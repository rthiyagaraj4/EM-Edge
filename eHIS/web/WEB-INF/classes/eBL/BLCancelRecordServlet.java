
/*
Sr No        Version           TFS/Incident        SCF/CRF            		 			Developer Name
--------------------------------------------------------------------------------------------------------
1            V210129            13523         MOHE-CRF-0060       						Shikha Seth
--------------------------------------------------------------------------------------------------------
 */

package eBL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import webbeans.eCommon.ConnectionManager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import java.util.Locale;
import java.util.ArrayList;
import java.util.Iterator;
import ecis.utils.OnlineReports;
import ecis.utils.OnlineReport;
/**
 * Servlet implementation class BLCancelRecordServlet
 */
public class BLCancelRecordServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	java.util.Properties prop;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLCancelRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    Connection con= null;
	    CallableStatement cstmt = null;
	    PrintWriter out = null;
	    List<BLCancelBillBean> cancelList = new ArrayList<BLCancelBillBean>();
	  
	    ResourceBundle rb = null;
	    ResourceBundle rb1 = null;
	   // ResourceBundle rb2 = null;
	    String lastRowIndex = request.getParameter("lastRowIndex");
//	    String mode = request.getParameter("mode");
	    int lastRow = Integer.parseInt(lastRowIndex);
	    
