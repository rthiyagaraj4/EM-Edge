<!DOCTYPE html>
<!-- <!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN"> -->
 <%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper" %>
<html>
<head>  
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String incdec = request.getParameter("inc_dec")==null?"":request.getParameter("inc_dec");
%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="JavaScript">
			function returnSlotValues(from)
			{
				var ret = '';
				if(from == 'O')
				{
					var n = parent.BlockApptAllocationDetailsFrame.document.forms[0].total_count.value;
					var sumtext = 0;
					var finalvals = '';
					for(var i=0;i<n;i++)
					{
						var a = eval("parent.BlockApptAllocationDetailsFrame.document.getElementById("block_slot_text")"+i+".value");
						sumtext+=eval(a);
							var b = eval("parent.BlockApptAllocationDetailsFrame.document.getElementById("block_slot")"+i+".value");
							b = b.replace('$',a);
							finalvals+=b+"#";
					}
					var totalslots = parent.BlockApptAllocationDetailsFrame.document.forms[0].slots_inc_dec.value;
					if(totalslots != sumtext)
					{
						
						alert('Total number of <%=incdec%> SLOTS must match SLOTS TO BE <%=incdec%>');
						ret = 'F';
					}
					else
					{
						ret = finalvals;
					}
				}
				else
					ret = '';
				
				parent.window.returnValue = ret ;
				if(ret != 'F')
					parent.window.close();
			}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"onKeyDown = 'lockKey()' >
	<hr>
	<table cellpadding=0 cellspacing=0 width="100%" border=0>
		<tr>
			<td align=center class=BODYCOLORFILLED>
				<b><font size=2>Sum of <%=incdec%> SLOTS and SLOTS TO BE <%=incdec%> must match</font>
			</td>
		</tr>
		<tr>
			<td align=right class=BODYCOLORFILLED>
				<input type="button" class=BUTTON value="   Ok   " onClick="returnSlotValues('O')">
				<input type="button" class=BUTTON value="Cancel" onClick="returnSlotValues('C')">
			</td>
		</tr>
	</table>
</body>
</html>

