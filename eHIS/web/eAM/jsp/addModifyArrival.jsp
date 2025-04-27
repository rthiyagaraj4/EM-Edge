<!DOCTYPE html>
<%--
	FileName	: addModifyArrival.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

      <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
      	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
		

      	<script>
      	function change() { 
      	 if (arrival_form.eff_status.checked == true)
      	 	arrival_form.eff_status.value="E";
      	 else
      		arrival_form.eff_status.value="D";
      	}
      	
      	function changeCase(Obj)
	{
		Obj.value=Obj.value.toUpperCase();
	
	}
      	</script>
	 
      </head>

      <body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>


<%
   request.setCharacterEncoding("UTF-8");
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   String  arrivalcode="";
   String  transportmode="";
   String  transportdesc="";
   String longdesc="";
   String shortdesc="";
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   boolean newArrival=true;
   String sql="";
   String facilityid="";

   Connection conn=null;
   Statement stmt1=null;
   ResultSet rset1=null;
   Statement stmt=null;
   ResultSet rset=null;
   PreparedStatement pstmt1 = null;
   PreparedStatement pstmt = null;
   
%>	 
<%
	arrivalcode=request.getParameter("arrival_code");
	facilityid=(String)session.getValue("facility_id");
   	transportmode=request.getParameter("transportmode");
	 
	
	try{
	 conn = ConnectionManager.getConnection(request);
	try{ 
  
	if(arrivalcode==null || arrivalcode=="" || transportmode == null || transportmode==""){
		transportmode="";
		transportdesc="";
		arrivalcode="";
		longdesc="";
		shortdesc="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		
		checkBoxAttribute="CHECKED";
		newArrival=true;
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else{

			newArrival=false;
			String sql1 = "select * from am_arrival_vw where transport_mode=? and arrival_code=? ";
			
			pstmt1   = conn.prepareStatement(sql1);
			pstmt1.setString	(	1,	transportmode		);
			pstmt1.setString	(	2,	arrivalcode		);

			rset		 = pstmt1.executeQuery();
			
	    	if(rset.next())
	    	{
  		     transportdesc=rset.getString("trans_mode_short_desc");
			 longdesc=rset.getString("arrival_long_desc");
			 shortdesc=rset.getString("arrival_short_desc");
			 effstatus=rset.getString("eff_status");
			  if(effstatus.equals("D")){
			otherTextAttribute="READONLY";
			checkBoxAttribute="";
			codeTextAttribute="READONLY";
		     }else{

			otherTextAttribute="";
			codeTextAttribute="READONLY";
			checkBoxAttribute="CHECKED";
		   }
			}
           facilityid=(String)session.getValue("facility_id");
             if(rset!=null)rset.close();
			 if(pstmt1!=null)pstmt1.close();
			 
  
		stmt = conn.createStatement();

		sql = "select transport_mode,arrival_code,long_desc,short_desc,eff_date_from,eff_date_to,eff_status from am_arrival where arrival_code=? and facility_id=? and transport_mode=?";
		
		pstmt   = conn.prepareStatement(sql);
		pstmt.setString	(	1,	arrivalcode		);
		pstmt.setString	(	2,	facilityid		);
		pstmt.setString	(	3,	transportmode		);

		rset		 = pstmt.executeQuery();
		rset.next();
		arrivalcode=rset.getString("arrival_code");
		longdesc=rset.getString("long_desc");
		shortdesc=rset.getString("short_desc");

		effstatus=rset.getString("eff_status");
		newArrival=false;
		if(effstatus.equals("D")){
			otherTextAttribute="READONLY";
			checkBoxAttribute="";
			codeTextAttribute="READONLY";
		}else{

			otherTextAttribute="";
			
			checkBoxAttribute="CHECKED";
		
		codeTextAttribute="READONLY";
		newArrival=false;
		eventFunctionForCase="";
	}	
	}

	     }catch(Exception e){
			e.toString();
	     }
	     finally{
	     	if(stmt!=null) 	stmt.close();
	     	if(rset!=null) 	rset.close();
	     }

%>	  

		 
      	<form name='arrival_form' id='arrival_form' action='../../servlet/eAM.ArrivalServlet' method='post' target='messageFrame'>
      	<div  align='left'>
      	<br><br><br> <BR><BR><BR>

      	<table border='0' cellpadding='0' cellspacing='0' align='center' >

		<tr>
	        <td width='10%'>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td width='10%'>&nbsp;</td>
	</tr>

	<tr>
<%
	      if(newArrival==true)
	      {

%>
	      <td>&nbsp;</td>
	      <td class="label" ><fmt:message key="Common.TransportMode.label" bundle="${common_labels}"/></td> 
	      <td colspan="2" class='fields'>&nbsp;&nbsp; <select name="transportmode" id="transportmode" >
	      <OPTION VALUE=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----


<%
  	    //con = (Connection) session.getValue( "connection" );
      	    stmt1 = conn.createStatement();

	    rset1 = stmt1.executeQuery( "SELECT TRANSPORT_MODE, SHORT_DESC FROM AM_TRANSPORT_MODE WHERE EFF_STATUS='E' AND PATIENT_RELATED_YN = 'Y' ORDER BY 2");
try
{
	    if( rset1 != null )
	    {
	         while( rset1.next() )
		 {
		     String transportmode1 = rset1.getString( "transport_mode" ) ;
		     String transportdesc1 = rset1.getString( "short_desc" ) ;


			if ( transportmode1.equals( transportmode ) )
			 out.println( "<option value='" + transportmode1 + "'> "+ transportdesc1);
			else
			     out.println( "<option value='" + transportmode1 + "' >" + transportdesc1 ) ;
		 }
	    }
			if(rset1!=null)rset1.close();
			if(stmt1!=null)stmt1.close();
}
catch(Exception e)
{
out.println("here");
}
finally
{


}

	      }
	      else
	      {

%>
		<td>&nbsp;</td>
		<td   class="label" ><fmt:message key="Common.TransportMode.label" bundle="${common_labels}"/></td>
		<td colspan="2" class='fields'>&nbsp;
<%
		out.println("<input type='hidden' name='transportmode' id='transportmode' value='" + transportmode + "' >") ;
		out.println("<input type='text' name='transportdesc' id='transportdesc' value=\"" + transportdesc + "\" size='15'maxlength='15' readonly>") ;
		}

%>
   	    </select>
   	    <img src='../../eCommon/images/mandatory.gif'align='center'></img>

      	<tr>
      	<td width='10%'>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td width='10%'>&nbsp;</td>
	</tr>

      		<tr>
      			<td>&nbsp;</td>
      		    <td  class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td><!--width='40%' -->
      		    <td class='fields'>&nbsp;&nbsp;<!--width='60%' colspan='2'-->
      		    <input type='text' onKeyPress="return CheckForSpecChars(event)"  onBlur="makeValidString(this);changeCase(this)"  name='arrival_code' id='arrival_code' value="<%=arrivalcode%>" size='2' maxlength='2' <%=codeTextAttribute%> <%=eventFunctionForCase%>>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
	      		<td>&nbsp;</td>
      		</tr>

      		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

      		<tr>
	      		<td>&nbsp;</td>
      		    <td   class=label><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td><!--width='40%' -->
      		    <td class='fields'>&nbsp;&nbsp;<!--width='60%' colspan='2'-->
      		    <input type='text' onBlur="makeValidString(this)" name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=longdesc%>" <%=otherTextAttribute%> >
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		    <td>&nbsp;</td>
      		</tr>

      		<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>

      		<tr>
	      		<td>&nbsp;</td>
      		    <td   class=label><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td><!--width='40%' -->
		    	<td class='fields'>&nbsp;&nbsp;<!--width='60%' colspan='2'-->
		    	<input type='text' name='short_desc' id='short_desc' size='15' maxlength='15'  onBlur="makeValidString(this)" value="<%=shortdesc%>" <%=otherTextAttribute%> >
		    	<img src='../../eCommon/images/mandatory.gif'></img></td>
				<td>&nbsp;</td>
      		</tr>

      		<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
		</tr>

      		<tr>
	      		<td>&nbsp;</td>
      		     <td  class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td><!--width='40%' -->
      		     <td class='fields'>&nbsp;&nbsp;<!--width='60%' colspan='2' -->
      		     <input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()"></td>
				<td>&nbsp;</td>
      		</tr>

      		<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>

      	</table>
      	</div>
		<input type='hidden' name='facility_id' id='facility_id' value='facilityid'>
		<%  if(newArrival){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}
	 }catch(Exception e)
	 {}
	 finally
	 {
		 ConnectionManager.returnConnection(conn,request);
	 }%>

      	</form>
		
      	</body>
      	</html>

