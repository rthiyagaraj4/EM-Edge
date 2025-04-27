<!DOCTYPE html>
<%@ page  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*" 
contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
     	request.setCharacterEncoding("UTF-8");
	    String from									= request.getParameter( "from" ) ;
	    String to									= request.getParameter( "to" ) ;
		int start									= 0 ;
	    int end										= 0 ;
	    int i										= 1 ;
		int cnt										= 0;
		int endOfRes = 1;

    	if ( from == null )
			start = 1 ;
	    else
			start = Integer.parseInt( from ) ;
    	if ( to == null )
	  		end = 8 ;
	    else
			end = Integer.parseInt( to ) ;
		
		String patient_name							="";
		String age									="";
		String sex									="";
		String location								="";
		String treatment_area_desc					="";
		String assign_room_num						="";
		String assign_bed_num						="";
		String deceased_date						="";
		String body_release_date_time				="";
	    String high_risk_yn							="";
		String timeinterval							="";
		String brought_dead_yn						="";
		String patient_det							="";
		String citizenyn							="";
		String religion								="";
		String colordisplay							="";
		String encounter_id                         ="";
		String patient_id							= checkForNull(request.getParameter("patient_id"));
	    //StringBuffer getcount						= new StringBuffer();
		StringBuffer getInt							= new StringBuffer();
		String clinic_code							= checkForNull(request.getParameter("locn"));
		String clinic_code1							= checkForNull(request.getParameter("clinic_code1"));
		String dec_date_time						= checkForNull(request.getParameter("dec_date_time"));
		
		String dec_date_time1 			=request.getParameter("dec_date_time1")==null?"":request.getParameter("dec_date_time1");
		
    
		if(patient_id.equals("")) patient_id        = "%";
		if(clinic_code.equals("")) clinic_code      = "%";
		if(clinic_code1.equals("")) clinic_code1	= "%";
		if(dec_date_time1.equals("")) dec_date_time1= "";
		if(dec_date_time.equals("")) dec_date_time  = "01/01/1800 00:00";
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
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language='javascript' src='../../eMO/js/MOBurialPermit.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		
		
