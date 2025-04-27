<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="BatchBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
	request.setCharacterEncoding("UTF-8");	
	Connection con=null;

StringBuffer sql = new StringBuffer();
String hist_rec_type	=	"";

int cnt=0;

try
{
	PreparedStatement stmt=null;
	ResultSet rs=null;
	con=ConnectionManager.getConnection(request);
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
BatchBean.clearAll();
// added by Archana @08-12-08 
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
//end
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
 <script src='../../eCA/js/ClinicalRepMast.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<form name='ClinicalRepMastBatchEventMain_form' id='ClinicalRepMastBatchEventMain_form'  method='post' target='messageFrame'        >
<body  class='CONTENT' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()"  >

<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>

<tr>
	<td class=label><fmt:message key="Common.HistoryType.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name='hist_rec_type' id='hist_rec_type' onChange='contrsystempop2()' >
		<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>	
	<%
	    sql = new StringBuffer();	
		sql.append("select HIST_REC_TYPE,LONG_DESC from  cr_hist_rec_type where hist_rec_type in ('BLTF','CLNT','FDOC','LBIN','PTCR','RDIN','SUNT','TRET') order by 1 ");

		stmt = con.prepareStatement(sql.toString());
		rs = stmt.executeQuery();

		while(rs.next())
		{
			hist_rec_type = rs.getString("HIST_REC_TYPE");
			String long_desc = rs.getString("LONG_DESC");
			%>
			<option value='<%=hist_rec_type%>'><%=long_desc%></option>
		<%}
			
			//added new
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();

	%>
	</select><img src='../../eCommon/images/mandatory.gif'>
	</td>

	<td class=label><fmt:message key="eCA.ContrSystem.label" bundle="${ca_labels}"/></td>
		
		<td class='fields'><select name='contr_system' id='contr_system' onchange='setdataset()'>
		<option value="">-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</option>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
</tr>

<tr>
<td class=label><fmt:message key="eCA.DataSet.label" bundle="${ca_labels}"/></td> 
<td class='fields'><input type='radio' name='data_set' id='data_set' value='A' onClick=callLevelFour1() checked><fmt:message key="Common.all.label" bundle="${common_labels}"/>
<input type='radio' name='data_set' id='data_set' value='S' onClick=callLevelFour1()><fmt:message key="Common.Selected.label" bundle="${common_labels}"/>
	<img src='../../eCommon/images/mandatory.gif'> </td>
 <td colspan=2></td>
</tr>

</table>
<!-- added by Archana @08-12-08 -->

			<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>

				<!-- end -->
<input type=hidden name=hist_rec_type1 value="<%=hist_rec_type%>">
<input type=hidden name=add_source1 value="">
	<input type='hidden' name='mode' id='mode' value='insert'>
	<input type='hidden' name='countOfRows' id='countOfRows' value='<%=cnt%>'>
</form>

</body>
</html>
<%
	
}
catch(Exception e)
{
	//out.println("From ClinicalRepMastMainEvent.jsp" + e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>

