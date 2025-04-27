<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<script>
	/*function alignWidth()
	{
		var totalRows =  document.getElementById("dataTable").rows.length;
		var counter = totalRows-1;
		var temp = document.getElementById("dataTitleTable").rows(0).cells.length;
		for(var i=0;i<temp;i++)
		{
			document.getElementById("dataTitleTable").rows(0).cells(i).width=document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
		}
	}*/
</script>
	
<% 	
	request.setCharacterEncoding("UTF-8");	

	String Encounter_Id     = request.getParameter("Encounter_Id");				
	String srl_no			= request.getParameter("srl_no");				
	String facility_id		= (String) session.getValue("facility_id");
	
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	Connection con = null;
	PreparedStatement stmt = null, pstmt = null;
	ResultSet rs = null, rs1 = null;

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	
	

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/procedures.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onScroll='scrollTitle()'>
	<form name='result_form' id='result_form'>
<%
	try
	{
        con = ConnectionManager.getConnection(request);

		String trans_key = facility_id+"$"+Encounter_Id+"$"+srl_no;
		String prev_modified_date = "";
		String prev_user_name = "";
		String user_name = "";
		String modified_date = "";
		String label_ref = "";
		String column_name = "";
		String ind = "";
		String old_val = "";
		String new_val = "";
		String desc_query = "";

		String sql="SELECT sm_get_desc.sm_appl_user(a.modified_by_id,?,'1') Modified_user_name, to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modifed_date_str, c.column_name, c.label_ref,  b.old_val ,  b.new_val FROM ca_audit_log_trn_hdr a, ca_audit_log_trn_dtl b, ca_audit_log_criteria c WHERE a.trans_key = ? and a.AUDIT_REF_NUMBER = b.AUDIT_REF_NUMBER and b.modi_col_ref = c.column_name order by a.modified_date desc, c.column_order ";

		
		

		stmt = con.prepareStatement(sql);
		stmt.setString(1, locale);
		stmt.setString(2, trans_key);
		rs = stmt.executeQuery();

		if(rs != null)
		{
	%>
			<div id='divDataTitle' style='postion:relative'>
				<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' style="border-bottom:#ffffff">
				<tr>
					<td class='COLUMNHEADERCENTER' width='30%'><font size=1><fmt:message key="Common.Field.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER' width='35%'><font size=1><fmt:message key="Common.previous.label" bundle="${common_labels}"/> <font size=1><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER' width='35%'><font size=1><font size=1><fmt:message key="Common.Modified.label" bundle="${common_labels}"/> <font size=1><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
				</tr>
				</table>
			</div>
			<table class='grid' border='1' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center' style="border-bottom:#000000">
	<%
			while(rs.next())
			{
				user_name = rs.getString(1)== null ? "" : rs.getString(1);
				modified_date = rs.getString(2)== null ? "" : rs.getString(2);
				column_name = rs.getString(3)== null ? "" : rs.getString(3);
				label_ref = rs.getString(4)== null ? "" : rs.getString(4);
				old_val = rs.getString(5)== null ? "" : rs.getString(5);
				new_val = rs.getString(6)== null ? "" : rs.getString(6);

				if(column_name.equals("ASS_PRACTITIONER1") || column_name.equals("ANAESTHETIST1"))
				{
					ind = "1";
				}
				else if(column_name.equals("ASS_PRACTITIONER2") || column_name.equals("ANAESTHETIST2"))
				{
					ind = "2";
				}
				else if(column_name.equals("ASS_PRACTITIONER3") || column_name.equals("ANAESTHETIST3"))
				{
					ind = "3";
				}
				else
					ind = "";

				if(!label_ref.equals(""))
				{
					if(label_ref.startsWith("eCA"))
					{
						label_ref = com.ehis.util.BundleMessage.getBundleMessage(pageContext,label_ref,"common_labels");
					}
					else if(label_ref.startsWith("Common"))
					{
						label_ref = com.ehis.util.BundleMessage.getBundleMessage(pageContext,label_ref,"common_labels");
					}
					label_ref = label_ref+ind;
				}

				if(column_name.equals("LATERALITY_IND"))
				{
					if(!old_val.equals(""))
					{
						if(old_val.equals("L"))
							old_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
						else if(old_val.equals("R"))
							old_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Right.label","ca_labels");
						else if(old_val.equals("B"))
							old_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
						else if(old_val.equals("N"))
							old_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
						else
							old_val = "";
					}
					if(!new_val.equals(""))
					{
						if(new_val.equals("L"))
							new_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
						else if(new_val.equals("R"))
							new_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Right.label","ca_labels");
						else if(new_val.equals("B"))
							new_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
						else if(new_val.equals("N"))
							new_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
						else
							new_val = "";
					}
				}
				
				if(column_name.equals("PROC_PERF_LOCN_CODE"))
				{
					desc_query = "select OP_GET_DESC.OP_CLINIC(?,?,?,'2') locn_desc from dual";

					if(!old_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,old_val);
						pstmt.setString(3,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								old_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
					if(!new_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,new_val);
						pstmt.setString(3,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								new_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
				}
				
				if(column_name.startsWith("ASS_PRACTITIONER"))
				{
					desc_query = "select AM_GET_DESC.AM_PRACTITIONER(?,?,'1') from dual";
					if(!old_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,old_val);
						pstmt.setString(2,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								old_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
					if(!new_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,new_val);
						pstmt.setString(2,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								new_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
				}

				if(column_name.startsWith("ANAESTHETIST") || column_name.equals("SCRUB_NURSE"))
				{
					desc_query = "Select b.practitioner_name from am_pract_for_facility A, AM_PRACTITIONER_LANG_VW B where a.facility_id= ? and a.eff_status='E' and b.pract_type = ? and a.practitioner_id = b.practitioner_id and b.practitioner_id = ? and b.language_id = ? ";

					if(!old_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,facility_id);
						if(column_name.startsWith("ANAESTHETIST"))
							pstmt.setString(2,"AN");
						else if(column_name.equals("SCRUB_NURSE"))
							pstmt.setString(2,"NS");
						pstmt.setString(3,old_val);
						pstmt.setString(4,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								old_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
					if(!new_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,facility_id);
						if(column_name.startsWith("ANAESTHETIST"))
							pstmt.setString(2,"AN");
						else if(column_name.equals("SCRUB_NURSE"))
							pstmt.setString(2,"NS");
						pstmt.setString(3,new_val);
						pstmt.setString(4,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								new_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
				}
				
				if(column_name.equals("ANAESTHESIA_CODE"))
				{
					desc_query = "Select AM_GET_DESC.AM_ANAESTHESIA(?,?,'1') from dual";
					if(!old_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,old_val);
						pstmt.setString(2,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								old_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
					if(!new_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,new_val);
						pstmt.setString(2,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								new_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
				}

				if(old_val.equals(""))
					old_val = "&nbsp;";
				if(new_val.equals(""))
					new_val = "&nbsp;";

				if(!prev_user_name.equals(user_name) || !prev_modified_date.equals(modified_date))
				{
	%>
					<tr>
					<td class ='CAGROUP' colspan='3'><fmt:message key="Common.date.label" bundle="${common_labels}"/> : <%=modified_date%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<fmt:message key="Common.user.label" bundle="${common_labels}"/> : <%=user_name%></td>
					</tr>
					<tr>
					<td class='gridData' width='30%' style='word-wrap:break-word'><%=label_ref%></td>
					<td class='gridData' width='35%' style='word-wrap:break-word'><%=old_val%></td>
					<td class='gridData' width='35%' style='word-wrap:break-word'><%=new_val%></td>
					</tr>
	<%
					prev_user_name = user_name;
					prev_modified_date = modified_date;
				}
				else
				{
	%>
					<tr>
					<td class='gridData' width='30%' style='word-wrap:break-word'><%=label_ref%></td>
					<td class='gridData' width='35%' style='word-wrap:break-word'><%=old_val%></td>
					<td class='gridData' width='35%' style='word-wrap:break-word'><%=new_val%></td>
					</tr>
	<%
				}
			}
	%>
			</table>
	<%
		}
		if(rs!=null)    rs.close();
		if(stmt!=null)  stmt.close();
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
	   if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
	</form>
	<script>//setTimeout('alignWidth()',500);</script>
</body>
</html>

