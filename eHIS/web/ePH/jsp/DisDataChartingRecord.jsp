<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.io.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 endss
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src='../../ePH/js/DisDataCharting.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/dchk.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
    Connection con = null;
    try {
			con = ConnectionManager.getConnection(request);
			PreparedStatement stmt  = null;
			PreparedStatement stmt1 = null;
		    ResultSet rset=null ;
			ResultSet rset1=null ;
			//java.util.Properties jdbc_props = (java.util.Properties) session.getValue("jdbc");
			//commented on 10 October 2005 - when called from OP clinician Id was being passed as null so taking practitioner_id from the session.
			//String clinicianid		=	(String)jdbc_props.getProperty("clinician_id");
			String clinicianid		=	(String) session.getAttribute("ca_practitioner_id") == null ? "" : (String) session.getAttribute("ca_practitioner_id");
			//out.println("clinicianid = "+clinicianid);
		    String facilityId = (String) session.getValue( "facility_id" ) ;
			String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
			String episodeid = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
			String episodetype = request.getParameter("episode_type")==null?"I":request.getParameter("episode_type");
			String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
			String visitid = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");
			if(visitid.equals("") && episodetype.equals("I")) visitid = "1";
			String batteryid = request.getParameter("battery_id")==null?"":request.getParameter("battery_id");
			//out.println("batteryid = "+batteryid);
			String patientid = request.getParameter("patient_id");
			String admdttime = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
			String locncode = request.getParameter("location_code")==null?"": request.getParameter("location_code");

			String patsex = request.getParameter("Sex")==null?"": request.getParameter("Sex");
//ss
			String amerepMode=request.getParameter("amerepMode")==null?"N":request.getParameter("amerepMode");
//se
			if(patsex.equals("Male")) patsex="M";
			else if(patsex.equals("Female")) patsex="F";
			else patsex="U";

			String mode = request.getParameter("mode")==null?"": request.getParameter("mode");
			String dob = request.getParameter("Dob")==null?"": request.getParameter("Dob");
		    String lastrecorddate = request.getParameter("last_record_date")==null?"":request.getParameter("last_record_date");
			String amendMode = request.getParameter("amendMode")==null?"":request.getParameter("amendMode");
			String replaceMode = request.getParameter("replaceMode")==null?"":request.getParameter("replaceMode");
			String newlastrecorddate = request.getParameter("new_last_record_date")==null?"":request.getParameter("new_last_record_date");
			String module_id = request.getParameter("module_id")==null?"": request.getParameter("module_id");
			String location_type = request.getParameter("location_type")==null?"": request.getParameter("location_type");
		    
			String readOnly="";
			String listDisabled="";
			String disabled="";
			String errorRemarks="";
			String longTextVal = "";
			
			if(amendMode.equals("Y")){
					lastrecorddate=newlastrecorddate;
					readOnly = "readOnly";
					listDisabled = "disabled";
			}

		if(replaceMode.equals("Y")){
				lastrecorddate=newlastrecorddate;
				readOnly = "readOnly";
				listDisabled = "disabled";
		}
/************************/

		String accessionnum = "" ;                  
		String discrmsrid = "" ;                   
		String discrmsrresulttype = "" ;          

		int numdigitsdec = 0;

		String defnum =  "" ;
		String defstr =  "" ;
		String defdata =  "" ;
		//String defaultdata =  "" ;
		Clob defaultdata = null;
		String chkType =  "" ;
		String shortdesc = "";

		String	normabnormind = "";
		String refrangetype = "";
		String range = "";
		String optype = "";

		String mandatoryyn = "";
		String sysdatetime = "";

		int maxsize = 8;
		int i=0;
		String dat="";

		String sel="";

		int count=0;
		/* String highstr = "";
		String lowstr = "";
		String abnstr = "";
		String crithighstr = "";
		String critlowstr = "";
		String critabnstr = ""; */

		String highstr = "";
		String lowstr = "";
		String abnstr = "";
		String critstr = "";
		String crithighstr = "";
		String critlowstr = "";
	  
		String highstr_desc = "";
		String lowstr_desc = "";
		String abnstr_desc = "";
		String critstr_desc = "";
		String crithighstr_desc = "";
		String critlowstr_desc = "";

		String critabnstr = "";
		
		int numdigitsmax =0;
		int numdigitsmin = 0;
		String numuom = "";
		int numreflow = 0;
		int numrefhigh = 0;
		int numcritlow = 0;
		int numcrithigh = 0;

%>
</head>

<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onKeyPress='' >
<!-- <form name='DisDataCharting_form' id='DisDataCharting_form' action='../../servlet/eCA.DisDataChartingServlet' method='post' target='messageframe'>  -->
<form name='DisDataCharting_form' id='DisDataCharting_form' action='../../ePH/jsp/DisDataChartingSubmit.jsp' method='post' target='messageFrame'> 
	<table  id='detailTab' width="100%" cellspacing='0' cellpadding='3' border=0 align='center'>

		<tr>
			<td class='columnheadercenter'  width='10%'><fmt:message key="Common.Variable.label" bundle="${common_labels}"/></td>
			<td class='columnheadercenter'  colspan="2" width='20%'><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
		</tr>
    <%
    try {
		// check with Rajan what is the use of this query -- suresh
	StringBuffer sql=new StringBuffer();
	if(sql.length() > 0) sql.delete(0,sql.length());
	sql.append(" select HIGH_STR,LOW_STR,ABN_STR,CRIT_STR,CRIT_HIGH_STR,CRIT_LOW_STR,HIGH_STR_DESC,LOW_STR_DESC,ABN_STR_DESC,CRIT_HIGH_STR_DESC ");
	sql.append(" ,CRIT_LOW_STR_DESC,CRIT_STR_DESC from cr_clin_event_param ");
			//added on 6th Feb 2003
			stmt = con.prepareStatement(sql.toString());
			rset=stmt.executeQuery();
			if(rset!=null && rset.next())
			{
					highstr = rset.getString("HIGH_STR")==null?"":rset.getString("HIGH_STR");
					lowstr = rset.getString("LOW_STR")==null?"":rset.getString("LOW_STR");
					abnstr = rset.getString("ABN_STR")==null?"":rset.getString("ABN_STR");
					critstr = rset.getString("CRIT_STR")==null?"":rset.getString("CRIT_STR");
					crithighstr = rset.getString("CRIT_HIGH_STR")==null?"":rset.getString("CRIT_HIGH_STR");
					critlowstr = rset.getString("CRIT_LOW_STR")==null?"":rset.getString("CRIT_LOW_STR");
					highstr_desc = rset.getString("HIGH_STR_DESC")==null?"":rset.getString("HIGH_STR_DESC");
					lowstr_desc = rset.getString("LOW_STR_DESC")==null?"":rset.getString("LOW_STR_DESC");
					abnstr_desc = rset.getString("ABN_STR_DESC")==null?"":rset.getString("ABN_STR_DESC");
					crithighstr_desc = rset.getString("CRIT_HIGH_STR_DESC")==null?"":rset.getString("CRIT_HIGH_STR_DESC");
					critlowstr_desc = rset.getString("CRIT_LOW_STR_DESC")==null?"":rset.getString("CRIT_LOW_STR_DESC");
					critstr_desc = rset.getString("CRIT_STR_DESC")==null?"":rset.getString("CRIT_STR_DESC");
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
	//out.println("<script>alert('"+mode+"');</script>");
	//out.println("<script>alert('"+batteryid+"');</script>");
	//out.println("<script>alert('"+mode+"');</script>");
	//out.println("<script>alert('"+mode+"');</script>");
   if(mode.equals("U"))
   {
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" SELECT  a.discr_msr_id ");
		sql.append(" ,a.short_desc ");
		sql.append(" ,a.unit_of_measure ");
		sql.append(" ,a.result_type ");
		sql.append(" ,a.num_digits_max ");
		sql.append(" ,a.num_digits_min ");
		sql.append(" ,a.num_digits_dec ");
		sql.append(" ,a.mandatory_yn ");
		sql.append(" ,decode(nvl(b.discr_msr_id,'Y'),'Y','I','U') operation_type ");
		sql.append(" ,b.DISCR_MSR_RESULT_NUM default_num ");          
		sql.append(" ,b.DISCR_MSR_RESULT_STR  default_str ");          
		sql.append(" ,b.DISCR_MSR_RESULT_DATA default_data ");   
		sql.append(" ,b.NORM_ABNORM_IND ");
		sql.append(" ,b.ERROR_REMARKS error_remarks ");
		sql.append(" ,ACCESSION_NUM,REF_RANGE_TYPE,to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sysdatetime ");
		sql.append(" FROM am_discr_msr_battery_view a,ca_encntr_discr_msr b ");
		sql.append(" WHERE a.DISCR_MSR_BATTERY_ID	= ?  ");
		sql.append(" and ? = b.facility_id(+)  ");
		sql.append(" and a.discr_msr_id = b.discr_msr_id(+) ");
		sql.append(" and b.encounter_id = ? ");
		sql.append(" and b.TEST_OBSERV_DT_TM= to_date(?,'dd/mm/yyyy hh24:mi:ss') ");
		sql.append(" order by  a.ORDER_SRL_NO ");
	
		stmt = con.prepareStatement(sql.toString());
		
		stmt.clearParameters();
		stmt.setString(1,batteryid);
		stmt.setString(2,facilityId);
		stmt.setString(3,episodeid);
		stmt.setString(4,lastrecorddate);

	}
	else if(mode.equals("I"))
	{
		
		
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" SELECT  discr_msr_id ");
		sql.append(" , short_desc ");
		sql.append(" ,unit_of_measure ");
		sql.append(" ,result_type ");
		sql.append(" ,num_digits_max ");
		sql.append(" ,num_digits_min ");
		sql.append(" ,num_digits_dec ");
		sql.append(" ,mandatory_yn ");
		sql.append(" ,'I' operation_type ");
		sql.append(" ,null default_num ");          
		sql.append(" ,null  default_str ");          
		sql.append(" ,null default_data ");    
		sql.append(" ,NULL NORM_ABNORM_IND ");
		sql.append(" ,null error_remarks ");
		sql.append(" ,null ACCESSION_NUM ");
		sql.append(" , REF_RANGE_TYPE,to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sysdatetime ");
		sql.append(" FROM am_discr_msr_battery_view  ");
		sql.append(" where DISCR_MSR_BATTERY_ID = ? order by ORDER_SRL_NO ");

		//if(stmt!=null) stmt.close();
		stmt = con.prepareStatement(sql.toString());
		stmt.clearParameters();
		stmt.setString(1,batteryid);
	}
	/*
	out.println(sql.toString());
	out.println("batteryid-->"+batteryid);
	out.println("facilityId-->"+facilityId);
	out.println("episodeid-->"+episodeid);
	*/
	rset=stmt.executeQuery();

		while (rset.next())
		{
			
			i++;
			//out.println("count = "+i);
			errorRemarks= rset.getString("error_remarks")==null?"Æ":rset.getString("error_remarks"); 
			//char 146
			sysdatetime = rset.getString("sysdatetime");
			discrmsrid = rset.getString("discr_msr_id");
			//out.println("discr_msr_id ="+discrmsrid);
			shortdesc = rset.getString("short_desc");
			//out.println("shortdesc ="+shortdesc);
			discrmsrresulttype = rset.getString("result_type");
			//out.println("<script>alert('discrmsrresulttype ="+discrmsrresulttype+"');</script>");
			optype = rset.getString("operation_type");
			defnum = rset.getString("default_num")==null?"":rset.getString("default_num");
			//out.println("defnum ="+defnum);
			defstr = rset.getString("default_str")==null?"":rset.getString("default_str");
			//defaultdata = rset.getString("default_data");
			if(mode.equals("U"))
			{
				defaultdata = rset.getClob(12);
				if(defaultdata != null)
				{
					BufferedReader rd = new BufferedReader(defaultdata.getCharacterStream());
					/*for(int i=0;i<(((CLOB)defaultdata).length);i++)
					{
						longTextVal.append(rd.readLine());
					}*/
					char[] longTextContent = new char[(int)defaultdata.length()];
					rd.read(longTextContent,0,(int)defaultdata.length());
					longTextVal = new String(longTextContent);
					rd.close();
				}
			}
			//out.println("longTextVal ="+longTextVal);
			//out.println("defstr --"+defstr+"--");
			//out.println("defaultdata --"+defaultdata+"--");
			mandatoryyn = rset.getString("mandatory_yn")==null?"N":rset.getString("mandatory_yn");
			refrangetype = rset.getString("ref_range_type")==null?"":rset.getString("ref_range_type");
			normabnormind = rset.getString("NORM_ABNORM_IND")==null?"":rset.getString("NORM_ABNORM_IND");

			if(normabnormind.equals(highstr))
				normabnormind = highstr_desc;
			else if(normabnormind.equals(lowstr))
				normabnormind = lowstr_desc;
			else if(normabnormind.equals(abnstr))
				normabnormind = abnstr_desc;
			else if(normabnormind.equals(critstr))
				normabnormind = critstr_desc; 
			else if(normabnormind.equals(crithighstr))
				normabnormind = crithighstr_desc;
			else if(normabnormind.equals(critlowstr))
				normabnormind = critlowstr_desc; 

			numdigitsmax = rset.getInt("num_digits_max");
			numdigitsmin = rset.getInt("num_digits_min");
			numdigitsdec = rset.getInt("num_digits_dec");
			maxsize = numdigitsmax;
			accessionnum = rset.getString("ACCESSION_NUM")==null?"":rset.getString("ACCESSION_NUM");
			numuom = "";
			numreflow = 0;    
			numrefhigh = 0;   
			numcritlow = 0;   
			numcrithigh = 0;  
			
			range = "";
			
			StringBuffer valsql = new StringBuffer();
			
			valsql.append(" select num_uom, num_ref_low,num_ref_high,num_crit_low,num_crit_high ");
			valsql.append(" ,ref_range_seq from am_discr_msr_ref_rng_num ");
			valsql.append(" WHERE discr_msr_id= ? ");
			
			//out.println("refrangetype"+refrangetype);
			if(refrangetype.equals("M"))
			{
				valsql.append( " and patient_sex = ? ");
				valsql.append(" and ( to_date( ?,'dd/mm/yyyy') <= ");				
				valsql.append("decode(START_AGE_UNITS,'D',trunc(sysdate)-START_AGE,'M',add_months(trunc(sysdate),-1*START_AGE),'Y',add_months(trunc(sysdate),-12*START_AGE))) ");
				valsql.append(" and ( to_date( ?,'dd/mm/yyyy') >= ");
				valsql.append("decode(END_AGE_UNITS,'D',trunc(sysdate)-END_AGE,'M',add_months(trunc(sysdate),-1*END_AGE),'Y',add_months(trunc(sysdate),-12*END_AGE)) )");
			}
			
			stmt1 = con.prepareStatement(valsql.toString());
			
			stmt1.clearParameters();
			stmt1.setString(1,discrmsrid);
			
			if(refrangetype.equals("M"))
			{
				stmt1.setString(2,patsex);
				stmt1.setString(3,dob);
				stmt1.setString(4,dob);
			}

			rset1=stmt1.executeQuery();

			if(rset1.next()){
					numuom = rset1.getString("num_uom")==null?"":rset1.getString("num_uom");
					numreflow = rset1.getInt("num_ref_low");
					numrefhigh = rset1.getInt("num_ref_high");
					numcritlow = rset1.getInt("num_crit_low");
					numcrithigh = rset1.getInt("num_crit_high");
					
			}
			if(rset1 != null)rset1.close();
			if(stmt1 != null)stmt1.close();

			if(numreflow != 0 || numrefhigh !=0)
				range = numreflow+" - "+numrefhigh;

			if (!errorRemarks.equals("Æ")){
					readOnly = "readOnly";
					listDisabled = "disabled";
			}
			//out.println("sql.toString() = "+sql.toString());
		%>
		<tr>
			<td width="50%" id="short_desc_<%=i%>"><%=shortdesc%></td>
			<td width="50%" >
			<%
					if(discrmsrresulttype.equals("L"))
					{
					  int k = i;
			%>
					<Select name='str_id_<%=i%>' id='str_id_<%=i%>' onChange="javascript:chkNormalAbnormal(this,'<%=i%>')" >
					  <option value=''>&nbsp; -----Select------&nbsp;</option>
					  <%

							stmt1 = con.prepareStatement(" select ref_rng_desc,NORM_ABNORM_IND,DFLT_YN from am_discr_msr_ref_rng_list where  discr_msr_id= ?");
							stmt1.clearParameters();
							stmt1.setString(1,discrmsrid);
							rset1=stmt1.executeQuery();
							if(rset1!=null)
							{
							   while(rset1.next())
							   {
									dat=rset1.getString("ref_rng_desc").trim();
									String normal=rset1.getString("NORM_ABNORM_IND")==null?"N":rset1.getString("NORM_ABNORM_IND");
									String dfltyn = rset1.getString("DFLT_YN")==null?"N":rset1.getString("DFLT_YN");
									if(dfltyn.equals("Y"))
										sel="selected";
									if(dat.equals(defstr))
								   {
										if(normal.equals("A")) normabnormind = abnstr_desc;
										else if(normal.equals("C")) normabnormind = critstr_desc;
										sel="selected";
								   }
								   else
										sel="";
									out.println("<option class='"+normal+"' value='"+dat+"' "+sel+" >"+dat+"</option>");
									k++;
							   }
							}
							if(rset1 != null)rset1.close();
						    if(stmt1 != null)stmt1.close();
			%>
					</Select>
			<%
				}
				else if(discrmsrresulttype.equals("C"))
				{
					String chk = "";
					if(defstr.equals("Y"))
						chk = "checked";
					out.println("<input type='checkbox' name='str_id_"+i+"' id='str_id_"+i+"' value='Y' "+chk+">");
				}
				else if(discrmsrresulttype.equals("F"))
				{
					String display = "";
					if(defdata.indexOf("<html>")==-1)
						display = defdata;
					out.println("<textarea name='str_id_"+i+"' rows='3' cols='71'>"+longTextVal+"</textarea>");
					//out.println("<textarea name='str_id_"+i+"' rows='3' cols='71'>"+display+"</textarea>");
					//out.println("<img src='../../eCA/images/Xdetail.gif' onClick=\"addDetailText('"+i+"')\" ></img>");
				}
				else if(discrmsrresulttype.equals("N"))
				{
					if (numdigitsmax==0) { numdigitsmax=22; maxsize=22;}
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defnum+"'  OnKeyPress =\"return allowValidNumber(this,event,'"+numdigitsmax+"','"+numdigitsdec+"')\" onBlur=\"  validateNumber(this,'"+numreflow+"','"+numrefhigh+"','"+i+"','"+numdigitsdec+"','"+numcritlow+"','"+numcrithigh+"','"+numdigitsmin+"','"+module_id+"','"+shortdesc+"')\" >");
				}
				else if(discrmsrresulttype.equals("I"))
				{
					//maxsize = numdigitsmax;
					if(numdigitsmax == 0) maxsize = 3;
					//out.println("maxsize="+maxsize);
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defnum+"'  OnKeyPress =\"return allowValidNumber(this,event,'"+numdigitsmax+"',0)\" onBlur=\"  validateNumber(this,'"+numreflow+"','"+numrefhigh+"','"+i+"','"+numdigitsdec+"','"+numcritlow+"','"+numcrithigh+"','"+numdigitsmin+"','"+module_id+"','"+shortdesc+"')\" >"); 
				}
				else if(discrmsrresulttype.equals("H"))
				{
					//out.println("maxsize = "+maxsize);
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='60' maxlength='4000' value = '"+defstr+"' >");
				}
				
				else
				{
					 if(discrmsrresulttype.equals("E"))
					{
						maxsize = 16;
						chkType = "return CheckForSpecCharsForDateTime(event)";
					}
					 else if(discrmsrresulttype.equals("D"))
					{
						 maxsize = 10;
						 chkType = "return CheckForSpecCharsForDate(event)";
					}
					 else if(discrmsrresulttype.equals("T"))
					{
						 maxsize =5;
						 chkType = "return CheckForSpecChars(event)";
					}
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defstr+"' OnKeyPress =\""+chkType+"\" onblur= \" return validateDateTime(this,'"+discrmsrresulttype+"'); \"  >");
				}

				if(mandatoryyn.equals("Y") && !discrmsrresulttype.equals("C"))
					out.println("<img align=center src='../../eCommon/images/mandatory.gif'></img>");
			%>
			<%if(!discrmsrresulttype.equals("F")){%>
				<%=numuom%>&nbsp;<%=range%>
			<%}%>
			</td>
				
