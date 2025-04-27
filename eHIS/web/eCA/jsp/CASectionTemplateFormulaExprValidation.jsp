<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<BODY CLASS="MESSAGE" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

<p align="left">
<%
	String detail=request.getParameter("defContent")==null?"":request.getParameter("defContent");
	//out.println("<script>alert('from here"+detail+"')</script>");
	//detail=detail.replace('~',' ');
	String calledFrom=request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
	eCA.ExpressionParser parser = new eCA.ExpressionParser();
	if(!detail.equals(""))
	{
		if(parser.checkForValidity(detail.replace('~',' ')))
		{
			if(calledFrom.equals("OK"))
			{
			%>
				<script>
					alert(getMessage("EXP_VALID","CA"))	;	
					//top.opener.window.document.CASectionTemplateDetailForm.component_type.value="F";
					//top.opener.window.document.CASectionTemplateDetailForm.formula_definition.value="<%=detail%>";	
					window.returnValue="<%=detail%>";
					window.close();
				</script>
			<%
			}
			else if(calledFrom.equals("VALIDATE"))
			{
			%>
				<script>
					alert(getMessage("EXP_VALID","CA"))	;
					
				</script>
			<%

			}


		}
		else
		{
			%>
				<script>
					alert(getMessage("EXP_INVALID","CA"))	;
								
				</script>
			<%
		}

	}
	else
	{%>
		<script>
			alert(getMessage("EXP_VALID","CA"))	;		
			window.returnValue="";
			window.close();
		</script>
		
	<%}
	parser = null;
%>
</p>
</body>
</html>

