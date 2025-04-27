<!DOCTYPE html>
<%@ page  import= "webbeans.eCommon.*,eCommon.Common.*,java.util.*,java.sql.*,java.text.*,java.net.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> <!--[eCommon.Common]Added by Sakthi against IN:-062848 -->
<%
	
		request.setCharacterEncoding("UTF-8");

		String patient_name                       ="";
		String age                                ="";
		String sex                                ="";
		String location				              ="";
		String Nationality				          =""; //Added by Sakthi against IN:-062848
		String high_risk_yn                       ="";
		String treatment_area_desc		          ="";
		String assign_room_num                    ="";
		String assign_bed_num			          ="";
		String deceased_date			          ="";
		String body_release_date_time             ="";
		String burial_permit_no		              ="";     	
		String mlc_yn							  = checkForNull(request.getParameter("mlcyn"));
		String brought_dead_yn                    = checkForNull(request.getParameter("broughtindead"));
		String patient_det="";
		String citizenyn="";
		String religion="";
		String PM_YN= checkForNull(request.getParameter("pmyn"));
		String deceased_date_cnv = "";
		String body_release_date_time_cnv = "";
		

		String colordisplay                        ="";
		String patient_id			= checkForNull(request.getParameter("patient_id"));
		String BURIAL_PERMIT_NO		= checkForNull(request.getParameter("BURIAL_PERMIT_NO"));
		String clinic_code			= checkForNull(request.getParameter("locn"));
		String clinic_code1			= checkForNull(request.getParameter("clinic_code1"));
		String dec_date_time        = checkForNull(request.getParameter("dec_date_time"));
		String regcase        = checkForNull(request.getParameter("regcase"));
		String timeinterval="";
		StringBuffer getInt=new StringBuffer();
		
		String dec_date_time1 =request.getParameter("dec_date_time1")==null?"":request.getParameter("dec_date_time1");
		
		if(patient_id.equals("")) patient_id        = "%";
		if(BURIAL_PERMIT_NO.equals("")) BURIAL_PERMIT_NO       = "%";
		if(clinic_code.equals("")) clinic_code            = "%";
		if(clinic_code1.equals("")) clinic_code1  = "%";
		if(dec_date_time1.equals("")) dec_date_time1      = "";
		if(dec_date_time.equals("")) dec_date_time      = "01/01/1800 00:00";
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
		<Script src="../../eCommon/js/DateUtils.js" language="JavaScript"></Script>
		<script language='javascript' src='../../eMO/js/MORegisterAttn.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		
<%
		Connection	    con		= null;
		Statement		st		= null;
		ResultSet		rs		= null;			        
		String facility_id = (String)session.getValue("facility_id");
		String from = request.getParameter( "from" ) ;
	    String to = request.getParameter( "to" ) ;
		int start = 0 ;
	    int end = 0 ;
	    int i=1;
    	if ( from == null )
		start = 1 ;
	    else
		start = Integer.parseInt( from ) ;
    	if ( to == null )
	  	end = 8 ;
	    else
		end = Integer.parseInt( to ) ;
        //int maxRecord = 0; 
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

	if (rs!=null) rs.close();
	if (st!=null) st.close();
	Boolean validationForNationality	= CommonBean.isSiteSpecific(con,"MO","NATIONALITY_APP_YN"); //Added by Sakthi against IN:-062848

