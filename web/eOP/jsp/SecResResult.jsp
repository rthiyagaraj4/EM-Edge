<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eOP/js/QmgmtRe_AssignPract.js" language='javascript'></script>
<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'> 

</head>
<script>
</script>
<BODY  class='CONTENT' onLoad='ClearMsg();' onMouseDown='CodeArrest()' onKeyDown='lockKey()' >
<form name='SecResForm' id='SecResForm' action='../../eOP/jsp/SecResResult.jsp' method='post' >
<%
	
	request.setCharacterEncoding("UTF-8");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String locale = (String) session.getValue("LOCALE") ;
	//String clinic_code="MUSP";
	//String sql="SELECT PRACTITIONER_ID,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"',2) practitioner_name FROM op_pract_for_clinic WHERE RESOURCE_CLASS='P'";
	String curpractid=request.getParameter("practList")==null?"":request.getParameter("curpractid");
	String sql="SELECT DISTINCT b.practitioner_id practitioner_id,b.practitioner_name practitioner_name,am_get_desc.AM_SPECIALITY(b.PRIMARY_SPECIALITY_CODE,'"+locale+"',1) primary_speciality FROM op_pract_for_clinic a,am_practitioner_lang_vw b,op_clinic c,am_pract_all_splty_vw d   WHERE b.language_id = ? AND (    UPPER (d.practitioner_id) LIKE UPPER (NVL (?, d.practitioner_id)) AND UPPER (b.practitioner_name) LIKE UPPER (NVL (?, b.practitioner_name)))AND UPPER (NVL (b.position_code, '123')) LIKE UPPER (NVL (null, NVL (b.position_code, '123'))) AND a.practitioner_id = b.practitioner_id AND a.clinic_code = c.clinic_code AND c.facility_id = a.facility_id AND b.practitioner_id = d.practitioner_id AND d.facility_id = NVL (?, d.facility_id) AND a.clinic_code = ? AND a.facility_id =? AND a.eff_status = 'E' AND EXISTS ( SELECT 1 FROM am_pract_for_facility WHERE practitioner_id = b.practitioner_id AND facility_id =? AND eff_status = 'E') AND ('Y' = (CASE WHEN c.open_to_all_pract_yn = 'N' THEN (SELECT get_pract_working_yn(?,?,d.practitioner_id) FROM DUAL) ELSE 'Y' END ))  and a.practitioner_id not in '"+curpractid+"' order by practitioner_name";
	String searchby=request.getParameter("search_by")==null?"":request.getParameter("search_by");
	String searchtext=request.getParameter("search_text")==null?"":request.getParameter("search_text");
	String searchcriteria=request.getParameter("searchcriteria")==null?"":request.getParameter("searchcriteria");
	String excludePract=request.getParameter("excludePract")==null?"":request.getParameter("excludePract");
	String clinic_code=request.getParameter("clinic_code");
	String appt_id=request.getParameter("appt_id");
	String practCount=request.getParameter("practCount")==null?"0":request.getParameter("practCount");
	String practList=request.getParameter("practList")==null?"":request.getParameter("practList");
	
	String excludePractFormatted="";
	//if(excludePract!=null && !excludePract.equals("")){		
		//excludePractFormatted="'"+excludePract.replaceAll(",","','");
		//excludePractFormatted = excludePractFormatted.substring(0,excludePractFormatted.length()-2);
		//sql=sql+" and instruction_id not in ("+excludePractFormatted+") ";
	//}
// 	StringBuffer sql = new StringBuffer();
	//String from  = request.getParameter( "from" ) ;
	//String to    = request.getParameter( "to" ) ;
	String selectedPract    = request.getParameter( "selectedPract" ) ;
	if (selectedPract ==null || selectedPract.equals("null"))
		selectedPract="";
	int andCheck = 0;
	int pract_count=0;
	
//	int start = 0 ;
	//int end = 0 ;
	int i=1;
	//String endOfRes="1";
//	if ( from == null )
	//	start = 1 ;
