<!DOCTYPE html>
<%--
/// MODULE			:	InPatient Management..(IP)
/// Function Name	:	Lodger -> CheckOutLodger && Lodger -> RenewGatePass
/// Developer		:	SRIDHAR R
/// Created On		:	FEB 2004
/// Funtion			:	This File is called on the click of ChkOutLodger or ChkOutAccPerson Functions & will direct the File to ReleaseBookLodgerDetail.jsp for	Both Functions.
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,java.net.*,com.ehis.util.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    
<script>
	async function closeWin(enc,patid)
	{
		await showModalCurEnc(enc,patid);             
	}

	async function callPage( lodger_ref_no, chk_in_date, enc_id, attached_to_inpatient_yn, ResultPageName, call_func, nursing_unit_short_desc, lodger_patient_id, patId_for_accID )
	{
	
		if(enc_id == '0') 
			enc_id='';

		var retVal = new String();
		
		var dialogHeight= "1200px";
		var dialogWidth = "1200px";
		var dialogTop = "72";
	
		var center = "1" ;
		var status="no";
		var arguments   = "" ;              
		var call_function = "";

		if(call_func == 'CHECK_OUT_LODGER')
		{
			call_function = 'CHECK_OUT_LODGER'
		}
		else if(call_func == 'CHECK_OUT_ACCMP_PERSON')
		{
			call_function = 'CHECK_OUT_ACCMP_PERSON'
		}
		
		var features    = "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		retVal=await window.showModalDialog("../../eIP/jsp/ReleaseBookLodgerDetail.jsp?mode=update&call_function="+call_function+"&lodger_ref_no="+lodger_ref_no+"&EncounterId="+enc_id+"&PatID="+lodger_patient_id+"&chk_in_dttime="+chk_in_date+"&Category="+attached_to_inpatient_yn+"&ResultPageName="+ResultPageName+"&patId_for_accID="+patId_for_accID+"&nursing_desc="+escape(nursing_unit_short_desc)+"&",arguments,features);
		parent.frames[2].document.location.reload();                
	}
