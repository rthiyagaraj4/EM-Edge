<!DOCTYPE html>
 <%--
	FileName	:StatGrpNationDetailquery.jsp
	Version	    : 3	
	Modified On	: 23-2-2005 , 7-3-2008
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>

<html>

	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language = 'javascript'></script>
		<script src = '../../eCommon/js/common.js' language = 'javascript'></script>
		<script language="javascript" src="../../eAM/js/StatGrpNationDetail.js"></script>
		
		<script language="JavaScript">
	  var sStyle='<%=sStyle%>';
	function callMember(alpha)
	{
		var errors = "";	
		var stat = parent.parent.frames[1].getLabel("Common.StatisticsGroup.label","Common");

		if(document.getElementById('stat_grp_id').value.length !=0)
		{
			
			parent.frames[1].location.href='../../eAM/jsp/StatGrpNationDetailresult.jsp?param='+alpha+'&stat_grp_id='+document.getElementById('stat_grp_id').value+'&category='+document.getElementById('category').value+'&dtl_flag=insert';
		
		}
		else
		{
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(stat)));
			parent.parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
			//parent.parent.frames(2).location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=APP-000001 Statistics Group cannot be blank...'
		}
	}
	function to_hide()
	{
		document.getElementById('alpha').style.visibility="hidden";
		document.getElementById('alpha1').style.visibility="hidden";
		parent.frames[1].location.href='../../eCommon/html/blank.html'
		
	}
	function to_visible()
	{
		var cat = parent.parent.frames[1].getLabel("Common.category1.label","Common")
		var stat = parent.parent.frames[1].getLabel("Common.StatisticsGroup.label","Common");
		   		
		document.forms[0].statusval.value='Y'
		var names = new Array(cat,stat);
		var errors = "";
		
		if(document.forms[0].category.value =="")
		{	
			//alert("APP-000001 Category cannot be blank...");
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(cat)))+"<br>";
			//errors = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(cat)));
			
			document.forms[0].category.focus();
			//return false;
		}
		
		if( document.forms[0].stat_group.value !="")
		{
			document.getElementById('alpha').style.visibility="visible";
			document.getElementById('alpha1').style.visibility="visible";
			parent.frames[1].location.href='../../eCommon/html/blank.html'
			
		}
		else
		{
			//parent.frames(2).location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=APP-000001 Statistics Group cannot be blank...'
			//alert("APP-000001 Statistics Group cannot be blank...");
			errors += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(stat)));
			
			
			document.forms[0].stat_group.focus();
			
			//parent.frames(2).document.statgrpdtlquery.focus();
			// parent.parent.frames(2).location.href='../../eCommon/jsp/MstCodeToolbar.jsp'
			//messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
           // return false;

			//return false;
			
			
		}



		if(errors.length != 0)
		{
			
			errors = errors + "<br> ";
			
			
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors;
			errors="";
			
		}
		else
		{
			errors="";
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors;
		//parent.reload();
		}
	}
	/**/
	function display_query()
	{
		parent.frames[1].location.href='../../eAM/jsp/StatGrpNationDetailresult.jsp?dtl_flag=query&stat_grp_id='+document.forms(0).stat_group.value;
	}
	
	function getVal()
	{
		
	   var category=document.getElementById('category').value;
		var HTMLVal = "<HTML><HEAD>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown = 'lockKey()'>";
		HTMLVal = HTMLVal +"<form name='form1' method='post' action='../../eAM/jsp/StatGrpPopulate.jsp' target=messageFrame>";
		HTMLVal = HTMLVal +"<input name='category' id='category' type='hidden' value= '"+category+"'>";
		HTMLVal = HTMLVal +"</form></BODY></HTML>";
		parent.parent.frames[2].document.write(HTMLVal);
		parent.parent.frames[2].document.forms[0].submit();
		document.getElementById('alpha').style.visibility="hidden";
        document.getElementById('alpha1').style.visibility="hidden";
        parent.result.location.href="../../eCommon/html/blank.html";

					
				
		}
				
				

	

	function from_query(stat_grp_id,category)
	{
		parent.frames[1].location.href='../../eAM/jsp/StatGrpNationDetailresult.jsp?dtl_flag=insert&stat_grp_id='+stat_grp_id+'&category='+category;
	}
	function assignVal(val)
	{
		document.forms[0].stat_grp_id.value = val;
		document.getElementById('alpha').style.visibility="hidden";
        document.getElementById('alpha1').style.visibility="hidden";
        parent.result.location.href="../../eCommon/html/blank.html";

	}
	
	</script>

