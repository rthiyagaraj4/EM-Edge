<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eMO/js/MOBedForArea.js" language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
 <body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
   Connection conn			= null;
   Statement stmt			= null; 
   ResultSet rset			= null; 
   ResultSet prset			= null;
   PreparedStatement pstmt	= null;
try
	{
	String  capacityCount	= "";
	String bedforareacount	= "";
	String code				= "";
	String long_desc		= "";
	String effstatus		= "";
	String codeTextAttribute= "";
	String checkBoxAttribute= "";
	String enblothrs		= "";
	String bed_no			= "";
	String mode				= "INSERT";
    request.setCharacterEncoding("UTF-8");
	conn					= ConnectionManager.getConnection(request);
    boolean newcomplaint	= false;
	String	 facilityId 			= (String) session.getValue( "facility_id" ) ;
    StringBuffer  SqlArea	= new  StringBuffer();
	SqlArea.setLength(0);
	SqlArea.append("select  distinct area_code, SHORT_DESC from MO_AREA where facility_id = '"+facilityId+"' and eff_status = 'E' order by 2");
	code	=	request.getParameter("area_code");
	bed_no	=	request.getParameter("bed_no");
	if(code==null)
	{
		code				=	"";
		bed_no				=	"";
		long_desc			=	"";
		effstatus			=	"E";
		codeTextAttribute	=	"";
		checkBoxAttribute	=	"CHECKED";
		newcomplaint		=	true;
		
	 }else{
		mode				= "MODIFY";
    	StringBuffer  sql	= new  StringBuffer();
		sql.setLength(0);
		sql.append("SELECT area_code,area_desc, bed_no,eff_status FROM mo_bed_for_area_vw WHERE area_code =? and bed_no =? and facility_id = ?");
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1,code);
		pstmt.setString(2,bed_no);
		pstmt.setString(3,facilityId);
		rset = pstmt.executeQuery();
		rset.next();
		code=rset.getString("AREA_CODE");
		long_desc=rset.getString("AREA_DESC");
		bed_no = rset.getString("BED_NO");
		bed_no  = (bed_no == null)?"":bed_no;
		effstatus=rset.getString("EFF_STATUS");
		if(effstatus.equals("D")){
		checkBoxAttribute="";
		enblothrs ="READONLY";
		}else{
		checkBoxAttribute="CHECKED";
		}
	  	codeTextAttribute="READONLY";
		newcomplaint=false;
		sql.setLength(0);
	 }
%>
<form name="MOBayForArea_form" id="MOBayForArea_form"  action='../../servlet/eMO.MOBedForAreaServlet' method='post' target='messageFrame'>
<br><br><br><br><br><br><br><br><br><br>
<table cellspacing='0' cellpadding='3' align="center" width="80%" border="0">

<%if (mode.equals("MODIFY")){%>
 <!-- <tr>
		<td class="label" align="right" width="40%"> Area Code</td>
		<td class='label' align='left'  width='40%'>&nbsp;
		<input type="text" name="area_code" id="area_code" value="<%=code%>" readonly>
		<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
 </tr> 
 <tr>
		<td colspan=2>&nbsp;</td>
 </tr>-->
  <tr>
		<td class="label" width="50%"><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
		<td class='fields' width='50%'><input type="text" name="area_desc" id="area_desc" value="<%=long_desc%>" readonly>
		<input type="hidden" name="area_code" id="area_code" value="<%=code%>" >
      </td>
  </tr>
    <%}else{%>
	     
	   <tr>
		<td class="label" width="50%"><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
		<td class='fields' width='50%'><select name='area_code' id='area_code'  value='<%=code%>'  <%=codeTextAttribute%> 
		 onChange="checkCond('<%=bedforareacount%>' ,'<%=capacityCount%>' )">
	    <option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
		<% 
              if(rset!=null)rset.close();
		      if(pstmt!=null)pstmt.close();
		      pstmt   = conn.prepareStatement(SqlArea.toString());
			  prset   = pstmt.executeQuery();
			  while(prset!=null && prset.next())
			  {
				 if(code.equals(prset.getString(1)))
	             {   
			  	       out.println("<option value='"+prset.getString(1)+"' selected>");	
					   
				 }
				 else
				 {  
					   out.println("<option value='"+prset.getString(1)+"'>");	
				       
				 }
				       out.println(prset.getString(2));
					   out.println("</option>"); 
			  }
		 	SqlArea.setLength(0);	
		 %>
		      </select><img src='../../eCommon/images/mandatory.gif' align='center'></img> 
			  </td>
	        </tr>	
	<%}%>
	
	<tr>
		<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="bed_no" id="bed_no" size="8" maxlength="8" value="<%=bed_no%>" <%=enblothrs%> <%=codeTextAttribute%>  onKeyPress='return CheckForSpecChars(event)' OnBlur='ChangeUpperCase(this)'><img align="center" src="../../eCommon/images/mandatory.gif"></img>
		 </td>
	</tr>	
 	<tr>
		<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	   <td class='fields'><input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
	</tr>	
	</table>

 <%  if(newcomplaint){%>

      	<input type='hidden' name='function' id='function'		value='insert'>
      	<input type='hidden' name='function_name' id='function_name'	value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function'		value='modify'>
      	<input type='hidden' name='function_name' id='function_name'	value='modify'>
     <%}%>
   </form>
	 <%  
	}catch(Exception e){
			out.println(e.toString());
			e.printStackTrace();
		}
		finally{
		   if(rset!=null) rset.close();
		   if(stmt!=null) stmt.close();
		   if(prset!=null) prset.close();
		   if(pstmt!=null) pstmt.close();
	       ConnectionManager.returnConnection(conn,request);
	  } %>
  </body>
  </html>

