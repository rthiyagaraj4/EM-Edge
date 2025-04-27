<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="EventBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%EventBean.clearAll();%>
<html>
	<head>
		<title></title>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCA/js/RecClinicalNotesLinkFutureEvent.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>

</head>

<%
			
	/*String from_date_time	=	request.getParameter("from_date_time")==null?"1/1/1900":request.getParameter("from_date_time");
	
	String to_date_time=request.getParameter("to_date_time")==null?"1/1/4000":request.getParameter("to_date_time");*/
  
	String from_date	="";
	String end_date		="";
 	StringBuffer strsql1 = new StringBuffer(" ");
 	StringBuffer where = new StringBuffer(" ");
    
	//String facility_id = (String)session.getValue("facility_id") ;
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String order=request.getParameter("order")==null?"":request.getParameter("order");
	String nature=request.getParameter("nature")==null?"":request.getParameter("nature");
	
	//String encounter_id	=		request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String from 			= 	request.getParameter("from");
	String to 	= 	request.getParameter("to");
	String rfrdFromDate 	= 	request.getParameter("rfrdFromDate")==null?"":request.getParameter("rfrdFromDate");
	String rfrdToDate 	= 	request.getParameter("rfrdToDate")==null?"":request.getParameter("rfrdToDate");

	String whereclause= request.getParameter("whereclause")==null?"":request.getParameter("whereclause");
	from_date=request.getParameter("from_date")==null?"":request.getParameter("from_date");
	end_date=request.getParameter("to_date")==null?"":request.getParameter("to_date");
	
	from_date		=	com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
	end_date		=	com.ehis.util.DateUtils.convertDate(end_date,"DMY",locale,"en");

	String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	
	String rowid="";
	
	String refid=""; 
	String referdate=""; 
	String referdate_th	="";
	String refpriority=""; 
	String priority="";
	String refreason="";  
	String refpractfrom="";  
	String refpractto="";  
	String refspecfrom="";  
	String refspecto= "";   
	String reflocfrom="";  
	String reflocto= "";
	String reffacfrom= "";  
	String reffacto= "";  
	
	String practionerid= "";  
	
	ArrayList  fields			=	new ArrayList();
	String categ_sec_qry ="";
	String field_ref ="";
