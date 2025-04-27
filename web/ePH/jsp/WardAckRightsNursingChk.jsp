<!DOCTYPE html>

<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
11/10/2017	  	IN064272	        prathyusha 											GHL-CRF-0466 [IN064272] 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"    import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<html>
<head>
<%
        request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	  	String login_user	=	(String)session.getValue("login_user");
		String facility_id   = (String)session.getValue( "facility_id" );
		String classvalue="";
		//System.err.println("locale===>"+locale);
		//System.err.println("facility_id===>"+facility_id);
		//System.err.println("login_user===>"+login_user);
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="JavaScript" SRC="../js/WardAcknowledgeRights.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
</head>
<body onMouseDown="" onKeyDown="lockKey()">
	<form name="FormWardAckRightsNursingChk" id="FormWardAckRightsNursingChk">
	<% 		
	try{
	java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
	String bean_id						= "WardAcknowledgeRightsBean";
	String bean_name	= "ePH.WardAcknowledgeRightsBean";
	
	WardAcknowledgeRightsBean bean = (WardAcknowledgeRightsBean)getBeanObject( bean_id,bean_name,request) ;
		
			String def_select ="";
			String mode	 = request.getParameter( "mode" ).trim() ;
			String user_id   =  request.getParameter( "user_id" ).trim() ;
			ArrayList result=new ArrayList();
			HashMap map = new HashMap() ;
			int all_count=0;
			int count=0;
			int gen_count=0;
	     	int nar_count=0;
	     	int con_count=0;
			String select_all_chk="";
			String select_gen_all_chk="",select_nor_all_chk="",select_con_all_chk="";
			String select_chk_box="",general_drug="",narcotic_drug="",controlled_drug="";
			String general_drug_chk="",narcotic_drug_chk="",controlled_drug_chk="";
			
%>
	
		<table   cellspacing="0" cellpadding="3" border="2" width = "75%" height="70" align="center">     
					<tr style='position:relative' style='top:expression(this.offsetParent.scrollTop-2)'>
					
						<td class='COLUMNHEADER' width="21%" height="5" align="center"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td >
						<td class='COLUMNHEADER' width=51% align="center"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;</th>
						<td class='COLUMNHEADER' width=7% align="center"><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/></th>
						<td class='COLUMNHEADER' width=50%>
						<table cellspacing="0" >
						<TR align="center"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.AuthorizationRights.label" bundle="${common_labels}"/></TR>
						<tr >
						
						<td  class='COLUMNHEADER' width=7% align="center"><fmt:message key="Common.general.label" bundle="${common_labels}"/>
						<td  class='COLUMNHEADER' width=7% align="center"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/>
						<td  class='COLUMNHEADER' width=7% align="center"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/>
						
						</tr>
						
						</table>
						
						</td>
					
					</tr>

					
			</table>     	
			<%map=bean.nursingAckRights(locale,user_id);  
			result=(ArrayList)map.get("result");
			 all_count=(Integer)map.get("count");
			 gen_count=(Integer)map.get("genral_count");
	     	 nar_count=(Integer)map.get("narcotic_count");
	     	 con_count=(Integer)map.get("contr_count");
			//System.out.println("all_count"+all_count+"map"+map+"result"+result);
			//System.out.println("result"+result.get(result.size()-1)); 
			
			if(all_count>0){
				select_all_chk="checked";
			}
			if(gen_count>0){
				select_gen_all_chk="checked";
			}
			if(nar_count>0){
				select_nor_all_chk="checked";
			}
			if(con_count>0){
				select_con_all_chk="checked";
			}
			
			%>
			<table   cellspacing="0" cellpadding="3" border="2" width = "75%" height="70" align="center">  
			<% if(result.size()>0){  %>
				<tr>
				<td  width="20%" style="font-family:verdana;font-size:8pt;" >*A
				 <input type="hidden"  name="ALL_code" id="ALL_code"  value="*A">
				</td>
				<td  width="48%" style="font-family:verdana;font-size:8pt;" >ALL</td>
				<td    width="7%" align="center"><input type="checkbox" name="select_all_yn" id="select_all_yn"     value="Y"     onclick="selectAll(this);" <%=select_all_chk %> ></td>
				<td   width="7%" align="center"><input type="checkbox" name="general_all_yn" id="general_all_yn"   value="Y"  onclick="gen_Sel(this);"  <%=select_gen_all_chk %>  ></td>
				<td   width="7%" align="center"><input type="checkbox" name="narcotic_all_yn" id="narcotic_all_yn"  value="Y"    onclick="nar_Sel(this)"  <%=select_nor_all_chk %> ></td>
				<td   width="7%" align="center"><input type="checkbox" name="controlled_all_yn" id="controlled_all_yn"  value="Y"  onclick="con_Sel(this)"  <%=select_con_all_chk %> ></td>
			</tr>	
		<%		for(int i=0;i<result.size();i+=6){
					
					/* System.out.println("code"+i+""+result.get(i));
					System.out.println("description"+i+""+result.get(i+1));
					System.out.println("checked"+result.get(i+5));
					System.out.println("gen"+i+""+result.get(i+2));
					System.out.println("nar"+i+""+result.get(i+3));
					System.out.println("controlled"+i+""+result.get(i+4));  */
					general_drug=(String)result.get(i+2);
					narcotic_drug=(String)result.get(i+3);
					controlled_drug=(String)result.get(i+4);
				%>
					<tr>
					            <td class="<%=classvalue%>" style="font-family:verdana;font-size:8pt;" align="left"  name="code_<%=count%>" id="code_<%=count%>"><%=result.get(i)%>
					            <input type="hidden"  name="code_<%=count%>" id="code_<%=count%>"  value="<%=result.get(i)%>">
					            </td>
								<%if((Integer)result.get(i+5) >0){
								select_chk_box="checked";
								}
								else{
									select_chk_box=""; 
								}
								
								%>
								
								 <td class="<%=classvalue%>"   width="45%" style="font-family:verdana;font-size:8pt;" align="left" ><%=result.get(i+1)%></td>
								<td  width="7%" align="center"><input type="checkbox"  name="select_yn_<%=count%>" id="select_yn_<%=count%>" id="select_yn_<%=count%>" onclick="enableProceed(this,<%=count%>);"  <%=select_chk_box %>></td>
								
								<%
								if(general_drug.equals("Y")){general_drug_chk="checked";
								
								%>
								<td  width="2%" align="center"><input type="checkbox"  name="general_yn_<%=count%>" id="general_yn_<%=count%>" id="general_yn_<%=count%>" value="Y"    onclick="AssignValue(this,<%=count%>);" <%=general_drug_chk %> ></td>
								<%
								}
								else{general_drug_chk="";
								
								%>
								<td  width="2%" align="center"><input type="checkbox"  name="general_yn_<%=count%>" id="general_yn_<%=count%>" id="general_yn_<%=count%>" value="N"    onclick="AssignValue(this,<%=count%>);" <%=general_drug_chk %> ></td>
								<%
								}
								if(narcotic_drug.equals("Y")){narcotic_drug_chk="checked";
								%>
								<td  width="2%" align="center"><input type="checkbox"  name="narcotic_yn_<%=count%>" id="narcotic_yn_<%=count%>" id="narcotic_yn_<%=count%>" value="Y"    onclick="AssignValue(this,<%=count%>);" <%=narcotic_drug_chk %> ></td>
								<%
								}
								else{narcotic_drug_chk="";
								%>
								<td  width="2%" align="center"><input type="checkbox"  name="narcotic_yn_<%=count%>" id="narcotic_yn_<%=count%>" id="narcotic_yn_<%=count%>" value="N"    onclick="AssignValue(this,<%=count%>);" <%=narcotic_drug_chk %> ></td>
								<%
								}
								if(controlled_drug.equals("Y")){controlled_drug_chk="checked";
								
								%>
								<td  width="2%" align="center"><input type="checkbox"  name="controlled_yn_<%=count%>" id="controlled_yn_<%=count%>" id="controlled_yn_<%=count%>" value="Y"    onclick="AssignValue(this,<%=count%>);" <%=controlled_drug_chk %>  ></td>
								<%
								}
								else{controlled_drug_chk="";
								
								%>
								<td  width="2%" align="center"><input type="checkbox"  name="controlled_yn_<%=count%>" id="controlled_yn_<%=count%>" id="controlled_yn_<%=count%>" value="N"    onclick="AssignValue(this,<%=count%>);" <%=controlled_drug_chk %>  ></td>
								<%
								}							
								 %>
								
						
					</tr>

		<%		count++;}
				
			}
			%>
			</table>
			
		<input type="hidden" name="count" id="count" value="<%=count-1%>"/>
		<%
		//putObjectInBean(bean_id,bean_name,request);
		}
		catch(Exception e){
			e.printStackTrace();
		}
			
%>
</form>
</body>
</html>



