<!DOCTYPE html>
<HTML>
<%@ page contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
	String locale				= (String)session.getAttribute("LOCALE");
	String sStyle				= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

<jsp:useBean id="releaseBedDetail" class="webbeans.eCommon.RecordSet" scope="session"/> 

<%@ include file="ForSplChars.jsp" %>
<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eIP/js/ReleaseBed.js' language='javascript'></script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>

<%
	String	 facilityId			= (String) session.getValue( "facility_id" ) ;
	String	 call_function		= checkForNull(request.getParameter("call_function"));
	
%>
<script language=javascript>

async function OnRemarks(bookingtype,bedbookingrefno)
{		
	var retVal1;
	var calling_from			= 'ReleaseBedDetail';
	var arguments				= "";
	var facilityid				= '<%=facilityId%>';
	var dialogHeight			= "10" ;
	var dialogWidth				= "50" ;
	var dialogTop				= "230";
	var dialogLeft				= "230";
		var features			= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;
	retVal1						= await window.showModalDialog("../../eIP/jsp/remarks.jsp?remarks="+calling_from+"&facilityid="+facilityid+"&bookrefno="+bedbookingrefno+"&booking_type="+bookingtype,arguments,features);
}

</script>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
</link>
</head>
<BODY  class='CONTENT' onMouseDown='CodeArrest()' OnKeyDown='CodeArrest();lockKey()'  >
<%
	Connection con				= null ;
	ResultSet rset				= null ;
	PreparedStatement pstmt=null;
	con							= ConnectionManager.getConnection(request);
	String P_nursingunitcode	= checkForNull(request.getParameter("nursing_unit_code"));
	String P_bedclasscode		= checkForNull(request.getParameter("bed_class_code"));
	String P_bookingtype		= checkForNull(request.getParameter("booking_type"));
	String P_blocktype			= checkForNull(request.getParameter("block_type"));
	String P_fromdate			= checkForNull(request.getParameter("from_date"));
	String P_untildate			= checkForNull(request.getParameter("until_date"));
	String reserve_bed_on_tfr_yn= checkForNull(request.getParameter("reserve_bed_on_tfr_yn"));
	String reservebed_yn		= checkForNull(request.getParameter("reservebedyn"));
	String select_bed			= checkForNull(request.getParameter("select_bed"));
	String bl_operational		= (String)session.getValue("bl_operational");
	P_nursingunitcode			= singleToDoubleQuotes(P_nursingunitcode);
	P_bedclasscode				= singleToDoubleQuotes(P_bedclasscode);
	P_bookingtype				= singleToDoubleQuotes(P_bookingtype);
	P_blocktype					= singleToDoubleQuotes(P_blocktype);
	String and_or_or			= " and ";
	StringBuffer sqlSb			= new StringBuffer();


	
	//sqlSb.append(" and facility_id='"+facilityId+"' and blocked_from_date_time <= SYSDATE ");
	/*Thursday, December 16, 2010 , SRR20056-SCF-6224 [IN:025500]*/
	sqlSb.append(" and facility_id='"+facilityId+"' ");

	if(!(P_nursingunitcode == null  || P_nursingunitcode.equals("")))
		sqlSb.append( " and req_nursing_unit_code = '"+P_nursingunitcode+"' ");

	if(!(P_bedclasscode == null  || P_bedclasscode.equals("")))
		sqlSb.append(" and req_bed_class_code = '"+P_bedclasscode+"' ");

	if(!(P_bookingtype == null  || P_bookingtype.equals("")))
	{
		//if(P_bookingtype.equals("T") && reservebed_yn.equals("Y"))
		/*5/5/2009 IN010339 SRR20056-SCF-2975*/
		if(P_bookingtype.equals("T") &&   (select_bed.equals("R") || select_bed.equals("A")))
			sqlSb.append( " and booking_type in ('N','T') ");
		else
			sqlSb.append( " and booking_type = '"+P_bookingtype+"' ");
	}

	if(!(P_blocktype == null  || P_blocktype.equals("")))
		sqlSb.append( " and blocking_type_code = '"+P_blocktype+"' ");

	if(!(P_fromdate == null  || P_fromdate.equals("")))
	{
		sqlSb.append( " and ( trunc(blocked_from_date_time) >= to_date('"+P_fromdate+"','dd/mm/rrrr')   ");
		/*Thursday, December 16, 2010 , SRR20056-SCF-6224 [IN:025500]*/
		sqlSb.append(" OR TO_DATE('"+P_fromdate+"', 'dd/mm/rrrr') BETWEEN TRUNC(blocked_from_date_time) AND TRUNC(blocked_until_date_time))");
			and_or_or=" and ";
	}

	if(!(P_untildate == null  || P_untildate.equals("")))
	{
		sqlSb.append( and_or_or+"  ( trunc(blocked_until_date_time) <= to_date('"+P_untildate+"','dd/mm/rrrr')   ");
		/*Thursday, December 16, 2010 , SRR20056-SCF-6224 [IN:025500]*/
		 sqlSb.append(" OR TO_DATE('"+P_untildate+"', 'dd/mm/rrrr') BETWEEN TRUNC(blocked_from_date_time) AND TRUNC(blocked_until_date_time))");
	}
		
	/*FS102IPSRRCRF0228V2.0 SCR-228 */	
		if(select_bed.equals("B"))
			{
				sqlSb.append("and booking_status = '0' and blocked_until_date_time > sysdate");
				/*Modified for IP-ICN-6903_Reopen*/
				sqlSb.append(" and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy')) > sysdate  ");
				/**/
				
			}else if(select_bed.equals("R"))
			{
				sqlSb.append(" and booking_status = '1'");
				sqlSb.append(" and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy')) > sysdate  ");
				
			}else if(select_bed.equals("A"))
			{
				sqlSb.append("and booking_status IN ('0','1') ");
				sqlSb.append(" and nvl(blocked_until_date_time,to_date('01/01/9999','dd/mm/yyyy')) > sysdate  ");
			}
			

