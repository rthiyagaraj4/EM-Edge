<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.io.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<html>
<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</head>
<form>
<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS="MESSAGE">
<p align="left">
<%
	request.setCharacterEncoding("UTF-8");
	String error=request.getParameter( "err_num" );
	String call_function = checkForNull(request.getParameter( "call_func" ));

	//out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
	

	String home_required_yn=request.getParameter("home_required_yn");
	if(home_required_yn ==  null)home_required_yn="N";

	if ( error != null ) 
	{

		String queryString = (String) session.getValue( "queryString" ) ;
		if ( queryString == null ) queryString = "" ;


		if(!(call_function!=null && call_function.equalsIgnoreCase("OT")))
		{	
			InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( error.getBytes()), "UTF-8" ) ;
			error = (new BufferedReader(reader)).readLine() ;
		}
		
		if ( error == null ) error = "" ;
		
		out.println( error ) ;
		

		if(call_function!=null && !call_function.equalsIgnoreCase("IP_Booking"))
		{
			
			out.println( "<script language='JavaScript'>parent.commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?"+queryString+"&home_required_yn="+home_required_yn+"';</script>" ) ;

			//out.println("<script>alert('after toolbar')</script>");
		}

		

		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;

		if ( error_value.equals( "1" ) )
			{
				out.println( "<script language='JavaScript'>parent.onSuccess();</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>" ) ;
			}
		
		}

%>
</p>
</BODY>
</form>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

