<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
    request.setCharacterEncoding("UTF-8");
   String facilityid = request.getParameter("operating_facility_id");
   String   locale = (String)session.getValue("LOCALE");
   String facility_id =  (String) session.getValue( "facility_id" ) ;
  String  locncode=request.getParameter("locn_code");
  String  flag =request.getParameter("flag");
  String service_code=request.getParameter("service_code");
  String subservicecode="";
  String subservicedesc="";
  String open_pract_yn="";
  /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
  String room_short_desc="";
  /*CRF end SS-CRF-0010 [IN034516]*/
   if(flag ==null  ) flag="";
    if(locncode==null)locncode="";
     Connection con = null;
	try
	{
		con=ConnectionManager.getConnection(request);

		PreparedStatement pstmt=null;
		ResultSet rs;
		//commented  by Raj when dealing with unclosed connections, statements and resultsets on 10/17/2003

		String servicecode="";
		String servicedesc="";	
        String roomcode="";
		String roomdesc="";
		String  visittypecode="";
		String   visittypedesc="";
		String sql="";
		
		if(flag.equals("visit_type"))
		{
		sql ="SELECT   service_code,  short_desc FROM   am_service_lang_vw WHERE  language_id=? and eff_status = 'E' AND service_code in (SELECT service_code FROM op_clinic WHERE clinic_code =? AND   facility_id=? UNION SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code =? AND b.facility_id=? and b.care_locn_type_ind = 'C') order by 2";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locncode);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,locncode);
		pstmt.setString(5,facility_id);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			servicecode=rs.getString("service_code");
			servicedesc=rs.getString("short_desc");
			
			%>	
				<script>
				var temp = "<%=servicecode%>";
				var temp1="<%=servicedesc%>";
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				//var opt=parent.document.frames[1].document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				parent.f_query_add_mod.document.forms[0].service.add(opt);
						
			</script>
				
			<%	
				}
				%>
		
			<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		
		<%
				
		}
		else if(flag.equals("visit_details"))
		{

   		sql ="SELECT   service_code,  short_desc FROM   am_service_lang_vw WHERE  language_id=? and eff_status = 'E' AND service_code in (SELECT service_code FROM op_clinic WHERE clinic_code =? AND   facility_id=? UNION SELECT b.service_code FROM OP_CLINIC_FOR_SERVICE b WHERE b.clinic_code =? AND b.facility_id=? and b.care_locn_type_ind = 'C') order by 2";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,locncode);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,locncode);
		pstmt.setString(5,facility_id);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			servicecode=rs.getString("service_code");
			servicedesc=rs.getString("short_desc");
			%>	
				<script>
				var temp = "<%=servicecode%>";
				var temp1="<%=servicedesc%>";
				//var opt=parent.document.frames[1].document.createElement("OPTION");
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				//parent.document.frames[1].document.forms[0].service_desc.add(opt);
				parent.f_query_add_mod.document.forms[0].service_desc.add(opt);
						
			</script>
		
	<%	}
	
	if(pstmt != null) pstmt.close();
	if (rs != null) rs.close();
	// query tuning.. modified by venkat S
	 /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */

	sql ="SELECT a.practitioner_id ROOM_NO, b.room_type room_type,am_get_desc.am_facility_room (a.facility_id,a.practitioner_id,?, 2) room_desc FROM op_pract_for_clinic a,  am_facility_room b WHERE a.facility_id=? AND a.clinic_code=? AND  a.eff_status='E' AND  a.resource_class='R' AND  a.practitioner_id=b.room_num  AND a.facility_id=b.OPERATING_FACILITY_ID ";
	/*CRF end SS-CRF-0010 [IN034516]*/
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,locncode);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			roomcode       =rs.getString("ROOM_NO");
			roomdesc       =rs.getString("room_type");
			/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
            room_short_desc=rs.getString("room_desc");
			/*CRF end SS-CRF-0010 [IN034516]*/
			%>	
				<script>
				var temp = "<%=roomdesc%>";
				/* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
                var temp1="<%=roomcode%>"+" "+"<%=room_short_desc%>";
				/*CRF end SS-CRF-0010 [IN034516]*/
				var temp2="<%=roomcode%>";
				//var opt=parent.document.frames[1].document.createElement("OPTION");
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp2;
				/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
                //parent.document.frames[1].document.forms[0].room_desc.add(opt);
				parent.f_query_add_mod.document.forms[0].room_desc.add(opt);
				/*CRF end SS-CRF-0010 [IN034516]*/
						
			</script>
	
		<%
	
	}
		
		if(pstmt != null) pstmt.close();
	if (rs != null) rs.close();
	
	sql ="select visit_type_code, OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, VISIT_TYPE_CODE,?,'2') short_desc from op_visit_type_for_clinic where facility_id = ? and clinic_code =? and eff_status='E' order by 2";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,locncode);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			visittypecode=rs.getString("visit_type_code");
			visittypedesc=rs.getString("short_desc");
			%>	
				<script>
				var temp = "<%=visittypedesc%>";
				var temp1="<%=visittypecode%>";
				//var opt=parent.document.frames[1].document.createElement("OPTION");
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				opt.text=temp;
				opt.value=temp1;
				//parent.document.frames[1].document.forms[0].visit_type_desc.add(opt);
				parent.f_query_add_mod.document.forms[0].visit_type_desc.add(opt);
						
			</script>
	
		<%
	
	}
		
			if(pstmt != null) pstmt.close();
	    if (rs != null) rs.close();
		sql ="select open_to_all_pract_yn from op_clinic where facility_id=? and clinic_code=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,locncode);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
		open_pract_yn=rs.getString("open_to_all_pract_yn");
		
			}
		%>
		<script>
			var open_pract_yn = "<%=open_pract_yn%>";
			parent.f_query_add_mod.document.forms[0].open_pract_yn.value=open_pract_yn;
			</script>
		
	<%	}	
		else {
		
			sql="Select distinct service_code,service_short_desc from am_facility_service_vw where eff_status='E' and operating_facility_id= ? order by service_short_desc";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,facilityid);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				servicecode=rs.getString("service_code");
				servicedesc=rs.getString("service_short_desc");
		
			%>
				<script>
					var temp = "<%=servicecode%>";
					var temp1="<%=servicedesc%>";
					var opt=parent.f_query_add_mod.document.createElement("OPTION");
					opt.text=temp1;
					opt.value=temp;
					parent.f_query_add_mod.document.forms[0].service_code.add(opt);
				
				
				</script>
				<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
			<%
			}
		 	 
		}
				

		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();
if(flag.equals("sub service"))
		{
		
	
	sql ="SELECT  SUBSERVICE_CODE subservice_code, AM_GET_DESC.AM_SUBSERVICE(SERVICE_CODE,SUBSERVICE_CODE,?,'2') short_desc FROM AM_FACILITY_SUBSRVC WHERE  OPERATING_FACILITY_ID=? AND  SERVICE_CODE=? ORDER BY 2";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,service_code);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			subservicecode=rs.getString("subservice_code");
			subservicedesc=rs.getString("short_desc");
			%>	
				<script>
				var temp = "<%=subservicedesc%>";
				var temp1="<%=subservicecode%>";
				//var opt=parent.document.frames[1].document.createElement("OPTION");
				var opt=parent.f_query_add_mod.document.createElement("OPTION");
				opt.text=temp;
				opt.value=temp1;
				//parent.document.frames[1].document.forms[0].sub_service_desc.add(opt);
				parent.f_query_add_mod.document.forms[0].sub_service_desc.add(opt);
						
			</script>
	
		<%
	
	}
		
		if(pstmt != null) pstmt.close();
	if (rs != null) rs.close();
		
		
		}




String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");
	}catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	
	
	}
%>