/*	String col_field ="";
	//String col_val ="";
	int col_span=0;*/

	PreparedStatement pstmt=null;
	ResultSet rset=null;

		
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int k=0;
	int maxRecord =0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

   	try
	{
       con =  ConnectionManager.getConnection(request);

	   practionerid   = (String) session.getValue("ca_practitioner_id"); 

		//shaiju new diag starts
	  
	   categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='RFRL' order by ORDER_SEQ_NUM";

		pstmt = con.prepareStatement(categ_sec_qry);
		
		pstmt.setString(1,sec_hdg_code);
		pstmt.setString(2,result_linked_rec_type);
		//pstmt.setString(3,result_linked_rec_type);

		rset = pstmt.executeQuery();

		if(rset.next())
		{
			do
			{
				field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
				fields.add(field_ref);
			}
			while(rset.next());

		}
		else
		{
			 if (rset != null) rset.close();
			 if (pstmt != null) pstmt.close();

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='RFRL' order by ORDER_SEQ_NUM";

			pstmt = con.prepareStatement(categ_sec_qry);
			pstmt.setString(1,result_linked_rec_type);
			//pstmt.setString(2,result_linked_rec_type);

			rset = pstmt.executeQuery();

			if(rset.next())
			{
				do
				{
					field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
					fields.add(field_ref);
				}
				while(rset.next());

				if (rset != null) rset.close();
				if(pstmt != null) pstmt.close();

			}
		

		}
		
	  
	  //shaiju new diag ends




	  
	  /* strsql1.append("select a.rowid row_id,a.REFERRAL_ID,to_char(a.REFERRAL_DATE,'dd/mm/yyyy hh24:mi') REFERRAL_DATE,decode(a.referral_priority,'E','Emergency','R','Referral for Admission','U','Semi Emergency','L','Elective') REFERRAL_PRIORITY,(select contact_reason from am_contact_reason where contact_reason_code=a.REFERRAL_REASON_CODE)  REFERRAL_REASON,nvl(replace(FROM_PRACT_NAME,'''',''),(select replace(short_name,'''','') from am_practitioner where practitioner_id=a.FROM_PRACT_ID)) FROM_REF_PRACT_NAME ,(select replace(short_desc,'''','') from am_speciality where speciality_code= A.FROM_SPECIALITY_CODE) FROM_SPLTY_DESC ,case when FROM_LOCN_DESC is not null then replace(FROM_LOCN_DESC,'''','') when FROM_LOCN_TYPE='N' then (select replace(short_desc,'''','') from ip_nursing_unit where facility_id=a.FROM_FACILITY_ID and                    nursing_unit_code=a.FROM_LOCN_CODE) when FROM_LOCN_TYPE='C' then (select replace(short_desc,'''','') from op_clinic where facility_id=a.FROM_FACILITY_ID and                               clinic_code=a.FROM_LOCN_CODE) end FROM_REF_LOCN_DESC ,(select facility_name from sm_facility_param where facility_id=a.FROM_FACILITY_ID) FROM_FACILITY_NAME , nvl(replace(TO_PRACT_NAME,'''',''),(select replace(short_name,'''','') from am_practitioner where practitioner_id=a.TO_PRACT_ID)) TO_REF_PRACT_NAME ,(select replace(short_desc,'''','') from am_speciality where speciality_code= A.TO_SPECIALITY_CODE) TO_SPECIALITY_DESC ,case when TO_LOCN_DESC is not null then replace(FROM_LOCN_DESC,'''','') when TO_LOCN_TYPE='N' then (select replace(short_desc,'''','') from ip_nursing_unit where facility_id=a.TO_FACILITY_ID and                                         nursing_unit_code=a.TO_LOCN_CODE) when  TO_LOCN_TYPE='C' then (select replace(short_desc,'''','') from op_clinic where facility_id=a.TO_FACILITY_ID and clinic_code=a.TO_LOCN_CODE) end TO_REF_LOCN_DESC ,(select facility_name from sm_facility_param where facility_id=a.TO_FACILITY_ID) TO_FACILITY_NAME from  pr_referral_register a where a.patient_id=?");
	   
	    if ( (whereclause == null || whereclause.equals("")) )
	     {
        
		/*if (link.equals("Dat"))
		where.append(" AND PREFERRED_TREATMENT_DATE between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') +.9999 ");
		else if (link.equals("Refid"))
		where.append(" and REFERRAL_ID=?");*//*

         where.append("  and (  a.PREFERRED_TREATMENT_DATE is null or  a.PREFERRED_TREATMENT_DATE between nvl(to_date(?,'dd/mm/yyyy'),trunc(SYSDATE)) and  NVL(to_date(?,'dd/mm/yyyy'),SYSDATE+365))");
		
	   // out.println("<script>alert('orddate:"+orddate+"')</script>");
	    //out.println("<script>alert('orderlineno:"+orderlineno+"')</script>");
	    //out.println("<script>alert('strsql1"')</script>");

		if((nature.equals("S")))
		{
		   where.append(" and a.FROM_PRACT_ID = ?");
		} 
	  
		if(order.equals("D"))
		where.append(" order by a.PREFERRED_TREATMENT_DATE desc, a.REFERRAL_DATE desc ");
		else
        where.append(" order by a.PREFERRED_TREATMENT_DATE,a.REFERRAL_DATE "); 
	
	
	    
	    strsql1.append(where.toString()); 
	    }
	    else
	    {
		strsql1.append(whereclause);

	    } */
		//
		strsql1.append("select a.rowid row_id,a.REFERRAL_ID,to_char(a.REFERRAL_DATE,'dd/mm/yyyy hh24:mi') REFERRAL_DATE,a.referral_priority,AM_GET_DESC.AM_CONTACT_REASON(A.REFERRAL_REASON_CODE,?,'1')   REFERRAL_REASON,nvl(replace(FROM_PRACT_NAME,'''',''),replace(AM_GET_DESC.AM_PRACTITIONER(A.FROM_PRACT_ID,?,'2'),'''','')) FROM_REF_PRACT_NAME ,AM_GET_DESC.AM_SPECIALITY(a.from_speciality_code,?,'2')  FROM_SPLTY_DESC ,case when FROM_LOCN_DESC is not null then replace(FROM_LOCN_DESC,'''','') when FROM_LOCN_TYPE='N' then IP_GET_DESC.IP_NURSING_UNIT(a.from_facility_id,a.from_locn_code,?,'1') when FROM_LOCN_TYPE='C' then OP_GET_DESC.OP_CLINIC(a.from_facility_id,a.from_locn_code,?,'1') end FROM_REF_LOCN_DESC ,SM_GET_DESC.SM_FACILITY_PARAM(a.from_facility_id,?,'1') FROM_FACILITY_NAME , nvl(replace(TO_PRACT_NAME,'''',''),AM_GET_DESC.AM_PRACTITIONER(A.TO_PRACT_ID,?,'2')) TO_REF_PRACT_NAME ,replace(AM_GET_DESC.AM_SPECIALITY(a.TO_SPECIALITY_CODE,?,'2'),'''','') TO_SPECIALITY_DESC ,case when TO_LOCN_DESC is not null then replace(FROM_LOCN_DESC,'''','') when TO_LOCN_TYPE='N' then replace(IP_GET_DESC.IP_NURSING_UNIT(a.to_facility_id,a.to_locn_code,?,'1'),'''','') when  TO_LOCN_TYPE='C' then replace(OP_GET_DESC.OP_CLINIC(a.to_facility_id,a.to_locn_code,?,'1'),'''','') end TO_REF_LOCN_DESC ,SM_GET_DESC.SM_FACILITY_PARAM(a.to_facility_id,?,'1') TO_FACILITY_NAME from  pr_referral_register a where a.patient_id=?");
	   
	    if((whereclause == null || whereclause.equals("")) )
			{
        
		   where.append("  and (  a.PREFERRED_TREATMENT_DATE is null or  a.PREFERRED_TREATMENT_DATE between nvl(to_date(?,'dd/mm/yyyy'),trunc(SYSDATE)) and  NVL(to_date(?,'dd/mm/yyyy'),SYSDATE+365))");
		   if(!rfrdFromDate.equals(""))
			{
				where.append("  and a.REFERRAL_DATE  >= to_date(?,'dd/mm/yyyy')");
			}
			if(!rfrdToDate.equals(""))
			{
				where.append("  and a.REFERRAL_DATE  <= to_date(?,'dd/mm/yyyy')+.9999 ");
			}
		
	   	if((nature.equals("S")))
		{
		   where.append(" and a.FROM_PRACT_ID = ?");
		} 
	  
		if(order.equals("D"))
		where.append(" order by a.PREFERRED_TREATMENT_DATE desc, a.REFERRAL_DATE desc ");
		else
        where.append(" order by a.PREFERRED_TREATMENT_DATE,a.REFERRAL_DATE "); 
		    
	    strsql1.append(where.toString()); 
	    }
	    else
	    {
		strsql1.append(whereclause);
		}

	
		stmt = con.prepareStatement(strsql1.toString());
		int st=0;

		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
        //stmt.setString(++st,facility_id);
		stmt.setString(++st,patient_id);
		
		/*if(link.equals("Dat"))
		{
		stmt.setString(++st,refdate);
		stmt.setString(++st,refdate);
		}
        else if(link.equals("Refid"))
		stmt.setString(++st,refval);*/
		
        stmt.setString(++st,from_date);
		stmt.setString(++st,end_date);
		 if(!rfrdFromDate.equals(""))
			{
			stmt.setString(++st,rfrdFromDate);
			}
		 if(!rfrdToDate.equals(""))
			{
			stmt.setString(++st,rfrdToDate);
			}
		
		if((nature.equals("S")))
		{
		stmt.setString(++st,practionerid);
		}
	  
		
    	rs = stmt.executeQuery();
	    
	 %>

<body onScroll="scrollTitle()" onKeyDown="lockKey()">
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>





<form name="RecClinicalNotesLinkFutureApptResultForm" id="RecClinicalNotesLinkFutureApptResultForm">	
<div id='divDataTitle' style='postion:relative'>
<table border="1" id="finalDiv" cellpadding="3" cellspacing="0" width="100%" align="center">
<tr >
<%
if ( !(start <= 1) )
		{
out.println("<td width='85%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%'>");
out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkFutureReferralResult.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&patient_id="+patient_id+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		}
		else
		{
out.println("<td width='100%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' >");
		}

//out.println("<script>alert('start"+start+"')</script>");

  if ( !( (start+14) > maxRecord ) )
		{
	out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkFutureReferralResult.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&patient_id="+patient_id+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		}
	%>	
</td>
</tr>
</table>

<table border="1" cellpadding="3" cellspacing="0" width="100%" align='center'  name="resultTable" id="resultTable" id="resultTable">
<tr>
<td class='columnheader' style="font-size:10" colspan=4><fmt:message key="Common.selectall.label" bundle="${common_labels}"/><input type='checkbox' name='ctrlChkBox' id='ctrlChkBox' onClick="javascript:perform(this);" ></td>
</tr>
</table>
</div>
<table class="grid" width="100%" align='center' name="resultTable2" id="resultTable2" id="resultTable2">
	<% 
	//out.println("<script>alert('start"+start+"')</script>");
	//out.println("<script>alert('end"+end+"')</script>");
	//out.println("<script>alert('i="+i+"')</script>");
      if ( start != 1 )
		{
		    for( int j=1; j<start; i++,j++ )
	           {
	             rs.next() ;
	           }
		}
		//out.println("<script>alert('end"+end+"')</script>");
	//out.println("<script>alert('i="+i+"')</script>");
	//out.println("<script>alert('rs.next()="+rs.next()+"')</script>");

		String classValue="";
		String classValue1="";
		int p=0; 
	 while(rs!=null && rs.next() && i<=end)
		{
		 
		rowid		=rs.getString("row_id")==null?" ":rs.getString("row_id");
		refid		=rs.getString("REFERRAL_ID")==null?" ":rs.getString("REFERRAL_ID");
		referdate	=rs.getString("REFERRAL_DATE")==null?" ":rs.getString("REFERRAL_DATE");
		referdate_th	=	com.ehis.util.DateUtils.convertDate(referdate,"DMYHM","en",locale);
		//refpriority=rs.getString("REFERRAL_PRIORITY")==null?" ":rs.getString("REFERRAL_PRIORITY");
		priority	= rs.getString("REFERRAL_PRIORITY")==null?" ":rs.getString("REFERRAL_PRIORITY");
		refreason	=rs.getString("REFERRAL_REASON")==null?" ":rs.getString("REFERRAL_REASON");
		refpractfrom=rs.getString("FROM_REF_PRACT_NAME")==null?" ":rs.getString("FROM_REF_PRACT_NAME");
        refpractto	=rs.getString("TO_REF_PRACT_NAME")==null?" ":rs.getString("TO_REF_PRACT_NAME");
		refspecfrom	=rs.getString("FROM_SPLTY_DESC")==null?" ":rs.getString("FROM_SPLTY_DESC");
		refspecto	=rs.getString("TO_SPECIALITY_DESC")==null?" ":rs.getString("TO_SPECIALITY_DESC");
		reflocfrom	=rs.getString("FROM_REF_LOCN_DESC")==null?" ":rs.getString("FROM_REF_LOCN_DESC");
		reflocto	=rs.getString("TO_REF_LOCN_DESC")==null?" ":rs.getString("TO_REF_LOCN_DESC");
		reffacfrom	=rs.getString("FROM_FACILITY_NAME")==null?" ":rs.getString("FROM_FACILITY_NAME");
		reffacto	=rs.getString("TO_FACILITY_NAME")==null?" ":rs.getString("TO_FACILITY_NAME");
		
		 
		if(priority.equals("E"))
			refpriority = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		else if(priority.equals("R"))
			refpriority = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.for.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admission.label","common_labels");
		else if(priority.equals("U"))
			refpriority = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiemergency.label","common_labels");
		else if(priority.equals("L"))
			refpriority = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.elective.label","common_labels");

			
		 if ( i % 2 == 0 ){
		 classValue = "CAGROUP" ;
		 classValue1 = "gridData" ;
		 }else{
		 classValue = "CAGROUP" ;
		 classValue1 = "gridData" ;
		// classValue = "LABEL" ;
		 }
	  	
	    
		 String beankey="";		
	 	 String checkstatus="";		
         
		for(int m=0;m<EventBean.getSize();m+=2)
				{
					beankey=EventBean.getObject(m).toString();
					
  					if(rowid.equalsIgnoreCase(beankey))
					{
					checkstatus="checked";
                    p++; 
					break;
					}
					
                   

				}
			%>
				<%
					if(fields.size()>0)
					{

						%>
						<tr><td class="<%=classValue%>" ><input type="checkbox" name="chkbox<%=k%>" id="chkbox<%=k%>" onClick="Reassaign(this);chkunchk(this)" value="<%=k%>"<%=checkstatus%>>
					<font size=2><b><fmt:message key="Common.referralid.label" bundle="${common_labels}"/> : </b></font><%=refid%></td><input type='hidden' name='chk_value<%=k%>' id='chk_value<%=k%>' value="<%=rowid%>">
					<!-- Instead of encoding and sending 'refreason','refpractfrom','refpractto','refspecfrom','refspecto','reflocfrom','reflocto','reffacfrom','reffacto' is passed directly modified by Archana Dhal on 10/28/2010 related to incident no IN024711. -->
					<input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=rowid%>~<%=refid%>|<%=referdate%>|<%=refpriority%>|<%=refreason%>|<%=refpractfrom%>|<%=refpractto%>|<%=refspecfrom%>|<%=refspecto%>|<%=reflocfrom%>|<%=reflocto%>|<%=reffacfrom%>|<%=reffacto%>'>
						
						<%
							if(fields.contains("DATE"))
							{
							%>
								<td class="<%=classValue%>"  ><font size=2><b><fmt:message key="Common.ReferredDate.label" bundle="${common_labels}"/> : </b></font><%=referdate_th%></td>
							<%
							}
							if(fields.contains("PRIORITY"))
							{
							%>
								<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/> : </b></font><%=refpriority%></td>
							<%
							}
							%>
							
							</tr>  
							<%

								if(fields.contains("REASONFORREFERRAL"))
							{
								%>
									<tr><td class="<%=classValue%>" colspan=4><font size=2><b><fmt:message key="Common.ReasonforReferral.label" bundle="${common_labels}"/> : </b></font><%=refreason%></td></tr>
								<%
							}
							%>
							
							<tr><td class="<%=classValue1%>" colspan="4">
									<table border="1"  cellpadding="3" cellspacing="0" width="100%">
									<tr>
									<td class="<%=classValue1%>">&nbsp;</td> 
							
							
							<%

								if(fields.contains("REFERREDFROM"))
							{
								%>
									<td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></b></font></td>
								<%
							}
							 if(fields.contains("REFERREDTO"))
							{
							%>
								<td class="<%=classValue1%>" colspan="2"><font size=2><b><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/> </b></font></td>
							<%
							}
							%>
							</tr>
							<%
						
						//for(int l=0;l<fields.size();++l)
						//{
							//col_field = (String)fields.get(l);

													
														
							if(fields.contains("PRACTITIONER"))
							{
								%>
									<tr><td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></b></font></td>
								<%
									if(fields.contains("REFERREDFROM"))
									{
									%>
										<td class="<%=classValue1%>" ><%=refpractfrom%>&nbsp;</td>
									<%
															
									}
									if(fields.contains("REFERREDTO"))
									{
									%>
										<td class="<%=classValue1%>" colspan="2"><%=refpractto%>&nbsp;</td>
									<%
															
									}
									%></tr><%
								
								
							}
							 if(fields.contains("SPECIALITY"))
							{
								%>
									<tr><td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></b></font></td>
								<%
									if(fields.contains("REFERREDFROM"))
									{
									%>
										<td class="<%=classValue1%>" ><%=refspecfrom%>&nbsp;</td>
									<%
															
									}
									if(fields.contains("REFERREDTO"))
									{
									%>
										<td class="<%=classValue1%>" colspan="2"><%=refspecto%>&nbsp;</td>
									<%
															
									}
									%></tr><%
															
							}
							if(fields.contains("LOCATION"))
							{
								%>
									<tr><td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/></b></font></td>
								<%
									if(fields.contains("REFERREDFROM"))
									{
									%>
										<td class="<%=classValue%>" ><%=reflocfrom%>&nbsp;</td>
									<%
															
									}
									if(fields.contains("REFERREDTO"))
									{
									%>
										<td class="<%=classValue1%>" colspan="2"><%=reflocto%>&nbsp;</td>
									<%
															
									}
									%></tr><%
															
							}
							if(fields.contains("SOURCE"))
							{
								%>
									<tr><td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.source.label" bundle="${common_labels}"/></b></font></td>
								<%
									if(fields.contains("REFERREDFROM"))
									{
									%>
										<td class="<%=classValue1%>" ><%=reffacfrom%>&nbsp;</td>
									<%
															
									}
									if(fields.contains("REFERREDTO"))
									{
									%>
										<td class="<%=classValue1%>" colspan="2"><%=reffacto%>&nbsp;</td>
									<%
															
									}
									%></tr><%
															
							}
						
						%>
							</table>
							</td>
							</tr>
						<%
						
						//} 

					}
					else
					{
						
					%>
                 
				<tr>			
					<td class="<%=classValue%>" ><input type="checkbox" name="chkbox<%=k%>" id="chkbox<%=k%>" onClick="Reassaign(this);chkunchk(this)" value="<%=k%>"<%=checkstatus%>>
					<font size=2><b><fmt:message key="Common.referralid.label" bundle="${common_labels}"/> : </b></font><%=refid%></td><input type='hidden' name='chk_value<%=k%>' id='chk_value<%=k%>' value="<%=rowid%>">
					<input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=rowid%>~<%=refid%>|<%=referdate_th%>|<%=refpriority%>|<%=refreason%>|<%=refpractfrom%>|<%=refpractto%>|<%=refspecfrom%>|<%=refspecto%>|<%=reflocfrom%>|<%=reflocto%>|<%=reffacfrom%>|<%=reffacto%>'> 
					<td class="<%=classValue%>"  ><font size=2><b><fmt:message key="Common.ReferredDate.label" bundle="${common_labels}"/> : </b></font><%=referdate_th%></td>
                    <td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/> : </b></font><%=refpriority%></td>
                    
                 </tr>
                 <tr>
                 <td class="<%=classValue%>" colspan=4><font size=2><b><fmt:message key="Common.ReasonforReferral.label" bundle="${common_labels}"/> : </b></font><%=refreason%></td> 
                 </tr>
                 <tr>
				<td class="<%=classValue1%>" colspan="4">
                   <table border="1"  cellpadding="3" cellspacing="0" width="100%">
                   <tr>
                   <td class="<%=classValue1%>">&nbsp;</td> 
        		   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.ReferredFrom.label" bundle="${common_labels}"/></b></font></td> 
        		   <td class="<%=classValue1%>" colspan="2"><font size=2><b><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/> </b></font></td> 
                   </tr>
				   <tr>	
				   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></b></font></td>    
                   <td class="<%=classValue1%>" ><%=refpractfrom%>&nbsp;</td>   
                   <td class="<%=classValue1%>" colspan="2"><%=refpractto%>&nbsp;</td>   
				   </tr>
				   <tr>	
				   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></b></font></td>    
                   <td class="<%=classValue1%>" ><%=refspecfrom%>&nbsp;</td>   
                   <td class="<%=classValue1%>" colspan="2"><%=refspecto%>&nbsp;</td>   
				   </tr>	
                   <tr>	
				   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/></b></font></td>    
                   <td class="<%=classValue1%>" ><%=reflocfrom%>&nbsp;</td>   
                   <td class="<%=classValue1%>" colspan="2"><%=reflocto%>&nbsp;</td>   
				   </tr>
                   <tr>	
				   <td class="<%=classValue1%>"><font size=2><b><fmt:message key="Common.source.label" bundle="${common_labels}"/></b></font></td>    
                   <td class="<%=classValue1%>" ><%=reffacfrom%>&nbsp;</td>   
                   <td class="<%=classValue1%>" colspan="2"><%=reffacto%>&nbsp;</td>   
				   </tr>
                </table>
				</td>
				</tr>
				
				
		<%
					}
				i++;
				k++;
		}
		 if((p+1) == i || p == 14)
					{
					%>
					<script>document.forms[0].ctrlChkBox.checked = true</script> 
					<%}
		if(i == 1)
		{
   		%>
        <script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
		<script>document.forms[0].ctrlChkBox.disabled = true</script> 
		<%}
				
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();		 	
	
	

}
			
			
catch(Exception e)
{
	e.printStackTrace();
	out.println("Exception cauight in RecClinicalNotesLinkFutureEventResult.jsp" + e);
}
finally 
{
	
	ConnectionManager.returnConnection(con,request);
}

%>
			
			
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="count" id="count" value="<%=k%>">
			
			
</table>

</form>
</body>
</script>
</html>

