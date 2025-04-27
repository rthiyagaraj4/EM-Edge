
<%@page import="eBL.Common.BlRepository"%>
<%@ page   import="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %> 
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%

String errorFlag =null;
	Connection con = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt= null ;
	ResultSet rst = null;
	System.err.println("1");
	String locale = (String)session.getAttribute("LOCALE"); 
	try{
		System.out.println("inside cancel package jsp");
		con = ConnectionManager.getConnection();
		con.setAutoCommit(false);
		
		
		    String facilityId = request.getParameter("facilityId");
		    System.out.println("TOTAL ROWS"+request.getParameter("facilityId")+"<<<");
		    System.out.println("TOTAL ROWS"+request.getParameter("totalRows")+"<<<");
		    String strTotalRows=request.getParameter("totalRows");
		    int totalRows = Integer.parseInt(strTotalRows);
		    
		    String docTypeCode = null;
			int docNum = 0;
			//String detailRepYn = request.getParameter("detailRepYn");
			
			for(int i=1;i<=totalRows;i++) {
				docTypeCode = request.getParameter("billdocType"+i);
				System.out.println("docTypeCode"+docTypeCode+"<<<");
				docNum = Integer.parseInt(request.getParameter("billdocNum"+i));
				System.out.println("docNum"+docNum+"<<<");
				cstmt = con.prepareCall("{call IBAEHIS.bl_cancel_bill_proc.bl_pkg_reopen_chk(?,?,?,?)}");
				cstmt.setString(1, facilityId);							
				cstmt.setString (2,  docTypeCode);
				cstmt.setInt(3, docNum);
				
				cstmt.registerOutParameter(4, Types.VARCHAR);
				
				cstmt.execute();
				errorFlag  = cstmt.getString(4).toString();
				if(errorFlag=="Y") {
					break;
				}
			}
			out.println(errorFlag);
			System.out.println("END cancel package jsp"+errorFlag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
%>
