<!DOCTYPE html>

<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRs
*	Purpose 		:	
*	Created By		:	SreeLatha
*	Created On		:	10 Jan 2005

--%>

<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	String flag=request.getParameter("flag")==null?"":request.getParameter("flag");

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;
	PreparedStatement pstmt1 = null;
	ResultSet rset1=null;

	con = ConnectionManager.getConnection(request);

	String sql="";
	String code="";
	String desc="";
	String comp=" ";
	String location_type="";
	String workplace_code="";
	String facility_id="";


	if(flag.equals("1"))
	{
    workplace_code=request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
    facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");

	try{	
			sql = "select locn_type from rs_workplace where workplace_code=? and  facility_id=?";
			comp="parent.frames[1].frames[0].document.forms[0].location_code";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,workplace_code);
			pstmt.setString(2,facility_id);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
			location_type=rset.getString("locn_type")==null?"":rset.getString("locn_type");
			}
			
			if(pstmt != null)
				pstmt.close();
			if(rset != null)
				rset.close();


			sql="SELECT locn_type,long_desc FROM am_care_locn_type_lang_vw  WHERE  (? IS NULL OR locn_type =?) and language_id like ?";
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setString(1,location_type);
			pstmt1.setString(2,location_type);
			pstmt1.setString(3,locale);
			rset1= pstmt1.executeQuery();
			while(rset1.next()){
				code=rset1.getString("locn_type");
				desc=rset1.getString("long_desc");
				
		
%>
				 <script>
					var temp = "<%=code%>";
					var temp1="<%=desc%>";
					var opt=parent.frames[1].frames[0].document.createElement("OPTION");
					opt.text=temp1;
					opt.value=temp;
					var comp=<%=comp%>;
					comp.add(opt)
					parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp';
					
				</script> 
<%	
			}
			if(pstmt1 != null)
				pstmt1.close();
			if(rset1!= null)
				rset1.close();
		}
		catch (Exception e){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			if (pstmt != null) pstmt.close();
			if (pstmt1 != null) pstmt1.close();
			if (rset != null) rset.close();
			if (rset1 != null) rset1.close();
			if(con != null)
				
			ConnectionManager.returnConnection(con,request);
		}
	}
%>
<html>
