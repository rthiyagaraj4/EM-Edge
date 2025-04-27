<!DOCTYPE html>
<%@page isErrorPage="true"%>
<HTML>

 <BODY >

 <TABLE width="100%" border="0" >
 <Th style="background-color:LIGHTBLUE;">Error On Page</Th>
 <TR>
	
	<td align="center">While loading the page some error has been occurred</td>
 </TR>
 <TR>
	<TD align="center" style="color:red">Error:&nbsp;<%=exception.toString()%></TD>
 </TR>
 <TR>
	<TD align="center" ><a href="javascript:document.location.href='../../eCommon/jsp/CommonClearObjects.jsp';" >Back</a></TD>
 </TR>
 </TABLE>
  
 </BODY>
</HTML>
