<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import = 'java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper' %>
<%
  String p_module_id		= "OA";
  String p_report_id		= "OARAPSL";
  String p_facility_id		= (String) session.getValue( "facility_id" );
  String p_user_name		= (String) session.getValue( "login_user" ); 
%>
<head>
   <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
    -->
<%
	String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eOA/js/repReprintApptSlips.js'></script>
<script language='javascript'>
	parent.messageFrame.document.location.href = "../../eCommon/jsp/error.jsp";    
	async function getrep(appt_ref_no,clinic_code,patient_id,rd_appt_yn) {  
		/*parent.frames[2].document.forms[1].p_appt_ref_no.value=val;
		parent.frames[2].document.forms[1].p_clinic_code.value=ccode;	
		var p_module_id=parent.frames[2].document.forms[1].p_module_id.value
		var p_report_id=parent.frames[2].document.forms[1].p_report_id.value
		var p_facility_id=parent.frames[2].document.forms[1].p_facility_id.value
		var p_location_type=parent.frames[2].document.forms[1].P_LOCATION_TYPE.value
		var p_clinic_code=ccode;
		var p_appt_ref_no=val;
		//var confirmprint = confirm(getMessage("APPT_REPRINT","OA"));
		//if (confirmprint)
		var features    = "dialogHeight:20; dialogWidth:70; scroll=no; status:no;";
		var arguments = '';	var url="../../eOA/jsp/reprintAppointmentSlipReport.jsp?p_module_id="+p_module_id+"&p_report_id="+p_report_id+"&p_facility_id="+p_facility_id+"&p_location_type="+p_location_type+"&p_clinic_code="+p_clinic_code+"&p_appt_ref_no="+p_appt_ref_no+"&singleApptYN=Y";
		var retVal = window.showModalDialog(url,arguments,features);
		if(retVal !='N'){
			var retArr=retVal.split("|~");
			parent.frames[2].document.forms[1].p_language_id.value=retArr[0];
			alert(getMessage("REPORT_SUBMIT_SERVER","Common"));
			parent.frames[2].document.forms[1].submit();
		}else{
		}*/
		
		var facility_id=parent.frames[2].document.forms[1].p_facility_id.value;
		var location_type=parent.frames[2].document.forms[1].P_LOCATION_TYPE.value
		var dialogHeight	= '70vh' ;
		var dialogWidth		= '65vw' ;
		var dialogTop		= 58;
		var arguments		= ''; 		
		
		if(rd_appt_yn=="Y"){ 
			/* below line appt_no variable added by venkatesh.s on 25/03/2012 against RUT-CRF-0006.1 [IN036541] */
			var sql="select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'RD' AND REPORT_ID = 'RDRORNTF' and language_id = '"+localeName+"'";
			var reportParamNames="ND_APPT_REF_NUM,ND_FACILITY_ID";
			var reportParamValues=appt_ref_no+","+facility_id;
			var getUrl			= "../../eCommon/jsp/InternalReportsPrint.jsp?rep_id=RDRORNTF&step=1&sqlString=" + sql + "&reportParamNames="+reportParamNames+"&reportParamValues=" + reportParamValues + "&Patient_ID=" + patient_id+ "&dest_locn_type="+location_type+"&dest_locn_code=" +clinic_code+"&appt_no="+appt_ref_no+"";

		}else{ 
			/* below line appt_no variable added by venkatesh.s on 25/03/2012 against RUT-CRF-0006.1 [IN036541] */
			var sql="select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OA' AND REPORT_ID = 'OARAPSL' and language_id = '"+localeName+"'";
			var reportParamNames="p_appt_ref_no,p_facility_id";
			var reportParamValues=appt_ref_no+","+facility_id;
			var getUrl			= "../../eCommon/jsp/InternalReportsPrint.jsp?rep_id=OARAPSL&step=1&sqlString=" + sql + "&reportParamNames="+reportParamNames+"&reportParamValues=" + reportParamValues + "&Patient_ID=" + patient_id+ "&dest_locn_type="+location_type+"&dest_locn_code=" + clinic_code +"&appt_no="+appt_ref_no+"";
		}
		var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;';
		retVal=   await window.showModalDialog(getUrl,arguments,features);
	}
  </script>
