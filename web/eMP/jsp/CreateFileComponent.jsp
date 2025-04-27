<!DOCTYPE html>
<%-- /* File Creation Component 
Calling file : CallCreateFileComponent.jsp
Called File : GetCreateFileComponentValues.jsp 
*/ --%>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.Common.*,webbeans.eCommon.MessageManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<html>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	Connection con = null;
	String p_single_or_multi_files_ind = ""; 
	String p_separate_file_no_yn =	"";

	PreparedStatement pstmt=null;
    ResultSet rset = null;
	PreparedStatement pstmt1=null;
    ResultSet rset1 = null;
	String sql = "";
	String dflt_fs_locn_code="";
	String sel="";
	String called_from ="";
	String location_code="";
	String p_patient_id ="";
	String p_pat_ser_grp_code ="";
	String p_mr_section_type ="";
	String p_mr_section_code = "";
	String p_encounter_id ="";
	String p_patient_class ="";
	String p_encounter_date_time = "";
	String facility_id = (String)session.getAttribute("facility_id");
    called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
	location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
	p_patient_id = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");

	p_pat_ser_grp_code = request.getParameter("p_pat_ser_grp_code")==null?"":request.getParameter("p_pat_ser_grp_code");

	p_mr_section_type = request.getParameter("p_mr_section_type")==null?"":request.getParameter("p_mr_section_type");
	p_mr_section_code = request.getParameter("p_mr_section_code")==null?"":request.getParameter("p_mr_section_code");

	p_encounter_id = request.getParameter("p_encounter_id")==null?"":request.getParameter("p_encounter_id");        
	p_patient_class = request.getParameter("p_patient_class")==null?"":request.getParameter("p_patient_class");       
	p_encounter_date_time = request.getParameter("p_encounter_date_time")==null?"":request.getParameter("p_encounter_date_time");
