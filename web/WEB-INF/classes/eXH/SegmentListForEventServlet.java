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
 * Class used to update the segment list for event values setup
 *
 */
public class SegmentListForEventServlet extends HttpServlet
{
	HttpServletRequest req=null;
	/**
	 * Do post method which implements the functionalities for segment list for event upadtion
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
		locale = "en";

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

		ResultSet rs1=null;
		Statement stmt1=null;
		Connection con=null;
		String segment_type="";
		String seg_select_yn = "";
		String event_type=XHDBAdapter.checkNull(request.getParameter("event_type"));
		String stnd_code=XHDBAdapter.checkNull(request.getParameter("stnd_code"));		

		ArrayList arrMultiple=new ArrayList();
		ArrayList arrColumn=null;
		ArrayList array_audit=null;
		try
		{

			con=ConnectionManager.getConnection();

//			String sql1="SELECT a.SEGMENT_TYPE,b.SEGMENT_NAME,a.OPTIONAL_YN,a.IN_USE_YN FROM XH_EVENT_TYPE_SEGMENT a,XH_SEGMENT b WHERE a.EVENT_TYPE='"+event_type+"' AND a.SEGMENT_TYPE=b.SEGMENT_TYPE AND b.IN_USE_YN='Y'  AND a.OPTIONAL_YN='Y' ORDER BY a.SEGMENT_SEQ" ;

			String sql1="	SELECT  DISTINCT * FROM (SELECT a.SEGMENT_TYPE,b.SEGMENT_NAME,a.OPTIONAL_YN,a.IN_USE_YN FROM XH_EVENT_TYPE_SEGMENT a,XH_SEGMENT_LANG_VW b  WHERE  DECODE(a.EVENT_TYPE,NULL,'XX',a.EVENT_TYPE) = 	 	 NVL('"+event_type+"' ,DECODE(a.EVENT_TYPE,NULL,'XX', a.EVENT_TYPE)) AND DECODE(B.STANDARD_CODE,NULL,'XX', B.STANDARD_CODE) = NVL('"+stnd_code+"' ,DECODE(B.STANDARD_CODE,NULL,'XX',B.STANDARD_CODE)) AND a.SEGMENT_TYPE=b.SEGMENT_TYPE AND b.IN_USE_YN='Y' AND b.LANGUAGE_ID='"+locale+"'  ORDER BY a.SEGMENT_seq)";

			stmt1=con.createStatement();
			rs1=stmt1.executeQuery(sql1);
			while(rs1.next())
			{
				segment_type=rs1.getString(1);

				arrColumn=new ArrayList();
				arrColumn.add(segment_type);
				arrColumn.add(event_type);
//					System.out.println("GUI bef in_use_yn : "+request.getParameter(segment_type+"_select_yn"));
				
				if( (rs1.getString(3).equals("N")) && (rs1.getString(4).equals("Y")) ){
					seg_select_yn = "Y";
//					System.out.println("dtbs Val seg_select_yn : "+seg_select_yn);
				}
                else {
				    seg_select_yn = request.getParameter(segment_type+"_select_yn");
					if((seg_select_yn == null)||(seg_select_yn.equals(""))||(seg_select_yn.equals("null"))||(seg_select_yn.equals(" "))){
						seg_select_yn = "N";
					}
					else if((seg_select_yn.equals("on"))){
						seg_select_yn = "Y";
					}
				}

//					System.out.println("SegmentListForEventServlet.java seg_select_yn : "+seg_select_yn);
//	           	arrColumn.add(XHDBAdapter.checkNullForCheckBox(request.getParameter(segment_type+"_select_yn")));
	           	arrColumn.add(seg_select_yn);
				arrMultiple.add(arrColumn);
				

			}
		}catch(Exception e)
		{
			 System.out.println("Error in dopost method of segmentlistforeventservlet :"+e.toString());
			e.printStackTrace(System.err);
		}

 finally{
	 try{
	if(rs1!=null)rs1.close();	
	 if(stmt1!=null)stmt1.close();	
	 con.close();
	 }catch(Exception e){
	  	     System.out.println("Error in closing statement of dopost method of segmentlistforeventservlet :"+e.toString());
			e.printStackTrace(System.err);
	 }
		}
	
	array_audit=new ArrayList();
	array_audit = ArrayAuditInfo.getArrayAuditInfo(session);

	HashMap details_hm= new HashMap();
	details_hm.put("row_details",arrMultiple);
	details_hm.put("gen_details",array_audit);

	// now calling function  callEJB

	HashMap result_hm=new HashMap();
	result_hm=callEJB(details_hm,locale);
	
	RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));
    reqDis.forward(request,response);		



	}// end of do post
    
	/**
	 * callEJB method is used to call segment list for event type related database procedures
	 * @param  HashMap details_hm
	 * @param  String locale
	 */

	public HashMap callEJB(HashMap details_hm, String locale)
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

		 System.out.println("Error in calling getconnection method in callejb method of segmentlistforeventservlet :"+exp.toString());
		exp.printStackTrace(System.err);
		exceptions=exceptions+"1"+"*"+exp.toString();
        
      }

	
     
	ArrayList arrRow = null;

	for (int j=0;j<row_arr.size();j++)
	{
		arrRow = (ArrayList)row_arr.get(j);
	       try
	      {
		
		 status=status+"***"+arrRow;
		 ostmt = connection.prepareCall("{ call xhmast.event_type_segment(?,?,?,?,?,?,?) }" ); 
		  
		 
		  String  segment_type=(String)arrRow.get(0);
		  String  event_type=(String)arrRow.get(1);
		  String  in_use_type=(String)arrRow.get(2);

		  String  usr_added_by_id=(String)gen_arr.get(0);
		  String  usr_added_at_ws_no=(String)gen_arr.get(1);
		  //String  s1=(String)gen_arr.get(2);
		 
		  
		 ostmt.setString(1,segment_type);
		 ostmt.setString(2,event_type);
		 ostmt.setString(3,in_use_type);
		  
		 ostmt.setString(4,usr_added_by_id);
		 ostmt.setString(5,usr_added_at_ws_no);
		 
		 ostmt.registerOutParameter(6,java.sql.Types.VARCHAR);
		 ostmt.registerOutParameter(7,java.sql.Types.VARCHAR);
		 ostmt.execute();
		 
		 message_text2=ostmt.getString(6);
		 if(message_text2.equals("0"))
		 {
			connection.commit();
	//		final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
			final java.util.Hashtable mesg = mm.getMessage(connection, "XH1001") ;
  	        message_text2 = ((String) mesg.get("message"));
		 }
		 else
		 {
			 connection.rollback();
	//		final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
 			final java.util.Hashtable mesg = mm.getMessage(connection, "XH1001") ;
			 message_text2 = ((String) mesg.get("message"));
		 }
		 //message_text2 = message_text2+ostmt.getString(7);
		 ostmt.close();
		 
	       }
	      catch(Exception ex)
	      {
			   System.out.println("Error in callinfg dbrealted statements in callejb method of SegmentListForEventServlet.java :"+ex.toString());
		      ex.printStackTrace(System.err);
			  exceptions=exceptions+"2"+"*"+ex.toString();
		
	      }
	}
	try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){
		      System.out.println("Error in calling closing dbconnection in callejb method of SegmentListForEventServlet.java:"+ex.toString());
		     ex.printStackTrace(System.err);
	}
	    
	status=message_text2;
	result_hm.put("exceptions",exceptions);
	result_hm.put("status",status);
	return result_hm;  
}// end of function
	

}// end of class
