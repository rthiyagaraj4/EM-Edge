<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_module_id		= "AM" ;
	String p_report_id		= "AMBEORSR" ;
	String p_passing_local_date="";
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");

	if(locale.equals("th"))
		{
			p_passing_local_date="Y";
		}else 
		{
			p_passing_local_date="N";
		}


Connection con=null;
Statement stmt =null;
	ResultSet rs =null;

%>
<html>
<HEAD>
<TITLE></TITLE>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

/*function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "28" ;
			var dialogWidth	= "43" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale=document.forms[0].locale.value;
				   
						
			if(obj.name=="resourcetype")
			{
				tit=encodeURIComponent(getLabel("eAM.EquipmentOtherResource.label","am"));
				sql="select distinct a.resource_type,b.long_desc from am_resource_lang_vw a,am_resource_type_lang_vw b where a.resource_type=b.resource_type and a.language_id=`"+locale+"` ";
				search_code="a.resource_type";
				search_desc= "b.long_desc";
			}
			
			if(obj.name=="resourceid")
			{
				tit=encodeURIComponent(getLabel("eAM.EquipmentOtherResource.label","am"));
				sql="select distinct resource_id,long_desc from am_resource_lang_vw where language_id=`"+locale+"` ";
				search_code="resource_id";
				search_desc= "long_desc";
			}
			
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}*/

	async function searchCode(obj,target_code,target_desc)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;
				var tit="";
				var sql="";

				if(obj.name=="resourcetype")
			{
					
				tit=getLabel("eAM.EquipmentOtherResource.label","am");
				sql="select distinct a.resource_type code,b.long_desc description from am_resource a,am_resource_type b where a.resource_type=b.resource_type and upper(a.resource_type) like upper(?) and upper(b.long_desc) like upper(?) order by 2  ";
				
				
			}
			
			if(obj.name=="resourceid")
			{
				
				tit=getLabel("eAM.EquipmentOtherResource.label","am");
				sql="select distinct resource_id code ,long_desc description from am_resource where upper(resource_id) like upper(?) and upper(long_desc) like upper(?) order by 2";
				
			
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


			async function searchCode1(obj,target_code,target_desc)
				{


				var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;

				if(obj.name=="p_fm_resource_code" || obj.name=="p_to_resource_code")
			{
					
				tit=getLabel("eAM.EquipmentOtherResource.label","am");
				sql="select distinct a.resource_type code,b.long_desc description from am_resource a,am_resource_type b where a.resource_type=b.resource_type and upper(a.resource_type) like upper(?) and upper(b.long_desc) like upper(?) order by 2  ";
				
			}
			
			if(obj.name=="p_fm_resource_id" || obj.name=="p_to_resource_id")
			{
				
				tit=getLabel("eAM.EquipmentOtherResource.label","am");
				sql="select distinct resource_id code ,long_desc description from am_resource where upper(resource_id) like upper(?) and upper(long_desc) like upper(?) order by 2";
				
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

<BODY onLoad="Focusing('p_fm_resource_code')" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repEquipmentResource" id="repEquipmentResource" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

					<tr>
						<td align="center" width="35%">&nbsp;</td>
						<td class="fields" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="fields" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
 
						<tr>
					<td  width='30%' class="label"><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/>  &nbsp;
					</td>
					<td  width='20%' align="left">
					<SELECT name="p_resource_class" id="p_resource_class">
                    <%
					try {
							  con = ConnectionManager.getConnection(request);
							  stmt = con.createStatement();
							  String sql = "select distinct resource_class from AM_RESOURCE";
							  rs = stmt.executeQuery(sql);
							  if( rs != null )
           					  {
								  %>
								  <option value=''> <fmt:message key="Common.Both.label" bundle="${common_labels}"/>
									  <%
								  while( rs.next())
								  {
										String classname = rs.getString("resource_class") ;
										String classname1;
										if (classname .equals("E")) 
											 classname1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
										else if(classname.equals("O"))
											   classname1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
										else
											   classname1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
                             			%>
										<option value='<%= classname %>'><%= classname1%>
										<%
								  }
							}
						}
						catch(Exception e) { //out.println(e.toString());
							e.printStackTrace();
						}
						finally {
						if (stmt != null) stmt.close();
						if (rs != null)   rs.close();
					    ConnectionManager.returnConnection(con,request);
					}
					%>
				    </select>
				
					</SELECT>
					</td>
				</tr>
				<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
						<td  width='30%' class="label"><fmt:message key="eAM.ResourceTypecode.label" bundle="${am_labels}"/>&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_resource_code' id='p_fm_resource_code' size="2" maxlength="2" align="center" onblur='if(this.value !="") searchCode1(this,p_fm_resource_code,p_fm_resource)'><input type="hidden" name="p_fm_resource" id="p_fm_resource"><input type='button' name='resourcetype' id='resourcetype' value='?' class='button' onclick='searchCode(this,p_fm_resource_code,p_fm_resource)'>
						</td>
						<td width='40%'> <input type=text  name='p_to_resource_code' id='p_to_resource_code' size="2" maxlength="2" align="center" onblur='if(this.value !="") searchCode1(this,p_to_resource_code,p_to_resource)'><input type="hidden" name="p_to_resource" id="p_to_resource"><input type='button' name='resourcetype' id='resourcetype' value='?' class='button' onclick='searchCode(this,p_to_resource_code,p_to_resource)'>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
   			    <tr>
						<td  width='30%' class="label"><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_resource_id' id='p_fm_resource_id' size="15" maxlength="15" align="center" onblur='if(this.value !="") searchCode1(this,p_fm_resource_id,p_fm_resource_id_desc)'><input type="hidden" name="p_fm_resource_id_desc" id="p_fm_resource_id_desc"><input type='button' name='resourceid' id='resourceid' value='?' class='button' onclick='searchCode(this,p_fm_resource_id,p_fm_resource_id_desc)'>
						</td>
						<td width='40%'> <input type=text  name='p_to_resource_id' id='p_to_resource_id' size="15" maxlength="15" align="center" onblur='if(this.value !="") searchCode1(this,p_to_resource_id,p_to_resource_id_desc)'><input type="hidden" name="p_to_resource_id_desc" id="p_to_resource_id_desc"><input type='button' name='resourceid' id='resourceid' value='?' class='button' onclick='searchCode(this,p_to_resource_id,p_to_resource_id_desc)'>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

                  <tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td  width='30%' class="label">
						<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
					</td>
					<td  width='20%' align="left">
						<select name='p_order_by_class' id='p_order_by_class'>
						<option value='3'><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>

			   <tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
					<td align='right' width='30%' class="label">
					&nbsp;
					</td>
					<td  width='20%' align="left">
						<select name='p_order_by_code' id='p_order_by_code'>
						<option value='5'><fmt:message key="eAM.ResourceTypecode.label" bundle="${am_labels}"/>
						<option value='4'><fmt:message key="eAM.ResourceTypeDescription.label" bundle="${am_labels}"/>
						</select>
					</td>
				</tr>

			   <tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
					<td align='right' width='30%' class="label">
					&nbsp;
					</td>
					<td  width='20%' align="left">
						<select name='p_order_by_id' id='p_order_by_id'>
						<option value='6'><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/>
						<option value='7'><fmt:message key="eAM.ResourceDescription.label" bundle="${am_labels}"/>
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
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	

</form>
</BODY>
</HTML>

