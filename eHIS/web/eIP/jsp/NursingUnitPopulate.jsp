<!DOCTYPE html>
<%@ page   contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<body class=message onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%
	request.setCharacterEncoding("UTF-8");
	String facilityId	= (String) session.getValue("facility_id");
	String dateVal = request.getParameter("dateVal");
		if(dateVal == null) dateVal= "";
	String booking = request.getParameter("booking");
		if(booking == null) booking ="";
	String expdate = request.getParameter("expdate");
		if(expdate == null) expdate ="";		 
	String med_code		= request.getParameter("med_code");
	String spy_code		= request.getParameter("spy_code");
	String prt_code		= request.getParameter("prt_code");
	String p_code		= "";
	String p_desc		= "";

	if (med_code==null) med_code="";
	if (spy_code==null) spy_code="";
	if (prt_code==null) prt_code="";
	
	Connection con= null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	PreparedStatement pstmt1 =null;
	ResultSet rs1 = null;
	Statement stmt = null;
	String str1="", str2="";

	try
	{	
		con = ConnectionManager.getConnection(request);	
		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
	
		/* This condition added by Nanda - 01/10/2002 */

		if(booking.equals("AssignBed"))
	    {
			int i=0; 
			while( rs.next() ) 
			{
				str1 = rs.getString( "team_id" ) ;
				str2 = rs.getString( "short_desc" );
				i++;
				if(i==1)
				{
					out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
					"element.text = '"+str2+"';"+ 
					"element.value= '"+str1+"';"+
					"element.selected='true';"+
					"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
				}
				else
				{
					out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
					"element.text = '"+str2+"';"+ 
					"element.value= '"+str1+"';"+
					"parent.frames[1].document.forms[0].team_id.selectedIndex=0;"+
					"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
				}
			}		
		}
		if(booking.equals("booking"))
	    {
			int i=0; 
			while( rs.next() ) 
			{
				str1 = rs.getString( "team_id" ) ;
				str2 = rs.getString( "short_desc" );
				i++;
				if(i==1)
				{
				out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
					"element.text = '"+str2+"';"+ 
					"element.value= '"+str1+"';"+
					"element.selected='true';"+
					"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
				}
				else
				{
					out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
					"element.text = '"+str2+"';"+ 
					"element.value= '"+str1+"';"+
					"parent.frames[1].document.forms[0].team_id.selectedIndex=0;"+
					"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
				}
			}		

			String str ="SELECT a.nursing_unit_code,a.Short_desc FROM IP_NURSING_UNIT a, IP_MED_SER_GRP_NURS_UT_TYPE b, IP_NURS_UNIT_FOR_SPECIALTY c,IP_NURSING_UNIT_FOR_PRACT D WHERE a.FACILITY_ID='"+facilityId+"' AND A.EFF_STATUS='E' AND B.MED_SER_GRP_CODE='"+med_code+"' AND A.FACILITY_ID=B.FACILITY_ID AND A.FACILITY_ID=C.FACILITY_ID AND A.FACILITY_ID=D.FACILITY_ID AND A.NURSING_UNIT_CODE=C.NURSING_UNIT_CODE AND A.NURSING_UNIT_CODE=D.NURSING_UNIT_CODE AND A.NURSING_UNIT_TYPE_CODE=B.NURSING_UNIT_TYPE_CODE AND C.SPECIALTY_CODE='"+spy_code+"' AND D.PRACTITIONER_ID='"+prt_code+"' ";

			stmt = con.createStatement();
			rs = stmt.executeQuery(str);

			if(rs != null)
			{
				while (rs.next())
				{
					p_code				= rs.getString("nursing_unit_code");
					p_desc				= rs.getString("Short_desc");
					%>
					<script>
						var temp = "<%=p_code%>";
						var temp1="<%=p_desc%>";
						var opt=parent.frames[2].document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.frames[1].document.forms[0].nursing_unit.add(opt);
						alert(parent.frames[1].document.forms[0].name);
					</script>
					<%
				}
			}
		}
	    else if(booking.equals("admit"))
	    {
			while( rs.next() ) 
			{
				str1 = rs.getString( "team_id" ) ;
				str2 = rs.getString( "short_desc" );
				out.println(	"<script> var element = parent.f_query_add_mod.document.frames[2].document.createElement('OPTION');"+
				"element.text = '"+str2+"';"+ 
				"element.value= '"+str1+"';"+
				"parent.f_query_add_mod.document.frames[2].document.forms[0].team_id.add(element);</script>");
			}
	     }
		 if(booking.equals("transfer"))
		 {
			while( rs.next() ) 
			{
				str1 = rs.getString( "team_id" ) ;
				str2 = rs.getString( "short_desc" );
				out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
				"element.text = '"+str2+"';"+ 
				"element.value= '"+str1+"';"+
				"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
			}		     
		}
		pstmt.close() ;      		
		out.println("</script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'></body></html>");
	    if(expdate.equals("expdate"))
		{				
			if(!dateVal.equals(""))
			{	
				pstmt1 	= con.prepareStatement( "select to_char(sysdate+'"+dateVal+"','dd/mm/rrrr hh24:mi') disdate from dual");
				rs1 = pstmt1.executeQuery();
				if(rs1.next())
				{
					String Expdate = rs1.getString("disdate");
					out.println("<script>parent.f_query_add_mod.document.frames[2].document.forms[0].expecteddischargedate.value = '"+Expdate+"';parent.f_query_add_mod.document.frames[2].document.forms[0].circumstance_of_injury.focus();</script>");				
				}
			}
			else
			{
				out.println("<script>parent.f_query_add_mod.document.frames[2].document.forms[0].expecteddischargedate.value = ''</script>");				
			}
		}
	}	
	catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	finally
	{
	 	ConnectionManager.returnConnection(con,request);	

		if(stmt!=null) stmt.close();
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		if(pstmt1!=null) pstmt1.close();
		if(rs1!=null) rs1.close();
	}
%>	
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

