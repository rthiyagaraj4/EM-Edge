<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_passing_local_date="";
	String p_module_id		= "AM" ;
	String p_report_id		= "AMBSPLPR" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String)session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");

	if(locale.equals("th"))
		{
			p_passing_local_date="Y";
		}else 
		{
			p_passing_local_date="N";
		}

	String practtype		=  "";
	StringBuffer fm_strt			=new StringBuffer();
	StringBuffer to_strt			=new StringBuffer();
	String practtypedesc	=  "";
	Connection con = null;
	ResultSet rset = null;
	Statement stmt=null;
%>

<html>
<HEAD>
<TITLE></TITLE>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../js/SearchPopup.js" language="JavaScript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
		async function searchCode(obj,target_code,target_desc)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;
				
				var sql="";
				
					if(document.forms[0].name =="repSpecialityForPract"){
						tit=getLabel("Common.speciality.label","Common");
						sql="select distinct speciality_code code, speciality_short_desc description from AM_PRACT_FOR_SPECIALITY_VW where FACILITY_ID ='"+repSpecialityForPract.p_facility.value+"' and upper(speciality_code) like upper(?) and upper(speciality_short_desc) like upper(?) order by 2 ";
						
						
						}else{
						tit=getLabel("Common.Section.label","Common");
						sql="select distinct section_code code, section_short_desc description from AM_FACILITY_SECTION_VW where OPERATING_FACILITY_ID ='"+document.forms[0].p_facility.value+"' and EFF_STATUS = 'E' and upper(section_code) like upper(?) and upper(section_short_desc) like upper(?) order by 2";
						
				
						}
											
				argumentArray[0] = sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target_code.value;
				argumentArray[6] = CODE_LINK ;
				argumentArray[7] = CODE_DESC ;
				
				retVal = await CommonLookup( tit, argumentArray );
				if (retVal !=null && retVal !="")
				{
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target_desc.value=arr[1];
					target_code.value=arr[0];
				}else
				{
				target_desc.value="";
				target_code.value="";
				}
			
			}
</script>
</HEAD>

<BODY  onLoad="Focusing('p_facility'); checkVal('All');" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repSpecialityForPract" id="repSpecialityForPract" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

		<tr>
			<td align="right" class="label" ><fmt:message key="Common.facility.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td colspan='2'><select name='p_facility' id='p_facility' onChange="checkVal(this.value);">
			<%
					try
					{
					
					con = ConnectionManager.getConnection(request);
					stmt=con.createStatement();
					String fid;
					String fname;
					
					String sql1 ="select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";
					
					rset=stmt.executeQuery(sql1);
					
					if(rset!=null)
					{
					   while(rset.next())
					   {
						fid=rset.getString("facility_id");
						fname=rset.getString("facility_name");
						
						if(fid.equals("All"))
						   {
						out.println("<option value='"+fid+"' selected>"+fname+"</option>");
						   }else
						   {
                        out.println("<option value='"+fid+"' >"+fname+"</option>");
						   }
					   }
					}
					   fm_strt= new StringBuffer();
					 to_strt= new StringBuffer();
					//String sqlt = "select pract_type,Desc_Userdef  from am_pract_type_lang_vw where language_id='"+locale+"' ";
						String sqlt = "select pract_type,Desc_Userdef  from am_pract_type";
					if(rset!=null)rset.close();
					rset= stmt.executeQuery( sqlt) ;
					fm_strt.append("<select name='fm_pract_type' id='fm_pract_type'><option value='' > -------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------");
					to_strt.append("<select name='to_pract_type' id='to_pract_type'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------");
					while(rset!=null&&rset.next())
					 {
						practtype=rset.getString("pract_type");
						practtypedesc=rset.getString("Desc_Userdef");
						fm_strt.append("<option value='"+ practtype+"' onClick='checkpract()' >"+practtypedesc);
						to_strt.append("<option value='"+ practtype+"' onClick='checkpract()' >"+practtypedesc);
					 }
					fm_strt.append("</select>");
					to_strt.append("</select>");
				    if(rset!=null)	rset.close();
				    if(stmt!=null)  stmt.close();
					}catch(Exception e) { //out.println(e);
						e.printStackTrace();
					}
					finally
					{
						ConnectionManager.returnConnection(con,request);
					} %>
				</select>
			</td>
			</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

					<tr>
						<td align="center" width="35%">&nbsp;</td>
						<td class="fields" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="fields" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>


					<tr>
							<td align='right' width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
							<td width='20%'  ><input type=text  name='p_fm_section_code' id='p_fm_section_code' size="4" maxlength="4" align="center" onblur='if(this.value !="") searchCode(this,p_fm_section_code,p_fm_section)'><input type="hidden" name="p_fm_section" id="p_fm_section"><input type='button' name='section_fm' id='section_fm' value='?' class='button' onclick='open_lookup(this,p_fm_section_code,p_fm_section)'>
							</td>
							<td width='40%'> <input type=text  name='p_to_section_code' id='p_to_section_code' size="4" maxlength="4" align="center" onblur='if(this.value !="") searchCode(this,p_to_section_code,p_to_section)'><input type="hidden" name="p_to_section" id="p_to_section"><input type='button' name='section_to' id='section_to' value='?' class='button' onclick='open_lookup(this,p_to_section_code,p_to_section)'>
										</td>
								</tr>

								<tr>
									<td>&nbsp;</td>
									<Td>&nbsp;</td>
				</tr>
									<tr>
										<td align='right' width='30%' class="label"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
										<td width='20%'  ><%=fm_strt%>&nbsp;&nbsp;&nbsp;
										</td>
										<td width='40%'><%=to_strt%>&nbsp;&nbsp;&nbsp;
										</td>
								</tr>

												<tr>
									<td>&nbsp;</td>
									<Td>&nbsp;</td>
				</tr>
									<tr>
										<td align='right' width='30%' class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
										<td width='30%'  ><input type=text  name='p_fm_practitioner_id' id='p_fm_practitioner_id' size="15" maxlength="15" align="center" onblur='if(this.value !="") open_lookup(this,p_fm_practitioner_id,p_fm_practitioner)'><input type="hidden" name="p_fm_practitioner" id="p_fm_practitioner"><input type='button' name='practitioner_fm' id='practitioner_fm' value='?' class='button' onclick='open_lookup(this,p_fm_practitioner_id,p_fm_practitioner)'>&nbsp;&nbsp;&nbsp;
										</td>
										<td width='50%'> <input type=text  name='p_to_practitioner_id' id='p_to_practitioner_id' size="15" maxlength="15" align="center" onblur='if(this.value !="") open_lookup(this,p_to_practitioner_id,p_to_practitioner)'><input type="hidden" name="p_to_practitioner" id="p_to_practitioner"><input type='button' name='practitioner_to' id='practitioner_to' value='?' class='button' onclick='open_lookup(this,p_to_practitioner_id,p_to_practitioner)'>&nbsp;&nbsp;&nbsp;
										</td>
								</tr>

								<tr>
									<td>&nbsp;</td>
									<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label" >
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='20%' align="left" colspan='2'>
						<select name='p_order_by' id='p_order_by'>
						<option value='4'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>
						<option value='5'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<!-- <input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
<input type='hidden' name='p_passing_local_date' id='p_passing_local_date' value='<%=p_passing_local_date%>'> -->

</form>
</BODY>
</HTML>

