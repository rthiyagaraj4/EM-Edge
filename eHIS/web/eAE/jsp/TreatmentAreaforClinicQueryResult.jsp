<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8"); 
String sStyle	= 
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
Connection con		= null ;
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");
try
	{
	String isPriorityZoneAppl				= request.getParameter("isPriorityZoneAppl");//Added By Shanmukh for MMS-DM-CRF-0147
	String whereClause				= request.getParameter("whereclause");
	StringBuffer sql  				= new StringBuffer();
	String from 					= request.getParameter("from") ;
	String to 						= request.getParameter("to") ;
	con				= ConnectionManager.getConnection(request);
	boolean isAppearAsTabEnable  = eCommon.Common.CommonBean.isSiteSpecific(con,"AE","AE_TREATMENT_AREA_TAB"); // added by lakshmanan for ML-MMOH-1973 on 01-07-2023
	if ( (whereClause == null || whereClause.equals("")) )
	{  
		
		 String cd					= request.getParameter("clinic_code");
		 String clinic_desc			= request.getParameter("clinic_desc");
		 String treatment_code		= request.getParameter("treatment_code");
		 String long_desc			= request.getParameter("long_desc");
		 //Added on 10/02/04 to display priority_zone
		 String priority_zone       = request.getParameter("priority_zone");
		 String gender				= request.getParameter("gender");
		 String open_to_all_prac_for_clinic_yn=request.getParameter("open_to_all_prac_for_clinic_yn");
		 String enabled				= request.getParameter("eff_status");
		 String	facilityId 			= (String) session.getValue( "facility_id" ) ;
		 /*Added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 start */
		 String appearAsTabYN		= (checkForNull(request.getParameter("appear_as_tab")).equals("on"))?"Y":"N";
		 /*Added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 end */
		 int andCheck 				= 0;
		 // Changing to Upper case and checking
		 cd							= cd.toUpperCase();
    	 treatment_code				= treatment_code.toUpperCase();
	
	  if( !(facilityId == null || facilityId.equals("")) )
	 {
	  sql.append(" where facility_id='"+facilityId+"'   ");
	  andCheck	=	1;
	 }
	 if ( !(cd== null || cd.equals("")) )
	 {
				 if ( andCheck == 1 ) 
				{
				sql.append(" and ");
				sql.append(" CLINIC_CODE like '"+cd+"%'");
				}
				else
				{
					sql.append(" where CLINIC_CODE like '"+cd+"%'");
					andCheck =1;
				}

	 }
	 /*Added by lakshmanan for ML-MMOH-CRF-1973 on 01/07/2023 start */
	 if (isAppearAsTabEnable && appearAsTabYN.equals("Y")) 
	 { 
			if ( andCheck == 1 ) 
				{
				sql.append(" and ");
				sql.append(" APPEAR_AS_TAB_YN = '"+appearAsTabYN+"'");
				}
			else
				{
					sql.append(" where APPEAR_AS_TAB_YN = '"+appearAsTabYN+"'");
					andCheck =1;
				}
	 }
	 /*Added by lakshmanan for ML-MMOH-CRF-1973 on 01/07/2023 end */
	 
	 //Added By Shanmukh for MMS-DM-CRF-0147
	 if ( !(isPriorityZoneAppl== null || isPriorityZoneAppl.equals("false")) )
	 {
				 if ( andCheck == 1 ) 
				{
				sql.append(" and ");
				sql.append(" PRIORITY_ZONE_CODE not in (select priority_zone from AE_PRIORITY_ZONE where eff_status ='D')");
				}
				else
				{
					sql.append(" where PRIORITY_ZONE_CODE not in (select priority_zone from AE_PRIORITY_ZONE where eff_status ='D')");
					andCheck =1;
				}

	 }
	 if ( !(clinic_desc == null || clinic_desc.equals("")) )
	 {	
	    if ( andCheck == 1 )
	    {
	          sql.append(" and ");
	     	  sql.append(" upper(CLINIC_LONG_DESC) like upper('"+clinic_desc+"%')");
	    }
	    else
	    {
			 sql.append(" where upper(CLINIC_LONG_DESC) like upper('"+clinic_desc+"%')");
			 andCheck 	= 1;
	    }
	 }

	if ( !(treatment_code == null || treatment_code.equals("")) )
	 {
	    if ( andCheck == 1 )
	    {
	          sql.append(" and ");
	     	  sql.append(" TREATMENT_AREA_CODE like'"+treatment_code+"%'");
	    }
	    else
	    {
			 sql.append(" where TREATMENT_AREA_CODE like '"+treatment_code+"%'");
			 andCheck 	= 1;
	    }
	 }

	 if ( !(long_desc == null || long_desc.equals("")) )
	 	 {
	 	    if ( andCheck == 1 )
	 	    {
	 	          sql.append(" and ");
	 	     	  sql.append(" upper(LONG_DESC) like upper('"+long_desc+"%')");
	 	    }
	 	    else
	 	    {
				sql.append(" where upper(LONG_DESC) like upper('"+long_desc+"%')");
				andCheck = 1;
	 	    }
	 }
	 //Added to display priority_zone
	 //Below line Modified by Shanmukh for MMS-DM-CRF-0147
     if ( !(priority_zone == null || priority_zone.equals("") || priority_zone.equals("A")) )
	 	 {
	 	    if ( andCheck == 1 )
	 	    {
	 	          sql.append(" and ");
	 	     	  sql.append(" PRIORITY_ZONE_CODE like'"+priority_zone+"%'");
	 	    }
	 	    else
	 	    {
				sql.append(" where PRIORITY_ZONE_CODE like '"+priority_zone+"%'");
				andCheck = 1;
	 	    }
		}
  	 if ( !(gender == null || gender.equals("") || gender.equals("A")) )
	 	 {
	 	    if ( andCheck == 1 )
	 	    {
	 	          sql.append(" and ");
	 	     	  sql.append(" GENDER like'"+gender+"%'");
	 	    }
	 	    else
	 	    {
				sql.append(" where GENDER like '"+gender+"%'");
				andCheck = 1;
	 	    }
		}

	  if ( !(open_to_all_prac_for_clinic_yn == null || open_to_all_prac_for_clinic_yn.equals("")) )
	     {
   	        if ( open_to_all_prac_for_clinic_yn.equals("Y") )
            {
				if ( andCheck == 0 ) 
				 {
					sql.append(" where OPEN_TO_ALL_PRAC_FOR_CLINIC_YN = 'Y'");
					andCheck = 1;
				}
				else
					 sql.append(" and OPEN_TO_ALL_PRAC_FOR_CLINIC_YN ='Y'");
			}
   			if ( open_to_all_prac_for_clinic_yn.equals("N") )
			{
			  if ( andCheck == 0 ) 
			   {
					sql.append(" where  OPEN_TO_ALL_PRAC_FOR_CLINIC_YN ='N'");
					andCheck = 1; 
				}
	          else
				  sql.append(" and OPEN_TO_ALL_PRAC_FOR_CLINIC_YN ='N'");
	       }
   	    }

	  if ( !(enabled == null || enabled.equals("")) )
	     {
   	        if ( enabled.equals("E") )
            {
				if ( andCheck == 0 ) 
				 {
					sql.append(" where EFF_STATUS='E'");
					andCheck = 1;
				}
				else
					 sql.append(" and EFF_STATUS='E'");
			}
   			if ( enabled.equals("D") )
			{
			  if ( andCheck == 0 ) 
			   {
					sql.append(" where  EFF_STATUS='D'");
					andCheck = 1; 
				}
	          else
				  sql.append(" and EFF_STATUS='D'");
	       }
   			if ( enabled.equals("B") )
   			{
   	   		} 
	    }
	//appending order by clause
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
	else 
		{
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

		PreparedStatement stmt=null;
		ResultSet rs=null;

	
	  StringBuffer strsql2= new StringBuffer(" ");
	  strsql2.append("select * from AE_TMT_AREA_FOR_CLINIC_vw ");
	  strsql2.append(sql.toString());
      stmt = con.prepareStatement(strsql2.toString());
	  rs = stmt.executeQuery();
	  String classValue = "" ;
	  int cnt=0;
	  String endOfRes="1";
	  	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rs.next() ;
	  }
  
 while (i<=end && rs.next()){
	if(cnt==0){
%>
<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAE/jsp/TreatmentAreaforClinicQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eAE/jsp/TreatmentAreaforClinicQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	
%>
</td>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th align='center' ><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></th>
<th align='center' ><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></th>
<th align='center' ><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></th>
<th align='center' ><fmt:message key="eAE.TreatmentAreaCode.label" bundle="${ae_labels}"/></th>
<th align='center' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th align='center' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th align='center' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</th>
<th align='center' ><fmt:message key="eAE.OpentoAllPracLocation.label" bundle="${ae_labels}"/></th>
<%if (isAppearAsTabEnable) {%>
<th align='center' ><fmt:message key="eAE.AppearAsTab.label" bundle="${ae_labels}"/></th> <!--Added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 -->
<% } %>
<th ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;</th>
<%}

	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");
	String clinic_code = rs.getString("clinic_code");
	String treatment_area_code = rs.getString("treatment_area_code");
	
	out.println("<a href='../../eAE/jsp/AddModifyTreatmentAreaforClinic.jsp?clinic_code="+clinic_code+"&treatment_area_code="+treatment_area_code+"' target='f_query_add_mod' >");
	out.println(clinic_code+"</a></td><td class='" + classValue + "'>");
	
	String clinic_desc = rs.getString("CLINIC_LONG_DESC");
	out.println(clinic_desc+"</td><td class='" + classValue + "'>");
	String priority_zone = rs.getString("priority_zone");
	out.println(priority_zone+"</td><td align='center' class='" + classValue + "'>");
	
	out.println(treatment_area_code+"</td><td class='" + classValue + "'>");
	
	String long_desc = rs.getString("long_desc");
	out.println(long_desc+"</td><td class='" + classValue + "'>");
	String short_desc = rs.getString("short_desc");
	out.println(short_desc+"</td><td class='" + classValue + "'>");
	String gender = rs.getString("gender");
	if(gender!=null && gender.equals("M"))
	   gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
	else if(gender!=null && gender.equals("F"))
		gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
	else if(gender!=null && gender.equals("U"))
		gender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
	else
		gender="&nbsp;";
	out.println(gender+"</td><td align='center' class='" + classValue + "'>");
	if ( rs.getString("open_to_all_prac_for_clinic_yn").equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/disabled.gif'></img></td>");
	out.println("</td><td align='center' class='" + classValue + "'>");
	
	/*Added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 start*/
	if (isAppearAsTabEnable) {
	if (checkForNull(rs.getString("APPEAR_AS_TAB_YN")).equals("Y") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/disabled.gif'></img></td>");
	out.println("</td><td align='center' class='" + classValue + "'>");
	}
	/*Added by lakshmanan for ML-MMOH-CRF-1973 on 01-07-2023 end */
	
	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/disabled.gif'></img>");
	i++;
	cnt++;
 }//endwhile
 if(cnt==0)
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
 if(!rs.next()&&cnt!=0){
	endOfRes="0";%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
 <%}
 %>
</td></tr>
</table>
<br><center>
</center>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>
<%
sql.setLength(0);
//strsql1.setLength(0);
strsql2.setLength(0);

if(rs!=null)	rs.close();
if(stmt!=null)	stmt.close();

 }catch(Exception e)
     {
		e.printStackTrace();
     }
	finally   
	{
		 
		 if(con != null)
		 ConnectionManager.returnConnection(con,request);
    }
%>

</BODY>
</HTML>