<%
	Connection con =ConnectionManager.getConnection(request);
	
	Statement stmt=null;
	ResultSet rset=null ;
	Statement stmt1=null;
	ResultSet rset1=null ;
	String stat_grp_desc ="";
	
	request.setCharacterEncoding("UTF-8");	
	String stat_grp_id = request.getParameter("stat_grp_id");	// from AddModifyStatGrpNationDetail.jsp
	String catgy=request.getParameter("category");
	if(catgy == null) catgy="";

	String catgy_desc="";
	if(catgy.equals("N"))
	   catgy_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels");
	else if(catgy.equals("S"))
	   catgy_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels");
	else if(catgy.equals("P"))
	   catgy_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	 
	 
	try{
		if(stat_grp_id == null || stat_grp_id.equals("null")) 
			stat_grp_id="";
		if(stat_grp_id.equals(""))
		{
%>
			<body  onLoad="to_hide();Focusing('category');getVal();" onMouseDown ='CodeArrest();' onKeyDown = 'lockKey()'>
<%	
		} 
		else
		{
%>
			<body onLoad="from_query('<%=stat_grp_id%>','<%=catgy%>');Focusing('stat_group');" onKeyDown = 'lockKey()' onMouseDown ='CodeArrest();' onKeyDown = 'lockKey()'>
<% 
		}
%>
	<form name='statgrpdtlquery' id='statgrpdtlquery'>
		<table cellspacing=0 cellpadding=0 width='100%' border=0>
		<tr>
		<td class='label' align='left' width='30%'><fmt:message key="Common.category1.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<%if(!stat_grp_id.equals(""))
	     {%>
		<td><input type ='text' name = 'category_desc'  id = 'category_desc' readOnly  size ='20' value ="<%=catgy_desc%>" >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
		
		<input type='hidden' name='category' id='category' value='<%=catgy%>'>

		<%}else
	 {%>
         
			
			<td><select name='category' id='category' onChange='getVal()'> 
		<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----        <option value='N'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/>
        <option value='S'><fmt:message key="Common.service.label" bundle="${common_labels}"/>
		<option value='P'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
		
   
		</select>&nbsp;<img align='center' src='../../eMP/images/mandatory.gif'>
		<%}%>

		</td>			
		</tr>

			
        <tr><td colspan='2'>&nbsp;</td></tr>
		<tr>
			<td class='label' align='left' width='30%'><fmt:message key="Common.StatisticsGroup.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<%if(stat_grp_id.equals("")) {%>
			<td width='70%' align='left'>			
			<select name='stat_group' id='stat_group' onChange='assignVal(this.value)'><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----
			<%
			%>
				</select>&nbsp;<img align='center' src='../../eMP/images/mandatory.gif'>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%} else if(!stat_grp_id.equals("")){

				stmt1 = con.createStatement();
				rset1 = stmt1.executeQuery("select stat_grp_desc from am_stat_group where stat_grp_id='"+stat_grp_id+"'");
				if(rset1.next())
				{
				stat_grp_desc = rset1.getString("stat_grp_desc");
				}
				%>
			<td><input type ='text' name = 'stat_group' readOnly  size ='20' value ="<%=stat_grp_desc%>" >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
			<%}%>
			<input type ='hidden' name ='stat_grp_id' id ='stat_grp_id' value ='<%=stat_grp_id%>'>		
			<input type ='hidden' name ='statusval' id ='statusval' value =''>		
			<input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels") +" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Member.label","common_labels")%>' name='search' id='search' onClick='to_visible()'>&nbsp;&nbsp;<input type='button' class='button' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='to_hide()'>
			</td>
		</tr>
		<tr><td colspan='2'>&nbsp;</td></tr>
	<TR id='alpha' name='alpha'>
			<TD colspan='2' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:callMember('A')">A</a>&nbsp;&nbsp;<a href="javascript:callMember('B')">B</a>&nbsp;&nbsp;<a href="javascript:callMember('C')">C</a>&nbsp;&nbsp;<a href="javascript:callMember('D')">D</a>&nbsp;&nbsp;<a href="javascript:callMember('E')">E</a>&nbsp;&nbsp;<a href="javascript:callMember('F')">F</a>&nbsp;&nbsp;<a href="javascript:callMember('G')">G</a>&nbsp;&nbsp;<a href="javascript:callMember('H')">H</a>&nbsp;&nbsp;<a href="javascript:callMember('I')">I</a>&nbsp;&nbsp;<a href="javascript:callMember('J')">J</a>&nbsp;&nbsp;<a href="javascript:callMember('K')">K</a>&nbsp;&nbsp;<a href="javascript:callMember('L')">L</a>&nbsp;&nbsp;<a href="javascript:callMember('M')">M</a>&nbsp;&nbsp;<a href="javascript:callMember('N')">N</a>&nbsp;&nbsp;<a href="javascript:callMember('O')">O</a>&nbsp;&nbsp;<a href="javascript:callMember('P')">P</a>&nbsp;&nbsp;<a href="javascript:callMember('Q')">Q</a>&nbsp;&nbsp;<a href="javascript:callMember('R')">R</a>&nbsp;&nbsp;<a href="javascript:callMember('S')">S</a>&nbsp;&nbsp;<a href="javascript:callMember('T')">T</a>&nbsp;&nbsp;<a href="javascript:callMember('U')">U</a>&nbsp;&nbsp;<a href="javascript:callMember('V')">V</a>&nbsp;&nbsp;<a href="javascript:callMember('W')">W</a>&nbsp;&nbsp;<a href="javascript:callMember('X')">X</a>&nbsp;&nbsp;<a href="javascript:callMember('Y')">Y</a>&nbsp;&nbsp;<a href="javascript:callMember('Z')">Z</a>&nbsp;&nbsp;<a href="javascript:callMember('Others')"><fmt:message key="Common.others.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;
			</TD>
		</TR>
		<tr id='alpha1' name='alpha1'><td colspan='2'>&nbsp;</td></tr>
		</TABLE>
		</form>

	<%}catch(Exception e){out.println("Exception :"+e);}
finally{
	try{
if(stmt!=null) stmt.close();
if(rset!=null) rset.close();
if(stmt1!=null) stmt1.close();
if(rset1!=null) rset1.close();
	}
	catch(Exception e)
	{}
ConnectionManager.returnConnection(con,request);
} %>
	</body>
</html>