%>
		
  <script>
        /*Below Code Added for this incident[33932] */
		 if('<%=timeinterval%>'!=""){
         var timeinterval='<%=timeinterval%>'*1000*60; 	
		 self.setInterval('submitPage()',timeinterval)
		}
       </script>
     </head>                         
		
		<body  onMouseDown='CodeArrest()'   onKeyDown="lockKey()">
		<form name = 'MOAreaAvailabilityQueryResult_form'>
 <%
		String classValue	= "";
		int rowIndex		= 1;
		
		
		int ccount          = 0;
        
			StringBuffer getcount = new StringBuffer();
			getcount.append("select count(*) from  mo_encounter_dtls_vw where upper(PATIENT_ID) like upper('"+patient_id+"')  and NVL(BURIAL_PERMIT_NO,'*') like  ('"+BURIAL_PERMIT_NO+"') AND NVL(ASSIGN_CARE_LOCN_TYPE,'*') LIKE ('"+clinic_code+"') AND NVL(ASSIGN_CARE_LOCN_CODE,'*') LIKE ('"+clinic_code1+"') and REGN_ALLOWED_IN_MO_YN='Y' ");
 
	
           if(PM_YN.equals("Y"))
		   {
		   getcount.append("and pm_yn='Y'");
		   }

		   if(brought_dead_yn.equals("Y"))
		   {
			   getcount.append("and BROUGHT_DEAD_YN='Y'");
		   }
		   if(mlc_yn.equals("Y"))
		   {
			   getcount.append("and mlc_yn='Y'");
		   }else
		   {
		   }
		   if(regcase.equals("Y"))
		   {
		   getcount.append(" and PATIENT_ID  in (select NVL(patient_id,'*') from mo_mortuary_regn)");
		   }else
			{
			getcount.append(" and PATIENT_ID not in (select NVL(patient_id,'*') from mo_mortuary_regn where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D'))");
			}

			getcount.append("and facility_id ='"+facility_id+"' and to_date(substr(DECEASED_DATE,1,10),'dd/mm/yyyy') between to_date('"+dec_date_time+"','dd/mm/yyyy')");
			if(dec_date_time1.equals("")) getcount.append("and (sysdate)");
			else getcount.append("and to_date('"+dec_date_time1+"','dd/mm/yyyy')");
			
			
			st=con.createStatement();
	     
			rs = st.executeQuery(getcount.toString());
			while(rs!=null && rs.next())
			{
				ccount = rs.getInt(1);
			}
			if (rs!=null) rs.close();
			if (st!=null) st.close();
		    if(ccount > 0)
			{
				
		 %>
			 
	 <p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../jsp/MODeceasedDtlsQueryResult.jsp?from="+(start-8)+"&to="+(end-8)+"&patient_id="+URLEncoder.encode(patient_id)+"&BURIAL_PERMIT_NO="+URLEncoder.encode(BURIAL_PERMIT_NO)+"&locn="+URLEncoder.encode(clinic_code)+"&clinic_code1="+URLEncoder.encode(clinic_code1)+"&dec_date_time="+URLEncoder.encode(dec_date_time)+"&dec_date_time1="+URLEncoder.encode(dec_date_time1)+"&regcase="+URLEncoder.encode(	regcase)+"&brought_dead_yn="+URLEncoder.encode(brought_dead_yn)+"&mlc_yn="+URLEncoder.encode(mlc_yn)+"&pmyn="+URLEncoder.encode(PM_YN)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+8) > ccount ) )
	out.println("<A HREF='../jsp/MODeceasedDtlsQueryResult.jsp?from="+(start+8)+"&to="+(end+8)+"&patient_id="+URLEncoder.encode(patient_id)+"&BURIAL_PERMIT_NO="+URLEncoder.encode(BURIAL_PERMIT_NO)+"&locn="+URLEncoder.encode(clinic_code)+"&clinic_code1="+URLEncoder.encode(clinic_code1)+"&dec_date_time="+URLEncoder.encode(dec_date_time)+"&dec_date_time1="+URLEncoder.encode(dec_date_time1)+"&regcase="+URLEncoder.encode(regcase)+"&brought_dead_yn="+URLEncoder.encode(brought_dead_yn)+"&mlc_yn="+URLEncoder.encode(mlc_yn)+"&pmyn="+URLEncoder.encode(PM_YN)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
</p>

<br>
<br>
		 <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>
		    <td class='columnheader'>&nbsp;</td>	
			<td class='columnheader'>&nbsp;</td>	
		    <td class='columnheader'><fmt:message key="eMO.DeceasedPatientDetls.label" bundle="${mo_labels}"/></td> 
			<%
			if(validationForNationality)
			{
			%>
			<td class='columnheader'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td> <!Added by Sakthi against IN:-062848-->
			<%
			}
			%>
			<td class='columnheader'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='columnheader'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
			<td class='columnheader'><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></td>
			<td class='columnheader'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>	
			<td class='columnheader'><fmt:message key="Common.deceaseddatetime.label" bundle="${common_labels}"/></td>	
		    <td class='columnheader'><fmt:message key="eMO.BodyDisToMortuary.label" bundle="${mo_labels}"/> </td>		 
			<td class='columnheader'><fmt:message key="eMO.BurialPermitNumber.label" bundle="${mo_labels}"/></td>		 
		     
<%
			
           

            StringBuffer operSql = new StringBuffer();
            //operSql.append("select PATIENT_ID, PATIENT_NAME, AGE,PM_YN,SEX,HIGH_RISK_YN, LOCATION,CITIZEN_YN,RELGN_DESC, TREATMENT_AREA_DESC,ASSIGN_ROOM_NUM, ASSIGN_BED_NUM, DECEASED_DATE, BODY_RELEASE_DATE_TIME, BURIAL_PERMIT_NO,MLC_YN, BROUGHT_DEAD_YN from mo_encounter_dtls_vw where REGN_ALLOWED_IN_MO_YN='Y'  and upper(PATIENT_ID) like upper('"+patient_id+"')  and NVL(BURIAL_PERMIT_NO,'*') like  ('"+BURIAL_PERMIT_NO+"') AND NVL(ASSIGN_CARE_LOCN_TYPE,'*') LIKE ('"+clinic_code+"') AND NVL(ASSIGN_CARE_LOCN_CODE,'*') LIKE ('"+clinic_code1+"')");

			operSql.append("select PATIENT_ID, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,  mp_get_desc.mp_country(nationality_code,'"+localeName+"',3)Nationality, AGE, PM_YN, SEX, HIGH_RISK_YN, DECODE(assign_care_locn_type,'N',IP_GET_DESC.IP_NURSING_UNIT(facility_id,assign_care_locn_code,'"+localeName+"',2), OP_GET_DESC.OP_CLINIC(facility_id,assign_care_locn_code,'"+localeName+"',2)) LOCATION , CITIZEN_YN,  mp_get_desc.MP_REGION(relgn_code,'"+localeName+"',2) RELGN_DESC, ae_get_desc.AE_TMT_AREA_FOR_CLINIC(facility_id,assign_care_locn_code,treatment_area_code,'"+localeName+"',2) TREATMENT_AREA_DESC, ASSIGN_ROOM_NUM, ASSIGN_BED_NUM, DECEASED_DATE, BODY_RELEASE_DATE_TIME, BURIAL_PERMIT_NO,MLC_YN, BROUGHT_DEAD_YN from mo_encounter_dtls_vw where REGN_ALLOWED_IN_MO_YN='Y'  and upper(PATIENT_ID) like upper('"+patient_id+"')  and NVL(BURIAL_PERMIT_NO,'*') like  ('"+BURIAL_PERMIT_NO+"') AND NVL(ASSIGN_CARE_LOCN_TYPE,'*') LIKE ('"+clinic_code+"') AND NVL(ASSIGN_CARE_LOCN_CODE,'*') LIKE ('"+clinic_code1+"')");
			
			operSql.append(" and facility_id ='"+facility_id+"' and to_date(substr(DECEASED_DATE,1,10),'dd/mm/yyyy') between to_date('"+dec_date_time+"','dd/mm/yyyy')");
			if(dec_date_time1.equals("")) operSql.append("and (sysdate)");
			else operSql.append("and to_date('"+dec_date_time1+"','dd/mm/yyyy')");
			
		  if(PM_YN.equals("Y"))
		   {
		   operSql.append("and pm_yn='Y' and mlc_yn='N'");
		   }

		   if(brought_dead_yn.equals("Y"))
		   {
			   operSql.append("and BROUGHT_DEAD_YN='Y'");
		   }
		   if(mlc_yn.equals("Y"))
		   {
			   operSql.append("and mlc_yn='Y'");
		   }
		   if(regcase.equals("Y"))
		   {
		   operSql.append(" and PATIENT_ID  in (select NVL(patient_id,'*') from mo_mortuary_regn)");
		   }else
			{
			operSql.append(" and PATIENT_ID not in (select NVL(patient_id,'*') from mo_mortuary_regn where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D'))");
			}
			
			operSql.append(" order by to_date(BODY_RELEASE_DATE_TIME,'dd/mm/yyyy hh24:mi') desc");
			
			
			st=con.createStatement();
			
			rs = st.executeQuery(operSql.toString());
			
	 	     if ( start != 1 )
	         for( int j=1; j<start; i++,j++ ){
	         rs.next() ;
            }
			while(rs.next()&&i<=end)
			{
			classValue =	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			rowIndex++;
			  
			patient_id          =rs.getString("patient_id")==null?"&nbsp;":rs.getString("patient_id");   
			patient_name        =rs.getString("patient_name")==null?"&nbsp;":rs.getString("patient_name");   
		    Nationality         =rs.getString("Nationality")==null?"&nbsp;":rs.getString("Nationality"); //Added by Sakthi against IN:-062848
	        age                 =rs.getString("age")==null?"&nbsp;":rs.getString("age");      
			sex                 =rs.getString("sex")==null?"&nbsp;":rs.getString("sex");      
			PM_YN               =rs.getString("PM_YN")==null?"&nbsp;":rs.getString("PM_YN");
			high_risk_yn        =rs.getString("high_risk_yn")==null?"&nbsp;":rs.getString("high_risk_yn");
			citizenyn           =rs.getString("CITIZEN_YN")==null?"&nbsp;":rs.getString("CITIZEN_YN");      
			religion            =rs.getString("RELGN_DESC")==null?"&nbsp;":rs.getString("RELGN_DESC");      
			//if(citizenyn.equals("Y")) citizenyn="Citizen";else citizenyn="Non Citizen";
			location			=rs.getString("location")==null?"&nbsp;":rs.getString("location");  
			
			if(sex!=null && !sex.equals("") && sex.equals("Male"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if(sex!=null && !sex.equals("") && sex.equals("Female"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else if(sex!=null && !sex.equals("") && sex.equals("Unknown"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			if(citizenyn.equals("Y")) 
			{
				citizenyn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.citizen.label","common_labels");				
			}
			else
			{ 
			     citizenyn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.noncitizen.label","common_labels");
			}


            patient_det= patient_id+","+patient_name+","+age+","+sex+","+religion+","+citizenyn;
			treatment_area_desc	=rs.getString("treatment_area_desc")==null?"&nbsp;":rs.getString("treatment_area_desc");   
			assign_room_num     =rs.getString("assign_room_num")==null?"&nbsp;":rs.getString("assign_room_num");      
			assign_bed_num		=rs.getString("assign_bed_num")==null?"&nbsp;":rs.getString("assign_bed_num");   
			deceased_date		=rs.getString("deceased_date")==null?"&nbsp;":rs.getString("deceased_date");  
			body_release_date_time =rs.getString("body_release_date_time")==null?"&nbsp;":rs.getString("body_release_date_time");   
			burial_permit_no	=rs.getString("burial_permit_no")==null?"&nbsp;":rs.getString("burial_permit_no");   
			mlc_yn		 	    =rs.getString("mlc_yn")==null?"&nbsp;":rs.getString("mlc_yn");  			
			brought_dead_yn     =rs.getString("brought_dead_yn")==null?"&nbsp;":rs.getString("brought_dead_yn");    
			
			if(!deceased_date.equals(""))
				deceased_date_cnv = DateUtils.convertDate(deceased_date,"DMYHM","en",localeName); 
			if(!body_release_date_time.equals(""))
				body_release_date_time_cnv = DateUtils.convertDate(body_release_date_time,"DMYHM","en",localeName); 


%>			  
    
	
	<tr>
	    
	 <td> <a name='desc1' href="javascript:viewPatientDetails('<%=patient_id%>')"><font size=1>+</a></td>     <%
	     if(mlc_yn.equals("Y"))
		{%>
			<td style='background-color:maroon;color:white' width=2%>&nbsp;P</td>	
		<%}else if(PM_YN.equals("Y"))
		{%>
			<td style='background-color:Yellow;color:black' width=2%>&nbsp;P</td>	
		<%}else 
		{%>
	           <td>&nbsp;</td>	
		<%}
	    
     
	if(high_risk_yn.equals("Y"))
	{
	colordisplay="style='background-color:Orange;'";
	}else
	{
		colordisplay="";
	}

     if(regcase.equals("Y"))
		   { if(brought_dead_yn.equals("Y"))
	{%>
        <td  style='background-color:black;color:white;'><font size=1><%=patient_det%></a></td>
		   <%}else
			   {%>
			   
	 <td  class='<%=classValue%>' <%=colordisplay%>><font size=1><%=patient_det%></a></td>
	 <%}
	 
	 }else{
	 if(brought_dead_yn.equals("Y"))
	{%>
	<td  style='background-color:black;'> <a name='desc1' href="javascript:showAllowOper('<%=patient_id%>','<%=burial_permit_no%>')" style='color:white;' ><font size=1><%=patient_det%></a></td>
   <%}else { 
   %>
	<td class='<%=classValue%>' <%=colordisplay%> > <a name='desc1' href="javascript:showAllowOper('<%=patient_id%>','<%=burial_permit_no%>')" ><font size=1><%=patient_det%></a></td>
  <%}}%>
   <%
			if(validationForNationality)
			{
			%>
        <td class='<%=classValue%>' <%=colordisplay%> > <font size=1><%=Nationality%></td>   <!Added by Sakthi against IN:-06284-->
			<%
			}
	%>
		<td class='<%=classValue%>'  <%=colordisplay%> > <a name='desc1' href="javascript:showPrevEncounter('<%=patient_id%>','<%=burial_permit_no%>')" > <font size=1><%=location%></td>
		<td class='<%=classValue%>' <%=colordisplay%>  > <font size=1><%=treatment_area_desc%></td>
		<td class='<%=classValue%>' <%=colordisplay%>   > <font size=1><%=assign_room_num%> </td>
		<td class='<%=classValue%>' <%=colordisplay%>   > <font size=1><%=assign_bed_num%></td>
		<td class='<%=classValue%>' <%=colordisplay%>  > <font size=1><%=deceased_date_cnv%></td>
		<td class='<%=classValue%>' <%=colordisplay%>  > <font size=1><%=body_release_date_time_cnv%></td>
		<!--Style Added by Santhosh for ML-MMOH-CRF-1947>-->
		<td class='<%=classValue%>' <%=colordisplay%> style='word-wrap:break-word;width:300px;' > <font size=1><%=burial_permit_no%></td>
		  </tr>
 <%
	i++;
		}
  %>
   </table>
        <br>
			<%}
	    else
				{
		          out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
				}
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
       </form>
    </body>
  </html>
<%!
public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
%>

