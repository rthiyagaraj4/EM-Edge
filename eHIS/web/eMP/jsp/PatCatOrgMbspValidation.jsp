<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page import="webbeans.eCommon.*,java.sql.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>


<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
 <Script src="../../eMP/js/PatientRegistration4.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <Script>
 function checkForEmpSrvNum(obj) { 
 alert("inside patcatmbspvalidation.jsp page 17");
var pract_id=parent.frames[1].frames[1].document.forms[0].loginUser.value
var empServNumCode=parent.frames[1].frames[1].document.forms[0].alt_id1_type.value;  
var empservno=parent.frames[1].frames[1].document.forms[0].alt_id1_no.value;
var family_link_no=''; //parent.frames[1].frames[1].document.forms[0].family_link_no.value;

	//if (family_link_no!="" && empservno!="") {
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH action=\"EmpServNo\" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open('POST','../../eMP/jsp/MPIntermediate.jsp?empServNumCode='+empServNumCode+'&empservno='+empservno+'&headId='+obj.value+'&pract_id='+pract_id+'&fieldName='+obj.name,false);	
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText=TrimStr(responseText); 
		if(responseText=="" || responseText=="null"){	 
		parent.frames[1].frames[1].document.forms[0].emp_service_no.value='';	
		}
		else if(responseText!=""){ 
		parent.frames[1].frames[1].document.forms[0].emp_service_no.value=responseText;
		}
}

 </Script>
