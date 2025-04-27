<!DOCTYPE html>
<%--Author  Archana Kumari Dhal Created on 4/3/2009 --%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
	
%>	
    
	<link rel='stylesheet' type='text/css' href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>	
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>	
	<script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></script>
	<script language="javascript" src="../js/MedRecAdminAlert.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='MedRecAdminAlertResult_Form' id='MedRecAdminAlertResult_Form' >
		<%
			
			Connection con = null;			
			try
			{
				java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
				String locale = (String) p.getProperty("LOCALE");					
				String classValue = "gridData";

				String from 					= request.getParameter("from") ;
	
				String to 						= request.getParameter("to") ;

				String fromDate			=	request.getParameter("fromDate") == null ? "" : request.getParameter("fromDate");
				
				String toDate			=	request.getParameter("ToDate") == null ? "" : request.getParameter("ToDate"); 
				if(!localeName.equals("en"))
				{
                 fromDate		=	com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
			     toDate	=	com.ehis.util.DateUtils.convertDate(toDate,"DMY",locale,"en");
				}
				
				 String group_by	=	request.getParameter("group_by") == null ? "" :		request.getParameter("group_by");

				
				 String practitioner_id	=	request.getParameter("practitioner_id") == null ? "" :		request.getParameter("practitioner_id");
				 String code	=	request.getParameter("code") == null ? "" :		request.getParameter("code");	
				 String fnName	=	request.getParameter("fnName") == null ? "" :		request.getParameter("fnName");
		       

				 String Categ_desc = "";
				 String Event_desc = "";
				 String GroupLabel = "";
				 String group1Value = "";
				 String group1Ref = "";
				 String group2Ref = "";
				 String prevGroup1Value = "";
				 String group2Value = "";
				 String alert_remarks = "";
				 //String Patient_id = "";
				 //String Patient_name = "";
				//String encounter_id = "";
				 String action_pend_datetime = "";
				 //String facility_id = "";				 
				 StringBuffer sql1 = new StringBuffer();
				 StringBuffer sql2 = new StringBuffer();
				 //String displaycatalog = "";
			   con = ConnectionManager.getConnection(request);
			   PreparedStatement stmt= null;
			   PreparedStatement stmt1= null;
			   ResultSet rset=null;
			   ResultSet rset1=null;
			   int count =0;
			   int count1 =0;
			  int k =	0;
				int maxRecord = 0;
				int start = 0 ;
				int end = 0 ;
				int i=1;

				if ( from == null )
					start = 1 ;
				else
					start = Integer.parseInt( from ) ;

				if ( to == null )
	  				end = 10 ;
				else
				end = Integer.parseInt( to ) ;			
				
				try
			 {
			sql2.append("SELECT COUNT(*) total_records  FROM CA_ALERT_CATEG_LANG a,CA_ALERT_ACTION_LOG b WHERE  a.ALERT_CATEG_CODE=b.ALERT_CATEG_CODE   AND  b.ACTION_PEND_DATETIME BETWEEN TO_DATE(?,'DD/MM/YYYY')  AND TO_DATE(?,'DD/MM/YYYY') AND a.LANGUAGE_ID = ?");
		
			if(!(code.equals("")||code.equals("null")))
				{
					sql2.append( "and b.ALERT_CATEG_CODE =? ");
				}	
				if(!(practitioner_id.equals("")||practitioner_id.equals("null"))){
					sql2.append( "and b.ACTION_BY_USER_ID =? ");
				}
				stmt1 = con.prepareStatement(sql2.toString());			   	  
			    stmt1.setString(++count1,fromDate);
			    stmt1.setString(++count1,toDate);
			    stmt1.setString(++count1,locale);
           if(!(code.equals("")||code.equals("null")))
			{
                stmt1.setString(++count1,code);
			}

			 if(!(practitioner_id.equals("")||practitioner_id.equals("null")))
				{
				
					stmt1.setString(++count1,practitioner_id);
					}
		    rset1 = stmt1.executeQuery();		
			if(rset1.next())
			{
				maxRecord = rset1.getInt("total_records");	
				
			}
			
			if (rset1 != null)
				rset1.close();

			if (stmt1 != null)
				stmt1.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		 if(maxRecord==0){	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");	}	
		 if(maxRecord !=0) { %>
			<table cellpadding='3' align='center' width='100%'>
				<tr >
			<td  width='100%' class='white' ></td>
				<td nowrap width='10%'>
			<%


				if ( !(start <= 1) )
				{
				out.println("<A HREF='../../eCA/jsp/MedRecAdminAlertResult.jsp?from="+(start-10)+"&to="+(end-10)+"&code="+code+"&practitioner_id="+practitioner_id+"&fromDate="+fromDate+"&ToDate="+toDate+"&group_by="+group_by+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");					
		  }			

				  if ( !( (start+10) >= maxRecord ) )
					{
			out.println("<A HREF='../../eCA/jsp/MedRecAdminAlertResult.jsp?from="+(start+10)+"&to="+(end+10)+"&code="+code+"&practitioner_id="+practitioner_id+"&fromDate="+fromDate+"&ToDate="+toDate+"&group_by="+group_by+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");	

	}
	
%>
</td>
</tr>
</table>		
    	<table class="grid" width='100%' border='0' cellpadding='3' cellspacing='0'>
				
		<%  
			
				if(group_by.equals("PAT")) 
				{
					group1Ref="  mp.PATIENT_NAME||', '||mp.sex||'/'||get_age(mp.date_of_birth)||','||mp.PATIENT_ID||', '||pr.encounter_id||','|| case when pr.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(pr.facility_id,pr.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(pr.facility_id,pr.ASSIGN_CARE_LOCN_CODE,?,'2') end ||','||AM_GET_DESC.AM_PATIENT_CLASS(pr.patient_class, ?,'2') ";
					group2Ref="  d.APPL_USER_NAME ";
					GroupLabel="Common.user.label";
				}
				else
			 	{
					group2Ref="   mp.PATIENT_NAME||', '||mp.sex||'/'||get_age(mp.date_of_birth)||','||mp.PATIENT_ID||'<br>'||pr.encounter_id||','|| case when pr.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(pr.facility_id,pr.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(pr.facility_id,pr.ASSIGN_CARE_LOCN_CODE,?,'2') end ||','||AM_GET_DESC.AM_PATIENT_CLASS(pr.patient_class, ?,'2')  ";
					group1Ref="  d.APPL_USER_NAME ";
					GroupLabel="Common.PatientDetails.label";
				}
				if(fnName.equals("CAMS_MRADMIN_ALERT")) 
				{
					
				out.println("<tr><td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,GroupLabel,"common_labels")+"</td>");

				}
				
				out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AlertCategory.label","ca_labels")+"</td>");
				//out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EventDescription.label","common_labels")+"</td>");
				out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ActionEvent.label","ca_labels")+"</td>");
				out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DateAndTime.label","ca_labels")+"</td>");
				out.println("<td class='columnheadercenter'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"</td>");
				out.println("</tr>");
				sql1.append("SELECT "+group1Ref+" group1Value, "+group2Ref +" group2Value,  a.ALERT_CATEG_DESC,c.ALERT_EVENT_DESC,to_char(ACTION_PEND_DATETIME,'dd/mm/yyyy hh24:mi') ACTION_PEND_DATETIME, b.ALERT_REMARKS FROM mp_patient mp,pr_encounter pr,CA_ALERT_CATEG_LANG a,CA_ALERT_ACTION_LOG b,CA_ALERT_EVENT_LANG_VW c ,sm_appl_user_lang_vw d WHERE mp.PATIENT_ID=pr.PATIENT_ID AND a.ALERT_CATEG_CODE=b.ALERT_CATEG_CODE and b.ALERT_EVENT_CODE=c.ALERT_EVENT_CODE  and b.facility_id=pr.facility_id and b.ENCOUNTER_ID=pr.encounter_id and  b.ACTION_PEND_DATETIME BETWEEN to_date(?,'DD/MM/YYYY') and to_date(?,'DD/MM/YYYY') and a.LANGUAGE_ID = ? AND C.LANGUAGE_ID=A.LANGUAGE_ID and d.appl_user_id=b.ACTION_BY_USER_ID and d.LANGUAGE_ID=A.LANGUAGE_ID ");
									
				if(!(code.equals("")||code.equals("null")))
				{
					sql1.append( "and b.ALERT_CATEG_CODE =? ");
				}	
				if(!(practitioner_id.equals("")||practitioner_id.equals("null"))){
					sql1.append( " and b.ACTION_BY_USER_ID =? ");
				}
				sql1.append( " order by 1,2 ");
				stmt = con.prepareStatement(sql1.toString());	
				stmt.setString(++count,locale);
				stmt.setString(++count,locale);
				stmt.setString(++count,locale);
				stmt.setString(++count,fromDate);
				stmt.setString(++count,toDate);
				stmt.setString(++count,locale);
				if(!(code.equals("")||code.equals("null")))
				{
					stmt.setString(++count,code);
				}

				if(!(practitioner_id.equals("")||practitioner_id.equals("null")))
				{
					stmt.setString(++count,practitioner_id);
				}	
				//stmt.setString(++count,group_by);
				rset = stmt.executeQuery();
				if ( start != 1 )
				{
					for( int j=1; j<start; i++,j++ )
						 rset.next() ;
				}
				while(rset!=null && rset.next() && i<=end)   
				{	
				 group1Value = rset.getString("group1Value")==null?"":rset.getString("group1Value");
				 group2Value = rset.getString("group2Value")==null?"":rset.getString("group2Value");
				 Categ_desc = rset.getString("ALERT_CATEG_DESC")==null?"":rset.getString("ALERT_CATEG_DESC");
				 Event_desc = rset.getString("ALERT_EVENT_DESC")==null?"":rset.getString("ALERT_EVENT_DESC");
				 action_pend_datetime = rset.getString("action_pend_datetime")==null?"":rset.getString("action_pend_datetime");
				 alert_remarks = rset.getString("ALERT_REMARKS")==null?"":rset.getString("ALERT_REMARKS");
				 if (!prevGroup1Value.equals(group1Value))
					{
					 out.println("<tr>");
					 out.println("<td class='"+classValue+"' name='Patdetail' colspan='4'><B>"+group1Value+"</B></td></tr>");
					 out.println("<tr>");	
					 prevGroup1Value=group1Value;
					}
					if(fnName.equals("CAMS_MRADMIN_ALERT")) 
				{
					
				out.println("<td  class='"+classValue+"' name='group2'>"+group2Value);

				}
				 	
				 out.println("</td><td  class='"+classValue+"' name='Catdesc'>"+Categ_desc);	
				 out.println("</td><td  class='"+classValue+"' name='Eventdesc'>"+Event_desc);	
				 out.println("</td><td  class='"+classValue+"' name='action_pend_datetime'>"+action_pend_datetime);	
				 out.println("</td><td  class='"+classValue+"' name='alertremarks'>"+alert_remarks);	
				 out.println("</td></tr>");
				
				  k++;
				 i++;
				 }
				 
			 if(k==0)
				 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			  }
			  
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
 
}
catch(Exception e)
{
	//out.println("Exception at try of MedRecAdminAlertResult.jsp -"+e.toString());//common-icn-0181
	e.printStackTrace();
}
finally 
{
	if (con!=null) ConnectionManager.returnConnection(con,request);
}
%> 
	
        
	</form>
</body>
</html>
			
			

