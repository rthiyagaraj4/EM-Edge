<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
        request.setCharacterEncoding("UTF-8");
		String atype                      = checkForNull(request.getParameter("atype"));
		String HIGH_RISK_BODY_YN="";
		String colordisplay="";
		String brought_dead_yn="";
		String postmortem_type="";
		String rno						  = checkForNull(request.getParameter("rno"));
		String pid						  = checkForNull(request.getParameter("pid"));
		String pmstatus					  = checkForNull(request.getParameter("pmstatus"));
		String rstatus					  = checkForNull(request.getParameter("rstatus"));
		String bdprtyn="";
		String bdprt="";
		String BODY_PART_OBTAINED_FROM_DESC="";
		String frmdate					  = checkForNull(request.getParameter("frmdate"));
		String todate                     = checkForNull(request.getParameter("todate"));
		String burial_permit_no		= request.getParameter("burial_permit_no")==null?"":request.getParameter("burial_permit_no");
    	String bur_perm_no="";
		String obtained_from			= request.getParameter("obt_frm")==null?"":request.getParameter("obt_frm");
		String function_id			= request.getParameter("function_id")==null?"":request.getParameter("function_id");

		if(atype.equals("")) atype        = "%";
		if(rno.equals("")) rno            = "%";
		if(pid.equals("")) pid            = "%";
		if(pmstatus.equals("")) pmstatus  = "%";
		if(todate.equals("")) todate      = "";
		if(frmdate.equals("")) frmdate    = "01/01/1800 00:00";
		String area_type_desc="";
		String area	                      = checkForNull(request.getParameter("area"));
		String gender	                      = checkForNull(request.getParameter("gender"));
		if(area.equals("")) area          = "%";
		String enc_id		              = "";
		String dis_rno		              = "";
		String dis_pid		              = "";
		String dis_pname	              = "";
		String dis_age		              = "";
		String patient_deceased_age       = "";
		String dis_sex		              = "";
		String dis_pmyn		              = "";
		String dis_pmstat	              = "";
		String by_recd_dt                 = "";
		String dis_acode                  = "";
		String dis_atype                  = "";
		String dis_pmstatdesc             ="";
		String RELEASE_BODY_YN            = "";
		String by_recd_dt_disply		  = "";
		String from = request.getParameter( "from" ) ;
	    String to = request.getParameter( "to" ) ;
        int start = 0 ;
    	int end = 0 ;
	    int l=1;
        if ( from == null )
	    start = 1 ;
	    else
	    start = Integer.parseInt( from ) ;
        if ( to == null )
	    end =6 ;
	    else
	    end = Integer.parseInt( to ) ;
   

 %>
 <html>
    <head>
	    <%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script language='javascript' src='../../eCommon/js/common.js' ></script>
		
		<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eMO/js/MORegDetailsQuery.js' ></script>
		<script language='javascript' src='../../eMO/js/MOAreaAvailabilityQueryCriteria.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
