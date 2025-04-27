<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>	
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String locale =((String)session.getAttribute("LOCALE"));
%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
    <script src='../js/NewbornRegistration.js' language='javascript'></script>
	<script src='../js/NewbornRegistration1.js' language='javascript'></script>
	<script src='../js/NewbornRegistration2.js' language='javascript'></script>
	<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>
	<script>
		function closeWindow(){
			parent.window.close();
		}
		async function callNewbornAssessmentNote(){
			var patient_id	= document.forms[0].patient_id.value;
			var accession_num	= parent.frames[2].document.forms[0].accession_num_nb_note.value;
			var q_finalized_yn	= parent.frames[2].document.forms[0].q_finalized_yn.value;
			var data_upd_allowed_aft_final_yn	= parent.frames[2].document.forms[0].data_upd_allowed_aft_final_yn.value;
			var chd_encounter_id	= document.forms[0].chd_encounter_id.value;
			var chd_patient_class	= document.forms[0].chd_patient_class.value;
			var retVal =    new String();
			var features =	"dialogHeight:41; dialogWidth:82; dialogTop:80  ; scroll=no; status:no";
			var arguments   = '' ;
			var isShowEditMode	= "Y";
			if(q_finalized_yn=="Y" && data_upd_allowed_aft_final_yn=="N"){
				isShowEditMode	= "N";
			}
			if(isShowEditMode=="Y"){
				retVal =await window.showModalDialog("../../eCA/jsp/RecClinicalNotesModal.jsp?function_id=BIRTH_REG_NOTES&appl_task_id=BIRTH_REG_NOTES&patient_id="+patient_id+"&accession_num="+accession_num+"&encounter_id="+chd_encounter_id+"&patient_class="+chd_patient_class+"&Field_Ref=parent.newbornheader_frame.document.forms[0].accession_num",arguments,features);
				if(retVal !=null && retVal !=undefined){
					var retValArr	= retVal.split("###");
					if(retValArr[1] !="Success"){
						parent.frames[2].document.forms[0].accession_num_nb_note.value	= "";
					}else{
						parent.frames[2].document.forms[0].accession_num_nb_note.value	= retValArr[0];
					}
				}
			}else{
				var action_url = "../../eCA/jsp/ViewMotherLinkedNotesMain.jsp?function_id=BIRTH_REG_NOTES&appl_task_id=BIRTH_REG_NOTES&patient_id="+patient_id+"&accession_num="+accession_num+"&encounter_id="+chd_encounter_id+"&patient_class="+chd_patient_class;
				var features =	"dialogHeight:41; dialogWidth:82; dialogTop:80  ; scroll=no; status:no";
				var  arguments = "";
				var returnValue=window.showModalDialog(action_url,arguments,features);
			}
		}
	</script>
</head>

