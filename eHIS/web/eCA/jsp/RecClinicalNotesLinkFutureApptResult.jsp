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
  
    String apptdate="";
    String apptrefno="";

 	StringBuffer strsql1 = new StringBuffer(" ");
 	StringBuffer where = new StringBuffer(" ");
    
	String facility_id = (String) session.getValue("facility_id") ;
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	//out.println("<script>alert('patient_id"+patient_id+"')</script>");
	
    String link=request.getParameter("link")==null?"":request.getParameter("link");
	String val=request.getParameter("val")==null?"":request.getParameter("val");
	String order=request.getParameter("order")==null?"":request.getParameter("order");
	String nature=request.getParameter("nature")==null?"":request.getParameter("nature");
	if(link.equals("Dat"))
    apptdate=request.getParameter("val")==null?"":request.getParameter("val");
	else if(link.equals("Refno"))
    apptrefno=request.getParameter("val")==null?"":request.getParameter("val");

	
	String from 			= 
	request.getParameter("from");
	//out.println("<script>alert('from"+from+"')</script>");
	String to 	= 
	request.getParameter("to");
	//out.println("<script>alert('to"+to+"')</script>");
	String whereclause= request.getParameter("whereclause")==null?"":request.getParameter("whereclause");

	//String pract_id=(String)session.getValue("ca_practitioner_id");
	//out.println("<script>alert('pract_id"+pract_id+"')</script>");
	
	String rowid="";
	String apptreferno=""; 
	String apptdat="";  
	String fromtime="";  
	String totime= "";   
	String locdesc= "";  
	String visitdesc= "";
	String resname= "";  
	String reason= "";   
	String remarks= "";  
	
	String practionerid= "";  


	String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	ArrayList  fields			=	new ArrayList();
	String categ_sec_qry ="";
	String field_ref ="";
//	String col_field ="";
	//String col_val ="";
//	int col_span=0;

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
	  
	   categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='APPT' order by ORDER_SEQ_NUM";

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

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY='APPT' order by ORDER_SEQ_NUM";

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
	  
	  
	  /* strsql1.append("select rowid row_id,APPT_REF_NO , TO_CHAR(APPT_DATE,'DD/MM/YYYY') APPT_DATE_STR , TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') FROM_TIME_STR , TO_CHAR(APPT_SLAB_TO_TIME ,'HH24:MI')  TO_TIME_STR , replace(CLINIC_SHORT_DESC,'''','') LOCATION_DESC , replace(VISIT_TYPE_SHORT_DESC,'''','') VISIT_TYPE_SHORT_DESC  , nvl2(    PRACTITIONER_SHORT_NAME,DECODE(RESOURCE_CLASS,'P','Practitioner','R','Room')||'/',null)||Replace(PRACTITIONER_SHORT_NAME,'''','') resource_name  ,replace(CONTACT_REASON,'''','') CONTACT_REASON ,replace(APPT_REMARKS,'''','') APPT_REMARKS from oa_appt_vw where  FACILITY_ID= ? AND PATIENT_ID=?");

	    if ( (whereclause == null || whereclause.equals("")) )
	     {
        
		if (link.equals("Dat"))
		where.append(" AND  APPT_DATE between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') +.9999 ");

		if (link.equals("Refno"))
		where.append(" and APPT_REF_NO=?");
		
	    //out.println("<script>alert('ord_status"+ord_status+"')</script>");
	    //out.println("<script>alert('strsql1"')</script>");
	    if((nature.equals("S")))
		{
        where.append(" and PRACTITIONER_ID = ?");
		}

		if(order.equals("D"))
		where.append(" ORDER BY APPT_DATE, APPT_SLAB_FROM_TIME desc ");
		else
        where.append(" ORDER BY APPT_DATE, APPT_SLAB_FROM_TIME "); 
	
	   
	    strsql1.append(where.toString()); */
