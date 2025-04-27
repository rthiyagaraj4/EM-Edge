<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*,java.net.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="SimplifyPractNurs" scope="session" class="webbeans.eCommon.RecordSet" />
<jsp:useBean id="ClinicForPracts" scope="session" class="webbeans.eCommon.RecordSet" />
<jsp:useBean id="NextPrevRecClinis" scope="session" class="webbeans.eCommon.RecordSet" />
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); %>
<html>
<head>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
Connection con = null;
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eOP/js/menuItemCheck.js" language="javascript"></script>
<script language='javascript' src='../../eOP/js/OPPractitionerComponent.js'></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script language='javascript' src='../../eOP/js/ResourceForLocnByPract.js'></script>
<script language='javascript' src='../../eOP/js/ResourceForUnit.js'></script>
</head>
<%
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;
String fnval = request.getParameter("function")==null?"insertByPract":request.getParameter("function") ;

String whereClause = request.getParameter("whereclause")==null?"":request.getParameter("whereclause"); 
StringBuffer sql = new StringBuffer();
StringBuffer sql1 = new StringBuffer();

int start = 0;
int end = 0;
int i = 1;
int cnt = 0; 
String ext_count = "0";
String endOfRes="1";

 if ( from == null )
    start = 1 ;
else
    start = Integer.parseInt( from ) ;

if ( to == null )
    end = 10;
else
    end = Integer.parseInt( to ) ; 

String is_origin = request.getParameter("is_origin");
if(is_origin==null)is_origin="true";

