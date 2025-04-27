<!DOCTYPE html>
<%
/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	Lodger -> CheckOutLodger && Lodger -> RenewGatePass
/// Developer		:	SRIDHAR R
/// Created On		:	26 APR 2004
/// Function		:	This Page is called for validating the Maximum Renewal Period for the Renew Gate Pass Function. It will add the no of Days/Hours to the Renew period from & return the value.
%>

<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" %>
<jsp:useBean id="obj" scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%

Connection conn = null; 
ResultSet rs	= null;
Statement stmt	= null;
Statement stmt_loc1	= null;
ResultSet rset	= null;
ResultSet rs_loc1	= null;
Statement pstmt	= null;
String value1  = "";
String value2 = ""; 
String value3 = "";
String from = "";
String value5 = "";
String clinicDesc = "";
String clinicCode = "";

try
{
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

	conn = ConnectionManager.getConnection(request);
	
	//Added on 8/24/2004 by Raghavendra for InformedDetails.jsp  
	value1 = request.getParameter("field1")==null?"":request.getParameter("field1");;

	if(!((value1.equals("InformDetails"))||(value1.equals("BedSideReferral"))))
	{
		Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get("SEARCH");
		String criteria = (String) hash.get("criteria");

		if(criteria.equals("Days"))
		{
			String prefDateTime =(String) hash.get("prefDateTime");
			String expDaysofStay=(String) hash.get("expDaysofStay");

			String sql = "Select to_char(to_date('"+prefDateTime+"','DD/MM/rrrr HH24:MI')+"+expDaysofStay+",'dd/mm/rrrr hh24:mi') From DUAL";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			out.println(rs.getString(1));
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		else if(criteria.equals("Hours"))
		{
			String prefDateTime		= (String) hash.get("prefDateTime");
			String expHoursofStay	= (String) hash.get("expHoursofStay");

			String sql = "Select to_char(to_date('"+prefDateTime+"','DD/MM/rrrr HH24:MI')+"+expHoursofStay+",'dd/mm/rrrr hh24:mi') From DUAL";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			out.println(rs.getString(1));
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		hash.clear();
	}
	else if(value1.equals("InformDetails"))
	{
		value2				=	request.getParameter("field2")==null?"":request.getParameter("field2");

		value3				=	request.getParameter("field3")==null?"":request.getParameter("field3");

		from				=	request.getParameter("field4")==null?"":request.getParameter("field4");

		value5				=	request.getParameter("field5")==null?"":request.getParameter("field5");

		if((value1.equals("InformDetails")) && (from.equals("RecordInpatientLeave")))
		{
			StringBuffer sqlBuffer	= new StringBuffer();
			String info_pat_name	= "";
			
			if (value3.equals("01"))
				{
					sqlBuffer.append("select contact1_name info_pat_name from mp_pat_rel_contacts where patient_id = '");
					sqlBuffer.append(value2);
					sqlBuffer.append("' ");
				}
				else if (value3.equals("02"))
				{
					sqlBuffer.append("select contact2_name info_pat_name from mp_pat_rel_contacts where patient_id = '");
					sqlBuffer.append(value2);
					sqlBuffer.append("' ");
				}

			String mysql = sqlBuffer.toString();
			pstmt	=	conn.createStatement();
		
			rset	=	pstmt.executeQuery(mysql);	

			if ((rset != null) && (rset.next()))
			info_pat_name = rset.getString("info_pat_name")==null?"":rset.getString("info_pat_name");
	 
 			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

				if ((value5.equals("Leave")) && !(info_pat_name.equals("")))
				{
				%>
				<script>
				parent.frames[1].document.getElementById("informed_name").value = "<%=info_pat_name%>";
				if(parent.frames[1].document.forms[0].informed_name.value.disabled==true)
				{ 			   
				parent.frames[1].document.forms[0].informed_name.value.disabled=false;
				parent.frames[1].document.forms[0].informed_name.value.focus();
				}
				</script>
				<%
				}
		}
	}

		else if(value1.equals("BedSideReferral"))
		{ 
		String ref_to =	request.getParameter("ref_to")==null?"":request.getParameter("ref_to");

		String loc_type =	request.getParameter("loc_type")==null?"":request.getParameter("loc_type");
		if(loc_type.equals("C")) 
		{	

		String sql_loc1=" SELECT SHORT_DESC CLINIC_DESC, CLINIC_CODE FROM `OP_CLINIC_LANG_VW  WHERE  LANGUAGE_ID = '"+locale+"' and EFF_STATUS = 'E' and clinic_type='C' AND FACILITY_ID = '"+ref_to+"' order by 1 "; 


		stmt_loc1=conn.createStatement();
		rs_loc1=stmt_loc1.executeQuery(sql_loc1);
		if(rs_loc1!=null)
		{
			while(rs_loc1.next())
			{
				clinicDesc	= rs_loc1.getString("CLINIC_DESC");
				clinicCode	= rs_loc1.getString("CLINIC_CODE");
				%>
				<script>
					var opt=parent.frames[4].document.createElement("OPTION");
					opt.text	= "<%=clinicDesc%>"; 
					opt.value	= "<%=clinicCode%>";
					parent.frames[1].document.forms[0].location1.add(opt);
					</script>
			<%
			}// E.O While 
		if(rs_loc1!=null)	rs_loc1.close();
		if(stmt_loc1!=null)	stmt_loc1.close();
		}// E.O If 
	}//end of if for loc_type c.
	else
	if(loc_type.equals("D")) 
	{	

		String sql_loc1=" SELECT SHORT_DESC NU_DESC, NURSING_UNIT_CODE FROM IP_NURSING_UNIT_LANG_VW   WHERE  LANGUAGE_ID = '"+locale+"' AND EFF_STATUS = 'E' AND LOCN_TYPE = 'N' AND FACILITY_ID = '"+ref_to+"' AND APPL_PATIENT_CLASS = 'DC' order by 1 ";

		String nursingUnitDesc= "";
		String nursingUnitCode= "";
		
		stmt_loc1=conn.createStatement();
		rs_loc1=stmt_loc1.executeQuery(sql_loc1);
		if(rs_loc1!=null)
		{
			while(rs_loc1.next())
			{
				nursingUnitDesc	= rs_loc1.getString("NU_DESC");
				nursingUnitCode	= rs_loc1.getString("NURSING_UNIT_CODE");
				%>
				<script>
					var opt=parent.frames[3].document.createElement("OPTION");
					opt.text	= "<%=nursingUnitDesc%>"; 
					opt.value	= "<%=nursingUnitCode%>";
					parent.frames[1].document.forms[0].location1.add(opt);
					</script>
			<%
			}// E.O While
		if(rs_loc1!=null)	rs_loc1.close();
		if(stmt_loc1!=null)	stmt_loc1.close();
		}// E.O If 
	} //end of if for loc_type "D".
	}//end of BedSideReferral else 
	
	if(rs != null)	rs.close();	
	if(stmt !=null) stmt.close();
}catch(Exception e) {out.println(e.toString());}
finally
{
	ConnectionManager.returnConnection(conn,request);
}
%>
