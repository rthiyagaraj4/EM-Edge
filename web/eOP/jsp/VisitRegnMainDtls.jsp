<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	      
<%
	request.setCharacterEncoding("UTF-8");
    String sStyle	=  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link> 
	  <script Language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<!-- 	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	        <title><fmt:message key="Common.VisitDetails.label" bundle="${common_labels}"/></title>
	</head>

	<body onKeyDown ='lockKey()'>
		<table width='100%' border=0 cellspacing=0 cellpadding=0>
			<tr>
				<th><fmt:message key="eOP.Checked-inAt.label" bundle="${op_labels}"/></th>
				<th align='left'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></th>
				<th align='left'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
				<th align='left'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
			</tr>

			<script>
				var mainArr = top.window.dialogArguments
				var chkedin_arr		= mainArr[0]
				var visittype_arr	= mainArr[1]
				var locn_arr		= mainArr[2]
				var pract_arr		= mainArr[3]
				var practitioner = "";
				var cname= "QRYEVENNOBORDER"

				document.writeln("<table width='100%' cellspacing='0' cellpadding='0' border='1'>");
				for(var i=0; i<visittype_arr.length; i++)
				{
					if(cname == "QRYEVENNOBORDER")	cname = "QRYODDNOBORDER"
					else	cname = "QRYEVENNOBORDER" ;

					document.writeln( "<tr>" ) ;
						document.writeln( "<td align='center' class="+cname+" width='31%'>"+chkedin_arr[i]	+"</td>" ) ;
						document.writeln( "<td align='left' class="+cname+" width='23%'>"+visittype_arr[i]+"</td>" ) ;
						document.writeln( "<td align='left' class="+cname+" width='19%'>"+locn_arr[i]		+"</td>" ) ;

						if(pract_arr[i] == "null")
							document.writeln( "<td align='left' class="+cname+" width='38%'>"+practitioner+"</td>" ) ;
						else
							document.writeln( "<td align='left' class="+cname+" width='38%'>"+pract_arr[i]+"</td>" ) ;
					document.writeln( "</tr>" ) ;
				}
				document.writeln("</table>");
			</script>
		</table>
	</body>
</html>

