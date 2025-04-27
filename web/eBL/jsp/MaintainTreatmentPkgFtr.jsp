<!DOCTYPE html>
<!-- 
Sr No        Version           Incident             SCF/CRF             Developer Name
--------------------------------------------------------------------------------------
1            V210504            16777	      PMG2021-COMN-CRF-0076      Ram kumar S
 -->


<%@ page
	import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*,  "
	contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = 	(String)session.getAttribute("LOCALE");
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language='javascript' src='../../eBL/js/json2.js'></script>
	
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eBL/js/MaintainTreamentPackage.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MTP</title>
</head>

<body onKeyDown="lockKey();" onMouseDown="CodeArrest();"  onscroll='moveFrame()'>

<center>
<!-- <table width="100%" border="0" cellspacing="0" cellpadding="0" class="BorderLight">  
   <tr>
        <td >--><table width="100%" border="0" cellspacing="0" cellpadding="5">
          <tr>
            <td width="15%" >Package Service Details</td>
            <td  ><span class="txtgray">
              <input name="Package Description2" id="Package Description2" type="text" id="Package Description2" value="Consultation" size="50" />
              <input type="button" name="button6" id="button6" id="Replace Service" value="Replace Service" />
            </span></td>
            <td colspan="6" >&nbsp;</td>
            <td style="text-align:right" >
			<input type="submit" name="Delete" id="Delete" id="Delete" value="Delete" />
			<input type="submit" name="Add" id="Add" id="Add" value="Add" />
		  </td>
          </tr>
        </table><!--  </td>
      </tr>      
    </table>-->
    </center>
    </body>
    </html>

