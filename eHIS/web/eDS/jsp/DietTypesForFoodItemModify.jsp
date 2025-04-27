<!DOCTYPE html>
<!-- Newly Created for KDAH-CRF-0359.1-->
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
	<%	
	 String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
					.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
					.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
		if (sStyle == null)
			sStyle = "IeStyle.css";
	Connection conn= null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String sql_diettype = "";
	String Existingcode=request.getParameter("ExistingItemcode");
	sql_diettype="select distinct diet_type, ds_get_desc.ds_diet_type(diet_type,'en', '2') diet_type_desc from ds_menu where MENU_CODE IN (select MENU_CODE from ds_menu_item where ITEM_CODE = '"+Existingcode+"') AND diet_type IS NOT NULL order by diet_type";	
	String diettype=(String)request.getParameter("diettype");		
	//String fetchedDietTypes="";
	StringBuffer fetchedDietTypes=new StringBuffer();
	int maxRecord=0;
		
		try
		{
		    conn = ConnectionManager.getConnection(request);
			pstmt = conn.prepareStatement(sql_diettype,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE) ;
			rst	= pstmt.executeQuery();			
			int l=0;
			//getting maximum record
	    	rst.last();	maxRecord = rst.getRow();		
			//again move the resultset pointer to initial position
			rst.beforeFirst();		
		  while(rst != null && rst.next())
		   {
			l++;
			//fetchedDietTypes+=rst.getString(1)+",";
			fetchedDietTypes.append(rst.getString(1)).append(",");

			if(l == maxRecord){
			//fetchedDietTypes+=rst.getString(2);
			fetchedDietTypes.append(rst.getString(2));

			}else{
			//fetchedDietTypes+=rst.getString(2)+",";
			fetchedDietTypes.append(rst.getString(2)).append(",");
			}

		   }
	System.err.println("fetchedDietTypes==>>"+fetchedDietTypes.toString());
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type="text/javascript" src="../../eDS/js/FooditemModify.js"></script>
	<title>DietTypes</title>
	<style type="text/css">
	@import url(../../eDS/css/css2/themes/winxp/skin.css);
	</style>
	<script type="text/javascript" src="../../eDS/js/navbar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
	<form name="" id="" action="" target="messageFrame">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<tr id="contentsForAssignDietType" style="display:inline;">			
					<td align="center">	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<% if(diettype.equals("")){%>
						<span class="label">Select All</span>
						<input type="checkbox" onclick="getdietTypeSelectAll(this,<%=maxRecord%>)" name="dietTypeSelectAll" id="dietTypeSelectAll" ></input>
					<% }%>
					<div id="listContentLayer" style="display:block;visibility:visible;overflow-y: scroll;height:136;width:245;border: 1px outset #9999FF" align="center">
						<TABLE width="100%" id="AbleM" CELLSPACING="0" cellpadding="0">							
						</TABLE>
					</div>
					</td>
			   </tr>
			<tr>
				<td colspan="4" align="center">
					<% if(diettype.equals("")){%>
						<input type="button" name="Close" id="Close" value="<fmt:message key='Common.ok.label' bundle='${common_labels}'/>" onClick="getDietTypesFoodItems()" class="Button">
					<%}%>
				</td>
			</tr>
	</table>
		
		<input type="hidden" name="fetchedDietTypes" id="fetchedDietTypes" value="<%=fetchedDietTypes.toString()%>" />
		<input type="hidden" name="diettype" id="diettype" value="<%=diettype%>" />
		<input type="hidden" name="Existingcode" id="Existingcode" value="<%=Existingcode%>" />
		<input type="hidden" name="dietmaxRecord" id="dietmaxRecord" value="<%=maxRecord%>" /><!--ICN-064175-->
		
	
	<%
	}
		catch(Exception e)
		  {
			e.printStackTrace();
		  }
		  finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(conn);
			}
			catch(Exception e){
				System.err.println("Exception in DietType Modify:"+e);
			}

		}
	%>
		<script>
			var fetchedDietTypes = document.getElementById("fetchedDietTypes").value;
	        	var diettype = document.getElementById("diettype").value;			
			getDietTypes(fetchedDietTypes,diettype);		
		</script>
	</form>
</body>
</html>

