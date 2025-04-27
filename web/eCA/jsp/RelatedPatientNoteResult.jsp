<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML><head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

</head>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCA/js/RelatedPatientHist.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%

out.println("<BODY  class='CONTENT' onLoad=\"parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num= ';\" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>");
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	StringBuffer sql = new StringBuffer();
	//String sqlbuild="";
	//String orderby="";  
	//String faci = (rs.getString("Facility")==null)?"":rs.getString("Facility");
	//String	facilityId 	= (String) session.getValue( "facility_id" )==null ? "" : (String) session.getValue( "facility_id" ) ;
	//String	patientId 	= (request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	//String  practitioner_id=(String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");	
	String from 					= request.getParameter("from") ;
	
	String to 						= request.getParameter("to") ;
	//String view			= (request.getParameter("view")==null)?"":request.getParameter("view");
    //String spl			= (request.getParameter("spl")==null)?"":request.getParameter("spl");
	//String rest			= (request.getParameter("rest")==null)?"":request.getParameter("rest");
	String from_date	= (request.getParameter("from_date")==null)?"":request.getParameter("from_date");
	String to_date		= (request.getParameter("to_date")==null)?"":request.getParameter("to_date");	
	from_date			=	com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
	to_date				=	com.ehis.util.DateUtils.convertDate(to_date,"DMY",locale,"en");
	String search_word		= request.getParameter("docName")==null?"":request.getParameter("docName");
	//out.println("search_word :"+search_word);	
	
	//String note_type		= request.getParameter("note_type")==null?"":request.getParameter("note_type");
	//out.println("note_type :"+note_type);		

	//String b_year		= request.getParameter("b_year");
	//String b_months     = request.getParameter("b_months");
	//String b_days		= request.getParameter("b_days");
	//String b_year2		= request.getParameter("b_year2");
	//String b_months2    = request.getParameter("b_months2");
	//String b_days2      = request.getParameter("b_days2");
 	//String sex		    = request.getParameter("sex");
 	//String status		= request.getParameter("status");
 	//String group		= request.getParameter("group");
 	//String term_set_id		= request.getParameter("term_set_id");

	//String fr_age="",to_age="";
	//String whereClause				= request.getParameter("whereclause");
			 
