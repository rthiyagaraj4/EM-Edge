<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.ArrayList,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>

<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<html>

<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOT/js/Slate.js"></script>
	
	<!--<script src="../../eOT/js/OTMessages.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
<style>

		TD.YW{
		BACKGROUND-COLOR:YELLOW;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}

	TD.GY{
		BACKGROUND-COLOR:GREY;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
	}

		TD.GR{
		BACKGROUND-COLOR:GREEN;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
			TD.DC{
		BACKGROUND-COLOR:DARKCYAN;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
			}
			TD.BL{
		BACKGROUND-COLOR:BLUE;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
			}
			
			TD.PK{
		BACKGROUND-COLOR:PINK;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
			}	

			TD.WH{
		BACKGROUND-COLOR:WHITE;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
			}

</style>


</head>
<body >
<form name="VerficationColorInd" id="VerficationColorInd">
<table cellpadding="3" cellspacing="0" width="100%" align="center" border="3">
<tr>	
<td class='YW' width='1%'></td>
<td class='white' nowrap>
<label nowrap style="font-size:9;font-weight:bold">Pending</label>
</td>

<td class='GY' width='1%'></td>
<td class='white' nowrap>
<label nowrap style="font-size:9;font-weight:bold">Rejected</label>
</td>

<td class='GR' width='1%'></td>
<td class='white' nowrap>
<label nowrap style="font-size:9;font-weight:bold">Approved</label>
</td>

<td class='DC' width='1%'></td>
<td class='white' nowrap>
<label nowrap style="font-size:9;font-weight:bold">Hold</label>
</td>

<td class='BL' width='1%'></td>
<td class='white' nowrap>
<label nowrap style="font-size:9;font-weight:bold">Sent</label>
</td>

<td class='PK' width='1%'></td>
<td class='pink' nowrap>
<label nowrap style="font-size:9;font-weight:bold">Clarification</label>
</td>


</tr>	

</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	</form>
</body>
</html>

