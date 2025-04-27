<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/MTP.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection	con			=	null;
	PreparedStatement pstmt	=	null;
	ResultSet rs			=	null;

	String strGyPatSeries	=	"";
	String strQuery			=	"";

	strQuery	=	"SELECT PAT_SER_GRP_CODE FROM CR_CLIN_EVENT_PARAM ";	

	try
	{
		con			=	ConnectionManager.getConnection(request);

		pstmt		=	con.prepareStatement(strQuery);
		rs			=	pstmt.executeQuery();

		if( rs != null && rs.next() )
		{
			strGyPatSeries	=	 rs.getString(1);

			if(strGyPatSeries == null)
				strGyPatSeries = "";

			if(strGyPatSeries.equals("") )
			{
				%>
					<script>
						var msg = getMessage("TGT_PAT_SERIES_NOT_CONFIG","CA");
						parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
					</script>
				<%
			}

		}
	}
	catch (Exception e26)
	{		
		e26.printStackTrace();
	}
	finally
	{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
<body>
<form name='MTPAddModifyForm' id='MTPAddModifyForm'>
<table border=0 cellspacing=0 cellpadding=0 width='100%' align=center>
<tr id='trcoll'>
	<th align='left' colspan='6'><fmt:message key="Common.source.label" bundle="${common_labels}"/> <fmt:message key="Common.encounter.label" bundle="${common_labels}"/></th>					
</tr>

<tr>
<td class=label align=right><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
<td align="left" colspan="2">&nbsp;<input type='text' name='src_pat_id' id='src_pat_id' size='20' readonly><input type='button' name='src_pat_search' id='src_pat_search' value='?' class='button' onClick='getPatient(this);' >
  <img src='../../eCommon/images/mandatory.gif'></img>
</td>
<td class=label align=right><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;</td>
<td align="left" colspan="2"><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' id ='encounter_id'readonly onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);"><input type="button" name='enc_id_search' id='enc_id_search' value="?" class="button" onclick="callSearchScreen('E',this);">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
</td>
</tr>
<br>
<tr style ="FONT-FAMILY:Verdana;font-size: 14pt; font-weight: bold;	text-align:CENTER;COLOR: YELLOW;">
	<td class=label align=right>&nbsp;</td>
	<td class=label align=left id ='srcpatinfo' colspan ='5'></td>
</tr>
<tr id='trcoll'>
	<th align='left' colspan='6'><fmt:message key="eCA.Target.label" bundle="${ca_labels}"/> <fmt:message key="Common.encounter.label" bundle="${common_labels}"/>					
</tr>

<tr>
<td class=label align=right><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
<td align="left" colspan="2">&nbsp;<input type='text' name='tgt_pat_id' id='tgt_pat_id' size='20' readonly><input type='button' name='tgt_pat_search' id='tgt_pat_search' value='?' class='button' onClick='getPatient(this);' >
  <img src='../../eCommon/images/mandatory.gif'></img>
</td>
<td class=label align=right><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;</td>
<td align="left" colspan="2"><input type='text'  size='12'  maxlength='12' name='tgt_encounter_id' id='tgt_encounter_id' readonly onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);"><input type="button" name='tgt_enc_id_search' id='tgt_enc_id_search' value="?" class="button" onclick="callSearchScreen('E',this);">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
</td>
</tr>
<tr  style ="FONT-FAMILY:Verdana;font-size: 14pt; font-weight: bold;	text-align:CENTER;COLOR: YELLOW;">
	<td class=label align=right>&nbsp;</td>
	<td class=label align=left id ='tgtpatinfo' colspan ='5'></td>
</tr>
</table>
<table border=0 cellspacing=0 cellpadding=0 width='90%' align=center>
<tr>
	<td align = 'right' colspan ='3'><input type = 'button' class = 'button' name ='search' value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick = 'fetchRecs()' disabled></td>
</tr>
</table>
<input type = 'hidden' name ='gypatseries' value = '<%=strGyPatSeries%>'>
</form>
</body>
</html>

