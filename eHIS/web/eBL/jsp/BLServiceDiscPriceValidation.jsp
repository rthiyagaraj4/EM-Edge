<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,  webbeans.eBL.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,java.io.*,java.util.*,eBL.Common.*,com.ehis.util.*,eBL.*,eMR.*" %>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="eBL.BlServiceDiscPriceBean"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
Connection con = null;
CallableStatement cstmt = null;
CallableStatement cstmt1 = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
boolean inserted = true;
String functionMode = "";
	
	try 
	{
		con = ConnectionManager.getConnection();
		functionMode = request.getParameter("functionMode");
		if (null == functionMode) {
			functionMode = "";
		}

		if("patientCategory".equals(functionMode)){			
			String patientCategory="";				
			try
			{				
				String billing_class=request.getParameter("billing_class");
				String category =	"select NVL(PATIENT_CATEGORY_CODE,'') from BL_BLNG_CLASS where BLNG_CLASS_CODE=?";
				pstmt = con.prepareStatement(category);
				pstmt.setString(1,billing_class);
				
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					patientCategory	= rs.getString(1);
				}
				System.err.println("patientCategory====>"+patientCategory);
				if(pstmt!=null)  pstmt.close();
				if(rs!=null)  rs.close();		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			out.println(patientCategory);					
		} 
		else if("chkMMItemServYN".equals(functionMode)){			
			String isServMatItemYN="N";				
			try
			{			
				String servCode=request.getParameter("servCode");
				String servInd=request.getParameter("servInd");
				
				//Changes done for MMS-KH-SCF-0187 by Manivel N
				/* String sql = "select NVL(MM_ITEM_SERV_YN,'N') MM_ITEM_SERV_YN  from bl_blng_serv where blng_serv_code='" + servCode + "'";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					isServMatItemYN = rs.getString("MM_ITEM_SERV_YN");			
				}	
				System.err.println("isServMatItemYN====>"+isServMatItemYN);
				if(pstmt!=null)  pstmt.close();
				if(rs!=null)  rs.close();*/
				
				BlServiceDiscPriceBean callingObj = new BlServiceDiscPriceBean();
				isServMatItemYN = callingObj.isServMatBased(servCode,servInd);
				System.err.println("isServMatItemYN====>"+isServMatItemYN);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
			out.println(isServMatItemYN);					
		}
		else if("isServiceChargeBasedYN".equals(functionMode)){
			String isServiceChargeBasedYN = "N";
			String rateChargeFlag="N";
			String materialItemYN="";

		try {
				String servCode=request.getParameter("servCode");
				pstmt = con.prepareStatement("select RATE_ENTRY_BY_USER_FLAG, MM_ITEM_SERV_YN from bl_blng_serv where blng_serv_code=? ");
				pstmt.setString(1, servCode);

				rs = pstmt.executeQuery();
				
				if (rs != null && rs.next()) {
					rateChargeFlag = (String) rs.getString("RATE_ENTRY_BY_USER_FLAG");
					materialItemYN = (String) rs.getString("MM_ITEM_SERV_YN");
					System.err.println("107===>"+materialItemYN);
				}
				System.err.println("85====>servCode===>"+servCode);
				System.err.println("rateChargeFlag===>"+rateChargeFlag);
				if(rateChargeFlag.equals("C")){
					isServiceChargeBasedYN="Y";
					System.err.println("isServiceChargeBasedYN===>"+isServiceChargeBasedYN);
				}
				if(pstmt!=null)  pstmt.close();
				if(rs!=null)  rs.close();				
	
		}catch(Exception e)
			{
				e.printStackTrace();
			}	
			out.println(isServiceChargeBasedYN);					
		}
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg from generatecolrpt.jsp "+e);
		con.rollback();
	}
	finally{
		ConnectionManager.returnConnection(con,request);
	} 
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
