<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script></head><BODY  OnMouseDown='CodeArrest()' onLoad='ClearMsg()'  onKeyDown = 'lockKey()' class='CONTENT'>
<%
request.setCharacterEncoding("UTF-8");	
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null)
		whereClause="";
	StringBuffer sql=new StringBuffer(" ");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	boolean isFPPPractApplicable = false;//Added by Thamizh selvi on 29th June 2018 against ML-MMOH-CRF-1184

	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql.setLength(0);
	sql.append("");
	String cd = request.getParameter("pract_id");
	String prname = request.getParameter("pract_name");
	String spltycd= request.getParameter("splty_code");
	String spltynm=request.getParameter("splty_name");
	String facility_id=request.getParameter("facility_id");
	String facility_name= request.getParameter("facility_name");
	String fppPractYn = checkForNull(request.getParameter("FPP_Pract"));//Added by Thamizh selvi on 29th June 2018 against ML-MMOH-CRF-1184


	if ( !(cd == null || cd.equals("")) )
	{
		sql.setLength(0);
		sql.append("and upper(Am_Pract_Specialities.practitioner_id) like upper('"+cd+"%')");
	}

	if ( !(prname == null || prname.equals("")) )
	{
		sql.append(" and ");
		sql.append("upper(am_practitioner.practitioner_name) like  upper('"+prname+"%') " );
	}

	if ( !(spltycd== null || spltycd.equals("")) )
	{
		sql.append(" and ");
		sql.append("Am_Pract_Specialities.speciality_code like  '"+spltycd.toUpperCase()+"%'" );
	}

	if ( !(spltynm== null || spltynm.equals("")) )
	{
		sql.append(" and ");
		sql.append(" upper(am_speciality.short_desc)  like  upper('"+spltynm+"%') " );
	}

	if ( !(facility_id== null || facility_id.equals("")) )
	{
		sql.append(" and ");
		sql.append("am_pract_specialities.facility_id like  '"+facility_id.toUpperCase()+"%'" );

	}
	if ( !(facility_name== null || facility_name.equals("")) )
	{
		sql.append(" and ");
		sql.append("am_pract_specialities.facility_id =sm_facility_param.facility_id  and  upper(sm_facility_param.facility_name)  like upper('"+facility_name+"%') " );
	}
	/*Added by Thamizh selvi on 29th June 2018 against ML-MMOH-CRF-1184 Start*/
	if (!(fppPractYn == null || fppPractYn.equals("")))
	{
	     if(fppPractYn.equals("Y"))
	         sql.append("and am_practitioner.fpp_pract_yn='Y'");
	     else if(fppPractYn.equals("N"))
	         sql.append("and am_practitioner.fpp_pract_yn='N'");
	}
	/*End*/

	}
	else
	{	sql.setLength(0);
		sql.append(whereClause);
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
	else
	{	
		sql.setLength(0);
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

Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;
try
{

conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();

isFPPPractApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM","FULL_PAYING_PATIENT_PRACT");//Added by Thamizh selvi on 29th June 2018 against ML-MMOH-CRF-1184

if(rs!=null)rs.close();
rs = stmt.executeQuery("select sm_facility_param.facility_name,am_pract_specialities.facility_id,am_practitioner.practitioner_name,am_pract_specialities.practitioner_id,am_pract_specialities.speciality_code,am_speciality.short_desc,AM_PRACTITIONER.fpp_pract_yn from sm_facility_param,am_practitioner,am_pract_for_facility, am_pract_specialities,am_speciality where am_pract_specialities.practitioner_id=am_pract_for_facility.practitioner_id and am_practitioner.practitioner_id=am_pract_for_facility.practitioner_id and am_speciality.speciality_code=am_pract_specialities.speciality_code and am_pract_specialities.facility_id=am_pract_for_facility.facility_id and sm_facility_param.facility_id = am_pract_specialities.facility_id "+sql);//Added by Thamizh selvi on 29th June 2018 against ML-MMOH-CRF-1184

if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;

while ( i<=end && rs.next() )
  {
	if(maxRecord==0)
	  {

%>

<p>
<table align='right'>
<tr>

<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/queryOPSPractitioner.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/queryOPSPractitioner.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<!--Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start-->
<% if(isFPPPractApplicable){ %>
	<td class='columnheader' width='4%'><fmt:message key="Common.FPP.label" bundle="${common_labels}"/></td>
<% } %><!--End-->


<% }

	  String classValue = "" ;

        if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	out.println("<tr><td nowrap class='"+classValue+"'>"+rs.getString("facility_id")+"</td>");
	out.println("<td nowrap class='" + classValue + "'>"+rs.getString("facility_name")+"</td>");
	out.println("<td class='" + classValue + "'>");
	String code = rs.getString("practitioner_id");
	String spcode=rs.getString("speciality_code");
	
	out.println(code+"</td><td class='" + classValue + "'>");
	
	out.println( rs.getString("practitioner_name") );
	out.println("</td><td class='" + classValue + "'>");
	
	out.println(spcode );
	out.println("</td> <td class='" + classValue + "'>");
	
	out.println( rs.getString("short_desc") );
	//out.println("</td class='" + classValue + "'>");
	/*Added by Thamizh selvi on 29th June 2018 against ML-MMOH-CRF-1184 Start*/
	if(isFPPPractApplicable){
		out.println("</td><td class='" + classValue + "'>");
		if (rs.getString("fpp_pract_yn").equals("Y"))
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	}/*End*/

	i++;
	maxRecord++;
  }// end of while

  if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}

}// end of try
catch(Exception e){out.println(e);}
finally
{
	try
	{
	if(stmt!=null)	stmt.close();
	if(rs!=null) 	rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionManager.returnConnection(conn,request);

}%>

</td></tr>
</table>
<br>
</BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (("").equals(inputString)) || (("null").equals(inputString)) ) ? "" : inputString );
	}
%>

