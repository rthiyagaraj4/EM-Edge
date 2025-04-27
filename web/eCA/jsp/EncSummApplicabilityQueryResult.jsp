<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
03/10/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/ChartApplicability.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%@page import="java.sql.*,java.io.*, webbeans.eCommon.ConnectionManager"%>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
	  
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String whereClause = "";
	String patientClass = "";
	String speciality = "";
	String practType = "";
	String practitionerName = "";
	String ageGrp = "";
	String summary = "";
	
	String mode = "modify";
	String from = request.getParameter( "from" ) ;	
    String to = request.getParameter( "to" ) ;   
	
	String classValue = "gridData";
	int rowCount = 0;
	int i = 0 ;
	int j = 0;
	
	StringBuffer sql =new StringBuffer();
	int start = 0;
	int end = 0;
	
	StringBuffer sqlQuery =new StringBuffer();
	StringBuffer sqlCount =new StringBuffer();
	int maxRecord =0;
	int count = 0;

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);
	
	try
	{	
		
		con = ConnectionManager.getConnection(request);
		whereClause = request.getParameter("whereClause")==null  ? "" : request.getParameter("whereClause");	
		if(whereClause == null || whereClause.equals(""))
		{
			patientClass = request.getParameter("patientClass");
			if(patientClass != null || !(patientClass.equals("")))
			{
			
				patientClass = patientClass.toUpperCase();
				if(patientClass.equals("") || patientClass==null) patientClass = "%";
				else
				 patientClass = patientClass + "%";
				
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where upper(PATIENT_CLASS)  like  '"+patientClass+"' ");
				count ++;
			}
			
			speciality = request.getParameter("speciality");
			if(speciality != null || !(speciality.equals("")))
			{
				speciality = speciality.toUpperCase();
				if(count > 0)
				{
					sql.append(" and upper(SPECIALITY_SHORT_DESC)  like  '"+speciality+"%' ");
				}
				else
				{
					sql.append(" where upper(SPECIALITY_SHORT_DESC)  like  '"+speciality+"%' ");
					count++;
				}
				
			}
			
			practType = request.getParameter("practType");
			if(practType != null || !(practType.equals("")))
			{
				practType = practType.toUpperCase();
				if(count > 0)
				{
					sql.append(" and upper(PRACT_TYPE_DESC)  like  '"+practType+"%' ");
				}
				else
				{
					sql.append(" where upper(PRACT_TYPE_DESC)  like  '"+practType+"%' ");
					count++;
				}
				
			}
			
			practitionerName = request.getParameter("practitionerId");
			if(practitionerName != null || !(practitionerName.equals("")))
			{
				practitionerName = practitionerName.toUpperCase();
				if(count > 0)
				{
					sql.append(" and upper(PRACTITIONER_NAME)  like  '"+practitionerName+"%' ");
				}
				else
				{
					sql.append(" where upper(PRACTITIONER_NAME)  like  '"+practitionerName+"%' ");
					count++;
				}
				
			}
			
			ageGrp = request.getParameter("ageGrp");
			if(ageGrp != null || !(ageGrp.equals("")))
			{
				ageGrp = ageGrp.toUpperCase();
				if(count > 0)
				{
					sql.append(" and upper(AGE_GROUP_SHORT_DESC)  like  '"+ageGrp+"%' ");
				}
				else
				{
					sql.append(" where upper(AGE_GROUP_SHORT_DESC)  like  '"+ageGrp+"%' ");
					count ++;
				}
				
			}
			
			summary = request.getParameter("summary");
			if(summary != null || !(summary.equals("")))
			{
				summary = summary.toUpperCase();
				if(count > 0)
				{
					sql.append(" and upper(SUMM_SHORT_DESC)  like  '"+summary+"%' ");
				}
				else
				{
					sql.append(" where upper(SUMM_SHORT_DESC)  like  '"+summary+"%' ");
					count ++;
				}
				
			}	   
			String ord[] = request.getParameterValues("orderbycolumns");
			if ( !(ord == null || ord .equals("")) )
			{
				sql.append(" order by ");
				for (i=0;i < ord.length;i++ )
				{
				if ( i == ord.length - 1 )
					sql.append(ord[i]);
				else
					sql.append(ord[i]+",");
				}
			}

		}
		else
		{
			sql.append(whereClause);
		}
		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
		if ( to == null )
			end = pageCnt ;
		else
			end = Integer.parseInt( to ) ;

		System.out.println( " ::: sql ::: "+sql.toString());

		sqlCount.append("select count(*) total from vw_es_summ_applicability  ");
		sqlCount.append(sql.toString());

		System.out.println( " ::: sqlCount ::: "+sqlCount.toString());
		
		ps = con.prepareStatement(sqlCount.toString());
		rs = ps.executeQuery();
		while(rs.next())
		{
			maxRecord = rs.getInt("total");
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		sqlQuery.append("select * from vw_es_summ_applicability ");
		sqlQuery.append(sql.toString());
		
		ps = con.prepareStatement(sqlQuery.toString());
		rs = ps.executeQuery();
%>
<br>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td class='white' width='88%'></td>
<td align=right>
<%
	if ( !(start <= 1) )
		out.println("<A class='gridLink' HREF='../../eCA/jsp/EncSummApplicabilityQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereClause="+java.net.URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	if ( !( (start+pageCnt) > maxRecord ) )
		out.println("<A class='gridLink' HREF='../../eCA/jsp/EncSummApplicabilityQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereClause="+java.net.URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
	</td>
</tr>
</table>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
	<tr>
		<td class='columnheadercenter' width='10%'>
			<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
		</td>
		<td class='columnheadercenter' width='20%'>
			<fmt:message key="eCA.SpecialityDesc.label" bundle="${ca_labels}"/>
		</td>	
		<td class='columnheadercenter' width='15%'>
			<fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>
		</td>	
		<td class='columnheadercenter' width='20%'>
			<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
		</td>			
		<td class='columnheadercenter' width='10%'>
			<fmt:message key="Common.agegroup.label" bundle="${common_labels}"/>
		</td>	
		<td class='columnheadercenter' width='25%'>
			<fmt:message key="Common.Summary.label" bundle="${common_labels}"/>
		</td>	
	</tr>
	<%
		for(j=1,i=1; j<start; i++,j++ )
	    	rs.next() ;
	      
		while ( rs.next() && i<= end  ) 
		{
			classValue =((rowCount & 1) == 0) ? "gridData" : "gridData";		
	%>
	<%
			out.println("<td class='"+classValue+"'> "+ 
							" <a class='gridLink' href='../../eCA/jsp/EncSummApplicabilityAddModify.jsp?" +
							"patientClassDesc="+java.net.URLDecoder.decode(rs.getString("PATIENT_CLASS_SHORT_DESC"))+
							"&mode="+mode+"&patientClassCode="+java.net.URLDecoder.decode(rs.getString("PATIENT_CLASS"))+
							"&specialtyDesc="+java.net.URLDecoder.decode(rs.getString("SPECIALITY_SHORT_DESC"))+
							"&specialtyCode="+java.net.URLDecoder.decode(rs.getString("SPECIALITY_CODE"))+
							"&practTypeDesc="+java.net.URLDecoder.decode(rs.getString("PRACT_TYPE_DESC"))+
							"&practTypeCode="+java.net.URLDecoder.decode(rs.getString("pract_type"))+
							"&practitionerName="+java.net.URLDecoder.decode(rs.getString("practitioner_name"))+
							"&practitionerId="+java.net.URLDecoder.decode(rs.getString("practitioner_id"))+
							"&ageGrpDesc="+java.net.URLDecoder.decode(rs.getString("AGE_GROUP_SHORT_DESC"))+
							"&ageGrpCode="+java.net.URLDecoder.decode(rs.getString("AGE_GROUP_CODE"))+
							"&encSummDesc="+java.net.URLDecoder.decode(rs.getString("summ_short_desc"))+
							"&encSummCode="+java.net.URLDecoder.decode(rs.getString("es_summ_code"))+"'>"+rs.getString("PATIENT_CLASS_SHORT_DESC")+"</a></td>");
	%>	
		<td class='<%=classValue%>'><%=rs.getString("SPECIALITY_SHORT_DESC")%></td>
		<td class='<%=classValue%>'><%=rs.getString("PRACT_TYPE_DESC")%></td>
		<td class='<%=classValue%>'><%=rs.getString("PRACTITIONER_NAME")%></td>
		<td class='<%=classValue%>'><%=rs.getString("AGE_GROUP_SHORT_DESC")%></td>
		<td class='<%=classValue%>'><%=rs.getString("SUMM_SHORT_DESC")%></td>
	</tr>
<%		
			rowCount ++;
			i++;
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in EncSummApplicabilityQueryResult Module "+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{				
			if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}

%>
	</body>
</html>


