<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/MergedPatientIds.js'></script>
	<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
	<!-- <script language="javascript" src="../../eDR/js/DRrowcolor.js" ></script> -->
	<Script Language="JavaScript" src="../../eCommon/js/rowcolor.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	
</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%
	//String locale = (String)session.getAttribute("LOCALE");

	Connection          con   = null;
	java.sql.Statement	stmt  = null;
	ResultSet	        rs	  = null;
	
	String              str   = "";
	String	   p_patient_id	  = "";
	String   p_patient_line	  = "";
	String              sql	  = "";
	
	int         p_pat_count	  = 0;
	int      p_dup_group_id	  = 0; 
	int       p_pat_rec_cnt	  = 0;

 try
   {
	String whereClause       = request.getParameter("whereclause");
	String from              = request.getParameter( "from" ) ;
	String to	             = request.getParameter( "to" ) ;
	String p_to_replace_date = request.getParameter( "p_to_replace_date" ) ;
	String p_fm_replace_date = request.getParameter( "p_fm_replace_date" ) ;
	if (p_to_replace_date==null || p_to_replace_date.equals("null") || p_to_replace_date.equals("")) 
				p_to_replace_date="31/12/5000";
	if (p_fm_replace_date==null || p_fm_replace_date.equals("null") || p_fm_replace_date.equals("")) 
				p_fm_replace_date="01/01/1700";
	
	con                      =  ConnectionManager.getConnection(request);
	stmt			         =  con.createStatement();

	if(whereClause == null || whereClause.equals("null")) whereClause = "";
	if(whereClause.equals(""))
	{
			sql	= "";
			p_patient_id	= request.getParameter("patient_id");

			if (p_patient_id==null || p_patient_id.equals("null")) 
				p_patient_id="";
			sql	= "  where patient_id = nvl(('"+p_patient_id+"'),patient_id) and nvl(initiating_function_id,0) <> 'MP_CHANGE_PAT_ID' and trunc(added_date) between  to_date('"+p_fm_replace_date+"','dd/mm/yyyy') and to_date('"+p_to_replace_date+"','dd/mm/rrrr') ";
			
			
	}
	else
	{
		sql = whereClause;
	}

	int x					= 0;
	int time_count			= 0;

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null || from.equals("null"))
	{
		start = 1 ;
	}
	else
	{
		start = Integer.parseInt( from ) ;
	}

	if ( to == null || to.equals("null"))
	{
	  	end = 10 ;
	}
	else
	{
		end = Integer.parseInt( to ) ;
	}
		
		
%>

<form name='group_header_form' id='group_header_form'>

	<table border=0 width='100%' cellspacing=0  id='tb1'>
		<tr>
			 <td class=label width='5%'></td>
			 <td class=label width='75%'></td>
			 <td class=label width='20%'></td>
		</tr>
<%


	if (p_patient_id.length() > 0)
	{
		str = "select count(*) total from dr_merged_patient_vw10 " + sql;

		rs = stmt.executeQuery(str);
        if(rs !=null)
		{
		    if (rs.next())
			p_pat_rec_cnt = rs.getInt("total");
		}  
		 if(rs !=null) rs.close();
		 if (p_pat_rec_cnt == 0)
		  {
	%>
		<script> 
			//var ErrorText = 'DR0009 - Patient Record does not exist';
			var ErrorText = getMessage("NO_RECORD","DR");
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		</script>
	<%
		}
	}
	else
	{
	%>
		<script> 
			var ErrorText = '';
			parent.parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_val=&err_num="+ErrorText;
		</script>
	<%
	}

	str   = "select merge_trn_id,patient_id,(CASE WHEN INSTR (Get_dup_Patient_line (patient_id,'"+localeName+"'), '#') > 0  THEN SUBSTR (Get_dup_Patient_line (patient_id,'"+localeName+"'), 1,   INSTR (Get_dup_Patient_line (patient_id,'"+localeName+"'), '#') - 1)  ELSE SUBSTR   (Get_Patient_line (patient_id,'"+localeName+"'), 1,   INSTR (Get_Patient_line (patient_id,'"+localeName+"'), '#') - 1 ) END) patient_line,pat_count,added_by_id,added_date from dr_merged_patient_vw10 " ;
	str  += sql;	
   
	rs	  =stmt.executeQuery(str);
			if (rs != null)
					{
						if ( start != 1 )
						  for( int j=1; j<start; i++,j++ )
						    {	
							  rs.next() ;						  
						    }
							while ( rs.next() && i<=end )
							{
							x= x + 1;
							time_count++;
							p_patient_id	= rs.getString("patient_id");
							p_pat_count		= rs.getInt("pat_count");
							
							p_patient_line	= (rs.getString("patient_line") == null)?"":rs.getString("patient_line");

							p_dup_group_id  = rs.getInt("merge_trn_id");
							

						%>
							<tr id='_<%=p_patient_id%>'>
								<td class='label' valign=top><a href='javascript:viewPatientDetails("<%=p_patient_id%>")'>+</a></td>
								<td colspan='2' class='label'><a name='<%=x%>' onClick='changeRowColor(this,3)' href='javascript:callDupGroupDetails("<%=p_patient_id%>","<%=p_dup_group_id%>","<%=p_pat_count%>")' id='_a<%=p_patient_id%>'>
									<%=p_patient_id%> 
									</a><br>
									<font size=1><%=p_patient_line%> </font>
								</td>
								<td align='right' valign=top class='label'>
									<%=p_pat_count%> 
								</td>
							</tr>
						<%
								i++;
						}
					}if(rs !=null) rs.close();
				%>

</table>
		<input type=hidden name="p_patcount" id="p_patcount" value=0>
</form>

<%

	    if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	}
	catch(Exception e)
	{
	out.println("Exception in The File MergedPatientIDHeader"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>

</body>
</html>

