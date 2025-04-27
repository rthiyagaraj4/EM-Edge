<!DOCTYPE html>

<!--
	FileName	: AdaptiveMenuLinkedFunctionsOrder.jsp
	Version	    : 1.0	
	Created On	: 29-06-2009
	Created By	: Arvind Singh Pal
	Purpose     : for CRF-0544-IP

	-->
<%
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
12/03/2018		IN066387	Kamalakannan G	12/03/2018		Ramesh G			Quick Link enable
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="adaptivemenuBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<HTML>
<style>
		TD.FIRSTSELECTED
		{
			BACKGROUND-COLOR: #B1C5E9;  
			FONT-SIZE: 9pt ;
			BORDER-STYLE: SOLID;
			border-left-color: #B2B6D7;
			border-right-color: #B2B6D7;
			border-top-color: #E2E3F0;
			border-bottom-color: #E2E3F0;
			height:18;	
		}
</style>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />		
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script language='javascript' src='../../eCA/js/AdaptiveMenu.js'></script>
		<script>
				function callfun(srlno)
				{
					var rowId_obj = document.getElementById("rowId");
						
					for(i=0;i<rowId_obj.length;i++)
					{
						for(j=0;j<rowId_obj[i].cells.length;j++)
						{
							if(i == (srlno-1))
							{	
								rowId_obj[i].cells[j].className = "FIRSTSELECTED";	
							}					
										
						}
					}
				}
		</script>
