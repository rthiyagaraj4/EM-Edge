<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<!-- This form is used to Insert/Delete from Patient Type Class -->
     <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
      	<script src='../../eAM/js/PatTypeClass.js' language='JavaScript'></script>
     </head>
     <body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>
      	<form name='pattypeclass_form' id='pattypeclass_form' action='../../servlet/eAM.PatTypeClassServlet' method='post' target='messageFrame'>
      		<div align='left'>
      		<center>
      		<BR>
      		<BR>
      		<BR>
      		<BR>
      		<BR>
      		<BR>
      		<BR>
      			<table border='0' cellpadding='0' cellspacing='0' width='80%'>
      			<tr>
				<td>
					&nbsp;
				</td>
      				<td>
      					&nbsp;
      				</td>
      			</tr>
      				<tr><td align='right' width='30%' class='label'><fmt:message key="Common.patienttype.label" bundle="${common_labels}"/></td><td width='50%' colspan='2'>&nbsp;

				<%
					request.setCharacterEncoding("UTF-8");
					String patienttype="";
					//String patientclass="";
					//String codeTextAttribute="";
					//String otherTextAttribute="";
					//String eventFunctionForCase="";
					boolean newPatientTypeClass=false;
					//String sql="";
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs=null;
				%>
				<%
					patienttype=request.getParameter("patient_type");

					if(patienttype == null ) patienttype= "";
					
					//codeTextAttribute="";
					//otherTextAttribute="";
					newPatientTypeClass=true;
					out.println("&nbsp;<select name='patient_type' id='patient_type' onChange='RemoveAll()'>&nbsp;<option value=''>--------------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------------</option>");
					
					try{
                    con = ConnectionManager.getConnection(request);
					pstmt 	= con.prepareStatement( "select patient_type,short_desc from am_patient_type where eff_status='E' order by short_desc" ) ;
					rs = pstmt.executeQuery() ;
					if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_type" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							if (patienttype == null || patienttype=="")
							{
							
								out.println( "<option value=\"" + Value + "\" >" + Label ) ;
							}	
							else
							{								
								if( patienttype.equals(Value))
									out.println( "<option selected value=\"" + Value + "\" >" + Label );
								else
									out.println( "<option  value=\"" + Value + "\" >" + Label );
							}	
						}
					}
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();

					out.println("</select> <img src='../../eCommon/images/mandatory.gif'></img>");
					out.println("</td></tr>");
					%>
				<tr>
					<td>
						&nbsp;
				    	</td>
      					<td>
      						&nbsp;
      					</td>
      				</tr>
					<%
					out.println("<table width='80%' cell padding='0' cellspacing='0' border='0' bordercolor='lavender'><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.AvailableClasses.label","am_labels")+"</th><th>&nbsp;</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.SelectedClasses.label","am_labels")+"</th><tr><td width='40%' align='center'><select name='available_patient_class' id='available_patient_class' size='10' style='width: 125px' >");


					if (patienttype != null && patienttype!="")
					{
						pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class not in (select patient_class from am_patient_type_class where patient_type =?) order by short_desc" ) ;
						pstmt.setString	(	1,	patienttype		);
						rs = pstmt.executeQuery() ;
						if( rs != null )
						{
							while( rs.next() )
							{
								String Value 	= rs.getString( "patient_class" ) ;
								String Label 	= rs.getString( "short_desc" ) ;
								out.println( "<option value=\"" + Value + "\" >" + Label + "</option>") ;
							}
						}
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();
					}
					out.println("</select></td>");
					out.println("<td align='center' width='10%'><input type='button' name='add' id='add' class='button' onclick='addOptiontoSelection()'  value='---->'><br><input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOptionfromSelection()'></img></td>");
					out.println("<td width='40%' align='center'><select name='selected_patient_class' id='selected_patient_class' size='10' multiple='true' style='width: 125px' >");
					//out.println("<option value = '' >XXXXXXXXXXXXXXX </option>");

					if (patienttype != null && patienttype!="")
					{
						pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class in (select patient_class from am_patient_type_class where patient_type =? ) order by short_desc" ) ;
						pstmt.setString	(	1,	patienttype		);
						rs = pstmt.executeQuery() ;
							if( rs != null )
						{
							while( rs.next() )
							{
								String Value 	= rs.getString( "patient_class" ) ;
								String Label 	= rs.getString( "short_desc" ) ;
								out.println( "<option value=\"" + Value + "\" >" + Label + "</option>") ;
							}
						}
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();
					}
					out.println("</select></td></tr></table>");
					}
					catch(Exception e) { e.printStackTrace();}
					finally {
					  if (rs != null)   rs.close();
					  if (pstmt != null) pstmt.close();
					  ConnectionManager.returnConnection(con,request);
					  
					}



				/*
					out.println("<tr><td width='60%' colspan='2'>&nbsp;&nbsp;<select name='available_patient_class' id='available_patient_class'>
					pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class not in (select patient_class from am_patient_type_class where patient_type =?) order by short_desc" ) ;
					pstmt.setString	(	1,	patienttype		);
					rs = pstmt.executeQuery() ;
						if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_class" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							out.println( "<option value=\"" + Value + "\" >" + Label +"</option>") ;
						}
					}
						pstmt.close() ;
					out.println("</select></td>");

					out.println("<td width='40%' colspan='2'>&nbsp;&nbsp;<select name='selected_patient_class' id='selected_patient_class'>
					pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class in (select patient_class from am_patient_type_class where patient_type =?) order by short_desc" ) ;
					pstmt.setString	(	1,	patienttype		);
					rs = pstmt.executeQuery() ;
						if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_class" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							out.println( "<option value=\"" + Value + "\" >" + Label ) ;
						}
					}
						pstmt.close() ;
					out.println("</select></td></tr>");

				}
				else
				{
					pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class not in (select patient_class from am_patient_type_class where patient_type = '"+patienttype+"') order by short_desc" ) ;
					rs = pstmt.executeQuery() ;
						if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_class" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							out.println( "<option value=\"" + Value + "\" >" + Label + "</option>") ;
						}
					}
						pstmt.close() ;
					out.println("</select></td>");
					out.println("<td align='center' width='10%'><input type='button' name='add' id='add' class='button' onclick='addOptiontoSelection()' value='---->'><input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOptionfromSelection()'></td>");
					out.println("<td width='45%' align='center'><select name='selected_patient_class' id='selected_patient_class' size='10' multiple='true'>");

					pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class in (select patient_class from am_patient_type_class where patient_type =?) order by short_desc" ) ;
					pstmt.setString	(	1,	patienttype		);
					rs = pstmt.executeQuery() ;
					if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_class" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							out.println( "<option value=\"" + Value + "\" >" + Label + "</option>") ;
						}
					}
					pstmt.close() ;
					out.println("</select></td></tr></table>");
					out.println("<tr><td width='60%' colspan='2'>&nbsp;&nbsp;<select name='available_patient_class' id='available_patient_class'>
					pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class not in (select patient_class from am_patient_type_class where patient_type =?) order by short_desc" ) ;
					pstmt.setString	(	1,	patienttype		);
					rs = pstmt.executeQuery() ;
					if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_class" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							out.println( "<option value=\"" + Value + "\" >" + Label +"</option>") ;
						}
					}

					pstmt.close() ;
					out.println("</select></td>");

					out.println("<td width='40%' colspan='2'>&nbsp;&nbsp;<select name='selected_patient_class' id='selected_patient_class'>
					pstmt 	= con.prepareStatement( "select patient_class,short_desc from am_patient_class where patient_class in (select patient_class from am_patient_type_class where patient_type =?) order by short_desc" ) ;
					pstmt.setString	(	1,	patienttype		);
					rs = pstmt.executeQuery() ;
					if( rs != null )
					{
						while( rs.next() )
						{
							String Value 	= rs.getString( "patient_class" ) ;
							String Label 	= rs.getString( "short_desc" ) ;
							out.println( "<option value=\"" + Value + "\" >" + Label ) ;
						}
					}

					pstmt.close() ;
					out.println("</select></td></tr>");
				}*/

				%>
				<tr>
				      	<td>
				      		&nbsp;
				      	</td>
				      	<td>
						 		&nbsp;
				      	</td>
      			</tr>
      				<tr>
								      	<td>
								      		&nbsp;
								      	</td>
								      	<td>
										 		&nbsp;
								      	</td>
      			</tr>
			</table>
		</div>
      		</center>
		<%  if(newPatientTypeClass){%>

		<input type='hidden' name='function' id='function' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>

		<%}else{%>

		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
		<%}%>
	</form>
     </body>
</html>

