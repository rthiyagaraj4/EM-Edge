
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<head>
    <Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
    <Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script language="JavaScript">

</script>

</head>

<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>

<p align="left">
<%
                

    String error=request.getParameter( "err_num" );
    //String home_required_yn=request.getParameter("home_required_yn");
	
	String invoke_from			= request.getParameter("invoke_from") == null ? "" : request.getParameter("invoke_from");

	
    if ( error != null ) {
        String queryString = (String) session.getValue( "queryString" ) ;
        if ( queryString == null ) queryString = "" ;
		
        if ( error == null ) error = "" ;


%>
		<script language="JavaScript"> if(parent.commontoolbarFrame!=null){ 
	var qry_stg="<%=queryString%>";
	
	var error="<%=error%>";
	
	var invoke_from	= "<%=invoke_from%>";
	var qry_string1= qry_stg.lastIndexOf("&expand");
	var finalString;
	var expand;
	var url;
	var final_name=getLabel("Common.menu.label","Common");
	if(parent.commontoolbarFrame.document.forms[0])
	{
		if(parent.commontoolbarFrame.document.forms[0].home)
	{
		if(parent.commontoolbarFrame.document.forms[0].home.value !=null )
	{
	if(parent.commontoolbarFrame.document.forms[0].home.value ==final_name )
	{
		expand="0";
	}else
	{
		expand="1";
	}
	}
	}
	}
	else
	{
		expand="0";
	}
	if(qry_string1 !=-1)
	{
	 finalString=qry_stg.substring(0,qry_string1);
	url="commonToolbar.jsp?qry_stg="+finalString+"&expand="+expand;
	}else
	{
	url="commonToolbar.jsp?qry_stg="+qry_stg+"&expand="+expand;
	}
	if(error=="R")
	{
	
	parent.commontoolbarFrame.location.href=url;
	parent.reset();
	}
	else
	{
	parent.commontoolbarFrame.location.href=url;

		if(invoke_from=="EMER_REGN_NB"){
			setTimeout('parent.disableToolBarButtons()',100);
		}

	}
	
	
	 } </script>
<%
			
////changes ends.
		
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;

		
        if ( error_value.equals( "1" ) )
		{
            out.println( "<script language='JavaScript'>parent.onSuccess();"+
            "document.writeln(\""+error+"\")" +
            "</script>" ) ;
		}else if(error.equals("R"))
		{
			
		}
		else
		{
                out.println( error ) ;
		}
            
/*
            if(error.indexOf("APP-SM0001") !=-1 || error.indexOf("APP-SM0002") !=-1 ||  error.indexOf("APP-SM0003") !=-1) 
                out.println("<script>alert('"+error.substring(0,error.length()-4)+"')</script>");
*/

            
    }

%>
</p>
</BODY>