<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onSelect="codeArrestThruSelect()" onLoad="" >
<form name='NewbornRegistration_form' id='NewbornRegistration_form'>
<%
	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rset          = null;	
    String facilityId           = (String)session.getValue("facility_id");
    String function_id = request.getParameter("function_id") ;
    if(function_id == null)function_id = "" ;
    String motherid                     = request.getParameter("mother_id")==null?"":request.getParameter("mother_id");
    String newbornpatsergrp     = request.getParameter("new_born_pat_ser_grp")==null?"":request.getParameter("new_born_pat_ser_grp");
    String nb_use_mother_ser= request.getParameter("nb_use_mother_ser")==null?"N":request.getParameter("nb_use_mother_ser");
    String patient_id_length= request.getParameter("patient_id_length")==null?"":request.
	getParameter("patient_id_length");
	String invoked_from = request.getParameter("invoked_from")==null?"":request.getParameter("invoked_from");
	String siteId = request.getParameter("siteId")==null?"":request.getParameter("siteId");
	String calling_module_id = request.getParameter("calling_module_id")==null?"":request.getParameter("calling_module_id");
	String chd_id = request.getParameter("chd_id")==null?"":request.getParameter("chd_id");
	String buttonType = request.getParameter("buttonType")==null?"R":request.getParameter("buttonType");
	String disable_button_yn = request.getParameter("disable_button_yn")==null?"N":request.getParameter("disable_button_yn");
	Boolean isNewBornChngsAppl = false;

	if(disable_button_yn.equals("Y"))
		disable_button_yn = "disabled";
	else
		disable_button_yn = "";

    String sql                  = "";
    //String site                 = "";
    String sel                  = "";

    //GregorianCalendar cal=new GregorianCalendar();
    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
    java.util.Date dt=new java.util.Date();

	String d = dateFormat.format( dt ) ;
	String sec = String.valueOf(dt.getMinutes());
	if ((sec).length()==1) sec="0"+sec; else sec = sec;
	d=d + " "+String.valueOf(dt.getHours())+":"+sec;
    String ip_install_yn = request.getParameter("ip_install_yn")==null?"N":request.getParameter("ip_install_yn");
    String mpsg ="";
    String mpsd ="";
    String gen_pat_id_yn = "";
    String patReadOnly = "";
    PreparedStatement smpsg=null;
    ResultSet rmpsg=null;
	/*
    String min_weight  = "";
	String max_weight  = "";
	String min_chest_circum = "";
	String max_chest_circum = "";
	String min_head_circum = ""; 
	String max_head_circum = ""; 
	String min_length = "";
	String max_length = "";
	String min_gestation = "";
	String max_gestation = "";
	*/
	//Added by kumar on 18/03/2003 for Malaysia Enhancements.
	//String pat_name_as_multipart_yn = "";
	String function_id_new			=""; 		

	try{
	function_id_new			= checkForNull(request.getParameter("function_id_new"));
	con = ConnectionManager.getConnection(request);
	isNewBornChngsAppl		 = CommonBean.isSiteSpecific(con,"IP","REG_NEW_BORN_FOR_IP_FLD_CHNGS");//Added by Dharma on 30th May 2018 against ML-MMOH-CRF-0898 [IN:064757]
	String chd_encounter_id	 = "";
	String chd_patient_class	 = "";
	if(isNewBornChngsAppl && "MAINTAIN_BIRTH".equals(function_id_new)){
		HashMap ResultHashMap = new HashMap();
		HashMap sqlColumns = new HashMap();
		sqlColumns.put("encounter_id","S");
		sqlColumns.put("patient_class","S");
		String wClause	= "where adt_status != '09' and discharge_date_time IS NULL and patient_class IN ('IP', 'DC') and patient_id='"+chd_id+"'";
		ResultHashMap = CommonBean.getParamDetails(sqlColumns,wClause,"PR_ENCOUNTER",con);
		chd_encounter_id				 = checkForNull((String) ResultHashMap.get("encounter_id"));
		chd_patient_class				 = checkForNull((String) ResultHashMap.get("patient_class"));
		chd_encounter_id				 = chd_encounter_id.equals("") ? "0" : chd_encounter_id;
		chd_patient_class				 = chd_patient_class.equals("") ? "XT" : chd_patient_class;
		sqlColumns.clear();
		ResultHashMap.clear();
	}

	/*
	pstmt = con.prepareStatement("select install_yn from sm_module where module_id = 'IP' ");
    rset = pstmt.executeQuery();
    if (rset!=null && rset.next())
    {
       ip_install_yn = rset.getString(1);
       if (ip_install_yn==null) ip_install_yn = "";
    }
	
	if(pstmt!=null) pstmt.close();
	if(rset!=null) rset.close();
	*/
	if(function_id_new.equals("REGISTER_NEWBORN")){
	//try
   // {
		 
		//con = ConnectionManager.getConnection(request);	
        
        if(nb_use_mother_ser.equals("Y"))
        {
            try
            {
            String sqlpg = "select m.pat_ser_grp_code, p.short_desc, gen_pat_id_yn from mp_patient m, mp_pat_ser_grp_lang_vw p where p.pat_ser_grp_code = m.pat_ser_grp_code and m.patient_id = ? and p.language_id='"+locale+"'";
            smpsg = con.prepareStatement(sqlpg);
            smpsg.setString(1,motherid) ;
            rmpsg = smpsg.executeQuery();
            if(rmpsg.next())
            {
                mpsg=rmpsg.getString(1);
                mpsd=rmpsg.getString(2);
                gen_pat_id_yn = rmpsg.getString(3);
            }
            }
            catch(Exception e)
            {
                out.println(e);
            }
            finally
            {
                if(rmpsg!=null)rmpsg.close();
                if(smpsg!=null)smpsg.close();
            }

        }
   		/*
		pstmt = con.prepareStatement("select install_yn from sm_module where module_id = 'IP' ");
        rset = pstmt.executeQuery();
        if (rset!=null && rset.next())
        {
            ip_install_yn = rset.getString(1);
            if (ip_install_yn==null) ip_install_yn = "";
        }
		*/

		/*
    }
    catch(Exception ex)
    {
        out.println(ex.toString());
    }                           
	finally
	{
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
	}
	*/

   	/*
	try{
     pstmt = con.prepareStatement("select site_id from sm_site_param ");
     rset = pstmt.executeQuery();
     if(rset.next())
     {
         site = rset.getString("site_id");
     }
    }catch(Exception e) { out.println(e.toString());}
	finally
	{
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
	}
	*/
   
	
%>


<%
	//Added by kumar on 15/09/2002 for Additional validation for min and max
	/*
	try
	{
		 //if(pstmt!=null) pstmt.close();
		 //if(rset!=null) rset.close();
		 pstmt = con.prepareStatement("select min_weight, max_weight, min_chest_circum, max_chest_circum, min_head_circum, max_head_circum, min_length, max_length, min_gestation, max_gestation, pat_name_as_multipart_yn from  mp_param where module_id=?");
		 pstmt.setString(1, "MP");
		 rset = pstmt.executeQuery();
		 if(rset.next())
		 {
			min_weight  = rset.getString("min_weight");
			max_weight  = rset.getString("max_weight");
			min_chest_circum  = rset.getString("min_chest_circum");
			max_chest_circum  = rset.getString("max_chest_circum");
			min_head_circum  = rset.getString("min_head_circum");
			max_head_circum  = rset.getString("max_head_circum");
			min_length  = rset.getString("min_length");
			max_length  = rset.getString("max_length");
			min_gestation  = rset.getString("min_gestation");
			max_gestation  = rset.getString("max_gestation");
			pat_name_as_multipart_yn = rset.getString("pat_name_as_multipart_yn");
			if (pat_name_as_multipart_yn.equals("N"))
			{
			}
			else
			{
			}

			if (min_weight==null) min_weight = "";
			if (max_weight==null) min_weight = "";
			if (min_length==null) min_length = "";
			if (max_length==null) min_length = "";
			if (min_chest_circum==null) min_chest_circum = "";
			if (max_chest_circum==null) max_chest_circum = "";
			if (min_head_circum==null) min_head_circum = "";
			if (max_head_circum==null) max_head_circum = "";
			if (min_gestation==null) min_gestation = "";
			if (max_gestation==null) max_gestation = "";
		 }
    }
	catch(Exception e) { out.println(e.toString());}
    finally
    {
        if (pstmt != null) pstmt.close();
        if (rset != null) rset.close();
    }

	*/
    out.println("<script language = 'javascript'> var PSGCodeArray = new Array(); var PSGYNArray = new Array(); var PSGPRYNArray = new Array(); var NamePrefixArray = new Array(); var PrefixSexArray = new Array();");	
    try{
        pstmt=con.prepareStatement("select pat_ser_grp_code, gen_pat_id_yn, prefix_reqd_yn from mp_pat_ser_grp where id_type not in ('R', 'X') ");
        rset = pstmt.executeQuery();
        int k =0;
        while ( rset.next() )
        {
            out.println("PSGCodeArray["+k+"]='"+rset.getString(1)+"';");
            out.println("PSGYNArray["+k+"]='"+rset.getString(2)+"';");
			out.println("PSGPRYNArray["+k+"]='"+rset.getString(3)+"';");
            k++;
        }
    }catch(Exception e) { out.println(e.toString());}
    finally
    {
        if (pstmt != null) pstmt.close();
        if (rset != null) rset.close();
    }
     out.println("</script>");

	Properties p;		
	p = (Properties) session.getValue("jdbc");
	String loginUser				= (String)session.getAttribute("login_user");
	HashMap hashMap		= new HashMap();
	hashMap = eMP.ChangePatientDetails.getSetupData(facilityId,"",con,p);
	String pat_ser_access_by_user_yn = checkForNull((String)hashMap.get("PAT_SER_ACCESS_BY_USER_YN"));
	String usedStatusSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE used_status = 'N') ";
	String userAccessSql	= "";
	if(pat_ser_access_by_user_yn.equals("Y")){
		userAccessSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM MP_PAT_SER_GRP_FOR_USER WHERE APPL_USER_ID = '"+loginUser+"') ";
	}
    
