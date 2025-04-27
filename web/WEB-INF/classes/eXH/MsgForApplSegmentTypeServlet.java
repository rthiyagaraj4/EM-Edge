/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.lang.reflect.Method;
import java.net.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.XHDBAdapter;
import eXH.ArrayAuditInfo;
import eXH.XHTYPE;

/**
 * Class used to update messagetype  for application segment types
 */
public class MsgForApplSegmentTypeServlet extends HttpServlet
{
	HttpServletRequest req=null;
	
	/**
	 * Do post method which implements the functionalities for messagetype  for application segment types
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{
		PrintWriter out;
		out=response.getWriter();
		req=request;		
			
		HttpSession session=request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
        String locale  = p.getProperty("LOCALE");
		locale	= "en";

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

		ResultSet rs1=null;
		Statement stmt1=null;
		Connection con=null;
		String event_type=request.getParameter("event_type");
		String appl_id=request.getParameter("appl_id");
		String standard_code = XHDBAdapter.checkNull(request.getParameter("stnd_code"));
	//	String status = XHDBAdapter.checkNull(request.getParameter("status"));
		String segment_type="";
		String optional_yn="";
		String in_use_yn="";
		String profile_id="";
		String in_use_yn1 = "";
		String profile_id1="";
		ArrayList arrMultiple=new ArrayList();
		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		try
		{
			con=ConnectionManager.getConnection();
			String sql1="";
//			System.out.println("MsgForApplSegmentTypeServlet Status "+status);		

			sql1="SELECT C.SEGMENT_TYPE, C.SEGMENT_NAME,NVL(D.OPTIONAL_YN ,'N') , NVL(D.IN_USE_YN ,'N') , NVL(C.OPTIONAL_YN ,'N')  	 MASTER_OPTIONAL_YN, D.PROFILE_ID,/*E.SHORT_DESC,C.STANDARD_DESC,*/C.EVENT_TYPE,/* C.STANDARD_CODE,C.SEGMENT_SEQ,*/'B' STATUS    FROM  XH_APPL_EVENT_SEGMENT  D, XH_STANDARD_PROFILE E,   (SELECT   '"+appl_id+"' APPLICATION_ID,	B.EVENT_TYPE EVENT_TYPE, B.SEGMENT_TYPE SEGMENT_TYPE, A.SEGMENT_NAME   SEGMENT_NAME, B.OPTIONAL_YN OPTIONAL_YN,	A.STANDARD_CODE STANDARD_CODE,F.STANDARD_DESC STANDARD_DESC,B.SEGMENT_SEQ	  FROM XH_SEGMENT_LANG_VW A,			XH_EVENT_TYPE_SEGMENT B,XH_STANDARD F WHERE   B.IN_USE_YN ='Y'	   AND  DECODE(B.EVENT_TYPE,NULL,'XX',				B.EVENT_TYPE) = NVL('"+event_type+"' ,DECODE(B.EVENT_TYPE,NULL,'XX',	   B.EVENT_TYPE))  	 AND B.SEGMENT_TYPE=A.SEGMENT_TYPE  AND A.STANDARD_CODE=F.STANDARD_CODE(+) AND	DECODE(A.STANDARD_CODE,NULL,'XX',	A.STANDARD_CODE) = NVL('"+standard_code+"',DECODE(A.STANDARD_CODE,NULL,'XX',A.STANDARD_CODE))	 AND  A.LANGUAGE_ID='"+locale+"') C   WHERE C.APPLICATION_ID  = D.APPLICATION_ID 	AND   C.SEGMENT_TYPE = D.SEGMENT_TYPE(+) AND		 C.EVENT_TYPE=D.EVENT_TYPE(+)			AND  D.PROFILE_ID=E.PROFILE_ID(+) 	   	   UNION       SELECT   B.SEGMENT_TYPE ,A.SEGMENT_NAME, 'Y' OPTIONAL_YN,'N' IN_USE_YN,  NVL(B.OPTIONAL_YN ,'N')  MASTER_OPTIONAL_YN,'' PROFILE_ID,/*''					   SHORT_DESC,F.STANDARD_DESC STANDARD_DESC,*/B.EVENT_TYPE EVENT_TYPE,/*A.STANDARD_CODE STANDARD_CODE,   B.SEGMENT_SEQ,*/'G' STATUS	 	  FROM XH_SEGMENT_LANG_VW A,XH_EVENT_TYPE_SEGMENT B,XH_STANDARD F  WHERE  		  	   B.IN_USE_YN ='Y'	   AND  DECODE(B.EVENT_TYPE,NULL,'XX',	B.EVENT_TYPE) =		NVL('"+event_type+"',DECODE(B.EVENT_TYPE,NULL,'XX',	   B.EVENT_TYPE))  		  AND B.SEGMENT_TYPE=A.SEGMENT_TYPE  		AND A.STANDARD_CODE=F.STANDARD_CODE(+) AND DECODE(A.STANDARD_CODE,NULL,'XX',		A.STANDARD_CODE) = 			NVL('"+standard_code+"',DECODE(A.STANDARD_CODE,NULL,'XX',A.STANDARD_CODE))	AND A.LANGUAGE_ID='"+locale+"'			AND (B.SEGMENT_TYPE,B.EVENT_TYPE) NOT IN (SELECT SEGMENT_TYPE,EVENT_TYPE FROM XH_APPL_EVENT_SEGMENT 	WHERE APPLICATION_ID=  '"+appl_id+"'   	AND EVENT_TYPE=NVL('"+event_type+"',EVENT_TYPE) ) ORDER BY 7,1 ";

//			System.out.println("MsgForApplSegmentTypeServlet Sql : "+sql1);
			
