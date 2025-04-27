<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	
<%
	
	String function_code = request.getParameter("function_code");
	String Function		= request.getParameter("Function");
	String facility_id=(String)session.getValue("facility_id");
	
	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;

	String nursing_unit_type="";
	String age_group="";
	String department="";
	String service="";
	String nursing_unit_short_desc="", pract_type_desc="", primary_speciality_code="", practitioner_name="";
	String sql="";
	int count = 0;

	try
	{
		con = ConnectionManager.getConnection(request);
		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
		stmt= con.createStatement();	
		
		/*if(Function.equals("nurs"))
		{
			sql_check="Select count(*) from ip_nursing_unit "+
			"where upper(nursing_unit_code)=upper('"+function_code+"') and "+
			"facility_id='"+facility_id+"' and eff_status = 'E' ";
		}
		else if(Function.equals("pract"))
		{
			sql_check="Select count(*) from am_pract_for_facility "+
			"where upper(practitioner_id)=upper('"+function_code+"') and "+
			"facility_id='"+facility_id+"' and eff_status='E' ";
		}
		ResultSet rs_check=stmt.executeQuery(sql_check);
		rs_check.next();
		int count=rs_check.getInt(1);

		if(rs_check!=null)rs_check.close();
		if(stmt!=null)stmt.close();
		*/

		//if(count==0) 
		//{%>
			<!--<script>
			if('<%=Function%>' == "nurs")
				alert(getMessage("INVALID_NURSING_UNIT","IP"));
			else if('<%=Function%>' == "pract")
				alert(getMessage("PRACT_NOT_ATT_TO_FACILITY","IP"));

			parent.frames[1].frames[1].document.getElementById('search_button').disabled=true;
			parent.frames[1].frames[1].document.getElementById('tab').style.visibility='hidden';
			if('<%=Function%>' == "nurs") 
				parent.frames[1].frames[1].document.getElementById('td5').innerHTML = "<input type=text name=function_code id=function_code size=4 maxlength=4 onblur='PopulateValues(this)'><input type=button class=button name='search_nurs_unit' id='search_nurs_unit' value='?' onclick='showmodal()'>";
			else if('<%=Function%>' == "pract")

			parent.frames[1].frames[2].location.href="../../eCommon/html/blank.html";
			parent.frames[1].frames[3].location.href="../../eCommon/html/blank.html";
		</script>-->
		<%//}
		//else
		//{	
			if(Function.equals("nurs"))
			{
				sql="Select NURSING_UNIT_TYPE_SHORT_DESC, AGE_GROUP_SHORT_DESC, DEPT_SHORT_DESC,"+
				"SERVICE_SHORT_DESC,NURSING_UNIT_SHORT_DESC  from IP_NURSING_UNIT_VW "+
				"where nursing_unit_code='"+function_code+"' and facility_id='"+facility_id+"' "+
				"and eff_status = 'E' ";
			}
			else if(Function.equals("pract"))
			{
				sql="Select PRACT_TYPE_DESC, SHORT_DESC , PRACTITIONER_NAME, PRIMARY_SPECIALITY_CODE "+
				"from am_pract_for_facility_vw A, AM_SPECIALITY B  "+
				"where PRACTITIONER_ID='"+function_code+"' and operating_facility_id='"+facility_id+"' "+
				"AND A.PRIMARY_SPECIALITY_CODE=B.SPECIALITY_CODE and a.eff_status = 'E' ";

			}

			stmt= con.createStatement();	
			rs = stmt.executeQuery(sql) ;
			if(rs!=null)
			{
					while (rs.next())
					{
						if(Function.equals("nurs"))
						{
							nursing_unit_type = rs.getString(1);	
							if(nursing_unit_type==null) nursing_unit_type="";
				 
							age_group = rs.getString(2);
							if(age_group==null) age_group="";
				 
							department = rs.getString(3);	
							if(department==null) department="";

							service = rs.getString(4);	
			
							nursing_unit_short_desc=rs.getString(5);
							if(nursing_unit_short_desc==null) nursing_unit_short_desc="";
							%>

							<script>
							/*parent.frames[1].frames[1].document.getElementById('search_button').disabled=false;*/
							
							parent.frames[1].frames[1].document.getElementById('tab').style.visibility='visible';
							parent.frames[1].frames[2].location.href="../../eCommon/html/blank.html";
							parent.frames[1].frames[3].location.href="../../eCommon/html/blank.html";
							parent.frames[1].frames[1].document.getElementById('td1').innerHTML="<b><%=nursing_unit_type%></b>";
							parent.frames[1].frames[1].document.getElementById('td2').innerHTML="<b><%=age_group%></b>";
							parent.frames[1].frames[1].document.getElementById('td3').innerHTML="<b><%=department%></b>";
							parent.frames[1].frames[1].document.getElementById('td4').innerHTML="<b><%=service%></b>";
					
							if(parent.frames[1].frames[1].document.getElementById('td5').innerHTML.lastIndexOf("<B>") != -1)
							{
								parent.frames[1].frames[1].document.getElementById('td5').innerHTML = parent.frames[1].frames[1].document.getElementById('td5').innerHTML.substring(0,parent.frames[1].frames[1].document.getElementById('td5').innerHTML.lastIndexOf("<B>"));
							}
							else
							{
							}
							parent.frames[1].frames[1].document.forms[0].search_button.focus();
							</script>
							<%
						}
						else if(Function.equals("pract"))
						{
							pract_type_desc = rs.getString(1);
							if(pract_type_desc == null)pract_type_desc="";
							primary_speciality_code = rs.getString(2);
							if(primary_speciality_code == null)primary_speciality_code="";
							practitioner_name = rs.getString(3);
							if(practitioner_name == null)practitioner_name="";

						%>	
							<script>
							//parent.frames[1].frames[1].document.getElementById('search_button').disabled=false;
							parent.frames[1].frames[1].document.getElementById('tab').style.visibility='visible';	
							parent.frames[1].frames[2].location.href="../../eCommon/html/blank.html";
							parent.frames[1].frames[3].location.href="../../eCommon/html/blank.html";
							parent.frames[1].frames[1].document.getElementById('td1').innerHTML="<b><%=pract_type_desc%></b>";
							parent.frames[1].frames[1].document.getElementById('td2').innerHTML="<b><%=primary_speciality_code%></b>";
							
							
					
							if(parent.frames[1].frames[1].document.getElementById('td5').innerHTML.lastIndexOf("<B>") != -1)
							{
								parent.frames[1].frames[1].document.getElementById('td5').innerHTML = parent.frames[1].frames[1].document.getElementById('td5').innerHTML.substring(0,parent.frames[1].frames[1].document.getElementById('td5').innerHTML.lastIndexOf("<B>"));
						}
						else
						{
						}
						parent.frames[1].frames[1].document.forms[0].search_button.focus();
						</script>

						<%
						}

						count++;
															
					}
				}

				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();

				if(count==0) 
				{%>
					<script>
					if('<%=Function%>' == "nurs")
						alert(getMessage("INVALID_NURSING_UNIT","IP"));
					else if('<%=Function%>' == "pract")
						alert(getMessage("PRACT_NOT_ATT_TO_FACILITY","IP"));

					parent.frames[1].frames[1].document.getElementById('search_button').disabled=true;
					parent.frames[1].frames[1].document.getElementById('tab').style.visibility='hidden';
					if('<%=Function%>' == "nurs") 
						parent.frames[1].frames[1].document.getElementById('td5').innerHTML = "<input type=text name=function_code id=function_code size=4 maxlength=4 onblur='PopulateValues(this)'><input type=button class=button name='search_nurs_unit' id='search_nurs_unit' value='?' onclick='showmodal()'>";
					else if('<%=Function%>' == "pract")

					parent.frames[1].frames[2].location.href="../../eCommon/html/blank.html";
					parent.frames[1].frames[3].location.href="../../eCommon/html/blank.html";
				</script>
				<%}
			//}
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		ConnectionManager.returnConnection(con,request); 
	}
	out.println("</script></head><body CLASS='MESSAGE' onKeyDown='lockKey()' ></body></html>");		
	
%>	


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

