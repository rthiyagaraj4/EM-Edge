<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../js/SectionTemplate.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%
	request.setCharacterEncoding("UTF-8");	
	Connection con = null;
	
	
    
	String count="";
	String sql		=" ",sql1="",comp_prompt="",comp_type="";
	String  comp_id=request.getParameter("comp_id");
	String  template_type=request.getParameter("template_type");
	if(template_type==null) template_type="";

	if (comp_id==null)comp_id="";
	if(!comp_id.equals("") && ((template_type.equals("")) || (template_type.equals("B"))))
	{
	 con = ConnectionManager.getConnection(request);
	
	
			try
			{									
						
						PreparedStatement pstmt = null;
						ResultSet	rs = null;
						sql=" select count(*) from am_discr_msr where DISCR_MSR_ID=? and EFF_STATUS='E'";
						pstmt	=	con.prepareStatement(sql);
						pstmt.setString(1,comp_id);
						rs = pstmt.executeQuery();
						if(rs!=null)
						{
							while(rs.next())
							{
								count=rs.getString(1);
							}
						}

						if (rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(Integer.parseInt(count)==0)
						{
						 %>
							 <script>
								var msg=getMessage("INVALID_COMP_ID","CA");
							
								top.content.master_pages.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
							 </script>
							 <script>
							  parent.frames[3].document.forms[0].component.select();	
							  parent.frames[3].document.forms[0].component.focus();	
						      </script>

						 <%
						}
						else
						{
						  sql1="select SHORT_DESC comp_prompt,RESULT_TYPE comp_type from AM_DISCR_MSR where DISCR_MSR_ID=? and EFF_STATUS='E'";
						pstmt=	con.prepareStatement(sql1);
						pstmt.setString(1,comp_id);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							comp_prompt=rs.getString(1);
							comp_type=rs.getString(2);
						
							
						
						
						%>
							<script>
						top.content.master_pages.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
				parent.frames[3].document.forms[0].component_prompt.value="<%=comp_prompt%>";
									</script>
						<%
						  if(comp_type.equals("T") || comp_type.equals("P"))
							{
						%>
					    <script>
						parent.frames[3].document.forms[0].column_span.value='3';
						parent.frames[3].document.forms[0].column_span.readOnly=true;
						parent.frames[3].document.forms[0].column_position.value='1';
						parent.frames[3].document.forms[0].column_position.readOnly=true;
						<%
						if(comp_type.equals("P"))
						{
						%>
							parent.frames[3].document.forms[0].hist_rec_type.disabled = true;
						<%}else{%>
							parent.frames[3].document.forms[0].hist_rec_type.disabled = false;
						<%}%>
						</script>
						<%
							}
						  else if(comp_type.equals("F"))
							{
						%>
						<script>
							parent.CASectionTemplateDetailFrame.document.forms[0].formulaDefinitionBtn.style.display='inline';
							callOnFormulaDefinition();
						</script>
						<%
							}
							else if(comp_type.equals("I") || comp_type.equals("N") || comp_type.equals("H"))
							{
						%>
							<script>
								parent.CASectionTemplateDetailFrame.document.getElementById("histDefYNTR").style.display = "inline";
								parent.CASectionTemplateToolbarFrame.document.CASectionTemplateToolbarForm.linkHistoryBtn.style.display = "inline";
							</script>
						<%
							}
							else if(comp_type.equals("L"))
							{
						%>
							<script>
								//parent.CASectionTemplateDetailFrame.document.getElementById("selectionCriteriaTR").style.display = "inline";
								parent.CASectionTemplateDetailFrame.document.getElementById("presentationCriteriaTR").style.display = "inline";
								parent.CASectionTemplateDetailFrame.document.getElementById("numericPrefixTR").style.display = "none";

							</script>
						<%
							}
						  else
							{
						%>
						<script>

						parent.frames[3].document.forms[0].column_span.readOnly=false;
						parent.frames[3].document.forms[0].column_position.readOnly=false;
						parent.frames[3].document.forms[0].hist_rec_type.disabled = true;
						</script>
						<%
							}
						%>
							<script>
								parent.frames[3].document.forms[0].component_type.value = "<%=comp_type%>";
							</script>
						<%
						}
						else//if the status id not E
						{
							%>
							<script>
							var msg01=	"APP-CA0156 Suspended code cannot be used";
							top.content.master_pages.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg01;
							</script>
							<%
						}
  				 }
			
				if (rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
			catch ( Exception e ){
				//out.println("Exception in CAGetComponentPrompt.jsp"+e.toString());//COMMON-ICN-0181
                                  e.printStackTrace();//COMMON-ICN-0181
			}
			finally{
            	
				
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
			
		}
	else{
		%>
			<script>
			top.content.master_pages.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			</script>
		<%
		}
%>