<%
		Connection	    con							= null;
		Statement		st							= null;
		ResultSet		rs							= null;			        
		String facility_id							= (String)session.getValue("facility_id");
		try
		{
		con	= ConnectionManager.getConnection(request);
		getInt.append("select QUEUE_REFRESH_INTERVAL from mo_parameter where facility_id='"+facility_id+"'"); 
		st=con.createStatement();
	    rs = st.executeQuery(getInt.toString());
		while(rs.next())
		{
			timeinterval=rs.getString("QUEUE_REFRESH_INTERVAL")==null?"0":rs.getString("QUEUE_REFRESH_INTERVAL");
		}
        if(rs!=null)rs.close();
		if(st!=null)st.close();
 
 %>
		
		<script>
         var timeinterval='<%=timeinterval%>'*1000*60; 	
		 self.setInterval('submitPage()',timeinterval)
        </script>
	</head>                         
		
		<body  onMouseDown='CodeArrest()' onKeyDown="lockKey()">
		
 	 
			
		     
		<%
			String classValue	= "";
			int rowIndex		= 1;
			

			StringBuffer operSql = new StringBuffer();
            operSql.append("select PATIENT_ID,encounter_id,  HIGH_RISK_YN, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) PATIENT_NAME, AGE, SEX,  DECODE(assign_care_locn_type,'N',IP_GET_DESC.IP_NURSING_UNIT(facility_id,assign_care_locn_code,'"+localeName+"',1), OP_GET_DESC.OP_CLINIC(facility_id,assign_care_locn_code,'"+localeName+"',1)) LOCATION,CITIZEN_YN,  MP_GET_DESC.mp_religion(relgn_code,'"+localeName+"','1') RELGN_DESC, AE_GET_DESC.ae_tmt_area_for_clinic( facility_id,assign_care_locn_code,treatment_area_code,'"+localeName+"','1') TREATMENT_AREA_DESC, ASSIGN_ROOM_NUM, ASSIGN_BED_NUM, DECEASED_DATE, BODY_RELEASE_DATE_TIME,BROUGHT_DEAD_YN from mo_encounter_dtls_vw where REGN_ALLOWED_IN_MO_YN='Y' and PATIENT_ID not in (select NVL(patient_id,'*') from mo_mortuary_regn where NVL(BODY_PART_OBTAINED_FROM,'*') NOT IN ('A','D')) and PATIENT_ID not in (select NVL(patient_id,'*') from mo_burial_permit) and upper(PATIENT_ID) like upper('"+patient_id+"')  and NVL(ASSIGN_CARE_LOCN_TYPE,'*') LIKE ('"+clinic_code+"') AND NVL(ASSIGN_CARE_LOCN_CODE,'*') LIKE ('"+clinic_code1+"')");
			
			operSql.append(" and facility_id ='"+facility_id+"' and to_date(substr(DECEASED_DATE,1,10),'dd/mm/yyyy') between to_date('"+dec_date_time+"','dd/mm/yyyy')");
			if(dec_date_time1.equals("")) operSql.append("and (sysdate)");
			else operSql.append("and to_date('"+dec_date_time1+"','dd/mm/yyyy') and PM_YN='N'and mlc_yn='N'");
			operSql.append(" order by to_date(BODY_RELEASE_DATE_TIME,'dd/mm/yyyy hh24:mi') desc ");
			
			st=con.createStatement();
			
			rs = st.executeQuery(operSql.toString());
			
			 if ( start != 1 )
	         for( int j=1; j<start; i++,j++ ){
	           rs.next() ;
             }
			 while( i<=end && rs.next() )
			 {
				 if (cnt == 0)
					{
						
				
			%>
				<form name = 'MOAreaAvailabilityQueryResult_form'>		 		 
				<p>
						<table align='right'>
							 <tr>
									<td>
									<%
										if ( !(start <= 1) )
											out.println("<A HREF='../jsp/MOBurialPermitQueryResult.jsp?from="+(start-8)+"&to="+(end-8)+"&patient_id="+URLEncoder.encode(patient_id)+"&locn="+URLEncoder.encode(clinic_code)+"&clinic_code1="+URLEncoder.encode(clinic_code1)+"&dec_date_time="+URLEncoder.encode(dec_date_time)+"&dec_date_time1="+URLEncoder.encode(dec_date_time1)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

										if ( endOfRes == 1 )
											out.println("<A id='nextval' HREF='../jsp/MOBurialPermitQueryResult.jsp?from="+(start+8)+"&to="+(end+8)+"&patient_id="+URLEncoder.encode(patient_id)+"&locn="+URLEncoder.encode(clinic_code)+"&clinic_code1="+URLEncoder.encode(clinic_code1)+"&dec_date_time="+URLEncoder.encode(dec_date_time)+"&dec_date_time1="+URLEncoder.encode(dec_date_time1)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
									%>
									</td>
							 </tr>
						</table>
					</p>

					<BR><BR>	
					 <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>
							<td class='columnheader'>&nbsp;</td>	
							<td class='columnheader'><fmt:message key="eMO.DeceasedPatientDetls.label" bundle="${mo_labels}"/></td> 
							<td class='columnheader'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
							<td class='columnheader'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
							<td class='columnheader' nowrap><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></td>
							<td class='columnheader' nowrap><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>	
							<td class='columnheader'><fmt:message key="Common.deceaseddatetime.label" bundle="${common_labels}"/></td>	
							<td class='columnheader'><fmt:message key="Common.BodyReleaseDateTime.label" bundle="${common_labels}"/></td>	

				<%
					}

				classValue =	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
				rowIndex++;
				patient_id          =rs.getString("patient_id")==null?"":rs.getString("patient_id"); 
				encounter_id        =rs.getString("encounter_id")==null?"":rs.getString("encounter_id"); 
				patient_name        =rs.getString("patient_name")==null?"":rs.getString("patient_name"); 
				age                 =rs.getString("age")==null?"":rs.getString("age");      
				sex                 =rs.getString("sex")==null?"":rs.getString("sex");      
				citizenyn           =rs.getString("CITIZEN_YN")==null?"":rs.getString("CITIZEN_YN");  
				high_risk_yn           =rs.getString("HIGH_RISK_YN")==null?"":rs.getString("HIGH_RISK_YN"); 
				religion            =rs.getString("RELGN_DESC")==null?"":rs.getString("RELGN_DESC");
				if(sex!=null && !sex.equals("") && sex.equals("Male"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if(sex!=null && !sex.equals("") && sex.equals("Female"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else if(sex!=null && !sex.equals("") && sex.equals("Unknown"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				if(citizenyn.equals("Y")) 
				{
					citizenyn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.citizen.label","common_labels");
					
			    }else
				{ 
				     citizenyn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.noncitizen.label","common_labels");
				}
				location			=rs.getString("location")==null?"&nbsp":rs.getString("location");   
				patient_det= patient_id+","+patient_name+","+age+","+sex+","+religion+","+citizenyn;
				treatment_area_desc	=rs.getString("treatment_area_desc")==null?"&nbsp;":rs.getString("treatment_area_desc");   
				assign_room_num     =rs.getString("assign_room_num")==null?"&nbsp":rs.getString("assign_room_num");      
				assign_bed_num		=rs.getString("assign_bed_num")==null?"&nbsp":rs.getString("assign_bed_num");   
				deceased_date		=rs.getString("deceased_date")==null?"&nbsp":rs.getString("deceased_date");  
				body_release_date_time =rs.getString("body_release_date_time")==null?"&nbsp":rs.getString("body_release_date_time"); 
				brought_dead_yn     =rs.getString("brought_dead_yn")==null?"&nbsp":rs.getString("brought_dead_yn");     

%>			  
    
	
	<tr>
	 <td> <a name='desc1' href="javascript:viewPatientDetails('<%=patient_id%>')"><font size=1>+</a></td>   
	<%
	if(high_risk_yn.equals("Y"))
	{
		colordisplay="style='background-color:Orange;'";
	}else
	{
		colordisplay="";
	}
     
	
     if(brought_dead_yn.equals("Y"))
	{%>
	<td  style='background-color:black;'><font size=1><a name='desc1' style='color:white' href="javascript:showAllowOper('<%=patient_id%>')"  ><%=patient_det%></a>></td>
   <%}else{ 
   %>
	<td class='<%=classValue%>' <%=colordisplay%>><font size=1><a name='desc1' href="javascript:showAllowOper('<%=patient_id%>')"  ><%=patient_det%></a></td>
  <%}%>
		<td class='<%=classValue%>'  <%=colordisplay%> ><a name='desc1' href="javascript:showPrevEncounter('<%=patient_id%>')"  ><font size=1><%=location%></a></td>
		<td class='<%=classValue%>'  <%=colordisplay%> > <font size=1><%=treatment_area_desc%></td>
		<td class='<%=classValue%>'   <%=colordisplay%> > <font size=1><%=assign_room_num%> </td>
		<td class='<%=classValue%>'  <%=colordisplay%>  > <font size=1><%=assign_bed_num%></td>
		<td class='<%=classValue%>'  <%=colordisplay%> > <font size=1><%=DateUtils.convertDate(deceased_date,"DMYHM","en",localeName)%></td>
		<td class='<%=classValue%>'  <%=colordisplay%>  > <font size=1><%=DateUtils.convertDate(body_release_date_time,"DMYHM","en",localeName)%></td>
		
		  </tr>
 <%
	i++;
	cnt++;
		  }

		if(cnt == 0)
		{%>	
				<script>
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));				
				</script>
		<%}

		if (!rs.next() && cnt!=0 )
		{
				endOfRes = 0;	
				%>
					<script>
						document.getElementById('nextval').innerHTML=" ";					
					</script>					
				<%
		 }
  %>
   </table>
        <br>
			<%				
				if (rs != null) rs.close();
                if (st != null) st.close();
	}
    catch(Exception e) {out.println(e.toString());}
    finally
    {
       	ConnectionManager.returnConnection(con,request);
		%><script>
			if(parent.frames[1].document.forms[0] != null)
			parent.frames[1].document.forms[0].search.disabled=false
		  </script>
		<%}
		
	%>
	    <input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
       </form>
    </body>
  </html>
<%!
public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
%>