</head>
<%
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try
{

	con	= ConnectionManager.getConnection();
	String panel_id="";
	String desc="";
	String id="";
	String description="";
	String classValue="";
	String checkAttribute="checked";
	
	String code="";
	String flag="";
	String mode="";
	String discrete="";
	String mandatory="";
	String mandatory1="";
//	String idupdate="";
//	String descupdate="";
//	String mandatoryupdate="";
	String clearvalue="";
	String disp_flag="";
	String change="";
	String pos1="";
	String pos2="";
	String temp_id="";
	String temp_mandatory1="";
	String temp_description="";
	String removebean="";
	String lastlink="";
	String sql="";
	String load="";
	String eff_status_update="";
	String enabled_checked_update	= "checked";
	String ql_type	= "";
	String adpt_id	= "";
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	sql="select  a.DISPLAY_ORDER, a.L_ADPT_FUNCTION_REF, b.ADPT_FUNCTION_NAME  from SM_QUICK_LINK_ADPT_MNU_DTL a,SM_QUICK_LINK_ADPT_MNU b where a.L_ADPT_FUNCTION_REF = b.ADPT_FUNCTION_REF order by a.DISPLAY_ORDER";
	

	mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	load=(request.getParameter("load")==null)?"":request.getParameter("load");
	
	ql_type=(request.getParameter("ql_type")==null)?"":request.getParameter("ql_type");
	adpt_id=(request.getParameter("adpt_id")==null)?"":request.getParameter("adpt_id");
	clearvalue=(request.getParameter("clearvalue")==null)?"":request.getParameter("clearvalue");
	removebean=(request.getParameter("removebean")==null)?"N":request.getParameter("removebean");	
	discrete= 
	(request.getParameter("discreteid")==null)?"":request.getParameter("discreteid");
	panel_id = (request.getParameter("id")==null)?"":request.getParameter("id");
	desc = (request.getParameter("description")==null)?"":request.getParameter("description");
	
	if(desc.indexOf("|")!=-1)
	
    {
    for(int i=0;i<desc.length();i++)
	{
	//	if(desc.indexOf("|")!=-1)
			desc=desc.replace('|','+');
	}
	}
	code = (request.getParameter("code")==null)?"":request.getParameter("code");
	flag = (request.getParameter("flag")==null)?"":request.getParameter("flag");
	mandatory = (request.getParameter("mandatory")==null)?"":request.getParameter("mandatory");
	disp_flag = (request.getParameter("disp_flag")==null)?"":request.getParameter("disp_flag");
	change = (request.getParameter("change")==null)?"":request.getParameter("change");
	pos1 = (request.getParameter("pos1")==null)?"":request.getParameter("pos1");
	pos2 = (request.getParameter("pos2")==null)?"":request.getParameter("pos2");
	lastlink = (request.getParameter("lastlink")==null)?"":request.getParameter("lastlink");
	//out.println("<script>alert('flag"+flag+"')</script>");


	String sql1 = "select EFF_STATUS,QUICK_LINK_TYPE from SM_QUICK_LINK_LIST_VW  where QUICK_LINK_REF = ? and QUICK_LINK_TYPE = ?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,adpt_id);
			pstmt.setString(2,ql_type);
			rs = pstmt.executeQuery();


			while(rs.next())
			{
				ql_type = rs.getString("QUICK_LINK_TYPE") == null ? "" : rs.getString("QUICK_LINK_TYPE");
				eff_status_update = rs.getString("EFF_STATUS") == null ? "E" : rs.getString("EFF_STATUS");//IN066387
				


				if(eff_status_update.equals("E"))
				{
					enabled_checked_update = "checked";
				}
				else
				{
					enabled_checked_update = "";
				}

			}
			if(rs != null)  rs.close(); 
			if(pstmt != null)  pstmt.close();
	int sp=0;
	int sptemp1=0;
	int sptemp2=0;
	if(change.equals("Y"))
	{
					
		ArrayList b= new ArrayList();
		b= adaptivemenuBean.getRecordSetHandle();
		int j=Integer.parseInt(pos1);
		sptemp1=Integer.parseInt(pos1);
		sptemp2=Integer.parseInt(pos2);
		int m=(3*j)-3;
		temp_id=b.get(m).toString();
		temp_description=b.get(m+1).toString();
		temp_mandatory1=b.get(m+2).toString();
		
		 sp=(j*3);
		//if(pos1!=pos2){
		adaptivemenuBean.removeObject(m+2);
		adaptivemenuBean.removeObject(m+1);
		adaptivemenuBean.removeObject(m);		
		
		
		int n=Integer.parseInt(pos2);
		int p=(3*n)-3;
		
		int q;
		if(j<n)
		q=p-3;
		else
        q=p;		
		
		if(lastlink.equals("X"))
		{
        adaptivemenuBean.putObject(temp_id);
		adaptivemenuBean.putObject(temp_description);
		adaptivemenuBean.putObject(temp_mandatory1);
		
		}
		else
		{         
		
		adaptivemenuBean.addObject(q,temp_id);
		adaptivemenuBean.addObject(q+1,temp_description);
		adaptivemenuBean.addObject(q+2,temp_mandatory1);
		
		// }
		}
	   
		flag="true";
		
		b.clear();
		}
        		
		
		if(code != null )
		{	
			if(flag.equals("false") )
			{
				int elementSize=adaptivemenuBean.getSize();
				if(elementSize<=3){
					out.println("<script>alert(getMessage('ATLEAST_ONE_LINK_FUN','CA'))</script>");
						
				}
				else{
					if(!code.equals("0"))
				{
				
				int s=Integer.parseInt(code) ;
			     
				adaptivemenuBean.removeObject(s+2);
				adaptivemenuBean.removeObject(s+1);
				adaptivemenuBean.removeObject(s);
					
				 }
				 
				 else
				 {
				      
					  
					int s=Integer.parseInt(code) ;
					adaptivemenuBean.removeObject(s+2);
					adaptivemenuBean.removeObject(s+1); 
					adaptivemenuBean.removeObject(s);
				}
				}
			}
		}
	
	
%> 
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >

<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<form name='Linked_form' id='Linked_form' >


<table border='0' cellpadding='0' cellspacing='0' width='99%' align='center'>
<tr ><td class='CAGROUP' align=center><b><font size='2'><fmt:message key="eCA.LinkedFunc.label" bundle="${ca_labels}"/></b></td></tr>
</table> 
<table border='1' cellpadding='0' cellspacing='0' width='99%' align='center'>
<tr>
<th width='20%'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></th>
<!-- <th width='30%'><fmt:message key="eCA.FunctionRef.label" bundle="${ca_labels}"/></th> -->
<th width='60%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
 <th width='20%'><fmt:message key="eCA.UncheckToRemove.label" bundle="${ca_labels}"/></th>

</tr>
	
<%
	

	int MaxLinkedRecord=0;
	if(removebean.equals("Y"))
	{
		if(!(panel_id.equals("") && desc.equals("")) )
		
		{
			MaxLinkedRecord=adaptivemenuBean.getSize();			
			if(adaptivemenuBean.containsObject(panel_id)==false )
			
			{
			if(MaxLinkedRecord<15){		
				adaptivemenuBean.putObject(panel_id);
				adaptivemenuBean.putObject(desc);
				adaptivemenuBean.putObject(mandatory);						
				}
				else{
						%>
						<script>
							var strMesg = getMessage("LINK_FUN_MORE_THAN_5","CA");
									strMesg = strMesg.replace('$$','5');
									alert(strMesg);
						</script>
				
				<%}
							
			}
			else
			{
							
				if (disp_flag.equals("frompanel"))
				{
					int i = Integer.parseInt(clearvalue);					
					adaptivemenuBean.setObject(i,panel_id);
					adaptivemenuBean.setObject(i+1,desc);
					adaptivemenuBean.setObject(i+2,mandatory);
					
				}
				
				else
					//out.println("<script>alert('APP-002005 Record Already Exists...')</script>");
				out.println("<script>alert(getMessage('CODE_ALREADY_EXISTS','Common'))</script>");

		}
	}

}
	else
	{	
		
		if(load.equals("load")){
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			adaptivemenuBean.clearAll();
			while(rs.next()){				
				panel_id=rs.getString("L_ADPT_FUNCTION_REF");			
				desc=rs.getString("ADPT_FUNCTION_NAME");				
				adaptivemenuBean.putObject(panel_id);
				adaptivemenuBean.putObject(desc);	
				adaptivemenuBean.putObject(mandatory);	
	}
		}		
		
	}	

			ArrayList a= new ArrayList();
			a= adaptivemenuBean.getRecordSetHandle();
						           
			int size=0;
			int j=0;
			int k=1;
			size=a.size();			
			for(int i=0;i<size;i++)
			{
				if ( j % 2 == 0 )
					 classValue = "QRYEVEN" ;
				else
					 classValue = "QRYODD" ;	
			
				
				out.println("<tr id=rowId><td class='" + classValue + "' align='center' width='20%' nowrap><a href='javascript:panelposition("+k+");onclick=callfun("+k+");'> "+k+" </a></td>");
				
				id=a.get(i).toString();
				description=a.get(i+1).toString();
				mandatory1= a.get(i+2).toString();				

				//out.println("<td class='" + classValue + "' align='left' width='30%' nowrap>"+id+"</td>");			
				
				out.println("<td class='" + classValue + "' align='left' width='40%' nowrap>");
				%>
				
				<%=description%>
				</td>
				<td class='<%=classValue%>' align='left' width='40%'><input type=checkbox <%=checkAttribute%> name='panelVals' value='<%=i%>' onClick='Reassaign(this)' ></td>
				<%
				out.println("<input type='hidden' name='id_"+k+"' id='id_"+k+"' value='"+id+"'>");
				out.println("<input type='hidden' name='dispOrder_"+k+"' id='dispOrder_"+k+"' value='"+k+"'>");
				i+=2;
				out.println("</tr>");
				j++;
				k++;
				
				
			}
			a.clear();
			%>
            <tr id='last' >
			<td class='" + classValue + "' align='center' width='20%' nowrap >
			<a href='javascript:panelposition("<%=k%>","X");onclick=callfun("<%=k%>");'> <%=k%> </a>
			</td>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>	

</table>

	<%
		
%>		
<input type="hidden" name="first" id="first" value="" >
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name="ql_type" id="ql_type" value="<%=ql_type%>">
<input type="hidden" name="adpt_function_name" id="adpt_function_name" value="">
<input type="hidden" name="desc" id="desc" value="">
<input type="hidden" name="eff_status" id="eff_status" value="">
<input type="hidden" name="eff_status_update" id="eff_status_update" value="<%=eff_status_update%>">
<input type="hidden" name="enabled_checked_update" id="enabled_checked_update" value="<%=enabled_checked_update%>">
<input type="hidden" name="count" id="count" value='<%=j%>'>

	
<%
 //out.println("<script>alert('before show');</script>");
out.println("<script>showvis('true')</script>");
}
catch(Exception e)
{
	e.printStackTrace();	
}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
}
%>

</form>
</body>
<script>
function showStatus()
{
	var ql_type = document.Linked_form.ql_type.value;
	if(ql_type == 'AM'){	
	var eff_update = document.Linked_form.eff_status_update.value;
	var eff_status = parent.f_query_add_mod.document.QuickLink_Form.eff_status;
	if(eff_update!="")//IN066387
    eff_status.value = eff_update;

	if(eff_status.value == 'E')
		{
		  eff_status.checked = true;
		}
		else
		{
			eff_status.checked = false;
		}
	}
}
showStatus();
</script>
</html>

