<!DOCTYPE html>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" %>
 
 

 <%request.setCharacterEncoding("UTF-8");
    Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rset=null;
	int countRec =0;

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
<script language='javascript' src='../js/XHTranslationManager.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

 <body onLoad='FocusFirstElement();getMaster2();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name="TranslationCriteria" id="TranslationCriteria"  >
<table cellspacing=0 cellpadding=2 align="center" width="95%" border="0">
<tr>
  <td class=label width='25%'><fmt:message key="Common.Application.label" bundle="${common_labels}"/>&nbsp;</td>
  <td class="fields" width='25%'><select name=application id=application onChange='getMaster1(this);'>
  <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
  <%

  sql.setLength(0);
  sql.append("  SELECT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION ORDER BY APPLICATION_ID");

  pstmt = conn.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
  rset = pstmt.executeQuery();
  if(rset != null)
   {
	  rset.last();
	  countRec = rset.getRow();
	  rset.beforeFirst();
   }
   if (countRec == 1)
	  {
		while(rset!=null && rset.next())
		  {%>
		<option value='<%=rset.getString("APPLICATION_ID")%>' selected><%=rset.getString("APPLICATION_NAME ")%> </option>
		  <%}
	  }
   else if (countRec >= 1)
   {
	  while(rset!=null && rset.next())
	  {%>
	   		<option value='<%=rset.getString("APPLICATION_ID")%>' selected><%=rset.getString("APPLICATION_NAME")%> </option>
	  <%}
	  }%>
  </select>&nbsp;<img name='mandatory1' src='../../eCommon/images/mandatory.gif'>
  </td>
  <td class=label  width='25%'><fmt:message key="Common.display.label" bundle="${common_labels}"/>&nbsp;</td>
   <td class="fields" width='25%'><select name=display id=display  >
    
  
    <option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
    <option value='T'><fmt:message key="eSM.Translated.label" bundle="${sm_labels}"/></option>
    <option value='N' selected><fmt:message key="eSM.NonTranslated.label" bundle="${sm_labels}"/></option>
  </select>&nbsp;<img name='mandatory1' src='../../eCommon/images/mandatory.gif'>
  </td>
  </tr>
  <tr>
  <td class='label' width='25%'><fmt:message key="Common.Module.label" bundle="${common_labels}"/>&nbsp;</td>
  <td class="fields" width='25%'><select name=module_id id=module_id  onChange='getMaster(this); '>
  <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
  </select>&nbsp;<img name='mandatory1' src='../../eCommon/images/mandatory.gif'>
  </td>
  <td class='label' width='25%'><fmt:message key="eSM.MasterName.label" bundle="${sm_labels}"/>&nbsp;</td>
  <td class="fields" width='25%'><select name=master_name id=master_name onChange='changeObj(this,module_id)'>
    
  <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
  
  
  
  </select>&nbsp;<img name='mandatory1' src='../../eCommon/images/mandatory.gif'>
  </td>
  </tr>

    
  <tr>
  <td class=label width='25%'>
  
   <fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>&nbsp;</td>
  <td class="fields"  id='obj1' nowrap><select name="start_ends_contains" id="start_ends_contains" >
					<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
					<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
				</select>
   <INPUT TYPE="text" name="searchtext" id="searchtext" width=30></td><td></td><td class="fields"  id='obj2'></td>
  </tr>
  <tr>
  <td class=label width='25%' id='obj3'></td>
  <td class="fields"   width='25%' id='obj4'></td>
  <td align='right' colspan=2><INPUT TYPE="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  class=button onClick='showResultPage()'>&nbsp;<INPUT TYPE="button"  class=button name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearData()' ></td<>
  </tr>
   <input type='hidden' name='language_direction' id='language_direction' value="">

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

