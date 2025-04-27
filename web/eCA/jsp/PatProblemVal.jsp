<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<%
	request.setCharacterEncoding("UTF-8");	
	Connection con = null; 
    PreparedStatement stmt=null;
	ResultSet rs = null;
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<%
	try
	{
		con = ConnectionManager.getConnection(request);
		String p_p_diag_code	= 	request.getParameter("p_diag_code");
		String p_scheme			=	request.getParameter("p_scheme");
		String cause_indicator	=	request.getParameter("p_cause_indicator");
		String sensitive_yn		=	request.getParameter("p_sensitive_yn");

		String sex		=	request.getParameter("Sex");
		String dob		=	request.getParameter("Dob");
		String code_indicator = "";
		//String associate_codes  = request.getParameter("associate_codes")==null?"N":request.getParameter("associate_codes");


		String authorizeButton=request.getParameter("authorizeButton")==null?"N":request.getParameter("authorizeButton");
	
		String p_diag_code		=   p_p_diag_code.trim();

		if (!(p_diag_code == null || p_diag_code.equals("null")||p_diag_code.length()==0))	
		{
			String p_diag_desc ="";
			String p_diag_srl_no ="";
			String p_record_type ="";
			String p_cause_indicator ="";
			String p_tab_list_no ="";
			String p_analysis_code ="";
			String p_notifiable_yn ="";
			String p_sensitive_yn ="";
			String p_longdescription="";
			int record_count=0;
			StringBuffer sql = new StringBuffer();
			
			sql.append("select short_desc, diag_srl_no, record_type, cause_indicator, analysis_code, notifiable_yn, sensitive_yn, long_desc, code_indicator from mr_icd_code where diag_code=? and diag_code_scheme=? and (code_indicator in ('D','C')    OR code_indicator IS NULL) ");

			if(p_scheme.equals("2"))
				sql.append(" and record_type='D' "); 
	
			stmt=con.prepareStatement(sql.toString());
			stmt.setString(1,p_diag_code);
			stmt.setString(2,p_scheme);
			rs = stmt.executeQuery();
//out.println("<script>alert(' in val" + dob +"--" + sex + "')</script>");
			String t_cause_indicator = "";
			while( rs.next() )
			{
				t_cause_indicator	=	checkForNull( rs.getString("cause_indicator") );
				if( (record_count==0) || (cause_indicator.equals(t_cause_indicator)) )
				{
					p_cause_indicator	=	t_cause_indicator;
					p_diag_desc 		=	checkForNull( rs.getString("short_desc") );
					p_diag_srl_no 		=	checkForNull( rs.getString("diag_srl_no") );
					p_record_type 		=	checkForNull( rs.getString("record_type") );
					//p_tab_list_no 	=	checkForNull( rs.getString("tab_list_no") );
					p_analysis_code		=	checkForNull( rs.getString("analysis_code") );
					p_notifiable_yn		=	checkForNull( rs.getString("notifiable_yn") );
					p_sensitive_yn		=	checkForNull( rs.getString("sensitive_yn") );
					p_longdescription =   checkForNull(rs.getString("long_desc"));
					code_indicator = checkForNull(rs.getString("code_indicator"));
				}
				record_count++;
			}
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			if(record_count==0)
			{
				out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' CLASS='MESSAGE'><script>alert(getMessage('INVALID_DIAG_CODE_FOR_PATIENT','CA'));parent.addModifyPatProblem.document.forms[0].Description.value='';parent.addModifyPatProblem.document.forms[0].Description1.value='';parent.addModifyPatProblem.document.forms[0].code.focus();parent.addModifyPatProblem.document.forms[0].code.select();parent.addModifyPatProblem.document.forms[0].ntf_button.style.visibility='hidden'; </script></body>");
			}
			else
			{
				//
				sql = new StringBuffer();
				sql.append("select count(*) from mr_icd_code where diag_code=? and diag_code_scheme=?  and ( gender_spec_ind = ? OR gender_spec_ind IS NULL)  and ( nvl(age_spec_ind,'O') NOT IN ('A','P','N') or age_spec_ind IN  ( select case when sysdate-to_date(?,'dd-mm-yyyy') between          NVL(ADULT_MIN_AGE_VALUE,0)*decode(ADULT_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(ADULT_MAX_AGE_VALUE,0) *decode(ADULT_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'A'	WHEN  Sysdate-to_date(?,'dd-mm-yyyy') between NVL(PEAD_MIN_AGE_VALUE,0)*decode(PEAD_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(PEAD_MAX_AGE_VALUE,0) *decode(PEAD_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'P' WHEN Sysdate-to_date(?,'dd-mm-yyyy') between NVL(NB_MIN_AGE_VALUE ,0)*decode(NB_MIN_AGE_UNIT,'Y',365,'M',12,'D',30,1) AND NVL(NB_MAX_AGE_VALUE,0) *decode(NB_MAX_AGE_UNIT,'Y',365,'M',12,'D',30,1) THEN 'N'  END FROM MR_PARAMETER )) AND (code_indicator not in ('A','E') OR code_indicator IS NULL) ");

				if(p_scheme.equals("2"))
					sql.append(" and record_type='D' "); 

				stmt=con.prepareStatement(sql.toString());
				stmt.setString(1,p_diag_code);
				stmt.setString(2,p_scheme);
				stmt.setString(3,sex);
				stmt.setString(4,dob);
				stmt.setString(5,dob);
				stmt.setString(6,dob);
				rs = stmt.executeQuery();
				//
				rs.next();
				if(rs.getInt(1) != 0)
				{
					StringBuffer a1 = new StringBuffer();
					a1.append("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
					+"parent.addModifyPatProblem.document.forms[0].Description.value=\""+p_diag_desc
					+"\";parent.addModifyPatProblem.document.forms[0].diag_srl_no.value='"+p_diag_srl_no
					+"';parent.addModifyPatProblem.document.forms[0].record_type.value='"+p_record_type
					+"';parent.addModifyPatProblem.document.forms[0].cause_indicator.value='"+p_cause_indicator
					+"';parent.addModifyPatProblem.document.forms[0].tab_list_no.value='"+p_tab_list_no
					+"';parent.addModifyPatProblem.document.forms[0].analysis_code.value='"+p_analysis_code
					+"';parent.addModifyPatProblem.document.forms[0].notifiable_yn.value='"+p_notifiable_yn
					+"';parent.addModifyPatProblem.document.forms[0].sensitive_yn.value='"+p_sensitive_yn
					+"';parent.addModifyPatProblem.document.forms[0].Description1.value=\""+p_diag_desc
					+"\";parent.addModifyPatProblem.document.forms[0].LongDescription.value=\""+p_longdescription
					+"\";");
					if(p_notifiable_yn!=null && p_notifiable_yn.equals("Y") )
					{
						a1.append("parent.addModifyPatProblem.document.forms[0].ntf_button.style.visibility='visible';");
					}
					else
					{
						 a1.append("parent.addModifyPatProblem.document.forms[0].ntf_button.style.visibility='hidden';");
					}				
					if(p_longdescription!=null )
					{
						a1.append("parent.addModifyPatProblem.document.forms[0].exclamation.style.visibility='visible';");
					}
					else
					{
						a1.append("parent.addModifyPatProblem.document.forms[0].exclamation.style.visibility='hidden';");
					}				
					if(p_cause_indicator!=null)
					{
						if(p_cause_indicator.equals("E") && p_scheme.equals("2"))
							a1.append("parent.addModifyPatProblem.document.forms[0].cause_ind.options[1].selected=true;");
					}else
					{
						if(p_scheme.equals("2"))
							a1.append("parent.addModifyPatProblem.document.forms[0].cause_ind.options[0].selected=true;");
					}
					if(record_count==1)
					{
						if(p_scheme.equals("2"))
						{
							if(p_cause_indicator.equals("E"))
								a1.append("parent.addModifyPatProblem.document.forms[0].cause_ind.selectedIndex=1;");
							else
								a1.append("parent.addModifyPatProblem.document.forms[0].cause_ind.selectedIndex=0;");
								a1.append("parent.addModifyPatProblem.document.forms[0].cause_ind.disabled=true;");
						}
					}
					if(record_count>1)
						a1.append("parent.addModifyPatProblem.document.forms[0].cause_ind.disabled=false;");

					if(!sensitive_yn.equals("Y"))
					{
						if(p_sensitive_yn.equals("Y"))
						{
							a1 = new StringBuffer();
							a1.append("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>");
							if (authorizeButton.equals("N"))
							a1.append("alert(getMessage('DIAG_AUTH_REQD','CA'));");
							a1.append("parent.addModifyPatProblem.document.forms[0].Description.value='';");
							a1.append("parent.addModifyPatProblem.document.forms[0].Description1.value='';");

							if (authorizeButton.equals("N")){
							a1.append("parent.addModifyPatProblem.document.forms[0].code.focus();");
							a1.append("parent.addModifyPatProblem.document.forms[0].code.select();");
							}

							if (authorizeButton.equals("Y"))
							{
								a1.append("parent.addModifyPatProblem.chkAuthorize(parent.PatProblemQueryTools.document.forms[0].authorize,'" + code_indicator +"');");			
							}
					
						}
					}
									
				 	
				 	a1.append("parent.addModifyPatProblem.document.PatProblem_form.code_indicator.value='"+code_indicator+"';");
					
					//a1.append("if ('"+p_sensitive_yn+"' != 'Y' && parent.addModifyPatProblem.document.PatProblem_form.retVal_auth.value != 'T' ){");
					a1.append("if('"+code_indicator+"' == 'D' || '"+code_indicator+"' == 'C'){");
					a1.append("parent.addModifyPatProblem.document.PatProblem_form.AddAssociateCodes.disabled=false;");
					a1.append("}");
					a1.append("else{     ");
					a1.append("parent.addModifyPatProblem.document.PatProblem_form.AddAssociateCodes.disabled=true;");
					a1.append("parent.addModifyPatProblem.document.PatProblem_form.associate_codes.value = '';");
					a1.append("}");
					//a1.append("}");
					a1.append("</script></head><body CLASS='MESSAGE' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'></body></html>");
					
					out.println(a1.toString());					
				}
				else
				{
					
					out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><body CLASS='MESSAGE' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'><script>alert(getMessage('INVALID_DIAG_CODE_FOR_PATIENT','CA'));parent.addModifyPatProblem.document.forms[0].Description.value='';parent.addModifyPatProblem.document.forms[0].Description1.value='';parent.addModifyPatProblem.document.forms[0].code.focus();parent.addModifyPatProblem.document.forms[0].code.select();parent.addModifyPatProblem.document.forms[0].ntf_button.style.visibility='hidden';parent.addModifyPatProblem.document.PatProblem_form.AddAssociateCodes.disabled=true; </script></body>");
				}
			}
		}
		else
		{
			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><body CLASS='MESSAGE' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'><script>parent.addModifyPatProblem.document.forms[0].Description1.value='';</script></body>");
		}
	
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{	
		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><body CLASS='MESSAGE' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>"+e.toString()+"</body>"); 
	}
	finally 
	{
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}
%>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

