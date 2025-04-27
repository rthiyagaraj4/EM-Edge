<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<script>
			var arr = top.window.dialogArguments
		</script>
	</head>

	<body onKeyDown='lockKey();'>
		<table cellspacing='0' cellpadding='0' width='80%' align='center' border=1>
			<tr>
				<td class='COLUMNHEADER'><fmt:message key="eMP.Legend.label" bundle="${mp_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="eMP.oldvalues.label" bundle="${mp_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.NewValue.label" bundle="${common_labels}"/></td>
			</tr>
			<script>
				var cname="QRYEVENNOBORDER"
				for(var i=0;i<arr[0].length;i++)
				{
					if(cname == "QRYEVENNOBORDER")
						cname =  'QRYODDNOBORDER'
					else
						cname =	'QRYEVENNOBORDER'

					document.writeln("<tr>")

						var old_val=arr[0][i]
						var new_val =arr[1][i]
						var aln = "";

						if(arr[2][i] == "Gender")
						{
							if(old_val == "U")	old_val = "Unknown"
							else if(old_val == "M")	old_val = "Male"
							else if(old_val == "F")	old_val = "Female"

							if(new_val == "U")	new_val = "Unknown"
							else if(new_val == "M")	new_val = "Male"
							else if(new_val == "F")	new_val = "Female"
						}

						if(arr[3][i] != null)
							if(arr[3][i].name.indexOf("oth_lang") != -1)
							{
								if(cname == "QRYEVENNOBORDER")
									cname='QRYEVENOTHLANG'
								else
									cname='QRYODDOTHLANG'
								aln="align='right'"
							}
							if(old_val =="")old_val = "&nbsp;"
						if(new_val =="")new_val = "&nbsp;"

						document.writeln("<td  align='right' class="+cname+" STYLE='COLOR:Navy;'><b>"+arr[2][i]+"&nbsp;&nbsp;</b></td>")
						document.writeln("<td class="+cname+" "+aln+"><font name='tahoma' size=2>"+old_val+"</td>")
						document.writeln("<td class="+cname+" "+aln+"><font name='tahoma' size=2>"+new_val+"</td>")
					document.writeln("</tr>")

					if(cname == 'QRYEVENOTHLANG' )
						cname= "QRYEVENNOBORDER"
					else if(cname == 'QRYODDOTHLANG')
						cname='QRYODDNOBORDER'

				}
			 </script>
		</table>
	</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : 

inputString);
	}
%>

