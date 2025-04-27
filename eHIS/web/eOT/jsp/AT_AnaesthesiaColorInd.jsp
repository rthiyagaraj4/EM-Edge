<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
		String outstanding="outstanding";
		String pre_oper="pre_oper";
		String intra_oper="intra_oper";
		String post_oper="post_oper";
		String finalised="finalised";
%>
	<style>
		TD.<%=outstanding%>{
		BACKGROUND-COLOR:#6666FF;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.<%=pre_oper%>{
		BACKGROUND-COLOR:#FF99FF;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.<%=intra_oper%>{
		BACKGROUND-COLOR:#CC0099;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.<%=post_oper%>{
		BACKGROUND-COLOR:#FFCC33;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}
		TD.<%=finalised%>{
		BACKGROUND-COLOR:#990099;
		FONT-SIZE: 8pt ;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #CC9966 0px solid;
		BORDER-LEFT: #CC9966 0px solid;
		BORDER-RIGHT: #CC9966 0px solid;
		BORDER-TOP: #CC9966 1px solid;
		}

	</style>

<form name="AnesthesiaColorInd" id="AnesthesiaColorInd">
	<br><br>
	<table cellpadding="3" cellspacing="0" width="100%" align="center" border="1">
		<tr>
			<td class='<%=outstanding%>' width='1%'nowrap></td>
			<td class="label" width="19%">
				<label style="font-size:9;font-weight:bold">
				<fmt:message key="Common.Outstanding.label" bundle="${common_labels}"/>     
				</label>
			</td>
			<td class='<%=pre_oper%>' width='1%'nowrap></td>
			<td class="label" width="19%">
				<label style="font-size:9;font-weight:bold">
				<fmt:message key="eOT.PreOperativeDetailsRecord.Label" bundle="${ot_labels}"/>
				</label>
			</td>
			<td class='<%=intra_oper%>' width='1%'nowrap></td>
			<td class="label" width="19%">
				<label style="font-size:9;font-weight:bold">
				<fmt:message key="eOT.IntraOperativeDetailsRecord.Label" bundle="${ot_labels}"/>
				</label>
			</td>
			<td class='<%=post_oper%>' width='1%'nowrap></td>
			<td class="label" width="19%">
				<label style="font-size:9;font-weight:bold">
				<fmt:message key="eOT.PostOperativeDetailsRecord.Label"  bundle="${ot_labels}"/>			
				</label>
			</td>
			<td class='<%=finalised%>' width='1%'nowrap></td>
			<td class="label" width="19%">
				<label nowrap style="font-size:9;font-weight:bold">
			 <fmt:message key="Common.Finalized.label" bundle="${common_labels}"/>
				</label>
			</td>
		</tr>
	</table>
</form>
</body>
</html>