Properties p			=	 (java.util.Properties) session.getValue( "jdbc" );



	String proceed_yn = "Y";
	String install_yn = "N";
	String fs_locn_code = "" ;
	String site_id = "";
	String prompt_for_old_file_no_yn = "";
	String sql_temp = "";
	StringBuffer str_sql = new StringBuffer();
	String file_type_appl_yn = "";
	String multi_files_in_same_fs_locn_yn = "";
	String filetypecodetemp = "";
	String file_type_code="";
	int show_buttons = 0;
	int recCnt = 0;
    int cnt=0;
	Boolean SiteSpecific_AutoCreatePatFile = false;
	Boolean SiteSpecific_AltFileNumber     = false;
	try 
	{
		con = ConnectionManager.getConnection(request);
		SiteSpecific_AutoCreatePatFile = CommonBean.isSiteSpecific(con, "MP","AUTO_CREATE_PAT_FILE_AND_REQ"); //Added for MMS-QH-CRF-0148
		SiteSpecific_AltFileNumber     = CommonBean.isSiteSpecific(con, "MR","ALTERNATE_FILE_NUMBER");   //Added by Sangeetha for GDOH-CRF-0103
		
		/* Select single or multi files indicator, separate file no and file type applicable from mp_param */
		
		try {
		sql = "select single_or_multi_files_ind,separate_file_no_yn,FILE_TYPE_APPL_YN,multi_files_in_same_fs_locn_yn from mp_param";
		pstmt = con.prepareStatement(sql);
		rset = pstmt.executeQuery();
		while(rset.next())
		{
			p_single_or_multi_files_ind = rset.getString(1)==null?"":rset.getString(1);
			p_separate_file_no_yn = rset.getString(2)==null?"":rset.getString(2);
			file_type_appl_yn = rset.getString("FILE_TYPE_APPL_YN")==null?"":rset.getString("FILE_TYPE_APPL_YN");
			multi_files_in_same_fs_locn_yn = rset.getString("multi_files_in_same_fs_locn_yn")==null?"N":rset.getString("multi_files_in_same_fs_locn_yn");
		}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
%>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../js/FileComponent.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function allowAlphaNumeric(event){
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		return true ;
	}
//added by N Munisekhar against  [IN:045249] 

//Modified by Sangeetha for GDOH-CRF_0103
     	function removeSpec(objSpec)
	     {  
                var data = objSpec.value;
                for (var i = 0; i < data.length; i++)
                {  
				 if (!(((data.charCodeAt(i)>=48) && (data.charCodeAt(i)<=57))||((data.charCodeAt(i)>=65) && (data.charCodeAt(i)<=90))||((data.charCodeAt(i)>=97) && (data.charCodeAt(i)<=122))))
                    {    
					data=data.replace(/[!`@#$%^&*()+=\-\[\]';,.\/{}|\s":<>\\?~_]/g,'');
                    objSpec.value =data;                    
					return false; 
                    } 
                }
				return true;
         }
	
	function changeCase(Obj)
	{
		Obj.value =Obj.value.toUpperCase();
	}
</script>
<!--	getCreateFileComponentValues(),doSubmit(),doClose() & doReturn() are moved to FileComponent.js-->
<title><fmt:message key="eMP.CreatePatientFile.label" bundle="${mp_labels}"/></title>
</head>
<%
	if(p_single_or_multi_files_ind.equals("S") && p_separate_file_no_yn.equals("N"))
		{}
	else
		{
	if (called_from.equals("MP"))/*This portion will execute only when called from =MP*/
	{
	try {
	sql_temp = "SELECT SITE_ID FROM SM_SITE_PARAM";
	pstmt = con.prepareStatement(sql_temp);
	rset = pstmt.executeQuery();
	if (rset!=null)
		{
		while(rset.next())
			site_id = rset.getString(1)==null?"":rset.getString(1);
		}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
	}
	catch (Exception e)
		{
			e.printStackTrace();
		}
	try 
		{	/* Code for displaying the mr section [Display only]*/
/*	str_sql.append("SELECT A.MR_SECTION_CODE FROM MR_SEC_FOR_PAT_SER_GRP A, MP_PAT_SER_FACILITY B WHERE A.PAT_SER_GRP_CODE = B.PAT_SER_GRP_CODE AND A.FACILITY_ID = '"+facility_id+"' AND B.SITE_OR_FACILITY_ID = DECODE(B.SITE_OR_FACILITY,'S','"+site_id+"', 'F', '"+facility_id+"') AND B.PAT_SER_GRP_CODE = '"+p_pat_ser_grp_code+"' AND B.MAX_SRL_NO = (Select MIN(MAX_SRL_NO) from MP_PAT_SER_FACILITY WHERE PAT_SER_GRP_CODE = '"+p_pat_ser_grp_code+"' AND SITE_OR_FACILITY_ID = DECODE(SITE_OR_FACILITY,'S','"+site_id+"', 'F', '"+facility_id+"'))");
*/
	str_sql.append("SELECT DECODE(SITE_OR_FACILITY, 'F', MR_SECTION_CODE, (select mr_section_code FROM MR_SEC_FOR_PAT_SER_GRP where (pat_ser_grp_code = '"+p_pat_ser_grp_code+"' OR pat_ser_grp_code = (select associated_pat_ser_grp_code from mp_pat_ser_grp where pat_ser_grp_code = '"+p_pat_ser_grp_code+"')) and FACILITY_ID = '"+facility_id+"')) mr_section_code from MP_PAT_SER_FACILITY WHERE SITE_OR_FACILITY_ID = DECODE(SITE_OR_FACILITY,'S','"+site_id+"', 'F', '"+facility_id+"') AND (pat_ser_grp_code = '"+p_pat_ser_grp_code+"' OR pat_ser_grp_code = (select associated_pat_ser_grp_code from mp_pat_ser_grp where pat_ser_grp_code = '"+p_pat_ser_grp_code+"')) AND MAX_SRL_NO = (Select MIN(MAX_SRL_NO) from MP_PAT_SER_FACILITY WHERE (pat_ser_grp_code = '"+p_pat_ser_grp_code+"' OR pat_ser_grp_code = (select associated_pat_ser_grp_code from mp_pat_ser_grp where pat_ser_grp_code = '"+p_pat_ser_grp_code+"')) AND SITE_OR_FACILITY_ID = DECODE(SITE_OR_FACILITY,'S','"+site_id+"', 'F', '"+facility_id+"'))");
	
	
	pstmt = con.prepareStatement(str_sql.toString());
	str_sql.setLength(0);
	rset = pstmt.executeQuery();
	if (rset!=null)
		{
		
		while(rset.next())
			p_mr_section_code = rset.getString(1)==null?"":rset.getString(1);
		
			
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
	} catch(Exception e)
		{
			e.printStackTrace();
		}

	if(p_mr_section_code.equals(""))
		{
		  proceed_yn = "N";
		}
	}//for called from MP
		}
%>
<body OnMouseDown="CodeArrest()" onKeyDown='lockKey();' style='background-color:<%=sStyle%>;'> 
<form name="createFileComponent" id="createFileComponent">
<table width='100%' border='0' cellspacing='0' cellpadding='1' align=center>
    <tr>
    <td width='50%'>&nbsp;</td>
    <td width='50%'>&nbsp;</td>
    </tr>    	
	<tr>
	<%if(proceed_yn.equals("N")){%>
	<tr>
    <td width='50%'>&nbsp;</td>
    <td width='50%'>&nbsp;</td>
    </tr>
	<tr>
    <td width='50%'>&nbsp;</td>
    <td width='50%'>&nbsp;</td>
    </tr><td class='label' align='center' colspan='2' id ='mrSectionId'></td>
	<script>
	document.getElementById('mrSectionId').innerHTML=getMessage('MR_SECTION_NOT_DEFINED','MP');	
	</script>
	<%
	show_buttons=2;
	}%>

	<%if(proceed_yn.equals("Y")){%>
	<%
	if(file_type_appl_yn.equals("N") && p_single_or_multi_files_ind.equals("M") && p_separate_file_no_yn.equals("N"))/*it is handling one exception*/
		{ show_buttons=1;%>
		</tr><tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>
		<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>
		<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>
		<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>
		<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>
		<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>
		<tr>	
		<%	//Map hashtable1 = MessageManager.getMessage(con, "FILE_TYPE_NOT_APPL");
		//	String st2 = (String)hashtable1.get("message");               
			%>  <!-- <td width='50%' colspan=2 class='data' align=center><font align=center><%-- =st2 --%></font></td> -->
			   <td width='50%' colspan=2 class='data' align=center id='errmsg'><font align=center></font></td>
				<script>var msg=getMessage("FILE_TYPE_NOT_APPL","MP");
				document.getElementById('errmsg').innerHTML=msg;</script> 
		</tr>
		<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>
		<tr>				
			<td colspan=2 align=center><input type='Button' class='Button' name='Ok' id='Ok' value='    <fmt:message key="Common.ok.label" bundle="${common_labels}"/>    ' onclick='doClose();'></td>
	<%  }else{ %>
	<%
	
		try {
		pstmt1 = con.prepareStatement("select install_yn from sm_module where module_id = 'FM'");
		rset1 = pstmt1.executeQuery();
		if(rset1!=null)
		{
			while(rset1.next())
			{
				install_yn = rset1.getString(1)==null?"":rset1.getString(1);
				
			}
		}
		if (rset1!=null) rset1.close();
		if (pstmt1!=null) pstmt1.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		if(install_yn.equals("Y"))/* If FM is installed display file storage location and mr section */
		{
			try{/*Statement to get the number of records in file storage location*/
				pstmt = con.prepareStatement("select count(1) from fm_storage_locn where facility_id = ? and permanent_file_area_yn = 'Y'");
                pstmt.setString(1, facility_id);
                rset = pstmt.executeQuery();
                if (rset.next())
                {
                    recCnt = rset.getInt(1);
					
                }
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
		
			pstmt = con.prepareStatement("select dflt_fs_locn_code from fm_parameter where facility_id = ?");
                pstmt.setString(1,facility_id);
                 rset = pstmt.executeQuery();
                if (rset.next())
                {
                    dflt_fs_locn_code = rset.getString(1);
                }
		        if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			
			}catch(Exception e){ 
				e.printStackTrace();
			}
		if (recCnt > 0) {/*Display list box only*/
		
%>
		<td class="label" align="left" width="40%" nowrap><fmt:message key="eMP.FileStorageLocn.label" bundle="${mp_labels}"/>&nbsp;</td>
   <td width="60%" align="left" nowrap><select name='fs_locn_code' id='fs_locn_code'   onchange='getCreateFileComponentValues_dummy();'   onmousewheel='return false;'><option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option> 
<%
		if(p_mr_section_type.equals("D"))
		{
			if(called_from.equals("OP")||called_from.equals("AE")||called_from.equals("DC"))
			{
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement("select a.mr_location_code fs_locn_code,b.short_desc from op_clinic a,fm_storage_locn b where a.facility_id=b.facility_id and a.mr_location_code=b.fs_locn_code and a.facility_id = ? and a.clinic_code = ? and a.eff_status='E' and b.eff_status='E' order by b.short_desc");
			}
			if(called_from.equals("IP"))
			{
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement("select a.fs_locn_code,b.short_desc from ip_nursing_unit a,fm_storage_locn b where a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code and a.facility_id = ? and a.nursing_unit_code=? and a.eff_status='E' and b.eff_status='E' order by b.short_desc");
			}
		}
		else if(p_mr_section_type.equals("C"))
		{
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement("select fs_locn_code,short_desc from fm_storage_locn where facility_id = ? and permanent_file_area_yn = 'Y' and eff_status='E' and locn_identity='D' and mr_locn_yn = 'Y' order by short_desc");
	  	}    
		else if(p_mr_section_type.equals(""))
		{
			if(pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement("select fs_locn_code,short_desc from fm_storage_locn where facility_id = ? and permanent_file_area_yn = 'Y' and eff_status='E' and mr_locn_yn = 'Y' order by short_desc");
		 }     

                pstmt.setString(1, facility_id);
				if(p_mr_section_type.equals("D"))
				{
					if(called_from.equals("OP")||called_from.equals("AE")||called_from.equals("DC")||called_from.equals("IP"))
					{
						pstmt.setString(2, location_code);
					}
				}
                rset=pstmt.executeQuery();
                
                if( rset != null )
                {
                   while( rset.next() )
                    {
                        fs_locn_code = rset.getString( "fs_locn_code" )==null?"":rset.getString("fs_locn_code");
                        String shortdesc=rset.getString("short_desc")==null?"":rset.getString("short_desc");
						 if (fs_locn_code.equals(dflt_fs_locn_code)) sel = "selected";
                        else sel = "";                      
            %><OPTION VALUE='<%= fs_locn_code %>' <%=sel%>><%= shortdesc %><%                                
                    }
				}
            %>
		</select>&nbsp;<img src='../images/mandatory.gif'></img></td>
        <%} else
			{
			%><td class="label" align="left" width="40%" nowrap>&nbsp;</td><td width="60%" align="left" nowrap>&nbsp;</td><%
			}
	%>
	</td>
    </tr>
	<!-- <tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr> -->
	<tr>
    <td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td> 
    <td width='50%' class=label align=left>
	<% 
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
		
		if(p_single_or_multi_files_ind.equals("S") && p_separate_file_no_yn.equals("N"))
		{%>
		<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>
		<%}
		/*else if(!((called_from.equals("OP")||called_from.equals("MP")||called_from.equals("IP")||called_from.equals("AE")||called_from.equals("DC"))))
		{
		String strsql = "select b.short_name mr_section, a.mr_section_code from fm_storage_locn a, mr_section b where a.facility_id = b.facility_id and a.fs_locn_code ='"+fs_locn_code+"' and a.mr_section_code = b.mr_section_code";
	    
		
		pstmt=con.prepareStatement(strsql);

	    rset = pstmt.executeQuery();	
			
					if(rset!=null)
                    {
                        while(rset.next())
                        {
    						//mr_section_code_desc = rset.getString("mr_section")==null?"":rset.getString("mr_section");//This value is not displayed on load. Only on change of fs locatin from the other jsp.
						}
					}*/
	%>
	<!-- MR Section&nbsp;</td><td class=label align=left><b><font id='mr_section' class='label'></font></b>
	</td> 
    </tr>-->
	<%	//} %>
	<% }else{ /* Else part of install_yn for FM */
	%>
	<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>
	<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>
	<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>
	<% } %>
    <tr>
    <td align='center' class='label' width='50%'id = id1 colspan=2>
	</td>
    </tr>
	<%
	if(file_type_appl_yn.equals("Y"))/* Show the file type window */
	{
	%>
	<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>	
	<tr>
    <td align='left' class='label' width='50%'><fmt:message key="Common.filetype.label" bundle="${common_labels}"/>&nbsp;</td>
	<td><select name='file_type' id='file_type' ><option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
	<%
		
	if(install_yn.equals("Y")){
		
		if(pstmt!=null)pstmt.close();  
		if(rset!=null)rset.close();  

		if(called_from.equals("OP")){
			str_sql.setLength(0);
			str_sql.append("select dflt_file_type_code, b.short_desc from op_clinic a, mr_file_type b where a.facility_id = '");
			str_sql.append(facility_id);
			str_sql.append("'  and a.clinic_code = '");
			str_sql.append(location_code);
			str_sql.append("'  and a.dflt_file_type_code = b.file_type_code(+) and b.appl_to_op='Y' ");
			pstmt = con.prepareStatement(str_sql.toString());
			str_sql.setLength(0);
//			pstmt = con.prepareStatement("select dflt_file_type_code, b.short_desc from op_clinic a, mr_file_type b where a.facility_id = '"+facility_id+"'  and a.clinic_code = '"+location_code+"'  and a.dflt_file_type_code = b.file_type_code(+) and b.appl_to_op='Y' ");
		}else if(called_from.equals("AE")){
			if(pstmt!=null) pstmt.close();
			str_sql.setLength(0);
			str_sql.append("select dflt_file_type_code, b.short_desc from op_clinic a, mr_file_type b where a.facility_id = '");
			str_sql.append(facility_id);
			str_sql.append("'  and a.clinic_code = '");
			str_sql.append(location_code);
			str_sql.append("'  and a.dflt_file_type_code = b.file_type_code(+) and b.appl_to_em='Y' ");			
			pstmt = con.prepareStatement(str_sql.toString());
			str_sql.setLength(0);
//			pstmt = con.prepareStatement("select dflt_file_type_code, b.short_desc from op_clinic a, mr_file_type b where a.facility_id = '"+facility_id+"'  and a.clinic_code = '"+location_code+"'  and a.dflt_file_type_code = b.file_type_code(+) and b.appl_to_em='Y' ");
		}
		else if(called_from.equals("IP"))
		{
			if(pstmt!=null) pstmt.close();
			str_sql.setLength(0);
			str_sql.append("select dflt_file_type_code, b.short_desc from ip_nursing_unit a, mr_file_type b where a.facility_id = '");
			str_sql.append(facility_id);
			str_sql.append("' and a.nursing_unit_code = '");
			str_sql.append(location_code);
			str_sql.append("' and a.dflt_file_type_code = b.file_type_code(+) and (b.appl_to_ip='Y' OR b.appl_to_dc='Y')");
			pstmt = con.prepareStatement(str_sql.toString());
			str_sql.setLength(0);
//			pstmt = con.prepareStatement("select dflt_file_type_code, b.short_desc from ip_nursing_unit a, mr_file_type b where a.facility_id = '"+facility_id+"' and a.nursing_unit_code = '"+location_code+"' and a.dflt_file_type_code = b.file_type_code(+) and (b.appl_to_ip='Y' OR b.appl_to_dc='Y')");
		}
		try
		{
		rset=pstmt.executeQuery();
		
		if(rset!=null && rset.next())
					{					
						filetypecodetemp = rset.getString("dflt_file_type_code")==null?"":rset.getString("dflt_file_type_code");
					
						//filetypedesctemp = rset.getString("short_desc")==null?"":rset.getString("short_desc");

						
					
					}
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
		}
		catch (Exception e)
			{
				e.printStackTrace();
			}

	/*	StringBuffer tempsql = new StringBuffer("select short_desc, file_type_code from mr_file_type where facility_id = '");
		tempsql.append(facility_id);
		tempsql.append("' and eff_status = 'E' ");
		if(called_from.equals("OP")){tempsql.append(" and appl_to_op='Y' ");}
		if(called_from.equals("AE")){tempsql.append(" and appl_to_em='Y' ");}
		if(called_from.equals("IP")){tempsql.append(" and (appl_to_ip='Y' or appl_to_dc='Y') ") ;}
		tempsql.append(" order by short_desc "); */
		StringBuffer tempsql = new StringBuffer("Select b.short_desc, a.file_type_code from fm_file_type_for_fsl a, mr_file_type b where a.facility_id = '");
		tempsql.append(facility_id);
		tempsql.append("' and a.fs_locn_code = '");
		tempsql.append(dflt_fs_locn_code);
				tempsql.append("' and a.facility_id = b.facility_id and a.file_type_code = b.file_type_code and a.eff_status=b.eff_status  and a.eff_status='E'");
				if(called_from.equals("OP")){tempsql.append(" and b.appl_to_op='Y' ");}
				if(called_from.equals("AE")){tempsql.append(" and b.appl_to_em='Y' ");}
				if(called_from.equals("IP")){tempsql.append(" and (b.appl_to_ip='Y' or b.appl_to_dc='Y') ");}
				tempsql.append(" order by short_desc ");
		
		pstmt = con.prepareStatement(tempsql.toString());
		rset=pstmt.executeQuery();
		if(rset!=null)
		{
			while(rset.next())
			{
					
						 file_type_code = rset.getString( "file_type_code" )==null?"":rset.getString("file_type_code"); 
                       String short_desc	=rset.getString("short_desc")==null?"":rset.getString("short_desc");
			if(file_type_code.equals(filetypecodetemp)) {
            %>
            <OPTION VALUE='<%=file_type_code%>'selected><%=short_desc%>
            <%          
			}else {%>
			<OPTION VALUE='<%=file_type_code%>'><%=short_desc%>
			<% }		
			cnt++;
			} 
			
			if(cnt==1)
			{
			%>
		
		<script>
		if(document.forms[0].fs_locn_code)
				{
		if(document.forms[0].fs_locn_code.value !="")
		document.forms[0].file_type.value="<%=file_type_code%>";
				}
		</script>
			<%}
		
		}
	}/*End of install_yn = 'N' for file type population */
	%></select>&nbsp;<img src='../images/mandatory.gif'></img>
	</td>
    </tr>
	<% }else {%>
	<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>
	<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td><tr>
	<% } %>
	<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>	
	<tr>    
	<% /* Code to get old file number */
		if (called_from.equals("MP"))
		{
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
		try {
		StringBuffer strsql3 = new StringBuffer("select prompt_for_old_file_no_yn from mr_section where facility_id = '");
		strsql3.append(facility_id);
		strsql3.append("' and mr_section_code='");
		strsql3.append(p_mr_section_code);
		strsql3.append("'");

		pstmt=con.prepareStatement(strsql3.toString());
		strsql3.setLength(0);
		rset = pstmt.executeQuery();
		if (rset!=null)
		{
			while(rset.next())
			{
				prompt_for_old_file_no_yn = rset.getString(1)==null?"":rset.getString(1);
				
			}
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		}
		catch (Exception e)
			{
			    e.printStackTrace();
			}
		}/* end of MP specific search for old file */
		else if (called_from.equals("OP")||called_from.equals("IP")||called_from.equals("AE"))
		{
		
		if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
		try {
		StringBuffer strsql4 = new StringBuffer("select prompt_for_old_file_no_yn from mr_section where facility_id = '");
		strsql4.append(facility_id);
		strsql4.append("' and mr_section_code='");
		strsql4.append(p_mr_section_code);
		strsql4.append("'");
			
		pstmt=con.prepareStatement(strsql4.toString());
		strsql4.setLength(0);
		rset = pstmt.executeQuery();
		if (rset!=null)
		{
			while(rset.next())
			{
				prompt_for_old_file_no_yn = rset.getString(1)==null?"":rset.getString(1);
			}
		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
			{
			  e.printStackTrace();
			}		
	
		}/*End of old file no search for OP and IP */ %>

	<%	if(p_single_or_multi_files_ind.equals("S") && p_separate_file_no_yn.equals("N"))
		{
			if((file_type_appl_yn.equals("N"))&&(install_yn.equals("N"))) {
			//Map hashtable = MessageManager.getMessage(con, "FILE_NO_REQD_YN");
			//String st1 = (String)hashtable.get("message");               
			%>   <td width='50%' colspan=2 class='data' id='msg1'><font align=center></font></td> 
				<script>
				document.getElementById('msg1').innerHTML=getMessage("FILE_NO_REQD_YN","MP");
				</script> 
			<% }else { %>
				<td width='50%' colspan=2>&nbsp;</td>
			<% } %>	
			
		<%}else
		{if (prompt_for_old_file_no_yn.equals("Y"))
		{	
			%>
			<td width='50%' align=left class=label><fmt:message key="eMP.OldFileNo.label" bundle="${mp_labels}"/></td><td class=label align=left><input type=text id='txt1' name=old_file_no size='15' maxlength='20' onKeyPress='return allowAlphaNumeric(event)' onBlur='changeCase(this);return removeSpec(this)'>
			<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>	
			<%}else{ %>
			<td width='50%' colspan=2>&nbsp;</td>

			<% }/* End of old file no */
		}
	}%>
    </tr>
	
	<!-- Added by Sangeetha for GDOH-CRF-0103 on 6-feb-17 -->
	<% if(SiteSpecific_AltFileNumber){ %>
	<tr>
	<td width='50%' align=left class=label><fmt:message key="eMP.AltFileNo.label" bundle="${mp_labels}"/></td><td class=label align=left><input type=text id='altFile' name=alt_file_no size='15' maxlength='24' onKeyPress='return allowAlphaNumeric(event)' onBlur='changeCase(this);return removeSpec(this)'>
	</tr>
	<% 
		} //end of SiteSpecific_AltFileNumber
		}
	}/* End of outer try */
	catch (Exception e)
	{
		e.printStackTrace();
	}
	 finally
    {
        ConnectionManager.returnConnection(con,request);
    }		
%>
	<tr><td width='50%'>&nbsp;</td><td width='50%'>&nbsp;</td></tr>
<% if (show_buttons==0){%>
	<tr>
    <td width='50%' align=right><input type='Button' class='Button' name='Ok' id='Ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick='doSubmit();'></td>
    <td width='50%'><input type='Button' class='Button' name='cancel' id='cancel' value=' <fmt:message key="Common.cancel.label" bundle="${common_labels}"/> ' onclick='parent.parent.document.getElementById("dialog_tag").close();'></td>
    </tr>
<% } else if(show_buttons==2){%>
		<tr><td colspan='2'></td></tr>
		<tr><td colspan='2'></td></tr>
		<tr>
	    <td width='50%' align=center colspan='2'><input type='Button' class='Button' name='Ok' id='Ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick='doSubmit();'></td>
		</tr>
<%}%>
</table>

<input type='hidden' name=facility_id id=facility_id value='<%=facility_id%>'>

<input type='hidden' name=p_encounter_id id=p_encounter_id value='<%=p_encounter_id%>'>
<input type='hidden' name=p_patient_class id=p_patient_class value='<%=p_patient_class%>'>
<input type='hidden' name=p_encounter_date_time id=p_encounter_date_time value='<%=p_encounter_date_time%>'>

<input type='hidden' name=p_patient_id id=p_patient_id value='<%=p_patient_id%>'>
<input type='hidden' name=p_single_or_multi_files_ind id=p_single_or_multi_files_ind value='<%=p_single_or_multi_files_ind%>'>
<input type='hidden' name=p_separate_file_no_yn id=p_separate_file_no_yn value='<%=p_separate_file_no_yn%>'>
<input type='hidden' name=p_location_code id=p_location_code value='<%=location_code%>'>

<input type='hidden' name=p_pat_ser_grp_code id=p_pat_ser_grp_code value='<%=p_pat_ser_grp_code%>'>
<input type='hidden' name=p_mr_section_type id=p_mr_section_type value='<%=p_mr_section_type%>'>
<input type='hidden' name=p_mr_section_code id=p_mr_section_code value='<%=p_mr_section_code%>'>


<input type='hidden' name=p_called_from id=p_called_from value='<%=called_from%>'>
<input type='hidden' name=recCnt id=recCnt value='<%=recCnt%>'>

<input type='hidden' name='file_no' id='file_no'>
<input type='hidden' name='error_value' id='error_value'>
<input type='hidden' name='install_yn' id='install_yn' value=<%=install_yn%>>
<input type='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value=<%=file_type_appl_yn%>>
<input type='hidden' name='multi_files_in_same_fs_locn_yn' id='multi_files_in_same_fs_locn_yn' value=<%=multi_files_in_same_fs_locn_yn%>>
<!-- Added for MMS-QH-CRF-0148 -->
<input type='hidden' name='sitespecific_autocreatepatfile' id='sitespecific_autocreatepatfile' value=<%=SiteSpecific_AutoCreatePatFile%>>
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
 <!-- Added for MMS-QH-CRF-0148 -- TO submit the request if it has only single record -->
 <script> 
 var tempAutoFileReq = document.forms[0].sitespecific_autocreatepatfile.value;
 if (tempAutoFileReq == "true")
 { 
	 if (document.forms[0].fs_locn_code && document.forms[0].fs_locn_code.length == 2)
	 {
		document.forms[0].fs_locn_code.selectedIndex = 1;
		if(document.forms[0].file_type)
		{
			if(document.forms[0].file_type.length == 2)
			{
				document.forms[0].file_type.selectedIndex = 1;
				doSubmit();
			}
		}else
		{ 
			doSubmit();
		}
	 }
  }
</script>