%>


     
<table width="100%" cellpadding=0 cellspacing=0 border=0 style="margin-top: 10px;">
    <tr>
        <td  class='label' width='18.9%' ><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/>
		<input type = 'hidden' name = 'nb_use_mother_ser' id = 'nb_use_mother_ser' value = '<%=nb_use_mother_ser%>' ></td>	   
        <td  class='FIELDS' width='20%'><select name="pat_ser_grp_code" id="pat_ser_grp_code" onChange="checkPatGenYN()">		
			<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------
            <%
                    try{
                        String whereClause = "";
						if(nb_use_mother_ser.equals("N"))
							whereClause="and id_type in ('B','U') ";

						sql     =   "select pat_ser_grp_code,short_desc from mp_pat_ser_grp_lang_vw where gen_pat_id_yn = 'Y' "+whereClause+" and id_type not in ('R', 'X') and language_id='"+locale+"' and (pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where site_or_facility_id = decode(site_or_facility,'S','"+siteId+"','F','"+facilityId+"') and used_status = 'N') OR ASSOCIATED_PAT_SER_GRP_CODE IS NOT NULL) "+userAccessSql+" union select pat_ser_grp_code,short_desc from mp_pat_ser_grp_lang_vw where  language_id='"+locale+"' and gen_pat_id_yn = 'N' "+whereClause+" and id_type not in ('R', 'X') "+usedStatusSql+" "+userAccessSql+" order by 2";	
				        pstmt   = con.prepareStatement(sql);
                        rset        = pstmt.executeQuery();

                        while(rset.next()) 
                        {
                            if(nb_use_mother_ser.equals("N"))
							{
								if(rset.getString("pat_ser_grp_code").equals(newbornpatsergrp))
									sel = "selected";
								else
									sel = "";
							}
							else
							{
								if(rset.getString("pat_ser_grp_code").equals(mpsg))
									sel = "selected";
								else
									sel = "";

							}
                            out.println("<option value='"+rset.getString("pat_ser_grp_code")+"' "+sel+">" + rset.getString("short_desc")+"</option>"); 
                        }
                    }catch(Exception e) { out.println(e.toString());}
                    finally
                    {
                        if (pstmt != null) pstmt.close();
                        if (rset != null) rset.close();
						//if(con!=null) //ConnectionManager.returnConnection(con,request);
                    }

            %>
            </select><img align=center src='../../eCommon/images/mandatory.gif'></img>
        </td>
                <% 
                %>
            <%
                %>
        <%
         if (gen_pat_id_yn.equals("Y") || mpsd.equals("")) 
            patReadOnly = "readOnly";
         %>
        <td class='label' width='20%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
        <td nowrap class='FIELDS' width='20%'><input class='upper' type="text" name="patient_id" id="patient_id" maxlength='<%=patient_id_length%>' size="20" <%=patReadOnly%> disabled onFocus="loadPatSeriesManual()" onBlur="makeValidString(this);checkPatientId()"
		onKeyPress='return CheckForSpecChars(event)'
		value=""><!--<img align=center src='../../eCommon/images/mandatory.gif'></img>-->
        </td>
		<!-- img commented and disabled added by mujafar for ML-MMOH-SCF-1039 -->
		<td class='fields' width = '20%'>
		<%
			if(buttonType.equals("R")) { 
				out.println("<input type='button' class='button' name='add_records' id='add_records' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Register.label","common_labels")+"' "+disable_button_yn+" onClick='addRecords();'>");		
			} else if(buttonType.equals("F")){
				out.println("<input type='button' class='button' name='add_records' id='add_records' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Finalize.label","common_labels")+"' "+disable_button_yn+" onClick='addRecords();'>");	
			}
			if (ip_install_yn.equals("Y") && calling_module_id.equals("IP")) { 
				out.println("<input type='button' class='button' name='close_win' id='close_win' value ='" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels") +"' onClick='closeWindow();'>");
			}
				
		%>
		</td>
		<td class='fields' width = '20%'    >
		<% out.println("<input type='button' class='button'  name='auditTrial' id='auditTrial' id ='auditButton' style='visibility:hidden'   value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AuditTrail.label","common_labels")+"'  onClick='viewAuditTrail();'>"); %>
		</td>
    </tr>	
