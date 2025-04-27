<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<!-- ****  Modified by kishor kumar n on 06/12/2008 for crf0387 applied new css grid. **** -->
	
	
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<head>
	<title><fmt:message key="eCA.ViewPatientProviderRelation.label" bundle="${ca_labels}"/></title>
</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<center>
		<form name='PatProvrelationResultForm' id='PatProvrelationResultForm' method='post'>
		<table class='grid' width='100%'>
		<tr align="left">
		<th class='columnHeadercenter' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter' ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></th>
        <th class='columnHeadercenter' ><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter'><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter'><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
		<th class='columnHeadercenter'><fmt:message key="eCA.Remarks.label"bundle="${ca_labels}"/></th>
		</tr>
		<%
			String lifetime="",self="",active="",encounter="", prev_head_desc = "";
			String patient_id = "",episode_id="";
			String head_desc="", phy_prov_name="", phys_prov_reln_name="", begin_date="", end_date="";
			String status="",classValue = "";
			String locn_name = "",visit_adm_date = "",location_type = "",prov_id="";
			String curr_remarks="";
			int countFlag=0;
			int i=0;
			
			StringBuffer query_string = new StringBuffer();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet	rs = null;

			String clinician_id = (String) session.getValue("ca_practitioner_id");

			try
			{
				java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
				String locale = (String) p.getProperty("LOCALE");

				lifetime		= request.getParameter("lifetime");
				self			= request.getParameter("self");
				active			= request.getParameter("active");
				encounter		= request.getParameter("encounter");
				patient_id		= request.getParameter("patient_id");
	            episode_id		= request.getParameter("episode_id");
	            curr_remarks		= request.getParameter("curr_remarks");
	            

				if(patient_id==null) patient_id = "";
				if(encounter==null) encounter = "";
				
				query_string.append("select remarks,lifetime_or_encntr,TO_CHAR(VISIT_ADM_DATE,'DD/MM/YYYY') visit_adm_date,episode_id, location_type, location,decode(location_type,'C',OP_GET_DESC.OP_CLINIC(facility_id,location,?,'1'),'W',IP_GET_DESC.IP_NURSING_UNIT(facility_id,location,?,'1'))locn_name,AM_GET_DESC.AM_PRACTITIONER(PHYS_PROV_ID,?,'1') phy_prov_name,CA_GET_DESC.CA_PRACT_RELN(PRACT_RELN_ID,?,'1') phys_prov_reln_name,to_char(begin_date_time,'dd/mm/yyyy hh24:mi') begin_date,to_char(end_date_time,'dd/mm/yyyy hh24:mi') end_date, status, PHYS_PROV_ID  from ca_encntr_pract_reln_vw where patient_id = ?");
    
				if (lifetime.equals("1"))
					query_string.append(" and lifetime_or_encntr = 'L'");
				else if (lifetime.equals("2"))
                     query_string.append(" and lifetime_or_encntr = 'E'");
				
    
				 if (self.equals("1"))
					{
						  query_string.append(" and phys_prov_id = ? ");
				 }else if (self.equals("2")){
						  query_string.append(" and phys_prov_id != ? ");
				 }
				
                if (active.equals("1"))
					query_string.append(" and sysdate between begin_date_time and nvl(end_date_time,sysdate)");
				else if (active.equals("2"))
                     query_string.append(" and nvl(end_date_time,sysdate) < sysdate");
				
				if (encounter.equals("1")){
				 	query_string.append(" and ((LIFETIME_OR_ENCNTR ='L') or (episode_id = ? ");
					query_string.append( " )) ");
				}

				query_string.append(" order by LIFETIME_OR_ENCNTR desc, VISIT_ADM_DATE desc, episode_id,begin_date_time ");

				con = ConnectionManager.getConnection(request);
	
				pstmt	=	con.prepareStatement(query_string.toString());
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				pstmt.setString(5,patient_id);
				
				if (self.equals("1")){
					pstmt.setString(6,clinician_id);
		    
				if (encounter.equals("1"))
					pstmt.setLong(7,Long.parseLong(episode_id));
				
				}else if (self.equals("2")){
					pstmt.setString(6,clinician_id);
				if (encounter.equals("1"))
					pstmt.setLong(7,Long.parseLong(episode_id));
				
				}
                if (encounter.equals("1") && self.equals("3"))
					pstmt.setLong(6,Long.parseLong(episode_id));
				
				rs = pstmt.executeQuery();
    
				if (rs != null)
				{
					
				while(rs.next())
				{
					countFlag++;

					phy_prov_name		= rs.getString("phy_prov_name");
					phys_prov_reln_name	= rs.getString("phys_prov_reln_name");
					begin_date			= rs.getString("begin_date");
					end_date			= rs.getString("end_date");
					status				= rs.getString("status");

					visit_adm_date		= rs.getString("visit_adm_date");
					locn_name			= rs.getString("locn_name");
					location_type		= rs.getString("location_type");
					curr_remarks =rs.getString("remarks");
					prov_id =rs.getString("PHYS_PROV_ID");
					
					if(prov_id == null)
						prov_id = "";
					
					
					if(curr_remarks == null)
						curr_remarks = "";
					
					if(location_type == null)
						location_type = "";

					if(locn_name == null)
						locn_name = "";

					if(begin_date== null)	
						begin_date="&nbsp;";

					if(end_date== null)		
						end_date="&nbsp;";

					if(visit_adm_date == null)		
						visit_adm_date="&nbsp;";
					
					if(!begin_date.equals("&nbsp;"))
						begin_date = com.ehis.util.DateUtils.convertDate(begin_date,"DMYHM","en",locale);

					if(!end_date.equals("&nbsp;"))
						end_date = com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",locale);
					
					if(!visit_adm_date.equals("&nbsp;"))
						visit_adm_date = com.ehis.util.DateUtils.convertDate(visit_adm_date,"DMY","en",locale);

					if(location_type.equals("C"))
					{
						location_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
					}
					else if(location_type.equals("W"))
					{
						location_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ward.label","common_labels");
					}
					//head_desc = lifetime_or_encntr+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels")+"-"+episode_id+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"-"+locn_name+"/"+location_type;
					head_desc = visit_adm_date+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels")+"- "+episode_id+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"- "+locn_name+"/"+location_type;
					
					String  fields=prov_id+"~"+phys_prov_reln_name.replace(" ","BLANK")+"~"+patient_id; //0605.6
					
					if(status == null) status = "&nbsp;";
					if(!(head_desc.equals(prev_head_desc)))
					{
			%>
						<tr>
							<td colspan=6 align='left' class='CAGROUP'>
								<%=head_desc%>
							</td>
						</tr>
			<%			i=1;
					}
					


					//out.println("status:::"+status);
				/*	if(status.equals("9"))
					{
						status = "Cancelled"

					}
					 if(status.equals(sysdate))
					{
						status = "begin_date"

					}
					else
					{

					}*/
					if(i%2==0) classValue = "gridData";
					else classValue = "gridData";
			%>
					<tr>
						<td class='<%=classValue%>'><%=phy_prov_name%></td>
						<td class='<%=classValue%>'><%=phys_prov_reln_name%></td>
						<td class='<%=classValue%>'><%=begin_date%></td>
						<td class='<%=classValue%>'><%=end_date%></td>
						<%
							if(status.equals("01"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
							else if(status.equals("09"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Expired.label","common_labels");
							else if(status.equals("99"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
							else
								status = status;
						%>
						<td class='<%=classValue%>'><%=status%></td>
					<%	if(curr_remarks!=""){ %>
						   <td class='<%=classValue%>'><a href="#" onClick=ShowRemarksDiag('<%=fields%>')>R</a></td> 
						<%} %>
					</tr>
			<%
					prev_head_desc = head_desc;
					i++;
				}
			}

			if(countFlag==0){
					out.println("<script language=javascript>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			}
			    
			
				if(rs!=null)	rs.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception@1 : "+e.toString());//COMMON-ICN-0181
			}
			finally
			{
				
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
		%>
		</table>
		</form>
	</center>
</body>
<script language='javascript' >

async function ShowRemarksDiag(Val) {
	var retVal;
	var dialogTop		= "310";
 	var dialogHeight	= "14" ;
 	var dialogWidth		= "28" ;
	var dialogLeft		= "240" ;
 	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogLeft:' + dialogLeft +';  dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments		= "";
 	retVal 				=await  window.showModalDialog("../../eCA/jsp/ShowCurrRemarksFrame.jsp?Val="+Val,arguments,features);
 
} 
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</html>

