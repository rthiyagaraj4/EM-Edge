<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locn = request.getParameter("locn");
	String pract = request.getParameter("pract");
	String fromday = request.getParameter("fromday");
	String P_flag = request.getParameter("p_flag");
	Connection con = null;
	String facilityId = (String)session.getValue("facility_id");
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	String sql="";
	String dat="";
	String id = "";
	String locn_id="";
	String locn_type = "";
	String opentoall = "";
	String day_in_caps="";
    String locale=(String)session.getAttribute("LOCALE");

	String default_select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	
	StringTokenizer st = new StringTokenizer(locn,"|");
	while (st.hasMoreTokens())
	{

			locn_id = st.nextToken();
			locn_type = st.nextToken();
			opentoall = st.nextToken();

	}
%><html><HEAD>	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='testform' id='testform'><%
	try {

	con = ConnectionManager.getConnection(request);
 	stmt = con.createStatement() ;

		if((pract.equals("") || pract == null) && (fromday.equals("") || fromday == null)){
		if (!(locn_id.equals("") || locn_id == null))
		{


		%>
			<script>
			parent.frames[1].document.getElementById(locn_type).innerText = '<%=locn_type%>';
			var opt = parent.document.frames[1].document.createElement("OPTION");
			opt.text = "----<%=default_select%>----";
			opt.value= '';
			parent.frames[1].document.forms[0].practitioner.add(opt);

			</script>
			<%
			if(opentoall.equals("Y")){
			//	sql  = " select practitioner_id, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name from  am_pract_for_facility where eff_status = 'E'  and operating_facility_id = '"+facilityId+"'  order by 2";
				sql  = " select practitioner_id, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1') practitioner_name from  am_pract_for_facility where eff_status = 'E'  and operating_facility_id = ? order by 2";
			}else{
			   //sql="Select a.practitioner_id, b.practitioner_name practitioner_name from am_pract_for_facility a,  am_practitioner_lang_vw b, op_clinic c  where b.language_id = '"+locale+"' and b.practitioner_id = a.practitioner_id  and a.eff_status = 'E' and a.facility_id = '"+facilityId+"'  and c.facility_id = a.facility_id and c.clinic_code = '"+locn_id+"' and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = '"+facilityId+"' and  practitioner_id = b.practitioner_id ))  and nvl(c.pract_type, b.pract_type) = b.pract_type order by practitioner_name";
			   sql="Select a.practitioner_id, b.practitioner_name practitioner_name from am_pract_for_facility a,  am_practitioner_lang_vw b, op_clinic c  where b.language_id = ? and b.practitioner_id = a.practitioner_id  and a.eff_status = 'E' and a.facility_id = ?  and c.facility_id = a.facility_id and c.clinic_code = ? and (c.speciality_code = b.primary_speciality_code or c.speciality_code in (select speciality_code from am_pract_specialities where facility_id = ? and  practitioner_id = b.practitioner_id ))  and nvl(c.pract_type, b.pract_type) = b.pract_type order by practitioner_name";
			}
				
			//rs = stmt.executeQuery(sql) ;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,facilityId);
			if(opentoall.equals("Y")){
			}else{
			pstmt.setString(3,locn_id);
			pstmt.setString(4,facilityId);
			}
			rs = pstmt.executeQuery();
			if (rs != null)
			{
				while(rs.next())
				{
					

					dat=rs.getString("practitioner_name");
					id=rs.getString("practitioner_id");
					
		%>
					<script>
							var element = parent.frames[1].document.createElement('OPTION');
							element.text = "<%=dat%>";
							element.value= "<%=id%>";
							parent.frames[1].document.forms[0].practitioner.add(element);

					</script>

<%
				}
		}
		if(rs !=null) rs.close();
}


}

if(P_flag.equals("Y")){
if(pract.equals("") || pract == null ){
if (!(locn_id.equals("") || locn_id == null))
{



			
			sql = "Select initcap(DAY_OF_WEEK)day_week, DAY_NO FROM SM_DAY_OF_WEEK Order by 2 ";
			rs = stmt.executeQuery(sql) ;

			if (rs != null)
			{
				while(rs.next())
				{
					dat=rs.getString("day_week");
					id=rs.getString("DAY_NO");

					if(dat.equals("Monday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(dat.equals("Tuesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(dat.equals("Wednesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(dat.equals("Thursday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(dat.equals("Friday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(dat.equals("Saturday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(dat.equals("Sunday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

%>
			<script>
					var element = parent.frames[1].document.createElement('OPTION');
					element.text = "<%=dat%>";
					element.value= "<%=dat%>";
					parent.frames[1].document.forms[0].from_day.add(element);

			</script>

<%
				}
		}
		if(rs !=null) rs.close();
}
}
}

if(fromday.equals("") || fromday == null){
if(!(locn_id.equals("") || locn_id == null)){
if (!(pract.equals("") || pract == null))
{

%>
			<script>
			var opt = parent.frames[1].document.createElement("OPTION");
			opt.text = "----<%=default_select%>----";
			opt.value= '';
			parent.frames[1].document.forms[0].from_day.add(opt);
			</script>
			<%
				sql = "Select initcap(DAY_OF_WEEK)day_week, DAY_NO FROM SM_DAY_OF_WEEK Order by 2 ";
			rs = stmt.executeQuery(sql) ;

			if (rs != null)
			{
				while(rs.next())
				{

					dat=rs.getString("day_week");
					id=rs.getString("DAY_NO");
					day_in_caps	=dat.toUpperCase();
					
					 
					 

					if(dat.equals("Monday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(dat.equals("Tuesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(dat.equals("Wednesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(dat.equals("Thursday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(dat.equals("Friday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(dat.equals("Saturday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(dat.equals("Sunday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

%>
			<script> /* Below line was modified by venkatesh.s on 24-Oct-2013 against SKR-SCF-0875 [IN044515]*/
					var element = parent.frames[1].document.createElement('OPTION');
					element.text = "<%=dat%>";
					element.value= "<%=day_in_caps%>";
					parent.frames[1].document.forms[0].from_day.add(element);

			</script>

<%
				}
		}
		if(rs !=null) rs.close();
}
}
}

if(!(fromday.equals("") || fromday == null)){
if(!(locn_id.equals("") || locn_id == null)){

%>
			<script>
			var opt = parent.frames[1].document.createElement("OPTION");
			opt.text = "----<%=default_select%>----";
			opt.value= '';
			parent.frames[1].document.forms[0].to_day.add(opt);
			</script>
			<%
		//sql = "Select initcap(DAY_OF_WEEK)day_week, DAY_NO FROM SM_DAY_OF_WEEK where initcap(rtrim(DAY_OF_WEEK)) != rtrim('"+fromday+"') Order by 2 ";
		sql = "Select initcap(DAY_OF_WEEK)day_week, DAY_NO FROM SM_DAY_OF_WEEK where initcap(rtrim(DAY_OF_WEEK)) != rtrim(?) Order by 2 ";
		//	rs = stmt.executeQuery(sql) ;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,fromday);
			rs = pstmt.executeQuery();
			if (rs != null)
			{
				while(rs.next())
				{
					dat=rs.getString("day_week");
					id=rs.getString("DAY_NO");
                    day_in_caps	=dat.toUpperCase();
					if(dat.equals("Monday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(dat.equals("Tuesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(dat.equals("Wednesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(dat.equals("Thursday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(dat.equals("Friday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(dat.equals("Saturday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(dat.equals("Sunday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}
%>
			<script>
					var element = parent.frames[1].document.createElement('OPTION');
					element.text = "<%=dat%>";
					/* Below line was modified by venkatesh.s on 24-Oct-2013 against SKR-SCF-0875 [IN044515]*/
					element.value= "<%=day_in_caps%>";
					parent.frames[1].document.forms[0].to_day.add(element);

			</script>

<%
				}
			}
			if(rs !=null) rs.close();
	}
	}
	if(rs != null) rs.close();
	if(rs1 != null) rs1.close();
	if(stmt != null)stmt.close();
}catch(Exception e){
//out.print("thre :" +e);
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
	
	ConnectionManager.returnConnection(con,request);
}

%>
</form>
</body>
</html>