//	    String facilityId = request.getParameter("facilityId");
	    BLCancelBillBean blCancelBillBean = null;
	    
		String docTypeCode =  request.getParameter("docTypeCode");
		String login_user =  request.getParameter("login_user");
		System.out.println("login_user="+login_user);
		//String docNum =  request.getParameter("docNum");
	//	String episodeType =  request.getParameter("episodeType");
		String cancelReasonCode= request.getParameter("cancel_reason_code"); //TO DO
		//String txnTypeCode =  request.getParameter("txnTypeCode");
		
		HttpSession session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String facilityId = (String) session.getValue( "facility_id" ) ;
		//String login_user = this.prop.getProperty( "login_user" ) ;
		String client_ip_address = this.prop.getProperty("client_ip_address") ;
		//String operating_facility_id = request.getParameter("facility_id"); //V210129
		boolean successFlag=true;
		String errorId=null;
		int errorLevel=0;
		String errorText=null;
		String value="";
		//HashMap returnMap = new HashMap();
		String pgm_id=null;
		String session_id=null;
		String pgm_date=null;
		String errorMsg = "";
	//	String errorMsgSucc="";
		String docNum="";
		int errorCount=0;
		//System.out.println("Inside doPost");
		
		con = ConnectionManager.getConnection(request);
		 out = response.getWriter();
		 BLCancelBillBean bean=null;
		 bean=new BLCancelBillBean();
		try {
			String locale = (String)session.getAttribute("LOCALE");
			Locale loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			rb1 = ResourceBundle.getBundle("eSM.resources.Messages",loc);
//			cstmt = con.prepareCall("{call IBAEHIS.BL_CANCEL_BIL_VALIDATION_CHECK(?,?,?,?,?,?)}");
			
			
			for(int i=1;i<=lastRow;i++)
			{			
				 docNum = request.getParameter("doc_num"+i);				
				if(docNum != null && !"".equals(docNum))
				{			
				
				bean.setDocTypeCode(request.getParameter("doc_typ_code"+i));
				bean.setDocNum(request.getParameter("doc_num"+i));
				bean.setEpisodeType(request.getParameter("episode_type"+i));
				bean.setFacilityId(request.getParameter("facility_id"+i)); //V210129
				cancelList.add(bean);
				}	  
			}
				for (Iterator iterator = cancelList.iterator(); iterator.hasNext();)
				{   
					if(errorCount==10) break;							
					blCancelBillBean = (BLCancelBillBean) iterator.next();
					blCancelBillBean.getDocTypeCode();
					blCancelBillBean.getDocNum();
					blCancelBillBean.getEpisodeType();
					blCancelBillBean.getFacilityId();//V210129
		              value=value+blCancelBillBean.getDocTypeCode()+"/"+blCancelBillBean.getDocNum()+"|";
	
					cstmt = con.prepareCall("{call IBAEHIS.bl_cancel_bill_proc.bl_bill_cancel(?,?,?,?,?,?,?,?,?,?)}");
//					cstmt.setString(1,facilityId); //V210129 Commented
					cstmt.setString(1,blCancelBillBean.getFacilityId()); //V210129 Added
					cstmt.setString(2,blCancelBillBean.getDocTypeCode());					
					cstmt.setString(3,blCancelBillBean.getDocNum());
					cstmt.setString(4,blCancelBillBean.getEpisodeType());
					cstmt.setString(5,login_user);
					cstmt.setString(6,client_ip_address);
					cstmt.setString(7,cancelReasonCode);
					cstmt.registerOutParameter(8, Types.VARCHAR);
					cstmt.registerOutParameter(9, Types.NUMERIC);
					cstmt.registerOutParameter(10,Types.VARCHAR);					
					cstmt.execute();
					errorId = cstmt.getString(8);
					errorLevel = cstmt.getInt(9);
					errorText = cstmt.getString(10);
									
					if(errorId==null) errorId="";	
		
					if(errorText==null) errorText="";
				
					if (errorId != "" || errorText != "" || errorLevel != 0) {				
						successFlag=false;
						docTypeCode=blCancelBillBean.getDocTypeCode();
						docNum=blCancelBillBean.getDocNum();
						if(errorMsg.equals("")){
							errorMsg =docTypeCode+"/"+docNum+":"+errorText+":"+rb.getString(errorId);
						}else {
						errorMsg =errorMsg+docTypeCode+"/"+docNum+":"+errorText+":"+rb.getString(errorId);						
						}
					}
				if(errorId=="" && errorText!=""){
				if(errorMsg.equals("")){
				errorMsg =docTypeCode+"/"+docNum+":"+errorText;
				}
				else
				{
				errorMsg =errorMsg+docTypeCode+"/"+docNum+":"+errorId+":"+errorText;
									
				}
				
				}
				if (errorId != "" || errorText != "" || errorLevel != 0) {
				errorMsg =errorMsg+"<<";

				errorCount++;
				System.out.println("errorMsg"+errorCount);
				}
				
			cstmt.close();
			}	
					if(successFlag) {
		
				con.commit();
				try{
					
					rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
					rb1 = ResourceBundle.getBundle("eSM.resources.Messages",loc);
																		
				//	con = ConnectionManager.getConnection(request);
									cstmt = con.prepareCall("{call IBAEHIS.bl_cancel_bill_proc.bl_bil_cancel_print (?,?,?,?,?,?,?,?,?)}");
									//params=
									cstmt.setString(1,facilityId);
								
									cstmt.setString(2,blCancelBillBean.getEpisodeType());
									
									cstmt.setString(3,value);
									
								
									cstmt.setString(4, client_ip_address);
								
									
									cstmt.registerOutParameter(5, Types.VARCHAR);
									//pgm_id=cstmt.getString(7);
									cstmt.registerOutParameter(6, Types.VARCHAR);
									//session_id=cstmt.getString(7);
									cstmt.registerOutParameter(7, Types.VARCHAR);
									//pgm_date=cstmt.getString(7);
									cstmt.registerOutParameter(8, Types.VARCHAR);
									
									cstmt.registerOutParameter(9, Types.VARCHAR);
									
									cstmt.execute();
									//episodeType=cstmt.getString(2);
									pgm_id=cstmt.getString(5);
									session_id=cstmt.getString(6);
									pgm_date=cstmt.getString(7);
									errorId = cstmt.getString(8);
									errorText = cstmt.getString(9);
								
								System.out.println("after procedure call");
								System.out.println(pgm_id);
								if(errorId==null) errorId="";	

								if(errorText==null) errorText="";
								
								if (errorId.equals("") && errorText.equals("") && errorLevel == 0) {
									//successFlag=true;
									con.commit();
									out.println("Y"+":::"+pgm_id+":::"+session_id+":::"+pgm_date);
									//errorMsgSucc = "Y"+":::"+pgm_id+":::"+session_id+":::"+pgm_date;
								//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( "APP-SM0070 Operation Completed Successfully ....","UTF-8" ) +"&err_value="+"1");								
								}
								else {									
									con.rollback();									
								}																		
								cstmt.close();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					finally{
						if(cstmt != null)
            try {
                cstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
			//cstmt = null;
			
		}
		
			}
			else {
			//	successFlag = false;
			//out.println("N"+":::"+errorId+":::"+errorText+":::"+errorLevel);
				System.out.println("rollback"+errorMsg);
				con.rollback();
				out.println("N"+":::"+errorMsg);	
			
				
			}
			
			
				
							
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			finally{
				if(cstmt != null)
            try {
                cstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
			ConnectionManager.returnConnection(con);
		}
		

			}
	
}
