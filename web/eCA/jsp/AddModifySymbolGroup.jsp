<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
08/04/2013    IN30708        Karthi      To incorporate the "Symbol" function  from Microsoft words to the Microsoft Editor in the clinical notes.
28/05/2013    IN040319        Karthi	System is not responding		
24/06/2013    IN041129		Chowminya G Enable checkbox default to yes
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
		<script src='../../eCA/js/CASymbolGroup.js' language='javascript'></script>
		<Script src ="../../eCommon/js/CommonLookup.js" language ="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			Connection con = null;
			try{
			
			con = ConnectionManager.getConnection(request);
			String mode	   = request.getParameter( "mode" ) ;
			int rowID = 0;
			String enabled_checked = "";
			String rfiReadOnlyYN = "";
			
			String group_code = request.getParameter("group_id") == null? "" : request.getParameter("group_id");
			String group_desc = request.getParameter("group_desc") == null? "" : request.getParameter("group_desc");
			String note_grp =  request.getParameter("note_group_id") == null? "" : request.getParameter("note_group_id");
			String note_group_desc =  request.getParameter("note_group_desc") == null? "" : request.getParameter("note_group_desc");
			String note_type =  request.getParameter("NOTE_TYPE") == null? "" : request.getParameter("NOTE_TYPE");
			String note_type_desc =  request.getParameter("note_type_desc") == null? "" : request.getParameter("note_type_desc");
			String eff_status = request.getParameter("eff_status") == null? "" : request.getParameter("eff_status");
			String sql = "";
			if("E".equals(eff_status))
				enabled_checked = "checked";
			else
				enabled_checked = "";
			PreparedStatement pstmt = null;	
			ResultSet resultSet = null;	
			//SymbolGroupBean beanObj = new SymbolGroupBean();
			if(mode.equals("2")) {
				//resultSet = beanObj.getSymbolNoteType(group_code, con);
				try{
					sql = "SELECT SYMBOL_GROUP, SYMBOL_GROUP_DESC, SYMBOL_GRP_NOTE , SYMBOL_GRP_NOTE_IND , CASE WHEN SYMBOL_GRP_NOTE_IND = 'G' THEN (ca_get_desc.CA_NOTE_GROUP(SYMBOL_GRP_NOTE, 'en', 1)) WHEN SYMBOL_GRP_NOTE_IND = 'T' THEN (ca_get_desc.CA_NOTE_TYPE(SYMBOL_GRP_NOTE,'en',1)) END note_group_desc FROM ca_symbol_group WHERE SYMBOL_GROUP = ?" ;
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, group_code.trim());
					resultSet	= pstmt.executeQuery() ;
				}
				catch(Exception ex){
					ex.getMessage();
				}
				rfiReadOnlyYN		= "ReadOnly";
				rowID = 1;
			}
			else {
				rowID = -1;
			}			
		%>	
	</head>

	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload= 'enableDisableFields(<%= mode%> )'>
		<form name='SymbolGroup' id='SymbolGroup' action='../../servlet/eCA.CASymbolGroupServlet' method='post' target='messageFrame'>
		
		<br>
			<table border='0' cellpadding='0' cellspacing='0' align='center' width='55%'>				
				<BR><BR><BR>
				<tr>
					<td class='label'  width='30%' ><fmt:message key="eCA.symbolgrpid.label" bundle="${ca_labels}"/></td>
					<td width='70%'><input type='text'  name = "group_id"  size='10' maxlength = '10' onkeypress="return CheckForSpecChars(event)" onpaste="return false;" onblur = "refreshFooter()" value=<%=group_code %>  <%=rfiReadOnlyYN%> > <!-- onpaste = "return false" added for IN040319   -->
						<img src='../../eCommon/images/mandatory.gif'>
					</td>
					
				</tr>
				<tr>
					<td colspan='2' >&nbsp;</td>
				</tr>
				<tr>
					<td class='label'   width='30%' ><fmt:message key="eCA.symbolgrpdesc.label" bundle="${ca_labels}"/></td>
					<td width='70%'><input type="textbox"  name = "group_desc"   maxlength = '40'  size='40' onBlur="makeValidString(this)" onpaste="return false;" onkeypress='return CheckForSpecCharsNoCaps(event)' value ="<%= group_desc %>" > <!-- onpaste = "return false" added for IN040319   -->
						<img src='../../eCommon/images/mandatory.gif'>
					</td>
					
				</tr>
				
				<tr>
					<td colspan='2' >&nbsp;</td>
				</tr>
				<tr>
					<td class='label'  width='20%' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
					<td class='fields' colspan="3" width='80%'>
						<SELECT name="search_by_" id="search_by_" onchange = 'enableDisableFields(<%= mode%> )'>
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
							<option value="G"><fmt:message key="eCA.NoteGroup.label" bundle="${ca_labels}"/></option>
							<option value="T"><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></option>
						</SELECT>
					</td>
				</tr>
				<tr>
					<td colspan='2' >&nbsp;</td>
				</tr>
				<tr id = 'note_idicator_enable' name= 'note_idicator_enable' style = "display:none" >					
					<td class=label id = 'note_grp_type'></td>
						<td class='fields' colspan="2"><input type='text' name='note_group_desc_' id='note_group_desc_' value="<%=note_group_desc%>" size="20" OnBlur ='getNoteGroupCode()'><input type='button' name='note_desc_search' id='note_desc_search' value='?' class='button' OnClick='getNoteGroupCode()'><input type='hidden' name='note_group_id_' id='note_group_id_' value="" > 
						<input type="button" value="Add" onClick="addNoteType('NoteGroupGrid',<%=mode%>)"/>

					</td>	
				</tr> 
				
				<tr>
					<td colspan='2' >&nbsp;</td>
				</tr>
				<tr id = 'eff_status_enable' name = 'eff_status_enable'  style = "display:none"  >
					<td class='label'  width='30%' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					<% if(mode.equals("1")){ //Included checked value in mode 1 and value E for default setup IN041129%>
					<td class='fields' width='70%'><input type="checkbox"  name="eff_status" id="eff_status" value= "E"  checked   onclick = 'setEffStauts(this)'></td>		
					<% } else if(mode.equals("2")) {%>
					<td class='fields' width='70%'><input type="checkbox"  name="eff_status" id="eff_status" <%=enabled_checked%> value = <%= eff_status %> onclick = 'setEffStauts(this)'></td>		
					<% } %>
				</tr>
				
				<tr>
					<td colspan='2' >&nbsp;</td>
				</tr>
				
				<tr id = 'note_table_enable' name = 'note_table_enable'  style = "display:none"   >
					<td colspan="2" >
						<DIV style="width:100%;height:430;overflow:auto">	
							<table  id='NoteGroupGrid' name = 'NoteGroupGrid' cellpadding='0' cellspacing='0' width="90%">
								<tr>
									<th width="15%" class='columnHeadercenter'> <fmt:message key="eCA.noteindicator.label" bundle="${ca_labels}"/> </th>
									<th width="30%" class='columnHeadercenter'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/>/<fmt:message key="eCA.NoteGroup.label" bundle="${ca_labels}"/> &nbsp;<img src='../../eCommon/images/mandatory.gif'></th>
									
									<th width="10%" class='columnHeadercenter'>
										<input type="button"  name="removeButton" id="removeButton" value="Remove" onClick="deleteRow('NoteGroupGrid')" /> 
									</th>
								</tr> 
								<%
								if(mode.equals("2")) {
									String note_grp_ind = "";
									while(resultSet.next()) {
										if(resultSet.getString("SYMBOL_GRP_NOTE_IND").equals("T")) {
											note_grp_ind = "Note Type";
										}
										else {
											note_grp_ind = "Note Group";
										}
								%>	
								<tr>
									<td class='gridData'  ><%=  note_grp_ind%></td> 
									<td class='gridData'  ><%=  resultSet.getString("note_group_desc") %></td>
									<input type="hidden"  name="note_group_id<%= rowID%>" id="note_group_id<%= rowID%>" value=<%=  resultSet.getString("SYMBOL_GRP_NOTE") %> >
									<input type="hidden"  name="search_by<%= rowID%>" id="search_by<%= rowID%>" value=<%=  resultSet.getString("SYMBOL_GRP_NOTE_IND") %> >
									<td class='gridData'><input type="checkbox"  name="remove" id="remove" value= ""> 
									</td></tr>
								<%		rowID = rowID + 1;
									}
								}	
								%>
							</table>
						</DIV>
					</td>
				</tr>
			</table>
			<input type="hidden" name="mode" id="mode" value="<%=mode%>"/>
			<input type="hidden" name="rowID" id="rowID" value="<%=rowID %>" /> 
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

