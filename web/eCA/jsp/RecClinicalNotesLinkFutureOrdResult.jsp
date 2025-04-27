<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="EventBean" class="webbeans.eCommon.RecordSet" scope="session"/>
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
  
    String orddate="";
    String ordval="";
	String  practionerid=""; 

 	StringBuffer strsql1 = new StringBuffer(" ");
 	StringBuffer where = new StringBuffer(" ");
    
	//String facility_id = (String)session.getValue("facility_id") ;
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	//out.println("<script>alert('patient_id"+patient_id+"')</script>");
	
    String link=request.getParameter("link")==null?"":request.getParameter("link");
	String val=request.getParameter("val")==null?"":request.getParameter("val");
	String order=request.getParameter("order")==null?"":request.getParameter("order");
	String nature=request.getParameter("nature")==null?"":request.getParameter("nature");

	if(link.equals("Dat"))
	orddate=request.getParameter("val")==null?"":request.getParameter("val");
	else if(link.equals("Ordno"))
    ordval=request.getParameter("val")==null?"":request.getParameter("val");

	String orderid="";
	String orderlineno="";
	if(!ordval.equals(""))
	{
	StringTokenizer ordtokens = new StringTokenizer(ordval,"|");
	orderid= ordtokens.nextToken();
	orderlineno=ordtokens.nextToken();
	}

	
	//out.println("<script>alert('encounter_id"+encounter_id+"')</script>");
	String from 			= 
	request.getParameter("from");
	//out.println("<script>alert('from"+from+"')</script>");
	String to 	= 
	request.getParameter("to");
	//out.println("<script>alert('to"+to+"')</script>");
	String whereclause= request.getParameter("whereclause")==null?"":request.getParameter("whereclause");

	String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");

	
	//String pract_id=(String)session.getValue("ca_practitioner_id");
	//out.println("<script>alert('pract_id"+pract_id+"')</script>");
	
	String rowid="";
	
	String ordcatdesc=""; 
	String ordtypedesc=""; 
	String ordcatlogdesc=""; 
	String ordstartdat="";  
	String ordfreq="";  
	String ordenddat="";  
	String ordprioritydesc= "";
	String priority = "";
	String ordloc= "";
	String ordcomments= "";  
	

		
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

	ArrayList  fields			=	new ArrayList();
	String categ_sec_qry ="";
	String field_ref ="";