//	else
	//	start = Integer.parseInt( from ) ;

	//if ( to == null )
	//  	end = 14 ;
	//else
	//	end = Integer.parseInt( to ) ;
	Connection conn = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;
	ArrayList<String> mappedSecRes=new ArrayList<String>();
	//mappedSecRes.add(curpractid);
	try{		
			conn=ConnectionManager.getConnection(request);
			/*String secResSql="select distinct resource_id from oa_resource_for_appt where appt_ref_no='"+appt_id+"' and facility_id='"+facilityId+"' union select attend_practitioner_id from pr_encounter where appt_id='"+appt_id+"' and facility_id='"+facilityId+"' ";
			PreparedStatement pstmtSecRes=conn.prepareStatement(secResSql);
			ResultSet rsSecRes=pstmtSecRes.executeQuery();
			while(rsSecRes.next()){
				mappedSecRes.add(rsSecRes.getString("resource_id"));
			}*/
			StringTokenizer practTokens=new StringTokenizer(practList,"$");
			while(practTokens.hasMoreTokens()){
				mappedSecRes.add(practTokens.nextToken());
			}
			stmt=conn.prepareStatement(sql);
			/*if(searchby.equals("C")){
				if (searchcriteria.equals("S")){					
					stmt.setString(1,searchtext+"%");
				}else if (searchcriteria.equals("E")){
					stmt.setString(1,"%"+searchtext);
				}else if (searchcriteria.equals("C")){
					stmt.setString(1,"%"+searchtext+"%");
				}
				//stmt.setString(1,searchtext+"%");
				//stmt.setString(2,"%");
			}else{				
				stmt.setString(1,"%");
				//stmt.setString(2,searchtext+"%");
				/*if (searchcriteria.equals("S")){
					stmt.setString(2,searchtext+"%");
				}else if (searchcriteria.equals("E")){
					stmt.setString(2,"%"+searchtext);
				}else if (searchcriteria.equals("C")){
					stmt.setString(2,"%"+searchtext+"%");
				}*/
			//}
			stmt.setString(1,locale);
			if(searchby.equals("C")){
				if (searchcriteria.equals("S")){					
					stmt.setString(2,searchtext+"%");
				}else if (searchcriteria.equals("E")){
					stmt.setString(2,"%"+searchtext);
				}else if (searchcriteria.equals("C")){
					stmt.setString(2,"%"+searchtext+"%");
				}				
				stmt.setString(3,"%");
			}else{
				stmt.setString(2,"%");				
				if (searchcriteria.equals("S")){
					stmt.setString(3,searchtext+"%");
				}else if (searchcriteria.equals("E")){
					stmt.setString(3,"%"+searchtext);
				}else if (searchcriteria.equals("C")){
					stmt.setString(3,"%"+searchtext+"%");
				}
			}
			//stmt.setString(2,searchtext);
			//stmt.setString(3,searchtext);
			stmt.setString(4,facilityId);
			stmt.setString(5,clinic_code);
			stmt.setString(6,facilityId);
			stmt.setString(7,facilityId);
			stmt.setString(8,facilityId);
			stmt.setString(9,clinic_code);
			rs=stmt.executeQuery();

			//String codeArray[]=selectedPract.split(",");
			String codeChecked="";

		//	if ( start != 1 )
		// for( int j=1; j<start; i++,j++ ){
	//		rs.next() ;
	//	  }%>
			
					

					<%

					String classValue="";
				while (rs.next()  )
				{ 
					if(maxRecord == 0)
			{%>
				<table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>
					<tr>
					<th><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/> </th>
					<th><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/> </th>
					<th><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/> </th>
					<th><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> </th>
					</tr>
			<%}
					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
						classValue = "QRYODD" ;
						codeChecked="";
						
						
						if(mappedSecRes.contains(rs.getString("practitioner_id"))){
							codeChecked="checked";
							pract_count++;
							selectedPract=selectedPract+rs.getString("practitioner_id")+"$";
						}else{
							if(curpractid.equals(rs.getString("practitioner_id"))){
								codeChecked="checked";
							}
						}
						out.println("<tr><td class='" + classValue + "'><font size='1'>"+rs.getString("practitioner_id")+"</td>");
						out.println("<td class='" + classValue + "'><font size='1'>"+rs.getString("practitioner_name")+"</td>");
						out.println("<td class='" + classValue + "'><font size='1'>"+rs.getString("primary_speciality")+"</td>");
						out.println("<td class='" + classValue + "'><input type='checkbox' name='practChk"+i+"' id='practChk"+i+"' onclick='addSelectedIns(this,"+i+");' "+codeChecked+"/></td></tr>");
						out.println("<input type='hidden' name='practCode"+i+"' id='practCode"+i+"' value='"+rs.getString("PRACTITIONER_ID")+"' />");
						

					i++;
					maxRecord++;
				}

				//if( !rs.next() && maxRecord!=0 )
						//{
							//endOfRes="0";
						
					//	}
				%><input type='hidden' name='Prac_count' id='Prac_count' value='<%=pract_count%>'/>
				<input type='hidden' name='selectedPract' id='selectedPract' value='<%=selectedPract%>'/>
				<input type='hidden' name='selectedPract1' id='selectedPract1' value='<%=selectedPract%>'/>
				<input type='hidden' name='excludePract' id='excludePract' value='<%=excludePract%>'/>
				<input type='hidden' name='practCount' id='practCount' value='<%=practCount%>'/>
				<input type='hidden' name='search_text' id='search_text' value='<%=searchtext%>'/>
				<input type='hidden' name='search_by' id='search_by' value='<%=searchby%>'/>
				<input type='hidden' name='searchcriteria' id='searchcriteria' value='<%=searchcriteria%>'/>
				<input type='hidden' name='calledFromOK' id='calledFromOK' value=''/>
				<%
		
			if(maxRecord == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			}

			boolean flag = false;
	
			
	}catch(Exception e){ out.println(e);e.printStackTrace();
	}
	finally   
	{
		if(stmt!=null) stmt.close();
		if(rs!=null) 	 rs.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
</form>
</BODY>
</HTML>
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