//
		//strsql1.append("select rowid row_id,APPT_REF_NO , TO_CHAR(sm_convert_date(APPT_DATE,'"+localeName+"'),'DD/MM/YYYY') APPT_DATE_STR ,TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') FROM_TIME_STR , TO_CHAR(APPT_SLAB_TO_TIME ,'HH24:MI')  TO_TIME_STR , replace((CASE WHEN a.clinic_code IS NOT NULL THEN OP_GET_DESC.OP_CLINIC(a.facility_id,a.clinic_code,?,'1') END),'''','') LOCATION_DESC , replace((CASE WHEN a.appt_type_code IS NOT NULL THEN OP_GET_DESC.OP_VISIT_TYPE(A.FACILITY_ID,A.APPT_TYPE_CODE,?,'1') END ),'''','') VISIT_TYPE_SHORT_DESC, nvl2((CASE WHEN (a.resource_class = 'P' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'2')  WHEN (a.resource_class = 'R' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2') WHEN (( a.resource_class = 'E' OR a.resource_class = 'O' ) AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2') END ) , RESOURCE_CLASS ||'/',null)||Replace((CASE WHEN (a.resource_class = 'P' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'2') WHEN (a.resource_class = 'R' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2') WHEN (( a.resource_class = 'E' OR a.resource_class = 'O' ) AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2')END) ,'''','') resource_name  ,replace(CONTACT_REASON,'''','') CONTACT_REASON ,replace(APPT_REMARKS,'''','') APPT_REMARKS from oa_appt_vw A where  FACILITY_ID= ? AND PATIENT_ID=?");//common-icn-0180
	    strsql1.append("select rowid row_id,APPT_REF_NO , TO_CHAR(sm_convert_date(APPT_DATE,?),'DD/MM/YYYY') APPT_DATE_STR ,TO_CHAR(APPT_SLAB_FROM_TIME,'HH24:MI') FROM_TIME_STR , TO_CHAR(APPT_SLAB_TO_TIME ,'HH24:MI')  TO_TIME_STR , replace((CASE WHEN a.clinic_code IS NOT NULL THEN OP_GET_DESC.OP_CLINIC(a.facility_id,a.clinic_code,?,'1') END),'''','') LOCATION_DESC , replace((CASE WHEN a.appt_type_code IS NOT NULL THEN OP_GET_DESC.OP_VISIT_TYPE(A.FACILITY_ID,A.APPT_TYPE_CODE,?,'1') END ),'''','') VISIT_TYPE_SHORT_DESC, nvl2((CASE WHEN (a.resource_class = 'P' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'2')  WHEN (a.resource_class = 'R' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2') WHEN (( a.resource_class = 'E' OR a.resource_class = 'O' ) AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2') END ) , RESOURCE_CLASS ||'/',null)||Replace((CASE WHEN (a.resource_class = 'P' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_PRACTITIONER(A.PRACTITIONER_ID,?,'2') WHEN (a.resource_class = 'R' AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_FACILITY_ROOM(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2') WHEN (( a.resource_class = 'E' OR a.resource_class = 'O' ) AND a.practitioner_id IS NOT NULL) THEN AM_GET_DESC.AM_RESOURCE(A.FACILITY_ID,A.PRACTITIONER_ID,?,'2')END) ,'''','') resource_name  ,replace(CONTACT_REASON,'''','') CONTACT_REASON ,replace(APPT_REMARKS,'''','') APPT_REMARKS from oa_appt_vw A where  FACILITY_ID= ? AND PATIENT_ID=?");//common-icn-0180

	    if ( (whereclause == null || whereclause.equals("")) )
	     {
        
		if (link.equals("Dat"))
		where.append(" AND  APPT_DATE between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') +.9999 ");

		if (link.equals("Refno"))
		where.append(" and APPT_REF_NO=?");
		
	    //out.println("<script>alert('ord_status"+ord_status+"')</script>");
	    //out.println("<script>alert('strsql1"')</script>");
	    if((nature.equals("S")))
		{
        where.append(" and PRACTITIONER_ID = ?");
		}

		if(order.equals("D"))
		where.append(" ORDER BY APPT_DATE, APPT_SLAB_FROM_TIME desc ");
		else
        where.append(" ORDER BY APPT_DATE, APPT_SLAB_FROM_TIME "); 
	
	   
	    strsql1.append(where.toString());	
//


	    }
	    else
	    {
		strsql1.append(whereclause);

	    }
		stmt = con.prepareStatement(strsql1.toString());
		int st=0;

		stmt.setString(++st,localeName);//common-icn-0180
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
        stmt.setString(++st,facility_id);
		stmt.setString(++st,patient_id);
		
		if(link.equals("Dat"))
		{
		stmt.setString(++st,apptdate);
		stmt.setString(++st,apptdate);
		}
        else if(link.equals("Refno"))
        stmt.setString(++st,apptrefno);

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
out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkFutureApptResult.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&val="+val+"&link="+link+"&patient_id="+patient_id+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		}
		else
		{
out.println("<td width='100%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' >");
		}

