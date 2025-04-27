<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >
<%
	request.setCharacterEncoding("UTF-8");
	
	String fac_id    	= (String) session.getValue( "facility_id" ) ;
	String locale = (String)session.getAttribute("LOCALE");	
	String whereClause = request.getParameter("whereclause");	
	
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	if ( (whereClause == null || whereClause.equals("")) )
	{	
		String group_id = request.getParameter("group_id");
		String group_name = request.getParameter("group_name"); 
		String locationType = request.getParameter("locationType");
		String location_code = request.getParameter("location_code");			
		String patient_id = request.getParameter("patient_id");
		
		
		//boolean wherecheck=false;
		
		//sbQuery.append(" where a.group_id = b.group_id");
		  // wherecheck=true;
		
		if ( !(group_id == null || group_id.equals("")) )
		{	
		      sbQuery.append(" and upper(a.group_id) like upper('"+group_id+"%')");				
			 
		}
		if ( !(group_name == null || group_name.equals("")) )
		{   
		    sbQuery.append(" and upper(a.group_name) like upper('"+group_name+"%')");		    
		}
		if ( !(locationType == null || locationType.equals("") || locationType.equals(" ")) )
		{				
			sbQuery.append(" and upper(a.LOCN_TYPE) like upper('"+locationType+"%')");			
		}
		
		if ( !(location_code == null || location_code.equals("")) )
		{				
			 sbQuery.append(" and upper(a.LOCN_CODE) like upper('"+location_code+"%')");			
		}
		if ( !(patient_id == null || patient_id.equals("")) )
		{	
		     sbQuery.append(" and upper(b.PATIENT_ID) like upper('"+patient_id+"%')");	
		    
		}		
		
		
		String ord[] = request.getParameterValues("orderbycolumns");


		if ( !(ord == null || ord .equals("")) )
		{
			sbQuery.append(" order by ");		
			for ( int i=0;i < ord.length;i++ )
			{
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);					
				}
				else{
					sbQuery.append(ord[i]+",");						
				}
			}
		 }	
	} //end of where clause IF
	else
	{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
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

Connection conn = null;
conn = ConnectionManager.getConnection(request);
Statement stmt = null;
int maxRecord = 0; int maxcount=0;
ResultSet rs = null;
try{

stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

//String sql="select * from oa_group_hdr "+sbQuery.toString();
String sql="select b.GROUP_ID,op_get_desc.op_clinic('"+fac_id+"', LOCN_CODE, '"+locale+"','1') clinic_desc, GROUP_NAME,LOCN_TYPE,LOCN_CODE,PATIENT_ID from oa_group_hdr a, oa_group_dtls b where a.group_id = b.group_id "+sbQuery.toString();

System.err.println("Query==>"+sql);

   rs = stmt.executeQuery(sql);
   rs.last();
   maxcount = rs.getRow(); 
   rs.beforeFirst(); 

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;

	while ( i<=end && rs.next() )
{
		if(maxRecord==0)
	{
%>
<P>
<table align='right'>
<tr >
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eOA/jsp/PatientGroupResultPage.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/PatientGroupResultPage.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
<br></br>
</p>
<form name="patgroup_result" id="patgroup_result" id="patgroup_result">
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="eOA.GroupId.label" bundle="${oa_labels}"/></th>
<th><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/> </th>
<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th> 




<% }
String classValue = "" ;

	if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'align='center'>");	
	
	String group_id = rs.getString("GROUP_ID");
	String group_name = 	rs.getString("GROUP_NAME");
	String loc_type = rs.getString("LOCN_TYPE");
	String list_value1="";
	if(loc_type.equals("C")){
	      list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	}else if(loc_type.equals("E")){
		 list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	}else if(loc_type.equals("D")) 	{
		list_value1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
	}
	String clinic_desc=rs.getString("clinic_desc"); 	
	String patient_id=rs.getString("PATIENT_ID"); 	
    
    
	
    out.println(group_id+"</td><td class='" + classValue + "' align='center'>");
	out.println(group_name);
    out.println("</td><td class='" + classValue + "' align='center'>");
	out.println(patient_id);	
	out.println("</td><td class='" + classValue + "' align='center'>");
	out.println(list_value1);
	out.println("</td><td class='" + classValue + "' align='center'>");
	out.println(clinic_desc);
	
		

	i++;
	maxRecord++;
	}//end of while 
		sbQuery.setLength(0);

if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
		if (rs != null)   rs.close();
	     if (stmt != null) stmt.close();

}	catch(Exception e) { 
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}

	finally {
		 
	   ConnectionManager.returnConnection(conn,request);
	}

%>
</td></tr>
</table>
</form>
</BODY>
</HTML>

