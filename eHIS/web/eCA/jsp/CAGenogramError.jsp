<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
 
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCA/js/CAPatientGenogram.js'></script>

<BODY OnMouseDown="CodeArrest()" onKeyDown="lockKey()" CLASS="MESSAGE">
<FORM>
<p align="left">
<%
	String error=request.getParameter( "err_num" );
	if ( error != null ) 
	{
		out.println( error ) ;
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;

		if ( error_value.equals( "1" ) ){
			String direction_loc = request.getParameter( "direction_loc" )==null ? "" : request.getParameter( "direction_loc" ) ;
			if ( direction_loc.equals( "" ) ){
				out.println( "<script language='JavaScript'>onSuccess();</script>" ) ;
			}else if( direction_loc.equals( "EMOTIONAL" ) ){
				String direction_value = request.getParameter( "direction_value" )==null ? "" : request.getParameter( "direction_value" ) ;
				out.println( "<script language='JavaScript'>onSuccessEmotionalRelation('"+direction_value+"');</script>" ) ;
			}else if("MEDHISTORY".equals(direction_loc)){
				String direction_value = request.getParameter( "direction_value" )==null ? "" : request.getParameter( "direction_value" ) ;
				out.println( "<script language='JavaScript'>onSuccessMedHisRelation('"+direction_value+"');</script>" ) ;				
			}
		}
	}

%>
</p>
</FORM>
</BODY>