//out.println("<script>alert('start"+start+"')</script>");

  if ( !( (start+14) > maxRecord ) )
		{
	out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkFutureApptResult.jsp?sec_hdg_code="+sec_hdg_code+"&result_linked_rec_type="+result_linked_rec_type+"&val="+val+"&link="+link+"&patient_id="+patient_id+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
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
<table class="grid" width="100%"  name="resultTable2" id="resultTable2" id="resultTable2" align='center'>
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
		
		 rowid=rs.getString("row_id")==null?" ":rs.getString("row_id");		 
		 apptreferno=rs.getString("APPT_REF_NO")==null?" ":rs.getString("APPT_REF_NO");
		 apptdat=rs.getString("APPT_DATE_STR")==null?" ":rs.getString("APPT_DATE_STR");
		 fromtime=rs.getString("FROM_TIME_STR")==null?" ":rs.getString("FROM_TIME_STR");
		 totime=rs.getString("TO_TIME_STR")==null?" ":rs.getString("TO_TIME_STR");
		 locdesc=rs.getString("LOCATION_DESC")==null?" ":rs.getString("LOCATION_DESC");
		 visitdesc=rs.getString("VISIT_TYPE_SHORT_DESC")==null?" ":rs.getString("VISIT_TYPE_SHORT_DESC");
		 resname=rs.getString("resource_name")==null?" ":rs.getString("resource_name");
		 reason=rs.getString("CONTACT_REASON")==null?" ":rs.getString("CONTACT_REASON");
		 remarks=rs.getString("APPT_REMARKS")==null?" ":rs.getString("APPT_REMARKS");
		
		 	 
		 if ( i % 2 == 0 ){
		 classValue = "CAGROUP" ;
		 classValue1 = "gridData" ;
		 }else{
		 classValue = "CAGROUP" ;
		 classValue1 = "gridData" ;
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
					<tr>				
						<td class="<%=classValue%>"><input type="checkbox" name="chkbox<%=k%>" id="chkbox<%=k%>" onClick="Reassaign(this);chkunchk(this)" value="<%=k%>"<%=checkstatus%>>
						<input type='hidden' name='chk_value<%=k%>' id='chk_value<%=k%>' value="<%=rowid%>"></td>
						<input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=rowid%>~<%=apptreferno%>|<%=apptdat%>|<%=fromtime%>|<%=totime%>|<%=locdesc%>|<%=visitdesc%>|<%=resname%>|<%=reason%>|<%=remarks%>'>
					<%
						if(fields.contains("APPTREFNO"))
						{
						%>
							<td class="<%=classValue%>"  >
							<font size=2><b>Appointment Ref.no : </b></font><%=apptreferno%></td>
						<%
						}
						if(fields.contains("DATE"))
						{
						%>
							<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.date.label" bundle="${common_labels}"/> : </b></font><%=apptdat%></td>
						<%
						}
						if(fields.contains("TIME"))
						{
						%>
							<td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.time.label" bundle="${common_labels}"/> : </b></font><%=fromtime%><font size=2><b> <fmt:message key="Common.to.label" bundle="${common_labels}"/> </b></font><%=totime%></td>
						<%
						}
						%></tr><tr>
						<%
						if(fields.contains("LOCATION"))
						{
						%>
							<td class="<%=classValue1%>"  ><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/> : </b></font><%=locdesc%></td>
						<%
						}
						if(fields.contains("VISITTYPE"))
						{
						%>
							<td class="<%=classValue1%>" colspan=3><font size=2><b><fmt:message key="Common.visittype.label" bundle="${common_labels}"/> : </b></font><%=visitdesc%></td>
						<%
						}
						%></tr>
						<%
						if(fields.contains("RESOURCE"))
						{
						%>
							<tr>
							<td class="<%=classValue1%>"  colspan=4><font size=2><b><fmt:message key="Common.resource.label" bundle="${common_labels}"/> : </b></font><%=resname%></td>
							</tr>
						<%
						}
						if(fields.contains("CONTACTREASON"))
						{
						%>
							<tr>
							<td class="<%=classValue1%>"  colspan=4><font size=2><b><fmt:message key="Common.ContactReason.label" bundle="${common_labels}"/> : </b></font><%=reason%></td>
							</tr>
						<%
						}
						if(fields.contains("REMARKS"))
						{
						%>
							<tr>
							<td class="<%=classValue1%>"  colspan=4><font size=2><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> : </b></font><%=remarks%></td>
							</tr>
						<%
						}
										
					}
					else
					{

				%>
				
				
				
				<tr>			
					<td class="<%=classValue%>"><input type="checkbox" name="chkbox<%=k%>" id="chkbox<%=k%>" onClick="Reassaign(this);chkunchk(this)" value="<%=k%>"<%=checkstatus%>><font size=2><b>Appointment Ref.no : </b></font><%=apptreferno%><input type='hidden' name='chk_value<%=k%>' id='chk_value<%=k%>' value="<%=rowid%>"></td>
					<input type='hidden' name='ret_value<%=k%>' id='ret_value<%=k%>' value='<%=rowid%>~<%=apptreferno%>|<%=apptdat%>|<%=fromtime%>|<%=totime%>|<%=locdesc%>|<%=visitdesc%>|<%=resname%>|<%=reason%>|<%=remarks%>'> 
					<td class="<%=classValue%>" ><font size=2><b><fmt:message key="Common.date.label" bundle="${common_labels}"/> : </b></font><%=apptdat%></td>
					<td class="<%=classValue%>"><font size=2><b><fmt:message key="Common.time.label" bundle="${common_labels}"/> : </b></font><%=fromtime%><font size=2><b> <fmt:message key="Common.to.label" bundle="${common_labels}"/> </b></font><%=totime%></td>
					<td></td>
				</tr>
				 <tr>
				<td class="<%=classValue1%>"  ><font size=2><b><fmt:message key="Common.Location.label" bundle="${common_labels}"/> : </b></font><%=locdesc%></td>
				<td class="<%=classValue1%>" colspan=3><font size=2><b><fmt:message key="Common.visittype.label" bundle="${common_labels}"/> : </b></font><%=visitdesc%></td>
				</tr>
				<tr>
				<td class="<%=classValue1%>"  colspan=4><font size=2><b><fmt:message key="Common.resource.label" bundle="${common_labels}"/> : </b></font><%=resname%></td>
				</tr>
				<tr>
				<td class="<%=classValue1%>"  colspan=4><font size=2><b><fmt:message key="Common.ContactReason.label" bundle="${common_labels}"/> : </b></font><%=reason%></td>
				</tr>
				<tr>
				<td class="<%=classValue1%>"  colspan=4><font size=2><b><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> : </b></font><%=remarks%></td>
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

