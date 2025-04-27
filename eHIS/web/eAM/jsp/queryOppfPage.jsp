<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<HTML><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script></head><BODY  class='CONTENT' onLoad='ClearMsg()'  onKeyDown = 'lockKey()' OnMouseDown='CodeArrest()'>
<%
request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue	
	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery =new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String appl_user ="";
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	boolean isFPPPractApplicable = false;//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
	if ( (whereClause == null || whereClause.equals("")) )
	{
	//sql = " ";

	String pracid = request.getParameter("pract_id")==null ?"":request.getParameter("pract_id");
	String pracname=request.getParameter("pract_name")==null ?"":request.getParameter("pract_name");
	String enabled1 = request.getParameter("nature")==null ?"":request.getParameter("nature");
	String facilityid=request.getParameter("facility_id")==null ?"":request.getParameter("facility_id");
	String facilityname=request.getParameter("facility_name")==null ?"":request.getParameter("facility_name");
	String speciality_desc=request.getParameter("speciality_desc")==null ?"":request.getParameter("speciality_desc");
	String speciality_code=request.getParameter("speciality_code")==null ?"":request.getParameter("speciality_code").toUpperCase();
	String allow_unassign_in_practq_yn = request.getParameter("allow_unassign_in_practq_yn")==null ?"":request.getParameter("allow_unassign_in_practq_yn").toUpperCase();
	String fppPractYn = checkForNull(request.getParameter("FPP_Pract"));//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184
	appl_user=p.getProperty( "login_user" ) ;


	if ( !(pracid == null || pracid.equals("")) )
	{
		sbQuery.append(" and upper(am_pract_for_facility_vw.practitioner_id) like upper('"+pracid+"%') ");
	}

	if ( !(pracname == null || pracname.equals("")) )
	{
		sbQuery.append(" and upper(am_practitioner.practitioner_name)  like upper('"+pracname+"%') ");
	}


	if ( !(allow_unassign_in_practq_yn == null || allow_unassign_in_practq_yn.equals("")) )
	{
		sbQuery.append("and upper(am_pract_for_facility_vw.allow_unassign_in_practq_yn)  like upper('"+allow_unassign_in_practq_yn+"%') ");
		
	}


	if ( !(facilityid == null || facilityid.equals("")) )
	{
		sbQuery.append("and upper(am_pract_for_facility_vw.OPERATING_FACILITY_ID) like upper('"+facilityid+"%')");
	}

	if ( !(facilityname == null || facilityname.equals("")) )
	{
		sbQuery.append("and upper(sm_facility_param.facility_name)  like  upper('"+facilityname+"%') ");
	}

	if ( !(enabled1 == null || enabled1.equals("")) )
	{
	   if ( enabled1.equals("E") )
	        {
		   sbQuery.append(" and am_pract_for_facility_vw.eff_status='E' ");
		}
	   if ( enabled1.equals("D") )
		{
			sbQuery.append(" and am_pract_for_facility_vw.eff_status='D' ");
		}
	  }

	if ( !(speciality_code == null || speciality_code.equals("")) )
	{
			sbQuery.append("and am_pract_for_facility_vw.PRIMARY_SPECIALITY_CODE like '"+speciality_code+"%'");
	  }
	  
	  	if ( !(speciality_desc == null || speciality_desc.equals("")) )
	  	{
				sbQuery.append("and upper(am_pract_for_facility_vw.PRIMARY_SPECIALITY_desc)  like upper('"+speciality_desc+"%') ");
	  	}

	/*Added by Thamizh selvi on 29th June 2018 against ML-MMOH-CRF-1184 Start*/
	if (!(fppPractYn == null || fppPractYn.equals("")))
	{
	     if(fppPractYn.equals("Y"))
	         sbQuery.append("and am_practitioner.fpp_pract_yn='Y'");
	     else if(fppPractYn.equals("N"))
	         sbQuery.append("and am_practitioner.fpp_pract_yn='N'");
	}
	/*End*/
	  
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sbQuery.append(" order by ");
		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sbQuery.append(ord[i]);
		else
			sbQuery.append(ord[i]+",");
		}
	}
	} //end of where clause IF
	else{
		sbQuery.setLength(0);
		sbQuery.append( whereClause);
		appl_user=p.getProperty( "login_user" ) ;}


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
try{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();

isFPPPractApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM","FULL_PAYING_PATIENT_PRACT");//Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184


String sql1="SELECT am_pract_for_facility_vw.allow_unassign_in_practq_yn,am_pract_for_facility_vw.primary_speciality_code, am_pract_for_facility_vw.PRIMARY_SPECIALITY_DESC, am_pract_for_facility_vw.OPERATING_FACILITY_ID, ";
		    sql1=sql1+"am_pract_for_facility_vw.eff_status,";
		    sql1=sql1+"am_pract_for_facility_vw.PRACTITIONER_ID,AM_PRACTITIONER.practitioner_name short_name,SM_FACILITY_PARAM.FACILITY_NAME, AM_PRACTITIONER.fpp_pract_yn FROM am_pract_for_facility_vw,AM_PRACTITIONER,SM_FACILITY_PARAM WHERE AM_PRACTITIONER.PRACTITIONER_ID=am_pract_for_facility_vw.PRACTITIONER_ID AND SM_FACILITY_PARAM.FACILITY_ID=am_pract_for_facility_vw.OPERATING_FACILITY_ID and sm_facility_param.facility_id in(select facility_id from sm_facility_for_user where appl_user_id = '"+appl_user+"')";//Added by Thamizh selvi on 29th June 2018 against ML-MMOH-CRF-1184
		    sql1=sql1+sbQuery.toString();			
		    rs = stmt.executeQuery(sql1);

		if ( start != 1 )
		for( int j=1; j<start; i++,j++ ){
		  rs.next() ;
			}

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
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/queryOppfPage.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/queryOppfPage.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

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
<th class='columnheader'><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.primaryspeciality.label" bundle="${common_labels}"/><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="eAM.AssignUnassignedPatient.label" bundle="${am_labels}"/></th>
<!--Added by Thamizh selvi on 28 June 2018 against ML-MMOH-CRF-1184 Start-->
<% if(isFPPPractApplicable){ %>
	<th class='columnheader' width='4%'><fmt:message key="Common.FPP.label" bundle="${common_labels}"/></th>
<% } %><!--End-->
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<% }

	String classValue = "" ;


        if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;


	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("OPERATING_FACILITY_ID");
	String pid=rs.getString("practitioner_id");

	out.println(code+"</td><td class='" + classValue + "'>");

	
	out.println(rs.getString("facility_name")+"</td><td class='" + classValue + "'>");

	out.println(pid+"</td><td class='" + classValue + "'>");

	out.println(rs.getString("short_name")+"</td><td align='left' class='" + classValue + "'>");
	out.println(rs.getString("primary_speciality_code")+"</td><td align='left' class='" + classValue + "'>");
	out.println(rs.getString("primary_speciality_desc")+"</td><td align='center' class='" + classValue + "'>");
		if(rs.getString("allow_unassign_in_practq_yn") .equals("Y"))
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	/*Added by Thamizh selvi on 29th June 2018 against ML-MMOH-CRF-1184 Start*/
	if(isFPPPractApplicable){
		out.println("</td><td align='center' class='" + classValue + "'>");
		if (rs.getString("fpp_pract_yn").equals("Y"))
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	}/*End*/
		out.println("</td><td align='center' class='" + classValue + "'>");
		if ( rs.getString("eff_status").equals("E") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		i++;
		maxRecord++;
    }

if(maxRecord == 0)
		{ %>
			 <script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<% }

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

	if(stmt!=null) 	stmt.close();
  	if(rs!=null)	rs.close();
  }
  catch(Exception e){out.print(e);}
  finally
  {
  
  	ConnectionManager.returnConnection(conn,request);

  }

%>

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

