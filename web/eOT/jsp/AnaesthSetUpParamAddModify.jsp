<!DOCTYPE html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOT/js/AnaesthesiaSetUpParameters.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form name="AnaesthSetUpParameterForm" id="AnaesthSetUpParameterForm"  onload='FocusFirstElement()'  action="../../servlet/eOT.AneasthSetUpParameterServlet" method="post" target="messageFrame"> 
<%

Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");

String disable_flag="";
String pre_anes_note_type		="";
String pre_anes_note_type_desc	="";
String intra_anes_note_type		="";
String intra_anes_note_type_desc="";
String post_anes_note_type		="";
String post_anes_note_type_desc	="";
String intra_anaesthesia_chart_id="";
String intra_anaesthesia_chart_id_desc="";
String post_anaesthesia_chart_id="";
String post_anaesthesia_chart_id_desc="";

String sql="";
int total_records=0;
		con=ConnectionManager.getConnection(request);	//Added Against Common-ICN-0031
	try{
		//con=ConnectionManager.getConnection(request);	//Commented Against Common-ICN-0031
		sql=" Select count(*) as total_records_existing from AT_PARAM";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
	    rs.next();
		
		total_records=rs.getInt(1);
		
}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			//ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}

		if(total_records==1)
		{
		   mode="modify";
		   disable_flag="disabled";
		}
		else
		{
		   mode="insert";
		   disable_flag="";
		}

		if(mode.equals("modify"))
{

	try{
		//con=ConnectionManager.getConnection(request);
		//sql="Select A.PRE_ANES_NOTE_TYPE, B.NOTE_TYPE_DESC PRE_ANES_NOTE_TYPE_DESC, A.INTRA_ANES_NOTE_TYPE, C.NOTE_TYPE_DESC INTRA_ANES_NOTE_TYPE_DESC, A.POST_ANES_NOTE_TYPE, D.NOTE_TYPE_DESC POST_ANES_NOTE_TYPE_DESC, A.INTRA_ANAESTHESIA_CHART_ID, E.SHORT_DESC INTRA_ANA_CHART_ID_DESC, A.POST_ANAESTHESIA_CHART_ID, F.SHORT_DESC POST_ANAESTHESIA_CHART_ID_DESC from AT_PARAM A  , CA_NOTE_TYPE B, CA_NOTE_TYPE C, CA_NOTE_TYPE D, CA_CHART_LANG_VW E, CA_CHART_LANG_VW F  WHERE A.PRE_ANES_NOTE_TYPE = B.NOTE_TYPE(+) AND A.INTRA_ANES_NOTE_TYPE = C.NOTE_TYPE(+)  AND A.POST_ANES_NOTE_TYPE = D.NOTE_TYPE(+)  AND  A.INTRA_ANAESTHESIA_CHART_ID = E.CHART_ID(+) AND  A.POST_ANAESTHESIA_CHART_ID = F.CHART_ID(+) AND E.LANGUAGE_ID=F.LANGUAGE_ID AND E.LANGUAGE_ID = '"+locale+"' ";

		sql="Select A.PRE_ANES_NOTE_TYPE, B.NOTE_TYPE_DESC PRE_ANES_NOTE_TYPE_DESC, A.INTRA_ANES_NOTE_TYPE, C.NOTE_TYPE_DESC INTRA_ANES_NOTE_TYPE_DESC, A.POST_ANES_NOTE_TYPE, D.NOTE_TYPE_DESC POST_ANES_NOTE_TYPE_DESC, A.INTRA_ANAESTHESIA_CHART_ID, E.SHORT_DESC INTRA_ANA_CHART_ID_DESC, A.POST_ANAESTHESIA_CHART_ID, F.SHORT_DESC POST_ANAESTHESIA_CHART_ID_DESC from AT_PARAM A  , CA_NOTE_TYPE_LANG_VW B, CA_NOTE_TYPE_LANG_VW C, CA_NOTE_TYPE_LANG_VW D, CA_CHART_LANG_VW E, CA_CHART_LANG_VW F  WHERE A.PRE_ANES_NOTE_TYPE = B.NOTE_TYPE(+) AND A.INTRA_ANES_NOTE_TYPE = C.NOTE_TYPE(+)  AND A.POST_ANES_NOTE_TYPE = D.NOTE_TYPE(+)  AND  A.INTRA_ANAESTHESIA_CHART_ID = E.CHART_ID(+) AND  A.POST_ANAESTHESIA_CHART_ID = F.CHART_ID(+) AND E.LANGUAGE_ID=F.LANGUAGE_ID AND D.LANGUAGE_ID=E.LANGUAGE_ID AND C.LANGUAGE_ID=E.LANGUAGE_ID AND B.LANGUAGE_ID=E.LANGUAGE_ID AND E.LANGUAGE_ID = ? ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		rs=stmt.executeQuery();

		if(rs!=null && rs.next())
		{
			pre_anes_note_type				=(rs.getString("PRE_ANES_NOTE_TYPE")==null?"":rs.getString("PRE_ANES_NOTE_TYPE"));
			pre_anes_note_type_desc			=(rs.getString("PRE_ANES_NOTE_TYPE_DESC")==null?"":rs.getString("PRE_ANES_NOTE_TYPE_DESC"));
			intra_anes_note_type			=(rs.getString("INTRA_ANES_NOTE_TYPE")==null?"":rs.getString("INTRA_ANES_NOTE_TYPE"));	
			intra_anes_note_type_desc		=(rs.getString("INTRA_ANES_NOTE_TYPE_DESC")==null?"":rs.getString("INTRA_ANES_NOTE_TYPE_DESC"));
			post_anes_note_type				=(rs.getString("POST_ANES_NOTE_TYPE")==null?"":rs.getString("POST_ANES_NOTE_TYPE"));
			post_anes_note_type_desc		=(rs.getString("POST_ANES_NOTE_TYPE_DESC")==null?"":rs.getString("POST_ANES_NOTE_TYPE_DESC")); 
			intra_anaesthesia_chart_id		=(rs.getString("INTRA_ANAESTHESIA_CHART_ID")==null?"":rs.getString("INTRA_ANAESTHESIA_CHART_ID"));
			intra_anaesthesia_chart_id_desc	=(rs.getString("INTRA_ANA_CHART_ID_DESC")==null?"":rs.getString("INTRA_ANA_CHART_ID_DESC"));
			post_anaesthesia_chart_id		=(rs.getString("POST_ANAESTHESIA_CHART_ID")==null?"":rs.getString("POST_ANAESTHESIA_CHART_ID"));
			post_anaesthesia_chart_id_desc	=(rs.getString("POST_ANAESTHESIA_CHART_ID_DESC")==null?"":rs.getString("POST_ANAESTHESIA_CHART_ID_DESC"));
		}


}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		//out.println("sql=="+sql);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
}

