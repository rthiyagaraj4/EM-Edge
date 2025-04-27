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
 <script src='../../eCommon/js/common.js' language='javascript'></script>
 <script language='javascript' src='../../eMO/js/MOMortuaryArea.js'></script> 
 <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
 <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 

<%	
     Connection con 			= null;
	 PreparedStatement pstmt	= null;
	 ResultSet rset				= null;
	 request.setCharacterEncoding("UTF-8");

	 String	facilityId 			= (String) session.getValue( "facility_id" ) ;
	// String locale              = (String)session.getAttribute("LOCALE");
	 String mode				= "";
	 
  try
  {
     con							= ConnectionManager.getConnection(request);
	 
	 String area_code_value			     = "";
	 String long_desc					 = "";              
	 String	short_desc				     = "";   
	 String eff_status				     = "";				
	 String Capacity				     = "";		
	 int capacitycount				     = 0;		
	 String postmortem_area_yn			 = "";				
	 String release_area_yn				 = "";				
	 String checkBoxAttribute2		     = "";
	 String disabledField1				 = "";
	 String readOnlyAttribute			 = "";
	 String readOnlyAttribute1			 = "";
	 String AREA_TYPE					 = "";
	 StringBuffer sql=new StringBuffer();

	 mode					                 = "INSERT";
	 String area_code1                       = "";
	 area_code1                                 = request.getParameter("area_code");
     if(!(area_code1 == null))
	 {
	      sql.setLength(0);
 	      sql.append("select AREA_CODE,LONG_DESC,SHORT_DESC,CAPACITY,AREA_TYPE,EFF_STATUS from MO_AREA where AREA_CODE=? and facility_id = ?");		 	
    	  pstmt   = con.prepareStatement(sql.toString());
		  pstmt.setString(1,area_code1) ;
		  pstmt.setString(2,facilityId) ;
		  rset = pstmt.executeQuery();
	      sql.setLength(0);   
		 while(rset!=null && rset.next())
		 {  
			area_code_value			= rset.getString("AREA_CODE");    
			area_code_value 		= (area_code_value == null)?"":area_code_value;

			long_desc				= rset.getString("LONG_DESC");
			long_desc 				= (long_desc == null)?"":long_desc;

			short_desc				= rset.getString("SHORT_DESC");
			short_desc 				= (short_desc == null)?"":short_desc;

			Capacity				= rset.getString("CAPACITY");
			Capacity				= (Capacity == null)?"":Capacity;

			AREA_TYPE		= rset.getString("AREA_TYPE");
			
			AREA_TYPE				= (AREA_TYPE == null)?"":AREA_TYPE;


			eff_status				= rset.getString("EFF_STATUS");
		
			if(eff_status!=null && eff_status.equalsIgnoreCase("E"))
			{
					checkBoxAttribute2  = "CHECKED";
			}
			else
		    {
				    readOnlyAttribute	= "READONLY";
			}
			mode						= "MODIFY";
	     }
        if(rset!=null)  rset.close();
	     if(pstmt!=null)  pstmt.close();
		  sql.setLength(0);
 	      sql.append("select count(*) cnt from mo_bed_for_area where AREA_CODE=? and facility_id = ?");
    	  pstmt   = con.prepareStatement(sql.toString());
		  pstmt.setString(1,area_code1) ;
		  pstmt.setString(2,facilityId) ;
		  rset = pstmt.executeQuery();
		 while(rset.next())
		 {
		 capacitycount=rset.getInt("cnt");
		 }		
	     if(rset!=null)  rset.close();
	     if(pstmt!=null)  pstmt.close();
		 
      }
      else
     {
	  area_code_value = "";
	  long_desc	= "";
	  short_desc = "";
	  Capacity	= "";
	 }
  
     if(mode.equalsIgnoreCase("INSERT"))
	 {
		  checkBoxAttribute2 = "CHECKED";
		  disabledField1 = "";
	 } 
    else
	{
		   disabledField1	  = "DISABLED";
		   readOnlyAttribute1 = "READONLY";
		   //disabledFields	  = "DISABLED"; 	
	}

	if(!(release_area_yn.equals("Y")))
		if(!(postmortem_area_yn.equals("Y")))
	  {
		
	  }
   %>
	  
   <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'onLoad="FocusFirstElement();setarea('<%=mode%>');">
	 <form name="MortuaryArea_form" id="MortuaryArea_form" action="../../servlet/eMO.MOMortuaryAreaServlet" method="post" target="messageFrame">
 <input type='hidden' name='AREA_TYPE' id='AREA_TYPE' value='<%=AREA_TYPE%>' >	 

 <input type='hidden' name='mode' id='mode' value='<%=mode%>' >	 
<br><br><br><br><br><br>

	<table cellspacing='0' cellpadding='3' align="center" width="80%" border="0">	
	
	<tr>
		<td class="label" width="50%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='fields' width="50%">
			<input type="text" name="area_code" id="area_code" size="4" maxlength="4" value='<%=area_code_value%>'  <%=readOnlyAttribute1%>  onKeyPress="return CheckForSpecChars(event)" OnBlur='ChangeUpperCase(this)'><img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>	

	<tr>
		<td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="long_desc" id="long_desc" size="40" maxlength="40" value="<%=long_desc%>"<%=readOnlyAttribute%>  	         onBlur="makeValidString(this)"><img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>	
	<tr>
		<td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" value="<%=short_desc%>" <%=readOnlyAttribute%>  onBlur="makeValidString(this)"><img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="eMO.Capacity.label" bundle="${mo_labels}"/></td>
		<td class='fields'><input type="text" name="Capacity" id="Capacity" value="<%=Capacity%>" <%=readOnlyAttribute%> size="3" maxlength="2" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='checkzero(this)'><img align="center" src="../../eCommon/images/mandatory.gif"></img>
				</td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="eMO.AreaType.label" bundle="${mo_labels}"/></td>
		<td class='fields'><select name='Area_Type' id='Area_Type' <%=disabledField1%>>
		<option value='P'><fmt:message key="eMO.PostmortemArea.label" bundle="${mo_labels}"/></option>
		<option value='R'><fmt:message key="eMO.ReleaseArea.label" bundle="${mo_labels}"/></option>
		<option value='S'><fmt:message key="eMO.StorageArea.label" bundle="${mo_labels}"/></option>
		<option value='O'><fmt:message key="Common.others.label" bundle="${common_labels}"/></option>		
	</td>
	</tr>
		<%if(AREA_TYPE.equals("R"))
		{
	
		%><script>document.forms[0].Area_Type.options[1].selected = true;
		</script><%
		}
		else if(AREA_TYPE.equals("S"))
		{
			
		%><script>document.forms[0].Area_Type.options[2].selected = true;
		</script><%
		}
		else if(AREA_TYPE.equals("P"))
		{
		
			%><script>document.forms[0].Area_Type.options[0].selected = true;
		</script><%
		}
		else if(AREA_TYPE.equals("O"))
		{
		
			%><script>document.forms[0].Area_Type.options[3].selected = true;
		</script><%
		}
%>
	


	<tr>
		<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="checkbox" name="eff_status" id="eff_status" value='<%=eff_status%>' <%=checkBoxAttribute2%>  onClick='chkValue(this);'></td>
	</tr>		
	</table>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>' >	
			<input type='hidden' name='area_code_val' id='area_code_val' value='<%=area_code_value%>' >	 	
			<input type='hidden' name='long_desc_val' id='long_desc_val' value='<%=long_desc%>' >	 	
			<input type='hidden' name='short_desc_val' id='short_desc_val' value='<%=short_desc%>' >	
			<input type='hidden' name='Capacity_val' id='Capacity_val' value='<%=Capacity%>' >
			<input type='hidden' name='capacitycount' id='capacitycount' value='<%=capacitycount%>' >		
			<input type='hidden' name='eff_status_val' id='eff_status_val' value='' >	
			<input type='hidden' name='facility_id' id='facility_id' value='<%=facilityId%>' >	 
   </form>
     <%
         if(mode.equals("INSERT"))
	 	out.println("<script>document.forms[0].eff_status.value='E';</script>");
	  %>
</body>
	<% } catch(Exception e){
		  out.println(e.toString());
		  e.printStackTrace();}
   finally
    {
        if(rset!=null) rset.close(); 
    	if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con,request);
    }
%>
</html>


								

