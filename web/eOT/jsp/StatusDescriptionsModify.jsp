<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eOT/js/StatusDescriptions.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<%

Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("mode");
String status_code = request.getParameter("status_code")==null?"":request.getParameter( "status_code" );
String disable_flag="";
String status_desc_sysdef="";
String status_desc="";
String color_ind ="";
String txt_color ="";
String status_code_disable="";
String sql="";
try{
	con=ConnectionManager.getConnection(request);
		// sql=" SELECT STATUS_CODE, STATUS_DESC_SYSDEF, STATUS_DESC, COLOR_IND, TEXT_COLOR FROM OT_STATUS WHERE STATUS_CODE=? ";
		
		sql=" SELECT STATUS_CODE, STATUS_DESC_SYSDEF, STATUS_DESC, COLOR_IND, TEXT_COLOR FROM OT_STATUS_LANG_VW WHERE STATUS_CODE=? AND LANGUAGE_ID= ?";
		stmt=con.prepareStatement(sql);
        stmt.setString(1,status_code);
        stmt.setString(2,locale);
      	rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			status_code=rs.getString("status_code");
			status_desc_sysdef=rs.getString("status_desc_sysdef");
			status_desc=rs.getString("status_desc");
			color_ind=rs.getString("color_ind");
			txt_color=rs.getString("text_color");
		}
		
		status_code_disable="disabled";
}catch(Exception e)
	{
		e.printStackTrace();
		//System.err.println("Err StatusDescriptionsModify" +e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				System.err.println("Err StatusDescriptionsModify" +e);
			}
		
		}
%>
<form name="status_descriptions_form" id="status_descriptions_form" onload='FocusFirstElement()'  action="../../servlet/eOT.StatusDescriptionsServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding='3' width='100%'  align=center>
<tr>
	<td class='label' width="25%" >
	<fmt:message key="Common.code.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" >
	<input type="text" name="status_code" id="status_code" value="<%=status_code%>" size=2 maxlength=2  <%=status_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
	</td>
</tr>

<tr>
	<td class='label' width="25%"  >
	<fmt:message key="eOT.SystemDefinedDescription.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width="25%" >
	<input type="text" name="status_desc_sysdef" id="status_desc_sysdef" value="<%=status_desc_sysdef%>"  size=40 maxlength=40 disabled>
	</td>
</tr>
<tr>
	<td class='label' width="25%" >
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%" >
	<input type="text" name="status_desc" id="status_desc" value="<%=status_desc%>"   size='40' maxlength='40' <%=disable_flag%>>
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
 <td class=label width="25%"  >
 <fmt:message key="eOT.BackGroundColor.Label" bundle="${ot_labels}"/>
 </td>
	<td class='fields' width="25%"  >
	<select name="color_ind" id="color_ind">
