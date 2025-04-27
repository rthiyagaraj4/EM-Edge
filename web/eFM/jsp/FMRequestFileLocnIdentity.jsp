<!DOCTYPE html>
<!--
	Created On	: 6/17/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Request File
-->

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%


	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	java.sql.Statement stmt		= null;
	java.sql.Statement stmt1	= null;	
	ResultSet rs				= null;
	ResultSet rs1				= null;	
	ResultSet rs3				= null;
	
	try
	{
		con	= ConnectionManager.getConnection(request);
		
		Properties p	= (Properties) session.getValue("jdbc");

		String fac_id		= (String) session.getValue("facility_id");
		String addedById	= p.getProperty("login_user");

		String storage_location	= request.getParameter("storage_location");
		String p_access_all		= request.getParameter("p_access_all");
		String fs_locn_code		= request.getParameter("fs_locn_code")==null?"":request.getParameter("fs_locn_code");
		String Re_Flag		= request.getParameter("Re_Flag")==null?"":request.getParameter("Re_Flag");
		String sql							= "";
		String sql1							= "";	
		String p_req_yn						= "";
		String p_req_across_yn				= "";
		String p_narration_desc				= "";
		String p_access_all_locn_identity	= "";

		stmt  = con.createStatement();
		stmt1 = con.createStatement();		
%>
<html>
<HEAD>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<body CLASS='MESSAGE' onKeyDown = 'lockKey()'>
	<form name='testform' id='testform'>
<%
		if(!(storage_location.equals("")))
		{
			if(!fs_locn_code.equals(""))
			{
				if(fs_locn_code.equals("C"))
				{
					%>
					<script>
						
				var Re_Flag="<%=Re_Flag%>";	
				if(Re_Flag=="Report")		
					{
                      parent.frames[2].document.getElementById("id1").innerHTML=getLabel("Common.clinic.label","common");
						parent.frames[2].document.forms[0].requesting.disabled=false;
						parent.frames[2].document.forms[0].requesting_btn.disabled=false;
					}else{
				      parent.frames[1].document.getElementById("id1").innerHTML=getLabel("Common.clinic.label","common");
						parent.frames[1].document.forms[0].requesting.disabled=false;
						parent.frames[1].document.forms[0].requesting_btn.disabled=false;
					}
					</script>
					<%
				}
				else if(fs_locn_code.equals("N"))
				{
					%>
					<script>
					var Re_Flag="<%=Re_Flag%>";	
				if(Re_Flag=="Report")	
					{
					parent.frames[2].document.getElementById("id1").innerHTML=getLabel("Common.nursingUnit.label","common");
						parent.frames[2].document.forms[0].requesting.disabled=false;
						parent.frames[2].document.forms[0].requesting_btn.disabled=false;
					}else{
				     parent.frames[1].document.getElementById("id1").innerHTML=getLabel("Common.nursingUnit.label","common");
						parent.frames[1].document.forms[0].requesting.disabled=false;
						parent.frames[1].document.forms[0].requesting_btn.disabled=false;
					}
					</script>
					<%
				}
				else if(fs_locn_code.equals("Y"))
				{
					%>
					<script>
						
						var Re_Flag="<%=Re_Flag%>";	
				      if(Re_Flag=="Report")		
					{
						parent.frames[2].document.getElementById("id1").innerHTML=getLabel("Common.DaycareUnit.label","common");
						parent.frames[2].document.forms[0].requesting.disabled=false;
						parent.frames[2].document.forms[0].requesting_btn.disabled=false;
						  
						}else{
						parent.frames[1].document.getElementById("id1").innerHTML=getLabel("Common.DaycareUnit.label","common");
						parent.frames[1].document.forms[0].requesting.disabled=false;
						parent.frames[1].document.forms[0].requesting_btn.disabled=false;
						}
					</script>
					<%
				}
				else if(fs_locn_code.equals("E"))
				{
					%>
					<script>
						
					var Re_Flag="<%=Re_Flag%>";	
				      if(Re_Flag=="Report")		
					   {
					 parent.frames[2].document.getElementById("id1").innerHTML=getLabel("Common.ProcedureUnit.label","common");
						parent.frames[2].document.forms[0].requesting.disabled=false;
						parent.frames[2].document.forms[0].requesting_btn.disabled=false;
					   
					   }else{	parent.frames[1].document.getElementById("id1").innerHTML=getLabel("Common.ProcedureUnit.label","common");
						parent.frames[1].document.forms[0].requesting.disabled=false;
						parent.frames[1].document.forms[0].requesting_btn.disabled=false;
					   }
					</script>
					<%
				}
				else if(fs_locn_code.equals("T"))
				{
					%>
					<script>
						
						var Re_Flag="<%=Re_Flag%>";	
				      if(Re_Flag=="Report")		
					   {
					  parent.frames[2].document.getElementById("id1").innerHTML=getLabel("Common.practitioner.label","common");
						parent.frames[2].document.forms[0].requesting.disabled=false;
						parent.frames[2].document.forms[0].requesting_btn.disabled=false;
					   }else{
				      parent.frames[1].document.getElementById("id1").innerHTML=getLabel("Common.practitioner.label","common");
						parent.frames[1].document.forms[0].requesting.disabled=false;
						parent.frames[1].document.forms[0].requesting_btn.disabled=false;
					   }
					</script>
					<%
				}
			}

			sql  = "SELECT a.NARRATION_CODE ,permanent_file_area_yn FROM FM_STORAGE_LOCN a  WHERE  a.FS_LOCN_CODE='"+storage_location+"' and a.facility_id='"+fac_id+"' ";	
			rs  = stmt.executeQuery(sql) ;
			if( rs != null )
			{
				while (rs.next())
				{
					p_narration_desc= rs.getString( "NARRATION_CODE" )==null?"":rs.getString( "NARRATION_CODE" );
					p_access_all_locn_identity = rs.getString("permanent_file_area_yn")==null?"":rs.getString("permanent_file_area_yn");
				}
			}	
			if(rs!=null) rs.close();		
	
			if(p_access_all.equals("*ALL"))
			{	
				if(p_access_all_locn_identity.equals("Y"))
				{
					p_req_yn		=	"Y";
					p_req_across_yn	=	"Y";
							}
				else
				{
					p_req_yn		=	"Y";
					p_req_across_yn	=	"N";
				}
			}
			else
			{
				sql1 = "select req_yn,req_across_facilities_yn from fm_user_access_rights where facility_id='"+fac_id+"' and fs_locn_code='"+storage_location+"' and appl_user_id='"+addedById+"' ";

				rs1 = stmt1.executeQuery(sql1);

				if(rs1.next())
				{
					p_req_yn		= rs1.getString("req_yn");
					p_req_across_yn = rs1.getString("req_across_facilities_yn");
				}
					}
			%>
			<script>
				var p_req_yn		= '<%=p_req_yn%>';
				var p_req_across_yn = '<%=p_req_across_yn%>';				
	            var Re_Flag="<%=Re_Flag%>";	
				if(Re_Flag=="Report")	
			{
          if(p_req_yn=='Y' && p_req_across_yn=='N')
				{						parent.searchResultFrame1.location.href='../../eFM/jsp/FMRequesteeFileIntRepDetails.jsp?p_print_enter_fcy=N&selected_fcy=YN&p_chosen_fcy=L';						
				}
				else if (p_req_yn=='N' && p_req_across_yn=='Y')
				{
					parent.searchResultFrame1.location.href='../../eFM/jsp/FMRequesteeFileIntRepDetails.jsp?p_print_enter_fcy=Y&selected_fcy=NY&p_chosen_fcy=E';
				}
				else if (p_req_yn=='Y' && p_req_across_yn=='Y')
				{
					parent.searchResultFrame1.location.href='../../eFM/jsp/FMRequesteeFileIntRepDetails.jsp?p_print_enter_fcy=N&selected_fcy=YY&p_chosen_fcy=L';
				}
				else
				{
					parent.frames[1].document.forms[0].logged_fcy.disabled=true;
				}		
			
			
			}else{
				if(p_req_yn=='Y' && p_req_across_yn=='N')
				{						parent.frames[2].document.location.href='../../eFM/jsp/FMRequesteeFileDetails.jsp?p_print_enter_fcy=N&selected_fcy=YN&p_chosen_fcy=L';						
				}
				else if (p_req_yn=='N' && p_req_across_yn=='Y')
				{
					parent.frames[2].document.location.href='../../eFM/jsp/FMRequesteeFileDetails.jsp?p_print_enter_fcy=Y&selected_fcy=NY&p_chosen_fcy=E';
				}
				else if (p_req_yn=='Y' && p_req_across_yn=='Y')
				{
					parent.frames[2].document.location.href='../../eFM/jsp/FMRequesteeFileDetails.jsp?p_print_enter_fcy=N&selected_fcy=YY&p_chosen_fcy=L';
				}
				else
				{
					parent.frames[2].document.forms[0].logged_fcy.disabled=true;
				}					
			}
					 			
			parent.frames[1].document.forms[0].req_narration.value='<%=p_narration_desc%>';
			 /* Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 */
			if(parent.frames[1].document.forms[0].req_narration.options[parent.frames[1].document.forms[0].req_narration.selectedIndex].text.toLowerCase()=='others'){
			  parent.frames[1].document.getElementById("remark_visible").style.visibility='visible' 
	         parent.frames[1].document.forms[0].reason.style.visibility='visible'
			 parent.frames[1].document.forms[0].mandatory.style.visibility='visible'
			  parent.frames[1].document.forms[0].reason.value="";
			} else {
			  parent.frames[1].document.getElementById("remark_visible").style.visibility='hidden' 
	         parent.frames[1].document.forms[0].reason.style.visibility='hidden'
			 parent.frames[1].document.forms[0].mandatory.style.visibility='hidden'
			}
			/* end ML-MMOH-CRF-0393-IN057159  */
			</script>
			<%
		}
		else
		{ %>
		<script>
		parent.frames[1].document.forms[0].req_narration.value="";	
		</script>
		<%}	
		if(rs!=null)	rs.close();	
		if(rs1!=null)	rs1.close();	
		if(rs3!=null)	rs3.close();
		if(stmt!=null)  stmt.close();
		if(stmt1!=null) stmt1.close();		
	}
	catch( Exception e )
	{
		out.println("Exception e :"+e);
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
</html>