%>

<form name="ReleaseBedDetail_Form" id="ReleaseBedDetail_Form" method='post' >

<%
		String	req_start		= ""; 
		String  req_end			= "";
		String  checkedOnes		= "";
		String	from			= request.getParameter("from") ;
		String	to				= request.getParameter("to") ;
		int		start			= 0;
		int		end				= 0;
		int		i				= 1;
		int		initCount		= 1;
		int		records_to_show	= 12;

		String reserved_bed_charged="";

        if (from == null)
			{ start = 1 ; }  
		else
			{  start = Integer.parseInt( from ) ; }

        if (to == null)
			{ end = 12 ; }
		else 
			{  end = Integer.parseInt( to ) ; }

        req_start				=   checkForNull(request.getParameter("start"),"0");
        req_end					=   checkForNull(request.getParameter("end"),"0");
			

		String classValue		= "" ;
		String next				= "";
		String prev				= "";
		
		try
		{
			String flagSelect	= checkForNull(request.getParameter("fromSelect"));
			        
			if(!flagSelect.equals(""))
				releaseBedDetail.clearAll();
		
			if(from != null && to != null)
			{
				int j			= 0;
				for( i=(Integer.parseInt(req_start)); i<= (Integer.parseInt(req_end)); i++)
				{
					if(request.getParameter("select_"+(i)) != null)
					{
						checkedOnes = request.getParameter("select_"+(i));
						if(!(releaseBedDetail.containsObject(checkedOnes)))
							releaseBedDetail.putObject(checkedOnes);

						j++;
					}
				}%>
		           <input type=hidden name='pages' id='pages' value='multiple'>
		           <input type=hidden name='totChecked' id='totChecked' value='<%=j%>'>
       <% }
        		i = 1 ;

		StringBuffer sql_count = new StringBuffer();
//		stmt					= con.createStatement(); Commented On 6/1/2010 for PE
		if (sql_count.length() > 0){ 
			sql_count.delete(0,sql_count.length());
		}
		
		sql_count.append(" SELECT " ); 
		sql_count.append("	 a.PATIENT_ID");
		sql_count.append("  ,decode(?,?,b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name");
		sql_count.append("  ,ENCOUNTER_ID " );
		sql_count.append("  ,req_bed_no " );
		sql_count.append("  ,req_room_no " );
		sql_count.append("  ,IP_GET_DESC.IP_BED_CLASS(REQ_BED_CLASS_CODE,?,'2') bed_class_desc ");
		sql_count.append("  ,IP_GET_DESC.IP_BLOCKING_TYPE(BLOCKING_TYPE_CODE,?,'2') blocking_type_desc ");
		sql_count.append("  ,TO_CHAR(blocked_from_date_time,'dd/mm/rrrr hh24:mi') blocked_from_date_time ");
		sql_count.append("  ,TO_CHAR(blocked_until_date_time,'dd/mm/rrrr hh24:mi') blocked_until_date_time ");
		sql_count.append("  ,blocking_remarks ");
		sql_count.append("  ,blocking_type_code ");
		sql_count.append("  ,bed_booking_ref_no ");
		sql_count.append("  ,booking_type ");
		sql_count.append("  ,req_bed_type_code ");
		sql_count.append("  ,req_nursing_unit_code ");
		sql_count.append("  ,IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, REQ_NURSING_UNIT_CODE,?,'2') nursing_unit_desc, sm_get_desc.sm_appl_user (a.modified_by_id,'en',1)blocked_by ");
/*FS102IPSRRCRF0228V2.0 SCR-228 */
		if(bl_operational.equals("Y")){
			sql_count.append("  ,BLCORE.RESERVED_BED_CHARGED(a.facility_id,a.patient_id,'I',a.encounter_id,(select srl_no from ip_reserved_bed_dtl where encounter_id = a.encounter_id AND facility_id = a.facility_id and reserved_nursing_unit_code = a.req_nursing_unit_code and reserved_bed_no = a.req_bed_no and reserved_to_time is null ),a.req_bed_type_code) reserved_bed_charged ");
		}
		sql_count.append(" FROM ");
		sql_count.append("  IP_BED_BOOKING a,MP_PATIENT b ");
		sql_count.append(" WHERE a.PATIENT_ID=b.PATIENT_ID(+)  and booking_type IN ('B','D','T','N') "+sqlSb.toString()+"  ");
		sql_count.append(" order by ");
		sql_count.append("  nursing_unit_desc ");
		sql_count.append("  , req_bed_no ");
//out.println(""+sql_count.toString());
		pstmt = con.prepareStatement(sql_count.toString());
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,locale);
		rset = pstmt.executeQuery();

		if ( start != 0 )
		{
			for( int j=1; j<start; i++,j++ )
			{
				rset.next() ;
			}
			initCount+=start;
			--initCount;
		}

		int z=0;
		int maxRecord = 0;
		while((z < records_to_show) && rset.next() ){
				if(maxRecord==0) {%>
						<table width='100%'>
								<tr>
									<table border='0' align='right'>
										<tr>
											<%
											if ( !(start <= 1))
											//{
											out.println("<td align='right' id='prev' width='100%'><a href='../../eIP/jsp/ReleaseBedDetail.jsp?from="+(start-12)+"&to="+(end-12)+"&select_bed="+select_bed+"&call_function="+call_function+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a></td>");
											//}else{
											out.println("<td align='right' id='next' style='visibility:hidden' ><a id = 'nextval' href='../../eIP/jsp/ReleaseBedDetail.jsp?from="+(start+12)+"&to="+(end+12)+"&select_bed="+select_bed+"&call_function="+call_function+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a></td>");
											//}
											%>
										</tr>
									</table>
								</tr>
						</table>
						<br>
						<br>
						<table border="1" width="99%" cellspacing='0' cellpadding='0' align="center">
							<th nowrap><fmt:message key="Common.bedstatus.label" bundle="${common_labels}"/>&nbsp;</th>
							<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</th>
							<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</th>
							<th nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;</th>
							<th nowrap><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>&nbsp;</th>
							<th nowrap><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/>&nbsp;</th>
							<th nowrap><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/>&nbsp;</th>
							<th nowrap><fmt:message key="eIP.BlockType.label" bundle="${ip_labels}"/>/<fmt:message key="eIP.ReasonforReserveBed.label" bundle="${ip_labels}"/>&nbsp;</th>
							<th nowrap><fmt:message key="eIP.BlockedThrough.label" bundle="${ip_labels}"/>&nbsp;</th>
							<th nowrap><fmt:message key="eIP.BlockedFrom.label" bundle="${ip_labels}"/>&nbsp;</th>
							<th nowrap><fmt:message key="Common.blockeduntil.label" bundle="${common_labels}"/>&nbsp;</th>
							<th nowrap><fmt:message key="eIP.BlockedBy.label" bundle="${ip_labels}"/>&nbsp;</th>
							<th nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</th> <!--added by Mano aganist ML-MMOH-CRF-01052-->
							<%if(!call_function .equals("QBB") ){%>
								<th nowrap><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
							<%}
				}
							String chkAttribute	=	"";
							z++;
							if ( i % 2 == 0 ){
								classValue	= "QRYEVENSMALL" ;
							}else{
								classValue	= "QRYODDSMALL" ;
							}
							String patientid				= checkForNull(rset.getString("PATIENT_ID"),"&nbsp;");
							String patientname		= checkForNull(rset.getString("patient_name"),"&nbsp;");
							String encounterid			= checkForNull(rset.getString("ENCOUNTER_ID"),"&nbsp;");
							String encounterid_select		= checkForNull(rset.getString("ENCOUNTER_ID"),"null");
							String reqbedno			= checkForNull(rset.getString("req_bed_no"));     
							String reqroomno			= checkForNull(rset.getString("req_room_no"));     
							String reqnursingunitcode	= checkForNull(rset.getString("req_nursing_unit_code"));     
							String bedclassdesc			= checkForNull(rset.getString("bed_class_desc"));
							String blockingtypedesc	= checkForNull(rset.getString("blocking_type_desc"),"&nbsp;");
							String blockedfromdatetime	= checkForNull(rset.getString("blocked_from_date_time"));     
							String blockeduntildatetime	= checkForNull(rset.getString("blocked_until_date_time"));     
							String blockingremarks			= checkForNull(rset.getString("blocking_remarks"));
							String bedbookingrefno			= checkForNull(rset.getString("bed_booking_ref_no"));
							String bookingtypedesc			= checkForNull(rset.getString("booking_type"),"&nbsp");
							//String req_bed_type_code		= checkForNull(rset.getString("req_bed_type_code"),"");
							/*FS102IPSRRCRF0228V2.0 SCR-228 */
							String blockedby             = checkForNull(rset.getString("blocked_by"),""); /* added by Mano aganist ML-MMOH-CRF-01052 */
							if(bl_operational.equals("Y")){
								reserved_bed_charged            = checkForNull(rset.getString("RESERVED_BED_CHARGED"),"");
							}
							if(bookingtypedesc.equals("N")){
								select_bed	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reserved.label","common_labels");
							}else {
								select_bed	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.blocked.label","common_labels");
							}
							if(bookingtypedesc.equalsIgnoreCase("D")){
								bookingtypedesc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeFunction.label","ip_labels");
							}else if(bookingtypedesc.equalsIgnoreCase("T")){
								bookingtypedesc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferFunction.label","ip_labels");
							}else if(bookingtypedesc.equalsIgnoreCase("B")){
								bookingtypedesc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BlockingFunction.label","ip_labels");
							}else if(bookingtypedesc.equalsIgnoreCase("N")){
								bookingtypedesc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferFunction.label","ip_labels");
							}else if(bookingtypedesc.equalsIgnoreCase("L")){
								bookingtypedesc	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TransferFunction.label","ip_labels");
							}
							String bookingtype		= checkForNull(rset.getString("booking_type")); 
							String nursingunitdesc	= checkForNull(rset.getString("nursing_unit_desc"));
							String selectvalue			= bookingtype+"`"+bedbookingrefno+"`"+encounterid_select+"`"+reqbedno+"`"+reqnursingunitcode;
							next								= nursingunitdesc;
							String blok_date_fr_display		= checkForNull(DateUtils.convertDate(blockedfromdatetime,"DMYHM","en",locale),"&nbsp;");
							String blok_date_until_display	= checkForNull(DateUtils.convertDate(blockeduntildatetime,"DMYHM","en",locale),"&nbsp;");
							if(blockeduntildatetime==null || blockeduntildatetime.equals("")){
								blok_date_until_display		= "&nbsp;";
							}
							if(releaseBedDetail.containsObject(selectvalue)){
								chkAttribute		= "CHECKED";
							}else{
								chkAttribute		= "";
							}
							int recordIndex		= releaseBedDetail.indexOfObject(selectvalue);
							if(recordIndex!=-1)
							if(chkAttribute.equals("CHECKED"))   
							releaseBedDetail.removeObject(recordIndex);
							if(!next.equals(prev) && reserve_bed_on_tfr_yn .equals("Y") ) {%>
								<tr><td class='CAGROUPHEADING' colspan=13><%=next%></td></tr>
							<%}else if(!next.equals(prev)){%>
								<tr><td class='CAGROUPHEADING' colspan=12><%=next%></td></tr>
							<% }%>
							<tr>
								<td class='<%=classValue %>' nowrap><%=select_bed%></td>
								<td class='<%=classValue %>' nowrap><%=patientid%></td>
								<td class='<%=classValue %>' nowrap><%=patientname%></td>
								<td class='<%=classValue %>' nowrap><%=encounterid%></td>
								<td class='<%=classValue%>' nowrap><%=reqbedno%></td>
								<td class='<%=classValue%>' nowrap><%=reqroomno%></td>
								<td class='<%=classValue %>' nowrap><%=bedclassdesc%></td>
								<td class='<%=classValue%>' nowrap><%=blockingtypedesc%></td>
								<td class='<%=classValue %>' nowrap><%=bookingtypedesc%></td>
								<td class='<%=classValue%>' nowrap><%=blok_date_fr_display%></td>
								<td class='<%=classValue%>' nowrap><%=blok_date_until_display%></td>
								<td class='<%=classValue%>' nowrap><%=blockedby%></td> <!--added by Mano aganist ML-MMOH-CRF-01052-->
								<%  
								//	if(!blockingremarks.equals("")){ Commented and added below code for IN023630 on 03.08.2010 by Suresh M
									if(!blockingremarks.equals("") && !select_bed.equals("Reserved")){%>
									<td class='<%=classValue %>' nowrap>
									<a href="javascript:OnRemarks('<%=bookingtype%>','<%=bedbookingrefno%>')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></td>
								<%}else{%>
									<td class='<%=classValue %>' nowrap>&nbsp;
									<!--<td class='<%=classValue %>' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> this line comment for 17874 Tuesday, January 05, 2010-->
								<%}
								if(!call_function .equals("QBB") ){ 	//if(!blockeduntildatetime.equals("")){
									if(select_bed.equals(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.blocked.label","common_labels"))){%>
										<td align='center' class='<%=classValue %>' nowrap><input type='checkbox'  <%=chkAttribute%> name='select_<%=i%>' value='<%=selectvalue%>'></td>
									<%}else if((!reserved_bed_charged.equals(""))||(!reserved_bed_charged.equals("null"))){%>
										<td align='center' class='<%=classValue %>' nowrap><input type='checkbox'   <%=chkAttribute%> name='select_<%=i%>' value='<%=selectvalue%>' onclick="checkbill(this,'<%=reserved_bed_charged%>')"></td>
									<%}else{%>
										<td align='center' class='<%=classValue %>' nowrap><input type='checkbox'  <%=chkAttribute%> name='select_<%=i%>' value='<%=selectvalue%>'></td>
								<%}}%>
							</tr>
				<%
				prev = next;
				i++;
				maxRecord++;
			}//endwhile
			%>
			</table>
		  <%//}
			if(maxRecord<12 || (!rset.next()))
			{%>
				<script >
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='hidden';
				</script>



			<%}
			else
			{%>
				<script>
					if (document.getElementById("next"))
						document.getElementById("next").style.visibility='visible';
				</script>
			<%}

			if(maxRecord==0)
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");

		}catch(Exception e){
			e.printStackTrace();
		}	
		finally {
			    try{
					if(pstmt!=null) pstmt.close();
					if(rset!=null) 	rset.close();
					
				}catch(Exception e){}
				ConnectionManager.returnConnection(con,request);
				session.setAttribute("releaseBedDetail", releaseBedDetail);
				out.print("<script>parent.frames[0].document.forms[0].search.disabled=false</script>");
		}
	%>
		<input type=hidden name=from value='<%=start%>'>
		<input type=hidden name=to value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
		<input type="hidden" name="no_of_rec" id="no_of_rec" value="<%=i%>">
		<input type="hidden" name="final_vals" id="final_vals" value="">
		<input type="hidden" name="sel_rec" id="sel_rec" value="">
		<input type=hidden name='nursing_unit_code' id='nursing_unit_code' value="<%=P_nursingunitcode%>">
		<input type=hidden name='booking_type' id='booking_type' value="<%=P_bookingtype%>">
		<input type=hidden name='block_type' id='block_type' value="<%=P_blocktype%>">
		<input type=hidden name='from_date' id='from_date' value="<%=P_fromdate%>">
		<input type=hidden name='until_date' id='until_date' value="<%=P_untildate%>">
		<input type=hidden name='call_function' id='call_function' value="<%=call_function%>">
		<input type=hidden name='bed_class_code' id='bed_class_code' value="<%=P_bedclasscode%>">
		<input type=hidden name='reservebedyn' id='reservebedyn' value="<%=reservebed_yn%>">		
		<input type='hidden' name = 'locale' value="<%=locale%>">  
		<input type='hidden' name = 'select_bed' value="<%=select_bed%>">  
</form>
</BODY>
</HTML>
<%!	
	private String checkForNull(String inputString){
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString,String defaultVal)	{
		return (inputString==null)	?	defaultVal	:	inputString;
	}
%>

