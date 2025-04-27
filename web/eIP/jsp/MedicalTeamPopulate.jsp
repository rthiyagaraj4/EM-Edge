<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<body class=message onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	
	String locale		= (String)session.getAttribute("LOCALE");
	
	String facilityId	= (String)session.getValue("facility_id");
	String practid		= checkForNull(request.getParameter("ippractid"));
	String dateVal		= checkForNull(request.getParameter("dateVal"));
	String admDate		= checkForNull(request.getParameter("admDate"));
	String booking		= checkForNull(request.getParameter("booking"));
	String expdate		= checkForNull(request.getParameter("expdate"));
	String teamid		= checkForNull(request.getParameter("team_id"));
	String med_code		= checkForNull(request.getParameter("med_code"));
	String spy_code		= checkForNull(request.getParameter("spy_code"));

	StringBuffer selectsql	= new StringBuffer();
	Connection con	= null;
	PreparedStatement pstmt =null;
	ResultSet rs	= null;
	PreparedStatement pstmt1 =null;
	ResultSet rs1	= null;

		// below eight lines added by Venkatesh.S on 29/Sep/2011 for the incident GHL-SCF-453 [IN028804].
			String patient_class = checkForNull(request.getParameter("patient_class"));
    String discharge_date_only="";
try
	{	
	 
      //incident GHL-SCF-453 [IN028804] end.   
   
        request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);	
		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
	// below eight lines added by Venkatesh.S on 29/Sep/2011 for the incident GHL-SCF-453 [IN028804].
		if(patient_class.equals("D")) //this block for DayCare patient.
		{
			StringTokenizer stringTokenizer = new StringTokenizer(admDate);
			while(stringTokenizer.hasMoreTokens()){
			discharge_date_only=stringTokenizer.nextToken();
			//String time_only=stringTokenizer.nextToken();
			}
			discharge_date_only=discharge_date_only+" 23:59";
			discharge_date_only = DateUtils.convertDate(discharge_date_only,"DMYHM","en",locale); 
			out.println("<script>parent.frames[2].document.forms[0].expecteddischargedate.value = '"+discharge_date_only+"';</script>");		
		}
	// incident GHL-SCF-453 [IN028804] end.  
	   
	   
	   if(patient_class.equals("I")) // This condition only added by Venkatesh.S(EmId-4008) for the                                           incident GHL-SCF-453 [IN028804].//this block for Inpatient                                            patient.
	   {

		if(expdate.equals("expdate"))
		{				
			if(!dateVal.equals(""))
			{	
				pstmt1 	= con.prepareStatement( "select to_char(to_date('"+admDate+"','dd/mm/rrrr hh24:mi')+'"+dateVal+"','dd/mm/rrrr hh24:mi') disdate from dual");
				rs1 = pstmt1.executeQuery();
				if(rs1.next())
				{
					String Expdate = rs1.getString("disdate");
					if(!(Expdate==null || Expdate.equals("")))
						Expdate = DateUtils.convertDate(Expdate,"DMYHM","en",locale); 
					out.println("<script>parent.frames[2].document.forms[0].expecteddischargedate.value = '"+Expdate+"';</script>");				
					if (rs1 != null) rs1.close();
					if (pstmt1 != null) pstmt1.close();
				}
			}
			else
			{
				out.println("<script>parent.document.frames[2].document.forms[0].expecteddischargedate.value = ''</script>");				
			}
		}}

		if (!(practid.equals("")))
		{
			selectsql.append(" select a.short_desc short_desc ,a.team_id, b.practitioner_id from 	AM_MEDICAL_TEAM_LANG_VW a, AM_PRACT_FOR_TEAM b where a.language_id = '"+locale+"' and a.facility_id ='"+facilityId+"' and a.facility_id = b.facility_id and b.practitioner_id ='"+practid+"' and a.speciality_code = '"+spy_code+"' and b.team_id=a.team_id and a.appl_for_ip_yn = 'Y' order by 1 ");
		}
		else if (practid.equals(""))
		{
			selectsql.append(" select distinct a.short_desc short_desc, a.team_id from AM_MEDICAL_TEAM_LANG_VW a, AM_PRACT_FOR_TEAM b where a.language_id = '"+locale+"' and a.facility_id ='"+facilityId+"' and a.facility_id = b.facility_id and a.speciality_code = '"+spy_code+"' and b.team_id=a.team_id and a.appl_for_ip_yn = 'Y' order by 1 ");
		}
		
		
		pstmt 	= con.prepareStatement(selectsql.toString());
		rs = pstmt.executeQuery() ;
		String str1 = "";
		String str2 = "";
		if( rs != null ) 
		{
			// This condition added by Nanda - 01/10/2002 
			if(booking.equals("AssignBed"))
			{
				int i=0; 
				while(rs.next()) 
				{
					str1 = rs.getString( "team_id" ) ;
					str2 = rs.getString( "short_desc" );
					i++;
					if(i==1)
					{
						if(med_code.equals("tfr_out"))
						{
							out.println(	"<script> var element = parent.frames[2].document.createElement('OPTION');"+
							"element.text = \""+str2+"\";"+ 
							"element.value= \""+str1+"\";"+
							"element.selected='true';"+
							"parent.frames[2].document.forms[0].team_id.add(element);</script>");
						}
						else
						{
							out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
							"element.text = \""+str2+"\";"+ 
							"element.value= \""+str1+"\";"+
							"element.selected='true';"+
							"parent.frames[1].document.forms[0].team_id.add(element);</script>");		
						}
					}
					else
					{
						if(med_code.equals("tfr_out"))
						{
							out.println(	"<script> var element = parent.frames[2].document.createElement('OPTION');"+
							"element.text = \""+str2+"\";"+ 
							"element.value= \""+str1+"\";"+
							"parent.frames[2].document.forms[0].team_id.selectedIndex=0;"+
							"parent.frames[2].document.forms[0].team_id.add(element);</script>");
						}
						else
						{
							out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
							"element.text = \""+str2+"\";"+ 
							"element.value= \""+str1+"\";"+
							"parent.frames[1].document.forms[0].team_id.selectedIndex=0;"+
							"parent.frames[1].document.forms[0].team_id.add(element);</script>");
						}
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
						out.println(	"<script> var element = 	parent.frames[1].document.createElement('OPTION');"+
						"element.text = \""+str2+"\";"+ 
						"element.value= \""+str1+"\";"+
						"element.selected=true ;"+
						"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
					}
					else
					{
						out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
						"element.text = \""+str2+"\";"+ 
						"element.value= \""+str1+"\";"+
						"parent.frames[1].document.forms[0].team_id.selectedIndex=0;"+
						"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
					}
				}		
			}
			
			if(booking.equals("transfer"))
			{
				while( rs.next() ) 
				{
					str1 = rs.getString( "team_id" ) ;
					str2 = rs.getString( "short_desc" );
					out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
					"element.text = \""+str2+"\";"+ 
					"element.value= \""+str1+"\";"+
					"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
				}		     
			}

			if(booking.equals("admit"))
			{
			%>
				<script>
					if(parent.f_query_add_mod.frames[2].document.AdmitPatient_form)
					{
						var obj = parent.f_query_add_mod.frames[2].document.AdmitPatient_form.team_id;
						var length  = obj.length;
						for(i=0;i<length;i++)
							obj.remove(1); 
						var team_opt = parent.f_query_add_mod.frames[2].document.createElement('OPTION');
						team_opt.text = '--- '+getLabel('Common.defaultSelect.label','Common')+' ---';
						team_opt.value = "";
						parent.f_query_add_mod.frames[2].document.forms[0].team_id.add(team_opt);
					}
				</script>
				<%
				int i=0;
				while( rs.next() ) 
				{
					str1 = rs.getString( "team_id" ) ;
					str2 = rs.getString( "short_desc" );
					i++;
					
					out.println(	"<script> var element = parent.f_query_add_mod.document.frames[2].document.createElement('OPTION');"+
					"element.text = \""+str2+"\";"+ 
					"element.value= \""+str1+"\";"+
					"element.selected=true;"+
					"parent.f_query_add_mod.document.frames[2].document.forms[0].team_id.add(element);</script>");
				}
				
				if(!teamid.equals("") && i > 0)
				{
				out.println("<script>parent.f_query_add_mod.document.frames[2].document.forms[0].team_id.value=\""+teamid+"\";</script>");
				}
			}
		}

		out.println("</script><script>let iframe = top.content; let lastFrame = iframe.frames[iframe.frames.length - 1].location.href = '../../eCommon/jsp/error.jsp?err_num=';</script></head><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'></body></html>");

		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();

	}catch(Exception e)
	{
		out.println("Exception in MedicalTeamPopulate.jsp : "+ e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);	
	}
%>	
</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
	}
%>

