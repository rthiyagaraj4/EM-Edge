<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>
<%
request.setCharacterEncoding("UTF-8");
Connection conn=null;
ResultSet rs1=null;
ResultSet rs2=null;
Statement stmt=null;

String locale = (String)session.getAttribute("LOCALE");

String fac_id		= (String) session.getValue( "facility_id" ) ;
String patient_id=request.getParameter("patient_id");
String patientname=request.getParameter("patientname");
String inviteddate=request.getParameter("inviteddate");
String waitlistnum=request.getParameter("waitlistnum");

inviteddate=DateUtils.convertDate(inviteddate,"DMY",locale,"en");


if (!patientname.equals(""))
	{
		patientname		= 	patientname + "%" ;
	}
String Reason_for_modify="";
String OLD_PREFERRED_DATE_TIME="";
String OLD_LOCN_CODE="";
String OLD_RESOURCE_CLASS="";
String OLD_RESOURCE_ID="";
String OLD_ORDER_CATALOG_CODE="";
String OLD_WAITLIST_CATEGORY_DESC="";
String NEW_PREFERRED_DATE_TIME="";
String NEW_LOCN_CODE="";
String NEW_RESOURCE_CLASS="";
String NEW_RESOURCE_ID="";
String NEW_RESOURCE_DESC="";
String OLD_RESOURCE_DESC="";
String NEW_LOCN_DESC="";
String OLD_LOCN_DESC="";
String NEW_ORDER_CATALOG_CODE="";
String NEW_WAITLIST_CATEGORY_DESC="";
String OLD_WAITLIST_CATEGORY_CODE="";
String NEW_WAITLIST_CATEGORY_CODE="";
String NEW_ORDER_CATALOG_DESC="";
String OLD_ORDER_CATALOG_DESC="";
String classValue="";
String WAIT_LIST_NO1="";
StringBuffer sql1=new StringBuffer("" );
StringBuffer sqlStr=new StringBuffer("");
StringBuffer sqlstr1 = new StringBuffer("");
int maxrecord=0;
int i=0;