</head>
<body class=MESSAGE onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	int count=0;
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String param = request.getParameter("param")==null?"":request.getParameter("param");
	String subid=request.getParameter("subid")==null?"":request.getParameter("subid");
	String defaultSelect1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");

	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
	
		String organization = request.getParameter("organization")==null?"":request.getParameter("organization");
		String code = "";
		String desc = "";

		Boolean isSuspendReinstateRelative = CommonBean.isSiteSpecific(con,"MP","SUSPEND_REINSTATE_RELATIONSHIP");//Added by Thamizh selvi on 11th Jan 2017 against MO-CRF-20119


	if(param.equals("QUERY"))
	{	 
		%>
		<script>

		var n=parent.frames[1].document.forms[0].sub_org.options.length;
	
		for(var i=0;i<n;i++)
		{
			parent.frames[1].document.forms[0].sub_org.remove(0);
		}
		var tp =" --------- "+getLabel("Common.defaultSelect.label","Common")+" ---------- "
		var opt=parent.frames[1].document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		parent.frames[1].document.forms[0].sub_org.add(opt);

		var opt1=parent.frames[1].document.createElement("OPTION");
		opt1.text=" ALL ";
		opt1.value="*ALL";
		parent.frames[1].document.forms[0].sub_org.add(opt1);

	</script>
		<%
		String record_exist="";
		String	sql = " select FAMILY_ORG_SUB_ID, FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_LANG_VW where language_id='"+locale+"' and FAMILY_ORG_ID = '"+organization+"' and EFF_STATUS = 'E' order by FAMILY_ORG_SUB_NAME  ";
		rs = stmt.executeQuery(sql);
		if( rs!=null )
		{
			while(rs.next())
			{
				code = rs.getString("FAMILY_ORG_SUB_ID");
				desc = rs.getString("FAMILY_ORG_SUB_NAME");
				%>
					<script>
						var oOption = parent.frames[1].document.createElement("OPTION");
						oOption.text="<%=desc%>";
						oOption.value="<%=code%>";
						
						parent.frames[1].document.forms[0].sub_org.add(oOption);
					</script>
				<% record_exist="true";
			}
		}
		if(record_exist.equals(""))%>
        <script>
			parent.sub_frame.document.forms[0].sub_org.value='*ALL';
		</script>
	<%
	}
	else
	if(param.equals("CREATE"))
	{
		%>
		<script>
		var n=parent.sub_frame.document.forms[0].sub_org.options.length;
	
		for(var i=0;i<n;i++)
		{
			parent.sub_frame.document.forms[0].sub_org.remove(0);
		}
		var tp =" --------- "+getLabel("Common.defaultSelect.label","Common")+" ---------- "
		var opt=parent.sub_frame.document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		parent.sub_frame.document.forms[0].sub_org.add(opt);

		var opt1=parent.sub_frame.document.createElement("OPTION");
		opt1.text=" ALL ";
		opt1.value="*ALL";
		parent.sub_frame.document.forms[0].sub_org.add(opt1);

	</script>
		<%
		String record_exist="";
		String	sql = " select FAMILY_ORG_SUB_ID, FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_LANG_VW where language_id='"+locale+"' and FAMILY_ORG_ID = '"+organization+"' and EFF_STATUS = 'E' order by FAMILY_ORG_SUB_NAME  ";
		rs = stmt.executeQuery(sql);
		if( rs!=null )
		{
			while(rs.next())
			{
				code = rs.getString("FAMILY_ORG_SUB_ID");
				desc = rs.getString("FAMILY_ORG_SUB_NAME");
				%>
					<script>
						var oOption = parent.sub_frame.document.createElement("OPTION");
						oOption.text="<%=desc%>";
						oOption.value="<%=code%>";
						if(oOption.value=="<%=subid%>" && "<%=subid%>"!='')
                            oOption.selected=true; 
						parent.sub_frame.document.forms[0].sub_org.add(oOption);
					</script>
				<%
						record_exist="true";
			}

		}
		if(subid.equals("*ALL"))%>
        <script>parent.sub_frame.document.forms[0].sub_org.value='*ALL';</script>
	<%}
	else
	if(param.equals("PATREG"))  /*If the function is called from Patient Registration Or ChangePatDtls*/
	{
		%>
		<!--
	   <script>
		var n=parent.frames[1].frames[1].document.forms[0].sub_organization.options.length;
		for(var i=0;i<n;i++)
		{
			parent.frames[1].frames[1].document.forms[0].sub_organization.remove(0);
		}
		var tp =" -- <%=defaultSelect1%> -- "
		var opt=parent.frames[1].frames[1].document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		parent.frames[1].frames[1].document.forms[0].sub_organization.add(opt);

		</script>
		-->
		<%

		int no_of_rec = 0;

	    String	sql = " select FAMILY_ORG_SUB_ID, FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_LANG_VW where language_id='"+locale+"' and FAMILY_ORG_ID = '"+organization+"' and EFF_STATUS = 'E' order by FAMILY_ORG_SUB_NAME  ";
		rs = stmt.executeQuery(sql);
		if( rs!=null )
		{
			while(rs.next())
			{
				no_of_rec++;

				code = rs.getString("FAMILY_ORG_SUB_ID");
				desc = rs.getString("FAMILY_ORG_SUB_NAME");
				//out.println("<script>	var oOption = parent.frames[1].frames[1].document.createElement('OPTION');						oOption.text='"+desc+"';						oOption.value='"+code+"';	parent.frames[1].frames[1].document.forms[0].sub_organization.add(oOption);		</script> ");
			}
		}/*If called from Change Pat Details the previous value should be assigned*/

		if(no_of_rec==1)
		{			out.println("<script>parent.frames[1].frames[1].document.forms[0].sub_organization.value ='"+code+"';parent.frames[1].frames[1].document.forms[0].sub_org_desc.value ='"+desc+"';parent.frames[1].frames[1].document.forms[0].selected_sub.value='"+code+"'; parent.frames[1].frames[1].getPatCategory();</script>");
		}

		%>
		<script>			
		var sel = parent.frames[1].frames[1].document.forms[0].selected_sub.value;		
		if ( sel != '' )
			parent.frames[1].frames[1].document.forms[0].sub_organization.value = sel;
			
		var fType = parent.frames[1].frames[1].document.forms[0].CalledFromFunction.value;
		var mem_type = parent.frames[1].frames[1].document.forms[0].family_org_membership.value;
		var prev_mem_type = parent.frames[1].frames[1].document.forms[0].prev_mem_type.value;
		if  (fType=='ChangePatDtls')  
		{	
			if ( ((mem_type=='2') || (mem_type=='3') || (mem_type=='4')) && (prev_mem_type!='1') )
			{
				parent.frames[1].frames[1].document.forms[0].sub_organization.disabled=true;  
				parent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=true;  
				parent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=true;  
				parent.frames[1].frames[1].document.forms[0].organization.disabled=true;
				parent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=true;
				parent.frames[1].frames[1].document.forms[0].rel.style.visibility='visible';
				if ( (mem_type=='4') && (parent.frames[1].frames[1].document.forms[0].family_link_no.value=='') )
				{
					parent.frames[1].frames[1].document.forms[0].rel.style.visibility='hidden';
				}
			}
			else
			{
				parent.frames[1].frames[1].document.forms[0].sub_organization.disabled=false;
				parent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=false;
				parent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=false;
				parent.frames[1].frames[1].document.forms[0].organization.disabled=false;
				parent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=false;
				if (parent.frames[1].frames[1].document.forms[0].family_link_no=='')
				{
					parent.frames[1].frames[1].document.getElementById("relationship_to_head").value = parent.frames[1].frames[1].document.getElementById("org_member_relationship_code").value;
					parent.frames[1].frames[1].document.forms[0].relationship_to_head.disabled=true;
				}
				if(parent.frames[1].frames[1].document.forms[0].rel)
				parent.frames[1].frames[1].document.forms[0].rel.style.visibility='hidden';
			}
		}
		/*If called from  MP-> Register Patient->Query->Change Demographics*/
		if (parent.frames[1].frames[1].document.getElementById("function_id").value == 'PAT_REG')
		{
			parent.frames[1].frames[1].document.forms[0].sub_organization.disabled=true;  
			parent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=true;  
			parent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=true;  
			parent.frames[1].frames[1].document.forms[0].organization.disabled=true;
			parent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=true;
		}
		</script>
		<%
	}
	else
	 if (param.equals("CATEXP"))
	{
		String category = checkForNull(request.getParameter("category"),"");
		String entitlement_by_pat_cat_yn = checkForNull(request.getParameter("entitlement_by_pat_cat_yn"),"N");
		String sql = "SELECT pat_cat_code, exp_val_appl_yn, to_char(sysdate+exp_period_in_days,'dd/mm/yyyy') exp_date FROM mp_pat_category,dual WHERE eff_status = 'E' ORDER BY 2";
		rs = stmt.executeQuery(sql);
		if( rs!=null )
		{
			while(rs.next())
			{
				code = rs.getString("pat_cat_code");
				if (category.equals(code))
				{
					String exp_val_appl_yn =  checkForNull(rs.getString("exp_val_appl_yn"),"N");
					String exp_date =  rs.getString("exp_date");
					if 	( (entitlement_by_pat_cat_yn.equals("Y")) && (exp_val_appl_yn.equals("Y")))
					{
		%>			   
					<script>
						parent.frames[1].frames[1].document.forms[0].pat_cat_code_exp_date.value="<%=exp_date%>";
						parent.frames[1].frames[1].document.forms[0].exp_val_appl_yn.value="<%=exp_val_appl_yn%>";
						parent.frames[1].frames[1].document.forms[0].pat_cat_code_exp_date.disabled=false;
						parent.frames[1].frames[1].document.forms[0].imgCatExpDate.disabled=false;
						parent.frames[1].frames[1].document.forms[0].imgCatExpDateMan.style.visibility='visible';
					</script>
		<%		
			        } else {
		%>			   
					<script>
						parent.frames[1].frames[1].document.forms[0].pat_cat_code_exp_date.value=	"";
						parent.frames[1].frames[1].document.forms[0].exp_val_appl_yn.value="";
						parent.frames[1].frames[1].document.forms[0].pat_cat_code_exp_date.disabled=true;
						parent.frames[1].frames[1].document.forms[0].imgCatExpDate.disabled=true;
						parent.frames[1].frames[1].document.forms[0].imgCatExpDateMan.style.visibility='hidden';
					</script>
		<%
					}
			}
		}
	}
	}
	else
	 if (param.equals("COPYEMP"))
	{
		 String org_id = checkForNull(request.getParameter("org_id"));
		 String org_sub_id = checkForNull(request.getParameter("org_sub_id"));
		 String family_org_sub_id		= "";
		 String family_org_sub_name		= "";
		 String org_contact_name		= "";
		 String org_addr_line_1			= "";
		 String org_addr_line_2			= "";
		 String  org_addr_line_3		= "";
		 String org_addr_line_4			= "";
		 String  res_area_code			= ""; 
		 String res_town_code			= ""; 
		 String region_code				= "";
		 String  postal_code			= "";
		 String country_code			= ""; 
		 String res_tel_no				= ""; 
		 String off_tel_no				= "";
		 String res_area_desc			= "";
		 String res_town_desc			= "";
		 String res_region_desc			= "";
		 String res_country_desc		= "";
		  if(!org_sub_id.equals(""))
		  {
	 		String sql="SELECT a.family_org_id, a.family_org_sub_id, a.family_org_sub_name,a.org_contact_name, a.org_addr_line_1, a.org_addr_line_2,a.org_addr_line_3, a.org_addr_line_4, a.res_area_code res_area_code,(SELECT long_desc FROM mp_res_area_lang_vw WHERE language_id='"+locale+"' and res_area_code = a.res_area_code) res_area_desc,  a.res_town_code res_town_code,(SELECT long_desc FROM mp_res_town_lang_vw  WHERE language_id='"+locale+"' and res_town_code = a.res_town_code) res_town_desc,a.region_code region_code,(SELECT short_desc FROM mp_region_lang_vw WHERE language_id='"+locale+"' and region_code = a.region_code) res_region_desc,a.postal_code postal_code, a.country_code,(SELECT long_name FROM mp_country_lang_vw  WHERE language_id='"+locale+"' and country_code = a.country_code) res_country_desc, a.res_tel_no,  a.off_tel_no FROM mp_family_org_sub_lang_vw a where language_id='"+locale+"' and a.FAMILY_ORG_SUB_ID='"+org_sub_id+"' and a.family_org_id='"+org_id+ "'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next())
	        {
               org_id						= checkForNull(rs.getString("FAMILY_ORG_ID"));
               family_org_sub_id		= checkForNull(rs.getString("FAMILY_ORG_SUB_ID"));
               family_org_sub_name	= checkForNull(rs.getString("FAMILY_ORG_SUB_NAME"));
               org_contact_name		= checkForNull(rs.getString("ORG_CONTACT_NAME"));
               org_addr_line_1			= checkForNull(rs.getString("ORG_ADDR_LINE_1"));
               org_addr_line_2			= checkForNull(rs.getString("ORG_ADDR_LINE_2"));
               org_addr_line_3			= checkForNull(rs.getString("ORG_ADDR_LINE_3"));
               org_addr_line_4			= checkForNull(rs.getString("ORG_ADDR_LINE_4"));
               res_area_code			= checkForNull(rs.getString("RES_AREA_CODE"));
               res_town_code			= checkForNull(rs.getString("RES_TOWN_CODE"));
               region_code				= checkForNull(rs.getString("REGION_CODE"));
               postal_code				= checkForNull(rs.getString("POSTAL_CODE"));
               country_code			= checkForNull(rs.getString("COUNTRY_CODE"));
               res_tel_no				= checkForNull(rs.getString("RES_TEL_NO"));
               off_tel_no				= checkForNull(rs.getString("OFF_TEL_NO"));
			   res_area_desc			= checkForNull(rs.getString("res_area_desc"));
			   res_town_desc			= checkForNull(rs.getString("res_town_desc"));
			   res_region_desc		= checkForNull(rs.getString("res_region_desc"));
			   res_country_desc		= checkForNull(rs.getString("res_country_desc"));
              
			}
		 }
		 %>
		 <script>
			if(parent.frames[1].frames[1].document.forms[0].employ_addr_line1)
				parent.frames[1].frames[1].document.forms[0].employ_addr_line1.value = "<%=org_addr_line_1%>" ;
			if(parent.frames[1].frames[1].document.forms[0].employ_addr_line2)
				parent.frames[1].frames[1].document.forms[0].employ_addr_line2.value = "<%=org_addr_line_2%>" ;
			if(parent.frames[1].frames[1].document.forms[0].employ_addr_line3)
				parent.frames[1].frames[1].document.forms[0].employ_addr_line3.value = "<%=org_addr_line_3%>" ;
			if(parent.frames[1].frames[1].document.forms[0].employ_addr_line4)
				parent.frames[1].frames[1].document.forms[0].employ_addr_line4.value = "<%=org_addr_line_4%>" ;
			if(parent.frames[1].frames[1].document.forms[0].contact3_res_town_code)
			{
				parent.frames[1].frames[1].document.forms[0].contact3_res_town_code.value = "<%=res_town_desc%>";
				parent.frames[1].frames[1].document.forms[0].e_town.value = "<%=res_town_code%>";
			}
			if(parent.frames[1].frames[1].document.forms[0].contact3_region_code)
			{
				parent.frames[1].frames[1].document.forms[0].contact3_region_code.value = "<%=res_region_desc%>";
				parent.frames[1].frames[1].document.forms[0].e_region.value = "<%=region_code%>";
			}
			if(parent.frames[1].frames[1].document.forms[0].contact3_res_area_code)
			{
				parent.frames[1].frames[1].document.forms[0].contact3_res_area_code.value = "<%=res_area_desc%>";
				parent.frames[1].frames[1].document.forms[0].e_area.value="<%=res_area_code%>";
			}
			if(parent.frames[1].frames[1].document.forms[0].employ_postal_code)
				parent.frames[1].frames[1].document.forms[0].employ_postal_code.value = "<%=postal_code%>";
			if(parent.frames[1].frames[1].document.forms[0].empyr_country_desc)
			{
				parent.frames[1].frames[1].document.forms[0].empyr_country_desc.value = "<%=res_country_desc%>";
				parent.frames[1].frames[1].document.forms[0].empyr_country_code.value = "<%=country_code%>";
			}
			if(parent.frames[1].frames[1].document.forms[0].res3_tel_no)
				parent.frames[1].frames[1].document.forms[0].res3_tel_no.value = "<%=res_tel_no%>";
			if(parent.frames[1].frames[1].document.forms[0].empyr_off_tel_no)
				parent.frames[1].frames[1].document.forms[0].empyr_off_tel_no.value = "<%=off_tel_no%>";
			if (parent.frames[1].frames[1].document.forms[0].empyr_contact_name)
			parent.frames[1].frames[1].document.forms[0].empyr_contact_name.value = "<%=org_contact_name%>"
			</script>
		<%
	  }
	else
	if (param.equals("CHKMEMBERSHIP"))
	{
		String patient_name="";
		String sql = "";
		String CalledFromFunction = checkForNull(request.getParameter("CalledFromFunction"),"");
		String alt_id1_no = checkForNull(request.getParameter("alt_id1_no"),"");
		String alt_id1_db = checkForNull(request.getParameter("alt_id1_db"),"");
		String patient_id = checkForNull(request.getParameter("patient_id"),"");
		String family_org_id_accept_yn = checkForNull(request.getParameter("family_org_id_accept_yn"),"");
		String membership_type = checkForNull(request.getParameter("membership_type"),"");
		ResultSet rset = null;

		if ( (family_org_id_accept_yn.equals("Y")) && (membership_type.equals("1")) && (CalledFromFunction.equals("ChangePatDtls")) && (!alt_id1_db.equals(alt_id1_no)) )
		{
			sql = " select count(*) count from mp_patient where (FAMILY_ORG_MEMBERSHIP='2' or FAMILY_ORG_MEMBERSHIP='3' ) and ALT_ID1_NO = '"+alt_id1_db+"'";
			rset = stmt.executeQuery(sql);
			if(rset.next())
			count = rset.getInt("count");
			if (rset != null) rset.close(); 
			if (count<0) 
			{
			  %>
				 <script>
							alert(getMessage("REL_MEM_EXISTS",'MP'));
							parent.frames[1].frames[1].document.forms[0].prev_mem_type.value="1";
							parent.frames[1].frames[1].document.forms[0].alt_id1_no.value=parent.frames[1].frames[1].document.forms[0].alt_id1_db.value;
							parent.frames[1].frames[1].document.forms[0].alt_id1_no.disabled=true;
							parent.frames[1].frames[1].document.forms[0].family_org_membership.focus();
							self.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				  </script>
				  <%
			}
			/*To check for Organization member records with the given membership ID */
			sql = " select count(*) count from mp_patient where family_org_membership='1' and  ALT_ID1_NO = '"+alt_id1_no+"'";
			rset = stmt.executeQuery(sql);
			if(rset.next())
			count = rset.getInt("count");
			if (rset != null) rset.close();
			if (count>=1) 
			{
			  %>
				<script>		
					alert(getMessage("DUP_ALTID_FOR_MEMBER",'MP'));//" Duplicate Organization Member ID - Cannot Proceed");
					parent.frames[1].frames[1].document.getElementById("alt_id1_no").value=parent.frames[1].frames[1].document.forms[0].alt_id1_db.value;
					parent.frames[1].frames[1].document.forms[0].alt_id1_no.focus();
					self.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				</script><%
			 }
	 }
	 else
	 {
		if (!patient_id.equals(""))
		 sql = " select count(*) count from mp_patient where family_org_membership='1' and	patient_id !='"+patient_id+"' and ALT_ID1_NO = '"+alt_id1_no+"'";
		else
		   sql = " select count(*) count from mp_patient where family_org_membership='1' and  ALT_ID1_NO = '"+alt_id1_no+"'";
		rset = stmt.executeQuery(sql);
		if(rset.next())
		count = rset.getInt("count");
		if (rset != null) rset.close();
		if (count>=1) 
		{
		  %>
			<script>			
			 if ((parent.frames[1].frames[1].document.getElementById("family_org_membership"))&&(parent.frames[1].frames[1].document.forms[0].family_org_membership.value=='1'))
			 {											
				alert(getMessage("DUP_ALTID_FOR_MEMBER",'MP'));//" Duplicate Organization Member ID - Cannot Proceed");
				parent.frames[1].frames[1].document.getElementById("family_org_membership").value='';
				parent.frames[1].frames[1].document.getElementById("alt_id1_no").value='';
				parent.frames[1].frames[1].document.forms[0].alt_id1_no.focus();
				if(parent.frames[1].frames[1].document.forms[0].relationship_to_head_desc)
					parent.frames[1].frames[1].document.forms[0].relationship_to_head_desc.value='';
				if(parent.frames[1].frames[1].document.forms[0].relationship_to_head)
					parent.frames[1].frames[1].document.forms[0].relationship_to_head.value='';
				parent.frames[1].frames[1].document.forms[0].sub_organization.disabled=true;
				parent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=true;
				parent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=true;
				parent.frames[1].frames[1].document.forms[0].sub_org_desc.value='';
				parent.frames[1].frames[1].document.forms[0].sub_organization.value='';
				parent.frames[1].frames[1].document.forms[0].org_sub_org.style.visibility='hidden';
				self.location.href = "../../eCommon/jsp/error.jsp?err_num=";
			 }
			</script>
			
			<!-- Added by Thamizh selvi on 13th Jan 2017 against MO-CRF-20119 Start-->
			<%
			if(isSuspendReinstateRelative)
			{
				sql = "SELECT COUNT (*) COUNT FROM mp_patient WHERE family_org_membership ='1' AND alt_id1_no = '"+alt_id1_no+"' AND suspend_yn = 'Y'";
				rset = stmt.executeQuery(sql);
				if(rset.next())
				count = rset.getInt("count");
				if (rset != null) rset.close();
				if (count>=1) 
				{
				  %>
					<script>
					 if ((parent.frames[1].frames[1].document.getElementById("family_org_membership"))&&((parent.frames[1].frames[1].document.forms[0].family_org_membership.value=='2') || (parent.frames[1].frames[1].document.forms[0].family_org_membership.value=='3') ))
					 {	
						alert(getMessage("ORG_MEMB_ID_SUSPENDED",'MP'));
						parent.frames[1].frames[1].document.getElementById("family_org_membership").value='';
						
						parent.frames[1].frames[1].document.getElementById("alt_id1_no").value='';
						parent.frames[1].frames[1].document.forms[0].alt_id1_no.focus();
					
						parent.frames[1].frames[1].document.forms[0].rel.style.visibility='hidden';
						parent.frames[1].frames[1].document.forms[0].alt1_gif.style.visibility='hidden';
						parent.frames[1].frames[1].document.forms[0].org_sub_org.style.visibility='hidden';
						self.location.href = "../../eCommon/jsp/error.jsp?err_num=";
					 }
					</script>
			<% } 
			} %>
			<!-- Added by Thamizh selvi on 13th Jan 2017 against MO-CRF-20119 End-->
		  <%
			sql = " select patient_id,decode('"+locale+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name))  patient_name,family_org_id, family_org_sub_id from mp_patient where family_org_membership='1' and alt_id1_no = '"+alt_id1_no+"'";
			rset = stmt.executeQuery(sql);
			if (rset!=null)
			{
				rset.next();
				patient_id =  checkForNull(rset.getString("patient_id"));
				patient_name =  checkForNull(rset.getString("patient_name"));
				String family_org_id =  checkForNull(rset.getString("family_org_id"),"N");
				String family_org_sub_id =  checkForNull(rset.getString("family_org_sub_id"));
				if (family_org_id.equals(""))
				{
					%>
					<script>
					parent.frames[1].frames[1].document.forms[0].organization.disabled=false;
					parent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=false;
					</script>
					<%
				}
				else
				{
					%>
					<script>
					parent.frames[1].frames[1].document.forms[0].organization.disabled=true;
					parent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=true;
					</script>
					<%
				}
				if (family_org_sub_id.equals(""))
				{
					int no_of_rec = 0;
					sql = " select FAMILY_ORG_SUB_ID, FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_lang_vw where language_id='"+locale+"' and FAMILY_ORG_ID = '"+family_org_id+"' and EFF_STATUS = 'E' order by FAMILY_ORG_SUB_NAME ";
				   rset = stmt.executeQuery(sql);
				  %> 
				  <script>
				   parent.frames[1].frames[1].document.forms[0].sub_organization.disabled=false
				   parent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=false
				   parent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=false
				  </script>
				  <%
				  while(rset.next())
				  {
					code = rset.getString("FAMILY_ORG_SUB_ID");
					desc = rset.getString("FAMILY_ORG_SUB_NAME");
					no_of_rec++;
					%>
					<!--
					<script>
						var oOption = parent.frames[1].frames[1].document.createElement("OPTION");
						oOption.text="<%=desc%>;
						oOption.value="<%=code%>;
						parent.frames[1].frames[1].document.forms[0].sub_organization.add(oOption);
					</script>
					-->
					<%
					}

					if(no_of_rec==1)
					{			out.println("<script>parent.frames[1].frames[1].document.forms[0].sub_organization.value ='"+code+"';parent.frames[1].frames[1].document.forms[0].sub_org_desc.value ='"+desc+"';</script>");
					}

					if (rset != null) rset.close();
				}
				else
				{
					String 	 org_name = "";
					sql = " select  a.family_org_name, b.family_org_sub_name from mp_family_org_lang_vw a, mp_family_org_sub_lang_vw b where b.language_id='"+locale+"' and a.family_org_id = '"+family_org_id+"' and a.family_org_id = b.family_org_id and family_org_sub_id='"+family_org_sub_id+"'";
					rset = stmt.executeQuery(sql);
					if (rset.next())
					{
						  org_name = rset.getString("family_org_name");
						  desc = rset.getString("family_org_sub_name");
					}
				 %>
					<script>
					//var oOption = parent.frames[1].frames[1].document.createElement("OPTION");
					//oOption.text="<%=desc%>";
					//oOption.value="<%=family_org_sub_id%>";
					//parent.frames[1].frames[1].document.forms[0].sub_organization.add(oOption);			  
					//parent.frames[1].frames[1].document.forms[0].sub_organization.selectedIndex=1;		
					parent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=true;
					parent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=true;
					parent.frames[1].frames[1].document.forms[0].sub_organization.value="<%=family_org_sub_id%>";
					parent.frames[1].frames[1].document.forms[0].sub_org_desc.value="<%=desc%>";
					parent.frames[1].frames[1].document.forms[0].organization.disabled=false;
					parent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=false;
					parent.frames[1].frames[1].document.forms[0].organization.value="<%=org_name%>";
					parent.frames[1].frames[1].document.forms[0].org_id.value="<%=family_org_id%>";
					parent.frames[1].frames[1].document.forms[0].organization.disabled=true;
					parent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=true;
				   </script>
				 <%
				}
				 %>  <script>
					 if (parent.frames[1].frames[1].document.forms[0].family_link_no)
					{					 
						parent.frames[1].frames[1].document.forms[0].family_link_no.value="<%=patient_id%>";
						parent.frames[1].frames[1].document.getElementById("head_pat_name").innerText="<%=patient_name%>";
						parent.frames[1].frames[1].document.forms[0].family_link_no.disabled=true;
						
					
						checkForEmpSrvNum(parent.frames[1].frames[1].document.forms[0].family_link_no);
							
						
						parent.frames[1].frames[1].getPatCategory();
						parent.frames[1].frames[1].document.forms[0].head_pat_search_reg.disabled=true;
						if(parent.frames[1].frames[1].document.forms[0].relationship_to_head_desc)
							parent.frames[1].frames[1].document.forms[0].relationship_to_head_desc.disabled=false;
						//parent.frames[1].frames[1].document.forms[0].relationship_to_head_desc.focus();
						parent.frames[1].frames[1].document.forms[0].relationship_to_head_id.disabled=false;
						if(parent.frames[1].frames[1].document.forms[0].relationship_to_head_code_id)
							parent.frames[1].frames[1].document.forms[0].relationship_to_head_code_id.focus();
						//parent.frames[1].frames[1].document.forms[0].relationship_to_head.disabled=false;
						//parent.frames[1].frames[1].document.forms[0].relationship_to_head.focus();
					}
						</script>
				 <%
			}
			if (rset != null) rset.close();
	 }
	else //  Count == 0 and Organization membership flag is checked
	if ( (count==0) && (family_org_id_accept_yn.equals("Y")) && ((membership_type.equals("2")) || (membership_type.equals("3"))) )
			{
				%>
						<!--
						<script>
							
							var n=parent.frames[1].frames[1].document.forms[0].sub_organization.options.length;
							for(var i=0;i<n;i++)
							{
								parent.frames[1].frames[1].document.forms[0].sub_organization.remove(0);
							}
							var tp =" --- <%=defaultSelect1%> --- "
							var opt=parent.frames[1].frames[1].document.createElement("OPTION");
							opt.text=tp;
							opt.value="";
							parent.frames[1].frames[1].document.forms[0].sub_organization.add(opt);
							-->

							<script>							

							alert(getMessage("ORG_MEM_NOT_EXISTS",'MP'));
							parent.frames[1].frames[1].document.forms[0].family_org_membership.value='';
							parent.frames[1].frames[1].document.forms[0].alt_id1_no.value='';
							parent.frames[1].frames[1].document.forms[0].alt_id1_no.focus();
							parent.frames[1].frames[1].document.forms[0].sub_organization.disabled=true;
							parent.frames[1].frames[1].document.forms[0].sub_org_id_btn.disabled=true;
							parent.frames[1].frames[1].document.forms[0].sub_org_desc.disabled=true;
							parent.frames[1].frames[1].document.forms[0].sub_org_desc.value='';
							parent.frames[1].frames[1].document.forms[0].sub_organization.value='';				
							parent.frames[1].frames[1].document.forms[0].organization.value="";
							if(parent.frames[1].frames[1].document.forms[0].family_link_no)
							parent.frames[1].frames[1].document.forms[0].family_link_no.value="";
							if(parent.frames[1].frames[1].document.forms[0].relationship_to_head)
							parent.frames[1].frames[1].document.forms[0].relationship_to_head.value="";
							parent.frames[1].frames[1].document.forms[0].organization.disabled=true;
							parent.frames[1].frames[1].document.forms[0].org_id_btn.disabled=true;
						</script>
				 <%
			}
	}
	}
	else
	if (param.equals("CHK_RELATED_MEM"))
	{
		String alt_id1_no = checkForNull(request.getParameter("alt_id1_no"),"");
		String sql = " select count(*) count from mp_patient where (FAMILY_ORG_MEMBERSHIP='2' or FAMILY_ORG_MEMBERSHIP='3' ) and ALT_ID1_NO = '"+alt_id1_no+"'";
		ResultSet rset = null;
		 count = 0;
		rset = stmt.executeQuery(sql);
		if(rset.next())
		count = rset.getInt("count");
		if (rset != null) rset.close(); 
		if (count>0) 
		{
		  %>
			 <script>
				if (parent.frames[1].frames[1].document.forms[0].family_org_membership.value != "1")
				{	  
						alert(getMessage("REL_MEM_EXISTS",'MP'));
						parent.frames[1].frames[1].document.forms[0].family_org_membership.value="1";
						parent.frames[1].frames[1].document.forms[0].prev_mem_type.value="1";
						parent.frames[1].frames[1].document.forms[0].alt_id1_no.disabled=true;
						parent.frames[1].frames[1].document.forms[0].family_org_membership.focus();
						self.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				}
			  </script>
			  <%
		}
		  else%>
			<script>parent.frames[1].frames[1].makeOrgMandate(parent.frames[1].frames[1].document.forms[0].family_org_membership)</script>
			  <%
	}
	else
	if(param.equals("PATSEARCH"))  /*If the function is called from Patient Search*/
	{
		%>
		<!--
	   <script>
		var n=parent.frames[1].document.Patient_Search_Form.sub_organization.options.length;
		for(var i=0;i<n;i++)
		{
			parent.frames[1].document.Patient_Search_Form.sub_organization.remove(0);
		}
		var tp ="--- <%=defaultSelect1%> --- "
		var opt=parent.frames[1].document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		parent.frames[1].document.Patient_Search_Form.sub_organization.add(opt);
		</script>
		-->
		<%
			int no_of_rec = 0;
	   String	sql = " select FAMILY_ORG_SUB_ID, FAMILY_ORG_SUB_NAME from MP_FAMILY_ORG_SUB_LANG_VW where language_id='"+locale+"' and FAMILY_ORG_ID = '"+organization+"' and EFF_STATUS = 'E' order by FAMILY_ORG_SUB_NAME  ";
		rs = stmt.executeQuery(sql);
		if( rs!=null )
		{
		%>
		<script>
			//parent.frames[1].document.Patient_Search_Form.sub_organization.disabled=false;
			parent.Pat_Search_Criteria_Frame.document.Advnc_Patient_Search_Form.sub_org_desc.disabled=false;
		</script>
			<%
			while(rs.next())
			{
				code = rs.getString("FAMILY_ORG_SUB_ID");
				desc = rs.getString("FAMILY_ORG_SUB_NAME");
				no_of_rec++;
				%>
				<!--
					<script>
						var oOption = parent.frames[1].document.createElement("OPTION");
						oOption.text="<%=desc%>";
						oOption.value="<%=code%>";
						parent.frames[1].document.Patient_Search_Form.sub_organization.add(oOption);
					</script>
				-->
				<%
			}
		}
		if(no_of_rec==1)
		{	
			out.println("<script>parent.frames[2].document.forms[0].sub_organization.value ='"+code+"';parent.frames[2].document.forms[0].sub_org_desc.value ='"+desc+"';</script>");
		}		
	}
	}catch (Exception e){
		out.println(e);
	}
	finally{
		if(stmt != null) stmt.close();
		if(rs!=null) rs.close();
		
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	public String singleToDoubleQuotes(String strDB)
	{
		/*
		String strModified="";
		try
		{
			if((strDB != null) ||(strDB !=""))
			{
				StringBuffer stringbuffer = new StringBuffer(strDB);
				int i = 0;
				for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
				{
					i = strDB.indexOf('\'', i);
					stringbuffer.insert(i + j, "'");
					i++;
				}
				strModified=stringbuffer.toString();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		return strDB.replaceAll("'","''");
	}
%>

