<!DOCTYPE html>


<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eOT/jsp/StringUtil.jsp"%>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE");
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
 String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }


%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/ConsumablePack.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%
//cannonicalization of empty String
String empty = "".intern();
String source=checkForNull(request.getParameter("source"));
String package_code = checkForNull(request.getParameter("package_code"));
String mode=checkForNull(request.getParameter("update_mode_yn"));
String item_code1=checkForNull(request.getParameter("item_code1"));
String short_desc1=checkForNull(request.getParameter("short_desc1"));
mode = (("modify").equals(mode))?"U":"I";
String description =empty; 
String initial_count=empty;
String item_code=empty;
String short_desc=empty;
String reqd_qty=empty;
String sql=empty;
String sql_uom=empty;
String uom_code=empty;
String uom_desc=empty;
String uom=checkForNull(request.getParameter("uom"));

sql="SELECT A.ITEM_CODE, B.SHORT_DESC, A.REQD_QTY FROM OT_PACKAGE_DTL A, MM_ITEM_LANG_VW B WHERE A. ITEM_CODE= B.ITEM_CODE AND A.PACKAGE_CODE =? AND B.LANGUAGE_ID =? ORDER BY 3";
sql_uom="SELECT  NVL(GEN_UOM_CODE,PUR_UOM_CODE) UOM_CODE,A.SHORT_DESC FROM  AM_UOM_LANG_VW A,MM_ITEM B WHERE NVL(GEN_UOM_CODE,PUR_UOM_CODE) = A.UOM_CODE AND   ITEM_CODE = ? AND   A.LANGUAGE_ID = ?";
Connection con=null;
PreparedStatement stmt=null;
PreparedStatement stmt_uom=null;
ResultSet rs=null;
ResultSet rs_uom=null;

	try{
		
		con=ConnectionManager.getConnection(request);
		stmt=con.prepareStatement(sql);
		stmt.setString(1,package_code);
		stmt.setString(2,locale);
		rs=stmt.executeQuery();
		int index=0;
		while(rs.next()){
			index++;
			item_code=java.net.URLEncoder.encode(rs.getString(1),"UTF-8");
			short_desc=java.net.URLEncoder.encode(rs.getString(2),"UTF-8");	
			reqd_qty=java.net.URLEncoder.encode(rs.getString(3),"UTF-8");
		if(rs_uom!=null) rs_uom.close();
		if(stmt_uom!=null) stmt_uom.close();
		stmt_uom=con.prepareStatement(sql_uom);
		stmt_uom.setString(1,item_code);
		stmt_uom.setString(2,locale);
		rs_uom=stmt_uom.executeQuery();
		while(rs_uom.next()){
			uom_code=rs_uom.getString(1);
			uom=rs_uom.getString(2);//uom=uom_desc;
		}
			out.println("<script>loadDBRows('"+item_code+"','"+short_desc+"','"+reqd_qty+"','"+index+"','"+uom+"','L');</script>");
		}
		out.println("<script>refresh()</script>");

      if(mode=="I")
		{if(rs_uom!=null) rs_uom.close();
		if(stmt_uom!=null) stmt_uom.close();
		stmt_uom=con.prepareStatement(sql_uom);
		stmt_uom.setString(1,item_code1);
		stmt_uom.setString(2,locale);
		rs_uom=stmt_uom.executeQuery();
		while(rs_uom.next()){
			uom_code=rs_uom.getString(1);
			uom_desc=rs_uom.getString(2);	
		}
		}

%>

<form name="ConsumablePackRecordForm" id="ConsumablePackRecordForm"  onload='FocusFirstElement()'  action="" method="" target=""> 
<table border=0 cellspacing=0 cellpadding=0  width='100%'  align=center>
<tr>
	<td class=label  width=25%>
	   <fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>
	</td>
	<td  width=25%>
	     <input type="text" name="item_code" id="item_code" value="<%=item_code1%>" size=20 maxlength=20 readonly >
	     
	</td>
	<td class=label width=25%>
	     <fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td  width=25%>
      	<input type="text" name="short_description" id="short_description" value="<%=short_desc1%>"  size='15' maxlength='40'  onBlur="if(this.value!='')callItemCode();" ><input type="button" class="button" name="generic_search" id="generic_search" value="?"  onClick='callItemCode();'  ><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class=label width=25%>
	      <fmt:message key="eOT.NoofUnits.Label" bundle="${ot_labels}"/>
	</td>
	<td width=25%>
	    <input type="text" name="reqd_qty" id="reqd_qty" value=""  size=10 maxlength=40 onBlur="ChkNumber(this);"><img src='../../eCommon/images/mandatory.gif'></img>
		<input type="text" name="uom_desc" id="uom_desc" readonly  value="<%=uom_desc%>" class='label' tabindex='-1' style="background:transparent;border:0">
	</td>
	<td width=25%>
	   
	</td>
	<td width=25%>
	 <input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();'>
	 <input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  onClick='removeRow();'>
	</td>
	<input type='hidden' name='item_code1' id='item_code1' value="<%=item_code1%>" >
	<input type='hidden' name='short_desc1' id='short_desc1' value="<%=short_desc1%>">
  	
</tr>
</table>
<%}catch(Exception e){
		System.err.println("Error in Consumable PackRecord.jsp"+e);
	}finally{
		try{
			if(rs!=null) rs.close();
			if(rs_uom!=null) rs_uom.close();
			if(stmt!=null) stmt.close();
			if(stmt_uom!=null) stmt_uom.close();
			if(con!=null) 
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){e.printStackTrace();}
	}
	%>
	<!-- added by Yadav for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<!-- end -->
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='params' id='params' value='<%=request.getParameter("source")%>'>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='package_code' id='package_code' value="<%=package_code%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='uom' id='uom' value="<%=uom_desc%>">


</form>
</body>
</html>


