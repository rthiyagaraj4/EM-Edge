<!DOCTYPE html>
<%@page  language="java" import="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
		<script language='javascript' src='../js/CAExternalApplDtl.js'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script language=javascript>
	
function callfunction(order_category,order_type_code){
			

			var target=parent.frames[1].document.forms[0].order_catalog1;
			var retVal=  new String();
			var dialogTop	= "40";
			var dialogHeight= "10" ;
			var dialogWidth= "40" ;
			var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
			var arguments	= "" ;
			var search_desc	= "";
			var title=getLabel("Common.ordercatalog.label","Common");
			//var title="Order Catalog";
			var sql="select order_catalog_code code,short_desc description from or_order_catalog where  order_category = '"+order_category+"' and order_type_code    ='"+order_type_code+"' and eff_status='E' and upper(order_catalog_code) like upper(?)  and upper(short_desc) like upper(?)  ";
			var argArray = new Array();
			var namesArray = new Array();
			var valuesArray = new Array();
			var datatypesArray = new Array();
			argArray[0] = sql;
			argArray[1] = namesArray;
			argArray[2] = valuesArray;
			argArray[3] = datatypesArray;
			argArray[4] = "2,1";
			argArray[5] = target.value;
			argArray[6] = DESC_LINK;
			argArray[7] = DESC_CODE;

			if(parent.frames[1].document.forms[0].order_catalog.value!="ALL" && parent.frames[1].document.forms[0].order_catalog.value!=""){
				retArray = CommonLookup(title,argArray);
				
				if(retArray != null && retArray !=""){
						parent.frames[1].document.forms[0].order_catalog1.value = retArray[1];
						parent.frames[1].document.forms[0].order_catalog.value=retArray[0];
						parent.frames[1].document.forms[0].catalog_buttn.disabled=false;
					}else {
						parent.frames[1].document.forms[0].order_catalog1.value = "All";
						parent.frames[1].document.forms[0].order_catalog.value = "*ALL";
						parent.frames[1].document.forms[0].catalog_buttn.disabled=false;
			}
		}
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
}

</script>
</head>
<body onKeyDown="lockKey()">
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		
		String search_value=request.getParameter("search_value")==null?"":request.getParameter("search_value");	
		String order_category=request.getParameter("order_category")==null?"":request.getParameter("order_category");	
		String order_type_code=request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");	

		String order_catalog_code = "";
		String short_desc = "";
		String sql = "";
		int count=0;
		
		try
		{
			con=ConnectionManager.getConnection();
			if (!search_value.equals("")){
					search_value=search_value+"%";
				}
				
				//sql = "select ORDER_CATALOG_CODE ,SHORT_DESC from or_order_catalog where  ORDER_CATEGORY = '"+order_category+"' and ORDER_TYPE_CODE    ='"+order_type_code+"' and eff_status='E' and upper(SHORT_DESC) like upper(?) ";//common-icn-0180
				sql = "select ORDER_CATALOG_CODE ,SHORT_DESC from or_order_catalog where  ORDER_CATEGORY = '"+order_category+"' and ORDER_TYPE_CODE    ='"+order_type_code+"' and eff_status='E' and upper(SHORT_DESC) like upper(?) ";//common-icn-0180
				
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,order_category);//common-icn-0180
				pstmt.setString(2,order_type_code);//common-icn-0180
				//pstmt.setString(1,search_value);//common-icn-0180
				pstmt.setString(3,search_value);//common-icn-0180
				rset=pstmt.executeQuery();

				while(rset.next())
				{	
					   order_catalog_code=rset.getString("ORDER_CATALOG_CODE");
                       short_desc=rset.getString("SHORT_DESC");
					   count=count+1;
				}
		if (count==1)
		{ 
			out.println("<script>");
			out.println("parent.frames[1].document.forms[0].order_catalog1.value='"+short_desc+"'");
			out.println("parent.frames[1].document.forms[0].order_catalog.value='"+order_catalog_code+"'");
			out.println("parent.frames[2].location.href='../../eCommon/jsp/error.jsp' ");
			out.println("</script>");
		}

		if(count>1 || count==0){	%>

				<script language=javascript>
				parent.frames[1].document.forms[0].catalog_buttn.disabled=true;
				callfunction('<%=order_category%>','<%=order_type_code%>');
				</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



  <% 
		}
	}
	catch(Exception ex){
			//out.println("Exception in try of CAExternalApplDtlGetOrderCatalog.jsp"+ex.toString());//common-icn-0181
                        ex.printStackTrace();//COMMON-ICN-0181
	}
	finally
		{
			if (rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			if (con!=null) ConnectionManager.returnConnection(con,request);
		}
%>
</body>
</html>

