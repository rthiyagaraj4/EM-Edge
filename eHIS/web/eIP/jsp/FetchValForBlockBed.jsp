<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,com.ehis.util.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<script language="JavaScript">

function bedDetails(errMsg)
{
	var err_msg = errMsg;
	parent.frames[2].location.href="../../eCommon/jsp/error.jsp?err_num="+err_msg;		
	var obj= parent.frames[1].document.forms[0]	
	if(parent.frames[1].document.getElementById("bedclass"))
		parent.frames[1].document.getElementById("bedclass").innerText=''

	if(parent.frames[1].document.getElementById("roomno"))
		parent.frames[1].document.getElementById("roomno").innerText=''

	obj.bed_class.value = '';
	obj.bed_type.value = '';
	obj.room_no.value = '';	
	obj.bed_no.value = '';
	obj.bed_no.focus();
}
</script>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		<%
			request.setCharacterEncoding("UTF-8");
			Connection con = null;
			String facility_id = (String)session.getAttribute("facility_id");
			Statement stmt = null;
			ResultSet rs =null;
			String obj_name		 = request.getParameter("obj_name");
		%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>

	<body class='message' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
try
{

	con = ConnectionManager.getConnection(request);

/// Added by SRIDHAR R on 5 OCT 2004...
// if obj_name.equals("main_bed_no").. then it is called from [ BED FOR NURSING UNIT ] FUNCTION ..IP MASTER CODE SET UP...

	if(obj_name.equals("bed_no") || obj_name.equals("main_bed_no") )
	{
		String nursing_unit	= request.getParameter("nursing_unit");
		String bed_no		= request.getParameter("bed_no");
		
		String sql = "select room_no, bed_class_long_desc, bed_class_code, bed_type_code,bed_class_short_desc, BED_TYPE_SHORT_DESC, SPECAILTY_SHORT_DESC, SPECIALTY_CODE from ip_nursing_unit_bed_vw where nursing_unit_code='"+nursing_unit+"' and bed_no='"+bed_no+"' and PSEUDO_BED_YN='N' and facility_id = '"+facility_id+"' ";
		try
		{					
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);
			if(rs!=null)
			{
				if(rs.next())
				{
					 String room_no= rs.getString(1);
					 String bed_class_code=rs.getString(3);
					 String bed_type_code=rs.getString(4);
					 String bed_class_short_desc=rs.getString(5);
					 String bed_type_short_desc=rs.getString("BED_TYPE_SHORT_DESC");
					 String specialty_code=rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
					 String specailty_short_desc=rs.getString("SPECAILTY_SHORT_DESC");
					
					%>
					 <script>
					if("<%=obj_name%>" == "main_bed_no")
					{
	
				parent.frames[1].document.forms[0].room.value='<%=room_no%>';
				parent.frames[1].document.forms[0].room.disabled = true;

				var bedClassOpt		= parent.frames[1].document.createElement("OPTION");
				bedClassOpt.text	= "<%=bed_class_short_desc%>";
				bedClassOpt.value	= "<%=bed_class_code%>";
				bedClassOpt.selected = true;
				parent.frames[1].document.forms[0].bed_class.add(bedClassOpt);
				parent.frames[1].document.forms[0].bed_class.disabled = true;

				var bedTypeOpt		= parent.frames[1].document.createElement("OPTION");
				bedTypeOpt.text		= "<%=bed_type_short_desc%>";
				bedTypeOpt.value	= "<%=bed_type_code%>";
				bedTypeOpt.selected = true;
				parent.frames[1].document.forms[0].bed_type.add(bedTypeOpt);
				parent.frames[1].document.forms[0].bed_type.disabled = true;
				parent.frames[1].document.forms[0].gender_specific_ind.disabled = true;//IN015822
				var spl = "<%=specialty_code%>";
				if(spl!="")
				{
				var specialtyOpt		= parent.frames[1].document.createElement("OPTION");
				specialtyOpt.text		= "<%=specailty_short_desc%>";
				specialtyOpt.value		= "<%=specialty_code%>";
				specialtyOpt.selected	= true;
				parent.frames[1].document.forms[0].speciality.add(specialtyOpt);
				parent.frames[1].document.forms[0].speciality.disabled = true;
				}
				else
				{
				parent.frames[1].document.forms[0].speciality.disabled = true;
				}
					}
					else
					{
						var obj= parent.frames[1].document.forms[0]
						parent.frames[1].document.getElementById('bedclass').innerText="<%=bed_class_short_desc%>"
						parent.frames[1].document.getElementById('roomno').innerText="<%=room_no%>"
						obj.bed_class.value = "<%=bed_class_code%>"
						obj.bed_type.value = "<%=bed_type_code%>"
						obj.room_no.value = "<%=room_no%>"								
					}
					</script> 
					<%
				}
				else
				{
					sql = "select room_no, bed_class_long_desc, bed_class_code,bed_type_code,bed_class_short_desc from ip_nursing_unit_bed_vw where nursing_unit_code='"+nursing_unit+"' and bed_no='"+bed_no+"' and PSEUDO_BED_YN='Y' and current_status = 'A' ";
					stmt = con.createStatement();
					rs	= stmt.executeQuery(sql);
					
					if(!rs.next())
					{	%>
					 <script>
						
						var err_msg=getMessage('INVALID_BED','IP');
						if("<%=obj_name%>" == "main_bed_no")
						{
							alert(err_msg);
							parent.frames[1].document.forms[0].main_bed_no.value = '';
						}
						else
						{
							bedDetails(err_msg);
						}
					</script> 
				<%	}
					
					else
					{	%>
					<script>
						
						var err_msg = getMessage('CANNOT_BLOCK_PSEUDO_BED','IP');//"APP-IP0193 Pseudo bed cannot be blocked. "
						if("<%=obj_name%>" == "main_bed_no")
						{
							alert(err_msg);
							parent.frames[1].document.forms[0].main_bed_no.value = '';
						}
						else
						{
							bedDetails(err_msg);
						}
							
						</script> 
				<%	}
						if(stmt!=null)stmt.close();
					if(rs!=null)rs.close();
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}
		catch (Exception e)
		{
			out.println(e.toString());
		}
		finally 
		{					
			if(stmt!=null)	stmt.close();
			if(rs!=null)	rs.close();
		}
	}
	else if(obj_name.equals("remarks"))
	{
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy HH:mm" ) ;
		java.util.Date dt=new java.util.Date();
		String currDate = dateFormat.format( dt ) ;
		 if(!(currDate==null || currDate.equals("")))
				currDate =  DateUtils.convertDate(currDate,"DMYHM","en",localeName); 
						

		%>
		<script>

		var obj= parent.frames[1].document.forms[0]
		obj.from_date.value="<%=currDate%>"
		</script>
<%	}
	else
	{
		if(obj_name.equals("from_date"))
		{
			String from_date = request.getParameter("from_date");
			String from_date1= from_date;
			String block_type_code = request.getParameter("blocking_type_code");
			String sql = "";
			String blocking_hour = "";
			String blocking_unit = "";
						
			//String sql = "select to_char(to_date('"+from_date1+ "','dd/mm/rrrr hh24:mi')+(nvl(bed_block_period_normal,0)/24),'dd/mm/rrrr hh24:mi') from ip_param where facility_id='"+facility_id+"'";

			if(!(block_type_code==null || block_type_code.equals("")))
			{
				sql = "select DFLT_MIN_BLOCK_PERIOD, DFLT_BLOCK_UNITS from IP_BLOCKING_TYPE where  BLOCKING_TYPE_CODE = '"+block_type_code+"'";

				try
					{
						stmt = con.createStatement();
						rs	= stmt.executeQuery(sql);
						if(rs!=null)
						{
							if(rs.next())
							{
								 blocking_hour =  rs.getString("DFLT_MIN_BLOCK_PERIOD");
								 blocking_unit =  rs.getString("DFLT_BLOCK_UNITS");
							}
						}
					}
					catch (Exception e)
					{
						out.println(e.toString());
					}
					finally 
					{					
						if(stmt!=null)	stmt.close();
						if(rs!=null)	rs.close();
					}
			}

			
			
			if(!(block_type_code==null || block_type_code.equals("")) && !(blocking_hour==null || blocking_hour.equals("")) && blocking_unit!=null && blocking_unit.equals("H"))
				sql = "select to_char(to_date('"+from_date1+ "','dd/mm/rrrr hh24:mi')+(nvl(DFLT_MIN_BLOCK_PERIOD,0)/24),'dd/mm/rrrr hh24:mi') from IP_BLOCKING_TYPE where  BLOCKING_TYPE_CODE = '"+block_type_code+"'";
			else if(!(block_type_code==null || block_type_code.equals("")) && !(blocking_hour==null || blocking_hour.equals("")) && blocking_unit!=null && blocking_unit.equals("D"))
				sql = "select to_char(to_date('"+from_date1+ "','dd/mm/rrrr hh24:mi')+(nvl(DFLT_MIN_BLOCK_PERIOD,0)),'dd/mm/rrrr hh24:mi') from IP_BLOCKING_TYPE where  BLOCKING_TYPE_CODE = '"+block_type_code+"'";
			else
				sql = "select to_char(to_date('"+from_date1+ "','dd/mm/rrrr hh24:mi')+(nvl(bed_block_period_normal,0)/24),'dd/mm/rrrr hh24:mi') from ip_param where facility_id='"+facility_id+"'";

				

				StringTokenizer tok1=new StringTokenizer(from_date," ");
				from_date = tok1.nextToken();
				String from_time = tok1.nextToken();

				StringTokenizer tok=new StringTokenizer(from_date,"/");
				String a[]=new String [3];
				for(int i=0;tok.hasMoreTokens();i++)
					a[i]= tok.nextToken();

				tok1=null;
				tok1=new StringTokenizer(from_time,":");
				String a1[]=new String [2];
				for(int i=0;tok1.hasMoreTokens();i++)
					a1[i]= tok1.nextToken();

			//if(userdate.after(currentdate) || userdate.equals(currentdate))
			{
					try
					{
						stmt = con.createStatement();
						rs	= stmt.executeQuery(sql);
						if(rs!=null)
						{
							if(rs.next())
							{
								String until_dt =  rs.getString(1);

								 
								
								 if(!(until_dt==null || until_dt.equals("")))
									until_dt =  DateUtils.convertDate(until_dt,"DMYHM","en",localeName);
																
								%>
									<script>
										var obj= parent.frames[1].document.forms[0]
										obj.until_date.value="<%=until_dt%>"
									</script>
								<%
							}
						}
						if(stmt!=null)stmt.close();
						if(rs!=null)rs.close();
					}
					catch (Exception e)
					{
						out.println(e.toString());
					}
					finally 
					{					
						if(stmt!=null)	stmt.close();
						if(rs!=null)	rs.close();
					}
				}
			}
			else
			{
				String block_type_code = request.getParameter("block_type");
				String sql = "select override_yn  from ip_blocking_type where blocking_type_code='"+block_type_code+"'";
				try
				{
					stmt = con.createStatement();
					rs	= stmt.executeQuery(sql);

					if(rs!=null)
					{
						if(rs.next())
						{
							 String override_yn= rs.getString(1);
							%>
								<script>
									var obj= parent.frames[1].document.forms[0]
									if("<%=override_yn%>"=="Y")
										obj.override.checked=true
									else
										obj.override.checked=false
								</script>
							<%
						}
					}
					if(stmt!=null)stmt.close();
					if(rs!=null)rs.close();
				}
				catch (Exception e)
				{
					out.println(e.toString());
				}
				finally 
				{					
					if(stmt!=null)	stmt.close();
					if(rs!=null)	rs.close();
				}
			}
	}
}catch (Exception e)
	{
			
			e.printStackTrace();
	}
	finally 
	{
		if(con != null)ConnectionManager.returnConnection(con,request);	
	}	
%>
	</body>
</html>
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