/*	if ( (whereClause == null || whereClause.equals("")) )
	{
		if(view.equals("S"))
			sqlbuild=sqlbuild+" and exists(select 1 from ca_encntr_pract_reln where FACILITY_ID=a.onset_facility_id and ENCOUNTER_ID=a.onset_encounter_id and PRACTITIONER_ID='"+practitioner_id+"')";

	    if( !(spl == null || spl.equals("")) )
			sqlbuild=sqlbuild+" and c.SPECIALTY_CODE='"+spl+"' ";
	
		if(rest.equals("F") || rest.equals("E"))
			sqlbuild=sqlbuild+" and c.facility_id='"+facilityId+"' ";

		if( !(from_date == null || from_date.equals("")) )
			sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME>=to_date('"+from_date+"' ,'dd/mm/yyyy')";
	
		if( !(to_date == null || to_date.equals("")) )
			sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME<=to_date('"+to_date+"' ,'dd/mm/yyyy')+.99 ";

		if(!(sex == null || sex.equals("")))
			sqlbuild=sqlbuild+" and b.sex='"+sex+"'";

		if(status.equals("D"))
			sqlbuild=sqlbuild+" and EXISTS (select  1 from AM_DISPOSITION_TYPE where DECEASED_YN='Y' AND  disp_type=C.DISPOSITION_TYPE) ";
		else if(status.equals("D"))
			sqlbuild=sqlbuild+" and (C.DISPOSITION_TYPE is null or EXISTS (select  1 from AM_DISPOSITION_TYPE where DECEASED_YN='N' AND  disp_type= nvl(C.DISPOSITION_TYPE,'xxx'))) ";
    
		if ((!b_year.equals("")) ||(!b_months.equals(""))||(!b_days.equals("")))
		{  
			if (b_year.equals(""))
			  b_year="0";
			if (b_months.equals(""))
			  b_months="0";
			if	(b_days.equals(""))
			  b_days="0";
			fr_age="("+b_year+"*365+"+b_months+"*30+"+b_days+")";
			 sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME-b.date_of_birth>"+fr_age+" ";
		}
	
		if ((!b_year2.equals("")) ||(!b_months2.equals(""))||(!b_days2.equals("")))
		{  
			if (b_year2.equals(""))
			  b_year2="0";
			else
			   b_year2="("+b_year2+"+1)";
			if (b_months2.equals(""))
			  b_months2="0";
			else
			   b_months2="("+b_months2+"+1)";
			if	(b_days2.equals(""))
			  b_days2="0";
			else
			   b_days2="("+b_days2+"+1)";
			to_age="("+b_year2+"*365+"+b_months2+"*30+"+b_days2+")";
			 sqlbuild=sqlbuild+" and c.VISIT_ADM_DATE_TIME-b.date_of_birth<="+to_age+" ";
		}
	}
	else
		sqlbuild=whereClause;   */


	
	int maxRecord = 0;
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

		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try
		{
			StringBuffer sqlQuery =  new StringBuffer("SELECT  count(*) total_records FROM ca_encntr_note a , ca_note_type_lang_vw b  , mp_patient c WHERE     b.LANGUAGE_ID  =? AND b.note_type=a.note_type   AND c.patient_id=a.patient_id   ");  
			if(!search_word.equals(""))
			{
			 sqlQuery.append(" and contains(NOTE_CONTENT,?)>0");	
			}
			con =  ConnectionManager.getConnection();
			pstmt = con.prepareStatement(sqlQuery.toString());
			pstmt.setString(1,locale);
			if(!search_word.equals(""))
			{
			pstmt.setString(2,search_word);
			}
			
		    rs = pstmt.executeQuery();		
			if(rs.next())
			{
				maxRecord = rs.getInt("total_records");
			}
			
			if (rs != null)
				rs.close();

			if (pstmt != null)
				pstmt.close();

		}catch(Exception e){
			e.printStackTrace();
		}

		
