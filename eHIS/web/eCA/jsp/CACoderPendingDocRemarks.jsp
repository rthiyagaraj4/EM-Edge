<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------

01/07/2020 	  IN073540		Chandrashekar										AAKH-CRF-0122.2
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*" contentType="text/html;charset=UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<title>
  Remarks
</title>
<script language='javascript' src='../js/CACoderFunciton.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eCA/js/CoderFunction.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</head>
<%
 String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
 String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

    String bean_id				= "CACoderFunction" ;
	String bean_name			= "eCA.CACoderFunction";
	CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ;
	System.err.println("patient_id="+patient_id+"encounter_id=="+encounter_id);
	String remarks =bean.getCoderRemarks(patient_id,encounter_id);
	System.err.println("remarks=="+remarks);
%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
  <form name="docRemarks" id="docRemarks" >
			<table cellpadding=3 cellspacing=0 border=0  width="100%" align="center" >

			<tr>
                
                <td  class="label"><textarea cols="78" rows="10" name="order_remarks"><%=remarks%></textarea></td>
                
            </tr>
			</table>

</body>
</form>
</html>