<%

	
	 String[] bgcolcode=null;
	 String[] bgcoltext=null;

	  //bgcolcode=new String[19];
      //bgcoltext=new String[19];
		bgcolcode=new String[20];
		bgcoltext=new String[20];

	
 /*	  bgcolcode[0]="BLUE";							BLUE               
	  bgcolcode[1]="LIGHBLUE";						BROWN              
	  bgcolcode[2]="DARKBLUE";						CYAN               
	  bgcolcode[3]="GREEN";							DARKBLUE           
	  bgcolcode[4]="LIGHTGREEN";					DARKCYAN           
	  bgcolcode[5]="DARKGREEN";						DARKGREEN          
	  bgcolcode[6]="YELLOW";						DARKRED            
      bgcolcode[7]="RED";							GREEN              
	  bgcolcode[8]="DARKRED";						GREY               
	  bgcolcode[9]="MAGENTA";						INDIGO             
	  bgcolcode[10]="BROWN";  						LIGHBLUE           
      bgcolcode[11]="VIOLET";						LIGHTGREEN         
      bgcolcode[12]="INDIGO";						MAGENTA            
	  bgcolcode[13]="ORANGE";						ORANGE             
      bgcolcode[14]="PINK";							PINK               
	  bgcolcode[15]="GREY";							PURPLE             
	  bgcolcode[16]="CYAN";							RED                
	  bgcolcode[17]="DARKCYAN";						select             
	  bgcolcode[18]="PURPLE";						VIOLET             
	  bgcoltext[19]="select";						YELLOW             
       
	   bgcoltext[0]="Blue";
	   bgcoltext[1]="Light Blue";
	   bgcoltext[2]="Dark Blue";
	   bgcoltext[3]="Green";
	   bgcoltext[4]="Light Green";
	   bgcoltext[5]="Dark Green";
	   bgcoltext[6]="Yellow";
	   bgcoltext[7]="Red";
	   bgcoltext[8]="Dark Red";
	   bgcoltext[9]="Magenta";
	   bgcoltext[10]="Brown";
	   bgcoltext[11]="Violet";
	   bgcoltext[12]="Indigo";
	   bgcoltext[13]="Orange";
	   bgcoltext[14]="Pink";
	   bgcoltext[15]="Grey";
	   bgcoltext[16]="Cyan";
	   bgcoltext[17]="Dark Cyan";
	   bgcoltext[18]="Purple";
	   bgcoltext[19]="select"; */
	  
		bgcolcode[0]="SELECT";					               
		bgcolcode[1]="BLUE";							             
		bgcolcode[2]="BROWN";							            
		bgcolcode[3]="CYAN";							           
		bgcolcode[4]="DARKBLUE";						           
		bgcolcode[5]="DARKCYAN";						          
		bgcolcode[6]="DARKGREEN";					           
		bgcolcode[7]="DARKRED";							              
		bgcolcode[8]="GREEN";							               
		bgcolcode[9]="GREY";						             
	   bgcolcode[10]="INDIGO";						           
	   bgcolcode[11]="LIGHTBLUE";  					        
	   bgcolcode[12]="LIGHTGREEN";					            
	   bgcolcode[13]="MAGENTA";						             
	   bgcolcode[14]="ORANGE";							              
	   bgcolcode[15]="PINK";						             
	   bgcolcode[16]="PURPLE";						               
	   bgcolcode[17]="RED";							             
	   bgcolcode[18]="VIOLET";									             
	   bgcolcode[19]="YELLOW";		
	   				 
      
	   bgcoltext[0]="Select";
	   bgcoltext[1]="Blue";       
	   bgcoltext[2]="Brown";      
	   bgcoltext[3]="Cyan";       
	   bgcoltext[4]="Dark Blue";  
	   bgcoltext[5]="Dark Cyan";  
	   bgcoltext[6]="Dark Green"; 
	   bgcoltext[7]="Dark Red";   
	   bgcoltext[8]="Green";      
	   bgcoltext[9]="Grey";       
	   bgcoltext[10]="Indigo";     
	   bgcoltext[11]="Light Blue"; 
	   bgcoltext[12]="Light Green";
	   bgcoltext[13]="Magenta";    
	   bgcoltext[14]="Orange";     
	   bgcoltext[15]="Pink";       
	   bgcoltext[16]="Purple";     
	   bgcoltext[17]="Red";        
	   bgcoltext[18]="Violet";     
	   bgcoltext[19]="Yellow";     
					     
	for(int i=0;i<bgcolcode.length;i++)
	{
    if(bgcolcode[i].equals(color_ind))
		
	{
		//bgcolcode[i]=bgcoltext[i];
		%> 
	<option value="<%=color_ind%>" selected ><%=bgcoltext[i]%></option>
	<%
	}else {
		%>
		<option value="<%=bgcolcode[i]%>"><%=bgcoltext[i]%></option> 
			  <%}
		

	}%>

  </select></td></tr>
  <tr>
      <td class='label' width="25%" >
	  <fmt:message key="eOT.TextColor.Label" bundle="${ot_labels}"/>
	  </td>
	<td class='fields' width="25%" >
	<select name="text_color" id="text_color">
	<%
	 if(txt_color.equalsIgnoreCase("WHITE")){%>
		<!-- <option value="">
			<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> 
		</option> -->
		<option value="WHITE" selected >
		 <fmt:message key="eOT.White.Label" bundle="${ot_labels}"/>
		</option>
		<option value="BLACK">
			<fmt:message key="eOT.Black.Label" bundle="${ot_labels}"/> 
		</option>
	 <%}else if(txt_color.equalsIgnoreCase("BLACK")){%>
		<!-- <option value="">
			<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> 
		</option> -->
		  <option value="BLACK" selected>
			  <fmt:message key="eOT.Black.Label" bundle="${ot_labels}"/> 
		  </option>
		  <option value="WHITE">
			<fmt:message key="eOT.White.Label" bundle="${ot_labels}"/>
		  </option>
	 <%}else{%>
		<!-- <option value="" selected>
			<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> 
		</option> -->
		  <option value="BLACK">
			  <fmt:message key="eOT.Black.Label" bundle="${ot_labels}"/> 
		  </option>
		  <option value="WHITE">
			<fmt:message key="eOT.White.Label" bundle="${ot_labels}"/>
		  </option>
	 <%}%>
    </select>
   </td>
</tr>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='status_code1' id='status_code1' value="<%=status_code%>">
<input type="hidden" name='status_desc_sysdef1' id='status_desc_sysdef1' value="<%=status_desc_sysdef%>">
<input type="hidden" name='status_desc1' id='status_desc1' value="<%=status_desc%>">
<input type="hidden" name='color_ind1' id='color_ind1' value="<%=color_ind%>">
<input type="hidden" name='text_color1' id='text_color1' value="<%=txt_color%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