</head>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String p_passing_local_date="";
	String locale = (String)session.getAttribute("LOCALE");
	if(locale.equals("th")){
		p_passing_local_date="Y";
	}else {
		p_passing_local_date="N";
	}
	String appt_ref_no = request.getParameter("appt_ref_no")==null?"":request.getParameter("appt_ref_no");
	String appt_date = request.getParameter("appt_date");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String clinic_code = request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
	String practitioner_id = request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
	String added_by_id = request.getParameter("added_by_id")==null?"":request.getParameter("added_by_id");
	String added_date = request.getParameter("added_date");
	String location1 = request.getParameter("location1")==null?"":request.getParameter("location1");
	String resource2 = request.getParameter("resource2")==null?"":request.getParameter("resource2");
	appt_date=DateUtils.convertDate(appt_date,"DMY",locale,"en");
	added_date=DateUtils.convertDate(added_date,"DMY",locale,"en");
	String facilityId = (String) session.getValue("facility_id");
	Connection con = null;  
	Statement stmt=null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	StringBuffer sql=new StringBuffer();
	int i=1;
	String classValue="";
	String rd_appt_yn="N";
	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" );
	String to = request.getParameter( "to" );  
	try{
		con = ConnectionManager.getConnection(request);  
		if ((whereClause == null || whereClause.equals(""))||whereClause.equals("null")){
			//sql.append( " where oa_appt.added_by_id = sm_appl_user_lang_vw.appl_user_id(+) and facility_id='"+facilityId+"' and CARE_LOCN_TYPE_IND=nvl('"+location1+"',CARE_LOCN_TYPE_IND) and language_id='"+locale+"' and RESOURCE_CLASS=nvl('"+resource2+"',RESOURCE_CLASS) and appt_ref_no = nvl('"+appt_ref_no+"',appt_ref_no) and appt_date = nvl(to_date('"+appt_date+"','dd/mm/yyyy'),appt_date) and clinic_code = nvl('"+clinic_code+"',clinic_code) and nvl(practitioner_id,'X') = nvl('"+practitioner_id +"',nvl(practitioner_id,'X') ) and nvl(patient_id,'X') = nvl('"+patient_id+"',nvl(patient_id,'X')) and nvl(oa_appt.added_by_id,'X') = nvl('"+added_by_id+"',oa_appt.added_by_id) and to_date(oa_appt.added_date ,'dd/mm/yyyy') = nvl(to_date('"+added_date+"','dd/mm/yyyy'),to_date(oa_appt.added_date,'dd/mm/yyyy')) order by to_number(appt_ref_no) desc ");
			sql.append( " where oa_appt.added_by_id = sm_appl_user_lang_vw.appl_user_id(+) and facility_id='"+facilityId+"' and sm_appl_user_lang_vw.language_id='"+locale+"' ");
			if(!location1.equals("")){
				sql.append("and CARE_LOCN_TYPE_IND='"+location1+"' ");
			}
			if(!resource2.equals("")){
				sql.append("and RESOURCE_CLASS='"+resource2+"' ");
			}
			if(!appt_ref_no.equals("")){
				sql.append("and appt_ref_no='"+appt_ref_no+"' ");
			}
			if(!appt_date.equals("")){
			sql.append("and appt_date = to_date('"+appt_date+"','dd/mm/yyyy') ");
			}
			if(!clinic_code.equals("")){
				sql.append("and clinic_code='"+clinic_code+"' ");
			}
			if(!practitioner_id.equals("")){
				sql.append("and practitioner_id='"+practitioner_id+"' ");
			}
			if(!patient_id.equals("")){
				sql.append("and patient_id='"+patient_id+"' ");
			}
			if(!added_by_id.equals("")){
				sql.append("and oa_appt.added_by_id='"+added_by_id+"' ");
			}
			if(!added_date.equals("")){
				sql.append("and trunc(oa_appt.added_date)=to_date('"+added_date+"','dd/mm/yyyy') ");
			}
			sql.append(" order by to_number(appt_ref_no) desc ");
		}else{
			sql.append(whereClause);
		}
		int start = 0 ;
		int end = 0 ;
		int temp_i=1;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
	  		end = 14 ;
		else
			end = Integer.parseInt( to ) ;		
		stmt = con.createStatement();
		int maxRecord = 0;
		String strsql2="select appl_user_name,to_char(oa_appt.added_Date,'dd/mm/yyyy') added_date, appt_ref_no, patient_id, patient_id,  patient_name,clinic_code,get_age(date_of_birth) age,gender ,to_char(appt_date,'dd/mm/yyyy') appt_date,to_char(appt_slab_from_time,'hh24:mi') appt_slab_from_time,to_char(appt_slab_to_time,'hh24:mi') appt_slab_to_time,OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_short_desc,CARE_LOCN_TYPE_IND,AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_IND,'"+locale+"','1') CARE_LOCN_TYPE_DESC,RESOURCE_CLASS, practitioner_id,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'))  practitioner_short_name,rd_appt_yn from oa_appt, sm_appl_user_lang_vw "+sql.toString();

		rs = stmt.executeQuery(strsql2);
		// commented by N Munisekhar on 13-May-2013 against  [IN:40010]
		//sql.setLength(0);
%>
	<body onmousedown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name='query_result' id='query_result'>
	<p>
	<table align='right'>
	<tr>
<%
	StringBuffer ref_nos = new StringBuffer("");
	StringBuffer clinic_codes = new StringBuffer();
	String appt_ref="";
	String ccode="";
	if (rs!=null) {
		if ( start != 1 )
			for( int j=1; j<start; temp_i++,j++ ){
				rs.next() ;
				appt_ref=rs.getString("appt_ref_no");
				ref_nos.append(appt_ref);
				ref_nos.append(",");
				ccode = rs.getString("clinic_code");
				clinic_codes.append(ccode);
				clinic_codes.append(",");
				rd_appt_yn = rs.getString("rd_appt_yn");
				clinic_codes.append(ccode);
				clinic_codes.append(",");
			}
			// modified by N Munisekhar on 13-May-2013 against  [IN:40010]
	  		while (temp_i<=end && rs.next()) {          
				if(maxRecord==0){
					if ( !(start <= 1) )  // {
						out.println("<td align ='right' id='prev'><A HREF='../../eOA/jsp/repReprintApptSlipsResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
					//}
//if ( !( (start+14) > maxRecord ) )
	//{
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/repReprintApptSlipsResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	
		//}
//End of  [IN:40010]
%>
</tr>
</table>
<br></p>
<table cellspacing='0' cellpadding='0' border=1 width='100%'>
		 <td class='COLUMNHEADER'>&nbsp;</th>
          <td class='COLUMNHEADER'><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
          <td class='COLUMNHEADER'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
          <td class='COLUMNHEADER'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
          <td class='COLUMNHEADER'><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
          <td class='COLUMNHEADER'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
          <td class='COLUMNHEADER'><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
          <td class='COLUMNHEADER'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
          <td class='COLUMNHEADER'><fmt:message key="Common.totime.label" bundle="${common_labels}"/></td>
		  <td class='COLUMNHEADER'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
          <td class='COLUMNHEADER'><fmt:message key="Common.LocationName.label" bundle="${common_labels}"/></td>
		  <td class='COLUMNHEADER'><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td> 
          <td class='COLUMNHEADER'><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></td> 
			
          <td class='COLUMNHEADER'><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></td> 
          <td class='COLUMNHEADER'><fmt:message key="Common.createddate.label" bundle="${common_labels}"/></td> 
<%			}

		
             if(temp_i<=end){ 
	     // modified by N Munisekhar on 13-May-2013 against  [IN:40010]
			 if ( temp_i % 2 == 0 )
	    	    classValue = "QRYEVEN" ;
		     else
    	    	classValue = "QRYODD" ;          
             appt_ref=rs.getString("appt_ref_no");
			 ref_nos.append(appt_ref);
			 ref_nos.append(",");
			 ccode = rs.getString("clinic_code");
			 clinic_codes.append(ccode);
			 clinic_codes.append(",");
			 String appt_date1 = rs.getString("appt_date");
			 String appt_date1_disp=DateUtils.convertDate(appt_date1,"DMY","en",locale);

			 String appt_slab_from_time = rs.getString("appt_slab_from_time");
			 rd_appt_yn = rs.getString("rd_appt_yn")==null?"N":rs.getString("rd_appt_yn");
			 String appt_slab_to_time = rs.getString("appt_slab_to_time");
			 String pract_id = rs.getString("practitioner_id");
			 location1 = rs.getString("CARE_LOCN_TYPE_IND");
			String gender_code=rs.getString("Gender");
			String gender_desc="";
			 if(gender_code.equals("M")) 
				{
				gender_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				}
				else if(gender_code.equals("F")) {
				gender_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				}
				else if(gender_code.equals("U")) {
				gender_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				}
			resource2= rs.getString("RESOURCE_CLASS");
			String res_name="";
			if(resource2.equals("P"))
			{
				res_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}
				if(resource2.equals("E"))
				{
					res_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}
			
				if(resource2.equals("O"))
				{
					res_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
				}
			
				if(resource2.equals("R"))
				{
					res_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}


			 String added_date1 = rs.getString("added_date");
			 String added_date1_disp=DateUtils.convertDate(added_date1,"DMY","en",locale);
			 String temp_patient_id=rs.getString("patient_id")==null?"":rs.getString("patient_id");
		
			%><tr><td align='left' class='<%=classValue%>' ><a href= "javascript:view_appt_dtl('<%=appt_ref%>','<%=appt_date1%>','<%=ccode%>','<%=pract_id%>','<%=appt_slab_from_time%>','<%=appt_slab_to_time%>')">+<td align='left' class='<%=classValue%>' ><a href= "javascript:getrep('<%=appt_ref%>','<%=ccode%>','<%=temp_patient_id%>','<%=rd_appt_yn%>') "><%
             out.println(appt_ref);
            %><input type='hidden' name='appt_ref_<%=i%>' id='appt_ref_<%=i%>' value='<%=appt_ref%>'></input>
			<input type='hidden' name='clinic_code_<%=i%>' id='clinic_code_<%=i%>' value='<%=ccode%>'></input></a></td><td align='left' class='<%=classValue%>' ><%
             out.println("&nbsp;&nbsp;"+temp_patient_id);
             %></td><td align='left' nowrap class='<%=classValue%>' nowrap >
			 <%=rs.getString("patient_name")%>
             </td><td align='left' class='<%=classValue%>' ><%
			 String age = rs.getString("age");
			 age = (age==null)?"&nbsp;&nbsp;":age;
			 out.println(age);
            %></td><td align='left' nowrap class='<%=classValue%>' >
				<%=gender_desc%>
             </td><td align='left' nowrap class='<%=classValue%>' >
			<%=appt_date1_disp%>
             </td><td align='left' nowrap class='<%=classValue%>' ><%=rs.getString("appt_slab_from_time")%>
            </td><td align='left' nowrap class='<%=classValue%>' >
             <%=rs.getString("appt_slab_to_time")%>
			 </td><td align='left' nowrap class='<%=classValue%>' ><%=rs.getString("CARE_LOCN_TYPE_DESC")%>
             </td><td align='left' nowrap class='<%=classValue%>' >
			 <%=rs.getString("clinic_short_desc")%>
            </td><td align='left' nowrap class='<%=classValue%>' ><%
			out.println(res_name);
            %></td><td align='left' nowrap class='<%=classValue%>' ><%
			 if(rs.getString("practitioner_short_name") == null)
			 {
			%>&nbsp;&nbsp;<%
			 } else
			 {
			 %><%=rs.getString("practitioner_short_name")%><%
			 }	
             %></td><td align='left' class='<%=classValue%>' nowrap>
			 <%=rs.getString("appl_user_name")%>
             </td><td align='left' class='<%=classValue%>' nowrap>
			 <%=added_date1_disp%>
			 </td></tr><%
             i++; 
			 temp_i++;
			 
			}
          else
			{
             appt_ref=rs.getString("appt_ref_no");
			 ref_nos.append(appt_ref);
			 ref_nos.append(",");
			 ccode = rs.getString("clinic_code");
			 clinic_codes.append(ccode);
			 clinic_codes.append(",");
			}
			maxRecord++;
          } //end of while
%>
        <input type='hidden' name='totrec' id='totrec' value='<%=i-1%>' ></input>   
        </table>
      </form>

      <form name='printrep' id='printrep' method='post' action='../../servlet/eOA.repReprintApptSlips' target='messageFrame'>
			<input type='hidden' name='p_report_id' id='p_report_id' value='<%=p_report_id%>'></input>
			<input type='hidden' name='P_RESOURCE_CLASS' id='P_RESOURCE_CLASS' value='<%=resource2%>'></input>
			<input type='hidden' name='P_LOCATION_TYPE' id='P_LOCATION_TYPE' value='<%=location1%>'></input>
			<input type='hidden' name='p_module_id' id='p_module_id' value='<%=p_module_id%>'></input>
			<input type= 'hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
     		<input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
     		<input type='hidden' name='p_appt_ref_no' id='p_appt_ref_no' value=''></input>
			<input type='hidden' name='p_clinic_code' id='p_clinic_code' value=''></input>	
			<input type='hidden' name='p_clinic_codes' id='p_clinic_codes' value='<%=clinic_codes.toString()%>'></input>
			<input type='hidden' name='p_appt_ref_nos' id='p_appt_ref_nos' value='<%=ref_nos%>'></input>
			<input type= 'hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'/></input>

       </form>
	  </body>
	  <script >
		   parent.f_query_search_criteria.document.getElementById('reprint_all').disabled=false;
	   </script>
		<%
		  }
		  else {
	%>
			 <script language='javascript'>
				var err = getMessage('NO_RECORD_FETCHED','OA');
				parent.messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num="+err;
			  </script>

		<% }

	if(maxRecord == 0)
	{%>
	<script>
		parent.f_query_search_criteria.document.getElementById('reprint_all').disabled=true;
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		//history.go(-1);
	</script>
	<%}

	if ( maxRecord < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<% 
			} else {%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

	<%}

     if (rs != null) rs.close();
	 if (rs1 !=null) rs1.close();
 	 if (stmt != null) stmt.close();

  } catch(Exception e)
	{
	 e.printStackTrace();
    }
  finally {
   	ConnectionManager.returnConnection(con,request);
  }

%>

</html>

