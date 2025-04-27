<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%
	eCA.CASectionTemplateFieldsAssociationBean templateBean = (eCA.CASectionTemplateFieldsAssociationBean)getObjectFromBean("templateBean","eCA.CASectionTemplateFieldsAssociationBean",session);
%>


<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String qs=request.getQueryString();
	String compId=request.getParameter("comp_id")==null?"":request.getParameter("comp_id");
	String srlNo=request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	String sectionHdgCode= request.getParameter("section_hdg_code")==null?"":request.getParameter("section_hdg_code");
	

        //loading all the dependent component with each component in this template in the bean vector  
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String parentCompIdSrlNo="",childCompIdSrlNo="",prevParentCompIdSrlNo="";
        try
		{
			con = ConnectionManager.getConnection(request);
			if(templateBean.getAssociationData().isEmpty())
			{			
				String sql = "select PARENT_COMP_REF,CHILD_COMP_REF  from CA_COMPONENT_DEPENDENCY_DTL where SEC_HDG_CODE=? order by PARENT_COMP_REF";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,sectionHdgCode);		
				rs=pstmt.executeQuery();
				Vector dependentComp= null;
				while(rs.next())
				{
					parentCompIdSrlNo = rs.getString(1);
					childCompIdSrlNo = rs.getString(2);
					if(!prevParentCompIdSrlNo.equals(parentCompIdSrlNo))
					{
						if(!prevParentCompIdSrlNo.equals(""))
							templateBean.setAssociatedComponents(prevParentCompIdSrlNo,dependentComp);

						dependentComp = new Vector();
						dependentComp.add(childCompIdSrlNo);
					}
					else
					{
						dependentComp.add(childCompIdSrlNo);
					}
					prevParentCompIdSrlNo = parentCompIdSrlNo;
				}
				if(dependentComp!=null)
					templateBean.setAssociatedComponents(parentCompIdSrlNo,dependentComp);
				dependentComp = null;
				//checking if the component selected is already a child of another component
				if(templateBean.isDependent(compId+srlNo)==-2)
				{
					templateBean.clearBean();%>
					<SCRIPT>
					alert(getMessage("ALREADY_CHILD_COMP","CA"));		 
					//alert("APP-CA0002 This Component is already child of \nanother component in this template");
							window.close();
					</SCRIPT>
				<%}   
			}
			//loading the bean with the already existing associations
			StringBuffer XMLString = new StringBuffer();	
			if(templateBean.getHashData().isEmpty())
			{
				try
				{
					String sql = "select DEP_DEFINITION  from ca_section_template where SEC_HDG_CODE=? and SRL_NO=? and COMP_ID =?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,sectionHdgCode);
					pstmt.setString(2,srlNo);
					pstmt.setString(3,compId);
					rs=pstmt.executeQuery();
					Clob formula_def_clob = null;
					if(rs.next())
					{
						formula_def_clob = rs.getClob(1);

						if(formula_def_clob!=null)
						{
							java.io.BufferedReader r = new java.io.BufferedReader(formula_def_clob.getCharacterStream());
							String line = "";
							while((line = r.readLine())!=null)
									XMLString.append(line);
						}		
						
						if(XMLString ==null)
							XMLString.append("");

						templateBean.parseXmlLoadHashtable(XMLString.toString());
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					//out.println("From ca_section_temolate"+e);//COMMON-ICN-0181
				}
				finally
				{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null)
					ConnectionManager.returnConnection(con,request);
					putObjectInBean("templateBean",templateBean,session);
				}	  
			}
		}
        catch(Exception e)
        {
			e.printStackTrace();
			//out.println("From CA_COMPONENT_DEPENDENCY_DTL"+e);//common-icn-0181
        }
		finally
        {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
        }
        
%>
<html>
<head>
	<title><fmt:message key="eCA.SelectDependentComponents.label" bundle="${ca_labels}"/></title>	
</head>
<iframe name='templateLinkingCompSelectionFrame' id='templateLinkingCompSelectionFrame' src='../../eCA/jsp/CASectionTemplateLinkingCompSelScr.jsp?<%=qs%>' frameborder="no" scrolling="auto" noresize style='height:84vh;width:98vw'></iframe>
	<iframe name='templateLinkingCompSelectionToolbarFrame' id='templateLinkingCompSelectionToolbarFrame' src='../../eCA/jsp/CASectionTemplateLinkingCompSelScrToolbar.jsp?<%=qs%>' frameborder=0 scrolling=no noresize style='height:6vh;width:98vw'></iframe>
	<iframe name='dummyFrame' id='dummyFrame' frameborder="no"   style='height:0%;width:100vw'></iframe>

</html>

