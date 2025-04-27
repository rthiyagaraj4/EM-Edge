
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<html>

<head>
<title> <%= request.getParameter("title")%></title>
<base target="_self">
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>   
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>
<script src='../../eQA/js/QAAnalyzePartialIndicators.js' language='javascript'></script>
<!-- <script src="../../eCommon/js/Common.js" language="javascript"> </script> -->
<Script src="../../eQA/js/QAMessages.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey();'>

<form name='form_query' id='form_query' method='post' action='QAAnalyzePartialIndSearchResult.jsp' >

	<%
	    request.setCharacterEncoding("UTF-8");
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
			max_records = (request.getParameter("max_records")== null) ? 12:Integer.parseInt(request.getParameter("max_records"));
			String sql= request.getParameter("sql");
			sql = (sql == null) ? "":sql;
			String from = request.getParameter( "from" ) ;
			String to = request.getParameter( "to" ) ;
			//out.println("sql:" + sql);
			from = (from == null) ? "0":from;
			to = (to == null) ? max_records+"":to;
				
			start = Integer.parseInt(from) ;
			end  = Integer.parseInt(to);
			if (start<=0) from = "0";

				String strQueryParam = request.getQueryString();
				String row = "<tr style='background-color:;'>";
				String evn = " <td class='QRYEVEN'";
				String odd = " <td class='QRYODD'";
				String strHtmlData = "";
				String strClickEvent = " onClick='fun(this)' ";
				//String strEncounterId = "";
				String strFacilityId="";
				String strClindStatus="";
				String strDiagCode="";
				String strProcCode="";
				String SYS_USER_CREATED="";

				//String strStatus;
				int intStatus = 0;
				
				String strEncounterId ="";
				//String  ASSIGN_CARE_LOCN_CODE  ="";
				String  PATIENT_NAME ="";          
				String  SEX         ="";           
				String  PATIENT_ID     ="";        
				//String  PRACTITIONER_ID     =""; 
				
				String PATIENT_CLASS="";
				String strIndicator = "";
				String strIndicatorId = "";
				String VISIT_ADM_DATE_TIME ="";
				String strQindStatus = "";
				String subTag="";
				String strTagPlus="";
				String mainTag="";
				String strHandCursor = " style='cursor:pointer' ";

				int intTempStart = start;
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
					
				vectorHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='0' id='tb1'>");
				vectorHtmlData.add("<th width='1%'>St</th>");
			//	vectorHtmlData.add("<th width='1%'>An</th>");
				vectorHtmlData.add("<th width='12%' onmouseover='hidetooltip();' nowrap>Encounter Id</th>");
//				vectorHtmlData.add("<th width='12%'>Location</th>");
				vectorHtmlData.add("<th width='25%' onmouseover='hidetooltip();'>Patient Name</th>");
				vectorHtmlData.add("<th width='1%'>Gender</th>");
				vectorHtmlData.add("<th width='10%'>Patient ID</th>");
				vectorHtmlData.add("<th width='25%' nowrap>Indicator</th>");
				vectorHtmlData.add("<th width='15%' nowrap>Discharged Date</th>");
				vectorHtmlData.add("<th width='15%' nowrap>Status</th>");
				//vectorHtmlData.add("<tr>");
			//	vectorHtmlData.add("<td>&nbsp;&nbsp;</td>");
			//	vectorHtmlData.add("<td colspan='4' class='label' align='left'><b class='label'>Encounter(Closed)</b><b style='background:brown'>&nbsp;&nbsp;&nbsp;&nbsp;</b></td>");
			//	vectorHtmlData.add("<td colspan='4'>&nbsp;&nbsp;</td>");
				//vectorHtmlData.add("</tr>");
				

				while(rs.next())
				{

					if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}
					++intFetchedRecords;
					vectorHtmlData.add(row);					
					
				 strFacilityId=rs.getString("FACILITY_ID");
				 strEncounterId = rs.getString("ENCOUNTER_ID");
				 PATIENT_NAME=rs.getString("PATIENT_NAME");
				 SEX         =rs.getString("GENDER");
				 PATIENT_CLASS=rs.getString("PATIENT_CLASS");
				 PATIENT_ID     =rs.getString("PATIENT_ID");
				 strIndicatorId=rs.getString("QIND_CLIND_ID");
				 strIndicator = rs.getString("QIND_CLIND_Desc");
				 VISIT_ADM_DATE_TIME =rs.getString("ENCOUNTER_START_DATE");
				 strClindStatus=rs.getString("CLIND_ANALYSIS_STATUS");
				 strQindStatus=rs.getString("STATUS_DESC");
				 strDiagCode=rs.getString("INCL_DIAG_CODE");
				 strProcCode=rs.getString("INCL_PROC_CODE");
				 SYS_USER_CREATED=rs.getString("SYS_USER_CREATED");
				                
			//	 if(strQindStatus.equals("null")||strQindStatus.equals("")||strQindStatus=="")
			//	 strQindStatus="&nbsp;";
				  
				  if (intFetchedRecords%2 == 0)	
						strHtmlData =  evn ;
					
				  else	strHtmlData = odd;					

				  if(intStatus==2)		strTagPlus="<td class='Brown'";
				  else			strTagPlus=strHtmlData;

				// if(strQindStatus.equals("9")==true)
				//	      subTag="<td class='Green'";
				// else		 subTag=strHtmlData; 

			
			mainTag=strTagPlus+" ID='"+strEncounterId+"' ENCOUNTER_ID='"+strEncounterId+"' PATIENT_NAME='"+PATIENT_NAME+"' PATIENT_ID='"+PATIENT_ID+"' FACILITY_ID='"+strFacilityId+"' PATIENT_CLASS ='"+PATIENT_CLASS+ "' QIND_CLIND_Desc='"+strIndicator+"' QIND_CLIND_ID='"+strIndicatorId +"' CLIND_ANALYSIS_STATUS='"+strClindStatus+ "' INCL_DIAG_CODE='"+strDiagCode+"' INCL_PROC_CODE='"+strProcCode+ "' SYS_USER_CREATED='"+SYS_USER_CREATED+"'"+strHandCursor+strClickEvent+"><b class='label'>+</b></td>"+ subTag ;
			//out.println(strIndicatorId);
			
		//	out.println("<script>alert('"+ mainTag+ "')</script>");
			//mainTag=mainTag+tooltip1;
			mainTag=mainTag+strHtmlData+" onmouseover='hidetooltip();' ID='"+strEncounterId+"' ENCOUNTER_ID='"+strEncounterId+"' PATIENT_NAME='"+PATIENT_NAME+"' PATIENT_ID='"+PATIENT_ID+"' FACILITY_ID='"+strFacilityId+"' PATIENT_CLASS ='"+PATIENT_CLASS+ "' QIND_CLIND_Desc='"+strIndicator+"' QIND_CLIND_ID='"+strIndicatorId +"' CLIND_ANALYSIS_STATUS='"+strClindStatus+ "' INCL_DIAG_CODE='"+strDiagCode+"' INCL_PROC_CODE='"+strProcCode+ "' SYS_USER_CREATED='"+SYS_USER_CREATED+"'"+strHandCursor+strClickEvent+"> <b class='label'>"+ strEncounterId +"</b></td>"+ strHtmlData+" onmouseover='hidetooltip();'> <b class='label'>"+  PATIENT_NAME +"</b></td>"+ strHtmlData+"><b class='label'>"+  SEX         +"</b></td><b class='label'>"+ strHtmlData+"><b class='label'>"+  PATIENT_ID     +"</b></td>"+ strHtmlData+"><b class='label'>"+strIndicator+"</b></td>"+ strHtmlData+"><b class='label'>"+  VISIT_ADM_DATE_TIME +"</b></td>"+strHtmlData+"><b class='label'>"+strQindStatus +"</b></td>";			
					vectorHtmlData.add(mainTag);
					vectorHtmlData.add("</tr>");
					//vectorHtmlData.add(tooltip1);
