<!DOCTYPE html>
 <!-- Program for resources are dispalyed for a particular visit  -->

<html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>		
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eOP/js/resourceType.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
		Connection con=null;
		
		String facility_id=(String)session.getValue("facility_id");
		String fnvalue="Insert";
		String ssource=(String)session.getAttribute("SOURCE");
		Statement stmt=null;
		ResultSet rs=null;
		String sql=null;
		String sql1=null;
		String visit_type_ind=null;
	    String visitind=null;
		String rclass=null;
		String rtype=null;
		
		String vcode=null;
		String vtype1=null;
		String code1=null,desc1=null;
		
		String  rsrlno=null;
		vcode=request.getParameter("visit_type_code");		
        String rcl=request.getParameter("resourceclass");		
		String vtdesc= "" ;		
		String required="Y";
		String requiredCHKBOX="checked";
try
 {
	    con=ConnectionManager.getConnection(request);
		stmt=con.createStatement();

        if(vcode==null)
		{
			visit_type_ind="<select name='indicator' id='indicator' onChange='fetchVals(this.form,this)'><option value=''>&nbsp;-------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+ "--------&nbsp;</option><option value='F' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels")+"&nbsp;<option value='L'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels")+"&nbsp;<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+"&nbsp;<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+"&nbsp;<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels")+"&nbsp;<option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels")+"&nbsp;</select>";
		}
		if(vcode!=null)
		{
		    int serial=Integer.parseInt(request.getParameter("rsource_srl"));
			vcode=vcode.trim();
			fnvalue="Modify";
	     try{
		  				
           sql="select a.visit_type_ind,b.resource_type,b.resource_class,b.resource_srl_no,b.resource_criteria required, c.short_desc VISIT_TYPE_DESC from op_visit_type a,op_resource_type_for_appt b, OP_VISIT_TYPE c  where a.visit_type_code='"+vcode+"' and a.visit_type_code=b.visit_type_code and b.resource_srl_no='"+serial+"' and a.facility_id=b.facility_id and A.FACILITY_ID = C.FACILITY_ID AND A.VISIT_TYPE_CODE = C.VISIT_TYPE_CODE and b.facility_id='"+facility_id+"'";
		
			
			rs=stmt.executeQuery(sql);
			if(rs.next()&&rs!=null)
				{
				visitind=rs.getString(1);
				rtype=rs.getString(2);
				rclass=rs.getString(3);
				
				if(rtype==null)rtype="";
				rsrlno=rs.getString(4);
				
				required=rs.getString(5);
				if(required==null  ){ required="N";}
				if(required.equals("Y")  ) 
					{ requiredCHKBOX="checked";}
				else{
				requiredCHKBOX="";
					}
					vtdesc = rs.getString(6);
			   }

		}catch(Exception e){
				out.println(e.toString());
				e.printStackTrace();
				}
		
		 if (visitind.equals("F")) {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels");
		visit_type_ind= "<input type='text' name='indicator' id='indicator' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}
		else if(visitind.equals("L")) {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
		visit_type_ind= "<input type='text' name='indicator' id='indicator' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}
		else if(visitind.equals("R")) {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		visit_type_ind= "<input type='text' name='indicator' id='indicator' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}
		else if(visitind.equals("E")) {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		visit_type_ind= "<input type='text' name='indicator' id='indicator' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}
		else if(visitind.equals("S")) {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels");
		visit_type_ind= "<input type='text' name='indicator' id='indicator' value='"+vtype1+"' size='15' maxlength='15' readonly>";
			}
		else {
		vtype1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels");
		visit_type_ind= "<input type='text' name='indicator' id='indicator' value='"+vtype1+"' size='20' maxlength='20' readonly>";
		}
		
		if(rtype!=null)
		   rtype=rtype.trim();
	     
		   if(rs!=null)rs.close();
  
	 } // IF closed here
		
	%>
</head>

<body  onLoad="FocusFirstElement()" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
	<form name='ResourceType_form' id='ResourceType_form' action='../../servlet/eOP.ResourceTypeForVisitTypeServlet' method='post' target='messageFrame'>
	<BR><BR><BR> <BR><BR>
		<table width='60%' border=0 align='center' cellspacing='0' cellpadding='0'>      	
		<tr><td colspan=3>&nbsp</td></tr>
		<tr>
				<td width='40%' class='label'><fmt:message key="eOP.VisitTypeIndicator.label" bundle="${op_labels}"/></td>
				<td width='60%' colspan='2' class='fields'><%=visit_type_ind%>
				<img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</tr>
		<tr>
				 <td class='label'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
				 <td class='fields' colspan='2'>
                 <%
				 if(fnvalue.equals("Modify"))
				 {
                 %>
                  <input type='text' name='visit_type' id='visit_type' size='15' maxlength='15' value="<%=vtdesc%>" readonly><img align='center' src='../../eCommon/images/mandatory.gif'></img>
				<input type='hidden' name='visit_type_code' id='visit_type_code' value="<%=vcode%>">
                 <%
                 }
				  else{
                 %>
          		 <select name='visittype' id='visittype' OnChange='fetchVals(this.form,this)'>
					<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					 bundle="${common_labels}"/> --------&nbsp;</option>
					</select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
                  <%}%>    
				</td>
			  </tr>			   
			<tr>
			 	 <td class='label'><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
				 <td colspan='2' class='fields'>
              <%
				 if(fnvalue.equals("Modify"))
				 {
                 %>
                  <input type='text' name='r_class' id='r_class' size='15' maxlength='15' value="<%=rcl%>" readonly><img align='center' src='../../eCommon/images/mandatory.gif'></img>
                 <input type='hidden' name='resource_class_code' id='resource_class_code' value="<%=rclass%>"> 
                 <%
                 }
				  else{
                 %>
				<select name='resourceclass' id='resourceclass' onChange='fetchVals(this.form,this)'>
				<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					 bundle="${common_labels}"/> --------&nbsp;</option>
				<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>  &nbsp;<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> &nbsp;<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>  &nbsp;<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/>  &nbsp;
					</select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
               <%}%>
					</td>
			  </tr>               
             <tr>
				 <td class='label'><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
				 <td class='fields' colspan='2'>
                <%
				if(fnvalue.equals("Insert"))
				{ 
				%>
				  <select name='resourcetype' id='resourcetype' onchange='fetchVals(this.form,this)'>
					<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
					bundle="${common_labels}"/> --------&nbsp;</option>
					</select><img name='im' id='imag' style='display:none' src="../../eCommon/images/mandatory.gif"     align='center'></img>
                <%}
					else
					{%>
					
					<select name='rsource_type' id='rsource_type'>
					<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
						bundle="${common_labels}"/> --------&nbsp;</option>
					<%
						try{
					  if(rclass.equals("P"))
					       sql1="select desc_userdef,pract_type from am_pract_type where eff_status='E' order by seq_no";
					else if(rclass.equals("R"))
					   sql1="select short_desc,locn_type from am_care_locn_type where care_locn_type_ind='R' order by long_desc";
					else if(rclass.equals("E"))
						sql1="select short_desc,resource_type from am_resource_type where eff_status='E' and resource_class='E' order by long_desc";
					 else if(rclass.equals("O"))
						sql1="select short_desc,resource_type from am_resource_type where eff_status='E' and resource_class='O' order by long_desc";
		
					 rs=stmt.executeQuery(sql1);
					 String sel="";
					 while(rs.next())
						{
						 desc1=rs.getString(1);
						 code1=rs.getString(2);
						 if(code1.equals(rtype))
							 sel="selected";
						 if(desc1==null)desc1="";
						%>
						<option value="<%=code1%>"<%=sel%>><%=desc1%></option>;				
						<% sel="";
					    }
					if(rs!=null)rs.close();
					if(stmt != null) stmt.close();
					
			}catch(Exception e) {
						out.println(e.toString());
						e.printStackTrace();
						}
			}//else closed here
					%>
                </select>
				
				</td>
			  </tr>			 
			<tr>
				 <td class='label'><fmt:message key="Common.required.label" bundle="${common_labels}"/></td>
				 <td colspan='2'><input type='checkbox' name='required' id='required' value='Y' <%=requiredCHKBOX%>>
			</tr>
			<tr><td colspan=3>&nbsp</td></tr>
     </table>	 
	 <input type='hidden' name='function_na' id='function_na' value='<%=fnvalue%>'>
	 <input type='hidden' name='function_name' id='function_name'  value='<%=fnvalue%>'>
	 <input type='hidden' name='rserialno' id='rserialno' value='<%=rsrlno%>'>
	 <input type='hidden' name='Gifstatus' id='Gifstatus' value=''>
	 <input type='hidden' name='sparams' id='sparams' value='<%=ssource%>'>
	 <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	 finally{
				try{
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
			
				ConnectionManager.returnConnection(con,request);
			}
	 %>
	 </form>
	 </body>
	 </html>

