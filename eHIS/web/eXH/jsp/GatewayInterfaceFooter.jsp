<!DOCTYPE html>
<HTML>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>

<HEAD> 
<% 
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/ViewEventsFooter.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
 
<form >

<table width="100%">
<th class='COLUMNHEADER'  align=left COLSPAN=7 >
Status($)
</th>
<tr>
<!-- Commented by Sethu for SIRIRAJ SCF-14742 on 11/08/2015
<!--
<td align=left class=label width="10%">
<img src='../../eXH/images/pink_square.jpg' width=30 height=15>New Gateway &nbsp;
</td>
-->
<td align=left class=label width="15%">
<img src='../../eXH/images/green_square.jpg' width=30 height=15> Active &nbsp;
</td>
<td align=left class=label width="15%">
<img src='../../eXH/images/Cyan-square.jpg' width=30 height=15> Completed&nbsp;
</td>
<!-- Commented by Sethu for SIRIRAJ SCF-14742 on 11/08/2015 -->
<!--
<td align=left class=label width="15%">
<img src='../../eXH/images/yello_square.jpg' width=30 height=15> Warming Up&nbsp;
</td>
-->
<td align=left class=label width="15%">
<img src='../../eXH/images/red_square.jpg' width=30 height=15 >Stopped &nbsp;
</td>
<td align=left class=label width="15%">
<img src='../../eXH/images/blue_square.jpg' width=30 height=15 >About to Stop &nbsp;
</td>
<!-- Commented by Sethu for SIRIRAJ SCF-14742 on 11/08/2015 -->
<!--
<td align=left class=label width="15%">
<img src='../../eXH/images/red_square.jpg' width=30 height=15 >Unknown 
</td>
-->
</tr>

<th class='COLUMNHEADER'  align=left COLSPAN=7>Communiction Status(#)</th>
<tr>
<td align=left class=label width="10%">
<img src='../../eXH/images/green_square.jpg' width=30 height=15>&nbsp;Connected &nbsp;
</td>
<td align=left class=label width="15%">
<img src='../../eXH/images/red_square.jpg' width=30 height=15 >&nbsp;Disconnected &nbsp;
</td>
<td align=left class=label width="15%">
<img src='../../eXH/images/Cyan-square.jpg' width=30 height=15>&nbsp; Completed&nbsp;
</td>
<td align=left class=label width="15%">
&nbsp;
</td>
<td align=left class=label width="15%">

</td>
<td align=left class=label width="15%">
 &nbsp;
</td>
<td align=left class=label width="15%">

</td>
</tr>
<tr><td class='COLUMNHEADER' COLSPAN=5></td></tr>
</table>

</form>
</body>
</html>