try {
	conn = ConnectionManager.getConnection(request);
	stmt=conn.createStatement();



		String install_yn_val="";	

				String sql_OR="select Operational_yn from sm_modules_facility where facility_id = '"+fac_id+"' and module_id = 'OR' ";
				rs2=stmt.executeQuery(sql_OR);
					if(rs2 !=null )
					{
						while (rs2.next())
						{
						install_yn_val=rs2.getString("Operational_yn");
						}

					}
			if(rs2 !=null)rs2.close();



	%>
	<HTML>
	<head>
	<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
	<script src="../../eOA/js/QueryWaitListAudit.js"></script>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()' onscroll="scrollheader()" >
	<form name='QueryWaitListResult' id='QueryWaitListResult'>
	<%
		

	
	if(!waitlistnum.equals(""))
		{
			sql1.append(" and b.wait_list_no='"+waitlistnum+"'");
		}
		if(!patientname.equals(""))
		{
			
			if(locale.equals("en"))
			{
			sql1.append(" and UPPER(a.PATIENT_NAME) like upper('"+patientname+"%')"); 
			}else if(locale.equals("th"))
			{
			sql1.append(" and UPPER(a.PATIENT_NAME_LOC_LANG) like upper('"+patientname+"%')"); 
			}
		}
		if(!inviteddate.equals(""))
		{
			sql1.append(" and to_char(a.INVITED_DATE_TIME,'dd/mm/yyyy')='"+inviteddate+"'");
		}
		if(!patient_id.equals(""))
		{
			sql1.append(" and a.PATIENT_ID='"+patient_id+"'");
		}
		sql1.append("order by b.ADDED_DATE desc");

	
	 
			sqlStr.append("select b.WAIT_LIST_NO,a.PATIENT_ID ");
	
		if(locale.equals("en"))
	{
		sqlStr.append(", a.patient_name");
	}else if(locale.equals("th"))
	{
		sqlStr.append(", a.PATIENT_NAME_LOC_LANG");
	}
		sqlStr.append(",a.INVITED_DATE_TIME,AM_GET_DESC.AM_CONTACT_REASON(a.REASON_FOR_MODIFY,'"+locale+"','1')  REASON_FOR_MODIFY ,b.ADDED_BY_ID, to_char(b.ADDED_DATE,'dd/mm/yyyy hh24:mi')ADDED_DATE ,to_char(b.OLD_PREFERRED_DATE_TIME,'dd/mm/yyyy')OLD_PREFERRED_DATE_TIME , b.OLD_LOCN_CODE, b.old_resource_class, b.OLD_RESOURCE_ID,b.OLD_ORDER_CATALOG_CODE, b.OLD_WAITLIST_CATEGORY_CODE, to_char(b.NEW_PREFERRED_DATE_TIME,'dd/mm/yyyy')NEW_PREFERRED_DATE_TIME, b.NEW_LOCN_CODE,  b.NEW_RESOURCE_CLASS , b.NEW_RESOURCE_ID, b.NEW_ORDER_CATALOG_CODE, b.NEW_WAITLIST_CATEGORY_CODE ,	decode(a.CARE_LOCN_TYPE_IND,'N', (case when b.old_locn_code is not null then (IP_GET_DESC.IP_NURSING_UNIT('"+fac_id+"', b.old_locn_code,'"+locale+"','2')) end),(case when b.old_locn_code is not null then(OP_GET_DESC.OP_CLINIC('"+fac_id+"', b.old_locn_code, '"+locale+"','2')) end)) old_locn_desc,decode(a.CARE_LOCN_TYPE_IND,'N', (case when b.new_locn_code is not null then (IP_GET_DESC.IP_NURSING_UNIT('"+fac_id+"', b.new_locn_code,'"+locale+"','2'))end),(case when b.new_locn_code is not null then (OP_GET_DESC.OP_CLINIC('"+fac_id+"', b.new_locn_code, '"+locale+"','2')) end)) new_locn_desc,(case when b.OLD_WAITLIST_CATEGORY_CODE is not null then  (OA_GET_DESC.OA_WAITLIST_CATEGORY(b.OLD_WAITLIST_CATEGORY_CODE , '"+locale+"','2')) end) waitlist,(case when b.NEW_WAITLIST_CATEGORY_CODE is not null then (OA_GET_DESC.OA_WAITLIST_CATEGORY(b.NEW_WAITLIST_CATEGORY_CODE , '"+locale+"','2')) end) waitlistnew,(case when b.new_resource_id is not null then decode(a.RESOURCE_CLASS,'P',(am_get_desc.am_practitioner(b.new_resource_id,'"+locale+"',1)),'R',(AM_GET_DESC.AM_FACILITY_ROOM('"+fac_id+"', b.new_resource_id,'"+locale+"','2')),'E', (AM_GET_DESC.AM_RESOURCE('"+fac_id+"', b.new_resource_id,'"+locale+"','2')))end) new_resource_id_name,(case when b.old_resource_id is not null then decode(a.RESOURCE_CLASS,'P',(am_get_desc.am_practitioner(b.old_resource_id,'"+locale+"',1)),'R',(AM_GET_DESC.AM_FACILITY_ROOM('"+fac_id+"', b.old_resource_id,'"+locale+"','2')),'E', (AM_GET_DESC.AM_RESOURCE('"+fac_id+"', b.old_resource_id,'"+locale+"','2')))end) old_resource_id_name");
		
		if(install_yn_val.equals("Y"))
		{
		sqlStr.append(",(CASE WHEN b.OLD_ORDER_CATALOG_CODE IS NOT NULL THEN (SELECT short_desc    FROM OR_ORDER_CATALOG_lang_vw WHERE ORDER_CATALOG_CODE =b.OLD_ORDER_CATALOG_CODE and language_id='"+locale+"') END ) ordercatalogold, (CASE WHEN b.NEW_ORDER_CATALOG_CODE IS NOT NULL THEN (SELECT short_desc FROM OR_ORDER_CATALOG_lang_vw   WHERE ORDER_CATALOG_CODE = b.NEW_ORDER_CATALOG_CODE and language_id='"+locale+"') END ) ordercatalognew ");
		}
		
		
		
		
		sqlStr.append("from pr_wait_list a,pr_wait_list_audit b where a.WAIT_LIST_NO=b.WAIT_LIST_NO and a.wait_list_no='"+waitlistnum+"'");
		sqlStr.append(sql1.toString()) ;
	//out.println(sqlStr);
		rs1=stmt.executeQuery(sqlStr.toString());
	
			if(rs1 !=null )
		{
			while(rs1.next())
			{
				if(maxrecord==0)
				{

	 
	 %>
		
		<div id='header' style="visibility:visible;backgroundColor:white;overflow:scroll;height:100vh;width:100vw">
			<table border="1" width="160%" cellspacing='0' cellpadding='0'>
			<tr>
			<td class='COLUMNHEADER'   colspan=5><fmt:message key="Common.OldValue.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'   colspan=5><fmt:message key="Common.NewValue.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'   colspan=3><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
			<td class='COLUMNHEADER' width='7%' nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.LocationDesc.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.resource.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='7%'nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.LocationDesc.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.resource.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>	
			<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='10%'><fmt:message key="eOA.ReasonForModify.label" bundle="${oa_labels}"/></td>
			<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.modifiedby.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='25%'><fmt:message key="eOA.ModifiedOn.label" bundle="${oa_labels}"/></td>
			</tr>
<% }
		
	/*	sqlStr.append("select b.WAIT_LIST_NO,a.PATIENT_ID ");
	
		if(locale.equals("en"))
	{
		sqlStr.append(", a.patient_name");
	}else if(locale.equals("th"))
	{
		sqlStr.append(", a.PATIENT_NAME_LOC_LANG");
	}
		sqlStr.append(",a.INVITED_DATE_TIME,AM_GET_DESC.AM_CONTACT_REASON(a.REASON_FOR_MODIFY,'"+locale+"','1')  REASON_FOR_MODIFY ,b.ADDED_BY_ID, to_char(b.ADDED_DATE,'dd/mm/yyyy hh24:mi')ADDED_DATE ,to_char(b.OLD_PREFERRED_DATE_TIME,'dd/mm/yyyy')OLD_PREFERRED_DATE_TIME , b.OLD_LOCN_CODE, b.old_resource_class, b.OLD_RESOURCE_ID,b.OLD_ORDER_CATALOG_CODE, b.OLD_WAITLIST_CATEGORY_CODE, to_char(b.NEW_PREFERRED_DATE_TIME,'dd/mm/yyyy')NEW_PREFERRED_DATE_TIME, b.NEW_LOCN_CODE,  b.NEW_RESOURCE_CLASS , b.NEW_RESOURCE_ID, b.NEW_ORDER_CATALOG_CODE, b.NEW_WAITLIST_CATEGORY_CODE ,	decode(a.CARE_LOCN_TYPE_IND,'N', (case when b.old_locn_code is not null then (IP_GET_DESC.IP_NURSING_UNIT('"+fac_id+"', b.old_locn_code,'"+locale+"','2')) end),(case when b.old_locn_code is not null then(OP_GET_DESC.OP_CLINIC('"+fac_id+"', b.old_locn_code, '"+locale+"','1')) end)) old_locn_desc,decode(a.CARE_LOCN_TYPE_IND,'N', (case when b.new_locn_code is not null then (IP_GET_DESC.IP_NURSING_UNIT('"+fac_id+"', b.new_locn_code,'"+locale+"','2'))end),(case when b.new_locn_code is not null then (OP_GET_DESC.OP_CLINIC('"+fac_id+"', b.new_locn_code, '"+locale+"','2')) end)) new_locn_desc,(case when b.OLD_WAITLIST_CATEGORY_CODE is not null then  (OA_GET_DESC.OA_WAITLIST_CATEGORY(b.OLD_WAITLIST_CATEGORY_CODE , '"+locale+"','2')) end) waitlist,(case when b.NEW_WAITLIST_CATEGORY_CODE is not null then (OA_GET_DESC.OA_WAITLIST_CATEGORY(b.NEW_WAITLIST_CATEGORY_CODE , '"+locale+"','2')) end) waitlistnew,(case when b.new_resource_id is not null then decode(a.RESOURCE_CLASS,'P',(am_get_desc.am_practitioner(b.new_resource_id,'"+locale+"',1)),'R',(AM_GET_DESC.AM_FACILITY_ROOM('"+fac_id+"', b.new_resource_id,'"+locale+"','2')),'E', (AM_GET_DESC.AM_RESOURCE('"+fac_id+"', b.new_resource_id,'"+locale+"','2')))end) new_resource_id_name,(case when b.old_resource_id is not null then decode(a.RESOURCE_CLASS,'P',(am_get_desc.am_practitioner(b.old_resource_id,'"+locale+"',1)),'R',(AM_GET_DESC.AM_FACILITY_ROOM('"+fac_id+"', b.old_resource_id,'"+locale+"','2')),'E', (AM_GET_DESC.AM_RESOURCE('"+fac_id+"', b.old_resource_id,'"+locale+"','2')))end) old_resource_id_name");
		
		if(install_yn_val.equals("Y"))
		{
		sqlStr.append(",(CASE WHEN b.OLD_ORDER_CATALOG_CODE IS NOT NULL THEN (SELECT short_desc    FROM OR_ORDER_CATALOG_lang_vw WHERE ORDER_CATALOG_CODE =b.OLD_ORDER_CATALOG_CODE and language_id='"+locale+"') END ) ordercatalogold, (CASE WHEN b.NEW_ORDER_CATALOG_CODE IS NOT NULL THEN (SELECT short_desc FROM OR_ORDER_CATALOG_lang_vw   WHERE ORDER_CATALOG_CODE = b.NEW_ORDER_CATALOG_CODE and language_id='"+locale+"') END ) ordercatalognew ");
		}
		
		
		
		
		sqlStr.append("from pr_wait_list a,pr_wait_list_audit b where a.WAIT_LIST_NO=b.WAIT_LIST_NO and a.wait_list_no='"+waitlistnum+"'");
		sqlStr.append(sql1.toString()) ;
	//out.println(sqlStr);
		rs1=stmt.executeQuery(sqlStr.toString()); */
		
	
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
				    classValue = "QRYODD" ;
		
			patient_id=rs1.getString("PATIENT_ID");
			if(patient_id==null)patient_id="";
			OLD_PREFERRED_DATE_TIME=rs1.getString("OLD_PREFERRED_DATE_TIME");
			if(OLD_PREFERRED_DATE_TIME ==null)OLD_PREFERRED_DATE_TIME="";

			String OLD_PREFERRED_DATE_TIME_DISP= DateUtils.convertDate(OLD_PREFERRED_DATE_TIME,"DMY","en",locale);

			NEW_PREFERRED_DATE_TIME=rs1.getString("NEW_PREFERRED_DATE_TIME");
			if(NEW_PREFERRED_DATE_TIME ==null)NEW_PREFERRED_DATE_TIME="";

			String NEW_PREFERRED_DATE_TIME_DISP= DateUtils.convertDate(NEW_PREFERRED_DATE_TIME,"DMY","en",locale);

			String ADDED_DATE= rs1.getString("ADDED_DATE");
			if(ADDED_DATE ==null)ADDED_DATE="";
			String ADDED_DATE_DISP= DateUtils.convertDate(ADDED_DATE,"DMYHM","en",locale);

			Reason_for_modify=rs1.getString("REASON_FOR_MODIFY");
			if(Reason_for_modify==null) Reason_for_modify="";
			//if(Reason_for_modify.length() >10)
			//Reason_for_modify=Reason_for_modify.substring(0,10);

			OLD_LOCN_CODE=rs1.getString("OLD_LOCN_CODE");
			if(OLD_LOCN_CODE ==null) OLD_LOCN_CODE="";
			NEW_LOCN_CODE=rs1.getString("NEW_LOCN_CODE");
			if(NEW_LOCN_CODE==null)NEW_LOCN_CODE="";

			OLD_LOCN_DESC=rs1.getString("old_locn_desc");
			if(OLD_LOCN_DESC==null) OLD_LOCN_DESC="";
			//if(OLD_LOCN_DESC.length() >10)
			//	OLD_LOCN_DESC=OLD_LOCN_DESC.substring(0,10);

			NEW_LOCN_DESC=rs1.getString("new_locn_desc");
			if(NEW_LOCN_DESC==null) NEW_LOCN_DESC="";
		//	if(NEW_LOCN_DESC.length() >10)
		//		NEW_LOCN_DESC=NEW_LOCN_DESC.substring(0,10);


			OLD_RESOURCE_ID=rs1.getString("OLD_RESOURCE_ID");
			if(OLD_RESOURCE_ID==null)OLD_RESOURCE_ID="";
			NEW_RESOURCE_ID=rs1.getString("NEW_RESOURCE_ID");
			if(NEW_RESOURCE_ID==null)NEW_RESOURCE_ID="";

			NEW_RESOURCE_CLASS=rs1.getString("NEW_RESOURCE_CLASS");
			if(NEW_RESOURCE_CLASS==null)NEW_RESOURCE_CLASS="";

			

			OLD_RESOURCE_CLASS=rs1.getString("OLD_RESOURCE_CLASS");
			if(OLD_RESOURCE_CLASS==null)OLD_RESOURCE_CLASS="";


			OLD_RESOURCE_DESC=rs1.getString("old_resource_id_name");
			if(OLD_RESOURCE_DESC ==null)OLD_RESOURCE_DESC="";

			
			if(OLD_RESOURCE_CLASS.equals("P"))
			{
				 OLD_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			 }
			 else if(OLD_RESOURCE_CLASS.equals("E"))
			{
				OLD_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			  }
			  else if(OLD_RESOURCE_CLASS.equals("R"))
			{
				OLD_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}
			else if(OLD_RESOURCE_CLASS.equals("O"))
			{
				OLD_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}


			//if(OLD_RESOURCE_DESC.length() >10)
			//	OLD_RESOURCE_DESC=OLD_RESOURCE_DESC.substring(0,10);

			NEW_RESOURCE_DESC=rs1.getString("new_resource_id_name");
			if(NEW_RESOURCE_DESC ==null)NEW_RESOURCE_DESC="";

			if(NEW_RESOURCE_CLASS.equals("P"))
			{
				 NEW_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			 }
			 else if(NEW_RESOURCE_CLASS.equals("E"))
			{
				NEW_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			  }
			  else if(NEW_RESOURCE_CLASS.equals("R"))
			{
				NEW_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}
			else if(NEW_RESOURCE_CLASS.equals("O"))
			{
				NEW_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}

			//if(NEW_RESOURCE_DESC.length() >10)
			//	NEW_RESOURCE_DESC=NEW_RESOURCE_DESC.substring(0,10);


			OLD_ORDER_CATALOG_CODE=rs1.getString("OLD_ORDER_CATALOG_CODE");
			if(OLD_ORDER_CATALOG_CODE==null)OLD_ORDER_CATALOG_CODE="";
			NEW_ORDER_CATALOG_CODE=rs1.getString("NEW_ORDER_CATALOG_CODE");
			if(NEW_ORDER_CATALOG_CODE==null)NEW_ORDER_CATALOG_CODE="";

			OLD_WAITLIST_CATEGORY_CODE=rs1.getString("OLD_WAITLIST_CATEGORY_CODE");
			if(OLD_WAITLIST_CATEGORY_CODE==null)OLD_WAITLIST_CATEGORY_CODE="";
			NEW_WAITLIST_CATEGORY_CODE=rs1.getString("NEW_WAITLIST_CATEGORY_CODE");
			if(NEW_WAITLIST_CATEGORY_CODE==null)NEW_WAITLIST_CATEGORY_CODE="";

			OLD_WAITLIST_CATEGORY_DESC=rs1.getString("waitlist");
			if(OLD_WAITLIST_CATEGORY_DESC==null)OLD_WAITLIST_CATEGORY_DESC="";
		//	if(OLD_WAITLIST_CATEGORY_DESC.length() > 10)
		//	OLD_WAITLIST_CATEGORY_DESC=OLD_WAITLIST_CATEGORY_DESC.substring(0,10);

			NEW_WAITLIST_CATEGORY_DESC=rs1.getString("waitlistnew");
			if(NEW_WAITLIST_CATEGORY_DESC==null)NEW_WAITLIST_CATEGORY_DESC="";
			// if(NEW_WAITLIST_CATEGORY_DESC.length() > 10)
			// NEW_WAITLIST_CATEGORY_DESC=NEW_WAITLIST_CATEGORY_DESC.substring(0,10);
			
			if(install_yn_val.equals("Y"))
		{
			OLD_ORDER_CATALOG_DESC=rs1.getString("ordercatalogold");
			if(OLD_ORDER_CATALOG_DESC==null)OLD_ORDER_CATALOG_DESC="";
			//if(OLD_ORDER_CATALOG_DESC.length() > 10)
			//OLD_ORDER_CATALOG_DESC=OLD_ORDER_CATALOG_DESC.substring(0,10);	

			NEW_ORDER_CATALOG_DESC=rs1.getString("ordercatalognew");
			if(NEW_ORDER_CATALOG_DESC==null)NEW_ORDER_CATALOG_DESC="";
			//if(NEW_ORDER_CATALOG_DESC.length() > 15)
			//NEW_ORDER_CATALOG_DESC=NEW_ORDER_CATALOG_DESC.substring(0,10);
		}

			WAIT_LIST_NO1=rs1.getString("WAIT_LIST_NO");
			if(WAIT_LIST_NO1==null)WAIT_LIST_NO1="";
			%>
			
				<tr>
					
					<td width='7%'  class='<%=classValue%>'><%=OLD_PREFERRED_DATE_TIME_DISP%>&nbsp;</td>
					
					<%if(OLD_LOCN_CODE.equals("")){%>
						<td width='7%'   class='<%=classValue%>'>&nbsp;</td>
					<%}else{%>
						<td width='7%'  class='<%=classValue%>' nowrap><%=OLD_LOCN_DESC%>&nbsp;</td>
					 <%}%>
					<%if(OLD_RESOURCE_CLASS.equals("")){%>
						<td width='7%'   class='<%=classValue%>'>&nbsp;</td>
					<%}else{%>
						<td width='7%'  class='<%=classValue%>' nowrap><%=OLD_RESOURCE_DESC%>&nbsp;</td>
					<%}%>
					<%if(OLD_WAITLIST_CATEGORY_CODE.equals("")){%>
						<td width='7%'   class='<%=classValue%>'>&nbsp;</td>
					<%}else{%>
						<td width='7%'   class='<%=classValue%>' nowrap><%=OLD_WAITLIST_CATEGORY_DESC%>&nbsp;</td>
					<%}%>
					<%if(OLD_ORDER_CATALOG_CODE.equals("")){%>
						<td  width='7%'   class='<%=classValue%>'>&nbsp;</td>
					<%}else{%>
						<td  width='7%'   class='<%=classValue%>'><%=OLD_ORDER_CATALOG_DESC%>&nbsp;</td>
					<%}%>
							
					<td width='7%'   class='<%=classValue%>' nowrap><%=NEW_PREFERRED_DATE_TIME_DISP%>&nbsp;</td>
					 
					 <%if(NEW_LOCN_CODE.equals("")){%>
						<td width='7%'   class='<%=classValue%>'>&nbsp;</td>
					 <%}else{%>
						<td width='7%'   class='<%=classValue%>' nowrap><%=NEW_LOCN_DESC%>&nbsp;</td>
					  <%}%>
					
					<%if(NEW_RESOURCE_CLASS.equals("")){%>
						<td width='7%'  class='<%=classValue%>'>&nbsp;</td>
					<%}else{%>
						<td width='7%'  class='<%=classValue%>'nowrap ><%=NEW_RESOURCE_DESC%>&nbsp;</td>
					<%}%>
					
							
					<%if(NEW_WAITLIST_CATEGORY_CODE.equals("")){%>
						<td width='7%'  class='<%=classValue%>'>&nbsp;</td>
					<%}else{%>
						<td width='7%'   class='<%=classValue%>' nowrap><%=NEW_WAITLIST_CATEGORY_DESC%>&nbsp;</td>
					<%}%>
					
				<%if(NEW_ORDER_CATALOG_CODE.equals("")){%>
						<td  width='7%'  class='<%=classValue%>' nowrap>&nbsp;</td>
					<%}else{%>
						<td  width='7%'   class='<%=classValue%>'><%=NEW_ORDER_CATALOG_DESC%>&nbsp;</td>
					<%}%>
					<td width='10%'   class='<%=classValue%>'><%=Reason_for_modify%>&nbsp;</td>
					<td width='8%'   class='<%=classValue%>'><%=rs1.getString("ADDED_BY_ID")%>&nbsp;</td>
					<td width='25%'   class='<%=classValue%>' ><%=ADDED_DATE_DISP%>&nbsp;</td>
				 </tr>
			
		
		<% i++;
		maxrecord++;
		}//end of while
		}

		if(maxrecord == 0)
		{%>
			<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); //history.go(-1);
				parent.frames[2].document.location.href="../../eCommon/html/blank.html";</script>
		<%}

	sqlstr1.setLength(0);
	sqlStr.setLength(0);
	sql1.setLength(0);
	if(stmt !=null)stmt.close();
	if(rs1 !=null)rs1.close();
}catch ( Exception e ){
	//out.println("Exception " +e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
	ConnectionManager.returnConnection(conn,request);
}
%>
</table></div>
</form>
</body>
</html>