//				out.println(mainTag);
					if (intFetchedRecords > max_records)
					{
						break;
					}
					
				} 
				 //if(rs!=null) rs.close();
				 // if(pstmt!=null)pstmt.close();
				vectorHtmlData.add("</table>");
				
				String tooltip1="<div style='position:absolute; width:10%; visibility:hidden;' id='tooltip' ><table id='tooltiptable1'  cellpadding=0 cellspacing=0 border='1'   class='BOX' width='10%' align='center'><TR><TD id='tooltipdata' ></TD></TR></TABLE></div>";
				vectorHtmlData.add(tooltip1);
			
			
		%>
		<table align='center' width='100%'>
		</tr>
		<tr>
		<td align='right'>
		<%
		if ((start>=1))
		{
			out.println("<A href=\"javascript:submitFormP()\" text-decoration='none'> Previous </a>");
		}
		else
		{
			out.println("<b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>");
		}
       if(intFetchedRecords==0)
	{%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));</script>
	<%  vectorHtmlData.clear(); }
		if (intFetchedRecords > max_records)
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
				//System.out.println((String)vectorHtmlData.get(l));
			}
	%>
		<input type='hidden' name='from' id='from' value="<%=start%>">
		<input type='hidden' name='to' id='to' value="<%=end%>">
		 
		<input type='hidden' name='sql' id='sql' value="<%=sql%>">
		<input type='hidden' name='max_records' id='max_records' value="<%=max_records%>">


		<input type=hidden name='rowVal' id='rowVal'  value=''>
		<input type=hidden name='PATIENT_ID' id='PATIENT_ID'  value='<%=PATIENT_ID%>'>
		<input type=hidden name='PATIENT_NAME' id='PATIENT_NAME'  value='<%=PATIENT_NAME%>'>
		<input type=hidden name='ENCOUNTER_ID' id='ENCOUNTER_ID'   value='<%=strEncounterId%>'>
		<input type=hidden name='FACILITY_ID' id='FACILITY_ID'   value='<%=strFacilityId%>'>
		<input type=hidden name='PATIENT_CLASS' id='PATIENT_CLASS'   value='<%=PATIENT_CLASS%>'>
		<!-- <input type=hidden name='QIND_DISCIPLINE_ID' id='QIND_DISCIPLINE_ID' value=''> -->
		<input type=hidden name='QUERY_PARAM' id='QUERY_PARAM' value='<%=strQueryParam%>'>
		<%
		           if(rs!=null) rs.close();
				   if(pstmt!=null)pstmt.close();
				  vectorHtmlData.clear();
				}
		
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception in File QAAnalyzePartialIndSearchResult:"+e.toString());
		}
		finally
            {
	         ConnectionManager.returnConnection(conn, request);
            }
%>

</form>
</body>
</html>
	