%>
<table cellpadding='3' align='center' width='100%'>
<tr >
<td width='100%' class='white' ></td>
<td nowrap width='10%'>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eCA/jsp/RelatedPatientNoteResult.jsp?from="+(start-14)+"&to="+(end-14)+"&docName="+search_word+"'"+" text-decoration='none'    class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if ( !( (start+14) >= maxRecord ) )
	{
		out.println("<A HREF='../../eCA/jsp/RelatedPatientNoteResult.jsp?from="+(start+14)+"&to="+(end+14)+"&docName="+search_word+"'"+" text-decoration='none' class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}
	
%>
</td>
</tr>
</table>
<table  width="100%" class='grid'>
<td class='columnheader' width='25%'  nowrap><fmt:message key="eCA.NoteDescription.label" bundle="${ca_labels}"/></td>
<td class='columnheader' width='20%' nowrap><fmt:message key="eOR.EventDateTime.label" bundle="${or_labels}"/></td>
<td class='columnheader' width='20%' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
<td class='columnheader' width='20%' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>

<td class='columnheader' width='5%' nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
<td class='columnheader' width='5%' nowrap><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></td>
<td class='columnheader' width='5%'><fmt:message key="Common.details.label" bundle="${common_labels}"/></td></tr>
<%
	try
	{
      
		sql.append("SELECT  b.NOTE_TYPE_DESC 	,TO_CHAR(EVENT_DATE_TIME,'dd/mm/yyyy hh24:mi') event_date_time_str ,a.patient_id,REPLACE(DECODE('',?,c.PATIENT_NAME,NVL(c.PATIENT_NAME_LOC_LANG,c.PATIENT_NAME)),'''','') 	patient_name,get_age (c.date_of_birth,NVL (c.deceased_date, SYSDATE) ) age	,c.sex sex	,a.note_type        ,a.FACILITY_ID 	,a.ACCESSION_NUM FROM ca_encntr_note a , ca_note_type_lang_vw b  , mp_patient c WHERE     b.LANGUAGE_ID  =? AND b.note_type=a.note_type   AND c.patient_id=a.patient_id ");
		
		if(!search_word.equals(""))
		{
		  sql.append(" and contains(NOTE_CONTENT,?)>0");	
		}
   
	 /*if (!note_type.equals(""))
		sql.append(" and a.note_type=? "); 

		 sql.append(" CONTAINS (a.note_content,?) >0") ;

		 if (!patientId.equals(""))
		  sql.append(" and a.patient_id != ? ");
		 //out.println("patientId :"+patientId);
		 // sql.append(sqlbuild);	
			 pstmt = con.prepareStatement(sql.toString());
			  pstmt.setString(1,locale);
			  pstmt.setString(2,locale);
			   if (!note_type.equals("")){
					pstmt.setString(3,note_type);
					pstmt.setString(4,search_word);
			   }else{
					pstmt.setString(3,search_word);
			   }

			   if (!note_type.equals("") && !patientId.equals(""))
					pstmt.setString(5,patientId);
			   else if (!patientId.equals(""))
					pstmt.setString(4,patientId);*/

		 //out.println("sql  :   "+sql);
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		if(!search_word.equals(""))
		{
		pstmt.setString(3,search_word);
		}
	    rs = pstmt.executeQuery();		
	

	 
		%>

	 <%	
		 if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		  rs.next() ;

	   while(rs!=null && rs.next() && i<=end)
		{
		  String note_type_desc = (rs.getString("NOTE_TYPE_DESC")==null)?"":rs.getString("NOTE_TYPE_DESC");
		  String date_time = (rs.getString("EVENT_DATE_TIME_STR")==null)?"":rs.getString("EVENT_DATE_TIME_STR");  	  
		  String pat_id = (rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");
		  String pat_name = (rs.getString("PATIENT_NAME")==null)?"":rs.getString("PATIENT_NAME");		
		 String age = (rs.getString("AGE")==null)?"":rs.getString("AGE");		 
		 String PAT_sex = (rs.getString("SEX")==null)?"":rs.getString("SEX");
		 String ACCE_NUM = (rs.getString("ACCESSION_NUM")==null)?"":rs.getString("ACCESSION_NUM");
		 
		// out.println(ACCE_NUM);
		 out.println("<tr ><td  class='gridData' align=left ><font  size=2>"+note_type_desc+"</font></td>");		
		out.println("<td   class='gridData'><font  size=2>"+date_time+"</td></font>");
		out.println("<td   nowrap class='gridData'><font  size=2>"+pat_id+"</td></font>");
		out.println("<td   class='gridData'><font  size=2>"+pat_name+"</td></font>");
		out.println("<td nowrap  class='gridData'><font  size=2>"+age+"</td></font>");
		out.println("<td nowrap  class='gridData'><font  size=2>"+PAT_sex+"</td></font>");
		out.println("<td><img id='textimg' src='../../eCA/images/flow_text.gif' onClick=\"javascript:populateDocument('"+ACCE_NUM+"')\"></td></tr>");
	  
		  //maxRecord = rs.getInt("total");}*/
		  i++;
        } 
		
 
	}catch(Exception e)
     {
        e.printStackTrace();
		e.toString();
		//out.println(e.toString());//common-icn-0181
     }
	finally   
	{
		 if(pstmt!=null)pstmt.close();
		 if(rs!=null)rs.close();
		 if(con!=null)
			 ConnectionManager.returnConnection(con,request);
    }
%>

</BODY>
</HTML>