//	String col_field ="";
	//String col_val ="";
	//int col_span=0;

	PreparedStatement pstmt=null;
	ResultSet rset=null;




   	try
	{
       con =  ConnectionManager.getConnection(request);
	   practionerid   = (String) session.getValue("ca_practitioner_id"); 

		//shaiju new diag starts
	  
	   categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='FORD' order by ORDER_SEQ_NUM";

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

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='FORD' order by ORDER_SEQ_NUM";

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


	  
	 /*  strsql1.append("Select a.rowid row_id,(SELECT replace(SHORT_DESc,'''','') FROM OR_ORDER_TYPE WHERE ORDER_TYPE_CODE=A.ORDER_TYPE_CODE ) ORDER_TYPE_SHORT_DESC,to_char(b.END_DATE_TIME,'dd/mm/yy HH24:MI') END_DATE_TIME, (SELECT replace(SHORT_DESC,'''','') FROM OR_ORDER_CATEGORY WHERE  ORDER_CATEGORY=A.ORDER_CATEGORY) order_category_short_desc, to_char(b.start_DATE_TIME,'dd/mm/yy HH24:MI') test_date_time,       catalog_synonym_dc item_short_desc, decode(b.priority,'R','Routine','U','Urgent','S','Stat')  priority ,nvl2(b.freq_Code,d.FREQ_DESC || '  for  ' || durn_value || '  ' || DURN_DESC,null) Frequency ,DECODE(A.SOURCE_TYPE,'C','Clinic','N','Nursing Unit','D','Day Care','E','Emergency','R','Referral')||'/',DECODE(SOURCE_TYPE,'N',(select short_Desc from ip_nursing_unit where facility_id = a.ordering_facility_id and nursing_unit_code = a.source_Code),'C',(select short_Desc from OP_clinic where facility_id = a.ordering_facility_id and clinic_code = a.source_Code),'D',(select short_Desc from ip_nursing_unit where facility_id = a.ordering_facility_id and nursing_unit_code = a.source_Code),'E',(select short_Desc from OP_clinic where facility_id = a.ordering_facility_id and clinic_code = a.source_Code),'R',(select SHORT_DESC from am_referral where referral_Code = a.source_code) )   Ordering_Location,(SELECT k.order_comment  FROM or_order_comment  K	where a.order_id = K.order_id and  k.action_seq_num = (select max(action_seq_num) 	from or_ordeR_comment where ordeR_id =a.order_id)) clinical_comments  from or_order  a, or_order_line b , am_frequency d, am_duration_type e  where a.patient_id = ? and b.order_line_status  IN ( select ordeR_status_code  from or_order_status_code where order_status_type between '00' and '20') and a.order_id = b.order_id  and nvl(a.cont_order_ind,'DO') in ('DO','CO','CR','DR')  and b.freq_code = d.freq_Code(+)        and b.DURN_TYPE        = e.DURN_TYPE(+)  and trunc(b.start_Date_Time) > =  trunc(sysdate) ");

	    if ( (whereclause == null || whereclause.equals("")) )
	     {
        
		if (link.equals("Dat"))
		where.append(" AND  b.start_DATE_TIME between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') +.9999 ");

		else if (link.equals("Ordno"))
		where.append(" and b.ORDER_ID=? and b.ORDER_LINE_NUM=?");
		
	   // out.println("<script>alert('orddate:"+orddate+"')</script>");
	    //out.println("<script>alert('orderlineno:"+orderlineno+"')</script>");
	    //out.println("<script>alert('strsql1"')</script>");
	
	    if((nature.equals("S")))
		{
        where.append(" and a.ORD_PRACT_ID = ?");
		}

		if(order.equals("D"))
		where.append(" order by b.start_DATE_TIME desc");
		else
        where.append(" order by b.start_DATE_TIME "); 
	    
	    strsql1.append(where.toString()); 
	    }
	    else
	    {
		strsql1.append(whereclause);

	    } */
		//
		strsql1.append("Select a.rowid row_id,replace(OR_GET_DESC.OR_ORDER_TYPE(A.ORDER_TYPE_CODE,?,'2'),'''','')  ORDER_TYPE_SHORT_DESC, to_char(sm_convert_date(b.END_DATE_TIME,'"+localeName+"'),'dd/mm/yyyy HH24:MI') END_DATE_TIME, OR_GET_DESC.OR_ORDER_CATEGORY(A.ORDER_CATEGORY,?,'2') order_category_short_desc,  to_char(sm_convert_date(b.start_DATE_TIME,'"+localeName+"'),'dd/mm/yyyy HH24:MI') test_date_time,catalog_synonym_dc item_short_desc,  b.priority priority ,nvl2(b.freq_Code,d.FREQ_DESC || '  for  ' || durn_value || '  ' || DURN_DESC,null) Frequency ,A.SOURCE_TYPE||'/',DECODE(SOURCE_TYPE,'N',IP_GET_DESC.IP_NURSING_UNIT(a.ordering_facility_id,a.source_code,?,'1'),'C',OP_GET_DESC.OP_CLINIC(a.ordering_facility_id,a.source_code,?,'1'),'D',IP_GET_DESC.IP_NURSING_UNIT(a.ordering_facility_id,a.source_code,?,'1'),'E',OP_GET_DESC.OP_CLINIC(a.ordering_facility_id,a.source_code,?,'1'),'R',AM_GET_DESC.AM_REFERRAL(a.source_code,?,'1') )   Ordering_Location,(SELECT k.order_comment  FROM or_order_comment  K	where a.order_id = K.order_id and  k.action_seq_num = (select max(action_seq_num) 	from or_ordeR_comment where ordeR_id =a.order_id)) clinical_comments  from or_order  a, or_order_line b , am_frequency d, am_duration_type e  where a.patient_id = ? and b.order_line_status  IN ( select ordeR_status_code  from or_order_status_code where order_status_type between '00' and '20') and a.order_id = b.order_id  and nvl(a.cont_order_ind,'DO') in ('DO','CO','CR','DR')  and b.freq_code = d.freq_Code(+)        and b.DURN_TYPE        = e.DURN_TYPE(+)  and trunc(b.start_Date_Time) > =  trunc(sysdate) ");

	    if ( (whereclause == null || whereclause.equals("")) )
	     {
        
		if (link.equals("Dat"))
		where.append(" AND  b.start_DATE_TIME between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') +.9999 ");

		else if (link.equals("Ordno"))
		where.append(" and b.ORDER_ID=? and b.ORDER_LINE_NUM=?");
		
	   // out.println("<script>alert('orddate:"+orddate+"')</script>");
	    //out.println("<script>alert('orderlineno:"+orderlineno+"')</script>");
	    //out.println("<script>alert('strsql1"')</script>");
	
	    if((nature.equals("S")))
		{
        where.append(" and a.ORD_PRACT_ID = ?");
		}

		if(order.equals("D"))
		where.append(" order by b.start_DATE_TIME desc");
		else
        where.append(" order by b.start_DATE_TIME "); 

 strsql1.append(where.toString()); 
	    }
	    else
	    {
		strsql1.append(whereclause);
		}
		//
		stmt = con.prepareStatement(strsql1.toString());
		int st=0;

		
        //stmt.setString(++st,facility_id);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,patient_id);
		
		if(link.equals("Dat"))
		{
		stmt.setString(++st,orddate);
		stmt.setString(++st,orddate);
		}

        if(link.equals("Ordno"))
		{
		stmt.setString(++st,orderid);
		stmt.setString(++st,orderlineno);

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
out.println("<td width='85%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' >");
out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkFutureOrdResult.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&val="+val+"&link="+link+"&patient_id="+patient_id+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		}
		else
		{
out.println("<td width='100%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' >");
		}

//out.println("<script>alert('start"+start+"')</script>");

  if ( !( (start+14) > maxRecord ) )
		{
	out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkFutureOrdResult.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&val="+val+"&link="+link+"&patient_id="+patient_id+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		}
	%>	
</td>
</tr>
</table>

<table border="1" cellpadding="3" cellspacing="0" width="100%"  name="resultTable" id="resultTable" id="resultTable" align='center'>
<tr>
<td class='columnheader' style="font-size:10"  colspan=4><fmt:message key="Common.selectall.label" bundle="${common_labels}"/><input type='checkbox' name='ctrlChkBox' id='ctrlChkBox' onClick="javascript:perform(this);" ></td>
</tr>
</table>
</div>
<table border="0"  cellpadding="3" cellspacing="0" width="100%" align='center' name="resultTable2" id="resultTable2" id="resultTable2">
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
		int p=0; 
	 while(rs!=null && rs.next() && i<=end)
		{
		 	
		 rowid=rs.getString("row_id")==null?" ":rs.getString("row_id");		 
		 ordcatdesc=rs.getString("order_category_short_desc")==null?" ":rs.getString("order_category_short_desc");
		 ordtypedesc=rs.getString("ORDER_TYPE_SHORT_DESC")==null?" ":rs.getString("ORDER_TYPE_SHORT_DESC");
		// fromtime=rs.getString("FROM_TIME_STR")==null?" ":rs.getString("FROM_TIME_STR");
		// totime=rs.getString("TO_TIME_STR")==null?" ":rs.getString("TO_TIME_STR");
		 ordcatlogdesc=rs.getString("item_short_desc")==null?" ":rs.getString("item_short_desc");
		 ordstartdat=rs.getString("test_date_time")==null?" ":rs.getString("test_date_time");
		 ordenddat=rs.getString("END_DATE_TIME")==null?" ":rs.getString("END_DATE_TIME");
		
		 //ordenddat=rs.getString("resource_name")==null?" ":rs.getString("resource_name");
		 //ordprioritydesc=rs.getString("priority")==null?" ":rs.getString("priority");
		 priority = rs.getString("priority")==null?" ":rs.getString("priority");
		 ordfreq=rs.getString("Frequency")==null?" ":rs.getString("Frequency");
		 ordloc=rs.getString("Ordering_Location")==null?" ":rs.getString("Ordering_Location");
		 ordcomments=rs.getString("clinical_comments")==null?" ":rs.getString("clinical_comments");
		
		 if (priority.equals("R"))
			 ordprioritydesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		 else if (priority.equals("U"))
			 ordprioritydesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
		 else if (priority.equals("S"))
			 ordprioritydesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.statistics.label","common_labels");

			 
		 if ( i % 2 == 0 )
		 classValue = "CAGROUP" ;
		 else
		 classValue = "LABEL" ;
	  	
	    
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
                 
				

					
					
				</tr>
				<%
					if(fields.size()>0)
					{
							
				%>
					<tr>			
					<td class="<%=classValue%>"><input type="checkbox" name="chkbox<%=k%>" id="chkbox<%=k%>" onClick="Reassaign(this);chkunchk(this)" value="<%=k%>"<%=checkstatus%>></td>
					<input type='hidden' name='chk_value<%=k%>' id='chk_value<%=k%>' value="<%=rowid%>">
					<!-- Instead of encoding and sending 'ordcatdesc','ordtypedesc','ordcatlogdesc','ordprioritydesc','ordloc','ordcomments', is passed directly modified by Archana Dhal on 10/27/2010 related to incident no IN024711. -->
					<input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=rowid%>~<%=ordcatdesc%>|<%=ordtypedesc%>|<%=ordcatlogdesc%>|<%=ordstartdat%>|<%=ordenddat%>|<%=ordfreq%>|<%=ordprioritydesc%>|<%=ordloc%>|<%=ordcomments%>'> 

				<%


					if(fields.contains("ORDERCATEGORY"))
					{
					%>
						<td class="<%=classValue%>"  colspan=3>
						<font size=2><b><%=ordcatdesc%></b></font></td>
					<%
					}
					if(fields.contains("ORDERTYPE"))
					{
					%>
						<tr>
							<td class="<%=classValue%>" colspan=4 ><font size=2><b><%=ordtypedesc%></b></font></td>
						</tr>
					<%
					}
					%><tr><%

					if(fields.contains("ORDER"))
					{
					%>
						<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.Test.label" bundle="${common_labels}"/>: </b></font><%=ordcatlogdesc%></td>
					<%
					}
					if(fields.contains("STARTDATE"))
					{
					%>
						<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.date.label" bundle="${common_labels}"/> : </b></font><%=ordstartdat%></td>
					<%
					}

					%></tr><tr><%
					
					if(fields.contains("ENDDATE"))
					{
					%>
						<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.enddate.label" bundle="${common_labels}"/> : </b></font><%=ordenddat%></td>
					<%
					}
					
					if(fields.contains("FREQUENCY"))
					{
					%>
						<td class="<%=classValue%>" colspan=3><%=ordfreq%></td>
					<%
					}
					
					%></tr><tr><%
					if(fields.contains("PRIORITY"))
					{
					%>
						<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/> : </b></font><%=ordprioritydesc%></td>
					<%
					}
					if(fields.contains("LOCATION"))
					{
					%>
						<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/> : </b></font><%=ordloc%></td>
					<%
					}
					%></tr><%
					
					if(fields.contains("CLINCOMMENTS"))
					{
					%>
						<tr>
						<td class="<%=classValue%>"  colspan=4><font size=2><b><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/>  : </b></font><%=ordcomments%></td>
						</tr>
					<%
					}
					
					
					}
					else
					{
				%>	

				<tr>			
					<td class="<%=classValue%>"  colspan=4><input type="checkbox" name="chkbox<%=k%>" id="chkbox<%=k%>" onClick="Reassaign(this);chkunchk(this)" value="<%=k%>"<%=checkstatus%>>
					<font size=2><b><%=ordcatdesc%></b></font></td><input type='hidden' name='chk_value<%=k%>' id='chk_value<%=k%>' value="<%=rowid%>">
					<input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=rowid%>~<%=ordcatdesc%>|<%=ordtypedesc%>|<%=ordcatlogdesc%>|<%=ordstartdat%>|<%=ordenddat%>|<%=ordfreq%>|<%=ordprioritydesc%>|<%=ordloc%>|<%=ordcomments%>'> 
				</tr>
				
				<tr>
					<td class="<%=classValue%>" colspan=4 ><font size=2><b><%=ordtypedesc%></b></font></td>
				</tr>
				<tr>

					<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.Test.label" bundle="${common_labels}"/>: </b></font><%=ordcatlogdesc%></td>
					<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.date.label" bundle="${common_labels}"/> : </b></font><%=ordstartdat%></td>
				</tr>
				
				<tr>
				<td class="<%=classValue%>" colspan=3><%=ordfreq%></td>
				<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.enddate.label" bundle="${common_labels}"/> : </b></font><%=ordenddat%></td>
				</tr>
				
				<tr>
				<td class="<%=classValue%>" colspan=3><font size=2><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/> : </b></font><%=ordprioritydesc%></td>
				<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/> : </b></font><%=ordloc%></td>
				</tr>
				<tr>
				<td class="<%=classValue%>"  colspan=4><font size=2><b><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/>  : </b></font><%=ordcomments%></td>
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
	//out.println("Exception cauight in RecClinicalNotesLinkFutureEventResult.jsp" + e);//COMMON-ICN-0181
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

