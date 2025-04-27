<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*,java.util.HashMap,java.sql.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
 <jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/>
 <jsp:useBean id="accessRightRec" class="webbeans.eCommon.RecordSet" scope="session"/>
 <jsp:useBean id="accessRight" class="webbeans.eCommon.RecordSet" scope="session"/> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
<script src='../../eCommon/js/common.js' language='javascript'></script>



<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eIP/js/NursUnitRoom.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

var xxx;
var sleBox;

</script>
<%
/* ADDED by SRIDHAR on 23 FEB 2004 FOR LEVEL OF CARE INDIACTOR & CHECK BOX */
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String nursing_unit = (request.getParameter("nursing_unit_code") == null) ? "" : request.getParameter("nursing_unit_code");
	String search_by	= checkForNull(request.getParameter("search_by"));
	String search_txt	= checkForNull(request.getParameter("search_txt"));
String req_start	="", req_end	="";
	String checkedOnes  ="";
	String SelectedOnes  ="";
		String removeCode = "";

	String SelectedOnes2 = "";
	
	String from			= request.getParameter("from") ;
	String to			= request.getParameter("to") ;
	String LOC			= "";
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int count = 0;
	if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 14 ; }   else {  end = Integer.parseInt( to ) ; }
	req_start =   (request.getParameter("start")==null)   ?  "0" :   request.getParameter("start");
	req_end   =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");

	String effStatus	="";
	Statement stmt3		= null;
	ResultSet rstlRs3	= null;
	effStatus=request.getParameter("effStatus");
	if(effStatus == null) effStatus="";
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null ;
	ResultSet rset	= null;
	Statement Levelstmt = null;
	ResultSet LevelRset = null;
	PreparedStatement pstmt = null;
	try
	{
		con = ConnectionManager.getConnection(request);
		String Update_yn	="";
		String data		="";		
		String code		="";		
		String sel		="";		
		String facility_id		=(String)session.getValue("facility_id");
		String nursing_unit_code= request.getParameter("nursing_unit_code");
		String flagSelect		= request.getParameter("fromSelect");
		Hashtable htRecord		= null ;
		int cnt=0;
		String classValue	="";
		String chkAttribute	="";
		String eff_status	="";
		StringBuffer patient_class = new StringBuffer();
		patient_class.append(" select  appl_patient_class from IP_NURSING_UNIT  where FACILITY_ID = '"+facility_id+"' and NURSING_UNIT_CODE='"+nursing_unit_code+"' and eff_status='E' ");
		String appl_patient_class="";
		stmt=con.createStatement();
		rs = stmt.executeQuery(patient_class.toString());

		if(rs !=null)
		{
			while(rs.next())
			{
				appl_patient_class=rs.getString("appl_patient_class");
			}
		if(rs != null)			rs.close(); 
		if(stmt != null)		stmt.close(); 
		}
		if(appl_patient_class.equals("DC"))
		{
			StringBuffer check_Dc = new StringBuffer();
			check_Dc.append(" select  count(*) cnt from IP_DC_UNIT_FOR_NURS_UNIT where FACILITY_ID = '"+facility_id+"' and NURSING_UNIT_CODE='"+nursing_unit_code+"'");
			
			stmt=con.createStatement();
			rs = stmt.executeQuery(check_Dc.toString());
			if(rs !=null)
			{
				while(rs.next())
				{
					cnt=rs.getInt("cnt");
				}
			}
			if(rs != null)			rs.close();
			if(stmt != null)		stmt.close();
		}


		if(!appl_patient_class.equals("DC"))
			cnt=1;


		if(cnt > 0)
		{

			if(appl_patient_class.equals("DC"))
			{
				StringBuffer practid_sql = new StringBuffer();
				practid_sql.append("select practitioner_id from op_pract_for_Clinic where clinic_code in (select clinic_code from ip_dc_unit_for_nurs_unit where FACILITY_ID = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"') and FACILITY_ID = '"+facility_id+"' and resource_class = 'R'");
				stmt = con.createStatement();
				rs	 = stmt.executeQuery(practid_sql.toString());

				if(rs !=null)
				{
					while(rs.next())
					{
					}
				}
				if(rs != null)			rs.close(); 
				if(stmt != null)		stmt.close();
			}

			if(flagSelect !=null)
			{
				accessRightRecSet.clearAll();
				accessRightRec.clearAll();
				accessRight.clearAll();
				htRecord = new Hashtable();
				StringBuffer sqlinsVals = new StringBuffer();
				if(appl_patient_class.equals("DC"))
				{
					sqlinsVals.append(" select ROOM_NO,Level_of_care_code,NO_OF_BEDS from IP_NURSING_UNIT_ROOM  where FACILITY_ID = '"+facility_id+"' and NURSING_UNIT_CODE='"+nursing_unit_code+"' and eff_status='E' ");
				}
				else
				{
					sqlinsVals.append(" select ROOM_NO,Level_of_care_code,NO_OF_BEDS from IP_NURSING_UNIT_ROOM  where FACILITY_ID = '"+facility_id+"' and NURSING_UNIT_CODE='"+nursing_unit_code+"' and eff_status='E' ");
				}
				stmt3=con.createStatement();
				rstlRs3 = stmt3.executeQuery(sqlinsVals.toString());

				if(rstlRs3 !=null)
				{
					while(rstlRs3.next())
					{
							accessRightRecSet.putObject(rstlRs3.getString(1));
							accessRightRec.putObject(rstlRs3.getString(2));
							accessRight.putObject(rstlRs3.getString(3));

					 }
					
				}
	       	}
			if(rstlRs3 != null)		rstlRs3.close(); 
			if(stmt3 != null)		stmt3.close();


        
// ADDED by SRIDHAR on 23 FEB 2004 
			if(from != null && to != null)
			{
				 int j=0;
				 for( i=(Integer.parseInt(req_start)); i<=(Integer.parseInt(req_end)); i++)
				 {
					 if(request.getParameter("chk"+(i)) != null)
					 {
						 checkedOnes = request.getParameter("chk"+(i));
						 SelectedOnes = request.getParameter("level"+(i));
						 SelectedOnes2 = request.getParameter("no_of_beds"+(i));

						 if(!(accessRightRecSet.containsObject(checkedOnes)))
						 {
							accessRightRecSet.putObject(checkedOnes);
							accessRightRec.putObject(SelectedOnes);
							accessRight.putObject(SelectedOnes2);

						 }
						 j++;
					 }
					 removeCode = checkForNull(request.getParameter("removeCode"+(i)));
					if(removeCode.equals("Y"))
						{ 
							if(request.getParameter("rm_num"+(i)) != null)
							 {
								String rm_num = request.getParameter("rm_num"+(i));
								if(accessRightRecSet.containsObject(rm_num))
								{
									int removeCodeIndex = accessRightRecSet.indexOfObject(rm_num);
									accessRightRecSet.removeObject(removeCodeIndex);
									accessRightRec.removeObject(removeCodeIndex);
									accessRight.removeObject(removeCodeIndex);
								}
							}
							
						}
						
					}
				 
				 out.println("<input type=hidden name='pages' id='pages' value='multiple'>");
				 out.println("<input type=hidden name='totChecked' id='totChecked' value='"+j+"'>");
			 }


			i = 1 ;
			
     		StringBuffer sql = new StringBuffer();

			if(appl_patient_class.equals("DC"))
			{
				sql.append("select distinct a.practitioner_id room_num, b.short_desc,decode(level_of_care_code, '',(select level_of_care_code from ip_nursing_unit_room where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"' and room_no = a.practitioner_id),(select nvl(level_of_care_code,'') from ip_nursing_unit where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"')) Level_of_care_code,B.eff_status,( select count(*) from ip_nursing_unit_bed where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"' and room_no = a.practitioner_id) no_of_beds   from op_pract_for_Clinic a,am_facility_room b where clinic_code in (select clinic_code from ip_dc_unit_for_nurs_unit where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"') and a.resource_class = 'R' and a.practitioner_id  = b.room_num and a.eff_status = 'E' and a.facility_id = '"+facility_id+"' and b.operating_facility_id = '"+facility_id+"' ");
		
				if(search_by.equals("ID"))
					sql.append(" and upper(room_num) like upper('"+search_txt+"%') ");
				else if(search_by.equals("DESC"))
					sql.append("  and upper(short_desc) like upper('"+search_txt+"%') ");

			}
			else
			{
				sql.append(" Select room_num, short_desc , B.eff_status, 'Y', nvl(no_of_beds,0) no_of_beds,B.Level_of_care_code ");
				sql.append(" from am_facility_room A,");
				sql.append(" IP_NURSING_UNIT_ROOM B ");
				sql.append(" WHERE B.FACILITY_ID='"+facility_id+"' ");
				sql.append(" AND B.NURSING_UNIT_CODE='"+nursing_unit_code+"' ");
				sql.append(" AND B.FACILITY_ID=A.OPERATING_FACILITY_ID ");
				sql.append(" AND B.ROOM_NO = A.ROOM_NUM and A.eff_status='E'  ");
			
				if(search_by.equals("ID"))
					sql.append(" and upper(room_num) like upper('"+search_txt+"%') ");
				else if(search_by.equals("DESC"))
					sql.append("  and upper(short_desc) like upper('"+search_txt+"%') ");

				sql.append(" union ");

				sql.append(" Select room_num, short_desc , 'D', 'N',0 ,Level_of_care_code" );
				sql.append(" from am_facility_room ");
				sql.append(" where operating_facility_id='"+facility_id+"' ");
				sql.append(" and eff_status='E' ");
				sql.append(" and resident_stay_yn='Y' ");
				sql.append(" and room_type in (Select locn_type from am_care_locn_type where care_locn_type_ind in ('R')) ");
				sql.append(" and nursing_unit_code is null ");
				sql.append(" and room_num not  in (Select room_no from ip_nursing_unit_room ");
				sql.append(" where facility_id='"+facility_id+"')  ");
		
				if(search_by.equals("ID"))
					sql.append(" and upper(room_num) like upper('"+search_txt+"%') ");
				else if(search_by.equals("DESC"))
					sql.append("  and upper(short_desc) like upper('"+search_txt+"%') ");
			}

			sql.append(" order by room_num ");
			try
			{
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs=stmt.executeQuery(sql.toString());

				rs.last();
				maxRecord = rs.getRow();
				rs.beforeFirst();
			}catch(Exception e)
			{
				//out.println(e);
				e.printStackTrace();
			}
		
			if(maxRecord == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				return;
			}
			if (start != 0)
				{
				   for(int j=1; j<=start; i++,j++)
					{
						rs.next() ;
					}
				}

			//out.println("<script>alert(\""+sql.toString()+"\");</script>");
			pstmt=con.prepareStatement("select LEVEL_OF_CARE_CODE,LEVEL_OF_CARE_DESC from ip_nursing_unit_vw where FACILITY_ID = ? and nursing_unit_code = ? ");	
			
		}
		else
		{%>
			<script>
				alert(getMessage("DC_UNITS_NOT_LINKED","IP"));
				document.location.href='../../eCommon/html/blank.html'
			</script>
		<%}
			String no_of_beds	="";
			while(i<=end && rs.next())
			{
				
				if(count == 0)
				{
		%>
		<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  class='CONTENT' >
		<form name='facility_form_result' id='facility_form_result' action='../../eIP/jsp/AddModifyNursUnitRoom.jsp' method='post'>

		<table  width="90%" border=0 align='center'>
		<tr>
		<input type= hidden name='nursing_unit_code' id='nursing_unit_code' value='<%=nursing_unit_code%>'>
		<input type='hidden' name='finalSelectedValues' id='finalSelectedValues' value=''>
		<input type= hidden name='from' id='from' value='<%=start%>'>
		<input type= hidden name='to' id='to' value='<%=end%>'>
		<input type= hidden name='start' id='start' value='<%=start%>'>
		<input type= hidden name='end' id='end' value='<%=end%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
		<input type='hidden' name='function_name' id='function_name' value='insert'>
		<input type=hidden name='maxRecord' id='maxRecord' value='<%=maxRecord%>' >
		<table align='right'>
		<tr>
		<%
	
		if ( !(start <= 1)) 
			{ 
				out.println("<td id='prev'><a href='javascript:submitPrevNext("+(start-14)+","+(end-14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");
				%>				
				<input type=hidden name='whichPage' id='whichPage' value='prev'></td>
				<%
			}
			//if ( !((start+14) >= maxRecord ))
			//{
				out.println("<td id='next' style='visibility:hidden'><a href='javascript:submitPrevNext("+(start+14)+","+(end+14)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");
				%>				
					<input type=hidden name='whichPage' id='whichPage' value='next'></td> 
				<%
			//}
		%>
		
		</tr>		
		</table>
		<br>
		<br>
		</tr>
	</table>
			<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'>
				<th width='10%'><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></th>
				<th width='35%' align=left>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eIP.RoomCubicleDescription.label" bundle="${ip_labels}"/></th>
				<th width='25%'><fmt:message key="Common.levelofcare.label" bundle="${common_labels}"/> </th> 
				<th width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>  </th>
			<%	 
		
				}

/*		if (start != 0)
		{
		   for(int j=1; j<=start; i++,j++)
		   {
				rs.next();
		   }
		}
*/
	/*pstmt=con.prepareStatement("select LEVEL_OF_CARE_CODE,LEVEL_OF_CARE_DESC from ip_nursing_unit_vw where FACILITY_ID = ? and nursing_unit_code = ? ");

		while(rs.next())
		{ */
			String room_num = "",short_desc = "";
			room_num		=  rs.getString("room_num");
			short_desc		=  rs.getString("short_desc");
			no_of_beds		= rs.getString("no_of_beds");
			eff_status		= rs.getString("eff_status");

			LOC = rs.getString("LEVEL_OF_CARE_CODE");
			if(LOC == null) LOC="";
			

			// ADDED by SRIDHAR on 23 FEB 2004 
			if(accessRightRecSet.containsObject(room_num))  {
					chkAttribute = "CHECKED";
				
			}
				
			else
			{
				if(eff_status.equals("E"))
				{
					chkAttribute = "CHECKED";
					
				}
				else
				{
					chkAttribute = "";
					
				}
				
			}
			
			if( i%2 == 0)  
				classValue="QRYEVEN";
			else
				classValue="QRYODD";
			%>
		<tr>
			<td width='1%' class='<%=classValue%>'><%=room_num%></td>
			<td class='<%=classValue%>'><%=short_desc%></td>

		<!--||||||||  CODED BY SRIDHAR ON 25 FEB 2004  |||||||||-->
		<!-- ||||||||||||||| LEVEL OF CARE INDICATOR  ||||||||||||||||-->
		<!-- The Select Option values are populated from Nursing Unit.
		If value of [Level Of Care] Select option in Nursing Unit is null then all Default values will be populated from [am_level_of_care] table.
		If there exists a value in [Level of care] wrt Nursing Unit code then only that Level of care value is populated as option value -->

		<%
	
	//moved this query out of while loop....
	//pstmt=con.prepareStatement("select LEVEL_OF_CARE_CODE,LEVEL_OF_CARE_DESC from ip_nursing_unit_vw where FACILITY_ID = ? and nursing_unit_code = ? ");

	pstmt.setString(1,facility_id);
	pstmt.setString(2,nursing_unit);
	LevelRset=pstmt.executeQuery();
	Levelstmt=con.createStatement();

	if(LevelRset!=null)
	{
		while(LevelRset.next())
		{
			data=LevelRset.getString("LEVEL_OF_CARE_DESC");
			code=LevelRset.getString("LEVEL_OF_CARE_CODE");

			if(code == null)
			{
				Update_yn = "Y";
				//Levelstmt=con.createStatement();
				//moved outside looop...
				LevelRset=Levelstmt.executeQuery("select LEVEL_OF_CARE_CODE,LEVEL_OF_CARE_DESC from am_level_of_care where EFF_STATUS = 'E' order by LEVEL_OF_CARE_DESC");
				if(LevelRset!=null)
				{
					%>
					<td align='center' class='<%=classValue%>' width='15%'>
					<select name="level<%=i%>" id="level<%=i%>" onchange='ValueSelect(chk<%=i%>,"<%=i%>");'>
					<% if(LOC.equals(""))
					{	
						chkAttribute = ""; %>
						<option value='<%=LOC%>'>&nbsp;------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------&nbsp;   
						<%
					}
					while(LevelRset.next())
					{
						data=LevelRset.getString("LEVEL_OF_CARE_DESC");
						code=LevelRset.getString("LEVEL_OF_CARE_CODE");
						if(LOC.equals(code))
							sel = "selected";
						else
							sel="";
						out.println("<option value='"+code+"'"+sel+">"+data+"</option>");
					}
				}	
			}
			else 
			{
				Update_yn ="N";
				if(LOC.equals(code))
					sel = "selected";
				else
					sel="";
				%>
				<td align='left' class='<%=classValue%>'><%=data%>
				<input type="hidden" name="level<%=i%>" id="level<%=i%>" value="<%=code%>" ></td> 
				</td>
				<%
			}
		}
	}

		%>
		</select>
			<td align='center' class='<%=classValue%>'>
				<input type='checkbox' <%=chkAttribute%> name='chk<%=i%>'  value='<%=room_num%>' onclick='checkdis(this);SelectValue(this,"<%=i%>");RemSelectAll(this, <%=i%>);' >
				<input type='hidden' name='removeCode<%=i%>' id='removeCode<%=i%>' value="">
				<input type='hidden' name='rm_num<%=i%>' id='rm_num<%=i%>' value="<%=room_num%>">
				<input type='hidden' name='no_of_beds<%=i%>' id='no_of_beds<%=i%>' value= "<%=no_of_beds%>" >
				<input type="hidden" name="Update_yn" id="Update_yn" value="<%=Update_yn%>" ></td> 
				<input type="hidden" name="search_by" id="search_by" value="<%=search_by%>" ></td> 
				<input type="hidden" name="search_txt" id="search_txt" value="<%=search_txt%>" ></td> 
		   </td>
		</tr>
		<%

		i++;
		count++;
	} 

	if(count<14 || (!rs.next()))
		{%>
			<script>
				if(document.getElementById("next"))
					document.getElementById("next").style.visibility='hidden';
			</script>
		<%
		}
		else
		{%>
			<script>
				if(document.getElementById("next"))
					document.getElementById("next").style.visibility='visible';
			</script>
		<%
		}

	if(count == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		return;
	}
		// end of while		
		if(stmt != null)		stmt.close(); 
		if(stmt3 != null)		stmt3.close(); 
		if(rstlRs3 != null)		rstlRs3.close(); 
		if(pstmt != null)		pstmt.close(); 
		if(rset != null)		rset.close(); 
		if(Levelstmt != null)	Levelstmt.close(); 
		if(LevelRset != null)	LevelRset.close(); 

	}catch(Exception e){
		//out.print(e);
		e.printStackTrace();
		}
	finally
	  {
		ConnectionManager.returnConnection(con,request);
		session.setAttribute("AXSRightRecSet", accessRightRecSet);
		session.setAttribute("AXSRightRec", accessRightRec);
		session.setAttribute("AXSRight", accessRight);
	  }%>
		</table>
		<input type='hidden' name='norecords' id='norecords' value='<%=i%>' >	
	</form>
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

