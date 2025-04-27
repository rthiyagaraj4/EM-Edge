<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
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
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script src="../../eCommon/js/common.js" language="javascript"></script>
			<script src="../../eOT/js/setcomponents.js" language="javascript"></script>
			<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
			<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<script>
			function checkForSpecChars(event)
				{
					var strCheck = '0123456789';
					var whichCode = (window.Event) ? event.which : event.keyCode;
					key = String.fromCharCode(whichCode);  // Get key value from key code
					if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
					if( (event.keyCode >= 97) && (event.keyCode <= 122) )
					return (event.keyCode -= 32);
					return true ;
				}
//RUT-CRF-0091 by MuthuN
			var valueForImage = "";
			function fnChkForDblQuotes(event)
			{
				var strCheck = '"\'';
				var whichCode = (window.Event) ? event.which : event.keyCode;
				key = String.fromCharCode(whichCode);  
				if (strCheck.indexOf(key) != -1) return false;  
				return true ;
			}
		</script>
<!-- Added by MuthuN 28-8-12-->
	</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="SetComponentsRecordForm" id="SetComponentsRecordForm"  onload='FocusFirstElement()' > 
<%
String mode=request.getParameter("update_mode_yn");
mode = ("modify".equals(mode))?"U":"I";
//RUT-CRF-0091 by MuthuN
String st_location="";
String disable_flag="";
String customer_id="";
PreparedStatement pstmt_st=null;
ResultSet rst_st=null;
//RUT-CRF-0091 by MuthuN
String item_desc =""; 
String item_code="";
String item_qty="";
String instr_code = checkForNull(request.getParameter("instr_code"));
String sql="";
sql="SELECT A.ITEM_CODE, B.ITEM_DESC, A.ITEM_QTY,B.LOCATION FROM OT_INSTRUMENT_COMPONENTS A, OT_SS_COMPONENTS B WHERE A.INSTR_CODE = ? AND A.ITEM_CODE=B.ITEM_CODE ORDER BY 1";
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
try
{
	con=ConnectionManager.getConnection(request);
	stmt=con.prepareStatement(sql);
	stmt.setString(1,instr_code);
	rs=stmt.executeQuery();
	int index=0;
	while(rs.next()){
		index++;
		item_code=rs.getString(1);
        item_desc=encode(rs.getString(2));
		item_qty=checkForNull(rs.getString(3));	
		st_location=checkForNull(rs.getString(4));//RUT-CRF-0091 by MuthuN
	 	out.println("<script> loadDBRows('"+item_code+"','"+item_desc+"','"+item_qty+"','"+st_location+"','"+index+"','L');</script>");
	}
	out.println("<script>refresh()</script>");
}catch(Exception e)
{
	e.printStackTrace();
	//System.err.println("Error in Set Components records.jsp"+e.getMessage());
}finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) 
		ConnectionManager.returnConnection(con,request);
	}catch(Exception e){e.printStackTrace();}
}
//Added by muthuN for RUT-CRF-0091 on 05-02-2013
	try
		{		
			con=ConnectionManager.getConnection(request);
			pstmt_st = con.prepareStatement("select CUSTOMER_ID from sm_site_param");				
			rst_st = pstmt_st.executeQuery();	
			if ( rst_st.next() && rst_st != null )
			{
				customer_id  =  rst_st.getString(1);
				System.err.println("customer_id   "+customer_id);
			}
			}
			catch(Exception e)
			{   e.printStackTrace();
				//System.out.println("4="+e.toString());
			}
			finally 
			{
				if (rst_st != null)   rst_st.close();
				if (pstmt_st != null) pstmt_st.close();
				if(con!=null) ConnectionManager.returnConnection(con,request); 
			}
//Added by muthuN for RUT-CRF-0091 on 05-02-2013
%>

<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center>
<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields">
		<input type="text" name="description" id="description" value=""  size='20' maxlength='20' onBlur="if(this.value!='')callItemCode(item_code,description);else item_code.value='';clearDesc();"><input type="button" class="button" name="generic_search" id="generic_search" value="?"  onClick="callItemCode(item_code,description);" ><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class=label width='25%'>
		<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields">
		<input type="text" name="item_code" id="item_code" value="" size='15' maxlength='15' readonly>

	</td>
</tr>


<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields">
		<input type="text" name="qty" id="qty" value="" size='1' maxlength='2' onkeypress='return checkForSpecChars(event)' onblur='checkQuantity();'>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<!--Added by MuthuN against RUT-CRF-0091 on 17-April-2013 starts here-->
<% if(customer_id.equalsIgnoreCase("RTN")){%>
<td class=label >
		<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<!--input type="text" name="st_location" value=""  onkeypress="return fnChkForDblQuotes(event);" size='15' maxlength='15' <%=disable_flag%>-->
		<input type="text" name="st_location" id="st_location" value=""  onkeypress="return fnChkForDblQuotes(event);" size='15' maxlength='15' readonly>
	</td>
<%}%>
<!--Added by MuthuN against RUT-CRF-0091 ends here-->
</tr>

<tr>
	<td></td>
	<td></td>
</tr>
<tr>

   <td colspan='3'></td>
   <td class='fields' width='25%'>
		
	<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();'>
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' ></td>
</tr>
</table>
<!-- added by Yadav for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<!-- end -->
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='params' id='params' value='<%=request.getParameter("source")%>'>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='instr_code' id='instr_code' value="<%=instr_code%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='customer_id' id='customer_id' value="<%=customer_id%>">
</form>
</body>
</html>


