<!DOCTYPE html>
<%@page import="java.sql.*,java.io.*,java.util.*,webbeans.eCommon.*,java.net.*,com.ehis.util.*" contentType="text/html;charset=UTF-8"%>
<html>
	<head>
		<% String locale = (String)session.getAttribute("LOCALE"); %>
		<% request.setCharacterEncoding("UTF-8");%>
		<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
		<%
			//String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String sStyle = "IeStyle.css";//Sanjay
		%>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script> -->
		<script src="../../eBT/js/ManageLISSpecimenImage.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onscroll='staticTr()'>
		<form name='LISImgResForm' id='LISImgResForm'>			
	<%
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtPatName = null;
		PreparedStatement pstmtSourceDet = null;
		ResultSet res = null;
		ResultSet resPatName = null;
		ResultSet resSourceDet = null;	

		//String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
		String facilityId = "HS";//Sanjay
		String sectionCode = request.getParameter("secCode") == null ? "" : request.getParameter("secCode");
		String fromSpecNum = request.getParameter("fromSpecNum") == null ? "" : request.getParameter("fromSpecNum");
		String toSpecNum = request.getParameter("toSpecNum") == null ? "" : request.getParameter("toSpecNum");
		String fromSpecRegdDate = request.getParameter("fromSpecRegdDate") == null ? "" : request.getParameter("fromSpecRegdDate");
		fromSpecRegdDate = DateUtils.convertDate(fromSpecRegdDate,"DMYHM",locale,"en");
		String toSpecRegdDate = request.getParameter("toSpecRegdDate") == null ? "" : request.getParameter("toSpecRegdDate");
		toSpecRegdDate = DateUtils.convertDate(toSpecRegdDate,"DMYHM",locale,"en");
		String fromCatNum = request.getParameter("fromCatNum") == null ? "" : request.getParameter("fromCatNum");
		String frmCatYr = request.getParameter("frmCatYr") == null ? "" : request.getParameter("frmCatYr");
		String frmCatNoPart = request.getParameter("frmCatNoPart") == null ? "" : request.getParameter("frmCatNoPart");
		String toCatNum = request.getParameter("toCatNum") == null ? "" : request.getParameter("toCatNum");
		String toCatYr = request.getParameter("toCatYr") == null ? "" : request.getParameter("toCatYr");
		String toCatNoPart = request.getParameter("toCatNoPart") == null ? "" : request.getParameter("toCatNoPart");
		String priority = request.getParameter("priority") == null ? "" : request.getParameter("priority");
		String from = request.getParameter("from") ;
	    String to = request.getParameter("to") ;

		String specimenNum = "";
		String specRegdDate = "";
		String patId = "";
		String episodeType = "";
		String patName = "";
		String patSex = "";
		String sourceType = "";
		String sourceCode = "";
		String sourceDesc = "";
		String catNum = "";
		String classValue = "QRYEVEN";

		int count = 0;
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i=1;

		if (from == null)
			start = 1 ;
		else
			start = Integer.parseInt(from);

		if (to == null)
			end = 14 ;
		else
			end = Integer.parseInt(to) ;

		StringBuffer sqlRes = new StringBuffer("SELECT A.specimen_no, to_char(A.spec_regd_date_time,'dd/mm/yyyy hh24:mi') spec_regd_date_time, A.source_type, A.source_code, A.category_code,	A.category_year, A.category_number, A.section_code,	A.urgent_indicator, B.patient_id, B.episode_type, A.category_code || ' ' || A.category_year || ' ' || A.category_number category_no FROM RL_OUTSTANDING_WORK A, RL_REQUEST_HEADER B WHERE A.operating_facility_id = ? and a.section_code = ? ");

		if(!fromSpecNum.equals("") && !toSpecNum.equals(""))
		{
			sqlRes.append(" and a.specimen_no >= ? and  a.specimen_no <= ? ");
		}
		else if(!fromSpecNum.equals("") && toSpecNum.equals(""))
		{
			sqlRes.append(" and a.specimen_no >= ? ");
		}
		else if(fromSpecNum.equals("") && !toSpecNum.equals(""))
		{
			sqlRes.append(" and a.specimen_no <= ? ");
		}

		if(!fromSpecRegdDate.equals("") && !toSpecRegdDate.equals(""))
		{
			sqlRes.append(" and A.spec_regd_date_time >= to_date(?,'dd/mm/yyyy hh24:mi') and A.spec_regd_date_time <= to_date(?,'dd/mm/yyyy hh24:mi')");
		}
		else if(!fromSpecRegdDate.equals("") && toSpecRegdDate.equals(""))
		{
			sqlRes.append(" and A.spec_regd_date_time >= to_date(?,'dd/mm/yyyy hh24:mi')");
		}
		else if(fromSpecRegdDate.equals("") && !toSpecRegdDate.equals(""))
		{
			sqlRes.append(" and A.spec_regd_date_time <= to_date(?,'dd/mm/yyyy hh24:mi') ");
		}

		if(!fromCatNum.equals("") && !toCatNum.equals(""))
		{
			sqlRes.append(" and A.category_code >= ? and  A.category_code <= ? ");
		}
		else if(!fromCatNum.equals("") && toCatNum.equals(""))
		{
			sqlRes.append(" and A.category_code >= ?  ");
		}
		else if(fromCatNum.equals("") && !toCatNum.equals(""))
		{
			sqlRes.append(" and  A.category_code <= ?  ");
		}

		if(!frmCatYr.equals("") && !toCatYr.equals(""))
		{
			sqlRes.append(" and  A.category_year >= ?  and A.category_year <= ? ");
		}
		else if(!frmCatYr.equals("") && toCatYr.equals(""))
		{
			sqlRes.append(" and  A.category_year >= ? ");
		}
		else if(frmCatYr.equals("") && !toCatYr.equals(""))
		{
			sqlRes.append(" and  A.category_year <= ? ");
		}

		if(!frmCatNoPart.equals("") && !toCatNoPart.equals(""))
		{
			sqlRes.append(" and  A.category_number >= ?  and A.category_number <= ? ");			
		}
		else if(!frmCatNoPart.equals("") && toCatNoPart.equals(""))
		{
			sqlRes.append(" and  A.category_number >= ? ");
		}
		else if(frmCatNoPart.equals("") && !toCatNoPart.equals(""))
		{
			sqlRes.append(" and  A.category_number <= ? ");
		}


		if(!priority.equals(""))
		{
			sqlRes.append(" and A.urgent_indicator = ? ");
		}

		sqlRes.append(" AND A.specimen_no = B.specimen_no AND A.operating_facility_id = B.operating_facility_id ORDER BY specimen_no ");
	
		try
		{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sqlRes.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			pstmt.setString(++count,facilityId);
			pstmt.setString(++count,sectionCode);

			if(!fromSpecNum.equals("") && !toSpecNum.equals(""))
			{
				pstmt.setString(++count,fromSpecNum);
				pstmt.setString(++count,toSpecNum);
			}
			else if(!fromSpecNum.equals("") && toSpecNum.equals(""))
			{
				pstmt.setString(++count,fromSpecNum);
			}
			else if(fromSpecNum.equals("") && !toSpecNum.equals(""))
			{
				pstmt.setString(++count,toSpecNum);
			}

			if(!fromSpecRegdDate.equals("") && !toSpecRegdDate.equals(""))
			{
				pstmt.setString(++count,fromSpecRegdDate);
				pstmt.setString(++count,toSpecRegdDate);
			}
			else if(!fromSpecRegdDate.equals("") && toSpecRegdDate.equals(""))
			{
				pstmt.setString(++count,fromSpecRegdDate);
			}
			else if(fromSpecRegdDate.equals("") && !toSpecRegdDate.equals(""))
			{
				pstmt.setString(++count,toSpecRegdDate);
			}

			if(!fromCatNum.equals("") && !toCatNum.equals(""))
			{
				pstmt.setString(++count,fromCatNum);
				pstmt.setString(++count,toCatNum);
			}
			else if(!fromCatNum.equals("") && toCatNum.equals(""))
			{
				pstmt.setString(++count,fromCatNum);
			}
			else if(fromCatNum.equals("") && !toCatNum.equals(""))
			{
				pstmt.setString(++count,toCatNum);
			}

			if(!frmCatYr.equals("") && !toCatYr.equals(""))
			{
				pstmt.setString(++count,frmCatYr);
				pstmt.setString(++count,toCatYr);
			}
			else if(!frmCatYr.equals("") && toCatYr.equals(""))
			{
				pstmt.setString(++count,frmCatYr);
			}
			else if(frmCatYr.equals("") && !toCatYr.equals(""))
			{
				pstmt.setString(++count,toCatYr);
			}

			if(!frmCatNoPart.equals("") && !toCatNoPart.equals(""))
			{
				pstmt.setString(++count,frmCatNoPart);
				pstmt.setString(++count,toCatNoPart);
			}
			else if(!frmCatNoPart.equals("") && toCatNoPart.equals(""))
			{
				pstmt.setString(++count,frmCatNoPart);
			}
			else if(frmCatNoPart.equals("") && !toCatNoPart.equals(""))
			{
				pstmt.setString(++count,toCatNoPart);
			}
	
			if(!priority.equals(""))
			{
				pstmt.setString(++count,priority);
			}

			res = pstmt.executeQuery();
			while(res.next())
			{
				maxRecord++;
			}
			if(maxRecord == 0)
			{
				//alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			
				//out.println("<script>alert(s1);history.go(-1);</script>");				
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				//out.println("<script>alert("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"NO_RECORD_FOUND_FOR_CRITERIA", "Common")+");history.go(-1);</script>");
				//out.println("<script>alert(getMessage("+"NO_RECORD_FOUND_FOR_CRITERIA"+","+"common"+")"+");history.go(-1);</script>");
				//out.println("<script>alert('No Sanjay'));history.go(-1);</script>");
			}
			%>
			<P>
			<table align='right'>
			<tr>
			<td>
			<%
			if (!(start <= 1))
				out.println("<A HREF='../../eBT/jsp/ManageLISSpecimenImageResult.jsp?from="+(start-14)+"&to="+(end-14)+"&"+request.getQueryString()+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+14) > maxRecord ) )
				out.println("<A HREF='../../eBT/jsp/ManageLISSpecimenImageResult.jsp?from="+(start+14)+"&to="+(end+14)+"&"+request.getQueryString()+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
			</td>
			</tr>
			</table>
			<br><br>
			</p>
			<table border='1' width='100%' cellpadding='1' cellspacing='0' align='center'>
				<tr id='imageResTr'>
					<th align='left'><fmt:message key="eBT.SpecimenNo.label" bundle="${common_labels}"/></th>
					<th align='left'><fmt:message key="Common.RegnDate.label" bundle="${common_labels}"/></th> 
					<th align='left'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th> 
					<th align='left'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th> 
					<th align='left'><fmt:message key="Common.Sex.label" bundle="${common_labels}"/></th> 
					<th align='left'><fmt:message key="Common.source.label" bundle="${common_labels}"/></th> 
					<th align='left'><fmt:message key="Common.CategoryCode.label" bundle="${common_labels}"/></th> 
				</tr>
		<%
			res.beforeFirst();

			if(start != 1)
				for(int j=1; j<start; i++,j++)
				  res.next() ;			
		    while(res.next() && i<=end)
			{
				
				episodeType = res.getString("episode_type") == null ? "" : res.getString("episode_type");
				patId = res.getString("patient_id") == null ? "" : res.getString("patient_id");
				sourceType = res.getString("source_type") == null ? "" : res.getString("source_type");
				sourceCode = res.getString("source_code") == null ? "" : res.getString("source_code");
				specimenNum = res.getString("specimen_no") == null ? "" : res.getString("specimen_no");
				specRegdDate = res.getString("spec_regd_date_time") == null ? "" : res.getString("spec_regd_date_time");
				catNum = res.getString("category_no") == null ? "" : res.getString("category_no");
				
				if(episodeType.equals("I") || episodeType.equals("O") || episodeType.equals("H"))
				{
					pstmtPatName = con.prepareStatement("SELECT short_name, sex, date_of_birth FROM MP_PATIENT_MAST WHERE patient_id = ?");
				}
				else
				{
					pstmtPatName = con.prepareStatement("SELECT short_name, sex, date_of_birth FROM RL_PATIENT_MAST WHERE patient_id = ?");
				}
				pstmtPatName.setString(1,patId);
				resPatName = pstmtPatName.executeQuery();

				while(resPatName.next())
				{
					patName = resPatName.getString("short_name") == null ? "" : resPatName.getString("short_name");
					patSex = resPatName.getString("sex") == null ? "" : resPatName.getString("sex");
				}

				if(resPatName != null) resPatName.close();
				if(pstmtPatName != null) pstmtPatName.close();

				if(sourceType.equals("W"))
				{
					//pstmtSourceDet = con.prepareStatement("SELECT short_desc FROM IP_WARD WHERE facility_id = ? AND ward_code = ?");					
					pstmtSourceDet = con.prepareStatement("SELECT short_desc FROM IP_NURSING_UNIT_LANG_VW WHERE facility_id = ? AND NURSING_UNIT_CODE = ? AND Language_id = ?");					
					pstmtSourceDet.setString(1,facilityId);
					pstmtSourceDet.setString(2,sourceCode);
					pstmtSourceDet.setString(3,locale);
				}
				else if(sourceType.equals("C"))
				{
					//pstmtSourceDet = con.prepareStatement("SELECT short_desc FROM OP_CLINIC_HIS_VW WHERE facility_id = ? AND clinic_code = ? ");
					pstmtSourceDet = con.prepareStatement("SELECT short_desc FROM OP_CLINIC_LANG_VW WHERE facility_id = ? AND clinic_code = ? AND Language_id = ?");
					pstmtSourceDet.setString(1,facilityId);
					pstmtSourceDet.setString(2,sourceCode);
					pstmtSourceDet.setString(3,locale);
				}
				else
				{
					//pstmtSourceDet = con.prepareStatement("SELECT short_desc FROM RL_REFERRAL WHERE referral_code = ? ");
					pstmtSourceDet = con.prepareStatement("SELECT short_desc FROM RL_REFERRAL_LANG_VW WHERE referral_code = ? AND Language_id  = ?");
					pstmtSourceDet.setString(1,sourceCode);
					pstmtSourceDet.setString(2,locale);
				}

				resSourceDet = pstmtSourceDet.executeQuery();				

				while(resSourceDet.next())
				{
					sourceDesc = resSourceDet.getString("short_desc") == null ? "" : resSourceDet.getString("short_desc");
				}

				if(resSourceDet != null) resSourceDet.close();
				if(pstmtSourceDet != null) pstmtSourceDet.close();

				if(i % 2 == 0) classValue = "QRYEVEN";
				else classValue = "QRYODD";
				
				out.println("<tr>");
				out.println("<td class = '"+classValue+"'><a href=\"javascript:specimenDetails('"+specimenNum+"')\" >"+specimenNum+"</a></td>");
				out.println("<td class = '"+classValue+"'>"+specRegdDate+"</td>");
				out.println("<td class = '"+classValue+"'>"+patId+"</td>");
				out.println("<td class = '"+classValue+"'>"+patName+"</td>");
				out.println("<td class = '"+classValue+"'>"+patSex+"</td>");
				out.println("<td class = '"+classValue+"'>"+sourceDesc+"</td>");
				out.println("<td class = '"+classValue+"'>"+catNum+"</td>");
				out.println("</tr>");
				i++;
			}//end of while

			if(res != null) res.close();
			if(pstmt != null) pstmt.close();
		}//end of try
		catch(Exception e)
		{
			//out.println("Exception in try of ManageLISSpecimenImageResult.jsp --"+e.toString());
			//System.out.println("Exception in try of ManageLISSpecimenImageResult.jsp --"+e.toString());
			e.printStackTrace(System.err);
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	%>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			</table>
		</form>
	</body>
</html>