<%
		Connection	    con		= null;
		Statement		st		= null;
		ResultSet		rs		= null;			        
		String facility_id = (String)session.getValue("facility_id");
		String locale = (String)session.getAttribute("LOCALE");
				
 %>
		</head>                         
		<body  onMouseDown='CodeArrest()' onKeyDown="lockKey()">
		<form name = 'MOAreaAvailabilityQueryResult_form'>
 <%
		String classValue	= "";
		int rowIndex		= 1;
		String AREA_DESC    ="";
		String prevcode     ="";
		int ccount          = 0;
		Boolean isReceivedDateTimeAppl;
        try
			{
			con	= ConnectionManager.getConnection(request);
			isReceivedDateTimeAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","RECEIVED_DATE_TIME");// Added by Shanmukh for ML-MMOH-CRF-1036		
			/*st	= con.createStatement();
			rs  =st.executeQuery("select AREA_DESC from mo_area_vw where AREA_CODE ='"+area+"'");
			while(rs!=null && rs.next())
			{
				area = rs.getString(1);
			}
			if (rs!=null) rs.close();
			if (st!=null) st.close();*/
			StringBuffer getcount = new StringBuffer();
			getcount.append("select count(*) from  mo_mortuary_regn_vw where upper(REGISTRATION_NO) like upper('"+rno+"') and upper(NVL(PATIENT_ID,'*')) like upper('"+pid+"') and NVL(AREA_CODE,'*') like  ('"+area+"') AND NVL(area_type,'*') LIKE ('"+atype+"') and upper(POSTMORTEM_STATUS) like upper('"+pmstatus+"') ");

			if(rstatus.equals("R"))
			    getcount.append("and RELEASE_BODY_DATE is not null ");
			else if(rstatus.equals("C"))
				getcount.append("and RELEASE_BODY_DATE is null ");
							 
		if(obtained_from.equals("C"))
        {
        getcount.append(" and  BODY_PART_OBTAINED_FROM is  null");
       }else if(obtained_from.equals("A")||obtained_from.equals("U")||obtained_from.equals("D")||(!obtained_from.equals("C")))
        {
       getcount.append(" and  BODY_PART_OBTAINED_FROM like '"+obtained_from+"%'");
       }
		    getcount.append(" and  SEX LIKE '"+gender+"%'");
			getcount.append(" and  NVL(BURIAL_PERMIT_NO,'*') LIKE '"+burial_permit_no+"%'");
			//getcount.append("and BODY_PART_OBTAINED_FROM is null  ");
			getcount.append("and facility_id ='"+facility_id+"' and to_date(substr(BODY_RECEIVED_DATE,1,10),'dd/mm/yyyy') between to_date('"+frmdate+"','dd/mm/yyyy')");
			if(todate.equals("")) getcount.append("and (sysdate)");
			else getcount.append("and to_date('"+todate+"','dd/mm/yyyy')");
			
			
			st=con.createStatement();
			
			rs = st.executeQuery(getcount.toString());
			while(rs!=null && rs.next())
			{
				ccount = rs.getInt(1);
			}
			if (rs!=null) rs.close();
			if (st!=null) st.close();
		    if(ccount > 0)
			{%>

			 <p>
	<table align='right'>
	<tr>
	<td>
	<%
	if ( !(start <= 1) )
		out.println("<A HREF='../jsp/MORegnDtlsQueryResult.jsp?function_id="+function_id+"&from="+(start-6)+"&to="+(end-6)+"&rno="+URLEncoder.encode(rno)+"&pid="+URLEncoder.encode(pid)+"&pmstatus="+URLEncoder.encode(pmstatus)+"&rstatus="+URLEncoder.encode(rstatus)+"&frmdate="+URLEncoder.encode(frmdate)+"&todate="+URLEncoder.encode(todate)+"&burial_permit_no="+URLEncoder.encode(	burial_permit_no)+"&obt_frm="+URLEncoder.encode(obtained_from)+"&area="+URLEncoder.encode(area)+"&gender="+URLEncoder.encode(gender)+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+6) > ccount ) )
		out.println("<A HREF='../jsp/MORegnDtlsQueryResult.jsp?function_id="+function_id+"&from="+(start+6)+"&to="+(end+6)+"&rno="+URLEncoder.encode(rno)+"&pid="+URLEncoder.encode(pid)+"&pmstatus="+URLEncoder.encode(pmstatus)+"&rstatus="+URLEncoder.encode(rstatus)+"&frmdate="+URLEncoder.encode(frmdate)+"&todate="+URLEncoder.encode(todate)+"&burial_permit_no="+URLEncoder.encode(burial_permit_no)+"&obt_frm="+URLEncoder.encode(obtained_from)+"&area="+URLEncoder.encode(area)+"&gender="+URLEncoder.encode(gender)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

	%>
	</td>
	</tr>
	</table>
	</p>

<br>
<br>
				
		  <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>
		    <th>&nbsp;</th>	<!--Modified by Shanmukh for ML-MMOH-CRF-1036-->		
		    <th><fmt:message key="Common.registrationno.label" bundle="${common_labels}"/></th> 
			<th><fmt:message key="eMO.Body.label" bundle="${mo_labels}"/><br><%if(isReceivedDateTimeAppl){%><fmt:message key="Common.received.label" bundle="${common_labels}"/><%}else{%><fmt:message key="eMO.Receipt.label" bundle="${mo_labels}"/><%}%><br><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></th>
			
		   <th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
			<th>
		   <%if(obtained_from.equals("C"))
             {%>
	         <fmt:message key="eMO.DeceasedName.label" bundle="${mo_labels}"/>
	         <%}else{%>
	         <fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
	         <%}%></th>
			<th><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
			<th nowrap><fmt:message key="eMO.PostmortemStatus.label" bundle="${mo_labels}"/></th>
			<th nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>	
			<th><fmt:message key="eMO.ReleasedYN.label" bundle="${mo_labels}"/></th>	
		    <%if(!obtained_from.equals("C"))
             {%>
	         <th><fmt:message key="eMO.BodyPartType.label" bundle="${mo_labels}"/></th>
	       <%}%>
	
			 <th><fmt:message key="eMO.BurialPermitNo.label" bundle="${mo_labels}"/></th>		 
		 
<%
			StringBuffer operSql = new StringBuffer();
		/*	operSql.append("select BURIAL_PERMIT_NO,BODY_PART_OBTAINED_FROM_DESC,postmortem_type,HIGH_RISK_BODY_YN,BROUGHT_DEAD_YN ,REGISTRATION_NO,BODY_RECEIVED_DATE,BODY_PART_OBTAINED_FROM,PATIENT_ID,ENCOUNTER_ID, PATIENT_NAME,AGE,SEX,PM_YN,POSTMORTEM_STATUS,POSTMORTEM_STATUS_DESC,NVL(AREA_CODE,'*') AREA_CODE,NVL( AREA_TYPE,'Unassigned') AREA_TYPE,area_type_desc, NVL(AREA_DESC,'Unassigned') AREA_DESC,decode(RELEASE_BODY_DATE,null,'No','Yes') released_yn from mo_mortuary_regn_vw");
			operSql.append(" where upper(REGISTRATION_NO) like upper('"+rno+"') ");
			operSql.append(" and upper(NVL(PATIENT_ID,'*')) like upper('"+pid+"') ");
			operSql.append(" and NVL(AREA_CODE,'*') like ('"+area+"')");
			operSql.append(" AND NVL(area_type,'*') LIKE ('"+atype+"')");
			//operSql.append(" and BODY_PART_OBTAINED_FROM is null ");
			operSql.append(" and upper(POSTMORTEM_STATUS)like upper('"+pmstatus+"')");

			if(obtained_from.equals("C"))
        {
        operSql.append(" and  BODY_PART_OBTAINED_FROM is  null");
       }else if(obtained_from.equals("A")||obtained_from.equals("U")||obtained_from.equals("D")||(!obtained_from.equals("C")))
        {
       operSql.append(" and  BODY_PART_OBTAINED_FROM like '"+obtained_from+"%'");
       }
		
			
			operSql.append(" and  SEX LIKE '"+gender+"%'");

			operSql.append(" and  NVL(BURIAL_PERMIT_NO,'*') LIKE '"+burial_permit_no+"%'");
			if(rstatus.equals("R"))
			    operSql.append("and RELEASE_BODY_DATE is not null ");
			else if(rstatus.equals("C"))
				operSql.append("and RELEASE_BODY_DATE is null ");
		
			operSql.append(" and facility_id ='"+facility_id+"'");
			operSql.append(" and to_date(substr(BODY_RECEIVED_DATE,1,10),'dd/mm/yyyy') between to_date('"+frmdate+"','dd/mm/yyyy') and ");
			if(todate.equals("")) operSql.append("(sysdate)");
			else operSql.append(" to_date('"+todate+"','dd/mm/yyyy')");
			operSql.append(" order by area_desc,area_code,  registration_no ");*/


			operSql.append("select BURIAL_PERMIT_NO,BODY_PART_OBTAINED_FROM_DESC,postmortem_type,HIGH_RISK_BODY_YN,BROUGHT_DEAD_YN ,REGISTRATION_NO,BODY_RECEIVED_DATE,BODY_PART_OBTAINED_FROM,PATIENT_ID,ENCOUNTER_ID,decode('"+locale+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) PATIENT_NAME,AGE,deceased_age,SEX,PM_YN,POSTMORTEM_STATUS,POSTMORTEM_STATUS_DESC,NVL(AREA_CODE,'*') AREA_CODE,NVL( AREA_TYPE,'Unassigned') AREA_TYPE,area_type_desc, MO_GET_DESC.MO_AREA('"+facility_id+"',AREA_CODE,'"+locale+"','2') AREA_DESC,decode(RELEASE_BODY_DATE,null,'No','Yes') released_yn from mo_mortuary_regn_vw");
			operSql.append(" where upper(REGISTRATION_NO) like upper('"+rno+"') ");
			operSql.append(" and upper(NVL(PATIENT_ID,'*')) like upper('"+pid+"') ");
			operSql.append(" and NVL(AREA_CODE,'*') like ('"+area+"')");
			operSql.append(" AND NVL(area_type,'*') LIKE ('"+atype+"')");
			//operSql.append(" and BODY_PART_OBTAINED_FROM is null ");
			operSql.append(" and upper(POSTMORTEM_STATUS)like upper('"+pmstatus+"')");

			if(obtained_from.equals("C"))
        {
        operSql.append(" and  BODY_PART_OBTAINED_FROM is  null");
       }else if(obtained_from.equals("A")||obtained_from.equals("U")||obtained_from.equals("D")||(!obtained_from.equals("C")))
        {
       operSql.append(" and  BODY_PART_OBTAINED_FROM like '"+obtained_from+"%'");
       }
		
			
			operSql.append(" and  SEX LIKE '"+gender+"%'");

			operSql.append(" and  NVL(BURIAL_PERMIT_NO,'*') LIKE '"+burial_permit_no+"%'");
			if(rstatus.equals("R"))
			    operSql.append("and RELEASE_BODY_DATE is not null ");
			else if(rstatus.equals("C"))
				operSql.append("and RELEASE_BODY_DATE is null ");
		
			operSql.append(" and facility_id ='"+facility_id+"'");
			operSql.append(" and to_date(substr(BODY_RECEIVED_DATE,1,10),'dd/mm/yyyy') between to_date('"+frmdate+"','dd/mm/yyyy') and ");
			if(todate.equals("")) operSql.append("(sysdate)");
			else operSql.append(" to_date('"+todate+"','dd/mm/yyyy')");
			operSql.append(" order by area_desc,area_code,  registration_no ");


			st=con.createStatement();
			
			rs = st.executeQuery(operSql.toString());
			if ( start != 1 )
	        for( int j=1; j<start; l++,j++ ){
	        rs.next() ;
            }
			
			
			while(rs.next()&&l<=end)
			{
			  classValue =	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			  rowIndex++;
			  enc_id  = rs.getString("ENCOUNTER_ID");
			  if(enc_id==null) enc_id ="&nbsp;";
			  dis_rno  = rs.getString("REGISTRATION_NO");
			  if(dis_rno==null) dis_rno ="";
			  by_recd_dt  = rs.getString("BODY_RECEIVED_DATE");
			  if(by_recd_dt==null) by_recd_dt ="";
			 brought_dead_yn=rs.getString("brought_dead_yn"); 
			  if(brought_dead_yn==null) brought_dead_yn ="";
			  bdprt=rs.getString("BODY_PART_OBTAINED_FROM"); 
			 if(bdprt==null)bdprtyn ="N";else bdprtyn="Y";

			 if(bdprt==null)bdprt="";

			 if(bdprtyn==null)bdprtyn ="";
			  dis_pid = rs.getString("PATIENT_ID");
			  if(dis_pid==null) dis_pid ="";
			  dis_pname = rs.getString("PATIENT_NAME");
			  if(dis_pname==null) dis_pname ="";
			  dis_age = rs.getString("AGE");
			   if(dis_age==null) dis_age ="";		  
			  patient_deceased_age = rs.getString("deceased_age");
			  if(patient_deceased_age==null) patient_deceased_age="";			 
			  dis_sex = rs.getString("SEX");
			  if(dis_sex==null) dis_sex ="";
			  dis_pmyn = rs.getString("PM_YN");
			   if(dis_pmyn==null) dis_pmyn ="";
			  bur_perm_no=rs.getString("BURIAL_PERMIT_NO");
              if(bur_perm_no==null) bur_perm_no ="";
			  HIGH_RISK_BODY_YN=rs.getString("HIGH_RISK_BODY_YN");
             if(HIGH_RISK_BODY_YN==null) HIGH_RISK_BODY_YN ="";
			  dis_pmstat = rs.getString("POSTMORTEM_STATUS");
			  if(dis_pmstat==null) dis_pmstat ="";
			  dis_pmstatdesc = rs.getString("POSTMORTEM_STATUS_DESC");
			  if(dis_pmstatdesc==null) dis_pmstatdesc ="";
			  
			  dis_acode = rs.getString("AREA_CODE");
			  if(dis_acode==null) dis_acode ="";
			  dis_atype = rs.getString("AREA_TYPE");
			  area_type_desc = rs.getString("area_type_desc")==null?"":rs.getString("area_type_desc");
			 postmortem_type=rs.getString("postmortem_type")==null?"":rs.getString("postmortem_type"); BODY_PART_OBTAINED_FROM_DESC=rs.getString("BODY_PART_OBTAINED_FROM_DESC")==null?"":rs.getString("BODY_PART_OBTAINED_FROM_DESC");
			  RELEASE_BODY_YN = rs.getString("released_yn");
			  AREA_DESC = rs.getString("AREA_DESC");
			  if(dis_atype==null) dis_atype ="";
			  if(RELEASE_BODY_YN==null) RELEASE_BODY_YN ="";
			  if(AREA_DESC==null) AREA_DESC ="";


				by_recd_dt_disply=DateUtils.convertDate(by_recd_dt,"DMYHM","en",locale);
			  
						/*****Gender Decode****/
						if(dis_sex.equals("Male"))
						{
							dis_sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						}else if(dis_sex.equals("Female"))
						{
							dis_sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						}else if(dis_sex.equals("Unknown"))
						{
							dis_sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						}

						/*****Y/N Decode****/
						if(RELEASE_BODY_YN.equals("No"))
						{
							RELEASE_BODY_YN=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
						}else if(RELEASE_BODY_YN.equals("Yes"))
						{
							RELEASE_BODY_YN=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
						}
						
						/*****AREA_DESC Decode****/
						if(AREA_DESC.equals(""))
						{
							AREA_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");
						}

						/*****POSTMORTEM_STATUS_DESC Decode****/
						if(dis_pmstat.equals("N"))
							dis_pmstatdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
						else if(dis_pmstat.equals("A"))
							dis_pmstatdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.NotRequested.label","mo_labels");
						else if(dis_pmstat.equals("R"))
							dis_pmstatdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requested.label","common_labels");
						else if(dis_pmstat.equals("S"))
							dis_pmstatdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
						else if(dis_pmstat.equals("E"))
							dis_pmstatdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
						else if(dis_pmstat.equals("C"))
							dis_pmstatdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");

						/*****BODY_PART_OBTAINED_FROM_DESC Decode****/
						if(bdprt.equals("A"))
						BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.AmputatedBodyPart.label","mo_labels");
						else if(bdprt.equals("D"))
							BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.DeadFetus.label","mo_labels");
						else if(bdprt.equals("U"))
							BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.UnidentifiedBodyPart.label","mo_labels");
						else 
							BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");



						/*****area_type_desc Decode****/
						if(dis_atype.equals("S"))
						{
						area_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.StorageArea.label","mo_labels");
						}else if(dis_atype.equals("R"))
						{
						area_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReleaseArea.label","mo_labels");
						}else if(dis_atype.equals("P"))
						{
						area_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PostmortemArea.label","mo_labels");
						}else if(dis_atype.equals("O"))
						{
						area_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
						}

		      if(prevcode.equals(AREA_DESC)) prevcode = "";
			  else prevcode = AREA_DESC;







			  if(!(prevcode.equals("")))
		{ 
			%>
	<tr><th colspan=13 align=left><B><%=prevcode%>/<%=dis_acode%>/<%=area_type_desc%></B></th></tr>
	 <% }prevcode =AREA_DESC; %>
	
    
	<%if(HIGH_RISK_BODY_YN.equals("Y"))
	{
	colordisplay="style='background-color:orange'";
	}else 
		{
		colordisplay="";
	}%>
	
	<tr>
	<!-- <td class='<%=classValue%>'>
	<a name='desc1' href="javascript:showAllowedOperations('<%=dis_acode%>','<%=dis_atype%>')" > <font size=1><%=dis_acode%></a></td> -->
	<%	if(postmortem_type.equals("M"))
		{
	%> 
	<td style='background-color:maroon;color:white' width='3%'>&nbsp;P</td>
	<%}else if(postmortem_type.equals("C")){%>
	<td style='background-color:yellow;color:maroon' width='3%'>&nbsp;P</td>
	<%}else{%>
	<td>&nbsp;</Td>
	<%}%>
		
		
		<td class='<%=classValue%>'  <%=colordisplay%>> <font size=1><%=dis_rno%></td>
		<td class='<%=classValue%>'  <%=colordisplay%> > <font size=1><%=by_recd_dt_disply%></td>
		<td class='<%=classValue%>' align='right'  <%=colordisplay%>> <font size=1><%=dis_pid%></td>
		
		<%if(brought_dead_yn.equals("Y")){%>
		<td  style='background-color:black;'>
		<a name='desc1' style="color:white" href='javascript:showAllowedOperations1("<%=java.net.URLEncoder.encode(dis_pname)%>","<%=dis_pid%>","<%=dis_rno%>","<%=bdprtyn%>")' > <font size=1><%=dis_pname%></a></td>
		<%}else{%>
		<td class='<%=classValue%>' <%=colordisplay%>>
		<a name='desc1' href='javascript:showAllowedOperations1("<%=java.net.URLEncoder.encode(dis_pname)%>","<%=dis_pid%>","<%=dis_rno%>","<%=bdprtyn%>")' > <font size=1><%=dis_pname%></a></td>
			
		<%}%>
		<td class='<%=classValue%>'  <%=colordisplay%> align='left'> <font size=1><%=patient_deceased_age%></td>
		<td class='<%=classValue%>'   <%=colordisplay%> align='left'> <font size=1><%=dis_sex%></td>
		<td class='<%=classValue%>'   <%=colordisplay%> align='left'> <font size=1><%=dis_pmstatdesc%> </td>
		<td class='<%=classValue%>'   <%=colordisplay%> align='left'> <font size=1><%=enc_id%></td>
		<td class='<%=classValue%>'  <%=colordisplay%> align='left'> <font size=1><%=RELEASE_BODY_YN%></td>
		<%if(!obtained_from.equals("C"))
        {%>
	   <td class='<%=classValue%>' <%=colordisplay%> ><font size=1> <%=BODY_PART_OBTAINED_FROM_DESC%></td>
	   <%}%>
		<!--Style Added by Santhosh for ML-MMOH-CRF-1947>-->
		<td class='<%=classValue%>' align='left' <%=colordisplay%> style='word-wrap:break-word;width:300px;'> <font size=1><%=bur_perm_no%></td>
			
			
		
    </tr>
 <%
	l++;
	}
  %>
   </table>
        <br>
			<%}
	    else
				{
		          out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}
				if (rs != null) rs.close();
                if (st != null) st.close();

				}
    catch(Exception e) {out.println(e.toString());
	e.printStackTrace();}
    finally
    {
       	ConnectionManager.returnConnection(con,request);
		%><script>
			if(parent.frames[1].document.forms[0] != null)
			parent.frames[1].document.forms[0].search.disabled=false
		  </script>
		<%}
		
	%>
	  <input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>

       </form>
    </body>
  </html>
<%!
public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
%>

