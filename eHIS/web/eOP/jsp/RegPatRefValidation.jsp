<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,java.io.*,webbeans.eCommon.ConnectionManager" %>
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale =((String)session.getAttribute("LOCALE"));
 request.setCharacterEncoding("UTF-8");
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
</head>
<body class='MESSAGE' onKeyDown = 'lockKey();'>			
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String pr_id = request.getParameter("process_id");
	int process = Integer.parseInt(pr_id);
	Connection con = null;	
	PreparedStatement pstmt=null;
	ResultSet rs = null;	
		
	String loginfacility = (String) session.getValue("facility_id");	

	try
	{
		con = ConnectionManager.getConnection(request);
		
		if(process == 9)
		{
		 String ref_type = request.getParameter("ref_type");
		 if(ref_type==null) ref_type="";
		 String hcare_type_code = request.getParameter("hcare_type");
		 if(hcare_type_code==null) ref_type="";
		 String function_name = request.getParameter("function_name");
		 if(function_name==null) function_name="";
		 String referredtoid="";
		 String referredtodesc="";
		 String hcare_setting_type_desc="";
		 String hcare_setting_type="";
		 String locntypecode="";
		 String locntypedesc="";
		 String sql = "";
		 StringBuffer sql1= new StringBuffer();
		 
		if(ref_type.equals("X"))
		{
			
		}
		else if(ref_type.equals("E") || ref_type.equals("L"))
		{
		
			if(ref_type.equals("E"))
			{%>
			
			<%				
				sql="SELECT a.FACILITY_ID referred_to_id ,a.FACILITY_NAME referred_to_id_desc   ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc hcare_setting_type_desc FROM SM_FACILITY_PARAM_LANG_VW a  , AM_HCARE_SETTING_TYPE_LANG_VW b WHERE a.facility_id != '"+loginfacility+"'  AND a.hcare_setting_type_code='"+hcare_type_code+"'   AND a.hcare_setting_type_code=b.hcare_setting_type_code   AND a.hcare_setting_type_code IN (SELECT to_hcare_setting_type_code FROM    am_hcare_setting_type_rstrn   WHERE from_hcare_setting_type_code = a.HCARE_SETTING_TYPE_CODE AND (ip_referral_yn = 'Y' OR op_referral_yn = 'Y'    )   )   AND a.language_id='"+locale+"'   AND b.language_id='"+locale+"' ORDER BY  a.facility_name";
			}
			else
			{
				sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc hcare_setting_type_desc from SM_FACILITY_PARAM_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = '"+loginfacility+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id='"+locale+"' and b.language_id='"+locale+"' and a.facility_id='"+loginfacility+"' order by a.facility_name";
			}
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					referredtoid=rs.getString("referred_to_id");
					referredtodesc=rs.getString("referred_to_id_desc");
					hcare_setting_type_desc=rs.getString("hcare_setting_type_desc");
					hcare_setting_type=rs.getString("hcare_setting_type_code");
					%>
					<script>
						var temp = "<%=referredtoid%>";
						var temp1="<%=referredtodesc%>";
						var hcare_setting_type_desc="<%=hcare_setting_type_desc%>";
						var hcare_setting_type="<%=hcare_setting_type%>";						
		   
						var opt3=document.createElement("OPTION");
						opt3.text=temp1;
						opt3.value=hcare_setting_type+"~"+temp;     
					<%
						if(ref_type.equals("L"))
						{
						%>	
						parent.frames[1].document.forms[0].p_fm_ref_source.value=temp1;						
						parent.frames[1].document.forms[0].p_fm_ref_source.disabled=true;
						parent.frames[1].document.forms[0].referralfrm.disabled=true;

						parent.frames[1].document.forms[0].referral_source_lkp_bkup_text_frm.value=temp1;						
						parent.frames[1].document.forms[0].referral_source_lkp_id_frm.value=hcare_setting_type+"~"+temp;
						parent.frames[1].document.forms[0].p_fm_ref_source_code.value=temp;
						
							if("<%=function_name%>" != "ReferredOutReport"){
								parent.frames[1].document.forms[0].p_to_ref_source.value=temp1;
								parent.frames[1].document.forms[0].p_to_ref_source.disabled=true;							
								parent.frames[1].document.forms[0].referralto.disabled=true;
								
								parent.frames[1].document.forms[0].referral_source_lkp_bkup_text_to.value=temp1;						
								parent.frames[1].document.forms[0].referral_source_lkp_id_to.value=hcare_setting_type+"~"+temp;
								parent.frames[1].document.forms[0].p_to_ref_source_code.value=temp;
							}						
						parent.frames[1].document.forms[0].p_hcare_type.disabled=false;						
						parent.frames[1].document.forms[0].p_hcare_type.value=hcare_setting_type;
						parent.frames[1].document.forms[0].p_hcare_type.disabled=true;
						<%
						}
						%>
					</script>
					<%
				}
			}	 
			if (rs!=null) rs.close();
			if(pstmt != null) pstmt.close();
			
			if(function_name.equals("ReferredOutReport"))
			{
				int ip=0;
				int op=0;

			sql1.append("select locn_type,short_desc from am_care_locn_type_lang_vw  where ");

			if(ref_type.equals("E"))
			{
				
				sql="select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct           decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from SM_FACILITY_PARAM where facility_id = '"+loginfacility+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";

				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs!=null)
				{
					if (rs.next())
					{
						ip=rs.getInt(1);
						op=rs.getInt(2);
					}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
		

				if (ip> 0 )
				{
				   if (op > 0)
					{
					   sql1.append(" care_locn_type_ind in ('C','E','D','N') and locn_type in('C','E','Y','N') and ");
				
					}
					else
					{
						sql1.append(" care_locn_type_ind in ('N') and locn_type in('N') and ");				
					}
				}
				else
				{       
					if(op>0)
					{
						sql1.append(" care_locn_type_ind in ('C') and locn_type in('C') and ");
					
					}
				
				}
			} //main if ends here
			else{
					sql1.append(" care_locn_type_ind in ('C','E','D','N') and locn_type in('C','E','Y','N') and ");				
				}
			sql1.append(" sys_user_def_ind='S' and  language_id='"+locale+"' order by 2");


			pstmt=con.prepareStatement(sql1.toString());
			rs=pstmt.executeQuery();
			if(rs !=null)
			{
				while(rs.next())
				{
					locntypecode=rs.getString("locn_type");
					locntypedesc=rs.getString("short_desc");
					%>
					<script>
						opt=document.createElement("OPTION");
						opt.text="<%=locntypedesc%>";
						opt.value="<%=locntypecode%>";
						parent.frames[1].document.forms[0].p_location_type_refto.add(opt);                         
					</script>
					<%
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			sql1.setLength(0);
			}
	   }
	}
	}catch(Exception e){out.println(e);}
finally
{
	try{
			if(rs != null)		rs.close();			
			if(pstmt != null) pstmt.close();			
	}catch(Exception ee){}
	if(con != null) ConnectionManager.returnConnection(con,request);
}	
	%>
	</body>
</html>

