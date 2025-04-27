<%
/* 
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
11/09/2024	67020	    Gomathi Sivakumar		12/09/2024		Ramesh G		CA-MMS-DM-CRF-0260-US007/03-Section
14/10/2024	70699	    Gunasekar R		        15/09/2024    Ashwini Ragupathi		ML-MMOH-CRF-1759
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
        <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<script src='../../eCA/js/Section.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title></title>
	<Script>
	function onSuccess()
	{
		alert('here..');
	}
	</script>
	
	</head>
	<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">
	<form name="MultiResCat_form" id="MultiResCat_form" action="../../servlet/eCA.SectionServlet" method="post" target="messageFrame">
	<%
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs   = null;
		String sql_query = "", hist_rec_type = "", short_desc = "";
		String sec_hdg_code ="";

		sec_hdg_code=request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");


		try
		{

			con = ConnectionManager.getConnection(request);
	
	%>

	<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr><td class='columnheader' colspan=4><fmt:message key="Common.Add.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eCA.ResultCategory.label" bundle="${ca_labels}"/></td></tr>
	<tr>
	<td class=label width='50%'><fmt:message key="eCA.ResultCategory.label" bundle="${ca_labels}"/></td>
	<td class='fields' width='50%'>
	<select name="res_categ" id="res_categ" onchange='populateOrdType(this);' >
	<option value="">&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
	<% 
		
		sql_query="select hist_rec_type, short_desc from cr_hist_rec_type where hist_rec_type not in ('FDOC','NCIN','ALGY','FEVT','MEDN','NBDT','DIAG','CHIC','MHD') order by 2"; //Added not in CHIC against 67020 //Added MHD for ML-MMOH-CRF-1759
		//sql_query="SELECT  short_desc,order_category FROM or_order_category_lang_vw  WHERE language_id=? and order_category !='CS'  ORDER BY short_desc";
		stmt = con.prepareStatement(sql_query);
		//stmt.setString(1,locale);
		rs = stmt.executeQuery();

		while(rs.next())
		{
			hist_rec_type	= rs.getString("hist_rec_type");
			//hist_rec_type	= rs.getString("order_category");
			short_desc		= rs.getString("short_desc");
			if((hist_rec_type == null) || hist_rec_type.equals("null"))hist_rec_type="";
			if((short_desc == null) || short_desc.equals("null"))short_desc="";
			out.println("<option value='"+hist_rec_type+"'>"+short_desc+"</option>" );	
		}
		if(rs != null) rs.close();
		if(stmt != null)stmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception in SectionMultiResCatAddModify.jsp "+e);//COMMON-ICN-0181
			 e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
		
		if(con!=null)
			ConnectionManager.returnConnection(con, request);
		}
	
	
	
	%>
	</select>
	<img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	
	<tr id='compbxOrdType' style="display" >
	<td class='label' width='50%' id='ord_type_label' ><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/> </td><td class='field' width='50%'>
	<select name="ord_type_comp" id="ord_type_comp" onchange='clearOrdcatlog(this);' >
	<option value="">&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
	</select></td>
	</tr>

	<tr id='lookupOrdType' style="display:none"><td class='label' width='50%' id='ord_type_label1' ><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td><td class='field' width='50%'><input type="text" name="ord_type_desc" id="ord_type_desc" value=""  size='30' maxlength='30' onBlur="getOrdType1(this);" ><input type='button' name='ord_type_search' id='ord_type_search' value='?' class='button' onClick='getOrdType();'>
	</tr>
	
	<tr id='lookup' style="display">
	<td class='label' width='50%' id='ord_catlog_label' ><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/> </td><td class='field' width='50%'><input type="text" name="ord_catlog_desc" id="ord_catlog_desc" value=""  size='30' maxlength='30' onBlur="getOrdCatalogue1(this)" ><input type='button' name='ord_catalogue_search' id='ord_catalogue_search' value='?' class='button' onClick='getOrdCatalogue();'><input type='hidden' value='' name='ord_catlog' id='ord_catlog'></td> 
	</tr>
	<tr id='compList' style="display:none" >
	<td class='label' width='50%' id='ord_catlog_label1' ><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/> </td><td class='field' width='50%'>
	<select name="ord_catlog1" id="ord_catlog1" onchange='' >
	<option value="">&nbsp;&nbsp;&nbsp;----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----&nbsp;&nbsp;&nbsp;</option>
	<option value="A"><fmt:message key="Common.admission.label" bundle="${common_labels}"/> </option>
	<option value="D"><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></option>
	<option value="I"><fmt:message key="Common.Intermediate.label" bundle="${common_labels}"/> </option>
	</select>
	</tr>
	<tr><td class='label' width='50%'></td>
	<td  width='25%' align='right'><input type="button" class='Button' name="searchresult_button" id="searchresult_button" title='Search Result' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>' onClick="this.disabled=true;recOrdMultiRes();"><input type="button" class='Button' name="return_form" id="return_form" title='Return' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Return.label","common_labels")%>' onClick='cancelMultiRes()'>
	<input type="button" class='Button' name="clear_form" id="clear_form" title='Clear Criteria' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearpage()'></td>
	</tr>

	</table>
	<input type='hidden' value='' name='ord_type' id='ord_type'></td>
	<input type=hidden value='<%=sec_hdg_code%>' name='sec_hdg_code'>
	<input type=hidden value='<%=locale%>' name='locale'>
	<input type=hidden value='' name='mode' id='mode'>
	</form>
</body>

</html>

