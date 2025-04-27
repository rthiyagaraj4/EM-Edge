<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*" %>
	
<%

%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
					
<Script Language="JavaScript" src="../../eOA/js/Blockapptslots.js"></Script>
	
	

<HTML><head>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>


</head>

<BODY  class='CONTENT' onLoad='ClearMsgFrame()' onKeyDown = 'lockKey()'>
<%
request.setCharacterEncoding("UTF-8");	

	String whereClause = request.getParameter("whereclause");

	StringBuffer sql =new StringBuffer("");
	String from = request.getParameter( "from" ) ;
	String locale = (String)session.getAttribute("LOCALE");

	
	String facilityid=(String)session.getValue("facility_id");
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	
	String location_code= request.getParameter("location_code");
	String location_desc = request.getParameter("long_desc");
	String pract_id=request.getParameter("pract_id");
	String pract_name=request.getParameter("pract_name");
	String block_date=request.getParameter("block_date");
	block_date=DateUtils.convertDate(block_date,"DMY",locale,"en");

	String locn_type=request.getParameter("locn_type");
	if(locn_type == null) locn_type ="";
	String resource_type=request.getParameter("resource_type");
	if(resource_type== null)resource_type ="";
	location_code=location_code.toUpperCase();
	pract_id = pract_id.toUpperCase();

	if ( !(location_code == null || location_code.equals("")) )
		{
		sql.append("and upper(clinic_code) like upper('"+location_code+"%')");
		}
	
	if ( !(location_desc == null || location_desc.equals("")) )
		{
			sql.append("and upper(OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1')) like upper('"+location_desc+"%')");
		}
		
	if ( !(pract_id == null || pract_id.equals("")) )
		{
			sql.append("and upper(PRACTITIONER_ID) like upper('"+pract_id+"%')");
		}
		
		
		if ( !(pract_name == null || pract_name.equals("")) )
			{
				sql.append("and upper(AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1')) like upper('"+pract_name+"%')");
			}

	if ( !(block_date == null || block_date.equals("")) )
			{
				sql.append("and BLOCK_DATE  =to_date('"+block_date+"','dd/mm/yyyy')");
			}
	if (! (locn_type == null || locn_type.equals("")))
		{
			sql.append("and upper (care_locn_type_ind ) like upper ('"+locn_type+"%')");
		}

	if(!(resource_type == null || resource_type.equals("")))
	{
		sql.append("and upper (resource_class) like upper ('"+resource_type+"%')");
	}



	String ord[] = request.getParameterValues("orderbycolumns");
	if ( !(ord == null || ord .equals("")) )
	{
		sql.append(" order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sql.append(ord[i]);
		else
			sql.append(ord[i]+",");
		}
	}
	} //end of where clause IF
	else{
		sql.append(whereClause);

	}

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

Connection conn =null;
Statement stmt=null;
ResultSet rset=null;
ResultSet rs=null;
int maxRecord = 0;

