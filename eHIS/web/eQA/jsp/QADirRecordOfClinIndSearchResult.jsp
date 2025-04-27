<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<head>
<title> <%= request.getParameter("title")%></title>
<base target="_self">
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>   
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<script src='../../eQA/js/QADirRecordOfClinIndicators.js' language='javascript'></script>
<Script Language='JavaScript' src='../../eCommon/js/messages.js'></Script>
<Script src="../../eQA/js/QAMessages.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()'>

<form name='form_query' id='form_query' method='post' action='QADirRecordOfClinIndSearchResult.jsp' >

	<%
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int max_records = 15;		
				
		ArrayList vectorHtmlData = new ArrayList();
		int start = 0,end = 0;
		int intFetchedRecords = 0;
		try
		{
			conn = ConnectionManager.getConnection(request);
			max_records = (request.getParameter("max_records")== null) ?8 :Integer.parseInt(request.getParameter("max_records"));
			//out.println("=============="+max_records);
			String sql= request.getParameter("sql");
			sql = (sql == null) ? "":sql;
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;

			from = (from == null) ? "0":from;
			to = (to == null) ? max_records+"":to;

			start = Integer.parseInt(from) ;
			end  = Integer.parseInt(to);
			if (start<=0) from = "0";

			
				String row = "<tr style='background-color:;'>";
				String evn = " <td class='QRYEVEN'";
				String odd = " <td class='QRYODD'";
				String strHtmlData = "";
				String strClickEvent = " onClick='fun(this)' ";
				String strFacilityIdEncounterId = "";
				String strFacilityId="";
				String strStatus;
				int intStatus = 0;
				String strQindStatus = "";
				String strEncounterId ="";
				String  ASSIGN_CARE_LOCN_CODE  ="";
				String  PATIENT_NAME ="";          
				String  SEX         ="";           
				String  PATIENT_ID     ="";        
				String  PRACTITIONER_ID     =""; 
				String  VISIT_ADM_DATE_TIME ="";
				String PATIENT_CLASS="";
				String subTag="";
				String strTagPlus="";
				String mainTag="";
				String strHandCursor = " style='cursor:pointer' ";

				int intTempStart = start;
							
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				vectorHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='0' id='tb1'>");
				vectorHtmlData.add("<th width='1%'>St</th>");
				//vectorHtmlData.add("<th width='1%'>An</th>");
				vectorHtmlData.add("<th width='12%' nowrap>Encounter Id</th>");
				vectorHtmlData.add("<th width='12%'>Location</th>");
				vectorHtmlData.add("<th width='40%'>Patient Name</th>");
				vectorHtmlData.add("<th width='1%'>Gender</th>");
				vectorHtmlData.add("<th width='10%'>Patient ID</th>");
				vectorHtmlData.add("<th width='10%' nowrap>Practitioner ID</th>");
				vectorHtmlData.add("<th width='15%' nowrap>Admit Visit Date</th>");
				vectorHtmlData.add("<tr>");
				vectorHtmlData.add("<td>&nbsp;&nbsp;</td>");
				vectorHtmlData.add("<td colspan='4' class='label' align='left'><b class='label'>Encounter(Closed)</b><b style='background:brown'>&nbsp;&nbsp;&nbsp;&nbsp;</b></td>");
				vectorHtmlData.add("<td colspan='4'>&nbsp;&nbsp;</td>");
				vectorHtmlData.add("</tr>");
				

				while(rs.next())
				{

					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;
					vectorHtmlData.add(row);					
					

				 strFacilityIdEncounterId = rs.getString("FAC_ENC_ID");
				 strFacilityId=rs.getString("FACID");
				 strStatus=rs.getString("ENC_STATUS"); 			
				 if(strStatus.equalsIgnoreCase("null")==false)
				 intStatus = Integer.parseInt(strStatus);
				 strQindStatus = rs.getString("QIND_ANALYSIS_STATUS");
                 strQindStatus = strQindStatus.trim();
				 if(strQindStatus.equals("null")||strQindStatus.equals("")||strQindStatus=="")
				 strQindStatus="&nbsp;";


				  strEncounterId =rs.getString("ENCOUNTER_ID");
				  ASSIGN_CARE_LOCN_CODE  =rs.getString("ASS_LOCN");
				  PATIENT_NAME =rs.getString("PATIENT_NAME");          
				  SEX         =rs.getString("GENDER");           
				  PATIENT_ID     =rs.getString("PATIENT_ID");        
				  PRACTITIONER_ID     =rs.getString("PRACTITIONER_ID"); 
				
				   PRACTITIONER_ID = PRACTITIONER_ID.trim();
				 if(PRACTITIONER_ID.equals("")||PRACTITIONER_ID=="")
				 PRACTITIONER_ID="&nbsp;";
					
				  VISIT_ADM_DATE_TIME =rs.getString("DATE_TIME");
				  PATIENT_CLASS=rs.getString("PATIENT_CLASS");

				  if (intFetchedRecords%2 == 0)	
						strHtmlData =  evn ;
					
				  else	strHtmlData = odd;					

				  if(intStatus==2)		strTagPlus="<td class='Brown'";
				  else			strTagPlus=strHtmlData;

				 if(strQindStatus.equals("9")==true)
					      subTag="<td class='Green'";
				 else		 subTag=strHtmlData;

		//	mainTag=strTagPlus+" ID='"+strFacilityIdEncounterId+"' ENCOUNTER_ID='"+strEncounterId+"' FACILITY_ID='"+strFacilityId+"' PATIENT_NAME='"+PATIENT_NAME+"' PATIENT_ID='"+PATIENT_ID+"' PATIENT_CLASS='"+PATIENT_CLASS +"'"+strHandCursor+strClickEvent+">	<b class='label'>+</b>		</td>"+ subTag+" >"+ strQindStatus +"</td>";
			mainTag=strTagPlus+" ID='"+strFacilityIdEncounterId+"' ENCOUNTER_ID='"+strEncounterId+"' FACILITY_ID='"+strFacilityId+"' PATIENT_NAME='"+PATIENT_NAME+"' PATIENT_ID='"+PATIENT_ID+"' PATIENT_CLASS='"+PATIENT_CLASS +"'"+strHandCursor+strClickEvent+">	<b class='label'>+</b>		</td>";

					
			mainTag=mainTag+strHtmlData+"> <b class='label'>"+ strEncounterId +"</b></td>"+ strHtmlData+"><b class='label'>"+  ASSIGN_CARE_LOCN_CODE  +"</b></td>"+ strHtmlData+"> <b class='label'>"+  PATIENT_NAME +"</b></td>"+ strHtmlData+"><b class='label'>"+  SEX         +"</b></td><b class='label'>"+ strHtmlData+"><b class='label'>"+  PATIENT_ID     +"</b></td>"+ strHtmlData+"><b class='label'>"+PRACTITIONER_ID+"</b></td>"+ strHtmlData+"><b class='label'>"+  VISIT_ADM_DATE_TIME +"</b></td>";			
					vectorHtmlData.add(mainTag);
					vectorHtmlData.add("</tr>");
					if (intFetchedRecords >= max_records)
					{
						break;
					}
					
				} if(rs!=null) rs.close();
				  if(pstmt!=null)pstmt.close();
				vectorHtmlData.add("</table>");
				
			
			
		%>
		<table align='center' width='100%'>
		</tr>
		<tr>
		<td align='right'>
		<%
		if ((start>1))
		{
			out.println("<A href=\"javascript:submitFormP()\" text-decoration='none'> Previous </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>");
		} if(intFetchedRecords==0)
	       {%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));</script>
	<%  vectorHtmlData.clear(); }

		if (intFetchedRecords>=max_records)
		{
			out.println("<A href=\"javascript:submitFormN()\" text-decoration='none'> Next </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}
		%>
		</td>
		</tr>
		</table>
		<%
			for (int l=0;l<vectorHtmlData.size() ;++l)
			{
				out.println((String)vectorHtmlData.get(l));
			}
	%>
		<input type='hidden' name='from' id='from' value="<%=start%>">
		<input type='hidden' name='to' id='to' value="<%=end%>">
		 
		<input type='hidden' name='sql' id='sql' value="<%=sql%>">
		<input type='hidden' name='max_records' id='max_records' value="<%=max_records%>">
		<%
		           if(rs!=null) rs.close();
				   if(pstmt!=null)pstmt.close();
				   vectorHtmlData.clear();}
		
		catch(Exception e)
		{
			out.println("Exception in File QADirRecordOfClinIndSearchResult"+e.toString());
		}
		finally
            {
	         ConnectionManager.returnConnection(conn, request);
            }
%>

</form>
</body>
</html>
	


