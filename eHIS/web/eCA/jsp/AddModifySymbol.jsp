<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
10/04/2013    IN30708        Karthi      To incorporate the "Symbol" function  from Microsoft words to the Microsoft Editor in the clinical notes.
28/05/2013    IN040319        Karthi	System is not responding		
29/05/2013	  IN040293		 Karthi		System is displaying special character along with symbol we defined
04/06/2013    IN040453      Nijitha S	CRF-CA-Bru-HIMS-CRF-221/07-Symbol->System is displaying special character in the 'Remarks' field
24/06/2013    IN041129		Chowminya G Enable checkbox default to yes
24/06/2013	  IN041144		Karthi L	When more characters are entered in Remarks filed of Symbol master , system displays exception message 	
---------------------------------------------------------------------------------------------------------------
--> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" %>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/CASymbol.js'></script>
		<Script src ="../../eCommon/js/CommonLookup.js" language ="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%

%>
	</head>

	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='Symbol' id='Symbol' action='../../servlet/eCA.CASymbolServlet' method='post' target='messageFrame'>
		<%	
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		Connection con = null;
		try{
			con = ConnectionManager.getConnection(request);
			String mode	   = request.getParameter( "mode" ) ;
			String enabled_checked = "";
			String rfiReadOnlyYN = "";
			
			PreparedStatement pstmt = null;	// added for IN040293 
			ResultSet resultSet = null;	// added for IN040293
			String sql = ""; // added for IN040293
			
			String symbol =  ""; // added for IN040293
			String symbol_id = request.getParameter("symbol_id") == null? "" : request.getParameter("symbol_id");
			 //String symbol = request.getParameter("symbol") == null? "" : request.getParameter("symbol"); // commented for IN040293
			String symbol_grp =  request.getParameter("symbol_group") == null? "" : request.getParameter("symbol_group");
			String symbol_group_desc =  request.getParameter("symbol_group_desc") == null? "" : request.getParameter("symbol_group_desc");
			//String remarks_text =  request.getParameter("remarks") == null? "" : request.getParameter("remarks");//IN040453
			String remarks_text =  "";//IN040453
			String eff_status = request.getParameter("eff_status") == null? "" : request.getParameter("eff_status");
			
			if("E".equals(eff_status))
				enabled_checked = "checked";
			else
				enabled_checked = "";
				
			if(mode.equals("2")) {
				rfiReadOnlyYN		= "ReadOnly";
				// added for IN040293
				try{
					//sql = "SELECT SYMBOL FROM ca_symbol WHERE SYMBOL_ID = ?" ;//IN040453
					sql = "SELECT SYMBOL,SYMBOL_REMARKS FROM ca_symbol WHERE SYMBOL_ID = ?" ;//IN040453
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, symbol_id.trim());
					resultSet	= pstmt.executeQuery() ;
					if(resultSet.next()){
						symbol = resultSet.getString("SYMBOL");
						remarks_text  = resultSet.getString("SYMBOL_REMARKS");//IN040453
					}
				}
				catch(Exception ex){
					ex.getMessage();
				}
			}
						
		%>	
		<br>
			<table border='0' cellpadding='0' cellspacing='0' align='center' width='55%'>				
				<BR><BR><BR>
				<tr>
					<td class='label'  width='30%' ><fmt:message key="eCA.symbolid.label" bundle="${ca_labels}"/></td>
					<td width='70%'><input type='text'  name = "symbol_id"  size='15' maxlength = '10' onpaste="return false;" onkeypress="return CheckForSpecChars(event)"  onblur = "refreshFooter()" value=<%=symbol_id %>  <%=rfiReadOnlyYN%> > <!-- onpaste = "return false" added for IN040319   -->
						<img src='../../eCommon/images/mandatory.gif'>
					</td>
					
				</tr>
				<tr>
					<td colspan='2' >&nbsp;</td>
				</tr>
				<tr>
					<td class='label'   width='30%' ><fmt:message key="eCA.symbol.label" bundle="${ca_labels}"/></td>
					<td width='70%'><input type="text" id = "symbol" name = "symbol"  size='15'  maxlength = '25' onblur = "return CheckForPromptSpecChars1(this)"  onkeypress="return CheckForPromptSpecChars(event)"  value ="<%= symbol %>" >
						<img src='../../eCommon/images/mandatory.gif'>
					</td>
				</tr>
				
				<tr>
					<td colspan='2' >&nbsp;</td>
				</tr>
				<tr>					
					<td class=label ><fmt:message key="eCA.symbolgroups.label" bundle="${ca_labels}"/></td>
						<td class='fields' colspan="2"><input type='text' name='symbol_group_desc_' id='symbol_group_desc_' value="<%=symbol_group_desc%>" size="20" OnBlur ='getNoteGroupCode1()'><input type='button' name='symbol_desc_search' id='symbol_desc_search' value='?' class='button' OnClick='getNoteGroupCode1()'><input type='hidden' name='symbol_group_id_' id='symbol_group_id_' value="<%=symbol_grp%>" > <!-- getNoteGroupCode changed to getNoteGroupCode1 -for IN040319   -->
						<img src='../../eCommon/images/mandatory.gif'></td>
				</tr>
				<tr>
					<td colspan='2' >&nbsp;</td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
			
					<td> <textarea name="symbol_remarks" value='' maxlength='100' rows="3" cols ="60"  onKeyPress=" checkMaxLimit(this,200)"  onBlur="callCheckMaxLength(this,200);makeValidString(this);"  ><%=remarks_text%></textarea> 
					<img src='../../eCommon/images/mandatory.gif'></td>
				</tr>

				<tr>
					<td colspan='2' >&nbsp;</td>
				</tr>
				<tr>
					<td class='label'  width='30%' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					<% if(mode.equals("1")){ //Included checked value in mode 1 and value E for default setup IN041129 %>
					<td class='fields' width='70%'><input type="checkbox"  name="eff_status" id="eff_status" value= "E"  checked onclick = 'setEffStauts(this)'></td>		
					<% } else if(mode.equals("2")) {%>
					<td class='fields' width='70%'><input type="checkbox"  name="eff_status" id="eff_status" <%=enabled_checked%> value = <%= eff_status %> onclick = 'setEffStauts(this)'></td>		
					<% } %>
				</tr>
				
			</table>
			<input type="hidden" name="mode" id="mode" value="<%=mode%>"/>
		</form>
		<%
		}
		catch(Exception ex){
			ex.getMessage();
		}
		finally{
			ConnectionManager.returnConnection(con,request);
		}
		%>	
	</body>
</html>

