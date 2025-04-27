package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.BLCashChequeHandOverBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blcashchequehandovervalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/ebl/jsp/BLCashChequeHandoverValidation.jsp", 1742749574003L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

Connection con = null;
try {
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection();	
	PreparedStatement pstmt = null;
	ResultSet rs = null;ResultSet rs1=null;//ResultSet rs_pkd=null;	
	String locale			= (String)session.getAttribute("LOCALE");
	String facilityId		= (String) session.getValue( "facility_id" ) ;
	String loginUser =  p.getProperty("login_user");		
	CurrencyFormat cf = new CurrencyFormat();
	Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash						= (Hashtable)hash.get( "SEARCH" ) ;
//	HashMap		labelsTmp				=	null;
	//int rec_count=0;
	String mode="";int noofdecimal=2;
	String str_noofdecimal="2";
	String cashCounterCode ="",strLoginTime="",strsysdate="",strCount="";//strsysdateDB="";
//	String strLoginTimeDB="";
		String 	cashInHand="",chequeInHand="",strErrorLevel="",strMessageId="",strErrorText="";
	String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;
	String func_mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode") ;
	
	String function_mode = "",cash_select="";


	 cashCounterCode		=	(String) hash.get( "cashCounterCode" );	 

	
	if(function_id!= null && function_id.equals("GET_DETAILS"))
	{  
		str_noofdecimal =(String) hash.get( "noofdecimal" );	
		noofdecimal = 	Integer.parseInt(str_noofdecimal);
		mode="insert";
			try
				{
					String sql1 = "	SELECT  to_char(LOGIN_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'), "+
					" to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') "+
					" FROM    BL_CASH_COUNTER_LANG_VW "+
					" WHERE  CASH_CTR_IN_USE_BY = ? "+
					" AND    OPERATING_FACILITY_ID   = ? "+
					" AND language_id='"+locale+"' AND CASH_COUNTER_CODE='"+cashCounterCode+"' ORDER BY 1 ";

					//System.out.println("sql1 c validatin"+sql1);
					pstmt = con.prepareStatement(sql1);
					pstmt.setString(1, loginUser);
					pstmt.setString(2, facilityId);					
					rs = pstmt.executeQuery() ;
					while(rs.next())
					{
						strLoginTime = rs.getString(1);						
						strsysdate = rs.getString(2);						
					}

					if(!(locale.equals("en"))){
						strLoginTime = com.ehis.util.DateUtils.convertDate(strLoginTime,"DMYHMS","en",locale);
						strsysdate = com.ehis.util.DateUtils.convertDate(strsysdate,"DMYHMS","en",locale);
					}

					rs.close();
					pstmt.close();
				}catch(Exception e)
				{
					out.println("Error cash ctr = "+e);
				}	
				
				try
				{	
					if(!(locale.equals("en"))){
						strLoginTime = com.ehis.util.DateUtils.convertDate(strLoginTime,"DMYHMS",locale,"en");
						//strsysdate = com.ehis.util.DateUtils.convertDate(strsysdate,"DMYHMS","en",locale);
					}
					String sql2 = "	SELECT 'X' FROM BL_HANDED_REQT  WHERE OPERATING_FACILITY_ID ='"+facilityId+"' AND CASH_COUNTER_CODE='"+cashCounterCode+"' AND LOGGEDIN_USER_ID = '"+loginUser+"' AND login_date_time = TO_DATE('"+strLoginTime+"','dd/mm/yyyy hh24:mi:ss')	AND STATUS = 'R' ";

					pstmt = con.prepareStatement(sql2);										
					
					rs1 = pstmt.executeQuery() ;
					while(rs1.next())
					{
						strCount = rs1.getString(1);						
											
					}

					rs1.close();
					pstmt.close();
				}catch(Exception e)
				{
					out.println("Error request chk cash ctr = "+e);
					System.out.println("Error request chk cash ctr :"+e);
				}		
				out.println("chkRequestYn('"+strCount+"');");
	 if(!(strCount.equals("X"))){	
		try
			{	
			if(!(locale.equals("en"))){
						//strLoginTime = com.ehis.util.DateUtils.convertDate(strLoginTime,"DMYHMS",locale,"en");
						strsysdate = com.ehis.util.DateUtils.convertDate(strsysdate,"DMYHMS",locale,"en");
					}
				CallableStatement callstmt = con.prepareCall("{ call bl_csh_chq_handover.proc_get_csh_chq_in_hand(?,?,?,to_date(?,'dd/mm/yyyy  hh24:mi:ss'),to_date(?,'dd/mm/yyyy  hh24:mi:ss'),?,?,?,?,?)}");
				callstmt.setString(1,facilityId);			
				callstmt.setString(2,cashCounterCode);			
				callstmt.setString(3,loginUser);			
				callstmt.setString(4,strLoginTime);			
				callstmt.setString(5,strsysdate);			
				callstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				callstmt.execute();			
		
				cashInHand = callstmt.getString(6);
				chequeInHand = callstmt.getString(7);
				strErrorLevel = callstmt.getString(8);
				strMessageId=callstmt.getString(9);			
				strErrorText=callstmt.getString(10);			
				
			
				if(cashInHand==null) cashInHand="0.00";
				if(chequeInHand==null) chequeInHand="0.00";
				if(strErrorLevel==null) strErrorLevel="";
				if(strMessageId==null) strMessageId="";
				if(strErrorText==null) strErrorText="";
				cashInHand = cf.formatCurrency(cashInHand, noofdecimal);
				chequeInHand = cf.formatCurrency(chequeInHand, noofdecimal);

		
		}catch(Exception e)
		{
			System.out.println("Exception @ HEADER package  :"+e);
		}
		//out.println("<script>parent.document.getElementById('loginDateTime').value='"+strLoginTime+"'</script>");
		

		strLoginTime = com.ehis.util.DateUtils.convertDate(strLoginTime,"DMYHMS","en",locale);
		strsysdate = com.ehis.util.DateUtils.convertDate(strsysdate,"DMYHMS","en",locale);
		
	out.println("calltodisplaydetails('"+strLoginTime+"','"+strsysdate+"','"+loginUser+"','"+cashInHand+"','"+chequeInHand+"','"+mode+"');");
	} 			
	}

	if(function_id!= null && function_id.equals("GET_DB_VALUES"))
	{
		String strCashCountrCode="",strInUseBy="",strLoginDate="",strReqDateTime="",strCashHandedOver="",strcheqHandedOver="";
		mode="modify";
		
			str_noofdecimal =(String) hash.get( "noofdecimal" );	
    		noofdecimal = 	Integer.parseInt(str_noofdecimal);
			strCount="";
			
try{

				String sql1 = "	SELECT CASH_COUNTER_CODE,LOGGEDIN_USER_ID, to_char(LOGIN_DATE_TIME,'DD/MM/YYYY hh24:mi:ss' ),to_char(REQUESTED_DATE_TIME,'DD/MM/YYYY hh24:mi:ss'),CASH_REQUEST_AMT,CHQ_REQUEST_AMT FROM bl_handed_reqt WHERE LOGIN_DATE_TIME=(SELECT LOGIN_DATE_TIME FROM   BL_CASH_COUNTER_SLMT_HDR WHERE  OPERATING_FACILITY_ID = '"+facilityId+"'	AND    CASH_COUNTER_USER_ID  = '"+loginUser+"' AND    LOGOUT_DATE_TIME     IS NULL) AND STATUS='R' ";
				pstmt = con.prepareStatement(sql1);
				//pstmt.setString(1, facility_id);
				//pstmt.setString(2, loginUser);
										
					rs = pstmt.executeQuery() ;
					while(rs.next())
					{
						strCashCountrCode = rs.getString(1);						
						strInUseBy = rs.getString(2);						
						strLoginDate = rs.getString(3);						
						strReqDateTime = rs.getString(4);						
						//strCashHandedOver = rs.getString(5);						
						//strcheqHandedOver = rs.getString(6);						
					}

					
					if(strCashCountrCode==null) strCashCountrCode="";
					if(strInUseBy==null) strInUseBy="";
					if(strLoginDate==null) strLoginDate="";
					if(strReqDateTime==null) strReqDateTime="";
				//	if(strCashHandedOver==null) strCashHandedOver="0.00";
				//	if(strcheqHandedOver==null) strcheqHandedOver="0.00";

				//	strCashHandedOver = cf.formatCurrency(strCashHandedOver, noofdecimal);
				//	strcheqHandedOver = cf.formatCurrency(strcheqHandedOver, noofdecimal);

					//strLoginDate = com.ehis.util.DateUtils.convertDate(strLoginDate,"DMYHMS","en",locale);
					//strReqDateTime = com.ehis.util.DateUtils.convertDate(strReqDateTime,"DMYHMS","en",locale);

					/*if(!(locale.equals("en"))){
						strLoginDate = com.ehis.util.DateUtils.convertDate(strLoginDate,"DMYHMS","en",locale);
						strReqDateTime = com.ehis.util.DateUtils.convertDate(strReqDateTime,"DMYHMS","en",locale);
					}
*/
					
					rs.close();
					pstmt.close();

					
										
						String sql2 = "	SELECT 'X' FROM BL_HANDED_REQT  WHERE OPERATING_FACILITY_ID ='"+facilityId+"' AND CASH_COUNTER_CODE='"+strCashCountrCode+"' AND LOGGEDIN_USER_ID = '"+strInUseBy+"' AND login_date_time = TO_DATE('"+strLoginDate+"','dd/mm/yyyy hh24:mi:ss')	AND STATUS = 'R' ";

						pstmt = con.prepareStatement(sql2);										
						
						rs1 = pstmt.executeQuery() ;
						while(rs1.next())
						{
							strCount = rs1.getString(1);						
												
						}

						rs1.close();
						pstmt.close();
					}catch(Exception e)
					{
						out.println("Error request chk GET ctr = "+e);
						System.out.println("Error request chk GET ctr :"+e);
					}		
				out.println("modifyRequestYn('"+strCount+"');");
 if(strCount.equals("X")){
	 	try{

			/*if(!(locale.equals("en"))){
						strLoginDate = com.ehis.util.DateUtils.convertDate(strLoginDate,"DMYHMS",locale,"en");
						strReqDateTime = com.ehis.util.DateUtils.convertDate(strReqDateTime,"DMYHMS",locale,"en");
					}*/
					cashInHand="";
					chequeInHand="";
					CallableStatement callstmt = con.prepareCall("{ call bl_csh_chq_handover.proc_get_csh_chq_in_hand(?,?,?,to_date(?,'dd/mm/yyyy  hh24:mi:ss'),to_date(?,'dd/mm/yyyy  hh24:mi:ss'),?,?,?,?,?)}");
						callstmt.setString(1,facilityId);			
						callstmt.setString(2,cashCounterCode);			
						callstmt.setString(3,loginUser);			
						callstmt.setString(4,strLoginDate);			
						callstmt.setString(5,strReqDateTime);			
						callstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
						callstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
						callstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						callstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						callstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
						callstmt.execute();			
				
						cashInHand = callstmt.getString(6);
						chequeInHand = callstmt.getString(7);
						strErrorLevel = callstmt.getString(8);
						strMessageId=callstmt.getString(9);			
						strErrorText=callstmt.getString(10);			
						
					
						if(cashInHand==null) cashInHand="0.00";
						if(chequeInHand==null) chequeInHand="0.00";
						if(strErrorLevel==null) strErrorLevel="";
						if(strMessageId==null) strMessageId="";
						if(strErrorText==null) strErrorText="";


						strCashHandedOver = cf.formatCurrency(cashInHand, noofdecimal);
						strcheqHandedOver = cf.formatCurrency(chequeInHand, noofdecimal);

		}catch(Exception e)
		{
			//out.println("Error cash ctr = "+e);
			e.printStackTrace();
		}
				
				//String bean_id		= "BLCashChequeHandOverBean";
				//String bean_name	= "eBL.BLCashChequeHandOverBean";
				//BLCashChequeHandOverBean bean			= (BLCashChequeHandOverBean)getBeanObject( bean_id, bean_name, request ) ;
			//	bean.setDBValues(strCashCountrCode,strInUseBy,strReqDateTime,locale,facilityId);//set database values to bean.

		
		strLoginDate = com.ehis.util.DateUtils.convertDate(strLoginDate,"DMYHMS","en",locale);
		strReqDateTime = com.ehis.util.DateUtils.convertDate(strReqDateTime,"DMYHMS","en",locale);

	out.println("calltodisplaydetails('"+strLoginDate+"','"+strReqDateTime+"','"+strInUseBy+"','"+strCashHandedOver+"','"+strcheqHandedOver+"','"+mode+"');");
	}
	}

	if(function_id!= null && function_id.equals("DUPLICATE_CHECK"))
	{  	
		//double totalAmount=0;
		ArrayList currDeno     = new ArrayList();
		int totRec		    = Integer.parseInt((String) hash.get( "total_records" ));
		int	index	    	= Integer.parseInt((String) hash.get( "index" ));	
		String item	= (String) hash.get( "item" );
		for(int i=0;i<totRec; i++)
		{
			if(i!=index)
			currDeno.add((String) hash.get( "code_"+i ));
		}
		
		if(currDeno.contains(item)){
			out.println("duplicateAlert('"+index+"')");		
		}
	
    } 
try{
	if(function_id!= null && function_id.equals("STORE_VALUES"))
	{  
		if(func_mode!= null && func_mode.equals("CASH_DTLS")){
			String bean_id		= "BLCashChequeHandOverBean";
			String bean_name	= "eBL.BLCashChequeHandOverBean";
			BLCashChequeHandOverBean bean			= (BLCashChequeHandOverBean)getBeanObject( bean_id, bean_name, request ) ;
			String	total_records		=	(String) hash.get( "totalRecordsCash" );
			function_mode               =	(String) hash.get( "mode" );  
			int totalRec				=	Integer.parseInt(total_records);
			ArrayList	curr_deno	    =	new ArrayList();
			ArrayList	curr_num	    =	new ArrayList();
			ArrayList	curr_amt	    =	new ArrayList();
			ArrayList	cash_colloction_details	    =	new ArrayList();
			HashMap cashCollectionDtlsMap    =   new HashMap();
			String temp="";String tot_cash_amt="";	
				for(int i=0;i<totalRec; i++)
					{
					temp =(String) hash.get( "currDeno_"+i );

						if(function_mode.equals("modify"))
						{
							cash_select  =	(String) hash.get( "cashSelect_"+i );  
							
							if(cash_select.equals("Y"))
							{
								if(!(temp.equals("")))
								{
								   curr_deno.add((String) hash.get( "currDeno_"+i ));
								   curr_num.add((String) hash.get( "currNumber_"+i ));
								   curr_amt.add((String) hash.get( "currAmt_"+i ));
								}
							}
						}else{						
							if(!(temp.equals("")))
								{
							   curr_deno.add((String) hash.get( "currDeno_"+i ));
							   curr_num.add((String) hash.get( "currNumber_"+i ));
							   curr_amt.add((String) hash.get( "currAmt_"+i ));
								}
						}
					}
					 cash_colloction_details.add( curr_deno );
					 cash_colloction_details.add( curr_num );
					 cash_colloction_details.add( curr_amt );

				 cashCollectionDtlsMap.put("CASH_COLL_DTLS",cash_colloction_details);
				 bean.setCashCollectionDtls(cashCollectionDtlsMap);

				 tot_cash_amt = (String) hash.get( "cash_total");

				bean.setTotCashAmt(tot_cash_amt);

		
		
		}
		if(func_mode!= null && func_mode.equals("CHEQ_DTLS")){
			String bean_id		= "BLCashChequeHandOverBean";
			String bean_name	= "eBL.BLCashChequeHandOverBean";
			BLCashChequeHandOverBean bean			= (BLCashChequeHandOverBean)getBeanObject( bean_id, bean_name, request ) ;
			String	total_records_chq		=	(String) hash.get( "totalRecordsChq" );
			int totalRec				=	Integer.parseInt(total_records_chq);
			ArrayList	chq_num			=	new ArrayList();
			ArrayList	chq_date		=	new ArrayList();
			ArrayList	bank_name	    =	new ArrayList();
			ArrayList	payer_name	    =	new ArrayList();
			ArrayList	patient_id	    =	new ArrayList();
			ArrayList	chq_amount		=	new ArrayList();
			ArrayList	cheque_colloction_details	    =	new ArrayList();
			HashMap chequeCollectionDtlsMap    =   new HashMap();
			String temp="";		String tot_chk_amt="",temp_chk_num="";				
				for(int i=0;i<totalRec; i++)
					{
						temp =(String) hash.get( "chkSelect_"+i );
						//System.out.println("temp vali:"+temp);
						temp_chk_num =(String) hash.get( "chqNum_"+i );
						//System.out.println("temp_chk_num vali:"+temp_chk_num);



					if(temp.equals("Y"))
					 {
						if(!(temp_chk_num.equals("")))
								{
						   chq_num.add((String) hash.get( "chqNum_"+i ));
						   chq_date.add((String) hash.get( "chqDate_"+i ));
						   bank_name.add((String) hash.get( "bank_"+i ));
						   payer_name.add((String) hash.get( "payer_"+i ));
						   patient_id.add((String) hash.get( "patientId_"+i ));
						   chq_amount.add((String) hash.get( "chqAmount_"+i ));
								}
						
					 }
					}
					 cheque_colloction_details.add( chq_num );
					 cheque_colloction_details.add( chq_date );
					 cheque_colloction_details.add( bank_name );
					 cheque_colloction_details.add( payer_name );
					 cheque_colloction_details.add( patient_id );
					 cheque_colloction_details.add( chq_amount );					

				 chequeCollectionDtlsMap.put("CHEQUE_COLL_DTLS",cheque_colloction_details);
				 bean.setChequeCollectionDtls(chequeCollectionDtlsMap);
			

				
				tot_chk_amt = ((String) hash.get( "cheque_total"));
				bean.setTotChequeAmt(tot_chk_amt);
		
		
		}
	}
	}catch (Exception e) {

	e.printStackTrace() ;
	System.out.println("Exception from STORE_VALUES :"+e);
	}
	

}catch (Exception e) {

	e.printStackTrace() ;
	System.out.println("Exception from PkgDefValidation :"+e);
}
finally
		{
		ConnectionManager.returnConnection(con, request);
		}
//putObjectInBean(bean_id,beanObj,request);


            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