</script>
<%
    request.setCharacterEncoding("UTF-8");
	String ResultPageName = "";
	ResultPageName = request.getParameter("PageValue")==null?"":request.getParameter("PageValue");
    String call_function     = request.getParameter("call_function");
	String locale			= (String)session.getAttribute("LOCALE");
	  

	if(!ResultPageName.equals("GatePass"))
	{
		Connection con = null;
		String patId_for_accID = "";
		try
		{
			con= ConnectionManager.getConnection(request);
			Statement stmt				= null;
            ResultSet rs				= null;
			CallableStatement Cs_Leave	= null; 
            String facility_id			= (String)session.getValue("facility_id");
            StringBuffer sql			= new StringBuffer();
			int records_to_show			= 12;

			String from = request.getParameter("from");
			String to = request.getParameter("to");
			StringBuffer where_criteria = new StringBuffer();
			where_criteria.append(checkForNull(request.getParameter("whereclause")));
			String nursing_unit_code =request.getParameter("nursing_unit");
            String lodger_type       =request.getParameter("lodger_type");
            String from_date         =request.getParameter("from_date");
			 if(from_date!=null && !from_date.equals(""))
				from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 
			 
            String to_date           =request.getParameter("to_date");
			 if(to_date!=null && !to_date.equals(""))
				to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 
            String patient_id        =request.getParameter("patient_id");
            String name              =request.getParameter("name");
            String gender            =request.getParameter("gender");
            String lodger_id         =request.getParameter("lodger_id");

			int p_max_record		 = 0;
			int start=0 ,	end=0;
			int endOfRes=1;
			String cname					= "QRYEVENSMALL" ;
			String prev_nursing_unit		= "&nbsp;" ;
			String curr_nursing_unit_code	= "";
			String prev_category			= "";
			String newcategory				= "" ;

    %>
</head>                           
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%
		if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
            where_criteria.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ");

        if( name!=null && !name.equals("") )// acc per id
            where_criteria.append(" and lodger_patient_id like '"+ name +"%' ");


		if( lodger_id!=null && !lodger_id.equals("") ) // lodger patinet id
            where_criteria.append(" and b.patient_id ='"+lodger_id+"' ");
			
			if( gender!=null && !gender.equals("") )
            where_criteria.append(" and a.lodger_gender ='"+ gender +"' ");


        if(from_date!=null && !from_date.equals(""))
            where_criteria.append(" and trunc(a.check_in_date_time) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
        
        if(to_date!=null && !to_date.equals(""))
            where_criteria.append(" and trunc(a.check_in_date_time) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");      
		
		try
		{
			if ( from == null )
				start = 0 ;
			else
				start = Integer.parseInt( from ) ;
			
			if ( to == null )
				end = records_to_show ;
			else
				end = Integer.parseInt( to ) ;

			sql.append("select a.lodger_ref_no  ,a.attached_to_inpatient_yn Accom_categ ,   (CASE WHEN a.NURSING_UNIT_CODE IS NOT NULL THEN (ip_get_desc.IP_NURSING_UNIT( '"+facility_id+"',a.NURSING_UNIT_CODE,'"+locale+"',2)) END ) nursing_unit_short_desc, A.attached_to_inpatient_yn   ,a.patient_encounter_id   ,b.patient_id    ,a.lodger_patient_id    ,a.lodger_name    ,a.bed_no||decode(a.bed_no,null,null,'/')||a.room_no  bed_no    ,to_char(check_in_date_time, 'dd/mm/rrrr hh24:mi') check_in_date_time,check_in_date_time check_in_date_time1, lodger_gender,   (CASE WHEN a.reason_for_stay_code IS NOT NULL THEN (ip_get_desc.IP_REASON_FOR_LODGER_STAY(a.reason_for_stay_code,'"+locale+"',2)) END ) reason_for_stay_code,   b.encounter_id     ,to_char(a.PERIOD_FROM_DATE, 'dd/mm/rrrr hh24:mi') PERIOD_FROM_DATE   ,to_char(a.PERIOD_TO_DATE, 'dd/mm/rrrr hh24:mi') PERIOD_TO_DATE   ,b.patient_id patId_for_accID from ip_lodger_detail a, pr_encounter  b where a.facility_id ='"+facility_id+"'  and a.check_out_yn= 'N' and  b.facility_id(+) = a.facility_id  and  b.encounter_id(+) = a.patient_encounter_id and a.attached_to_inpatient_yn =  decode('"+ lodger_type+"','A','Y','L','N',a.attached_to_inpatient_yn) " + where_criteria.toString());
			sql.append(" ORDER by ");
			sql.append(" Accom_categ, nursing_unit_short_desc, check_in_date_time1 desc  ");


			stmt = con.createStatement () ;
			rs = stmt.executeQuery(sql.toString());

			if(start > 1)
			{
				for(int k=0; k < start ;k++)
				{
					if (rs != null)
						rs.next();
				}
			}

			int cnt = 0;
			int z = 0;
			
			while( z < records_to_show  && rs.next() )
			{	
				if(cnt==0)
				{
					out.println("<p><table align='right'><tr><td>");

					if ( !(start <= 0) )
						out.println("<A HREF='../jsp/ReleaseLodgerLookupResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&lodger_type="+lodger_type+"&nursing_unit_code="+nursing_unit_code+"&from_date="+from_date+"&to_date="+to_date+"&patient_id="+patient_id+"&name="+name+"&gender="+gender+"&call_function="+call_function+" '" +
						" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

					if ( endOfRes==1 )
						out.println("<A id='nextval' HREF='../jsp/ReleaseLodgerLookupResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&lodger_type="+lodger_type+"&nursing_unit_code="+nursing_unit_code+"&from_date="+from_date+"&to_date="+to_date+"&patient_id="+patient_id+"&name="+name+"&gender="+gender+"&call_function="+call_function+" '"
						+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
						out.println("</td></tr></table></p>");
						out.println("<br><br>");

			out.println("<table width='100%' cellspacing=0 cellpadding=0 border=1>") ;
			out.println( "<tr>" ) ;

			if(call_function.equals("CHECK_OUT_LODGER"))
			{
				out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Lodger.label","common_labels")+"</th>" ) ;
				out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.LodgerName.label","ip_labels")+"</th>" ) ;
				out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ReasonforStay.label","ip_labels")+"</th>" ) ;
			}
			else if(call_function.equals("CHECK_OUT_ACCMP_PERSON"))
			{
				out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</th>" ) ;
				out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPerson.label","ip_labels")+"</th>" ) ;
				out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPersonName.label","ip_labels")+"</th>" ) ;
			}
			
			out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ChkdInDt.label","ip_labels")+"</th>" ) ;
			out.println( "</tr>" ) ;

			}


					z++;
					if((cname != null) && (cname.equals("QRYEVENSMALL")))
						cname = "QRYODDSMALL" ;
					else
						cname = "QRYEVENSMALL" ;

					curr_nursing_unit_code = rs.getString("nursing_unit_short_desc")== null ? com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels"): rs.getString("nursing_unit_short_desc");

					patId_for_accID = rs.getString("patient_id");

				String lodger_ref_no			= rs.getString("lodger_ref_no");
				String check_in_date_time		= rs.getString("check_in_date_time");
				String patient_encounter_id		= rs.getString("patient_encounter_id");
				String attached_to_inpatient_yn = rs.getString("attached_to_inpatient_yn");
				String nursing_unit_short_desc  = rs.getString("nursing_unit_short_desc");
				String lodger_patient_id        = rs.getString("lodger_patient_id");
				String lodger_name              = rs.getString("lodger_name") == null ? "&nbsp" : rs.getString("lodger_name");

					if(lodger_type.equals(""))
					{
						newcategory = rs.getString("Accom_categ");
						if(!newcategory .equals(prev_category)    )
						{
							out.println ( "<tr><td class='IPCAHIGHERLEVELCOLOR' colspan='5'><font size='2'><b>"+newcategory+"</font></td></tr>" ) ;
						}
					}

					if( !prev_nursing_unit.equals(curr_nursing_unit_code)  )
					{
						out.println ( "<tr><td class='CAGROUPHEADING' colspan='5'>"+curr_nursing_unit_code+"</td></tr>" ) ;
					}

				
				
				out.println( "<tr>" );
				if(call_function.equals("CHECK_OUT_ACCMP_PERSON"))
				{
				out.println ( "<td class='"+cname+"' nowrap>");
				out.println(rs.getString("patient_id")==null ? "&nbsp; ": rs.getString("patient_id") +"</td>") ;
				}
	
				out.println ( "<td class='"+cname+"' nowrap>");
				out.println(rs.getString("lodger_patient_id")==null ? "&nbsp; ": rs.getString("lodger_patient_id") +"</td>") ;
				//out.println ( "<td class='"+cname+"' nowrap><a href =\"javascript:callPage('" + rs.getString("lodger_ref_no") + "', '"+ rs.getString("check_in_date_time") +"', '"+rs.getLong("patient_encounter_id")+"', '"+ rs.getString("attached_to_inpatient_yn") +"','"+ResultPageName+"','"+call_function+"','"+ rs.getString("nursing_unit_short_desc") +"','"+rs.getString("lodger_patient_id")+"', '"+patId_for_accID+"')\">" +( rs.getString("lodger_name") == null ? " &nbsp;" : rs.getString("lodger_name"))+"</a></td>") ;
				
				out.println ( "<td class='"+cname+"' nowrap><a href =\"javascript:callPage('" +lodger_ref_no + "','" + check_in_date_time + "','" + patient_encounter_id + "','" + attached_to_inpatient_yn + "','" + ResultPageName + "','" + call_function + "','" + nursing_unit_short_desc + "','" + lodger_patient_id + "', '" + patId_for_accID +"')\">" );

				out.println("'"+lodger_name+"'</a></td>");
								
				if(call_function.equals("CHECK_OUT_LODGER"))
				{
					out.println ( "<td class='"+cname+"' nowrap> "+  (rs.getString("reason_for_stay_code") ==null? "&nbsp; " :(rs.getString("reason_for_stay_code")) ) +"</td>" ) ;
				}
					String check_in_date_display = rs.getString("check_in_date_time");
					if(check_in_date_display == null)
						check_in_date_display = "";
					else
						check_in_date_display = DateUtils.convertDate(check_in_date_display,"DMYHM","en",locale);

					out.println ( "<td class='"+cname+"' nowrap> "+check_in_date_display+"</a></td>" ) ;
					
					out.println( "</tr>" ) ;
					prev_nursing_unit =curr_nursing_unit_code ;
					prev_category =  rs.getString("Accom_categ") ;
                     if(prev_category.equals("Y"))
					{ 
						 prev_category= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPerson.label","ip_labels");
					}else{
						prev_category= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Lodger.label","common_labels");
					}
					p_max_record++;
					cnt++;
				}
			%>
				<script>				
					if (parseInt('<%=p_max_record%>') == 0)
					{
						alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
						parent.frames[2].document.location.href='../../eCommon/html/blank.html';
					}
				</script>
			<%

			out.println("</table>");

			if( !rs.next() && cnt!=0 )
			{
				endOfRes=0;
			%>
			<script>
				document.getElementById('nextval').innerHTML = " ";
			</script>
			<%
			}

		}catch(Exception e) { out.println(e.toString());}
		finally 
		{
			try
			{
				if (rs != null)			rs.close();  
				if (stmt != null)		stmt.close();
				if(Cs_Leave != null)	Cs_Leave.close();
			}
			catch(Exception e)
			{
			}
			out.print("<script>parent.frames[1].document.forms[0].disabled=false</script>");
		}
    %>
    <input type='hidden' name='lodger_type' id='lodger_type' value="<%=lodger_type%>" >
    <input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value="<%=nursing_unit_code%>" >
    <input type='hidden' name='from_date' id='from_date' value="<%=from_date%>" >
    <input type='hidden' name='to_date' id='to_date' value="<%=to_date%>" >
    <input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>" >
    <input type='hidden' name='name' id='name' value="<%=name%>" >
    <input type='hidden' name='gender' id='gender' value="<%=gender%>" >
	<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >    
</form>
    </body>
<% } catch(Exception e){out.println(e);}
    finally		
	{
        ConnectionManager.returnConnection(con,request);
    }
}/// E.O ResultPageName.equals("GatePass"))
else
{
	Connection con = null;
	try{
			con= ConnectionManager.getConnection(request);
			Statement stmt				= null;
            ResultSet rs				= null;
			CallableStatement Cs_Leave	= null; 
            String facility_id			= (String)session.getValue("facility_id");
            StringBuffer sql			= new StringBuffer();
			int records_to_show			= 8;

			String from = request.getParameter("from");
			String to = request.getParameter("to");
			StringBuffer where_criteria = new StringBuffer();
			where_criteria.append(checkForNull(request.getParameter("whereclause")));
            String nursing_unit_code =request.getParameter("nursing_unit");
            String from_date         =request.getParameter("from_date");
            String to_date           =request.getParameter("to_date");
            String patient_id        =request.getParameter("patient_id");
            String name              =request.getParameter("name");
            String gender            =request.getParameter("gender");
			int p_max_record		 = 0;
			int start=0,end=0;

			
    %>
</head>                         
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%

		if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
            where_criteria.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ");

        if( name!=null && !name.equals("") )
            where_criteria.append(" and lodger_patient_id like '"+ name +"%' ");

        if( gender!=null && !gender.equals("") )
            where_criteria.append(" and a.lodger_gender ='"+ gender +"' ");

        if(from_date!=null && !from_date.equals(""))
            where_criteria.append(" and trunc(a.check_in_date_time) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
        
        if(to_date!=null && !to_date.equals(""))
            where_criteria.append(" and trunc(a.check_in_date_time) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");      
		

        try
		{

			String cname					= "QRYEVENSMALL" ;
			String prev_nursing_unit		= "&nbsp;" ;
			String curr_nursing_unit_code	= "";
			String prev_category			= "";
			String newcategory				= "" ;

			int cnt = 0;
			int z = 0;
			int endOfRes=1;


				if ( from == null )
                    start = 0 ;
                else
                    start = Integer.parseInt( from ) ;
                
                if ( to == null )
                    end = records_to_show ;
                else
                    end = Integer.parseInt( to ) ;


				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select a.lodger_ref_no  ,a.attached_to_inpatient_yn Accom_categ ,   (CASE WHEN a.NURSING_UNIT_CODE IS NOT NULL THEN (ip_get_desc.IP_NURSING_UNIT('"+facility_id+"',a.NURSING_UNIT_CODE,'"+locale+"',2)) END ) nursing_unit_short_desc, A.attached_to_inpatient_yn   ,a.patient_encounter_id  ,C.patient_id  ,a.lodger_patient_id   ,a.lodger_name  ,to_char(check_in_date_time, 'dd/mm/rrrr hh24:mi') check_in_date_time,check_in_date_time check_in_date_time1, lodger_gender,  (CASE WHEN A.reason_for_stay_code IS NOT NULL THEN (ip_get_desc.IP_REASON_FOR_LODGER_STAY(A.reason_for_stay_code,'"+locale+"',2)) END ) reason_for_stay_code,  c.encounter_id    ,to_char(f.PERIOD_FROM_DATE, 'dd/mm/rrrr hh24:mi') PERIOD_FROM_DATE  ,to_char(f.PERIOD_TO_DATE, 'dd/mm/rrrr hh24:mi') PERIOD_TO_DATE   from   IP_LODGER_GATE_PASS f    , ip_lodger_detail a, pr_encounter  c where  a.facility_id ='"+facility_id+"'    and  a.check_out_yn = 'N'     and  f.revised_yn = 'N'     and  c.facility_id(+) = a.facility_id    and  c.encounter_id(+) = a.patient_encounter_id    and a.lodger_ref_no(+) = f.lodger_ref_no ");
				sql.append(where_criteria.toString());
				sql.append(" ORDER by ");
				sql.append(" Accom_categ,nursing_unit_short_desc,check_in_date_time1 desc  ");

				stmt = con.createStatement () ;
				rs = stmt.executeQuery(sql.toString());

				if(start > 1 && (rs != null))
				{
					for(int k=0; k < start ;k++)
						rs.next();
				}				

				while( z < records_to_show && rs.next() )
				{	
					if (cnt==0)
					{


				out.println("<p><table align='right'><tr><td>");
				if ( !(start <= 0) )
					out.println("<A HREF='../jsp/ReleaseLodgerLookupResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&nursing_unit_code="+nursing_unit_code+"&from_date="+from_date+"&to_date="+to_date+"&patient_id="+patient_id+"&name="+name+"&gender="+gender+"&PageValue="+ResultPageName+" '" +
					" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

				if (endOfRes==1 )
					out.println("<A id='nextval' HREF='../jsp/ReleaseLodgerLookupResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&nursing_unit_code="+nursing_unit_code+"&from_date="+from_date+"&to_date="+to_date+"&patient_id="+patient_id+"&name="+name+"&gender="+gender+"&PageValue="+ResultPageName+" '"
					+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
					out.println("</td></tr></table></p>");
					out.println("<br><br>");

		
		
		out.println("<table width='100%' cellspacing=0 cellpadding=0 border=1>") ;
		out.println( "<tr>" ) ;
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPersonDetails.label","ip_labels")+"</th>" ) ;
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AccompanyingPersonName.label","ip_labels")+"</th>" ) ;
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.periodfrom.label","common_labels")+"</th>" ) ;
		out.println( "<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.periodto.label","common_labels")+"</th>" ) ;
		}

					z++;
					if(cname.equals("QRYEVENSMALL"))
						cname = "QRYODDSMALL" ;
					else
						cname = "QRYEVENSMALL" ;
												
						curr_nursing_unit_code= rs.getString("nursing_unit_short_desc")== null ? "&nbsp;": rs.getString("nursing_unit_short_desc");

						if( !prev_nursing_unit.equals(curr_nursing_unit_code)  || !newcategory .equals(prev_category) )
						{
							out.println ( "<tr><td class='CAGROUPHEADING' colspan='5'>"+ curr_nursing_unit_code +"</td></tr>" ) ;
						}

				out.println( "<tr>" ) ;
				out.println ( "<td class='"+cname+"' nowrap>");
				out.println(rs.getString("lodger_patient_id")==null ? "&nbsp; ": rs.getString("lodger_patient_id") +"</td>") ;
		
				out.println ( "<td class='"+cname+"' nowrap><a href =\"javascript:callPage('" + rs.getString("lodger_ref_no") + "', '"+ rs.getString("check_in_date_time") +"', '"+rs.getLong("patient_encounter_id")+"', '"+ rs.getString("attached_to_inpatient_yn") +"','"+ResultPageName+"','"+call_function+"','"+ rs.getString("nursing_unit_short_desc") +"','"+rs.getString("lodger_patient_id")+"')\">" +(rs.getString("lodger_name") == null ? " &nbsp;" : rs.getString("lodger_name"))+"</a></td>") ;

				String period_from_date_display = rs.getString("PERIOD_FROM_DATE");
					if(period_from_date_display == null)
						period_from_date_display = "";
					else
						period_from_date_display = DateUtils.convertDate(period_from_date_display,"DMYHM","en",locale);
				
				out.println ( "<td class='"+cname+"' nowrap> "+period_from_date_display+"</td>" ) ;
				
				String period_to_date_display = rs.getString("PERIOD_TO_DATE");
					if(period_to_date_display == null)
						period_to_date_display = "";
					else
						period_to_date_display = DateUtils.convertDate(period_to_date_display,"DMYHM","en",locale);
				out.println ( "<td class='"+cname+"' nowrap> "+period_to_date_display+"</td>" ) ;
	 
				out.println( "</tr>" ) ;
				prev_nursing_unit =curr_nursing_unit_code ;
				prev_category =  rs.getString("Accom_categ") ;
				if(prev_category.equals("Y"))
				{ 
				  prev_category = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.Attendant.label","ip_labels");
				}else{
				  prev_category = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Lodger.label","common_labels");
				}
				p_max_record++;
				cnt++;
			}
			%>

		<script>				
			if (parseInt('<%=p_max_record%>') == 0)
			{
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
				parent.frames[2].document.location.href='../../eCommon/html/blank.html';
			}
		</script>
	<%   out.println("</table>");

			if( !rs.next() && cnt!=0 )
			{
				endOfRes=0;
			%>
			<script>
				document.getElementById('nextval').innerHTML = " ";
			</script>
			<%
			}

        }catch(Exception e) 
		{ 
			out.println(e.toString());
		}
		finally 
		{
			if (rs != null)			rs.close();  
			if (stmt != null)		stmt.close();
			if(Cs_Leave != null)	Cs_Leave.close();	out.print("<script>parent.frames[1].document.forms[0].disabled=false</script>");
		}
    %>
			<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value="<%=nursing_unit_code%>" >
			<input type='hidden' name='from_date' id='from_date' value="<%=from_date%>" >
			<input type='hidden' name='to_date' id='to_date' value="<%=to_date%>" >
			<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>" >
			<input type='hidden' name='name' id='name' value="<%=name%>" >
			<input type='hidden' name='gender' id='gender' value="<%=gender%>" >
		</form>
    </body>
<%	}catch(Exception e){out.println(e);}
    finally
	{
        ConnectionManager.returnConnection(con,request);
    }    
}// E.o if(ResultPageName.equals("GatePass"))
%>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

