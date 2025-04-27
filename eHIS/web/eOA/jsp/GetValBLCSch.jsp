<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,java.util.*" %>

<%request.setCharacterEncoding("UTF-8");
	String locn = request.getParameter("locn");
	String pract = request.getParameter("pract");
	
	//out.println("locn inside getval"+locn);
	//out.println("locn inside getval"+pract);
	
	

	Connection con = null;
	String facilityId = (String)session.getValue("facility_id");
	Statement stmt=null;
    PreparedStatement pstmt=null;
	ResultSet rs = null;
	String sql="";
	String dat="";
	String locn_id="";

	StringTokenizer st = new StringTokenizer(locn,"|");
	while (st.hasMoreTokens())
	{
			locn_id = st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
	}
	%><html><HEAD>	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
					<Script src="../../eOA/js/BlockLiftCancelSch.js" language="JavaScript"></Script>
					<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='testform' id='testform'><%
	try{
	con = ConnectionManager.getConnection(request);
		if(pract.equals("") || pract == null){
		if (!(locn_id.equals("") || locn_id == null))
		{
		%>
			<script>
			

			</script>
			<%
		}
	}


if (!(locn_id.equals("") || locn_id == null))
{
		//int i=0;
           StringBuffer dispStr=new StringBuffer("");
          
			//sql  = "  select distinct initcap(b.day_of_week) wkdt, a.day_no from  oa_clinic_time_table a, sm_day_of_week b where facility_id = '"+facilityId+"'  and clinic_code = '"+locn_id+"' and a.day_no = b.day_no order by a.day_no ";
			sql  = "  select distinct initcap(b.day_of_week) wkdt, a.day_no from  oa_clinic_time_table a, sm_day_of_week b where facility_id = ? and clinic_code = ? and a.day_no = b.day_no order by a.day_no ";
			stmt = con.createStatement() ;
			//rs = stmt.executeQuery(sql) ;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,locn_id);
			rs = pstmt.executeQuery();
			if (rs != null)
			{
				while(rs.next())
				{
					dat=rs.getString("wkdt");
					if(dat.equals("Monday")){
						out.println("<script>parent.frames[1].document.getElementById('mon').disabled=false</script>");
					}else if(dat.equals("Tuesday")){
						out.println("<script>parent.frames[1].document.getElementById('tue').disabled=false</script>");
					}else if(dat.equals("Wednesday")){
						out.println("<script>parent.frames[1].document.getElementById('wed').disabled=false</script>");
					}else if(dat.equals("Thursday")){
						out.println("<script>parent.frames[1].document.getElementById('thu').disabled=false</script>");
					}else if(dat.equals("Friday")){
						out.println("<script>parent.frames[1].document.getElementById('fri').disabled=false</script>");
					}else if(dat.equals("Saturday")){
						out.println("<script>parent.frames[1].document.getElementById('sat').disabled=false</script>");
					}else if(dat.equals("Sunday")){
						out.println("<script>parent.frames[1].document.getElementById('sun').disabled=false</script>");
					}
				}


					/*if(dat.equals("Monday"))
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
								}*/


            /* if(rs.next()){
	         dispStr.append("<table id='id' border='0' cellpadding='0' cellspacing='0'  width='80%'>");
	           do{ 
					dayofweek =  rs.getString(1);
					dayofweek = dayofweek.substring(0, 3);
					//out.println("dayofweek"+dayofweek);
					
					i++;

					
				
				}while(rs.next());

				day_1_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Monday.label","common_labels");
				out.println("sssssssssss:"+day_1_desc);
		        day_2_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Tuesday.label","common_labels");
				day_3_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wednesday.label","common_labels");
				day_4_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Thursday.label","common_labels");
				day_5_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Friday.label","common_labels");
				day_6_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Saturday.label","common_labels");
				day_7_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sunday.label","common_labels");
				dispStr.append("<tr><td class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</td>");
				
                dispStr.append("<td class=fields width='7%' align='right'>&nbsp;"+day_1_desc+"<input type='checkbox' name='day_1' id='day_1' value='N' onClick='checkDay(this);' ></td>");
                dispStr.append("<td class=fields width='7%'>"+day_2_desc+"<input type='checkbox' name='day_2' id='day_2' value='N' onClick='checkDay(this);'  ></td>");
				dispStr.append("<td class=fields width='7%'>"+day_3_desc+"<input type='checkbox' name='day_3' id='day_3' value='N' onClick='checkDay(this);'></td>");
				dispStr.append("<td class=fields width='7%'>"+day_4_desc+"<input type='checkbox' name='day_4' id='day_4' value='N' onClick='checkDay(this);'></td>");
                dispStr.append("<td class=fields width='7%'>"+day_5_desc+"<input type='checkbox' name='day_5' id='day_5' value='N' onClick='checkDay(this);'  ></td>");
				dispStr.append("<td class=fields width='7%'>"+day_6_desc+"<input type='checkbox' name='day_6' id='day_6' value='N' onClick='checkDay(this);' ></td>");
                dispStr.append("<td class=fields width='7%'>"+day_7_desc+"<input type='checkbox' name='day_7' id='day_7' value='N' onClick='checkDay(this);' ></td>");


				 //dispStr.append("<td class=fields width='7%'>"+day_7_desc+"<input type='checkbox' //name='day_7' value='"+day_7+"' onClick='checkDay(this);' ></td>");

				dispStr.append("<td class=fields width='7%'></td>");
				dispStr.append("<td class=fields width='7%'></td>");
				dispStr.append("<td class=fields width='7%'></td>");
				dispStr.append("<td class=fields width='7%'></td>");
				dispStr.append("<td class=fields width='7%'></td>");
			   
					  
				dispStr.append("</tr></table>");*/

%>
		<script>
	       // parent.frames[1].document.getElementById("info").innerHTML="<%=dispStr.toString()%>";
			parent.frames[3].location.href='../../eCommon/jsp/error.jsp'
       </script>
	

<%
				//}
		//}

		
}
}


	if(stmt != null)stmt.close();
	if(rs != null) rs.close();


}catch(Exception e) { 
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
	ConnectionManager.returnConnection(con,request);
}

%>
</form>
</body>
</html>

