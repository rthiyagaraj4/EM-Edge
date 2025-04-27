<%@page import="java.sql.*,java.util.*, eCA.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	//HashMap dataMap=null;
	
	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String calc_id = request.getParameter("calc_id")==null?"":request.getParameter("calc_id");

	Connection		  con	=	null;
	PreparedStatement stmt	=	null;
	ResultSet		  rs	=	null;

	String formula_ref_id   = "";
	String formula_ref_desc = "";
	String form_selected = "";


	try{

		con =  ConnectionManager.getConnection(request);

		String formulaQry = " SELECT FORMULA_REF_ID, FORMULA_REF_DESC,(select f.FORMULA_REF_ID from CA_CLINICAL_CALC f where f.CALC_ID= ? ) form_sel FROM CA_CLIN_CALC_DEF WHERE CALC_ID = ? " ;

		stmt = con.prepareStatement(formulaQry);

		stmt.setString(1,calc_id);
		stmt.setString(2,calc_id);
		
		rs = stmt.executeQuery();

		while(rs.next())
		{

			formula_ref_id	=	rs.getString("FORMULA_REF_ID");
			formula_ref_desc	= rs.getString("FORMULA_REF_DESC");
			form_selected	=	rs.getString("form_sel");


			
			out.println("var element = parent.ClinicalCalcSelectFrame.document.createElement('OPTION')");
			out.println("element.text = '"+formula_ref_desc+"'");
			out.println("element.value = '"+formula_ref_id+"'");
			if(form_selected.equals(formula_ref_id))
			{
				out.println("element.selected = true");
			}
			out.println("parent.ClinicalCalcSelectFrame.document.ClinicalCalcSelectForm.clin_formula.add(element)");
			out.println("parent.frames[2].location.href='../../eCA/jsp/ClinicalCalcSelectedFormulaList.jsp?formula_ref_id="+form_selected+"'");
			

			
		}
		
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();	

		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception caught in ClinicalCalcFormulaIntermediate.jsp " + e);//COMMON-ICN-0181

	}
	finally 
	{
			
		ConnectionManager.returnConnection(con,request);
	}
	%>