try{
	conn = ConnectionManager.getConnection(request);

stmt = conn.createStatement();
String strsql2="select clinic_code, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name, practitioner_id, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, practitioner_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, practitioner_id,'"+locale+"','2')) practitioner_full_name,resource_class,care_locn_type_ind,AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_ind,'"+locale+"','1') care_locn_type_desc,to_char(block_date,'dd/mm/yyyy')block_date,TO_CHAR (block_date, 'DAY') block_day, first_visits_blocked,other_visits_blocked,srl_no,to_char(EFFECTIVE_FROM_DATE_TIME,'hh24:mi') EFFECTIVE_FROM_DATE_TIME, to_char(EFFECTIVE_TO_DATE_TIME,'hh24:mi') EFFECTIVE_TO_DATE_TIME from oa_block_appt where upper(facility_id) like upper('"+facilityid+"') and  block_date >= trunc(sysdate)"  +sql.toString() ;
rs = stmt.executeQuery(strsql2);

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

	  StringBuffer param=new StringBuffer("");

	while ( rs.next() && i<=end ){
		if(maxRecord==0)
		{


	%>
<P>
<table align='right'>
<tr>
<%
if ( !(start <= 1) ) { %>
	<td align ='right' id='prev'><A HREF='../../eOA/jsp/BlockAppointmentQueryResult.jsp?from=
<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A></td>
		<% }

//if ( !( (start+14) > maxRecord ) ) 
{
	%>
		<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/BlockAppointmentQueryResult.jsp?
		from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=
		<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
	 <% }


sql.setLength(0);
%>
</tr>
</table><br><br>
</P>



<form name='results' id='results'>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<td class='COLUMNHEADER'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
<td class='COLUMNHEADER'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="Common.Location.label" bundle="${common_labels}"/><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' nowrap><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER'><fmt:message key="Common.totime.label" bundle="${common_labels}"/></td>

<% }
 
		
String classValue="";

	if ( i % 2 == 0 )
		classValue = "QRYEVEN" ;
		else
	classValue = "QRYODD" ;

	%>
	<tr onClick='aaa(this)'><td class='<%=classValue%>'> <a href='javascript:deleted()'>
<%	
	String code = rs.getString("clinic_code");
	String srl_no=rs.getString("srl_no");
	String loc_desc=rs.getString("CLINIC_NAME");
	String pract_id=rs.getString("PRACTITIONER_ID");
	if(pract_id == null || pract_id.equals("null")) pract_id="&nbsp;";
//	String pract_id1=rs.getString("PRACTITIONER_ID");
//	if(pract_id1 == null || pract_id.equals("null")) pract_id1="&nbsp;";
	String pract_name=rs.getString("PRACTITIONER_FULL_NAME");
	if(pract_name == null || pract_name.equals("null")) pract_name="&nbsp;";
	String BLOCK_DAY=rs.getString("block_day");
	String pract_id1 = rs.getString("PRACTITIONER_ID")==null?"XXABCXXDEFXXGHIXX":rs.getString("PRACTITIONER_ID");
	String pract_name1 = rs.getString("PRACTITIONER_FULL_NAME")==null?"XXABCXXDEFXXGHIXXJKLXXMNOXXPQRXXX":rs.getString("PRACTITIONER_FULL_NAME");
	BLOCK_DAY=BLOCK_DAY.trim();
	if(BLOCK_DAY.equalsIgnoreCase("MONDAY"))
								{
									BLOCK_DAY=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(BLOCK_DAY.equalsIgnoreCase("TUESDAY"))
								{
									BLOCK_DAY=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(BLOCK_DAY.equalsIgnoreCase("WEDNESDAY"))
								{
									BLOCK_DAY=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(BLOCK_DAY.equalsIgnoreCase("THURSDAY"))
								{
									BLOCK_DAY=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(BLOCK_DAY.equalsIgnoreCase("FRIDAY"))
								{
									BLOCK_DAY=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(BLOCK_DAY.equalsIgnoreCase("SATURDAY"))
								{
									BLOCK_DAY=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(BLOCK_DAY.equalsIgnoreCase("SUNDAY"))
								{
									BLOCK_DAY=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}


	String from_time=rs.getString("EFFECTIVE_FROM_DATE_TIME");
	String to_time= rs.getString("EFFECTIVE_TO_DATE_TIME");

	String clinic_type=rs.getString("care_locn_type_desc");
	String first_visits_blocked = rs.getString("first_visits_blocked")==null?"0":rs.getString("first_visits_blocked");
	String other_visits_blocked= rs.getString("other_visits_blocked")==null?"0":rs.getString("other_visits_blocked");
	
	String alcncriteria ="";
		//rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");
	String resource = rs.getString("resource_class");
	if(resource == null) resource = "";
	String resource_type_desc="";

	if(resource.equals("P"))
			{
			resource_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(resource.equals("E"))
			{
			resource_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(resource.equals("R"))
			{
			resource_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(resource.equals("O"))
			{
			resource_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
	String locn_type=rs.getString("care_locn_type_ind");
	if(locn_type == null ) locn_type = "";
	String CARE_LOCN_TYPE_DESC =rs.getString("care_locn_type_desc");
	if(CARE_LOCN_TYPE_DESC == null) CARE_LOCN_TYPE_DESC="";
	String dateString = rs.getString("BLOCK_DATE");

	String dateString_disp=DateUtils.convertDate(dateString,"DMY","en",locale);
	
	//param.append(code+"|"+srl_no+"|"+java.net.URLEncoder.encode(loc_desc)+"|"+pract_id1+"|"+(pract_name)+"|"+BLOCK_DAY+"|"+from_time+"|"+to_time+"|"+clinic_type+"|"+dateString+"|"+alcncriteria+"|"+first_visits_blocked+"|"+other_visits_blocked+"|"+CARE_LOCN_TYPE_DESC+"|"+(resource_type_desc)+"|"+locn_type+"|"+resource);
	param.append(code+"|"+srl_no+"|"+loc_desc+"|"+pract_id1+"|"+(pract_name1)+"|"+BLOCK_DAY+"|"+from_time+"|"+to_time+"|"+clinic_type+"|"+dateString+"|"+alcncriteria+"|"+first_visits_blocked+"|"+other_visits_blocked+"|"+CARE_LOCN_TYPE_DESC+"|"+(resource_type_desc)+"|"+locn_type+"|"+resource);


	%>&nbsp;<%=CARE_LOCN_TYPE_DESC%></a><input type='hidden' name=u<%=i%> value='<%=param.toString()%>'>  </td>
		<%param.setLength(0);%>
	<td class='<%=classValue%>'><a href='javascript:deleted()'>&nbsp;<%=code%> </a></td>	
	<td class='<%=classValue%>' > <a href='javascript:deleted()'>&nbsp;<%=loc_desc%> </a></td>
		<td class='<%=classValue%>'><a href='javascript:deleted()'>&nbsp;<%=resource_type_desc%></a></td>
		<td width='7%' class='<%=classValue%>'><a href='javascript:deleted()'>&nbsp;<%=pract_id%></a></td><td class='<%=classValue%>'> <a href='javascript:deleted()'>
		<%=pract_name%></a></td><td class='<%=classValue%>'><a href='javascript:deleted()'>&nbsp;
		<%=dateString_disp%>
	</a> </td><td class='<%=classValue%>'> <a href='javascript:deleted()'>
	<%=BLOCK_DAY%></a> </td><td class='<%=classValue%>'><a href='javascript:deleted()'>&nbsp;
	<%=from_time%>
	</a></td><td class='<%=classValue%>'> <a href='javascript:deleted()'>&nbsp; 
	<%=to_time%>
	</a> </td>
<%
	i++;
	maxRecord++;

  }//endwhile

if(maxRecord == 0)
{%>
	<script src='../../eCommon/js/common.js' language='javascript'></script>

	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);ClearMsgFrame();</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='visible';
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%}
	if(rs!=null)	rs.close();
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();


}catch(Exception e){
	e.printStackTrace();
}finally  {
	ConnectionManager.returnConnection(conn,request);
}
%>

</td></tr>
</table>
<br><center>

</center>
</form>
</BODY>
</HTML>