</table>
<br>
<%}else{

	String pat_ser_grp_code = request.getParameter("pat_ser_grp_code")==null?"":request.getParameter("pat_ser_grp_code");
	String pat_ser_grp_desc = request.getParameter("pat_ser_grp_desc")==null?"":request.getParameter("pat_ser_grp_desc");

	/*
	HashMap hashMap=new HashMap();
	HashMap hashMap13=new HashMap();
	hashMap = eMP.NewbornDetails.getNewbornData(motherid, con, p);
	String q_pat_ser_grp_desc =  (String) hashMap.get("q_pat_ser_grp_desc") == null?"":hashMap.get("q_pat_ser_grp_desc");
	hashMap13 = eMP.NewbornDetails.getPatSerGrpCode((String) hashMap.get("q_pat_ser_grp_code"), con,p);
	*/

	%>
	<table width="100%" cellpadding='0' cellspacing='0'align='center' border='0' style="margin-top: 10px;">
					<tr>
						<td class='label' width='20%'><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>
						<td nowrap width='20%' class='FIELDS'><input type="hidden" name="pat_ser_grp_code" id="pat_ser_grp_code"  value="<%=pat_ser_grp_code%>"><input type="text" name="pat_ser_grp_code_desc" id="pat_ser_grp_code_desc"  value="<%=pat_ser_grp_desc%>" maxlength='11' size="20" readonly> <img align=center src='../images/mandatory.gif'></img></td>
						<td width='20%' class='label' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td nowrap class='FIELDS' width='20%'><input type="text" name="patient_id" id="patient_id" value="<%=motherid%>"  size="20" readOnly disabled onBlur='makeValidString(this);'><!--<img align='center' src='../images/mandatory.gif'></img>--></td>
						<!-- img commented and disabled added by mujafar for ML-MMOH-SCF-1039 -->
						<% 
							if(invoked_from.equals("details_page")) {
								out.println("<td class='FIELDS' width='20%'>");
								if(buttonType.equals("R")) { 
									out.println("<input type='button' class='button' name='add_records' id='add_records' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Register.label","common_labels")+"' "+disable_button_yn+" onClick='addRecords();'>"); 	
								} else if(buttonType.equals("F")){
									out.println("<input type='button' class='button' name='add_records' id='add_records' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Finalize.label","common_labels")+"' "+disable_button_yn+" onClick='addRecords();'>");	
								}
								if (ip_install_yn.equals("Y") && calling_module_id.equals("IP")) { 
									out.println("<input type='button' class='button' name='close_win' id='close_win' value ='" + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels") +"' onClick='closeWindow();'>");
								}
								out.println("</td>");
							} else {
								out.println("<td class='label' width='20%'></td>");
							}
						%>	
						<%if(isNewBornChngsAppl && "MAINTAIN_BIRTH".equals(function_id_new)){%>
						<td class='fields' width = '20%'    >
						<% out.println("<input type='button' class='button' style='width:175px;' id='btnNewbornAssessmentNote' name='btnNewbornAssessmentNote' id='btnNewbornAssessmentNote'value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewbornAssessmentNote.label","mp_labels")+"'  onClick='callNewbornAssessmentNote();'>"); %>
						</td>
						<%}%>
						<td class='fields' width = '20%'>
						<% out.println("<input type='button' class='button'  name='auditTrial' id='auditTrial' id ='auditButton' style='visibility:hidden'   value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AuditTrail.label","common_labels")+"'  onClick='viewAuditTrail();'>"); %>
						</td>

				    </tr>

				</table> 

<%}%>
<input type='hidden' name='pat_no_gen_yn' id='pat_no_gen_yn' value='Y'></input>
<input type='hidden' name='pat_ser_prefix_reqd_yn' id='pat_ser_prefix_reqd_yn' value=""></input>
<input type='hidden' name='function_id_mg' id='function_id_mg' value="<%=function_id_new%>">
<input type='hidden' name='chd_id' id='chd_id' value="<%=chd_id%>">
<input type='hidden' name='chd_encounter_id' id='chd_encounter_id' value="<%=chd_encounter_id%>">
<input type='hidden' name='chd_patient_class' id='chd_patient_class' value="<%=chd_patient_class%>">
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
		{
			
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	%>
	<script>visibleAudit();</script>
</form>
</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