try{
con=ConnectionManager.getConnection(request);    
PreparedStatement pstmt = null;
ResultSet rs = null;
String callfunc=request.getParameter("call_func");
String oper=request.getParameter("oper")==null?"":request.getParameter("oper");

Boolean isSimplifyPractNursUnit = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","SIMPLIFY_PRACT_FOR_NURS_RES");
Boolean fromSession = false;
String c_code ="";
if(is_origin.equals("true") && session.getAttribute("ResForLocnByPract") != null){
	session.removeAttribute("ResForLocnByPract");
}else{
	int page1 = end/10;
	HashMap<String, String> map = (HashMap<String, String>)(session.getAttribute("ResForLocnByPract")==null ? new HashMap<String, String>() : session.getAttribute("ResForLocnByPract")) ;
	c_code = map.get("c_clinic_id"+page1);
	if(c_code != null){
		NextPrevRecClinis.clearAll();
		String[] NextPrevCodes = c_code.split(",");
		for(String npCode : NextPrevCodes){
			NextPrevRecClinis.putObject(npCode);	
		}
		fromSession = true;
	}
}

String practname="";
String effstatus="E";

String facilityid=(String)session.getValue("facility_id");
String care_locn_type_ind = (request.getParameter("unit_type") == null)?"":request.getParameter("unit_type");
String practitionerid=(request.getParameter("pract_id") == null)?"":request.getParameter("pract_id");
String speciality_id=(request.getParameter("speciality_id") == null)?"":request.getParameter("speciality_id");
String search_desc=(request.getParameter("search_desc") == null)?"":request.getParameter("search_desc");
String search_by=(request.getParameter("search_by") == null)?"":request.getParameter("search_by");

String checkClinic = "";
String checkClinicValue = "N";
String proceedToByLocn = "N";
String ext_count_str = "";

sql1.append("select clinic_code  from op_pract_for_clinic where practitioner_id = ? and facility_id = ? and resource_class = 'P'");

pstmt = con.prepareStatement(sql1.toString());
pstmt.setString(1, practitionerid);
pstmt.setString(2, facilityid);
rs = pstmt.executeQuery();
ClinicForPracts.clearAll();
SimplifyPractNurs.clearAll();
int cntOFPract = 0;
if(rs != null){
	while(rs.next()){
		ext_count = rs.getString("clinic_code");
		ClinicForPracts.putObject(ext_count);
		
		if(cntOFPract == 0){
			ext_count_str = "'"+ext_count+"'";
		}else{
			ext_count_str = ext_count_str + ",'"+ext_count+"'";	
		}
		cntOFPract++;
	}
}
if(cntOFPract <= 0 && oper.equals("create")){
sql1.setLength(0);
if(pstmt!=null)pstmt.close();
if(rs!=null)rs.close();
sql1.append("SELECT locn_code FROM am_locn_for_oper_stn WHERE oper_stn_id = (SELECT oper_stn_id	FROM am_user_for_oper_stn WHERE appl_user_id = (SELECT appl_user_id FROM sm_appl_user WHERE func_role_id = ?) AND (TO_DATE (SYSDATE, 'DD/MM/YYYY') >= TO_DATE (eff_date_from, 'DD/MM/YYYY') AND (eff_date_to IS NULL OR TO_DATE (SYSDATE, 'DD/MM/YYYY') <= TO_DATE (eff_date_to, 'DD/MM/YYYY'))) and facility_id = ?) ");

pstmt=con.prepareStatement(sql1.toString());
pstmt.setString(1, practitionerid);
pstmt.setString(2, facilityid);
rs = pstmt.executeQuery();
if(rs != null){
	while(rs.next()){
		SimplifyPractNurs.putObject(rs.getString(1));
	}
}

if(pstmt!=null)pstmt.close();
if(rs!=null)rs.close();

}

if(!whereClause.equals("")) 
	{
		sql.append(whereClause);   
   }else{

	   sql.append("SELECT a.practitioner_id, a.practitioner_name, b.clinic_code, B.long_desc locn_long_desc, b.care_locn_type_ind, am_get_desc.AM_SPECIALITY (b.speciality_code, 'en', 2 ) specialty_short_desc, b.speciality_code, b.clinic_type, b.PRIMARY_RESOURCE_CLASS, b.OPEN_TO_ALL_PRACT_YN FROM am_practitioner a, op_clinic b WHERE a.practitioner_id = ? AND b.clinic_type = ? and b.facility_id=? and (b.SPECIALITY_CODE in (select speciality_code from AM_PRACT_SPECIALITIES where facility_id = ? and practitioner_id = ? ) or b.SPECIALITY_CODE = a.PRIMARY_SPECIALITY_CODE) and (b.PRIMARY_RESOURCE_CLASS != 'P' OR b.OPEN_TO_ALL_PRACT_YN != 'Y') and b.eff_status = 'E' ");
//	   sql.append("SELECT a.practitioner_id, a.practitioner_name, b.clinic_code, B.long_desc locn_long_desc, b.care_locn_type_ind, am_get_desc.AM_SPECIALITY (b.speciality_code, 'en', 2 ) specialty_short_desc, b.speciality_code, b.clinic_type, b.PRIMARY_RESOURCE_CLASS, b.OPEN_TO_ALL_PRACT_YN FROM am_practitioner a, op_clinic b WHERE a.practitioner_id = ? AND b.clinic_type = ? and b.facility_id=? and b.SPECIALITY_CODE = a.PRIMARY_SPECIALITY_CODE and (b.PRIMARY_RESOURCE_CLASS != 'P' OR b.OPEN_TO_ALL_PRACT_YN != 'Y') and b.eff_status = 'E' ");
	
	
	if(!speciality_id.equals("")){
		sql.append(" and b.speciality_code = '"+ speciality_id +"' ");
	}
	
	if(!search_by.equals("") && !search_desc.equals("")){
		if(search_by.equals("c")){
			sql.append(" and b.clinic_code like '%"+search_desc.toUpperCase()+"%' ");
		}else if(search_by.equals("d")){
			sql.append(" and UPPER(b.long_desc) like UPPER('%"+search_desc+"%')");//Modified By Gaurav for ML-MMOH-SCF-3045
		}	
	}
	
	if(oper.equals("modify")){
		sql.append(" and b.clinic_code in ("+ ext_count_str+")");
	}
	
	sql.append("order by B.long_desc asc");
}
System.err.println("168 in ResourceForLocnByPractCritResult.jsp sql="+sql.toString());
	pstmt=con.prepareStatement(sql.toString());
	pstmt.setString(1, practitionerid);
	pstmt.setString(2, care_locn_type_ind.toUpperCase());
	pstmt.setString(3, facilityid);
	pstmt.setString(4, facilityid);
	pstmt.setString(5, practitionerid);
	rs=pstmt.executeQuery();
	// Added for ML-MMOH-SCF-3045 start
	int rowCount = 0;
	if(cntOFPract <= 0 && oper.equals("create")){
		sql1.setLength(0);
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		HashMap<String, String> map1 = (HashMap<String, String>)(session.getAttribute("ResForLocnByPract")==null ? new HashMap<String, String>() : session.getAttribute("ResForLocnByPract"));
		String c_clinic_id="";
		// if(!fromSession){
		pstmt2=con.prepareStatement(sql.toString());
		pstmt2.setString(1, practitionerid);
		pstmt2.setString(2, care_locn_type_ind.toUpperCase());
		pstmt2.setString(3, facilityid);
		pstmt2.setString(4, facilityid);
		pstmt2.setString(5, practitionerid);
		rs2=pstmt2.executeQuery();
		int mapcnt=0;
		int prevPageno=1;
		while(rs2.next()){
			++mapcnt;
			int pageno = (int) Math.ceil(mapcnt/10.0);
			if(pageno<=prevPageno){
				prevPageno=pageno;
			}else{
				c_clinic_id="";
				prevPageno=pageno;
			}
			if(SimplifyPractNurs.containsObject(rs2.getString("clinic_code"))){
				if(c_clinic_id.equals(""))
					c_clinic_id=rs2.getString("clinic_code");
				else
					c_clinic_id=c_clinic_id+","+rs2.getString("clinic_code");
			}
			if(map1.get("page")!=null){
				int page1 = Integer.parseInt(map1.get("page"));
					if(pageno > page1){
					map1.put("c_clinic_id"+pageno, c_clinic_id);
					}
				}else{
					map1.put("c_clinic_id"+pageno, c_clinic_id);
				}
		}
		map1.put("oper", oper);
		map1.put("cntOFPract",Integer.toString(cntOFPract));
		map1.put("prevPageno",Integer.toString(prevPageno));
		session.setAttribute("ResForLocnByPract", map1);
		if(pstmt2!=null)pstmt2.close();
		if(rs2!=null)rs2.close();
	}
	 // Added for ML-MMOH-SCF-3045 end
%>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();' onKeyPress=''> 
<form name="clinic_res_by_pract_form" id="clinic_res_by_pract_form" action="../../eOP/jsp/ResourceForLocnByPractCritResult.jsp" method="post" target="messageFrame">
<table align='right'>
<tr>
<td>
<%
if ( !(start== 1) )			
	for( int j=1; j<start; i++,j++ )   
		rs.next() ; 

while(i <= end &&  rs.next())
{
	if(cnt == 0){
%>
</td>
</tr>
</table><br><br>	

<tr width='100%' >
				<td align='right' class='white'>
					<table align='right'><tr>
						   <td>
							<%
							if ( !(start <= 1) )
							{
								out.println("<A HREF='javascript:submitPrevNext("+(start-10)+","+(end-10)+", "+start+", "+end+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
							}
							if (endOfRes.equals("1"))
							 {
								out.println("<A id='nextval' HREF='javascript:submitPrevNext("+(start+10)+","+(end+10)+", "+start+", "+end+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
							 }

							%>
								</td>
								</tr>
								</table>
							</td>
							</tr>

	<table border="1" cellpadding="0" cellspacing="0" width="80%" align="center" >	
		<tr>
			<th class='columnheader' align="left"> <fmt:message key="Common.Location.label" bundle="${common_labels}"/> </td>			
			<th class='columnheader' align="left"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>			
			<th class='columnheader' align="left"></td>			
			<th class='columnheader' align="left"><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> <input type='checkbox' onClick='toggle_check(this, <%=start %>, <%=end%>);'> </td>
		</tr>	
		<%}
		if(ClinicForPracts.containsObject(rs.getString("clinic_code"))){
			proceedToByLocn = "Y";
		}
	
		if(SimplifyPractNurs.containsObject(rs.getString("clinic_code")) || ClinicForPracts.containsObject(rs.getString("clinic_code"))){
			checkClinic = " checked ";
			checkClinicValue = "Y";
		}else{
			checkClinic = " ";
			checkClinicValue = "N";
		}
		//Added by Ajay Hatwate for ML-MMOH-SCF-3045
		if(fromSession){
			if(c_code != null){
				if(NextPrevRecClinis.containsObject(rs.getString("clinic_code"))){
					checkClinic = " checked ";
					checkClinicValue = "Y";
				}else{
					checkClinic = " ";
					checkClinicValue = "N";
				}
			}
		}
		%>
		<tr>
		<td width='20%' class='fields'> <%=rs.getString("locn_long_desc") %></td>
		<td width='20%' class='fields'> <%=rs.getString("specialty_short_desc") %> </td>
		
		<td width='20%' class='fields' style="background-color:white"> 
		<span style="font-size:8pt; cursor: pointer;color:blue;" OnMouseOver="Tip(reasonToolTip1('<%=rs.getString("practitioner_id") %>','<%=rs.getString("speciality_code") %>','<%=rs.getString("clinic_code") %>', '<%=care_locn_type_ind %>', '<%= rs.getString("clinic_type")%>', '<%=proceedToByLocn %>'))"  onmouseout="UnTip()" onclick="pointToLocn('<%=rs.getString("practitioner_id") %>','<%=rs.getString("speciality_code") %>','<%=rs.getString("clinic_code") %>', '<%=care_locn_type_ind %>', '<%= rs.getString("clinic_type")%>', '<%=proceedToByLocn %>')" >
			<fmt:message key="Common.WeekAppl.label" bundle="${common_labels}"/> 
		</span>
		</td>
		
		<td width='20%' class='fields'> <input type='checkbox' name='check_<%=i%>' onClick="setChecked(this, '<%=i%>')" <%=checkClinic %> /> 
		<input type='hidden' name="code<%=i%>" value="<%=rs.getString("clinic_code")%>" />
		<input type='hidden' name="checked<%=i%>" value="<%=checkClinicValue %>" />
		 </td>
		</tr>
	<%
	i++;
	cnt++;
} 
%>	
<!-- <div name='tooltiplayer1' id='tooltiplayer1' style='width:30%; visibility:hidden;' bgcolor='blue' ></div> -->
<input type='hidden' name = 'facility_id' value = '<%=facilityid%>'/>
<input type='hidden' name = 'pract_id' value = '<%=practitionerid%>'/>
<input type='hidden' name = 'clinic_type' value = '<%=care_locn_type_ind.toUpperCase()%>'/>
<input type='hidden' name = 'isSimplifyPractNursUnit' value = '<%=isSimplifyPractNursUnit%>'/>
<input type='hidden' name = 'speciality_id' value = '<%=speciality_id%>'/>
<input type='hidden' name = 'search_by' value = '<%=search_by%>'/>
<input type='hidden' name = 'search_desc' value = '<%=search_desc%>'/>
<input type ='hidden' name='called_from' id='called_from' value='RES_BY_PRACT'>
<input type="hidden" name="function" id="function" value="<%=fnval%>">
<input type="hidden" name="start" id="start" value="<%=start%>">
<input type="hidden" name="end" id="end" value="<%=end%>">
<input type="hidden" name="oper" id="oper" value="<%=oper%>">
<input type="hidden" name="count" id="count" value="<%=cnt%>">
<input type=hidden name='isOnApply' id='isOnApply' value='N'>
</form>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript' src='../../eOT/js/wz_tooltip.js'></script>
	</body>
	</html>
	<%
	if (!rs.next() && cnt!=0 )
	{
	endOfRes = "0";	
	%>
		<script>
		document.getElementById('nextval').innerHTML=" ";
		</script>
	<%
	}
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();

}catch(Exception e){
		e.printStackTrace();
	}
	finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}

if(cnt==0)	
	   out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
%>

