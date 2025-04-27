<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@page import="org.jaxen.util.FollowingAxisIterator"%>
<%@page import="eCommon.XSSRequestWrapper,eBL.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String queryStrng=request.getQueryString();
	String patientid=request.getParameter("patientid");
	String pkgIdx=request.getParameter("pkgIdx");//10882183
	String title="wesrdtfygunkludco78yi ";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel='StyleSheet' href='../../eCommon/html/IeStyle_new.css' type='text/css'/>
    <script language='javascript' src='../../eBL/js/BLModifyFinancialDetails.js'></script>
      <script language='javascript' src='../../eCommon/js/jquery.js'></script>
  
    <script>

    
   </script>
</head>
<body>
 <div class="lookupContainer" >
    <div id="headerDiv" class="lookup-headercontainer col-34" style="background-color: #00A0DD;">
			<div class="lookup-title"><fmt:message key="eBL.BLNG_CLASS_ELIG_PKG.label" bundle="${bl_labels}" /></div>
			<input type="Button" class="icon-button" value="X" onclick="closeAuthPopup()" >
		</div>
	<br>
	<br>
	<div>
		<div class="form-group col-xs-3 col-sm-4">
			<input type="radio" name="reqFrom" id="patReq" value='P'  onclick="selectRecs(this)"/>
			<label class="label-radio">Patient Request &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> 
		</div>
		
		<div class="form-group col-xs-3 col-sm-4">
			<input type="radio" name="reqFrom" id="hospReq" value='H'  onclick="selectRecs(this)"/>
			<label class="label-radio ">Hospital Request &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		</div>
	</div>
	<br>
	<br>
	<div class="button_container" align="center">
        <input type="button" class="btn btn-primary" value="OK" onclick="validateReqSelected()">
    </div>
    <br>
 </div>
 	<input type='hidden' id='queryStrng' value='<%=queryStrng%>'> 
 	<input type='hidden' id='pkgIdx' value='<%=pkgIdx%>'>
 	<input type='hidden' id='storeVal' value=''>
 	
</body>
</html>