<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eAE/js/PatientPriority.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
  <%	 
	 request.setCharacterEncoding("UTF-8");
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 
     Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 String mode						= "";
     String priority_code_result		= request.getParameter("priority_code");
	 /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
	 String locale		    = (String)session.getAttribute("LOCALE");
	 String color                   ="";
	 String green                   = "";
	 String red                     ="";
	 String yellow                  ="";
	 String unassigned              ="";
	 /* CRF  SKR-CRF-0021 [IN028173] end  */
	  
		 priority_code_result			= (priority_code_result == null)?"":priority_code_result;
  try
  {
     con								= ConnectionManager.getConnection(request);
	 String priority_code				= "";
	 String long_desc					= "";
	 String short_desc					= "";
	 String priority_no					= "";
	 String priority_zone				= "";
	 String eff_status					= "";
	 String optSelected					= "";//Added By Shanmukh for MMS-DM-CRF-0147
	 String checkBoxAttribute			= "";
 	 String readOnlyAttribute			= "";
	 String readOnlyAttribute1			= "";
	 String disabledField				= "";
		mode							= "INSERT";
   
    String sql = "select * from AE_PAT_PRIORITY where priority_code	 = ? ";
 if(!(priority_code_result.equals("")))
  {
	pstmt   = con.prepareStatement(sql);
	pstmt.setString(1,priority_code_result) ;
 	rset = pstmt.executeQuery();
	
/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
		      green                = request.getParameter("green");
		      red                  = request.getParameter("red");
			  yellow               = request.getParameter("yellow");
			  unassigned           = request.getParameter("unassigned");
           
			
			
/* CRF  SKR-CRF-0021 [IN028173] end  */
	
	 while(rset!=null && rset.next())
	  {
	 		priority_code				= rset.getString("PRIORITY_CODE");    
			priority_code 				= (priority_code == null)?"":priority_code;
			long_desc					= rset.getString("LONG_DESC");
			long_desc 					= (long_desc == null)?"":long_desc;
			short_desc					= rset.getString("short_desc");
			short_desc 					= (short_desc == null)?"":short_desc;
			priority_no					= rset.getString("PRIORITY_NO");
			priority_no 				= (priority_no == null)?"":priority_no;
			priority_zone				= rset.getString("PRIORITY_ZONE");
			priority_zone				= (priority_zone == null)?"":priority_zone;
			
			
			
				
			eff_status					= rset.getString("EFF_STATUS");
			if(eff_status!=null && eff_status.equalsIgnoreCase("E"))
			{
					checkBoxAttribute   = "CHECKED";
			}
			else
		    {
					disabledField		 = "DISABLED";
					readOnlyAttribute	 = "READONLY";
	   	    }
			mode						 = "MODIFY";
			readOnlyAttribute1			 = "READONLY";
	  }
	  

	  if(rset!=null)  rset.close();
	  if(pstmt!=null)  pstmt.close();
  } // end of if priority_code_result	  
	  if(mode.equalsIgnoreCase("INSERT"))
		  checkBoxAttribute = "CHECKED";
   %>

	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="patient_priority" id="patient_priority" action="../../servlet/eAE.PatientPriorityServlet" method="post" target="messageFrame">
	 <table border="0" cellpadding="3" cellspacing="0" align='center' width='70%'>
		 <br><br><br>
	    <tr>
		   <td colspan='2' height='5'></td>
		</tr>
	    <tr>
		      <td class='label'  width='50%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='priority_code' id='priority_code' value='<%=priority_code%>' maxLength='2' size='2' <%=readOnlyAttribute1%> onBlur='changeCase(this);' onKeyPress="return CheckForSpecChars(event)">
   		      <img src='../../eCommon/images/mandatory.gif' ></img>
			  </td> 	
	    </tr>	
		<tr>
		   <td colspan='2'></td>
		</tr>
		
		<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='long_desc' id='long_desc' value="<%=long_desc%>" maxLength='30' size='30' <%=readOnlyAttribute%> onBlur="makeValidString(this)">
			  <img src='../../eCommon/images/mandatory.gif' ></img>
              </td>
        </tr>
		<tr>
		   <td colspan='2'></td>
		</tr>
		<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='text' name='short_desc' id='short_desc' value="<%=short_desc%>" maxLength='15' size='15' <%=readOnlyAttribute%> onBlur="makeValidString(this)">
 		      <img src='../../eCommon/images/mandatory.gif' ></img>
              </td>
        </tr>
		<tr>
		   <td colspan='2'></td>
		</tr>
		<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
		
			 <td class='field'  width='50%'><select name='priority_zone1' id='priority_zone1' <%=disabledField%>>
			 <option value=''>&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;
			  	<%
				/* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
				//if (mode.equals("INSERT"))
				//{
				
				 try{  
	             
	            sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' and PRIORITY_ZONE not in ('B','W') order by PRIORITY_ZONE_ORDER ";
				pstmt    = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
				 
				 /* color      =rset.getString("PRIORITY_ZONE");
				 if (color.equals("G")) {green=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("R")){red=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("Y")){yellow=rset.getString("PRIORITY_ZONE_DESC");}
				 if (color.equals("U")){unassigned=rset.getString("PRIORITY_ZONE_DESC");}*/
				 
				 //Added By Shanmukh for MMS-DM-CRF-0147
				
				
			    if(priority_zone.equals(rset.getString(1)))
							out.println("<option value='"+rset.getString(1)+"' selected>");	
							else
				            out.println("<option value='"+rset.getString(1)+"'>");	     
							out.println(rset.getString(2));
							out.println("</option>"); 
				}
		    
		
				
				
	        }catch(Exception e)
	        {
	        e.printStackTrace();
	        }
			//}
				/* CRF  SKR-CRF-0021 [IN028173] end  */
				%>
				
				<!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->
			<!--  <%if(priority_no.equals("1"))
	          {
              %>  <option value=''>&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;
			     <option value='2'><%=green%>
                 <option value='1' selected><%=red%>
				 <option value='3'><%=yellow%>
                 <option value='4'><%=unassigned%>
			 <% } else if(priority_no.equals("2")){%>
				 <option value=''>&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;
				 <option value='2' selected><%=green%>
				 <option value='1'><%=red%>
				 <option value='3'><%=yellow%>
                 <option value='4'><%=unassigned%>
				 
              <% } else if(priority_no.equals("3")) { %>
				  <option value=''>&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;
			  	 <option value='2'><%=green%>
			     <option value='1'><%=red%>
				 <option value='3' selected><%=yellow%>
                 <option value='4'><%=unassigned%>
 		       <% } else if(priority_no.equals("4")) { %>
				  <option value=''>&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;
			      <option value='1'><%=green%>
				  <option value='2'><%=red%>
				  <option value='3'><%=yellow%>
				  <option value='4' selected><%=unassigned%>
 		      <% }else {%>
				 <option value=''selected>&nbsp;----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----&nbsp;
			     <option value='2'><%=green%>
			     <option value='1'><%=red%>
				 <option value='3'><%=yellow%>
                 <option value='4'><%=unassigned%>
				
				<% } %>-->
			  </select>
 		      <!--CRF  SKR-CRF-0021 [IN028173] end-->
		
			
			  <img src='../../eCommon/images/mandatory.gif' ></img>
              </td>
        </tr>
		<tr>
		   <td colspan='2'></td>
		</tr>
		<tr>
		      <td class='label'  width='50%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		      <td class='field'  width='50%'><input type='checkbox' name='eff_status' id='eff_status' value='<%=eff_status%>' <%=checkBoxAttribute%>  onClick='chkValue(this);'>
              </td>
        </tr>
		<tr>
		   <td colspan='2' height='5'></td>
		</tr>
	    
	 </table> 
		     <input type='hidden' name='mode' id='mode' value='<%=mode%>' >	
		     <input type='hidden' name='priority_zone' id='priority_zone' value='' >	
			  
		 
	 </form>
		  <%
                if(mode.equals("INSERT"))
				out.println("<script>document.forms[0].eff_status.value='E';document.forms[0].priority_code.focus();</script>");
				else
				out.println("<script>document.forms[0].long_desc.focus();</script>");
		 %>
    </body>
 
<% 
if(rset!=null) rset.close();
if(pstmt!=null) pstmt.close();

} catch(Exception e){e.printStackTrace();}
   finally
    {
    	if(con!=null)		
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

