<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<html>
<head>

<script src='../js/RecDiagnosis.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
</head>
<body onKeyDown = 'lockKey()'>
<form name='getDiagValForm' id='getDiagValForm'>
<%

	request.setCharacterEncoding("UTF-8");
	Connection con = null; 
	PreparedStatement stmt_appln_yn=null;
	ResultSet rs_appln_yn = null;
	
	PreparedStatement stmt=null;
	ResultSet rs = null;
	PreparedStatement stmt1=null;
	ResultSet rs1 = null;
	
	
		
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String term_set_code = request.getParameter("term_set_code")==null?"":request.getParameter("term_set_code");
	String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
	String dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
//out.println("dob"+dob);
//out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
	//String code_indicator = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");
//	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
    
	term_set_code = term_set_code.toUpperCase();
	String short_desc = "";
	String long_desc = "";

	String age_spec_ind_val = "";
	String age_group_appl_yn = "";

	int recordcnt = 0;
	int maxrecord = 0;
	StringBuffer sql = new StringBuffer();
	String sql_appln_yn = "";
	String sql_cnt = "";
	try
	{
		con = ConnectionManager.getConnection(request);
			
		sql_cnt="select count(*) count from MR_D_"+term_set_id+"_VW where term_code = ?" ; 
		stmt1 = con.prepareStatement(sql_cnt);
		stmt1.setString(1,term_set_code);
		rs1 =  stmt1.executeQuery();
		while(rs1.next())
		{
			maxrecord = rs1.getInt(1);
		}
		if(rs1!=null) rs1.close();
		if(stmt1!=null) stmt1.close();

	
		if(maxrecord == 0)
		{
			//out.println("<script> var msg = getMessage('INVALID_VALUE','Common'); msg	= msg.replace('#',getLabel('Common.DiagnosisCode.label','Common')); alert(msg);parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value='';parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.select();parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.focus();</script>");

			out.println("<script> var msg = getMessage('INVALID_VALUE','Common'); msg	= msg.replace('#',getLabel('Common.DiagnosisCode.label','Common')); alert(msg);parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.value = '';			parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.focus();		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.select();		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = '';		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = '';		parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=true;</script>");
		}
		else
		{
			sql_appln_yn = "select AGE_GROUP_APPL_YN,SENSITIVITY_APPL_YN,TERM_SET_DESC,NOTIFICATION_APPL_YN from mr_term_set where TERM_SET_ID = ?";
			stmt_appln_yn = con.prepareStatement(sql_appln_yn);
			stmt_appln_yn.setString(1,term_set_id);
			
			rs_appln_yn = stmt_appln_yn.executeQuery();

			while(rs_appln_yn.next())
			{
				age_group_appl_yn = rs_appln_yn.getString("AGE_GROUP_APPL_YN")==null?"":rs_appln_yn.getString("AGE_GROUP_APPL_YN");
			}

			
			if(rs_appln_yn!=null)  rs_appln_yn.close();
			if(stmt_appln_yn!=null)  stmt_appln_yn.close();
		
			if(age_group_appl_yn.equals("Y"))
			{

				String sql_age_spec_ind = " select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',30,'D',1,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',30,'D',1,1) THEN 'N'  END FROM MR_PARAMETER ";
				stmt_appln_yn = con.prepareStatement(sql_age_spec_ind);
				stmt_appln_yn.setString(1,dob);
				stmt_appln_yn.setString(2,dob);
				stmt_appln_yn.setString(3,dob);
				
				rs_appln_yn = stmt_appln_yn.executeQuery();
				while(rs_appln_yn.next())
					age_spec_ind_val = rs_appln_yn.getString(1)==null?"":rs_appln_yn.getString(1);	
			
			}	
			

				
			

		


			if(rs_appln_yn!=null)  rs_appln_yn.close();
			if(stmt_appln_yn!=null)  stmt_appln_yn.close();

			int j = 0;
			j++;
   
			sql.append("select short_desc,long_desc,code_indicator from MR_D_"+term_set_id+"_VW where term_code = ?" ); 
			if(!sex.equals(""))
			{
				sql.append(" and (GENDER_SPEC_IND = ? OR gender_spec_ind IS NULL)");
			}
			if(age_group_appl_yn.equals("Y") && (!age_spec_ind_val.equals("")))
			{
				sql.append(" and (age_spec_ind is null or AGE_SPEC_IND = ?) ");
			}
			/*if(!code_indicator.equals(""))
			{
				sql.append(" and code_indicator = ?");
			}*/

			stmt = con.prepareStatement(sql.toString());
			stmt.setString(j++,term_set_code);
			
			if(!sex.equals(""))
			{
				stmt.setString(j++,sex);
			}
			if( age_group_appl_yn.equals("Y") && (!age_spec_ind_val.equals("")))
			{
				stmt.setString(j++,age_spec_ind_val);
			}
			/*if(!code_indicator.equals(""))
			{
				stmt.setString(j++,code_indicator);
			}*/
		
			rs = stmt.executeQuery();

			while(rs.next())
			{
				short_desc = rs.getString("short_desc");
				long_desc = rs.getString("long_desc");
				//code_indicator = rs.getString("code_indicator");
				recordcnt++;

			}

			if(rs!=null) rs.close();		
			if(stmt!=null) stmt.close();
		
			if(recordcnt ==  0)
			{	
				%>
				
				<SCRIPT LANGUAGE="JavaScript">
					alert(getMessage("MR_INVALID_DIAG_CODE_FOR_PATIENT","MR"));
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.value = '';
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.focus();
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_code.select();
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = '';
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = '';
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=true;
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value = '';
				</SCRIPT>
			<%
			}
			else
			{
			%>
				<SCRIPT LANGUAGE="JavaScript">
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.diag_desc.value = '<%=short_desc%>';
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.long_desc.value = '<%=long_desc%>';
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.exclamation.disabled=false;
				if(parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value == 'Y')
						parent.AddAssociateCodeAddModifyFrame.doSelect('A');
				else
					parent.AddAssociateCodeAddModifyFrame.document.AddAssociateCodeAddModifyForm.flag_to_add.value = 'Y'

				</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



			<%
			}

		}
	}
	catch(Exception e)
	{
		//out.println("Exception @ try "+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	

%>
</form>
</body>
</html>

