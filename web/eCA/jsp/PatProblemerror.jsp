<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../js/PatProblem.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<head>

<script language="JavaScript">

function onsuccess(called_from_ip) 
{
	if(called_from_ip == "Y"){
		
		var QueryString = parent.addModifyPatProblem.document.getElementById("QueryString").value;
		
		parent.PatProblemQueryResult.document.location.reload();
		parent.addModifyPatProblem.document.location.href="../../eCA/jsp/addModifyPatProblem.jsp?"+QueryString +"&QueryString=" + escape(QueryString) ;
	}

	
	else{
		
		
		var aut='';
		var authorizeButton=top.content.workAreaFrame.PatProblemQueryTools.document.forms[0].authorizeButton.value;
		if (authorizeButton=='N') aut='';
		else  aut= top.content.workAreaFrame.PatProblemQueryTools.document.forms[0].authorize.value;

	
		var QueryString = top.content.workAreaFrame.addModifyPatProblem.document.getElementById("QueryString").value;
		//alert("QueryString"+QueryString)
		var sex = top.content.workAreaFrame.addModifyPatProblem.document.PatProblem_form.sex.value;
		
		var QueryString1 = top.content.workAreaFrame.PatProblemQueryTools.document.getElementById("QueryString1").value;
        //alert("QueryString1"+QueryString1)  
//		var a=QueryString1.indexOf("errorModify",0);
//		if (a!= -1) QueryString1=QueryString1.substring(0,a-1)

		var a=QueryString1.indexOf("QueryString",0);
		if (a!= -1) QueryString1=QueryString1.substring(0,a-1)

	//	alert("QueryString1"+QueryString1)  
		
		top.content.workAreaFrame.PatProblemQueryResult.document.location.href="../../eCA/jsp/PatProblemQueryResult.jsp?"+QueryString1 +"&authorize="+aut+"&QueryString=" + escape(QueryString1)+"&Sex="+top.content.workAreaFrame.addModifyPatProblem.document.PatProblem_form.sex.value+"&Dob="+top.content.workAreaFrame.addModifyPatProblem.document.PatProblem_form.dob.value ;
		
		top.content.workAreaFrame.addModifyPatProblem.document.location.href="../../eCA/jsp/addModifyPatProblem.jsp?"+QueryString1 +"&authorize="+aut+"&QueryString=" + escape(QueryString1)+"&Sex="+top.content.workAreaFrame.addModifyPatProblem.document.PatProblem_form.sex.value+"&Dob="+top.content.workAreaFrame.addModifyPatProblem.document.PatProblem_form.dob.value ;
		top.content.workAreaFrame.PatProblemQueryTools.document.location.href="../../eCA/jsp/PatProblemQueryTools.jsp?"+QueryString1+"&authorize="+aut+"&QueryString=" + escape(QueryString1)+"&Sex="+top.content.workAreaFrame.addModifyPatProblem.document.PatProblem_form.sex.value+"&Dob="+top.content.workAreaFrame.addModifyPatProblem.document.PatProblem_form.dob.value  ;
	}
}


</script>

</head>

<BODY CLASS="MESSAGE" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<p align="left">
<%
    //out.println("<script>alert('paterror')</script>");
	String error=request.getParameter( "err_num" )==null?"":request.getParameter( "err_num" );
	String queryString = "";
   
	queryString = (String)session.getValue("queryString");
	
	if(queryString==null)
    {
		queryString=request.getQueryString();
		
	}

	if(error != null){
	out.println( error ) ;
		

		if ( queryString == null ) queryString = "" ;
		String called_from_ip = request.getParameter( "called_from_ip" )==null ? "" : request.getParameter( "called_from_ip" ) ;
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		if ( error_value.equals( "1" ) )
			out.println( "<script language='JavaScript'>onsuccess('"+called_from_ip+"');</script>" ) ;
	}
%>
</p>
</BODY>

