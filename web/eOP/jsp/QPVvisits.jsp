<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" 
contentType="text/html; charset=UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script Language="JavaScript" src='../js/QueryPatientVisits.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   
</head>

<%

	String Facility_Id = (String) session.getValue("facility_id");
	String patid=request.getParameter("patid");
	String mrnno=request.getParameter("mrnno");

	String dtfrm=request.getParameter("dtfrm");
	String dtto=request.getParameter("dtto");
	String serv=request.getParameter("serv");
	String loc=request.getParameter("loc");
	String locale = (String) session.getValue("LOCALE");
	String pract=request.getParameter("pract");
	String episode_id=request.getParameter("episode_id");
	String fr_epi_id=request.getParameter("fr_epi_id");
	String to_epi_id=request.getParameter("to_epi_id");
	String service_code = request.getParameter("service_code");
	String episode_status = request.getParameter("episode_status");
	String user_id = request.getParameter("user_id");
	//String episode_no = request.getParameter("episode_no");
	String speciality_id = request.getParameter("speciality_id");
	String fld2_display = "";
	if(mrnno==null) mrnno="";
	if(dtfrm==null) dtfrm="";
	if(dtto==null) dtto="";
	if(serv==null) serv="";
	if(loc==null) loc="";
	if(pract==null) pract="";
	if(episode_id==null) episode_id="";
	if(fr_epi_id==null) fr_epi_id="";
	if(to_epi_id==null) to_epi_id="";
	if(service_code==null)	service_code = "";
	if(episode_status==null)	episode_status = "";

	String visit_type_ind = "";
	String encounter_id="";
	StringBuffer where_criteria =new StringBuffer();
	StringBuffer row = new StringBuffer();
	String and_yn = "";
	Connection conn = null ;
	Statement stmt=null;
	ResultSet rset=null;

	