%>
<br><br>
<table border=0 cellspacing=0 cellpadding=3  width='60%'  align=center>
<!-- <tr>
	<td width='42%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr> -->
   
<tr> 
	<td class="label" nowrap>
		<fmt:message key="eOT.PreAnaesthesiaNoteType.Label" bundle="${ot_labels}"/>
	</td>
	<td align="fields" nowrap>
		
		<input type='text' name='pre_anes_note_type_desc' id='pre_anes_note_type_desc' size='30' value="<%=pre_anes_note_type_desc%>" onBlur="if(this.value!='')searchNoteType(pre_anes_note_type,pre_anes_note_type_desc); else pre_anes_note_type.value=''" > 
		<input type='hidden' name="pre_anes_note_type" id="pre_anes_note_type"  value="<%=pre_anes_note_type%>"> 
		<input type='button' class='button' value='?' name='notetypelkp' id='notetypelkp' onClick="searchNoteType(pre_anes_note_type,pre_anes_note_type_desc);" >
	<img src='../../eCommon/images/mandatory.gif'>
	</td>			 
</tr> 

<tr> 
	<td class="label" nowrap>
		<fmt:message key="eOT.IntraAnaesthesiaNoteType.Label" bundle="${ot_labels}"/>
	</td>
	<td align="fields" nowrap>
		
		<input type='text' name='intra_anes_note_type_desc' id='intra_anes_note_type_desc' size='30' value="<%=intra_anes_note_type_desc%>" 
		onBlur="if(this.value!='')searchNoteType(intra_anes_note_type,intra_anes_note_type_desc); else intra_anes_note_type.value=''" > 
		<input type='hidden' name='intra_anes_note_type' id='intra_anes_note_type'  value="<%=intra_anes_note_type%>"> 
		<input type='button' class='button' value='?' name='notetypelkp' id='notetypelkp' onClick="searchNoteType(intra_anes_note_type,intra_anes_note_type_desc);" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>			 