			stmt1=con.createStatement();
			rs1=stmt1.executeQuery(sql1);
			while(rs1.next())
			{
				arrColumn=new ArrayList();			
						
				segment_type=rs1.getString(1);		
				event_type = XHDBAdapter.checkNull((String)rs1.getString(7));
				profile_id1 = XHDBAdapter.checkNull((String)rs1.getString(6));			
				in_use_yn1 = rs1.getString(4);		
	//					System.out.println("in_use_yn1 rs : "+in_use_yn1);
	//					System.out.println("segment_type : "+segment_type);
    //			in_use_yn=XHDBAdapter.checkNullForCheckBox(request.getParameter(segment_type+"_in_use_yn"));
				in_use_yn=XHDBAdapter.checkNullForCheckBox(request.getParameter(segment_type+"_"+event_type+"_in_use_yn"));
	//					System.out.println("in_use : "+request.getParameter(segment_type+"_"+event_type+"_in_use_yn"));		
	//					System.out.println("GUI _in_use_yn gui :"+in_use_yn);
                 profile_id = 	 XHDBAdapter.checkNull(request.getParameter(segment_type+"_"+event_type+"_profile_id"));
				if(in_use_yn1.equals(in_use_yn) && profile_id1.equals(profile_id))
				{

				}
				else
				{ 
	//			if(in_use_yn.equals("Y")){
					optional_yn=rs1.getString(5);
	//				profile_id = 	 XHDBAdapter.checkNull(request.getParameter(segment_type+"_profile_id"));
					profile_id = 	 XHDBAdapter.checkNull(request.getParameter(segment_type+"_"+event_type+"_profile_id"));
	//				 System.out.println("profile_id : "+profile_id);

					arrColumn.add(appl_id);
					arrColumn.add(event_type);
					arrColumn.add(segment_type);
					arrColumn.add(optional_yn);
					arrColumn.add(in_use_yn);
					arrColumn.add(profile_id);				
					arrMultiple.add(arrColumn);
				} // insert only the selected records

			} // end of rs.next

		}catch(Exception e)
		{
			out.println("Error in dopost method of MsgForApplSegmentTypeServlet :"+e.toString());
			e.printStackTrace(System.err);
		}

		 finally
		{
			 try
			{
				if(rs1!=null)rs1.close();	
				if(stmt1!=null)stmt1.close();
				con.close();
			 }catch(Exception e)
			 {
					out.println("Error in closing statement of dopost method of MsgForApplSegmentTypeServlet :"+e.toString());
					e.printStackTrace(System.err);
			}
		}
	
		array_audit=new ArrayList();
		array_audit = ArrayAuditInfo.getArrayAuditInfo(session);

		HashMap details_hm= new HashMap();
		details_hm.put("row_details",arrMultiple);
		details_hm.put("gen_details",array_audit);
		
		HashMap result_hm=new HashMap();
		result_hm=callEJB(details_hm,locale );
		
		RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
		reqDis.forward(request,response);		
	}// end of do post

   /**
	 * callEJB method is used to call messagetype  for application segment types related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */
	public HashMap callEJB(HashMap details_hm,String locale)
   {    
	Connection connection = null;
	CallableStatement ostmt = null;
	String message_text2 = "";
	
	String status="";
	String exceptions="";
	HashMap result_hm=new HashMap();
	MessageManager mm=new MessageManager();

	ArrayList row_arr = (ArrayList) details_hm.get("row_details");
	ArrayList gen_arr = (ArrayList) details_hm.get("gen_details");
	
	  
    try
	{
		connection = ConnectionManager.getConnection();
      }
      catch(Exception exp)
      {

		 System.out.println("Error in calling getconnection method in callejb methosd of MsgForApplSegmentTypeServlet :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }
     
	ArrayList arrRow = null;
//	System.out.println("row_arr.size() : "+row_arr.size());
	
	for (int j=0;j<row_arr.size();j++)
	{
		arrRow = (ArrayList)row_arr.get(j);
	       try
	      {
		
		 status=status+"***"+arrRow;
		 ostmt = connection.prepareCall("{ call xhmast.segment_for_application(?,?,?,?,?,?,?,?,?,?) }" ); 

		  String  appln_id=(String)arrRow.get(0);
		  String  event_type=(String)arrRow.get(1);
   	      String  segment_type=(String)arrRow.get(2);
		  String  option_yn=(String)arrRow.get(3);
		  String  in_use_type=(String)arrRow.get(4);
		  String  prfl_id = (String)arrRow.get(5);
	//		System.out.println("prfl_id : "+prfl_id);

		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);

		 ostmt.setString(1,appln_id);
		 ostmt.setString(2,event_type);
		 ostmt.setString(3,segment_type);
		 ostmt.setString(4,option_yn);
		 ostmt.setString(5,in_use_type);
	 	 ostmt.setString(6,prfl_id);
		  
		 ostmt.setString(7,usr_added_by_id);
		 ostmt.setString(8,usr_added_at_ws_no);

		 ostmt.registerOutParameter(9,java.sql.Types.VARCHAR);
		 ostmt.registerOutParameter(10,java.sql.Types.VARCHAR);
		 ostmt.execute();
		
	     String status2 = 	ostmt.getString(9);	
	// 		 System.out.println("status2 : "+status2);
		 message_text2 = ostmt.getString(10);	
	//		 System.out.println("message_text2 : "+message_text2);
		 if(status2.equals("0"))
		 {
			 connection.commit();
//			 final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
 			 final java.util.Hashtable mesg = mm.getMessage(connection, "XH1001") ;
		     status = ((String) mesg.get("message"));
		 }
		 else
		  {   
			 connection.rollback();
//			  final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
  			  final java.util.Hashtable mesg = mm.getMessage(connection, "XH1000") ;
			 status = ((String) mesg.get("message"));
		
		  }
		 ostmt.close();
		 
	       }
	      catch(Exception ex)
	      {
			  System.out.println("Error inc alling dbrealted statements in callejb method of MsgForApplSegmentTypeServlet :"+ex.toString());
		      ex.printStackTrace(System.err);
			  exceptions=exceptions+"4"+"*"+ex.toString();
		
	      }
	}
	 try
	{
			ConnectionManager.returnConnection(connection);
	}catch(Exception ex)
	{
				 System.out.println("Error in calling closing dbconnection in callejb method of MsgForApplSegmentTypeServlet :"+ex.toString());
				ex.printStackTrace(System.err);
	 }			
	//	status=message_text2;
		result_hm.put("exceptions",exceptions);
		result_hm.put("status",status);
		return result_hm;  
  }// end of callEJB
	
}// end of class
