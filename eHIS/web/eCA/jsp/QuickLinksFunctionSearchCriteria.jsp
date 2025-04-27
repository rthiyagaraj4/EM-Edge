<!DOCTYPE html>
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/02/2019		IN069654	sivabagyam M 	07/02/2019		Ramesh G			MO-CRF-20101.4
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 08/12/2009  */
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	{
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	}
	/** ends here*/
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onLoad = "document.getElementById('search_text').focus()" onKeyDown="lockKey()">
<%
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	String search_text = request.getParameter("search_text") == null ? "" : request.getParameter("search_text");
	String ql_type = request.getParameter("ql_type") == null ? "" : request.getParameter("ql_type");
%>
<script>

	var radioval="D";
	function closew()
	{
		parent.window.close();
	}
	function CallDescFrame()
	{
		
		var listval=document.getElementById("search_criteria").value;
		var txtbox=document.getElementById("search_text").value;
		// console.log(listval);
		
		var ql_type=document.getElementById("ql_type").value;
		// console.log(ql_type);
		
		if(ql_type=='AM'){
		
			if(ql_type=='AM')
			{
				parent.frames[1].location.href='../../eCA/jsp/QuickLinksFunctionSearchResult.jsp?search_by='+radioval+'&search_criteria='+listval+'&search_text='+escape(txtbox)+'&ql_type='+ql_type;
			}
			else
			{
				var msg = getMessage('CAN_NOT_BE_BLANK','COMMON');
				msg = msg.replace('$','Module');
				alert(msg);
			}
		}
		else{
			var module_id=document.getElementById("module_id").value;
			if(module_id != null && module_id != '')
			{
				parent.frames[1].location.href='../../eCA/jsp/QuickLinksFunctionSearchResult.jsp?search_by='+radioval+'&search_criteria='+listval+'&search_text='+escape(txtbox)+'&module_id='+module_id+'&ql_type='+ql_type;
			}
			else
			{
				var msg = getMessage('CAN_NOT_BE_BLANK','COMMON');
				msg = msg.replace('$','Module');
				alert(msg);
			}
		}
	}

	function storeVal(currad)
	{
		radioval=currad.value
	}

</script>

<form name='SearchCriteria' id='SearchCriteria'>
<br/>
<table  border="0" width='100%' cellspacing='0' cellpadding='0'>
	
	<% if(ql_type.equals("AM")){ %>
		
		<%} else {%>
	<tr>
		<td>&nbsp;&nbsp;</td>
		
		
		<td class="label" nowrap ><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<select name="module_id" id="module_id"><option value = ''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	<%
			try
			{
				con = ConnectionManager.getConnection(request);
				String sql = "SELECT module_id from sm_module WHERE install_yn = 'Y' and exists (select 1 from sm_quick_link_option where SM_MODULE_ID=sm_module.module_id ) order by 1";
				String module_id = "";
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();

				while(rs.next())
				{
					module_id = rs.getString("module_id") == null ? "" : rs.getString("module_id");
					if(ql_type.equals("QF"))
					{
						if(module_id.equals("CA"))
						{
	%>
						<option value='<%=module_id%>' selected><%=module_id%></option>
	<%
						}
					}
					else
					{
	%>
						<option value='<%=module_id%>'><%=module_id%></option>
	<%
					}
				}
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
			finally
			{
				if (con != null) 
					ConnectionManager.returnConnection(con,request);
			}
	%>
			
			</select><img src="../../eCommon/images/mandatory.gif">
		</td>
		<td>&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;</td>
		
	</tr>
	<% } %>
	<tr>
		<td>&nbsp;&nbsp;</td>

		<td class="label" nowrap><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		
		<td  class="fields">
			 <input type="radio" name="search_by" id="search_by" class="label" value="C"  onclick='storeVal(this)'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
			<input type="radio" name="search_by" id="search_by" class="label" value="D" checked onclick='storeVal(this)'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
		</td>



		<td class="label" ><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>

		<td class='fields'>
			<select name="search_criteria" id="search_criteria">
			<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
			<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
			</select>
		</td>


	</tr>
	<tr>
		<td>&nbsp;&nbsp;</td>

		<td class='label' nowrap><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>

		<td class="fields"><input type="text" onBlur='makeValidString(this);'  name="search_text" id="search_text" value='<%=search_text%>' width=30% align="left" size='40' maxlength='70' ></td>

		<td>&nbsp;</td>

		<td align='left'><input type="button" width='20%' align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="CallDescFrame(); " class='button' >		
		</td>
	</tr>
</table>
<!-- added by kishore kumar n on 08/12/2009  -->
<%
	if(!imgUrl.equals("")){%>
	
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>

<!--ends here -->
<input type='hidden' name='ql_type' id='ql_type' value="<%=ql_type%>" > 
</form>
<script>
	if('<%=search_text%>' != '')
		document.forms[0].Search.click();
</script>
</body>
</html>