<td nowrap id='abcd'>
			<input type="hidden" name="item_id_<%=i%>" id="item_id_<%=i%>" value="<%=discrmsrid%>" >
			<input type="hidden" name="uom_id_<%=i%>" id="uom_id_<%=i%>" value="<%=numuom%>" >
			<input type="hidden" name="normal_low_<%=i%>" id="normal_low_<%=i%>" value="<%=numreflow%>" >
			<input type="hidden" name="normal_high_<%=i%>" id="normal_high_<%=i%>" value="<%=numrefhigh%>" >
			<input type="hidden" name="num_digits_dec_<%=i%>" id="num_digits_dec_<%=i%>" value="<%=numdigitsdec%>" >	
			<input type="hidden" name="op_type_<%=i%>" id="op_type_<%=i%>" value="<%=optype%>" >
			<input type="hidden" name="result_type_<%=i%>" id="result_type_<%=i%>" value="<%=discrmsrresulttype%>" >
			<input type="hidden" name="num_crit_low_<%=i%>" id="num_crit_low_<%=i%>" value="<%=numcritlow%>" >					
			<input type="hidden" name="num_crit_high_<%=i%>" id="num_crit_high_<%=i%>" value="<%=numcrithigh%>" >	
			<input type="hidden" name="accession_num_<%=i%>" id="accession_num_<%=i%>" value="<%=accessionnum%>" >
			<input type="hidden" name="def_data_<%=i%>" id="def_data_<%=i%>" value='<%=defdata%>' >	
			<input type="hidden" name="norm_abnorm_ind_<%=i%>" id="norm_abnorm_ind_<%=i%>" value='<%=normabnormind%>' >		
			<input type="hidden" name="mandatory_yn_<%=i%>" id="mandatory_yn_<%=i%>" value='<%=mandatoryyn%>' >			
			</td></tr>
			<%
		//	i++;
		}
			//out.println("sql.toString() = "+sql.toString());
		 
            if(rset!=null) rset.close();
			 if(stmt!=null) stmt.close();
			 if(rset1!=null) rset1.close();
			 if(stmt1!=null) stmt1.close();
			// while (rset.next());
			//end while

			if(!(batteryid.equals("")) && i == 0)
			{
				out.println("<script>alert(getMessage('NO_DISCR_MSR','CA'))</script>");
				out.println("<script>window.close();</script>");
			}
			else if(batteryid.equals(""))
			{
				out.println("<script>alert(getMessage('NO_BATTERY','CA'))</script>");
				out.println("<script>window.close();</script>");
			}
        }catch(Exception e){
                out.println("Inqq   "+e.toString());
				e.printStackTrace(System.err);
        }
        
        %>
		
        
        </table>
        <input type="hidden" name="no_of_rec" id="no_of_rec" value="<%=i%>" >
        <input type="hidden" name="last_record_date" id="last_record_date" value="<%=lastrecorddate%>" >
		<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>" >
		<input type="hidden" name="episode_id" id="episode_id" value="<%=episodeid%>" >
		<input type="hidden" name="episode_type" id="episode_type" value="<%=episodetype%>" >
		<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>" >
		<input type="hidden" name="visit_id" id="visit_id" value="<%=visitid%>" >
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>" >
		<input type="hidden" name="clinician_id" id="clinician_id" value="<%=clinicianid%>" >
		<input type="hidden" name="adm_dt_time" id="adm_dt_time" value="<%=admdttime%>" >
		<input type="hidden" name="locn_code" id="locn_code" value="<%=locncode%>" >
		<input type="hidden" name="low_str" id="low_str" value="<%=lowstr_desc%>" >
		<input type="hidden" name="high_str" id="high_str" value="<%=highstr_desc%>" >
		<input type="hidden" name="abn_str" id="abn_str" value="<%=abnstr_desc%>" >
		<input type="hidden" name="crit_low_str" id="crit_low_str" value="<%=critlowstr_desc%>" >
		<input type="hidden" name="crit_high_str" id="crit_high_str" value="<%=crithighstr_desc%>" >
		<input type="hidden" name="crit_abn_str" id="crit_abn_str" value="<%=critabnstr%>" >
		<input type="hidden" name="battery_id" id="battery_id" value="<%=batteryid%>" >	
		<input type="hidden" name="sys_date_time" id="sys_date_time" value="<%=sysdatetime%>" >
		<input type="hidden" name="in_error" id="in_error" value="<%=amendMode%>" >
		<input type="hidden" name="in_replace" id="in_replace" value="<%=replaceMode%>" >
		<input type="hidden" name="module_id" id="module_id" value='<%=module_id%>' >
		<input type="hidden" name="location_type" id="location_type" value='<%=location_type%>' >
		<input type="hidden" name="replaceError_count" id="replaceError_count" value='<%=count%>' >

</form>
</body>
</html>

<%
	} catch ( Exception e) {
			out.println("Out "+e);
	}finally {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
%>