try
{
	
	conn  =  ConnectionManager.getConnection(request);
	stmt = conn.createStatement();

	boolean showCancelledVisits = eCommon.Common.CommonBean.isSiteSpecific(conn,"OP","INCLUDE_CANCELLED_VISITS");//Added by Thamizh selvi on 13th Feb 2017 against GDOH-CRF-0125
	
	StringBuffer sql =new StringBuffer();
	String FromDateTime = "";
	String ToDateTime = "";
	String extra_criteria = "";

		// patient_id 
		if (!patid.equals(""))
		{
			where_criteria.append( "patient_id = '"+patid+"'" );
			and_yn = " and ";
		}
		// MRN
		if (!mrnno.equals(""))
		{
			where_criteria.append( and_yn).append( " patient_id in(select patient_id from mr_pat_file_index  where facility_id='"+Facility_Id+"' and file_no ='"+mrnno+"')");
			and_yn = " and ";
		}
		// Date From
		if (!dtfrm.equals(""))
		{
			where_criteria.append(and_yn).append("trunc(queue_date) >= to_date('"+dtfrm+"','dd/mm/yyyy')");
			and_yn = " and ";
		}
		// To
		if (!dtto.equals(""))
		{
			where_criteria.append( and_yn).append("trunc(queue_date) <= to_date('"+dtto+"','dd/mm/yyyy')");
			and_yn = " and ";
		}
		// Service
		if (!serv.equals(""))
		{
			where_criteria.append( and_yn).append( "service_code ='"+ serv +"'" );
			and_yn      = " and ";
		}
		if (!service_code.equals(""))
		{
			where_criteria .append( and_yn).append( "service_code ='"+ service_code +"'");
			and_yn      = " and ";
		}
		// Clinic
		if (!loc.equals(""))
		{
			//where_criteria .append( and_yn).append( "assign_care_locn_code ='"+loc+"'");
			where_criteria .append( and_yn).append( "locn_code ='"+loc+"'");
			and_yn      = " and ";
		}
		// Practitioner
		if (!pract.equals(""))
		{
			where_criteria .append(and_yn ).append( "practitioner_id='"+pract+"'");
			and_yn      = " and ";
		}
		if (episode_id != null && !episode_id.equals(""))
		{
			where_criteria .append(and_yn).append( "episode_id = '"+episode_id+"' ");
			and_yn      = " and ";
		}

		if (fr_epi_id != null && !fr_epi_id.equals(""))
		{
			where_criteria .append(and_yn).append( "episode_id >= '"+fr_epi_id+"' ");
			and_yn      = " and ";
		}

		if (to_epi_id != null && !to_epi_id.equals(""))
		{
			where_criteria .append(and_yn).append( "episode_id < '"+to_epi_id+"' ");
			and_yn      = " and ";
		}

		if(speciality_id != null && !speciality_id.equals(""))
		{
			where_criteria .append(and_yn).append( "speciality_code='"+speciality_id+"'");
			and_yn      = " and ";
		}

		if(user_id != null && !user_id.equals(""))
		{
			where_criteria .append(and_yn).append( "ADDED_BY_ID='"+user_id+"'");
			and_yn      = " and ";
		}
		

	if(!service_code.equals(""))
	{
	
	sql.append( "Select to_char(queue_date,'dd/mm/yyyy hh24:mi') from_date,queue_date visit_adm_date_time " );
	sql.append(" from op_patient_queue  " );
	sql.append(" where facility_id = '"+Facility_Id+"' and patient_class='OP' ");
	sql.append(" and service_code = '"+service_code+"' and patient_id = '"+patid+"' ");
		

	if (fr_epi_id != null && !fr_epi_id.equals(""))
	{
		sql.append(" and episode_id >= '"+fr_epi_id+"' ");
	}

	if (to_epi_id != null && !to_epi_id.equals(""))
	{
		sql.append(" and episode_id < '"+to_epi_id+"' ");
	}

	sql.append(" order by queue_date " );
    rset = stmt.executeQuery(sql.toString());

	if(rset != null)
	{
		if(rset.next())
		{
			FromDateTime = rset.getString(1);
		}
	}
	if(FromDateTime == null)	FromDateTime = "";

	if(rset != null) rset.close();
	
	sql.setLength(0);

	sql.append( "Select to_char(queue_date,'dd/mm/yyyy hh24:mi') to_date,queue_date visit_adm_date_time " );
	sql.append( " from op_patient_queue  " );
	sql.append(" where facility_id = '"+Facility_Id+"' and patient_class ='OP' ");
	sql.append( " and service_code = '"+service_code+"' and patient_id = '"+patid+"' ");
	
	if (fr_epi_id != null && !fr_epi_id.equals(""))
	{
		sql.append(" and episode_id >= "+fr_epi_id+" ");
	}

	if (to_epi_id != null && !to_epi_id.equals(""))
	{
		sql.append(" and episode_id < "+to_epi_id+" ");
	}
	sql.append(" order by queue_date desc");

	rset = stmt.executeQuery(sql.toString());
	if(rset != null)
	{
		if(rset.next())
		{
			ToDateTime = rset.getString(1);
		}
	}

	if(ToDateTime == null)	ToDateTime = "";

	if(rset != null) rset.close();

	sql.setLength(0);
	
	if(!FromDateTime.equals(""))
		extra_criteria = " and TO_DATE(TO_CHAR(queue_date,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') between to_date('"+FromDateTime+"','dd/mm/yyyy hh24:mi') and to_date(nvl('"+ToDateTime+"',to_char(sysdate,'dd/mm/yyyy hh24:mi')),'dd/mm/yyyy hh24:mi') and service_code = '"+service_code+"' ";
	}
 
    /*sql.setLength(0);   
	int maxRecord = 0;
	
    sql.append("select count(*) as total from Pr_Search_visit_vw ");
    sql.append( "where facility_id = '"+Facility_Id+"' and nvl(level_of_care_ind,'XX') ='A' and ").append(where_criteria).append(extra_criteria);
	
	if (!episode_status.equals(""))
		sql.append( " and nvl(episode_status,'"+episode_status+"') = '"+episode_status+"'"); 
	
    rset = stmt.executeQuery(sql.toString());
	rset.next();
	maxRecord = rset.getInt("total");

	if(rset != null) rset.close();

	sql.setLength(0);
	
	if(maxRecord == 0)	
	{				
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	}else
	{*/
	try
	{
	 sql.setLength(0);
	
	/*Added by Thamizh selvi on 13th Feb 2017 against GDOH-CRF-0125 Start*/
	if(showCancelledVisits){

		sql.append("SELECT   patient_id, TO_CHAR(queue_date,'dd/mm/yyyy hh24:mi') adm_date_time, patient_class,			  am_get_desc.AM_SERVICE(service_code,'"+locale+"',2)service_short_desc, op_get_desc.OP_CLINIC(facility_id,LOCN_CODE, '"+locale+"',1)clinic_desc ,  op_get_desc.OP_VISIT_TYPE(facility_id,VISIT_TYPE_code,'"+locale+"',2)visit_type_desc,			  am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"',2) practitioner_name,		  am_get_desc.am_disposition_type(disposition_type,'"+locale+"',2)disposition_short_desc,  NVL(op_episode_visit_num,''),	 ENCOUNTER_ID, 'A' visit_type_ind,  queue_date,  CANCEL_REASON_CODE,am_get_desc.am_contact_reason(CANCEL_REASON_CODE,'"+locale+"',2)CANCEL_REASON_DESC,SPECIALITY_CODE,am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,'"+locale+"',2)  SPECIALITY_DESC,sm_get_desc.SM_APPL_USER(ADDED_BY_ID,'en',1) user_name  FROM 	  op_patient_queue	WHERE facility_id = '"+Facility_Id+"' AND ").append(where_criteria).append(extra_criteria);
		 
	}/*End*/


	else{

		sql.append("SELECT   patient_id, TO_CHAR(queue_date,'dd/mm/yyyy hh24:mi') adm_date_time, patient_class,			  am_get_desc.AM_SERVICE(service_code,'"+locale+"',2)service_short_desc, op_get_desc.OP_CLINIC(facility_id,LOCN_CODE, '"+locale+"',1)clinic_desc ,  op_get_desc.OP_VISIT_TYPE(facility_id,VISIT_TYPE_code,'"+locale+"',2)visit_type_desc,			  am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"',2) practitioner_name,		  am_get_desc.am_disposition_type(disposition_type,'"+locale+"',2)disposition_short_desc,  NVL(op_episode_visit_num,''),	 ENCOUNTER_ID, 'A' visit_type_ind,  queue_date,  CANCEL_REASON_CODE,am_get_desc.am_contact_reason(CANCEL_REASON_CODE,'"+locale+"',2)CANCEL_REASON_DESC,SPECIALITY_CODE,am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,'"+locale+"',2)  SPECIALITY_DESC,sm_get_desc.SM_APPL_USER(ADDED_BY_ID,'en',1) user_name  FROM 	  op_patient_queue	WHERE QUEUE_STATUS!='99' and facility_id = '"+Facility_Id+"' AND ").append(where_criteria).append(extra_criteria);

	}

    /*sql.append("select patient_id, to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') adm_date_time, ");
    sql.append("patient_class, service_short_desc, clinic_desc , visit_type_desc, practitioner_name, ");
    sql.append("disposition_short_desc, nvl(op_episode_visit_num,'') , ");
	sql.append(" ENCOUNTER_ID, level_of_care_ind visit_type_ind, visit_adm_date_time,CANCEL_REASON_CODE, CANCEL_REASON_DESC  ");
    sql.append( "from Pr_Search_visit_vw ");
    sql.append("where facility_id = '"+Facility_Id+"' and nvl(level_of_care_ind,'XX') ='A' and ").append(where_criteria).append(extra_criteria);*/
	
	if (!episode_status.equals(""))
		sql.append( " and nvl(episode_status,'"+episode_status+"') = '"+episode_status+"'"); 

    sql.append( " order by queue_date desc");
	
	rset = stmt.executeQuery(sql.toString());
	
	
//	if(rset.next())
//	{
		// rset.previous();	
%>
    
	
	<%

    String classValue = "";

    String fld1="";
    String fld2="";
    String fld3="";
    String fld4="";
    String fld5="";
    String fld6="";
    String fld7="";
    String fld8="";
    String fld9="";
	String cancelReasonCode="";//Added by Thamizh selvi on 13th Feb 2017 against GDOH-CRF-0125
	String user = "";

	

    int i = 0;
    //if(rset != null) 
	//{
		int count=0;
        while(rset.next())
        {if(count==0)
			{%>
			
			<body onLoad='callPline();' onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
    <form name="visittab_form" id="visittab_form" >
    <table border='0' cellpadding='0' cellspacing='0' width='95%' align='center'>
    <tr><td align='center'>
    <table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1'>
  
    <th class='columnheader' ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></th>
    <th class='columnheader' ><fmt:message key="Common.service.label" bundle="${common_labels}"/></th>
    <th class='columnheader' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
	<th class='columnheader' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
    <th class='columnheader' ><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></th>
    <th class='columnheader' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
    <th class='columnheader' ><fmt:message key="Common.Disposition.label" bundle="${common_labels}"/></th>
    <th class='columnheader'><fmt:message key="eOP.VisitNo.label" bundle="${op_labels}"/></th>

    <th class='columnheader'><fmt:message key="Common.Visit.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></th>
	
	<!--Added by Thamizh selvi on 13th Feb 2017 against GDOH-CRF-0125 Start-->
	<%if(showCancelledVisits){%>
		<th class='columnheader' ><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></th> 

			<%}/*End*/
			}
			count++;
			if ( i%2 == 0 )
                classValue="QRYEVEN";
            else
                classValue="QRYODD";

            fld1=rset.getString(1); if(fld1 == null) fld1="";
            fld2=rset.getString(2); if(fld2 == null) fld2="";

			fld2_display=DateUtils.convertDate(fld2,"DMYHM","en",locale);

            fld3=rset.getString(3); if(fld3 == null) fld3="";
            fld4=rset.getString(4); if(fld4 == null) fld4="";
            fld5=rset.getString(5); if(fld5 == null) fld5="";
            fld6=rset.getString(6); if(fld6 == null) fld6="";
            fld7=rset.getString(7); if(fld7 == null) fld7="";
            fld8=rset.getString(8); if(fld8 == null) fld8="";
            fld9=rset.getString(9); if(fld9 == null) fld9="";
            encounter_id=rset.getString(10); if(encounter_id == null) encounter_id="";
            visit_type_ind=rset.getString(11); if(visit_type_ind == null) visit_type_ind="";
			
			cancelReasonCode=rset.getString("CANCEL_REASON_CODE"); if(cancelReasonCode == null) cancelReasonCode="";//Added by Thamizh selvi on 13th Feb 2017 against GDOH-CRF-0125

			String speciality_desc=rset.getString("SPECIALITY_DESC"); 
			if(speciality_desc == null) speciality_desc="";

			user=rset.getString("user_name");
			if(user == null)
				user="";
			
           
			row.append("<tr><td  class='" + classValue + "' nowrap>" + fld2_display + "</td>");
            row.append("<td  class='" + classValue + "' nowrap>" + fld4 + "</td>");
            row.append("<td  class='" + classValue + "' nowrap>" + fld5 + "</td>");

			row.append("<td  class='" + classValue + "' nowrap>" + speciality_desc + "</td>");

            row.append("<td  class='" + classValue + "' nowrap>" + fld6 + "</td>");
            if(fld7!="")
            {
                row.append("<td  class='" + classValue + "'>" + fld7 + "</td>");
            }
            else
            {
                row.append("<td  class='" + classValue + "'>&nbsp;</td>");
            }
            if(fld8!="")
            {
                row.append("<td  class='" + classValue + "' nowrap>" + fld8 + "</td>");
            }
            else
            {
                row.append("<td  class='" + classValue + "'>&nbsp;</td>");
            }
            row.append("<td  class='" + classValue + "' nowrap>" + fld9 + "</td>");

			row.append("<td  class='" + classValue + "' nowrap>" +user+ "</td>");
			
			/*Added by Thamizh selvi on 13th Feb 2017 against GDOH-CRF-0125 Start*/
			if(showCancelledVisits){
				if(cancelReasonCode!="")
				{
					row.append("<td  class='" + classValue + "' nowrap>" + "Y" + "</td>");
				}
				else
				{
					row.append("<td  class='" + classValue + "' nowrap>" + "N" + "</td>");
				}
			}/*End*/
	
			row.append("</tr>");

            out.print(row.toString());

			row.setLength(0);
            
            i++;
        }
    //}
	if(rset != null) rset.close();	
	/*}else*/
	if(count==0)
	{	
   out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	}
	}
	catch(Exception e){out.println("Exception@1 "+e.toString());}

   if(stmt != null) stmt.close();
   sql.setLength(0);
   row.setLength(0);
}
catch(Exception e){out.println("Exception@Main "+e.toString());}
finally
{
	try
	{
		if (rset != null ) rset.close();
		if( stmt != null) stmt.close();
	}catch(Exception e) {}
    if(conn!=null) ConnectionManager.returnConnection(conn,request);  
}
    %>

    </table>
    </td></tr>
    </table>

<script>
if(parent.parent.frames[0].document.forms[0].search_button)
parent.parent.frames[0].document.forms[0].search_button.disabled=false;</script>

</form>
</body>
</html>

