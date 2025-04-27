<!DOCTYPE html>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

 <%request.setCharacterEncoding("UTF-8");
    Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;

 try
 {
    StringBuffer sql=new  StringBuffer();
    conn = ConnectionManager.getConnection(request);

	%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../js/TranslationManager.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

 <body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="TranslationCriteria" id="TranslationCriteria" >
<table cellspacing=0 cellpadding=0 align="center" width="95%" border="0">
  <tr><td colspan=4>&nbsp;</td></tr>
  <tr>
  <td class=label><fmt:message key="Common.Module.label" bundle="${common_labels}"/>&nbsp;</td>
  <td class="fields"><select name=module_id  onChange='getMaster(this); '>
  <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
  <%
  sql.append("select   module_id, module_name  from  sm_module  order by module_name ");
  pstmt = conn.prepareStatement(sql.toString());
  rset = pstmt.executeQuery();
  while(rset.next())
  {%>
  <option value='<%=rset.getString("module_id")%>'><%=rset.getString("module_name")%> </option>
  
  <%}
	if (rset != null) rset.close();
	if (pstmt != null) pstmt.close();
   %>
  
  </select>&nbsp;<img name='mandatory1' src='../../eCommon/images/mandatory.gif'>
  </td>
  <td class=label><fmt:message key="eSM.MasterName.label" bundle="${sm_labels}"/>&nbsp;</td>
  <td class="fields"><select name=master_name >
    
  <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
  
  
  
  </select>&nbsp;<img name='mandatory1' src='../../eCommon/images/mandatory.gif'>
  </td>
  </tr>
<tr>
  <td class=label><fmt:message key="Common.Language.label" bundle="${common_labels}"/>&nbsp;</td>
  <td class="fields"><select name=language >
  <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
  <%

  sql.setLength(0);
  sql.append("select LANGUAGE_ID, SHORT_NAME from sm_language where PRIMARY_LANG_YN='N' and EFF_STATUS='E' order by SHORT_NAME");
  pstmt = conn.prepareStatement(sql.toString());
  rset = pstmt.executeQuery();
  while(rset.next())
  {%>
  <option value='<%=rset.getString("LANGUAGE_ID")%>'><%=rset.getString("SHORT_NAME")%> </option>
  
  <%}%>
  
  </select>&nbsp;<img name='mandatory1' src='../../eCommon/images/mandatory.gif'>
  </td>
  <td class=label><fmt:message key="Common.display.label" bundle="${common_labels}"/>&nbsp;</td>
  <td class="fields"><select name=display >
    
  
    <option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
    <option value='T'><fmt:message key="eSM.Translated.label" bundle="${sm_labels}"/></option>
    <option value='N' selected><fmt:message key="eSM.NonTranslated.label" bundle="${sm_labels}"/></option>
  </select>&nbsp;<img name='mandatory1' src='../../eCommon/images/mandatory.gif'>
  </td>
  </tr>
  <tr>
  <td class=label> <fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>&nbsp;</td>
  <td class="fields" colspan=2 > <INPUT TYPE="text" name="searchtext" id="searchtext" size=50></td>
  <td class="fields"><INPUT TYPE="button" name="Search" id="Search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  class=button onClick='showResultPage()'>&nbsp;<INPUT TYPE="button"  class=button name="clear" id="clear" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearData()' ></td<>
  </tr>
<tr><td colspan=4 ></td></tr>
 <%
	}catch(Exception e) { out.println("Main : "+e.toString());}
	finally
	{
		try{
		if (rset != null) rset.close();
		if (pstmt != null) pstmt.close();
		}catch(Exception e) {}
		if(conn != null) ConnectionManager.returnConnection(conn,request); 
	}
%>
 </form>
 </body>
 </html>

