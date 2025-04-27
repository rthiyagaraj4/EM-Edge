<!DOCTYPE html>

<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
		request.setCharacterEncoding("UTF-8");
		String sql=null;
		Connection con = null;
		Statement pst=null;
		ResultSet rset=null,prs=null;		
		PreparedStatement pstmt=null;
		
		String clinicLevelOfCare = null;
		String rd_appl_yn = "N";
		try{
		con=ConnectionManager.getConnection(request);
		String code="";
		String desc="";
		String name=request.getParameter("name");
		String value=request.getParameter("value");
		String fid=request.getParameter("fid").trim();
		String ccode=request.getParameter("ccode");
		String radApplYn=request.getParameter("radApplYn");
				
		String comp=" ";
		String func=request.getParameter("function");	
		String sel=request.getParameter("selval");
		String ind = request.getParameter("applind");
		
		String proid=request.getParameter("proid");
		String care_ind=request.getParameter("care_ind");
		String allow_visit_reg=null;
		String vsql="";
		//String lsql="";
		String isAERegisterTypeAutoUpdateAppl = request.getParameter("isAERegisterTypeAutoUpdateAppl"); // added by mujafar for KDAH-CRF-0526
	
		

		pst=con.createStatement();					
	try
	{
		if(name!=null)
			name=name.trim();
			
		if(fid!=null)
			fid=fid.trim();
		if(value!=null)
			value=value.trim();
			
		if(sel!=null)
			sel=sel.trim();
			
		if(ccode!=null)
			ccode=ccode.trim();
		if(!value.equals("")){
			
			/* if(name.equals("location"))
			{
			  
			  if(!value.equals(""))
				{
				  lsql="Select clinic_code, long_desc from op_clinic where (care_locn_type_ind='"+care_ind+"') and facility_id='"+fid+"' and clinic_type in (select locn_type from am_care_locn_type where locn_type='"+value+"') and eff_status='E' order by 2";
				 
				 prs=pst.executeQuery(lsql);
			  while(prs.next())
				{
                  code=prs.getString(1);
				  desc=prs.getString(2); */
				  %>
				<!--	<script>
					  var opt=parent.document.f_query_add_mod.document.createElement("OPTION");
				      opt.text="<%=desc%>";
					  opt.value="<%=code%>";
					  parent.document.f_query_add_mod.document.forms[0].clinic.add(opt);
				  </script> -->
                  <%

				/* }
			 	 if(prs!=null)prs.close();
				
				}
			} */
		if(name.equals("clinic1")){			
	 	   if(func.equals("insert")){
			if(proid.equals("visit_type_for_proc_unit")){
            
			  String psql="select ALLOW_VISIT_REGN_YN from op_clinic where clinic_code='"+value+"' and facility_id='"+fid+"'and CARE_LOCN_TYPE_IND = '"+care_ind+"' ";            prs=pst.executeQuery(psql);			 	
			   
			 	
			  if(prs.next())
				  allow_visit_reg=prs.getString(1);
				
			  if(prs!=null)prs.close();
					
			  if(allow_visit_reg.equals("Y")){
                comp="parent.document.f_query_add_mod.document.forms[0].vitalsignsb";
				vsql="select discr_msr_id,short_desc from am_discr_msr where eff_Status ='E' and result_type ='V' order by short_desc ";
              	
				prs=pst.executeQuery(vsql);
				if(prs != null) {
			while( prs.next() ) {
				code=prs.getString(1);
				desc=prs.getString(2);
			%>
			<script>
				var temp = "<%=code%>";
				var temp1="<%=desc%>";
				var opt=parent.document.f_query_add_mod.document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				var comp=<%=comp%>
				comp.add(opt)
			</script>
			<%		   	  
			}
		   }
				if(prs != null) prs.close();
			   		
				}
	
			} 
				sql=" select ind, type from op_appl_vtypeind_vw where clinic_code='"+value+"' and facility_id='"+fid+"' order by type ";
				pstmt = con.prepareStatement("Select level_of_care_ind,rd_appl_yn from op_clinic where clinic_code = ? and facility_id = ?");
				pstmt.setString(1, value);
				pstmt.setString(2, fid);

				rset = pstmt.executeQuery();

				if( rset != null && rset.next() ){
					clinicLevelOfCare = rset.getString("level_of_care_ind");
					rd_appl_yn = rset.getString("rd_appl_yn")==null?"N":rset.getString("rd_appl_yn");
				}
			%><script>	parent.document.f_query_add_mod.document.forms[0].radApplYn.value='<%=rd_appl_yn%>';	</script><%

				if(pstmt != null) pstmt.close();
				if(rset != null) rset.close();
			  comp="parent.document.f_query_add_mod.document.forms[0].indicator";
			
			}			
			
		}
		}
			
		if(name.equals("indicator")){ 
			if(radApplYn.equals("Y")){
				sql="select nvl(max_appt_duration,0)||'$'||nvl(max_appt_slots,0)||'$'||visit_type_code code,short_desc from op_visit_type where VISIT_TYPE_IND='"+ind+"' and facility_id='"+fid+"' and EFF_STATUS='E' and rd_appl_yn = 'Y' order by short_desc ";
			}else{
				if(proid.equals("visit_type_for_proc_unit")){
					sql="select nvl(max_appt_duration,0)||'$'||nvl(max_appt_slots,0)||'$'||visit_type_code code,short_desc from op_visit_type where VISIT_TYPE_IND='"+ind+"' and facility_id='"+fid+"' and EFF_STATUS='E' and rd_appl_yn = 'N' order by short_desc ";
				}else{
					sql = "select nvl(max_appt_duration,0)||'$'||nvl(max_appt_slots,0)||'$'||visit_type_code code ,short_desc from op_visit_type where facility_id='"+fid+"' and eff_status='E' and visit_type_ind='"+ind+"' and rd_appl_yn = 'N' order by short_desc ";
			}
			}
		comp="parent.document.f_query_add_mod.document.forms[0].visittype";
		}
		
			if(sql!=null){
				pstmt=con.prepareStatement(sql);
				rset = pstmt.executeQuery();
		}
        					
		
		%>
          <html><HEAD>
			<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
			<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				</HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey();'><form name='nam1' id='nam1'>
        <%
		int visitTypeCnt = 0 ;
		if(rset != null) 
		{
			while( rset.next() ) 
			{
				code=rset.getString(1);
				desc=rset.getString(2);
				visitTypeCnt++;
			%>
			<script>
					
				var temp = "<%=code%>";
				var temp1="<%=desc%>";
				var opt=parent.document.f_query_add_mod.document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				var comp=<%=comp%>
				comp.add(opt)

				<%
				if(name.equals("clinic1") && isAERegisterTypeAutoUpdateAppl.equals("true") && code.equals("E") )
				{ // added by mujafar for KDAH-CRF-0526
					visitTypeCnt=visitTypeCnt+1;
				%>	var opt=parent.document.f_query_add_mod.document.createElement("OPTION");
					var temp2 = "W";
					var temp3="EMERGENCY FOLLOW-UP";
					opt.text=temp3;
					opt.value=temp2;
				var comp=<%=comp%>
				comp.add(opt)
				<%
				}
				%>

				
				
			</script>
			<%		   	  
			}
		}
		%><script>if('<%=visitTypeCnt%>' == 1){comp.selectedIndex = 1;comp.onchange();}</script><%
        if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();
	    if(pst != null) pst.close();
	}catch(Exception e) { 
		e.printStackTrace();
		}		   	  
			

		if(clinicLevelOfCare != null)
		if(clinicLevelOfCare.equals("E"))
			{
		%>
            <script> 
			parent.document.f_query_add_mod.document.forms[0].max_appt_duration.readOnly = true; parent.document.f_query_add_mod.document.forms[0].max_appt_slots.readOnly = true; 
			</script>
		<%
			}
		else
			{		
         %>
			 <script>
			   parent.document.f_query_add_mod.document.forms[0].max_appt_duration.readOnly = false; parent.document.f_query_add_mod.document.forms[0].max_appt_slots.readOnly = false;
			 </script>
         <%
			}

	}catch(Exception e) { 
		out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
			if(con!=null) ConnectionManager.returnConnection(con,request);			
	
	}
	%>	
     </form></body></html>

