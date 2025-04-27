<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
       
<html>
<head>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../js/ClinicalRepMast.js' language='javascript'></script>
   
 <%
request.setCharacterEncoding("UTF-8");	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
             
<body class ='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="ClinicalRepMastSubTabform" id="ClinicalRepMastSubTabform">
<table border='0' cellpadding='3' cellspacing='0' class='' id="tab" width="100%" align='center'>
<tr>

 <!-- <td class='CAFIFTHLEVELCOLOR'  align="center" style='cursor:pointer;' onclick="callLevelThree()" width='10%' id="individual">Individual</td> -->

 <td class='CAHIGHERLEVELCOLOR' align='center' style='cursor:pointer;' width='10%' id="batch"> Batch</td>

 </tr>
 </table>
                            
 </form>

