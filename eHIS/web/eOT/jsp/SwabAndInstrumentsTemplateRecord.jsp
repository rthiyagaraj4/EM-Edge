<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<% 
String source=checkForNull(request.getParameter("source"));
String status = checkForNull(request.getParameter("status"));
String mode = checkForNull(request.getParameter("update_mode_yn"));
String disable_all_flag = ( ("modify").equals(mode) && "D".equals(status))?"disabled":"";
%>
<%! 
	String encode(String data){	  
		String outDat = "";
		byte byteData[] = data.getBytes();
		for (int i=0; i<byteData.length; i++){
			outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
		}
		return(outDat);
   }
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String imgUrl="";
if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
	<script language='javascript' src='../../eOT/js/SwabAndInstrumentsTemplate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="SwabAndInstrumentsTemplateRecordForm" id="SwabAndInstrumentsTemplateRecordForm"  onload='FocusFirstElement()'  action="" method="" target=""> 
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>'>
<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center>
<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type="text" name="srl_no" id="srl_no" value="" size='3' maxlength='3' onblur='ChkNumber(this);' ><img src='../../eCommon/images/mandatory.gif'>
	</td>
	<td class=label>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="description" id="description" value=""  size='20' maxlength='30' onBlur="if(this.value!='')callSwabAndInstrumentsTemplatecode(item_code,description); else item_code.value='';"><input type="button" class="button" name="generic_search" id="generic_search" value="?"  onClick='callSwabAndInstrumentsTemplatecode(item_code,description);' <%=disable_all_flag%> ><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="item_code" id="item_code" value="" size='6' maxlength='6' readonly >
	</td>
	<td class=label>
		<fmt:message key="eOT.InitialCount.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="initial_count" id="initial_count" value=""  size=3 maxlength=3 onblur="ChkNumber(this);" >
	</td>
</tr>
<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
</tr>
<tr>
	<td></td>
	<td></td>
	<td></td>
   <td class=fields width='25%'>
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();'  <%=disable_all_flag%> >
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();'  <%=disable_all_flag%> >
	</td>
</tr>
</table>
<%if(!imgUrl.equals("")){ %>
	 <img src='<%=imgUrl%>' width='100%' height='15'/> 
<%
}
if (mode.equals("modify")){
mode="U";
}else{
mode="I";
}
String description ="",initial_count="",item_code="",srl_no="",sql=""; 
String template_id = checkForNull(request.getParameter("template_id"));


	sql="SELECT A.ITEM_CODE, B.DESCRIPTION, A.ITEM_SRL_NO, A.INITIAL_COUNT FROM OT_SWAB_INSTR_TMPL_DTL A, OT_SWAB_INSTR_ITEMS_LANG_VW B WHERE A. ITEM_CODE= B. ITEM_CODE AND A.TEMPLATE_ID =? AND B.LANGUAGE_ID = ? ORDER BY 3";
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
try
{
	con=ConnectionManager.getConnection(request);
	stmt=con.prepareStatement(sql);
	stmt.setString(1,template_id);
	stmt.setString(2,locale);
	rs=stmt.executeQuery();

	int index=0;
	if(rs !=null)
	{
	while(rs.next())
	{
		index++;
		item_code=rs.getString(1);
		description=java.net.URLEncoder.encode(rs.getString(2),"UTF-8");	
        srl_no=rs.getString(3);
		initial_count=checkForNull(rs.getString(4));
		out.println("<script>loadDBRows('"+item_code+"','"+description+"','"+srl_no+"','"+initial_count+"','"+index+"','L');</script>");
	}
	}
	out.println("<script>refresh()</script>");
}catch(Exception e)
{
	e.printStackTrace();
	//System.err.println("Error in SwabAndInstrumentsTemplate records.jsp"+e.getMessage());
}finally{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) 
		ConnectionManager.returnConnection(con,request);
}
%>
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='template_id' id='template_id' value="<%=template_id%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