</tr> 

<tr> 
	<td class="label" nowrap>
		<fmt:message key="eOT.PostAnaesthesiaNoteType.Label" bundle="${ot_labels}"/> 
	</td>
	<td align="fields" nowrap>
		
		<input type='text' name='post_anes_note_type_desc' id='post_anes_note_type_desc' size='30' value="<%=post_anes_note_type_desc%>" 
		onBlur="if(this.value!='')searchNoteType(post_anes_note_type,post_anes_note_type_desc); else post_anes_note_type.value=''"> 
		<input type='hidden' name='post_anes_note_type' id='post_anes_note_type'  value="<%=post_anes_note_type%>"> 
		<input type='button' class='button' value='?' name='notetypelkp' id='notetypelkp' onClick="searchNoteType(post_anes_note_type,post_anes_note_type_desc);" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>			 
</tr> 

<tr> 
	<td class="label" nowrap>
		<fmt:message key="eOT.IntraAnaesthesiaChartID.Label" bundle="${ot_labels}"/> 
	</td>
	<td align="fields" nowrap>
		
		<input type='text' name='intra_anaesthesia_chart_id_desc' id='intra_anaesthesia_chart_id_desc' size='30' value="<%=intra_anaesthesia_chart_id_desc%>" 
		onBlur="if(this.value!='')searchChartId(intra_anaesthesia_chart_id,intra_anaesthesia_chart_id_desc); else intra_anaesthesia_chart_id.value=''"> 
		<input type='hidden' name='intra_anaesthesia_chart_id' id='intra_anaesthesia_chart_id'  value="<%=intra_anaesthesia_chart_id%>"> 
		<input type='button' class='button' value='?' name='notetypelkp' id='notetypelkp' onClick="searchChartId(intra_anaesthesia_chart_id,intra_anaesthesia_chart_id_desc);" >
	    <img src='../../eCommon/images/mandatory.gif'>
	</td>			 
</tr>   

<tr> 
	<td class="label" nowrap>
		<fmt:message key="eOT.PostAnaesthesiaChartID.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields" nowrap>
		
		<input type='text' name='post_anaesthesia_chart_id_desc' id='post_anaesthesia_chart_id_desc' size='30' value="<%=post_anaesthesia_chart_id_desc%>" 
		onBlur="if(this.value!='')searchChartId(post_anaesthesia_chart_id,post_anaesthesia_chart_id_desc); else post_anaesthesia_chart_id.value=''"> 
		<input type='hidden' name='post_anaesthesia_chart_id' id='post_anaesthesia_chart_id'  value="<%=post_anaesthesia_chart_id%>"> 
		<input type='button' class='button' value='?' name='notetypelkp' id='notetypelkp' onClick="searchChartId(post_anaesthesia_chart_id,post_anaesthesia_chart_id_desc);" >
	    <img src='../../eCommon/images/mandatory.gif'>
	</td>			 
</tr>   

<!-- <tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr> -->
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name="tot_records" id="tot_records" value="<%=total_records %>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


