<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/05/2013		 IN030708	  Nijitha S			Bru-HIMS-CRF-221
29/05/2013		IN040304	  Karthi L			System is displaying the defined Symbols only once.
04/06/2013		IN040481	  Nijitha S			CRF-CA-Bru-HIMS-CRF-221/08-Record Clinical Notes->Symbols is not displayed completely
20/06/2013		IN041022			Nijitha S   CRF-CA-Bru-HIMS-CRF-221/11-System is not displaying error message 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya		Clinical Notes is not correct for some of the Symbols which are loaded. 
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
-----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page
	import="java.sql.*,java.util.*,webbeans.eCommon.*, eCA.* ,eCommon.Common.*"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<% 
request.setCharacterEncoding("UTF-8");
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<head>
<title>Symbol Table</title>
</head>
<SCRIPT language="javascript" src="../../eCA/js/Symbols.js"></SCRIPT>

<style type="text/css">
.columnHeading {
	font-family: verdana;
	font-size: 30px;
	color: navy;
	background-color: grey;
}

.gridData3 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	color: #000000;
	font-weight: normal;
	background-color: grey;
}

.grid1 {
	float: right;
	width: 20px;
	border-left: 1px;
	border-right: 1px;
	border-top: 1px;
	border-bottom: 1px;
	border-color: #666666;
	border-style: solid;
}

.borderhighlight {
	width: 20px;
	background-color: #FF9900;
	float: right;
	background-repeat: repeat-x;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 8pt;
	color: #000000;
	font-weight: normal;
	text-align: left;
	padding-right: 0px;
	vertical-align: top;
	border-left: 2px;
	border-right: 2px;
	border-top: 2px;
	border-bottom: 2px;
	border-color: grey;
	border-style: solid;
	margin: 0;
	border-collapse: collapse;
}

div.scroll {
	overflow-y: scroll;
	overflow-x: hidden;
}
</style>
<body>
	<form name='displaySymbol' id='displaySymbol'>
	<div class='scroll' style="height: 250px; width: 500px">
			<table class=grid cellspacing='0' style="width:500px">
		<%
	String note_type				=	request.getParameter("note_type"); 
	String note_group				=	request.getParameter("note_group"); 
	String symbol_grp =  request.getParameter("symbol_group") == null? "" : request.getParameter("symbol_group");
	String symbol_group_desc =  request.getParameter("symbol_group_desc") == null? "" : request.getParameter("symbol_group_desc");
	List symbolsList = null;
	int noOfSymbols =0;
	int symbol_grp_count=0;
	int totalRows=0;
	String symbol="";
	String curr_symbol_grp_desc="";
	int index=0;
	int indicator=0;
	String buttonHidden="type='button'";
	ResultSet resultSet =null;
	Connection con = null;
	try
	{
		PreparedStatement pst = null;
		con = ConnectionManager.getConnection(request);
		StringBuilder symbolsQuery = new StringBuilder();
	
		//symbolsQuery.append("select sym.symbol,symgrp.symbol_group_desc FROM ca_symbol sym, ca_symbol_group symgrp WHERE sym.symbol_group = symgrp.symbol_group AND SYMBOL_GRP_NOTE IN (?,?) AND sym.EFF_STATUS='E' AND  symgrp.EFF_STATUS='E' group BY symgrp.symbol_group_desc,sym.symbol, symgrp.symbol_group order by symgrp.symbol_group_desc asc"); //commented for IN040304
		symbolsQuery.append("select sym.symbol,symgrp.symbol_group_desc FROM ca_symbol sym, ca_symbol_group symgrp WHERE sym.symbol_group = symgrp.symbol_group AND SYMBOL_GRP_NOTE IN (?,?) AND sym.EFF_STATUS='E' AND  symgrp.EFF_STATUS='E' group BY symgrp.symbol_group_desc,sym.symbol, symgrp.symbol_group,sym.SYMBOL_ID order by symgrp.symbol_group_desc asc"); //modified for IN040304		
		pst = con.prepareStatement(symbolsQuery.toString()); 
		pst.setString(1,note_group);
		pst.setString(2,note_type);
		resultSet = pst.executeQuery();
	
		%>



				<%
					String firstSysbol ="";//IN041022
					while(resultSet.next())
					{
						symbol_group_desc = resultSet.getString("symbol_group_desc");
						if(!curr_symbol_grp_desc.trim().equalsIgnoreCase(symbol_group_desc.trim()))
						{
						   index=0;
							%>
				<tr>
					<td class='columnHeadercenter' colspan="10"><%=symbol_group_desc%></td>
				</tr>
				<%
						}
						curr_symbol_grp_desc =symbol_group_desc;								
						symbol = resultSet.getString("symbol");
						if(index==0 || index==10)
						{
							if(index==10)
							{
							index=0;//IN040481
							%>
				</tr>
				<%
						    }
							else
							{
							%>
				<tr height='10px'>
					<%
							}
						}
						if(!"".equals(symbol))
						{
						//IN041022 Starts
						if("".equals(firstSysbol))
						firstSysbol =symbol;
						//IN041022 Ends
						out.println("<td nowrap style='width:20px;' style = 'cursor:pointer;' id='symbol"+indicator+"' class='grid1'  onClick='javascript:storeSelectedSymbol(\""+symbol+"\",\""+indicator+"\")' ondblclick='javascript:insertSymOnDBLclk(\""+symbol+"\")' > ");
						//IN043895 Start.
						//out.println("<font style='float:right;font-weight:bold;'>");
							//IN049424 Start.
							//out.println("<font face='\"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\"' style='float:right;font-weight:bold;'>");
							out.println("<font style='float:right;font-weight:bold;'>");
							//IN049424 End.
						//IN043895 End.						
						out.println(symbol);
						out.println("</font>");
						out.println("</td>");
						index++;
						indicator++;
						}
					}
					if(indicator==0){
						out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
						buttonHidden="type='hidden'";
					}
					%>
					<input type='hidden' name='totalSymbols' id='totalSymbols' value='<%=indicator%>'>
					<!--IN041022 Starts-->
					<!--<input type='hidden' name='selectedSymbol' id='selectedSymbol' value=''>-->
					<input type='hidden' name='selectedSymbol' id='selectedSymbol' value='<%=firstSysbol%>'>
					<!--IN041022 Ends-->
					<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		resultSet.close();
		ConnectionManager.returnConnection(con,request);
	}		
	%>
				
			</table>
		</div>

		<table cellspacing='0' width="100%" height="10%">
			<tr>
				<td align='center'><input width="100%" height="10%"
					<%=buttonHidden%> value="Insert" onclick='insertSymbol();'  />
				</td>
			</tr>
		</table>
			<!--IN041022 Starts-->
			<SCRIPT LANGUAGE="JavaScript">

onLoadDefSymbol();</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<!--IN041022 Ends-->
</form>
</body>
</html>

