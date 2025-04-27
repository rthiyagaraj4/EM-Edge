<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%request.setCharacterEncoding("UTF-8"); %> 
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="DATAELEMENTCROSSREFSecond" id="DATAELEMENTCROSSREFSecond" method="POST" action='../../eXH/jsp/' >

<%	
	request.setCharacterEncoding("UTF-8");
   String event_code="";
   String strBeanName = XHEventControllerBean.strBeanName;

   Connection conn = null;
//Statement stmt=null;
//ResultSet rs=null;
try 
{
	conn = ConnectionManager.getConnection();
	XHEventControllerBean	xhBean = XHEventControllerBean.getBean(strBeanName,request,session);
	//xhBean.action(request,conn);
	String strData[][]= xhBean.getDatabaseData();
	//xhBean.action(request,conn);
	for (int j=0; j<strData.length;j++)
{
	 //System.out.println("strData[i][3]"+strData[j][3]);
    if((strData[j][3].toString().trim()).equals("Y"))
	{
        event_code=event_code+strData[j][1].toString().trim()+",";
	} 
%>



<%	
}

}
catch(Exception e1)
{
out.println("Error ings thana="+e1);
}
finally
{
	ConnectionManager.returnConnection(conn);
}
%>	
<input type='hidden' name='event_code' id='event_code' value='<%=event_code%>' >

<script>
window.returnValue=document.forms[0].event_code.value;

window.close();
</script>
</body>
</html>

