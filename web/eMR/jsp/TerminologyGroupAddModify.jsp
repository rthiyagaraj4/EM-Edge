<!DOCTYPE html>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper"   contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/TerminologyGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String mode=request.getParameter("mode");
 // String code=request.getParameter("factor_code");
%>

<body onMouseDown="CodeArrest()"  onload='FocusFirstElement()' onKeyDown="lockKey()">
<form name="TerminologyAddModify_Form" id="TerminologyAddModify_Form" method="post">
<%
if(mode == "1" || mode.equals("1"))
{
	Connection conn=null;
	String term_group_id="";
	// String term_set_id="";
	//String term_group_desc="";
	String effstatus="";

	/* Check Style Correction 10/5/2005
	 String codeTextAttribute=""; 
	 String otherTextAttribute=""; 
	 boolean new_term_group_id = false;
	 String eventFunctionForCase=""; 
	*/
	String checkBoxAttribute="";
	String sql="";
	String isIndexChecked="";
	try
	{
		conn=ConnectionManager.getConnection(request);
		term_group_id=request.getParameter("term_group_id");
		if(term_group_id==null || term_group_id.equals(""))
		{
			term_group_id="";
			//term_set_id="";
			//term_group_desc="";
			effstatus="E";

	/*	Check Style Correction 10/5/2005	
			codeTextAttribute="";
			otherTextAttribute="";
			new_term_group_id=true;
			eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	*/
			checkBoxAttribute="CHECKED";
		}
		else
		{
			//Statement stmt=null;
			PreparedStatement stmt=null;	
			ResultSet rset=null;
			try	
			{
				//stmt = conn.createStatement();
				sql = "select a.term_group_id, a.term_set_id, a.term_group_desc,a.eff_status, b.term_set_desc,a.INDEX_TYPE_YN from MR_TERM_GROUP_HDR a, MR_TERM_SET b where a.term_group_id =?";
				
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,term_group_id);
				rset = stmt.executeQuery();
				rset.next();
				term_group_id=rset.getString("term_group_id");
				//term_set_id=rset.getString("term_set_id");
				//term_group_desc=rset.getString("term_group_desc");
				effstatus=rset.getString("eff_status");
				isIndexChecked=rset.getString("INDEX_TYPE_YN");


				if(effstatus.equals("D"))
				{
					//otherTextAttribute="READONLY";
					checkBoxAttribute="";
				}
				else
				{
					//otherTextAttribute="";
					checkBoxAttribute="CHECKED";
				}

				if(isIndexChecked!=null && isIndexChecked.equals("Y"))
				{
					
					isIndexChecked="CHECKED";
				}
				else
				{
					
					isIndexChecked="";
				}

			 }
			 catch(Exception e)
			 {
				//out.println(e.toString());
				e.printStackTrace();
			 }	
			 finally
			 {
				try
				{
					if(stmt!=null)
						stmt.close();
					if(rset!=null)
					rset.close();
				}	
				catch(Exception e)
				{
					//out.println(e.toString());
					e.printStackTrace();
				}
			 }

		 /*	Check Style Correction 10/5/2005	
			 codeTextAttribute="READONLY";
			 eventFunctionForCase="";
			 new_term_group_id=false;
		*/
		}
	}
	catch(Exception e)
	{
		//out.println(e);
		e.printStackTrace();
	}
	%>
	<table border='0' cellpadding='5' cellspacing=0 width="100%" align="center">
	<tr>
		<td width="20%"  class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
		<td width='60%' class='fields' >
		<input type="text" name="Term_Group_ID" id="Term_Group_ID" size="10" maxlength="10" onKeyPress="return CheckForSpecChars(event);">&nbsp;
		<img src="../../eCommon/images/mandatory.gif"></img>
		</td>
		<td class="label" width='20%'></td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type="text" name="Term_Group_Desc" id="Term_Group_Desc" size="30" maxLength="60">
		<img src="../../eCommon/images/mandatory.gif"></img>
		</td>
		<td class="label" ></td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
		<td class="fields" >
		<select name="term_set_id" id="term_set_id"  onchange='changeTerminology(this);'>
		<option value="" selected style='align:center'>-------------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------------------- </option>
	<%
		try
		{
			PreparedStatement terminology_stmt=null;
			ResultSet terminology_rset=null;
			//conn = ConnectionManager.getConnection(request);
	//			String multiple_yn=request.getParameter("multiple_yn");
		
			//String term_set ="select TERM_SET_ID,TERM_SET_DESC from mr_term_set where PROC_SPEC_YN = 'Y' and eff_Status = 'E' order by 2";
			//Modified on 04-06-2008
			String term_set = "select TERM_SET_ID,TERM_SET_DESC from mr_term_set where eff_Status = 'E' order by 2";

			terminology_stmt =conn.prepareStatement(term_set);
			terminology_rset = terminology_stmt.executeQuery();
			String tsetid="",tsetdesc="";
			while(terminology_rset!=null  && terminology_rset.next())
			{
				tsetid=terminology_rset.getString(1);
				tsetdesc=terminology_rset.getString(2);
				out.println("<option style='align:center' value='"+tsetid+"'>"+tsetdesc+""); 
			}

			if (terminology_rset != null) 
				terminology_rset.close();
			if (terminology_stmt != null) 
				terminology_stmt.close();
			//term_set_id=request.getParameter("term_set_id");	
	%>
		</select><img src="../../eCommon/images/mandatory.gif"></img></td>
		<input type='hidden' name='desc' id='desc' value='<%=tsetdesc%>'>
		<td class='button'><input name='inp' id='inp' type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCode.label","common_labels")%>'  onclick='callTermCode(term_set_id)' style='visibility:hidden'>
			</td>
		
	</tr>
	<tr>
		<td class="label"  ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<input type='checkbox' name='term_status_yn' id='term_status_yn' value='<%=effstatus%>' <%=checkBoxAttribute%> onClick="change()">
		</td>
		<td class="label" ></td>
	</tr>
	<tr>
		<td class="label"  ><fmt:message key="eMR.Indexed.label" bundle="${mr_labels}"/></td>
		<td class='fields'>
			<input type='checkbox' name='term_index_yn' id='term_index_yn' value='N' <%=isIndexChecked%> onClick="changeIndex(this)">
		</td>
		<td class="label" ></td>
	</tr>
	</table>
		<input type='hidden' name='mode' id='mode' value='1'>
	<%
	}
	catch(Exception e)
	{
	}
	finally
	{

	ConnectionManager.returnConnection(conn,request);
	}
}
else if(mode=="2" || mode.equals("2"))
{
	String term_group_id=request.getParameter("term_group_id")==null?"":request.getParameter("term_group_id");
    String term_set_id=request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
    String term_group_desc=request.getParameter("term_group_desc")==null?"":request.getParameter("term_group_desc");
    String term_set_desc=request.getParameter("term_set_desc")==null?"":request.getParameter("term_set_desc");
    String effstatus=request.getParameter("eff_status")==null?"":request.getParameter("eff_status");
    String indexed=request.getParameter("indexed")==null?"N":request.getParameter("indexed");
	String stat="";
	String disable="";
	String style="";
	String indexed_checked = "CHECKED";
	String indexed_disabled = "disabled";
	if(effstatus.equals("E"))
	{
		stat="CHECKED";
		disable="";
		if(indexed.equals("Y"))
		{
			indexed_checked = "CHECKED";
			indexed_disabled = "";
		}
		else
		{
			indexed_checked = "";
			indexed_disabled = "";
		}
	}
	else
	{
		disable="disabled='true'";
		stat="";
		style="visibility:hidden";

		if(indexed.equals("Y"))
		{
			indexed_checked = "CHECKED";
			indexed_disabled = "disabled";
		}
		else
		{
			indexed_checked = "";
			indexed_disabled = "disabled";
		}

	
	}
%>
	<input type = "hidden" name = "effstatus" id = "effstatus" value = '<%=effstatus%>'>
	<input type = "hidden" name = "indexed" id = "indexed" value = '<%=indexed%>'>
	<table border='0' cellpadding='5' cellspacing=0 width="100%" align="center">
	<tr>
		<td width="20%"  class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
		<td class='fields' width='60%' >
		<input type="text" name="Term_Group_ID" id="Term_Group_ID" size="10" maxlength="10" disabled value='<%=term_group_id%>'>
		<input type="hidden" name="term_group_id" id="term_group_id" value='<%=term_group_id%>'>
		<img src="../../eCommon/images/mandatory.gif"></img>
		</td>
		<td class="label" width='20%'></td>
	</tr>
	<tr>
		<td class="label" ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='fields' >
		<input type="text" name="Term_Group_Desc" id="Term_Group_Desc" size="30" maxLength="60" value='<%=term_group_desc%>'  <%=disable%>>
		<img src="../../eCommon/images/mandatory.gif"></img>
		</td>
		<td class="label" ></td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
		<td class="fields" >
		<select name="term_set_id" id="term_set_id" disabled>
		<option value='<%=term_set_id%>' selected ><%=term_set_desc%></option>
		</select><img src="../../eCommon/images/mandatory.gif"></img></td>
		<td class='button'>
		<input name='inp' id='inp' type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCode.label","common_labels")%>'  class=button onclick='callTermCode(term_set_id)'  style='<%=style%>'>
		</td>
	</tr>
	<tr>
		<td class="label"  ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='checkbox' name='term_status_yn' id='term_status_yn' value='<%=effstatus%>' <%=stat%> onClick="change()">
		</td>
		<td class="label" ></td>
	</tr>
	<tr>
		<td class="label"  ><fmt:message key="eMR.Indexed.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type='checkbox' name='term_index_yn' id='term_index_yn' value='<%=indexed%>' <%=indexed_checked%> <%=indexed_disabled%> onClick="changeIndex(this)" ></td>
		<td class="label" ></td>
	</tr>
	</table>
	<input type='hidden' name='desc' id='desc' value='<%=term_set_desc%>'>
	<input type='hidden' name='mode' id='mode' value='2'>
<%
}
%>

</form>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

