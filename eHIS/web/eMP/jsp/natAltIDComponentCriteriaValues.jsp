
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, java.text.*, java.net.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%	
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	java.sql.Statement stmtn=null,stmt=null;
	ResultSet rset3 = null,rset=null ;
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get("SEARCH") ;
	String step=(String) hash.get("step");
	String id=(String) hash.get("id");
	String oth_id_type=(String) hash.get("oth_id_type");
	String alert_reqd_yn = (String) hash.get("alert_reqd_yn");
	String mr_transaction = (String) hash.get("mr_transaction");
	if(step == null) step = "";		
	if(id == null) id="";
	if(oth_id_type == null) oth_id_type="";
	if(alert_reqd_yn == null) alert_reqd_yn="N";
	if(mr_transaction == null) mr_transaction="N";
	String patient_id = "";
	String result = "";
	String error_message = "";
	String date_of_birth = "";
	String facilityid=(String)session.getValue("facility_id");
	String alt_id1_type = "";
	String alt_id2_type = "";
	String alt_id3_type = "";
	String alt_id4_type = "";
	String disp_prompt="";
	String field_name="";
	String patient_id_detail="";
	String nat_invoke_routine="";
	String nat_data_source_id="";
	String nat_id_length ="";
	String age_in_years  = "";
	String age_in_months = "";
	String age_in_days   = "";
	String sex = "";		
	String patient_id_addresses= "";		
	int altcount=0;//Added by Rameswar on 15th July 2015 against IN056434	
	
	webbeans.op.PatientData patdata = new webbeans.op.PatientData();			
	try{
		con = ConnectionManager.getConnection(request);
		String sql1 = "select decode('"+step+"','N',nat_id_prompt,'A1',alt_id1_type,'A2',alt_id2_type,'A3',alt_id3_type,'A4',alt_id4_type),alt_id1_type,alt_id2_type,alt_id3_type,alt_id4_type,invoke_routine,nat_data_source_id,nat_id_length from mp_param ";
		
		stmtn=con.createStatement();
		rset3=stmtn.executeQuery(sql1);
		     
		if(rset3!= null && rset3.next())
		{
			disp_prompt= rset3.getString(1);
			alt_id1_type= rset3.getString(2);
			alt_id2_type= rset3.getString(3);
			alt_id3_type= rset3.getString(4);
			alt_id4_type= rset3.getString(5);
			nat_invoke_routine= rset3.getString(6);
			nat_data_source_id= rset3.getString(7);
			nat_id_length= rset3.getString(8);
		} if(rset3 != null) rset3.close();
			if(disp_prompt==null) disp_prompt="";
			if(alt_id1_type==null) alt_id1_type="";
			if(alt_id2_type==null) alt_id2_type="";
			if(alt_id3_type==null) alt_id3_type="";
			if(alt_id4_type==null) alt_id4_type="";
			if(nat_invoke_routine==null) nat_invoke_routine="";
			if(nat_data_source_id==null) nat_data_source_id="";
			if(nat_id_length==null) nat_id_length=""; 
			
		//Modified below Query Query tuning for full table scan [IN:051268]
		String sql="select a.patient_id,a.patient_id||'||'||decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) ||'||'||a.national_id_no||'||'||a.alt_id1_no||'||'||a.alt_id2_no||'||'||a.alt_id3_no||'||'||a.alt_id4_no||'||'||a.name_prefix||'||'||a.first_name||'||'||a.second_name||'||'||a.third_name||'||'||a.family_name||'||'||a.name_suffix||'||'||a.sex||'||'||to_char(a.date_of_birth,'dd/mm/yyyy')||'||'||a.contact1_no||'||'||a.contact2_no||'||'||a.email_id||'||'||a.nationality_code||'||'||to_char(a.alt_id1_exp_date,'dd/mm/yyyy')||'||'||to_char(a.alt_id2_exp_date,'dd/mm/yyyy') ||'||'||to_char(a.alt_id3_exp_date,'dd/mm/yyyy') ||'||'||to_char(a.alt_id4_exp_date,'dd/mm/yyyy')||'||'|| calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),1) ||'||'|| calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),2) ||'||'|| calculate_age(to_char(a.date_of_birth,'dd/mm/yyyy'),3)||'||'||a.oth_alt_id_type ||'||'|| a.oth_alt_id_no,b.ADDR1_TYPE    ||'||'||B.ADDR1_LINE1   ||'||'||B.ADDR1_LINE2   ||'||'||B.ADDR1_LINE3   ||'||'||B.ADDR1_LINE4   ||'||'||a.RES_TOWN_CODE ||'||'||a.RES_AREA_CODE ||'||'||B.POSTAL1_CODE||'||'||a.REGION_CODE ||'||'||B.COUNTRY1_CODE||'||'||B.CONTACT1_NAME ||'||'||B.INVALID1_YN ||'||'||B.ADDR2_TYPE    ||'||'||B.ADDR2_LINE1   ||'||'||B.ADDR2_LINE2   ||'||'||B.ADDR2_LINE3   ||'||'||B.ADDR2_LINE4   ||'||'||B.RES_TOWN2_CODE||'||'||B.RES_AREA2_CODE||'||'||B.REGION2_CODE||'||'||B.POSTAL2_CODE  ||'||'||B.COUNTRY2_CODE ||'||'||B.CONTACT2_NAME ||'||'||B.INVALID2_YN    ||'||'||B.ADDR3_TYPE    ||'||'||B.ADDR3_LINE1   ||'||'||B.ADDR3_LINE2   ||'||'||B.ADDR3_LINE3   ||'||'||B.ADDR3_LINE4   ||'||'||B.POSTAL3_CODE  ||'||'||B.COUNTRY3_CODE ||'||'||B.CONTACT3_NAME ||'||'||B.INVALID3_YN   ||'||'||B.ADDR4_TYPE    ||'||'||B.ADDR4_LINE1   ||'||'||B.ADDR4_LINE2   ||'||'||B.ADDR4_LINE3   ||'||'||B.ADDR4_LINE4   ||'||'||B.POSTAL4_CODE  ||'||'||B.COUNTRY4_CODE ||'||'||B.CONTACT4_NAME ||'||'||B.INVALID4_YN   ||'||'||B.ADDR5_TYPE    ||'||'||B.ADDR5_LINE1   ||'||'||B.ADDR5_LINE2   ||'||'||B.ADDR5_LINE3   ||'||'||B.ADDR5_LINE4   ||'||'||B.POSTAL5_CODE  ||'||'||B.COUNTRY5_CODE ||'||'||B.CONTACT5_NAME from mp_patient a ,mp_pat_addresses b where a.patient_id = b.patient_id(+) AND a.patient_id BETWEEN NVL ('%%','%%')  AND NVL ('',a.patient_id) AND a.patient_id LIKE '%%'";
		
		if(step.equals("N")){
			sql=sql+" and  a.national_id_no='"+id+"' ";
			field_name = "national_id_no";
		}
		else if(step.equals("A1")){
			sql=sql+" and  a.alt_id1_no='"+id+"' ";
			field_name = "alt_id1_no";
		}
		else if(step.equals("A2")){
			sql=sql+" and  a.alt_id2_no='"+id+"' ";
			field_name = "alt_id2_no";
		}
		else if(step.equals("A3")){
			sql=sql+" and  a.alt_id3_no='"+id+"' ";
			field_name = "alt_id3_no";
		}
		else if(step.equals("A4")){
			sql=sql+" and  a.alt_id4_no='"+id+"' ";
			field_name = "alt_id4_no";
		}
		else if(step.equals("A5")){
			sql=sql+" and  a.oth_alt_id_no='"+id+"' and  a.oth_alt_id_type = '"+oth_id_type+"' ";
			field_name = "other_alt_Id";
		}
		
		rset3=stmtn.executeQuery(sql);
		if(rset3!= null){
			while(rset3.next()){
				patient_id = rset3.getString(1);
				patient_id_detail = rset3.getString(2);
				patient_id_addresses = rset3.getString(3);
				altcount++;
			}
		} if(rset3 != null) rset3.close();
		/*Added by Rameswar on 15th July 2015 against IN056434*/
		/*When multiple patients has same Alt ID then patient ID should be populate in Patient ID field
			If Alt Id is Unique, it should be populated*/
		if(altcount>1){
		patient_id="";
		}
if(!patient_id.equals("")){
	String chkst=patdata.CheckStatus(con,patient_id);
	if(chkst.equals("DECEASED")){
		patient_id_detail="DECEASED";
		%>				
		var err_age1 = getMessage("PAT_DECEASED_NOT_ALLOWED","MP");	
		<% if(mr_transaction.equals("Y")) { %>
		err_age1= err_age1.substring(0,err_age1.indexOf("cannot")) ;
		<% }%>
		alert(err_age1);
		document.forms[0].txtSmartcard_dup.value="D";
		<%
	}
	else if(chkst.equals("SUSPENDED")){
		patient_id_detail="SUSPENDED";
		%>
		var err_age2 = getMessage("PAT_SUSPENDED_NOT_ALLOWED","MP");
		<% if(mr_transaction.equals("Y")) { %>
		err_age2= err_age2.substring(0,err_age2.indexOf("cannot")) ;
		<% }%>
		alert(err_age2);
		document.forms[0].txtSmartcard_dup.value="D";
		<%
	} 
	else if(chkst.equals("INACTIVE")){
		patient_id_detail="INACTIVE";
		%>
		var err_age3 = getMessage("PAT_INACTIVE_PATIENT","MP");
		<% if(mr_transaction.equals("Y")) { %>
		err_age3= err_age3.substring(0,err_age3.indexOf("cannot")) ;
		<% }%>
		alert(err_age3);
		document.forms[0].txtSmartcard_dup.value="D";
		<%
	} 	
	if(chkst.equals("INACTIVE") || chkst.equals("SUSPENDED") || chkst.equals("DECEASED")){
	}
	else
	{
		%>
		document.forms[0].txtSmartcard_pat_id.value='<%=patient_id%>';
		document.forms[0].txtSmartcard_dup.value="D";
		<%
		String In_patient_status =  patdata.CheckInPatient(con,patient_id,facilityid);
		//added condition to restict alert in Medical Records for ML-MMOH-441 on 27/7/2015 By Sangeetha
		if(In_patient_status.equals("CURRENTLY_IN_PATIENT") && !mr_transaction.equals("Y"))
		{
			%>
			var err_age3 = getMessage( "CURRENTLY_IN_PATIENT","Common");
			alert(err_age3);
			<%
		}
			
		String alt_status = patdata.CheckAlternateId(con,patient_id,localeName);
		//char alt_stat = 'Y';
		if(!alt_status.equals(""))
		{
			char val = alt_status.charAt(0);

			if(val == 'W')
			{
				String msg = alt_status.substring(2,alt_status.length());
			%>	
//				alert("<%=msg%>"); 
				/*
				var contyn = confirm("<%=msg%>");  
				if(contyn) {			}
				*/
		<%	}
			else if(val =='C')
			{			
				String msg = alt_status.substring(1,alt_status.length());
			%>
//					alert("<%=msg%>"); 
		<%	}
			else 
			{	
				String msg = alt_status.substring(2,alt_status.length());
			%>
//					alert("<%=msg%>"); 
		<%	}
		}
	}	%>
	//populateDetail("<%=field_name%>","<%=patient_id_detail%>","<%=patient_id_addresses%>");
<%	}
	else{
       if(step.equals("N")&&nat_invoke_routine.equals("Y")&&nat_data_source_id.equals("NRIC")){
			sql = "select VERIFY_NATIONAL_ID('"+id+"') from dual";
			rset3=stmtn.executeQuery(sql);
			if(rset3!= null && rset3.next())
			result = rset3.getString(1);
						
			StringTokenizer strTok = new StringTokenizer(result,"$");				
					
			if(strTok.hasMoreTokens())
				result = strTok.nextToken();
				if(result.equals("TRUE")){
					if(strTok.hasMoreTokens())
						date_of_birth = strTok.nextToken();	
					if(strTok.hasMoreTokens())
						age_in_years = strTok.nextToken();	
					if(strTok.hasMoreTokens())
						age_in_months = strTok.nextToken();	
					if(strTok.hasMoreTokens())
						age_in_days = strTok.nextToken();	
					if(strTok.hasMoreTokens())
						sex = strTok.nextToken();
					result = "NAT_ID_VALUES"+"||"+date_of_birth+"||"+age_in_years+"||"+age_in_months+"||"+age_in_days+"||"+sex;
					%>
					//populateDetail("<%=field_name%>","<%=result%>","<%=patient_id_addresses%>");
					<%
				}
				else if(result.equals("FALSE")){
					if(strTok.hasMoreTokens())
					{
						error_message = strTok.nextToken();
						if(error_message.equals("NAT_ID_CHARS")){%>
						var msg = getMessage('<%=error_message%>','MP');
						msg = msg.replace('#','<%=disp_prompt%>');
						msg = msg.replace('@','<%=nat_id_length%>');
						alert(msg);	
						document.forms[0].national_id_no.focus();
						<%}else{%>
						var msg = getMessage('<%=error_message%>','MP');
						msg = msg.replace('$','<%=disp_prompt%>');
						alert(msg);	
						document.forms[0].national_id_no.focus();
						<%}%>
						<% if(!mr_transaction.equals("Y")) { %>
						document.forms[0].national_id_no.value='';
						<% }
					}
				}
				else
				{
					if(strTok.hasMoreTokens()){
						error_message = strTok.nextToken();
						%>
						var msg = getMessage('<%=error_message%>','MP');
						alert(msg);	
						document.forms[0].national_id_no.focus();
						<% if(!mr_transaction.equals("Y")) { %>
						document.forms[0].national_id_no.value='';
						<% }%>						
						<%							
					}
				}
			}
			else{
				%>	
				var idVal = '<%=disp_prompt%>';
				var step1 = '<%=step%>';
				var field_name1= '<%=field_name%>';
				var alert_reqd_yn = '<%=alert_reqd_yn%>';
				var err = getMessage('INVALID_VALUE','Common');
				if(step1=="A5"){
					err = err.replace('#','Other Alt ID');
					if(document.forms[0].txtSmartcard_path.value==''){ // if condition for smartcard
						alert(err);
						document.forms[0].other_alt_Id.focus();
						<% if(!mr_transaction.equals("Y")) { %>
							document.forms[0].other_alt_Id.value='';
						<% }%>
					}
					
				}
				else{
				   if(alert_reqd_yn == "Y"){
						err = err.replace('#',idVal);
						alert(err);
						eval("document.forms[0]."+field_name1+".focus()")
						eval("document.forms[0]."+field_name1+".value=''");
				   }
				}
				<%							
			}
		}
		if(stmtn!= null) stmtn.close();
		if(stmt!= null) stmt.close();
		if(rset3 != null) rset3.close();
		if(rset != null) rset.close();
		hash.clear();
	}
	catch(Exception e){	 
		out.println(e.toString());
	}
	finally{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	%>
