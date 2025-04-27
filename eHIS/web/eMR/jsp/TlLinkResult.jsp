<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/ValidateControl.js" Language="JavaScript"></Script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eMR/js/TLReportSetup.js' language='javascript'></script>
</head>
<body OnMouseDown="CodeArrest()">
<form name="ssorderresult" id="ssorderresult" action="../../servlet/eMR.OrderCatalogForReportServlet" method='post' target="messageFrame">
<% 
	request.setCharacterEncoding("UTF-8");    
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");    
	response.addHeader("X-Content-Type-Options", "nosniff");
    Connection con				= null;
	Statement	stmt	        = null;
	ResultSet	rset			= null;
	ResultSet	rset2			= null;
	ResultSet	rset3			= null;
	StringBuffer sb=null;
	

	String classValue			= "";
	String ord_cat				= "";
	String chkd					= "";
	String tab_list_no			= "";
	String report_id			= "";
	String group_code			= "";
	String sub_group_code		= "";
	String level_code3			= "";
	String type					= "";
	StringBuffer concat		= new StringBuffer("");
	String code_from			= "";
	String code_to				= "";
	String code_desc			= "";
	String group_type			= "";
   
	int		maxrecord			= 0;
	float   count_float			= 0;
	int		count				= 0;
	
	try
	{
		type						= checkForNull(request.getParameter("alphabet"));
		report_id					= checkForNull(request.getParameter("report_id"));
		group_code					= checkForNull(request.getParameter("group_code"));

		code_from					= checkForNull(request.getParameter("code_from"));
		code_to						= checkForNull(request.getParameter("code_to"));
		code_desc					= checkForNull(request.getParameter("code_desc"));
		
		StringTokenizer sp=new StringTokenizer(code_from,"|");
		if(sp.hasMoreTokens())
		{
		 code_from=sp.nextToken();
		 if(sp.hasMoreTokens())
		 {
			  code_to=sp.nextToken();
		 }
		}
		
        
		sub_group_code				= checkForNull(request.getParameter("sub_group_code"));
		level_code3				    = checkForNull(request.getParameter("level_code3"));
		type						= type.trim();
		report_id					= report_id.trim();
		group_code					= group_code.trim();
		sub_group_code				= sub_group_code.trim();
		con				            = ConnectionManager.getConnection(request);
		stmt			            = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
   
   %>
 
 <table cellspacing=0 cellpadding=0 width='100%' border=1>
  
 <tr>
	<th align="left" width='10%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>	
    <th align="left" width='50%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	<th align="left" width='20%'><fmt:message key="Common.OrderSrlNo.label" bundle="${common_labels}"/></th>		
	<th align="left" width='20%'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>
  </tr>
			<% 
	
	  int p=0;
	  sb = new StringBuffer();
	  //Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
	  if(report_id.equals("MRIPCSMB") || report_id.equals("MRDCCSMB") || report_id.equals("MROPCSMB"))
		{  //Modified for this CRF PER-RH-0206
            sb.append("SELECT tab_list_no, long_desc, 0 cnt, 'N' chkd FROM mr_tab_list WHERE eff_status = 'E' ");
			if(!code_from.equals("") && !code_to.equals(""))
            {
				sb.append(" and upper(tab_list_no) between upper('"+code_from+"') and upper('"+code_to+"') and ");
				p=1;
				
			}
			else if(code_from.equals("") && !code_to.equals(""))
            {
               sb.append(" and upper(tab_list_no) like upper('"+code_to+"%') and ");
			   p=1;
			
			}
			else if(!code_from.equals("") && code_to.equals(""))
            {
				sb.append(" and upper(tab_list_no) like upper('"+code_from+"%') and ");
				p=1;
			
			}
			if(!code_desc.equals(""))
			{
				 if(p==0)
				 sb.append(" and ");
				 sb.append("  upper(LONG_DESC) like upper('"+code_desc+"%') and ");
				 p=1;
			   
		    }
            if(p==0)
				sb.append(" and ");
            sb.append(" tab_list_no not in (select mast_code FROM mr_report_mapping where ");
			sb.append(" report_id ='"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null) and (sub_group_code = '"+sub_group_code+"' or  sub_group_code is not null ) and (level3_code ='"+level_code3+"' or level3_code is not null) and mast_table_name_reference ='TL') union ");
			sb.append("select a.mast_code tab_list_no, b.long_desc long_desc, a.order_by_srl_no cnt, 'Y' chkd from mr_report_mapping a, mr_tab_list b where a.mast_code = b.tab_list_no and ");
			if(!code_from.equals("") && !code_to.equals(""))
            {
				sb.append(" upper(a.mast_code) between upper('"+code_from+"') and upper( '"+code_to+"') and ");
			}
			else if(code_from.equals("") && !code_to.equals(""))
            {
               sb.append(" upper(a.mast_code) like upper('"+code_to+"%') and ");
			}
			else if(!code_from.equals("") && code_to.equals(""))
            {
				sb.append(" upper(a.mast_code) like upper('"+code_from+"%') and ");
			}
			if(!code_desc.equals(""))
			{
				
				sb.append(" upper(b.LONG_DESC) like upper('"+code_desc+"%') and ");
			
			   
		    }
			sb.append("a.report_id ='"+report_id+"' and a.group_code ='"+group_code+"' and a.sub_group_code = '"+sub_group_code+"' and a.level3_code ='"+level_code3+"'  and a.mast_table_name_reference ='TL'");
		}

         		
		//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Added by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
		else if(report_id.equals("MROPCSMS") || report_id.equals("OPBMTMOR") || report_id.equals("IPBMRMOT") || report_id.equals("IPBEXCDT") || report_id.equals("MRDCPROD") || report_id.equals("MRDCPROS")) 
		{
			sb.append("SELECT tab_list_no, long_desc, 0 cnt, 'N' chkd FROM mr_tab_list WHERE eff_status = 'E' ");
			
			if(!(code_from.equals("")) && !(code_to.equals("")))
            {
				sb.append(" and upper(tab_list_no)  between upper('"+code_from+"') and upper('"+code_to+"') and ");
			
				p=1;
				
			}
			else if(code_from.equals("") && (!code_to.equals("")))
            {
               sb.append(" and  upper(tab_list_no) like upper('"+code_to+"%') and ");
			   
			   p=1;
			
			}
			else if((!code_from.equals("")) && code_to.equals(""))
            {
				sb.append(" and upper(tab_list_no) like upper('"+code_from+"%')  and ");
				p=1;
				
			
			}
			if((!code_desc.equals("")))
			{
				 if(p==0)
				 sb.append(" and ");
				 sb.append("upper(LONG_DESC) like upper('"+code_desc+"%') and ");
				 p=1;
			
			   
		    }
            if(p==0)
			sb.append(" and ");
			sb.append(" tab_list_no not in (select mast_code FROM mr_report_mapping where ");
			sb.append(" report_id ='"+report_id+"' and (group_code ='"+group_code+"' or group_code is not null) and mast_table_name_reference ='TL') union ");
			sb.append("select a.mast_code tab_list_no, b.long_desc long_desc, a.order_by_srl_no cnt, 'Y' chkd from mr_report_mapping a, mr_tab_list b where a.mast_code = b.tab_list_no and ");
			if((!code_from.equals("")) && (!code_to.equals("")))
            {
				sb.append(" upper(a.mast_code) between upper('"+code_from+"') and  upper('"+code_to+"') and ");
			}
			else if(code_from.equals("") && (!code_to.equals("")))
            {
               sb.append(" upper(a.mast_code) like upper('"+code_to+"%') and ");
			}
			else if((!code_from.equals("")) && code_to.equals(""))
            {
				sb.append(" upper(a.mast_code) like upper('"+code_from+"%') and ");
			}
			if((!code_desc.equals("")))
			{
			   sb.append(" upper(b.LONG_DESC) like upper('"+code_desc+"%') and ");
			}
			sb.append("a.report_id ='"+report_id+"' and a.group_code ='"+group_code+"'  and a.mast_table_name_reference ='TL'");
		}
		else if ( report_id.equals("MRBPD207")	&& type.equals("BC") )
		{ 
			
			 sb.append("select '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, serv_classification_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd from bl_Serv_classification where serv_classification_code not in (select mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND (group_code = '"+group_code+"' ) and (sub_group_code = '"+sub_group_code+"' )) union select a.report_id, a.mast_table_name_reference, a.mast_code, (select short_desc from bl_serv_classification where serv_classification_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd from mr_report_mapping a where a.report_id = '"+report_id+"' and a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"'");
		}
		else
		{

          if(type.equals("BT"))
		  {
				 sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,BED_TYPE_CODE mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM ip_bed_type WHERE BED_TYPE_CODE NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) and (sub_group_code = '"+sub_group_code+"' or sub_group_code is not null ))UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from ip_bed_type where BED_TYPE_CODE = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"'" );
		  }
		  else if(type.equals("BD"))
		  {
				 sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,BED_CLASS_CODE mast_code, short_desc, 0 cnt,  NULL report_desc, NULL group_code, 'N' chkd FROM ip_bed_class WHERE BED_CLASS_CODE NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"') UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from ip_bed_class where BED_CLASS_CODE = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'" );
		  }
		  else if((type.equals("SP") && report_id.equals("MRIPCSBD")) || (type.equals("SP") && report_id.equals("MRIPCSOBD")))
		  {  //Below line modified for this CRF PER-PD-209A
			  
				 sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,speciality_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_speciality WHERE speciality_code NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) and (sub_group_code = '"+sub_group_code+"' or sub_group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from am_speciality where speciality_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"' and a.sub_group_code ='"+sub_group_code+"'");
		  }
		  else if(type.equals("SP"))
		  {
			
				 sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,speciality_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_speciality WHERE speciality_code NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from am_speciality where speciality_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
		  }
		  else if(type.equals("RC"))
		  { 
			   
				  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,race_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM mp_race WHERE race_code NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from mp_race where race_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
	      }
		  else if(type.equals("DT"))
		  {
			  
				 sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,nod_type mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM mp_nod_type WHERE nod_type NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from mp_nod_type where nod_type = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
		  }
		  else if(type.equals("HC"))
		  {
			   
			 sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,hcare_setting_type_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_hcare_setting_type WHERE hcare_setting_type_code NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from am_hcare_setting_type where hcare_setting_type_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
		  }
		  else if(type.equals("BC"))
	     {
			   
			   sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,hcare_setting_type_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_hcare_setting_type WHERE hcare_setting_type_code NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from am_hcare_setting_type where hcare_setting_type_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
			}
			else if(type.equals("NU"))
			{
				


			   sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, a.nursing_unit_code mast_code, a.short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM ip_nursing_unit a, ae_param b where a.facility_id = b.operating_facility_id  and a.nursing_unit_code = b.nursing_unit_code and a.appl_patient_class = 'IP' and a.eff_status = 'E' and (a.facility_id, a.nursing_unit_code) not in (select added_facility_id, mast_code from mr_report_mapping  WHERE report_id =  '"+report_id+"' AND  mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null)) union SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, speciality_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_speciality where eff_status = 'E' and speciality_code  not in ( select mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null)) union select a.report_id, a.mast_table_name_reference, a.mast_code, ( select short_desc from ip_nursing_unit where facility_id = a.added_facility_id and nursing_unit_code = a.mast_code UNION select short_desc from am_speciality where speciality_code = a.mast_code ) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd from mr_report_mapping a where a.report_id = '"+report_id+"' and a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
				
				/* sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, nursing_unit_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM ip_nursing_unit where appl_patient_class = 'IP' and (facility_id, nursing_unit_code) not in (select added_facility_id, mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null)) union SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, clinic_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM op_clinic where level_of_care_ind = 'E' and (facility_id, clinic_code) not in (select added_facility_id, mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null)) union select a.report_id, a.mast_table_name_reference, a.mast_code, (select short_desc from ip_nursing_unit where facility_id = a.added_facility_id and nursing_unit_code = a.mast_code UNION select CLINIC_CODE from op_clinic where level_of_care_ind='E' and facility_id = a.added_facility_id and clinic_code = a.mast_code) short_desc, a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd from mr_report_mapping a where a.report_id = '"+report_id+"' and a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");   */
                

	 

             }
			else if(type.equals("CL"))
			{
				
			  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference,clinic_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd from op_clinic where care_locn_type_ind = 'C' and (facility_id, clinic_code) not in (select added_facility_id, mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null) ) union select a.report_id,a.mast_table_name_reference, a.mast_code, (select short_desc from op_clinic where facility_id = a.added_facility_id and clinic_code = a.mast_code) short_desc, a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd from mr_report_mapping a where a.report_id = '"+report_id+"' and  a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
			   }
	else if(type.equals("HC") && report_id.equals("IPBMCREF"))
			{
		         
			   sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, hcare_setting_type_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_hcare_setting_type WHERE hcare_setting_type_code NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from am_hcare_setting_type where hcare_setting_type_code = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
          }
	else if(type.equals("CP"))
		{
		  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, speciality_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd from am_speciality where eff_status = 'E' and  speciality_code not in (select mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null) ) union select  a.report_id,a.mast_table_name_reference, a.mast_code, (select short_desc from am_speciality where speciality_code = a.mast_code)short_desc, a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd from mr_report_mapping a where a.report_id = '"+report_id+"' and a.mast_table_name_reference = '"+type+"'  and a.group_code = '"+group_code+"'");
		   

		 /* sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, clinic_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd from op_clinic where care_locn_type_ind in ('C','E') and (facility_id, clinic_code) not in (select added_facility_id, mast_code from mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( group_code = '"+group_code+"' or group_code is not null) ) union select a.report_id,a.mast_table_name_reference, a.mast_code, (select short_desc from op_clinic where clinic_code = a.mast_code)short_desc, a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd from mr_report_mapping a where a.report_id = '"+report_id+"' and a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");  */
        }
		else if(type.equals("DP"))
		{
			
		  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, DISP_TYPE mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM AM_DISPOSITION_TYPE WHERE  DISP_TYPE NOT IN (SELECT mast_code FROM mr_report_mapping WHERE report_id =  '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND ( GROUP_CODE = '"+group_code+"' or group_code is not null) )UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc from AM_DISPOSITION_TYPE where DISP_TYPE = a.mast_code ) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
        }
		else if(type.equals("NS"))
		{
			
			String sql12="select group_type from mr_report_grouping where group_code = '"+group_code+"'";
		 rset3=stmt.executeQuery(sql12);
		 while(rset3.next())
			 {
				group_type=rset3.getString("group_type");
			 }
			 if(rset3!=null) rset3.close();

		  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, NAME_SUFFIX mast_code, NAME_SUFFIX short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM MP_NAME_SUFFIX WHERE NAME_SUFFIX NOT IN (SELECT a.mast_code FROM mr_report_mapping a,mr_report_grouping b WHERE a.report_id =  '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' AND a.group_code=b.group_code AND ( a.GROUP_CODE = '"+group_code+"' or a.group_code is not null) AND b.group_type='"+group_type+"')UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT NAME_SUFFIX short_desc from MP_NAME_SUFFIX where NAME_SUFFIX = a.mast_code) short_desc,a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' and a.group_code = '"+group_code+"'");
        }
		/*Added by Ashwini on 19-Jun-2019 for ML-MMOH-CRF-1340*/
		else if(type.equals("SC"))
		{
		  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, clinic_code mast_code, short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM op_clinic WHERE clinic_code NOT IN ( SELECT mast_code FROM mr_report_mapping WHERE report_id = '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND (group_code = '"+group_code+"' OR group_code IS NOT NULL)) AND specialist_clinic_yn != 'Y' AND care_locn_type_ind IN ('C', 'E') UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT short_desc FROM op_clinic WHERE clinic_code = a.mast_code AND specialist_clinic_yn != 'Y' AND care_locn_type_ind IN ('C', 'E')) short_desc, a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' AND a.group_code = '"+group_code+"' AND mast_code IN ( SELECT clinic_code FROM op_clinic WHERE clinic_code = a.mast_code AND specialist_clinic_yn != 'Y' AND care_locn_type_ind IN ('C', 'E'))");
        }
		/*End ML-MMOH-CRF-1340*/
		/*Added by Ashwini on 28-Jan-2021 for ML-MMOH-CRF-1341*/
		else if(type.equals("DA"))
		{
		  sb.append("SELECT '"+report_id+"' report_id, '"+type+"' mast_table_name_reference, position_code mast_code, position_desc short_desc, 0 cnt, NULL report_desc, NULL group_code, 'N' chkd FROM am_position WHERE position_code NOT IN ( SELECT mast_code FROM mr_report_mapping WHERE report_id = '"+report_id+"' AND mast_table_name_reference = '"+type+"' AND (group_code = '"+group_code+"' OR group_code IS NOT NULL)) UNION SELECT a.report_id, a.mast_table_name_reference, a.mast_code, (SELECT position_desc short_desc FROM am_position WHERE position_code = a.mast_code) short_desc, a.order_by_srl_no cnt, a.report_desc, a.group_code, 'Y' chkd FROM mr_report_mapping a WHERE a.report_id = '"+report_id+"' AND a.mast_table_name_reference = '"+type+"' AND a.group_code = '"+group_code+"'");
        }
		/*End ML-MMOH-CRF-1341*/
	}		int i=1;
			 String count_float_string="";
			// stmt			= con.createStatement();
		    if(report_id.equals("MROPCSMB") || report_id.equals("MROPCSMS") || report_id.equals("MRIPCSMB") || report_id.equals("OPBMTMOR") || report_id.equals("IPBMRMOT") || report_id.equals("IPBEXCDT") || report_id.equals("MRDCCSMB") || report_id.equals("MRDCPROD") || report_id.equals("MRDCPROS"))
		    {   //below and above line also Modified for this CRF PER-RH-0206 
				String supsql="";
				//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
				if(report_id.equals("MRIPCSMB") || report_id.equals("MRDCCSMB") || report_id.equals("MROPCSMB"))
				  supsql="select order_by_srl_no from mr_report_mapping where report_id ='"+report_id+"' and group_code = '"+group_code+"' and sub_group_code ='"+sub_group_code+"' and level3_code ='"+level_code3+"'";
				//MROPCSMS Added by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
				else if(report_id.equals("MROPCSMS") || report_id.equals("OPBMTMOR") || report_id.equals("IPBMRMOT") || report_id.equals("IPBEXCDT") || report_id.equals("MRDCPROD") || report_id.equals("MRDCPROS"))
					supsql="select order_by_srl_no from mr_report_mapping where report_id ='"+report_id+"' and group_code = '"+group_code+"'" ;
								 
                 rset2=stmt.executeQuery(supsql);
				 while(rset2.next())
				 {
					  String order_by_srl_no_new=rset2.getString("order_by_srl_no");
					  int index_known=order_by_srl_no_new.indexOf('.');
                      order_by_srl_no_new=order_by_srl_no_new.substring((index_known+1),(order_by_srl_no_new.length()));
					  concat.append(order_by_srl_no_new+"#");
					   
				 }
				 if(rset2!=null) rset2.close();

                  concat.append("1000#");
			}
			//out.println("SQL = "+sb.toString());	 
			rset	= stmt.executeQuery(sb.toString());
			
			if(rset!=null)
			 {
				rset.last();
				maxrecord = rset.getRow();
				rset.beforeFirst();
				while(rset.next())
				{   
				    //Below line Modified for this CRF PER-RH-0206
					if(report_id.equals("MRIPCSMB") || report_id.equals("MROPCSMB") || report_id.equals("MROPCSMS") || report_id.equals("OPBMTMOR") || report_id.equals("IPBMRMOT") || report_id.equals("IPBEXCDT") || report_id.equals("MRDCCSMB") || report_id.equals("MRDCPROD") || report_id.equals("MRDCPROS"))
					{	
						 tab_list_no		= rset.getString("tab_list_no");
						 ord_cat            = rset.getString("long_desc");
					}
				    count              = rset.getInt("cnt");
					chkd               = rset.getString("chkd");
					//Below line Modified for this CRF PER-RH-0206
					//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
					if(report_id.equals("MRIPCSMB") || report_id.equals("MRDCCSMB") || report_id.equals("MROPCSMB"))
					{	
						   count_float      = rset.getFloat("cnt");
						   int occ			= String.valueOf(count_float).indexOf('.');
						   String  number2	= String.valueOf(count_float).substring((occ+1),(String.valueOf(count_float).length()));
						   if(number2.length()<2)
							   count_float_string=String.valueOf(count_float)+"0";
						   else
							   count_float_string=String.valueOf(count_float);
					}
					else{
					  
					count              = rset.getInt("cnt");}
   										                   
					 if ( (i+1) % 2 == 0 )
						 classValue = "QRYEVEN" ;
					 else
						 classValue = "QRYODD" ;
						
			       %>    
					<tr>
						<input type="hidden" name="count1" id="count1" value=<%=i%>>
					   
					   
						
						<%if(report_id.equals("MRIPCSMB") || report_id.equals("MROPCSMB") || report_id.equals("MROPCSMS") || report_id.equals("OPBMTMOR") || report_id.equals("IPBMRMOT") || report_id.equals("IPBEXCDT") || report_id.equals("MRDCCSMB") || report_id.equals("MRDCPROD") || report_id.equals("MRDCPROS"))
							{  //Above line Modified for this CRF PER-RH-0206 
						%>
							<td class='<%=classValue%>'><%=rset.getString("TAB_LIST_NO")%> </td>
							<td class='<%=classValue%>'>
							<%=checkForNull(rset.getString("long_desc"))%> </td>
							<input type="hidden" name="tab_list<%=i%>" id="tab_list<%=i%>" value="<%=ord_cat%>">
							<input type="hidden" name="tab_list_no<%=i%>" id="tab_list_no<%=i%>" value="<%=tab_list_no%>">
						<%}
						else { %>
							<td class='<%=classValue%>'><%=rset.getString("MAST_CODE")%> </td>
							<td class='<%=classValue%>'>
							<%=checkForNull(rset.getString("short_desc"))%> </td>
							<input type="hidden" name="tab_list<%=i%>" id="tab_list<%=i%>" value="<%=checkForNull(rset.getString("short_desc"))%>">
							<input type="hidden" name="tab_list_no<%=i%>" id="tab_list_no<%=i%>" value="<%=rset.getString("mast_code")%>">
						<%}%>
						<% if(count > 0)
							{%>
								
								<% //Modified for this CRF PER-RH-0206 
								//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
 								if(report_id.equals("MRIPCSMB") || report_id.equals("MRDCCSMB") || report_id.equals("MROPCSMB")){ 
								%>
									<td class='<%=classValue%>' align=center>
									<INPUT TYPE="text" name="text<%=i%>" id="text<%=i%>" size='6' maxLength='6' onBlur="chkSerialno(this);" onkeypress="return allowPositiveNumber()"  value="<%=count_float_string%>" maxLength='4' onBlur="chkvalidnum(this);"></td>
								<%}
								else if(report_id.equals("MRIPCSBD") || report_id.equals("MRIPCSOBD"))
								{ //Modified for this CRF PER-PD-209A %>								
									<td class='<%=classValue%>' align=center>
									<INPUT TYPE="text" name="text<%=i%>" id="text<%=i%>" size='6' maxLength='4' onBlur="chkSerialno(this);" onkeypress="return allowPositiveNumber()"  value="<%=count%>" maxLength='4' onBlur="chkvalidnum(this);"></td>
								<%}
								else
								{ %>
									<td class='<%=classValue%>' align=center>
									<INPUT TYPE="text" name="text<%=i%>" id="text<%=i%>" size='6' maxLength='4' onBlur="chkSerialno(this);" onkeypress="return allowPositiveNumber()"  value="<%=count%>" maxLength='4' onBlur="chkvalidnum(this);"></td>
								<%}
							 }
						 else 
						  { 
						    //Below line Modified for this CRF PER-RH-0206 
							//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
						     if(report_id.equals("MRIPCSMB") || report_id.equals("MRDCCSMB") || report_id.equals("MROPCSMB"))
								{%>
								<td class='<%=classValue%>' align=center>
								<INPUT TYPE="text" name="text<%=i%>" id="text<%=i%>" size='6'  maxLength='6' onBlur="chkSerialno(this);" onkeypress="return allowPositiveNumber()" value="" onBlur="chkdup(this); chkvalidnum(this);"></td>
								<%}
								else if(report_id.equals("MRIPCSBD") || report_id.equals("MRIPCSOBD"))
								{ //Modified for this CRF PER-PD-209A%>
								<td class='<%=classValue%>' align=center>
								<INPUT TYPE="text" name="text<%=i%>" id="text<%=i%>" size='6'  maxLength='4' onBlur="chkSerialno(this);" onkeypress="return allowPositiveNumber()" value="" onBlur="chkdup(this); chkvalidnum(this);"></td>
								<%}
								else
								{%>
								<td class='<%=classValue%>' align=center>
								<INPUT TYPE="text" name="text<%=i%>" id="text<%=i%>" size='6'  maxLength='4' onBlur="chkSerialno(this);" onkeypress="return allowPositiveNumber()" value="" onBlur="chkdup(this); chkvalidnum(this);"></td>
								

						 <%}
						  }
						 if(chkd.equals("N"))
						 {%>
								<td class='<%=classValue%>' align='center'><input type='checkbox' name='inc<%=i%>' id='inc<%=i%>' value='<%=chkd%>' onClick='funchk(this)'></td>
						<%} 
						else 
						{%>
								<td class='<%=classValue%>' align='center'><input type='checkbox' name='inc<%=i%>' id='inc<%=i%>' value='<%=chkd%>' checked onClick='funchk(this)'></td>
						<%}%>
						<% i++;
				}
				 if(rset!=null) rset.close(); %>
			</tr>
						
			<%		
			}
			   if(maxrecord==0){%>
					<SCRIPT LANGUAGE="JavaScript">
					<!--
						alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
						parent.parent.f_query_add_mod.f_query_add_mod_result.location.href='../../eCommon/html/blank.html';
					//-->
					</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



			<%}%>
				</table>
				 <input type ='hidden' name ='alphabet' value =''>
				 <input type ='hidden' name ='report_id' value ='<%=report_id %>'>
				 <input type ='hidden' name ='group_code' value ='<%=group_code%>'>
				 <input type ='hidden' name ='sub_group_code' value ='<%=sub_group_code%>'>
				 <input type ='hidden' name ='maxrecord' value ='<%=maxrecord%>'>
				 <input type ='hidden' name ='maxrecord1' value ='<%=i%>'>
				 <input type ='hidden' name ='concat' value ='<%=concat.toString()%>'>
				 <input type ='hidden' name ='mast_table_name_reference' value ='<%=type%>'>
				 <input type ='hidden' name ='function_name1' value =''>
				 <input type ='hidden' name ='level_code' value ="<%=level_code3%>">
				 
<%  if(stmt!=null) stmt.close();
   
   }
  catch(Exception e)
  {
	  //out.println("Exception in File TlLinkResult"+e.toString());
	  e.printStackTrace();
  }
 finally
 {
    ConnectionManager.returnConnection(con,request);
 }

 %>	
</form>
</body>
</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>


