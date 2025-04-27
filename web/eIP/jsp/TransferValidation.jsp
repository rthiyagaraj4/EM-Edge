<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,javax.servlet.jsp.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	 String locale			= (String)session.getAttribute("LOCALE");
  	 
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='Javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='Javascript'></script>
<script src="../../eIP/js/TransferPatient.js" language="javascript"></script>
<script src="../../eIP/js/BedBookingTransfer.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body CLASS="MESSAGE" onKeyDown='lockKey()'>
<form name="TransferValidation_form" id="TransferValidation_form">
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	webbeans.op.PatientData patdata		= new webbeans.op.PatientData();
	Connection			con				=	null;
	Statement			stmt			=	null;
	Statement			stmt_nu			=	null;
	ResultSet			rset			=	null;
	ResultSet			rset_nu			=	null;
	PreparedStatement	pstmt			=	null;
	ResultSet			rs				=	null;
	String	facilityId					=	"";	
	String	value1						=	""; 
	String	value2						=	"";
	String value3						=	""; 
	String	from						=	"";
	String  value5						=	"";
	String  value8						=   "";
	StringBuffer sql					= new StringBuffer();
	String roomno						=	"";
	String	bedno						= "";
	String	servicecode					= "",		servicedesc				=	"";
	String  subservicecode				= "",		subservicedesc			=	"";
	String  to_bed_no					= "";
	String deactivate_pseudo_bed_yn		= "N";
	String  reqParam					= "";
	StringBuffer sqlQuery				= new StringBuffer();
	String  selectedTeam				= "";
	String  practitioner				= "";
	String  practid						= "";
	String  servcode					= "";
	String  prioritycode				= "";
	String  priority_code_form			= "";
	String  patient_class_code			= "";
	String  patient_nursingunit			= "";
	String c_from						= "";
	String value9						= "";
	String value10						= "";
	String nursingunitcode				= "";
	String fr_bed_class_code			= "";
	try
	{
		con								=	ConnectionManager.getConnection(request);
		facilityId						=	(String)session.getValue("facility_id");
		patdata.setFacility_id(facilityId);
		nursingunitcode					=	checkForNull(request.getParameter("nursingunitcode"));
		value1							=	checkForNull(request.getParameter("field1"));
		value2							=	checkForNull(request.getParameter("field2"));
		value3							=	checkForNull(request.getParameter("field3"));
		if(nursingunitcode.equals("") && !value3.equals(""))
			nursingunitcode = value3;
		from							=	checkForNull(request.getParameter("field4"));
		selectedTeam					=   checkForNull(request.getParameter("selectedTeam"));
		reqParam						=   checkForNull(request.getParameter("reqParam"));
		c_from							=	checkForNull(request.getParameter("c_field4"));
		selectedTeam					=   checkForNull(request.getParameter("selectedTeam"));
		value5							=	checkForNull(request.getParameter("field5"));
		value8							=	checkForNull(request.getParameter("field8"));
		value9							=	checkForNull(request.getParameter("field9"));
		value10							=	checkForNull(request.getParameter("field10"));
		to_bed_no						=   checkForNull(request.getParameter("to_bed_no"));
		servcode						=	checkForNull(request.getParameter("serviceCode"));
		//Added by kishore for getting Priority Exp Hrs on 4/30/2004
		priority_code_form				=	checkForNull(request.getParameter("priority_form"));
		prioritycode					= checkForNull(request.getParameter("prioritycode"));
		
		patient_nursingunit				= checkForNull(request.getParameter("patient_nursingunit"));
		String change_bed_class_yn		= checkForNull(request.getParameter("change_bed_class_yn"));

	
		/*
		Commented for PE On 4/30/2010.
		String paramSql = " select deactivate_pseudo_bed_yn from IP_PARAM where facility_id='"+facilityId+"' ";

		paramStmt	= con.createStatement();
		paramRS		= paramStmt.executeQuery(paramSql);
		if(paramRS.next())
		{
			deactivate_pseudo_bed_yn = paramRS.getString("deactivate_pseudo_bed_yn");
		}
		if(paramRS !=null) paramRS.close(); 
		if(paramStmt != null) paramStmt.close();*/

		deactivate_pseudo_bed_yn		= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
		/*	@Name: Added by kishore on 4/30/2004
		@Reasor:Getting papulate Expired Hrs to JSP Bed Booking Transfer
		@Param: prioritycode from parent JSP Bed Booking Transfer
		*/
       
		if(from.equals("getBedType"))
		{
			String class_code = checkForNull(request.getParameter("bed_class"));
			String bedtype_code = checkForNull(request.getParameter("bed_type_code"));
			String bed_type_code ="";
			String bed_type_desc ="";
			out.println("<script>");
			out.println("var obj1 =parent.frames[1].document.forms[0].bed_type_code;");
			out.println("var length1  = obj1.length;");
			out.println("for(i=0;i<length1;i++) {obj1.remove(1);}");
			out.println("</script>");
			if(!class_code.equals(""))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				if(deactivate_pseudo_bed_yn.equals("Y") && !nursingunitcode.equals("") )
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					//sql.append(" SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_lang_vw b WHERE a.facility_id = '"+facilityId+"' AND a.nursing_unit_code = '"+nursingunitcode+"' AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code AND a.bed_class_code = '"+class_code+"' AND a.eff_status='E' AND b.eff_status = 'E' AND a.psuedo_bed_status = 'N' and b.language_id='"+locale+"' ORDER BY b.short_desc ");
					/*Wednesday, May 05, 2010 , modified for PE*/
					sql.append("select distinct bed_type_code , ip_get_desc.ip_bed_type(bed_type_code,?,2) short_desc from ip_nursing_unit_bed where facility_id = ? AND nursing_unit_code = ? and bed_class_code = ? and  psuedo_bed_status = 'N' AND eff_status = 'E' ORDER BY short_desc ");
				}
				else if(deactivate_pseudo_bed_yn.equals("N") && !nursingunitcode.equals("") )
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					//sql.append(" SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_lang_vw b WHERE a.facility_id = '"+facilityId+"' AND a.nursing_unit_code = '"+nursingunitcode+"' AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code AND a.bed_class_code = '"+class_code+"' AND a.eff_status='E' AND b.eff_status = 'E' and b.language_id='"+locale+"' ORDER BY b.short_desc ");
					/*Wednesday, May 05, 2010 , modified for PE*/
					sql.append("SELECT DISTINCT bed_type_code ,ip_get_desc.ip_bed_type(bed_type_code,?,2) short_desc FROM IP_NURSING_UNIT_BED WHERE facility_id = ? AND nursing_unit_code = ? AND bed_class_code = ? AND eff_status='E'  ORDER BY short_desc ");

				}

				if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
				pstmt	=	con.prepareStatement(sql.toString());
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,nursingunitcode);
				pstmt.setString(4,class_code);
				rset	=	pstmt.executeQuery();
				while(rset.next())
				{
					bed_type_code = checkForNull(rset.getString("bed_type_code"));
					bed_type_desc = checkForNull(rset.getString("short_desc"));
					out.println ("<script>var opt1= parent.frames[1].document.createElement('Option');\n opt1.text=\""+bed_type_desc+"\"; opt1.value=\""+bed_type_code+"\"; obj1.add(opt1); 				if('"+bed_type_code+"'=='"+bedtype_code+"')opt1.selected=true;</script>");
					out.println ("<script>parent.frames[1].document.createElement('Option');</script>") ;
					
				}
				if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
			}
		}
		if(from.equals("getBedClass")){
			String function_Id = checkForNull(request.getParameter("function_Id"));
			String bed_class_code ="";
			String bed_class_desc ="";
			out.println("<script>");
			if(function_Id.equals("REQUEST_TRANSFER")){
				out.println("var obj1 =parent.frames[1].document.forms[0].Bedcode;");
			}else if(function_Id.equals("TRANSFER_PAT_OUT")){
				out.println("var obj1 =parent.frames[2].document.forms[0].to_bed_class;");
			}
			out.println("var length1  = obj1.length;");
			out.println("for(i=0;i<length1;i++) {obj1.remove(1);}");
			out.println("</script>");
			if(function_Id.equals("REQUEST_TRANSFER") || function_Id.equals("TRANSFER_PAT_OUT") ){
				if(!nursingunitcode.equals("")){
					if(sql.length() > 0) sql.delete(0,sql.length());
					if(deactivate_pseudo_bed_yn.equals("Y")){
						//sql.append(" SELECT DISTINCT a.bed_class_code, b.short_desc FROM ip_nursing_unit_bed a, ip_bed_class_lang_vw b WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = '"+nursingunitcode+"' AND a.bed_class_code = b.bed_class_code AND a.psuedo_bed_status = 'N' and b.language_id='"+locale+"' ORDER BY b.short_desc ");
						/*Wednesday, May 05, 2010 , modified for PE*/
						sql.append(" SELECT DISTINCT bed_class_code, ip_get_desc.ip_bed_class(bed_class_code,?,2) short_desc FROM ip_nursing_unit_bed WHERE facility_id = ? AND eff_status = 'E' AND nursing_unit_code = ? AND psuedo_bed_status = 'N' ORDER BY short_desc ");
					}else{
						//sql.append(" SELECT DISTINCT a.bed_class_code, b.short_desc FROM ip_nursing_unit_bed a, ip_bed_class_lang_vw b WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = '"+nursingunitcode+"' AND a.bed_class_code = b.bed_class_code and b.language_id='"+locale+"' ORDER BY b.short_desc ");
						/*Wednesday, May 05, 2010 , modified for PE*/
						sql.append(" SELECT DISTINCT bed_class_code, ip_get_desc.ip_bed_class(bed_class_code,?,2) short_desc FROM ip_nursing_unit_bed WHERE facility_id = ? AND eff_status = 'E' AND nursing_unit_code = ?  ORDER BY short_desc ");
					}

					pstmt	=	con.prepareStatement(sql.toString());
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					pstmt.setString(3,nursingunitcode);
					rset	=	pstmt.executeQuery();
					while(rset.next()){
						bed_class_code = checkForNull(rset.getString("bed_class_code"));
						bed_class_desc = checkForNull(rset.getString("short_desc"));
						out.println ("<script>var opt1= parent.frames[1].document.createElement('Option');\n opt1.text=\""+bed_class_desc+"\"; opt1.value=\""+bed_class_code+"\"; obj1.add(opt1);</script>");
						out.println ("<script>parent.frames[1].document.createElement('Option');</script>") ;
					}
					if(rset !=null) rset.close(); 
					if(pstmt != null) pstmt.close();
				}
			}
		}

	/*if(from.equals("getBedClass_trnsOut"))
		{
			String nursingunitcode = checkForNull(request.getParameter("nursingunitcode"));
			String bed_class_code ="";
			String bed_class_desc ="";

		out.println("<script>");
		out.println("var obj1 =parent.frames[2].document.forms[0].to_bed_class;");
		out.println("var length1  = obj1.length;");
		out.println("for(i=0;i<length1;i++) {obj1.remove(1);}");
		out.println("</script>");
			if(!nursingunitcode.equals(""))
			{
				sql	="SELECT DISTINCT a.bed_class_code, b.short_desc FROM ip_nursing_unit_bed a, ip_bed_class b WHERE a.nursing_unit_code = '"+nursingunitcode+"' AND a.bed_class_code = b.bed_class_code ORDER BY a.bed_class_code" ;
				
				stmt	=	con.createStatement();
				rset	=	stmt.executeQuery(sql);
				
				while(rset.next())
				{
					bed_class_code = checkForNull(rset.getString("bed_class_code"));
					bed_class_desc = checkForNull(rset.getString("short_desc"));
				  	out.println ("<script>var opt1= parent.frames[1].document.createElement('Option');\n opt1.text='"+bed_class_desc+"'; opt1.value='"+bed_class_code+"'; obj1.add(opt1);</script>");
					out.println ("<script>parent.frames[1].document.createElement('Option');</script>") ;
				}
				if(rset !=null) rset.close(); 
				if(stmt != null) stmt.close();
			}
		}*/

		if(value9.equals("validateNUnitBedClass"))
		{
				int flag_count = 0;
				String function_name = checkForNull(request.getParameter("function_name"));	
				String to_bed_class = checkForNull(request.getParameter("to_bed_class"));
				String to_bed_type = checkForNull(request.getParameter("to_bed_type"));
				String nursing_unit_code = checkForNull(request.getParameter("fr_nursing_unit_code"));
				boolean flag_nu_bedclass = false;
				if(!nursing_unit_code.equals(""))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					if(deactivate_pseudo_bed_yn.equals("Y"))
					{
						sql.append(" select count(*) from ip_nursing_unit_bed where facility_id ='"+facilityId+"' and nursing_unit_code = '"+nursing_unit_code+"' and bed_class_code = '"+to_bed_class+"' and bed_type_code = '"+to_bed_type+"' and eff_status = 'E' and  psuedo_bed_status = 'N' ");
					}
					else
					{
						sql.append(" select count(*) from ip_nursing_unit_bed where facility_id ='"+facilityId+"' and nursing_unit_code = '"+nursing_unit_code+"' and bed_class_code = '"+to_bed_class+"' and bed_type_code = '"+to_bed_type+"' and eff_status = 'E' ");
					}

					stmt	=	con.createStatement();
					rset	=	stmt.executeQuery(sql.toString());

					if(rset.next() && rset!=null)
					{
						flag_count = rset.getInt(1);
						if(flag_count > 0)
							flag_nu_bedclass = true;
					}
					if(stmt!=null) stmt.close();
					if(rset!=null) rset.close();
				}

				if(function_name.equals("Request_Trasnfer"))
				{
					if(flag_nu_bedclass)
					{
						out.println("<script>setBooleanValue_reqforTrnsfr(true);</script>");

					}
					else
					{
						out.println("<script>setBooleanValue_reqforTrnsfr(false);</script>");
					}
				}
				else
				{
				if(flag_nu_bedclass)
				{
					out.println("<script>setBooleanValue(true);</script>");

				}
				else
				{
					out.println("<script>setBooleanValue(false);</script>");
				}
			}
		}

			if(value9.equals("Tfr_out"))
			{
				String class_code = checkForNull(request.getParameter("bed_class"));
				String bed_type_code ="";
				String bed_type_desc ="";

				if(!class_code.equals(""))
				{
					if(sql.length() > 0) sql.delete(0,sql.length());

					if(deactivate_pseudo_bed_yn.equals("Y") && !nursingunitcode.equals(""))
					{
						if(sql.length() > 0) sql.delete(0,sql.length());
						//sql.append(" SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc bed_type_short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_lang_vw b WHERE a.facility_id = '"+facilityId+"' AND a.nursing_unit_code = '"+nursingunitcode+"' AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code AND a.bed_class_code = '"+class_code+"' AND a.eff_status='E' AND b.eff_status = 'E' AND a.psuedo_bed_status = 'N' and b.language_id='"+locale+"' ORDER BY b.short_desc ");
						//Wednesday, May 05, 2010 , modified for PE
						sql.append(" SELECT DISTINCT bed_type_code, ip_get_desc.ip_bed_type(bed_type_code,?,2) bed_type_short_desc FROM IP_NURSING_UNIT_BED WHERE facility_id = ? AND nursing_unit_code = ? AND bed_class_code = ? AND eff_status='E' AND psuedo_bed_status = 'N' ORDER BY bed_type_short_desc ");
					}
					else if(deactivate_pseudo_bed_yn.equals("N") && !nursingunitcode.equals("") )
					{
						if(sql.length() > 0) sql.delete(0,sql.length());
						//sql.append(" SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc bed_type_short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_lang_vw b WHERE a.facility_id = '"+facilityId+"' AND a.nursing_unit_code = '"+nursingunitcode+"' AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code AND a.bed_class_code = '"+class_code+"' AND a.eff_status='E' AND b.eff_status = 'E' and b.language_id='"+locale+"' ORDER BY b.short_desc ");
						//Wednesday, May 05, 2010 , modified for PE
						sql.append(" SELECT DISTINCT bed_type_code, ip_get_desc.ip_bed_type(bed_type_code,?,2) bed_type_short_desc FROM IP_NURSING_UNIT_BED WHERE facility_id = ? AND nursing_unit_code = ? AND bed_class_code = ? AND eff_status='E'  ORDER BY bed_type_short_desc ");
					}
					pstmt	=	con.prepareStatement(sql.toString());
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					pstmt.setString(3,nursingunitcode);
					pstmt.setString(4,class_code);
					rset	=	pstmt.executeQuery();
					out.println("<script>");
					 out.println("var obj =parent.frames[2].document.forms[0].bed_type_code;");
					 out.println("var length  = obj.length;");

					 out.println("for(i=0;i<length;i++) {obj.remove(1);}");
					 out.println("</script>");
					while(rset.next())
					{
						bed_type_code = checkForNull(rset.getString("bed_type_code"));
						bed_type_desc = checkForNull(rset.getString("bed_type_short_desc"));
								 
					 out.println ("<script>var opt= parent.frames[2].document.createElement('Option');\n opt.text=\""+bed_type_desc+"\"; opt.value=\""+bed_type_code+"\";obj.add(opt);");
					 out.println ("parent.frames[2].document.createElement('Option')</script>") ;
					 out.println ("<script>parent.frames[2].document.forms[0].hid_bed_type.value=\""+bed_type_code+"\"") ;
					 
					 out.println("</script>");
					}
					 if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();

				}
			}
		String blocking_type = "";
		int block_period=0;
		String blocked_until_date = "";
		String blocked_until_date_converted = "";
		String blocking_code	= "";
		String transfer_out = "";
		String block_unit = "";
		StringBuffer str_block_period = new StringBuffer();
		
		facilityId = (String)session.getValue("facility_id");
		if(from.equals("block_date"))
		{
               
			String transfer_type_code=value3;
          
			transfer_out	=	value5;
			StringBuffer blocking_date = new StringBuffer();
			blocking_date.append("select blocking_type_code,ip_get_desc.IP_BLOCKING_TYPE(BLOCKING_TYPE_CODE,'"+locale+"',2) BLOKCING_TYPE_SHORT_DESC,BLOCK_PERIOD,BLOCK_UNITS from ip_transfer_type_vw where TRANSFER_TYPE_CODE='"+transfer_type_code+"'");
			
				stmt			=	con.createStatement();
				rset = stmt.executeQuery(blocking_date.toString());
				if (rset.next())
				{
					blocking_code	= checkForNull(rset.getString("blocking_type_code"));
					blocking_type	= checkForNull(rset.getString("BLOKCING_TYPE_SHORT_DESC"));
					block_unit		= checkForNull(rset.getString("BLOCK_UNITS"));
					block_period	= rset.getInt("BLOCK_PERIOD");
				}


		if(!blocking_code.equals(""))
		{
           
			//Calcuated for blocked_until_date on 8/24/2004
			if(transfer_out.equals("transfer_out"))
			out.print("<script>parent.frames[2].document.forms[0].blocking_type.value=\""+blocking_type+"\";</script>");
        

			if(block_period >0 )
			{
				if(block_unit.equals("D"))
					block_period =(block_period)*24;	
				
				if(str_block_period.length() > 0) str_block_period.delete(0,str_block_period.length());
				str_block_period.append("select to_char((sysdate+'"+block_period+"'/24),'dd/mm/rrrr hh24:mi') a from dual");
				stmt			=	con.createStatement();
				rset = stmt.executeQuery(str_block_period.toString());
				if (rset != null && rset.next())
				{
					blocked_until_date = checkForNull(rset.getString("a"));
					if(!(blocked_until_date==null || blocked_until_date.equals("")))
						blocked_until_date_converted = DateUtils.convertDate(blocked_until_date,"DMYHM","en",locale);
				}
				if(rset !=null) rset.close(); if(stmt != null) stmt.close();
			}
			else
			{
				if(str_block_period.length() > 0) str_block_period.delete(0,str_block_period.length());
				str_block_period.append("select BED_BLOCK_PERIOD_NORMAL from ip_param where facility_id='"+facilityId+"'");
				blocking_type="";
				stmt			=	con.createStatement();
				rset = stmt.executeQuery(str_block_period.toString());
				while(rset.next())
				{
					block_period = rset.getInt("BED_BLOCK_PERIOD_NORMAL");
				}
				if(rset !=null) rset.close(); if(stmt != null) stmt.close();

				if(str_block_period.length() > 0) str_block_period.delete(0,str_block_period.length());
				str_block_period.append("select to_char((sysdate+'"+block_period+"'/24),'dd/mm/rrrr hh24:mi') a from dual");
				stmt			=	con.createStatement();
				rset = stmt.executeQuery(str_block_period.toString());
				while(rset.next())
				{
					blocked_until_date = checkForNull(rset.getString("a"));
					if(!(blocked_until_date==null || blocked_until_date.equals("")))
						blocked_until_date_converted = DateUtils.convertDate(blocked_until_date,"DMYHM","en",locale);

				}
				if(rset !=null) rset.close(); if(stmt != null) stmt.close();
			}
			if(transfer_out.equals("transfer_out"))
			{
			   	out.print("<script>parent.frames[2].document.forms[0].bed_blocking_period.value=\""+block_period+"\";parent.frames[2].document.forms[0].bed_block_until.value=\""+blocked_until_date_converted+"\";parent.frames[2].document.forms[0].blocking_type_code.value=\""+blocking_code+"\";</script>");
			}
			else
			{
				out.print("<script>parent.frames[1].document.forms[0].blocking_type.value=\""+blocking_type+"\";parent.frames[1].document.forms[0].bed_blocking_period.value=\""+block_period+"\";parent.frames[1].document.forms[0].bed_block_until.value=\""+blocked_until_date_converted+"\";parent.frames[1].document.forms[0].blocking_type_code.value=\""+blocking_code+"\";parent.frames[1].document.forms[0].bed_blocking_period.focus();</script>");
			}
		  }
		  else
		   {
			if(transfer_out.equals("transfer_out"))
			{
			   out.print("<script>parent.frames[2].document.forms[0].blocking_type.value='';parent.frames[2].document.forms[0].blocking_type.disabled=true;parent.frames[2].document.forms[0].bed_blocking_period.value='';parent.frames[2].document.forms[0].bed_blocking_period.disabled=true;parent.frames[2].document.forms[0].bed_block_until.value='';parent.frames[2].document.forms[0].bed_block_remarks.value='';parent.frames[2].document.forms[0].bed_block_remarks.disabled=true;</script>");
			}
			else
			{

		   out.print("<script>parent.frames[1].document.forms[0].blocking_type.value=\""+blocking_type+"\";parent.frames[1].document.forms[0].bed_blocking_period.value=\""+block_period+"\";parent.frames[1].document.forms[0].bed_block_until.value=\""+blocked_until_date_converted+"\";parent.frames[1].document.forms[0].blocking_type_code.value=\""+blocking_code+"\";parent.frames[1].document.forms[0].bed_blocking_period.focus();</script>");
			}
		   }
		}
		else if(from.equals("block_date1"))
		{
			transfer_out	=	value5;
			block_period = Integer.parseInt(value2);
			if(block_period >0)
			{
				if(str_block_period.length() > 0) str_block_period.delete(0,str_block_period.length());
				str_block_period.append("select to_char((sysdate+'"+block_period+"'/24),'dd/mm/rrrr hh24:mi') a from dual");
				stmt			=	con.createStatement();
				rset = stmt.executeQuery(str_block_period.toString());
				if (rset != null && rset.next())
				{
					blocked_until_date = rset.getString("a");
					if(blocked_until_date==null) blocked_until_date="";
					if(!(blocked_until_date==null || blocked_until_date.equals("")))
						blocked_until_date_converted = DateUtils.convertDate(blocked_until_date,"DMYHM","en",locale);

				}
				if(rset !=null) rset.close(); if(stmt != null) stmt.close();
				if(transfer_out.equals("transfer_out"))
				{
				  out.print("<script>parent.frames[2].document.forms[0].bed_block_until.value=\""+blocked_until_date_converted+"\";</script>");
				}
				else
				{
				out.print("<script>parent.frames[1].document.forms[0].bed_block_until.value=\""+blocked_until_date_converted+"\";</script>");
				}
			}
			else
			{
				if(transfer_out.equals("transfer_out"))
				{							
					out.print("<scriptparent.frames[2].document.forms[0].bed_block_until.value='';parent.frames[2].document.forms[0].bed_blocking_period.focus();</script>");
				}
				else
				{ 	    		
					out.print("<script>parent.frames[1].document.forms[0].bed_block_until.value='';parent.frames[1].document.forms[0].bed_blocking_period.focus();</script>");
				}
			}
		}
		if (reqParam.equals("executeQuery"))
		{
			if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
			sqlQuery.append("SELECT DISTINCT pract_role, PRACTITIONER_ID, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name FROM am_pract_for_team WHERE team_id = '" +selectedTeam+"' AND pract_role='C' ");
			stmt =	con.createStatement();
			rset = stmt.executeQuery(sqlQuery.toString());

			if (rset.next())
			{
				practid = checkForNull(rset.getString("PRACTITIONER_ID"));
				practitioner =checkForNull(rset.getString("practitioner_name"));
			}
			if(rset !=null) rset.close(); if(stmt != null) stmt.close();

			out.println("<script>parent.frames[1].document.forms[0].practid.value=\""+practid+"\" </script>");
			out.println("<script>parent.frames[1].document.forms[0].pract_desc.value=\""+practitioner+"\" </script>");
		}
		else if (priority_code_form.equals("priority_value"))
		{
			String expire_period	= "";
			stmt = con.createStatement();
			rset =stmt.executeQuery("select EXPIRE_YN, EXPIRY_PERIOD from ip_transfer_priority where "+   "facility_id='"+facilityId+"' and "+ "PRIORITY_CODE='"+prioritycode+"' and EFF_STATUS = 'E' ");

			while(rset!=null && rset.next())
			{
				expire_period= checkForNull(rset.getString("EXPIRY_PERIOD"));
			}
			if(rset !=null) rset.close(); 
			if(stmt != null) stmt.close();
			
			if (expire_period != null)
			{ 
				String exp_date_time ="";
				String sql_exp_date="select to_char((sysdate+'"+expire_period+"'/24),'dd/mm/rrrr hh24:mi') exp_date_time from dual ";
				stmt = con.createStatement();
				rset =stmt.executeQuery(sql_exp_date);
				if (rset!=null && rset.next())
				{	
					exp_date_time= checkForNull(rset.getString("exp_date_time"));
					out.println("<script>parent.frames[1].document.forms[0].exp_date_time.value = \""+exp_date_time+"\";</script>");	
				}
				  if(rset !=null) rset.close(); if(stmt != null) stmt.close();
			}
		 }
		else if (from.equals("patientcode_value"))
		{	
			from = "";
			StringBuffer sql_nu = new StringBuffer();
			sql_nu.append("select PATIENT_CLASS from ip_nursing_unit_vw where FACILITY_ID = '"+facilityId+"' and EFF_STATUS = 'E' and NURSING_UNIT_SHORT_DESC = '"+patient_nursingunit+"'");
			stmt_nu = con.createStatement();
					rset_nu = stmt_nu.executeQuery(sql_nu.toString());								
					if((rset_nu != null) && (rset_nu.next()))
					{
						patient_class_code = checkForNull(rset_nu.getString("PATIENT_CLASS"));
					}
					if(rset_nu !=null) rset_nu.close(); if(stmt_nu != null) stmt_nu.close();

			out.println("<script>parent.frames[2].document.AdmitPatient_form.patient_class_id.value = \""+patient_class_code+"\";</script>");
		}
		
		else if ((from.equals("TransferOutForm")) && (!value2.equals("")) )
		{
			StringBuffer sqlBuffer	= new StringBuffer();
			String info_pat_name	= "";
			if (value3.equals("01"))
			{
				sqlBuffer.append("select contact1_name info_pat_name from mp_pat_rel_contacts where patient_id = '");
				sqlBuffer.append(value2);
				sqlBuffer.append("' ");
			}
			else if (value3.equals("02"))
			{
				sqlBuffer.append("select contact2_name info_pat_name from mp_pat_rel_contacts where patient_id = '");
				sqlBuffer.append(value2);
				sqlBuffer.append("' ");
			}
			
			pstmt	=	con.prepareStatement(sqlBuffer.toString());
			rset	=	pstmt.executeQuery();	
			if ((rset != null) && (rset.next()))
				info_pat_name = checkForNull(rset.getString("info_pat_name"));
			
			if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();

			if (value5.equals("TransferOut") && (info_pat_name.equals("")))
			{
				out.println("<script>parent.frames[2].document.forms[0].info_pat_name.value = '';");	
			}
			else if ((value5.equals("TransferIn")) && (info_pat_name.equals("")) )
			{
				out.println("<script>parent.frames[1].document.forms[0].informed_name.value = '';</script>");	
			}

			if ((value5.equals("TransferIn")) &&  (!info_pat_name.equals("")))
			{
				%>
				<script>
				parent.frames[1].document.forms[0].informed_name.value = "<%=info_pat_name%>";
				if(parent.frames[1].document.forms[0].informed_name.value.disabled==true)
				{ 			   
					parent.frames[1].document.forms[0].informed_name.value.disabled=false;
					parent.frames[1].document.forms[0].informed_name.value.focus();
				}
				</script>
				<%
			}
			else if ((value5.equals("TransferOut")) && ((!info_pat_name.equals(""))))
			{
				out.println("<script>parent.frames[2].document.forms[0].info_pat_name.value = \""+info_pat_name+"\"; parent.frames[2].document.forms[0].info_pat_name.focus();</script>");
			}
			return;
		}
				
		else if(from.equals("Transfer_form"))
		{

			String nursingcode  =	value3;
			bedno				=	value5;

			String request_tfr	=	checkForNull(request.getParameter("field1"));
			if(request_tfr.equals("request_tfr"))
			{
				/*StringBuffer strBuffer=new StringBuffer();
				strBuffer.delete(0, strBuffer.length());
				strBuffer.append(" select to_char(date_of_birth,'dd/mm/rrrr') date_of_birth ,sex ");
				strBuffer.append("from mp_patient where patient_id = '"+patient_id+"' ");
				
				stmt = con.createStatement();
				rset = stmt.executeQuery(strBuffer.toString());
				dateofbirth = "";
				if(rset.next())
				{
					patientgender = rset.getString("sex") == null ? "" : rset.getString("sex");
					dateofbirth = rset.getString("date_of_birth") == null ? "" : rset.getString("date_of_birth");
				}
					if(rset !=null) rset.close(); if(stmt != null) stmt.close();

				strBuffer.delete(0, strBuffer.length());
				strBuffer.append(" SELECT age_group_code,locn_type FROM ip_nursing_unit WHERE "); strBuffer.append("facility_id='"+facilityId+"' and nursing_unit_code='"+nursingcode+"' ");
				stmt=con.createStatement();
				rset = stmt.executeQuery(strBuffer.toString());
				if (rset.next())
				{
					String agegrpcode = rset.getString(1) == null ? "" : rset.getString(1);
					if(rset !=null) rset.close(); if(stmt != null) stmt.close();

					if(!agegrpcode.equals(""))
					{
						strBuffer.delete(0, strBuffer.length());
						strBuffer.append("Select '1' from am_age_group Where age_group_code='"+agegrpcode+"' ");
						strBuffer.append("And NVL(GENDER,'"+patientgender+"')= '"+patientgender+"' AND ");
						strBuffer.append("trunc(SYSDATE)- to_date('"+dateofbirth+"','dd/mm/rrrr') BETWEEN ");
						strBuffer.append("DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE ");
						stmt=con.createStatement();
						rset = stmt.executeQuery(strBuffer.toString());
						if(!rset.next())
						{*/
							%>	
							<script>
							/*if(parent.frames[1].document.forms[0].nursing_unit_desc)
							{
								alert(getMessage('AGE_GENDER_NOT_ALLOWED','IP'));
								parent.frames[1].document.forms[0].nursing_unit_desc.value='';
								parent.frames[1].document.forms[0].service.value='';
								parent.frames[1].document.forms[0].sub_service.value='';
								parent.frames[1].document.forms[0].nursing_unit.value='';
								parent.frames[1].document.forms[0].nursing_unit_desc.focus();
							}
							else if(parent.frames[2].document.forms[0].nursing_unit_desc)
							{
								if(parent.frames[2].document.forms[0].name=='EmergencyTransfer_form')
								{
									alert(getMessage('AGE_GENDER_NOT_ALLOWED','IP'));
									parent.frames[2].document.forms[0].nursing_unit_desc.value='';
									parent.frames[2].document.forms[0].service.value='';
									parent.frames[2].document.forms[0].sub_service.value='';
									parent.frames[2].document.forms[0].nursing_unit_code.value='';
									parent.frames[2].document.forms[0].nursing_unit_desc.focus();
								}
							}*/
							</script>	
							<%
			}
			if(!to_bed_no.equals(""))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select room_no, bed_type_code, bed_class_code, specialty_code from ip_nursing_unit_bed where nursing_unit_code = '"+nursingcode+"' and bed_no='"+to_bed_no+"' and eff_status = 'E' and facility_id = '"+facilityId+"' " );
				stmt	=	con.createStatement();
				rset	=	stmt.executeQuery(sql.toString());

				if(rset != null)
				{
					if(rset.next())
					{
						roomno				=	checkForNull(rset.getString("room_no"));
						String bedClassCode	=	checkForNull(rset.getString("bed_class_code"));
					
						if(value8.equals("from_tfrout"))
						{	
							out.println("<script>parent.frames[2].document.forms[0].to_room_no.value=\""+roomno+"\";parent.frames[2].document.forms[0].Bedcode.value=\""+bedClassCode+"\";</script>");
						}
						else
						{
							out.println("<script>parent.frames[1].document.forms[0].to_room_no.value=\""+roomno+"\";parent.frames[1].document.forms[0].Bedcode.value=\""+bedClassCode+"\";parent.frames[1].document.forms[0].BalnkFlag.value = 'Y';</script>");
						}
						
					}
					else
					{
						if(value8.equals("from_tfrout"))
						{
						out.println("<script> if(parent.frames[2].document.forms[0].name == \"BedBookingTransfer_form\") parent.frames[2].document.forms[0].continue_yn.value=\"N\"; alert(getMessage('INVALID_BED','IP'));parent.frames[2].document.forms[0].to_room_no.value='';parent.frames[2].document.forms[0].to_bed_no.focus();parent.frames[2].document.forms[0].to_bed_no.select();parent.frames[2].document.forms[0].to_bed_no.value='';</script>");
						}
						else
						{
						out.println("<script> if(parent.frames[1].document.forms[0].name = \"BedBookingTransfer_form\") parent.frames[1].document.forms[0].continue_yn.value=\"N\"; alert(getMessage('INVALID_BED','IP'));parent.frames[1].document.forms[0].BalnkFlag.value = 'N';parent.frames[1].document.forms[0].to_room_no.value='';parent.frames[1].document.forms[0].to_bed_no.focus();parent.frames[1].document.forms[0].to_bed_no.select();parent.frames[1].document.forms[0].to_bed_no.value='';</script>");
						}
					}
				}
				if(rset !=null) rset.close(); if(stmt != null) stmt.close();
			}
			else if(!bedno.equals(""))
			{
				if(value9.equals("Y"))
				{
					String bed_class_code=value1;
					String bed_type_code=value2;
					
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("select" );
					sql.append("  NURSING_UNIT_CODE" );
					sql.append("  , IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID,NURSING_UNIT_CODE,'"+locale+"',2 ) NURSING_UNIT_SHORT_DESC" );
					sql.append("  ,ROOM_NO" );
					sql.append("  , BED_TYPE_CODE" );
					sql.append("  , IP_GET_DESC.IP_BED_TYPE(BED_TYPE_CODE,'"+locale+"',2 ) BED_TYPE_SHORT_DESC" );
					sql.append("  , BED_CLASS_CODE" );
					sql.append("  ,IP_GET_DESC.IP_BED_CLASS(BED_CLASS_CODE,'"+locale+"',2 ) BED_CLASS_SHORT_DESC" );
					sql.append("  , SPECIALTY_CODE" );
					sql.append("  , AM_GET_DESC.AM_SPECIALITY(SPECIALTY_CODE,'"+locale+"',2 ) SPECAILTY_SHORT_DESC " );
					sql.append(" from" );
					sql.append("  IP_NURSING_UNIT_BED " );
					sql.append("where NURSING_UNIT_CODE = '"+nursingcode+"' " );
					sql.append("  and BED_NO='"+bedno+"' " );
					sql.append("  and BED_TYPE_CODE='"+bed_type_code+"' " );
					sql.append("  and BED_CLASS_CODE='"+bed_class_code+"' " );
					sql.append("  and FACILITY_ID = '"+facilityId+"' " );
					sql.append("  and EFF_STATUS = 'E' " );
					sql.append("  and MAIN_BED_NO is" );
					sql.append("  NULL" );
				}
				else
				{
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append("select" );
					sql.append("  NURSING_UNIT_CODE" );
					sql.append("  ,IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID,NURSING_UNIT_CODE,'"+locale+"',2 ) NURSING_UNIT_SHORT_DESC" );
					sql.append("  ,ROOM_NO" );
					sql.append("  , BED_TYPE_CODE" );
					sql.append("  , IP_GET_DESC.IP_BED_TYPE(BED_TYPE_CODE,'"+locale+"',2 ) BED_TYPE_SHORT_DESC" );
					sql.append("  , BED_CLASS_CODE" );
					sql.append("  ,IP_GET_DESC.IP_BED_CLASS(BED_CLASS_CODE,'"+locale+"',2 ) BED_CLASS_SHORT_DESC" );
					sql.append("  , SPECIALTY_CODE" );
					sql.append("  ,AM_GET_DESC.AM_SPECIALITY(SPECIALTY_CODE,'"+locale+"',2 ) SPECAILTY_SHORT_DESC " );									 
					sql.append("from" );
					sql.append("  IP_NURSING_UNIT_BED " );
					sql.append("where NURSING_UNIT_CODE = '"+nursingcode+"' " );
					sql.append("  and BED_NO='"+bedno+"' " );
					sql.append("  and FACILITY_ID = '"+facilityId+"' " );
					sql.append("  and EFF_STATUS = 'E' " );
					sql.append("  and MAIN_BED_NO is" );
					sql.append("  NULL" );
						
				}
				
				stmt	=	con.createStatement();
				rset	=	stmt.executeQuery(sql.toString());
				
				
				if(rset.next())
				{				
						
					String bedtypecode	=	checkForNull(rset.getString("bed_type_code"));
					String bedtypedesc	=	checkForNull(rset.getString("bed_type_short_desc"));
					roomno				=	checkForNull(rset.getString("room_no"));
					String bedClassCode=checkForNull(rset.getString("bed_class_code"));
				
					if(value8.equals("from_tfrout"))
					{	
					out.println("<script>parent.frames[2].document.forms[0].to_room_no.value=\""+roomno+"\";parent.frames[2].document.forms[0].Bedcode.value=\""+bedClassCode+"\";</script>");
					}
					else
					{
						if(value10.equals("assign_bed"))
						{
							
								out.println("<script>parent.frames[1].document.forms[0].to_room_no.value=\""+roomno+"\";parent.frames[1].document.forms[0].Bedcode.value=\""+bedClassCode+"\";var obj =parent.frames[1].document.forms[0].Bedtype;var length  = obj.length;for(i=0;i<length;i++){obj.remove(0);} var opt= parent.frames[1].document.createElement('Option');opt.text=\""+bedtypedesc+"\";opt.value=\""+bedtypecode+"\";opt.selected = true;obj.add(opt);parent.frames[1].document.createElement('Option');</script>");
						}
						else
						{
							out.println("<script>parent.frames[1].document.forms[0].to_room_no.value=\""+roomno+"\";parent.frames[1].document.forms[0].Bedcode.value=\""+bedClassCode+"\";var obj =parent.frames[1].document.forms[0].bed_type_code;var length  = obj.length;for(i=0;i<length;i++){obj.remove(0);} var opt= parent.frames[1].document.createElement('Option');opt.text=\""+bedtypedesc+"\";opt.value=\""+bedtypecode+"\";opt.selected = true;obj.add(opt);parent.frames[1].document.createElement('Option');</script>");
						}
					}
				}
				else
				{
					if(value8.equals("from_tfrout"))
					{
						out.println("<script> if(parent.frames[2].document.forms[0].name = \"BedBookingTransfer_form\") parent.frames[2].document.forms[0].continue_yn.value=\"N\"; if(parent.frames[2].document.forms[0].name = \"EmergencyTransfer_form\") parent.frames[2].document.forms[0].continue_yn.value=\"N\";  alert(getMessage('INVALID_BED','IP'));parent.frames[2].document.forms[0].to_room_no.value='';parent.frames[2].document.forms[0].to_bed_no.focus();parent.frames[2].document.forms[0].to_bed_no.select(); </script>");
					}
					else
					{
						out.println("<script> if(parent.frames[1].document.forms[0].name = \"BedBookingTransfer_form\") parent.frames[1].document.forms[0].continue_yn.value=\"N\"; if(parent.frames[1].document.forms[0].name = \"EmergencyTransfer_form\") parent.frames[1].document.forms[0].continue_yn.value=\"N\";alert(getMessage('INVALID_BED','IP'));parent.frames[1].document.forms[0].to_room_no.value='';/*parent.frames[1].document.forms[0].to_bed_no.focus();parent.frames[1].document.forms[0].to_bed_no.select();*/ parent.frames[1].document.forms[0].to_bed_no.value = ''</script>");

					}
				}
				if(rset !=null) rset.close(); if(stmt != null) stmt.close();
				//out.println("checking for error");
			}
			else if (!nursingcode.equals(""))
			{
			if(value8.equals("from_tfrout"))
			{
				out.print("<script>parent.frames[2].document.forms[0].change_bed_class_yn.value=\""+change_bed_class_yn+"\";</script>");
				
			}
			else
			{									    					out.print("<script>if(parent.frames[1].document.forms[0].change_bed_class_yn)parent.frames[1].document.forms[0].change_bed_class_yn.value=\""+change_bed_class_yn+"\";</script>");//code   modified  for [IN:046920] 
			}
			if(value8.equals("from_tfrout"))
			{
				String allow_trans_booking ="";
				String NURSING_UNIT_CODE="";
				String value7				=	checkForNull(request.getParameter("field7"));

				StringBuffer sql_nu = new StringBuffer();
			
				sql_nu.append("select allow_emerg_trf_yn, nursing_unit_code,ip_get_desc.IP_NURSING_UNIT(facility_id,NURSING_UNIT_CODE,'"+locale+"',2 ) nursing_unit_short_desc from IP_NURSING_UNIT where  facility_id = '"+facilityId+"' and eff_status = 'E' and nursing_unit_code = '"+nursingcode+"'");
				stmt_nu = con.createStatement();
				rset_nu = stmt_nu.executeQuery(sql_nu.toString());

				if((rset_nu != null) && (rset_nu.next()))
				{
					allow_trans_booking = rset_nu.getString("ALLOW_EMERG_TRF_YN");
					NURSING_UNIT_CODE = rset_nu.getString("NURSING_UNIT_CODE");
					
					if(!value7.equals(NURSING_UNIT_CODE))
					{
						if (allow_trans_booking.equals("N"))
						{
						
						out.println("<script>alert(getMessage( 'EMER_TRANSFER_NOT_ALLOWED','IP'));parent.frames[2].document.forms[0].nursing_unit_desc.value='';parent.frames[2].document.forms[0].nurs_desc_hid.value='';parent.frames[2].document.forms[0].nursing_unit_code.value='';</script>");
						allow_trans_booking ="";
						return;
						}
					}
					if(rset_nu !=null) rset_nu.close(); if(stmt != null) stmt.close();
					
				}
				}
				String addlservice = "";
				if(sql.length() > 0) sql.delete(0,sql.length());
				
				sql.append("select service_code from Ip_nursing_unit where Facility_id='"+facilityId+"' and  EFF_STATUS = 'E' and nursing_unit_code='"+nursingcode+"'");

				stmt = con.createStatement();
				rset = stmt.executeQuery(sql.toString());
		
				if(rset != null && rset.next())
				{
					servicecode			=	checkForNull(rset.getString("service_code"));
					if(value8.equals("from_tfrout"))
					{
						out.print("<script>parent.frames[2].document.forms[0].service.value=\""+servicecode+"\";</script>");
					 }
					else
					{
						out.print("<script>parent.frames[1].document.forms[0].service.value=\""+servicecode+"\";</script>");
					}
				 }
				out.println("<script>");
				if(rset !=null) rset.close(); if(stmt != null) stmt.close();
				if(value8.equals("from_tfrout"))
				{
				out.println("var obj =parent.frames[2].document.forms[0].service;");
				}
				else
				{
				out.println("var obj =parent.frames[1].document.forms[0].service;");
				}
				out.println("var length  = obj.length;");
				out.println("for(i=0;i<length;i++) {obj.remove(1);}");
				
				if(sql.length() > 0) sql.delete(0,sql.length());				
				sql.append("select service_code,am_get_desc.AM_SERVICE(SERVICE_CODE,?,2 ) service_short_desc from ip_nurs_unit_for_service where facility_id = ? and nursing_unit_code = ? union select service_code,am_get_desc.AM_SERVICE(SERVICE_CODE,?,2 ) service_short_desc from ip_nursing_unit where facility_id = ? and EFF_STATUS = 'E' and nursing_unit_code = ? order by 2");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,nursingcode);
				pstmt.setString(4,locale);
				pstmt.setString(5,facilityId);
				pstmt.setString(6,nursingcode);
				rset = pstmt.executeQuery();								
				while (rset.next())
				{
					addlservice			=	checkForNull(rset.getString("service_code"));
					servicedesc			=	checkForNull(rset.getString("service_short_desc"));
					if(value8.equals("from_tfrout"))
					{
					//out.println ("var opt= parent.frames[2].document.createElement('Option');\nopt.text=\""+servicedesc+"\"; opt.value=\""+addlservice+"\";if(\""+servicecode+"\"== \""+addlservice+"\") opt.selected = true;\nobj.add(opt)") ;
					/*Friday, February 12, 2010 ,GHL-SCF-200,IN018739 ,allow user to select service , not to default service when nursing unit is selected*/
					out.println ("var opt= parent.frames[2].document.createElement('Option');\nopt.text=\""+servicedesc+"\"; opt.value=\""+addlservice+"\";\nobj.add(opt)") ;
					out.println ("parent.frames[2].document.createElement('Option')") ;
					}
					else
					{
					//out.println ("var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+servicedesc+"\"; opt.value=\""+addlservice+"\";if(\""+servicecode+"\"== \""+addlservice+"\") opt.selected = true;\nobj.add(opt)") ;
					/*Friday, February 12, 2010 ,GHL-SCF-200,IN018739 ,allow user to select service , not to default service when nursing unit is selected*/
					out.println ("var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+servicedesc+"\"; opt.value=\""+addlservice+"\";\nobj.add(opt)") ;
					out.println ("parent.frames[1].document.createElement('Option')") ;
					}
				}
				out.println("</script>");
				if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
				out.println("<script>");
				if(value8.equals("from_tfrout"))
				{
				out.println("var obj1 =parent.frames[2].document.forms[0].sub_service;");
				}
				else
				{
				out.println("var obj1 =parent.frames[1].document.forms[0].sub_service;");
				}
				out.println("var length1  = obj1.length;");
				out.println("for(i=0;i<length1;i++) {obj1.remove(1);}");
				out.println("</script>");
				
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("Select SUBSERVICE_CODE, am_get_desc.AM_SUBSERVICE(SERVICE_CODE,SUBSERVICE_CODE,?,2 )  SUBSERVICE_SHORT_DESC from am_facility_subsrvc where OPERATING_FACILITY_ID = ? AND EFF_STATUS = 'E' AND SERVICE_CODE = ? order by 2");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,servicecode);
				rset = pstmt.executeQuery();

				while(rset != null && rset.next())
				{
					subservicecode			=	checkForNull(rset.getString("SUBSERVICE_CODE"));
					subservicedesc			=	checkForNull(rset.getString("SUBSERVICE_SHORT_DESC"));
					
					if(value8.equals("from_tfrout"))
					{
						//out.println ("<script> var opt1= parent.frames[2].document.createElement('Option');\n opt1.text=\""+subservicedesc+"\"; opt1.value=\""+subservicecode+"\"; opt1.selected = true;\n obj1.add(opt1);</script>");
						out.println ("<script> var opt1= parent.frames[2].document.createElement('Option');\n opt1.text=\""+subservicedesc+"\"; opt1.value=\""+subservicecode+"\"; \n obj1.add(opt1);</script>");
						out.println ("<script>parent.frames[2].document.createElement('Option');</script>") ;
					}
					else
					{
						
						//out.println ("<script> var opt1= parent.frames[1].document.createElement('Option');\n opt1.text=\""+subservicedesc+"\"; opt1.value=\""+subservicecode+"\"; \n opt1.selected = true;obj1.add(opt1);</script>");
						out.println ("<script> var opt1= parent.frames[1].document.createElement('Option');\n opt1.text=\""+subservicedesc+"\"; opt1.value=\""+subservicecode+"\"; \n obj1.add(opt1);</script>");
						out.println ("<script>parent.frames[1].document.createElement('Option');</script>") ;
					}
				}
				if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
				String popbedclass	= checkForNull(request.getParameter("popbedclass"));
				nursingcode			= checkForNull(request.getParameter("field3"));
				if(popbedclass.equals("BedClass"))
				{

					out.println("<script>");
					if(value8.equals("from_tfrout"))
					{
					out.println("var obj1 =parent.frames[2].document.forms[0].to_bed_class;");
					}
					else
					{
					out.println("var obj1 =parent.frames[1].document.forms[0].Bedcode;");
					}
					out.println(" var length1  = obj1.length;");
					out.println("for(i=0;i<length1;i++) {obj1.remove(1);}");
					out.println("</script>");
					if(sql.length() > 0) sql.delete(0,sql.length());
					//sql.append("select distinct a.bed_class_code, b.short_desc from ip_nursing_unit_bed a, ip_bed_class_lang_vw b where a.nursing_unit_code = '"+nursingcode+"' and a.bed_class_code  = b.bed_class_code and b.language_id='"+locale+"' order by a.bed_class_code");
					/*Wednesday, May 05, 2010 modified for PE*/
					sql.append("select distinct bed_class_code, ip_get_desc.ip_bed_class(bed_class_code,?,2)short_desc from ip_nursing_unit_bed  where nursing_unit_code = ?  order by short_desc");
					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1,locale);
					pstmt.setString(2,nursingcode);
					rset = pstmt.executeQuery();
					String bedClassCode = "";
					String bedClassDesc = "";
					while(rset != null && rset.next())
					{
						bedClassCode			=	checkForNull(rset.getString("bed_class_code"));
						bedClassDesc			=	checkForNull(rset.getString("short_desc"));
						if(value8.equals("from_tfrout"))
						{
							out.println ("<script> var opt1= parent.frames[2].document.createElement('Option');\n opt1.text=\""+bedClassDesc+"\"; opt1.value=\""+bedClassCode+"\"; opt1.selected = true;\n obj1.add(opt1);</script>");
							out.println ("<script>parent.frames[2].document.createElement('Option');</script>") ;
						}
						else
						{
							out.println ("<script> var opt1= parent.frames[1].document.createElement('Option');\n opt1.text=\""+subservicedesc+"\"; opt1.value=\""+subservicecode+"\"; \n opt1.selected = true;obj1.add(opt1);</script>");
							out.println ("<script>parent.frames[1].document.createElement('Option');</script>") ;
						}
					}
					out.println("</script>");
				}
				if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
			
			}
			else if (!servcode.equals("")||servcode.equals(""))
			{
				if(!value10.equals("assign_bed"))
				{
					out.println("<script>");
					if(value8.equals("from_tfrout"))
					{
						out.println("var obj =parent.frames[2].document.forms[0].sub_service;");
					}
					else
					{
						out.println("var obj =parent.frames[1].document.forms[0].sub_service;");
					}
					out.println("var length  = obj.length;");

					out.println("for(i=0;i<length;i++) {obj.remove(1);}");

					String subservice_code = "", subservice_desc = "";
					StringBuffer sersql = new StringBuffer();
					sersql.append("Select SUBSERVICE_CODE,am_get_desc.AM_SUBSERVICE(SERVICE_CODE,SUBSERVICE_CODE,?,2 )  SUBSERVICE_SHORT_DESC from am_facility_subsrvc where SERVICE_CODE = ? and eff_status = 'E' and OPERATING_FACILITY_ID = ? order by 2");
					pstmt = con.prepareStatement(sersql.toString());
					pstmt.setString(1,locale);
					pstmt.setString(2,servcode);
					pstmt.setString(3,facilityId);
					rset = pstmt.executeQuery();

					if(rset!=null )
					{
						
						while(rset.next())
						{
							subservice_code  = checkForNull(rset.getString("SUBSERVICE_CODE"));
							subservice_desc = checkForNull(rset.getString("SUBSERVICE_SHORT_DESC"));
							if(value8.equals("from_tfrout"))
							{
								out.println ("var opt= parent.frames[2].document.createElement('Option');\nopt.text=\""+subservice_desc+"\"; opt.value=\""+subservice_code+"\"; obj.add(opt)");
								out.println ("parent.frames[2].document.createElement('Option')") ;
							}
							else
							{
							
								out.println ("var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+subservice_desc+"\"; opt.value=\""+subservice_code+"\"; obj.add(opt)");
								out.println ("parent.frames[1].document.createElement('Option')") ;
							}
						}
						if(rset !=null) rset.close(); if(pstmt != null) pstmt.close();
					}
					out.println("</script>");
				}
			}
			}
		else if(c_from.equals("Confirm_transfer"))	{
			String nursingcode  =	value3;
			bedno				=	value5;
			
			
			if(!to_bed_no.equals(""))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select room_no, bed_type_code,bed_class_code,specialty_code from ip_nursing_unit_bed where nursing_unit_code = '"+nursingcode+"' and bed_no='"+to_bed_no+"' and eff_status = 'E' and facility_id = '"+facilityId+"' " );

				stmt	=	con.createStatement();
				rset	=	stmt.executeQuery(sql.toString());

				if(rset != null)
				{
					if(rset.next())
					{
						roomno				=	checkForNull(rset.getString("room_no"));
						String bedClassCode	=	checkForNull(rset.getString("bed_class_code"));
						out.println("<script>parent.frames[1].document.forms[0].to_room_no.value=\""+roomno+"\";parent.frames[1].document.forms[0].Bedcode.value=\""+bedClassCode+"\";</script>");
					}
					else
					{
						out.println("<script> if(parent.frames[1].document.forms[0].name == \"BedBookingTransfer_form\") parent.frames[1].document.forms[0].continue_yn.value=\"N\"; alert(getMessage('INVALID_BED','Common'));parent.frames[1].document.forms[0].to_room_no.value='';parent.frames[1].document.forms[0].to_bed_no.focus();parent.frames[1].document.forms[0].to_bed_no.select();</script>");
					}
					if(rset !=null) rset.close(); if(stmt != null) stmt.close();
				}
			}
			else if(!bedno.equals(""))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select room_no, bed_type_code,bed_class_code,specialty_code, b.short_desc  from ip_nursing_unit_bed a, am_speciality_lang_vw b where a.eff_status = 'E' and nursing_unit_code = '"+nursingcode+"' and bed_no='"+bedno+"' and facility_id = '"+facilityId+"' and a.specialty_code = b.speciality_code (+) and b.language_id='"+locale+"'");
				
				stmt	=	con.createStatement();
				rset	=	stmt.executeQuery(sql.toString());

				if(rset.next())
				{
					roomno				=	checkForNull(rset.getString("room_no"));
					String bedClassCode=checkForNull(rset.getString("bed_class_code"));
					out.println("<script>parent.frames[1].document.forms[0].to_room_no.value=\""+roomno+"\";parent.frames[1].document.forms[0].Bedcode.value=\""+bedClassCode+"\";</script>");
				}
				else
				{
					out.println("<script> if(parent.frames[1].document.forms[0].name = \"BedBookingTransfer_form\") parent.frames[1].document.forms[0].continue_yn.value=\"N\"; if(parent.frames[1].document.forms[0].name = \"EmergencyTransfer_form\") parent.frames[1].document.forms[0].continue_yn.value=\"N\";  alert(getMessage('INVALID_BED','Common'));parent.frames[1].document.forms[0].to_room_no.value='';parent.frames[1].document.forms[0].to_bed_no.focus();parent.frames[1].document.forms[0].to_bed_no.select(); </script>");
				}
				if(rset !=null) rset.close(); if(stmt != null) stmt.close();
			}
			
			else if (!nursingcode.equals(""))
			{
				String addlservice = "";
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("select service_code from Ip_nursing_unit where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingcode+"'");
				
				stmt = con.createStatement();
				rset = stmt.executeQuery(sql.toString());

				if(rset != null && rset.next())
				{
					servicecode			=	checkForNull(rset.getString("service_code"));
					out.print("<script>parent.frames[2].document.forms[0].service.value=\""+servicecode+"\";</script>");					
				}
				out.println("<script>");
				if(rset !=null) rset.close(); if(stmt != null) stmt.close();
				out.println("var obj =parent.frames[1].document.forms[0].service;");
				out.println("var length  = obj.length;");
				out.println("for(i=0;i<length;i++) {obj.remove(1);}");
				if(sql.length() > 0) sql.delete(0,sql.length());				
				sql.append("select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"',2 ) service_short_desc from ip_nurs_unit_for_service where facility_id = '"+facilityId+"' and nursing_unit_code = '"+nursingcode+"' union select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"',2 ) service_short_desc from ip_nursing_unit where facility_id = '"+facilityId+"' and nursing_unit_code = '"+nursingcode+"' order by 2 ");
				
				stmt = con.createStatement();
				rset = stmt.executeQuery(sql.toString());								
				while (rset.next())
				{
					addlservice			=	checkForNull(rset.getString("service_code"));
					servicedesc			=	checkForNull(rset.getString("service_short_desc"));
					out.println ("var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+servicedesc+"\"; opt.value=\""+addlservice+"\";if(\""+servicecode+"\"== \""+addlservice+"\") opt.selected = true;\nobj.add(opt)") ;
					out.println ("parent.frames[1].document.createElement('Option')") ;
				}
				out.println("</script>");
				if(rset !=null) rset.close(); if(stmt != null) stmt.close();
				out.println("<script>");
				out.println("var obj1 =parent.frames[1].document.forms[0].sub_service;");
				out.println("var length1  = obj1.length;");
				out.println("for(i=0;i<length1;i++) {obj1.remove(1);}");
				out.println("</script>");
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("Select SUBSERVICE_CODE,am_get_desc.AM_SUBSERVICE(SERVICE_CODE,SUBSERVICE_CODE,'"+locale+"',2 ) SUBSERVICE_SHORT_DESC from am_facility_subsrvc where OPERATING_FACILITY_ID = '"+facilityId+"' AND EFF_STATUS = 'E' AND SERVICE_CODE = '"+addlservice+"' order by 2");
				stmt = con.createStatement();
				rset = stmt.executeQuery(sql.toString());
				while(rset != null && rset.next())
				{
					subservicecode			=	checkForNull(rset.getString("SUBSERVICE_CODE"));
					subservicedesc			=	checkForNull(rset.getString("SUBSERVICE_SHORT_DESC"));
					out.println ("<script> var opt1= parent.frames[1].document.createElement('Option');\n opt1.text=\""+subservicedesc+"\"; opt1.value=\""+subservicecode+"\"; opt1.selected = true;\n obj1.add(opt1);</script>");
					out.println ("<script>parent.frames[1].document.createElement('Option');</script>") ;
				}
				if(rset !=null) rset.close(); if(stmt != null) stmt.close();
			}
			else if (!servcode.equals("") ||servcode.equals(""))
			{
				out.println("<script>");
				out.println("var obj =parent.frames[1].document.forms[0].sub_service;");
				out.println("var length  = obj.length;");
				out.println("for(i=0;i<length;i++) {obj.remove(1);}");

				String subservice_code = "", subservice_desc = "";
				StringBuffer sersql = new StringBuffer();
				sersql.append("Select SUBSERVICE_CODE,am_get_desc.AM_SUBSERVICE(SERVICE_CODE,SUBSERVICE_CODE,'"+locale+"',2 ) SUBSERVICE_SHORT_DESC from am_facility_subsrvc where SERVICE_CODE = '"+servcode+"' and eff_status = 'E' and OPERATING_FACILITY_ID = '"+facilityId+"' order by SUBSERVICE_SHORT_DESC");
				stmt = con.createStatement();
				rset = stmt.executeQuery(sersql.toString());

				if(rset!=null )
				{
					while(rset.next())
					{
						subservice_code  = checkForNull(rset.getString("SUBSERVICE_CODE"));
						subservice_desc = checkForNull(rset.getString("SUBSERVICE_SHORT_DESC"));
						
						out.println ("var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+subservice_desc+"\"; opt.value=\""+subservice_code+"\"; opt.selected = true;\nobj.add(opt)");
						out.println ("parent.frames[1].document.createElement('Option')") ;
					}
					if(rset !=null) rset.close(); if(stmt != null) stmt.close();
				}
				out.println("</script>");
			}
		}else if(c_from.equals("INTRA_WARD_TFR")){//Added for PE On 4/29/2010 Query executed by Intra ward Transfer on click of Reserve Bed.%>
					<script>
						
		var obj =parent.Transfer_frame.document.EmergencyTransfer_form.reason_for_reserved_bed;
						var length  = obj.length;
						for(i=0;i<length;i++) {obj.remove(1);}
					</script>
			<%
						
					String reason_code="";
					String reason_desc="";

					// this query changed by jayashree for SRR20056-SCF-7627 [IN: 27703] on 5/7/2011 removed added facility id
					String RESERV_BED_SQL="SELECT  a.BLOCKING_TYPE_CODE, IP_GET_DESC.IP_BLOCKING_TYPE(a.BLOCKING_TYPE_CODE,'"+locale+"','2') SHORT_DESC FROM IP_BLOCKING_TYPE a WHERE  a.EFF_STATUS = 'E' ORDER BY a.SHORT_DESC";
					pstmt =con.prepareStatement(RESERV_BED_SQL);
					rs=pstmt.executeQuery();
					while(rs.next()){
							reason_code = rs.getString("BLOCKING_TYPE_CODE");
							reason_desc = rs.getString("SHORT_DESC");
							%>
						<script>
							var opt= parent.Transfer_frame.document.createElement('Option');
							opt.value="<%=reason_code%>";
							opt.text="<%=reason_desc%>";
							obj.add(opt);
						</script>
				<%}
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}else if(c_from.equals("INTRA_WARD_N_OTHERS")){%>
						<script>
							var obj =parent.Transfer_frame.document.EmergencyTransfer_form.Bedcode;
							var length  = obj.length;
							for(i=0;i<length;i++) {obj.remove(1);}
						</script>
				  <%
					if(sql.length() > 0) sql.delete(0,sql.length());
					String function_Id		= checkForNull(request.getParameter("function_Id"));
					 fr_bed_class_code	= checkForNull(request.getParameter("fr_bed_class_code"));
					
					if(function_Id.equals("Transfer_patient")){
							if(deactivate_pseudo_bed_yn.equals("Y")){
								//StrBuf.append(" SELECT DISTINCT a.bed_class_code, b.short_desc FROM ip_nursing_unit_bed a, IP_BED_CLASS_LANG_VW b WHERE language_id='"+locale+"' and a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = '"+frnursingunitcode+"' AND a.bed_class_code = b.bed_class_code AND a.psuedo_bed_status = 'N' ORDER BY b.short_desc ");
								/*Wednesday, April 28, 2010 , Modified for PE*/
								sql.append(" SELECT DISTINCT bed_class_code, ip_get_desc.ip_bed_class(bed_class_code,?,2)short_desc FROM ip_nursing_unit_bed  WHERE facility_id = ? AND eff_status = 'E' AND nursing_unit_code = ? AND psuedo_bed_status = 'N' and bed_no like '%%' ORDER BY short_desc ");
							}else{
								//StrBuf.append(" SELECT DISTINCT a.bed_class_code, b.short_desc FROM ip_nursing_unit_bed a, IP_BED_CLASS_LANG_VW b WHERE language_id='"+locale+"' and  a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = '"+frnursingunitcode+"' AND a.bed_class_code = b.bed_class_code ORDER BY b.short_desc ");
								/*Wednesday, April 28, 2010 , Modified for PE*/
								sql.append(" SELECT DISTINCT bed_class_code, ip_get_desc.ip_bed_class(bed_class_code,?,2)short_desc FROM ip_nursing_unit_bed  WHERE facility_id = ? AND eff_status = 'E' AND nursing_unit_code = ? and bed_no like '%%' ORDER BY short_desc ");
							}
					}else{
							//StrBuf.append("Select bed_class_code,short_desc from IP_BED_CLASS_LANG_VW where language_id='"+locale+"' and  eff_status='E' order by short_desc ");
							/*Wednesday, April 28, 2010 ,modifed for PE*/
							sql.append("Select bed_class_code,ip_get_desc.ip_bed_class(bed_class_code,?,2)short_desc from IP_BED_CLASS where eff_status='E' order by short_desc ");
					}
					String bedcode="";
					String beddesc="";
					pstmt = con.prepareStatement(sql.toString());
					if(function_Id.equals("Transfer_patient")){
						pstmt.setString(1,locale);
						pstmt.setString(2,facilityId);
						pstmt.setString(3,nursingunitcode);
					}else{
						pstmt.setString(1,locale);
					}
					rs = pstmt.executeQuery();
						while(rs.next()){
							bedcode   = rs.getString("bed_class_code") ;
							beddesc   = rs.getString("short_desc") ;
						%>
							<script>
								var opt= parent.Transfer_frame.document.createElement('Option');
								opt.value="<%=bedcode%>";
								opt.text="<%=beddesc%>";
								if("<%=bedcode%>"=="<%=fr_bed_class_code%>"){
									opt.selected=true;
								}
								obj.add(opt);
								parent.frames[1].document.createElement('Option');
							</script>
				<%
						}
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();%>
						<script>
								getBedtype_tfrDtls();
						</script>
			<%}else if(c_from.equals("Transfer_Out")){//Added for PE On Tuesday, May 04, 2010 Query executed by Transfer Patient Out on click of Reserve Bed.%>
					<script>
						var obj =parent.Transfer_frame.document.EmergencyTransfer_form.reason_for_reserved_bed;
						var length  = obj.length;
						for(i=0;i<length;i++) {obj.remove(1);}
					</script>
			<%
					String blocking_remarks = request.getParameter("blocking_remarks");

                    
					if(blocking_remarks == null) blocking_remarks = "";
					String reason_code="";
					String reason_desc="";

					String RESERV_BED_SQL="SELECT  a.BLOCKING_TYPE_CODE, IP_GET_DESC.IP_BLOCKING_TYPE(a.BLOCKING_TYPE_CODE,'"+locale+"','2') SHORT_DESC FROM IP_BLOCKING_TYPE a WHERE a.EFF_STATUS = 'E' ORDER BY a.SHORT_DESC";
					pstmt =con.prepareStatement(RESERV_BED_SQL);
					rs=pstmt.executeQuery();
					while(rs.next()){
							reason_code = rs.getString("BLOCKING_TYPE_CODE");
							reason_desc = rs.getString("SHORT_DESC");
                   
							%>
						<script>
							var opt= parent.Transfer_frame.document.createElement('Option');
							opt.value="<%=reason_code%>";
							opt.text="<%=reason_desc%>";
							if("<%=reason_code%>"=="<%=blocking_remarks%>"){
									opt.selected=true;
								}
							obj.add(opt);
						</script>
				<%}
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}else if(c_from.equals("Cancel_Reason")){
			%>
				<script>
						var obj =parent.Transfer_frame.document.EmergencyTransfer_form.cancel_reason;
						var length  = obj.length;
						for(i=0;i<length;i++) {obj.remove(1);}
				</script>
			<%	   String  code="";
					String desc="";
					String reasonQuery="select contact_reason_code, am_get_desc.am_contact_reason(contact_reason_code,?,1)contact_reason from am_contact_reason where EFF_STATUS ='E' and cancel_transfer_yn = 'Y' order by contact_reason";
					pstmt =con.prepareStatement(reasonQuery);
					pstmt.setString(1,locale);
					rs=pstmt.executeQuery();
					while(rs.next()){
							code = rs.getString(1);
							desc = rs.getString(2);
			%>
						<script>
							var opt= parent.Transfer_frame.document.createElement('Option');
							opt.value="<%=code%>";
							opt.text="<%=desc%>";
							obj.add(opt);
						</script>
			<%}
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}		
	
	
		if(rset != null ) rset.close();
		if(rs != null ) rs.close();
		if(stmt_nu != null) stmt_nu.close();
		if(rset_nu != null) rset_nu.close();
		if(stmt != null) stmt.close();
		if(pstmt != null) pstmt.close();

	}catch(Exception e)
	{			
		

		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</form>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

