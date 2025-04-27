<!DOCTYPE html>
<%@ page import="eBL.*,java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>





<HTML>
<head>
</head>
<STYLE>
		TD.MS{
		BACKGROUND-COLOR:navy;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}

		TD.AS{
		BACKGROUND-COLOR:#FFF791;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}

		TD.IS{
		BACKGROUND-COLOR:RED;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}

</STYLE>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<FORM>
			<table cellpadding=3 cellspacing=0  width="100%">
			<TR>
			<td width='5%'  class='label'>&nbsp;</td>
			<td class='PATIENTLINECOLOR' width='3%'></td>
					<td class='white' nowrap>
						<label nowrap style="font-size:9;font-weight:bold"><fmt:message key="eBL.CHARGE_FOR_MAIN_SERV.label" bundle="${bl_labels}"/></label>
					</td>

			<td class='NORMPATLINE' width='3%'></td>
			<td class='white' nowrap>
			<label nowrap style="font-size:9;font-weight:bold"><fmt:message key="eBL.CHARGE_FOR_ADDL_SERV.label" bundle="${bl_labels}"/></label>
			</td>

			<td class='IS' width='3%'></td>
			<td class='white' nowrap>
			<label nowrap style="font-size:9;font-weight:bold"><fmt:message key="eBL.INVALID_ADDL_SERV.label" bundle="${bl_labels}"/></label>
			</td>

			</TR>
			</TABLE>
	</FORM>
	</BODY>
</HTML>

