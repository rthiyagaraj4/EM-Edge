package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eCA.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recmaternityconsintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecMaternityConsIntermediate.jsp", 1709115237962L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block4Bytes, _wl_block4);

	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;


	String mode = request.getParameter("NBmode")==null?"":request.getParameter("NBmode");

	if(mode.equals("ChkNB"))
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String facility_id       = (String) session.getValue("facility_id");
		String no_of_birth ="0";
		String birth_order ="0";

		//String newBornQry="select A.NO_OF_BIRTH,B.BIRTH_ORDER from CA_SPL_DELIVERY_RECORD A,MP_birth_register B where A.MOTHER_PATIENT_ID = B.MOTHER_PATIENT_ID(+) and A.CYCLE_NO = B.DEL_SEQ_NO(+) and A. FACILITY_ID= ? and A.ENCOUNTER_ID= ? and A.CYCLE_NO= ? ";
		String newBornQry="select (select A.NO_OF_BIRTH  from CA_SPL_DELIVERY_RECORD A where A. FACILITY_ID= ? and A.MOTHER_PATIENT_ID= ? and CYCLE_NO= ? AND ROWNUM=1) NO_OF_BIRTH , (select max(B.BIRTH_ORDER)  from MP_birth_register B where B.MOTHER_PATIENT_ID= ?  and MC_CYCLE_NO = ? ) BIRTH_ORDER from dual ";
		
		
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		//String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String cycle_no = request.getParameter("cycle_no")==null?"0":request.getParameter("cycle_no");

		try
		{
			con = ConnectionManager.getConnection(request);
			pstmt		=	con.prepareStatement(newBornQry);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setInt(3,Integer.parseInt(cycle_no));
			pstmt.setString(4,patient_id);
			pstmt.setInt(5,Integer.parseInt(cycle_no));
			rs	 =	pstmt.executeQuery();
			while(rs.next())
			{

				no_of_birth = rs.getString("NO_OF_BIRTH") == null?"0":rs.getString("NO_OF_BIRTH");
				birth_order = rs.getString("BIRTH_ORDER") == null?"0":rs.getString("BIRTH_ORDER");
				
			} 
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();



			if(Integer.parseInt(no_of_birth)==Integer.parseInt(birth_order))
			{
				out.println("event_close_yn('Y');");
			}
			else
			{
				out.println("event_close_yn('N');");
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}	


	}
	else if(mode.equals("ChkDS"))
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmtSect = null;
//		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		ResultSet rsSect = null;
//		ResultSet rs1 = null;
		Boolean delv_rec = true;
		
		String facility_id       = (String) session.getValue("facility_id");
		String no_of_birth ="0";
		String sec_hdg_code = "";
		String delivery_indicator = "";
		
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		//String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String cycle_no = request.getParameter("cycle_no")==null?"0":request.getParameter("cycle_no");
		String module_id = request.getParameter("module_id")==null?"0":request.getParameter("module_id");
		String splt_event_code = request.getParameter("splty_event_code")==null?"":request.getParameter("splty_event_code");
//		String splty_task_code = request.getParameter("splty_task_code")==null?"":request.getParameter("splty_task_code");
		
		try
		{

			String  NoOfBirthQry = " select A.NO_OF_BIRTH ,(SELECT delivery_indicator FROM mp_nod_type where NOD_TYPE = DELIVERY_TYPE) delivery_indicator  from CA_SPL_DELIVERY_RECORD A where A. FACILITY_ID= ? and A.MOTHER_PATIENT_ID= ? and CYCLE_NO= ? AND ROWNUM=1 ";

			String sec_det_qry = " select CHILD_SEC_HDG_CODE from CA_SUBSECTION_LINK_VW where HEADER_SEC_HDG_CODE = 'MC25' order by CHILD_SEQ_NUM " ;

			String transDateQryNew =" select 1 from  CA_PAT_SPLTY_TASK_DTL A,CA_PAT_SPLTY_EPISODE_TASK B where A.ACCESSION_NUM=B.ACCESSION_NUM AND B.PATIENT_ID =? AND B.FACILITY_ID=? AND B.MODULE_ID= ? AND B.CYCLE_NO = ? AND A.HDR_CODE= 'MC25' AND A.SUBHDR_CODE = ? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE='MCT005' AND BIRTH_ORDER = ? and FINALIZE_YN='Y' ";
			
			con		= ConnectionManager.getConnection(request);
			pstmt	= con.prepareStatement(NoOfBirthQry);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,patient_id);
			pstmt.setInt(3,Integer.parseInt(cycle_no));
			rs	 =	pstmt.executeQuery();
			while(rs.next())
			{

				no_of_birth = rs.getString("NO_OF_BIRTH") == null?"0":rs.getString("NO_OF_BIRTH");
				delivery_indicator = rs.getString("delivery_indicator") == null?"0":rs.getString("delivery_indicator");
							
			} 
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
			if(Integer.parseInt(no_of_birth)>0&&!delivery_indicator.equals("C"))
			{
				pstmtSect	= con.prepareStatement(sec_det_qry);
				pstmt	= con.prepareStatement(transDateQryNew);


				for(int DLoop=1;DLoop<=Integer.parseInt(no_of_birth);DLoop++)
				{
				
					rsSect = pstmtSect.executeQuery();

					while(rsSect.next())
					{
						sec_hdg_code =rsSect.getString("CHILD_SEC_HDG_CODE")==null?"":rsSect.getString("CHILD_SEC_HDG_CODE");

						
						if(sec_hdg_code.equals("MC05"))
						{
							continue;
						}
						
						pstmt.setString(1,patient_id);
						pstmt.setString(2,facility_id);
						pstmt.setString(3,module_id);
						pstmt.setInt(4,Integer.parseInt(cycle_no));
						//pstmt.setString(5,sub_act_code);
						pstmt.setString(5,sec_hdg_code);
						pstmt.setString(6,splt_event_code);
						//pstmt.setString(7,splty_task_code);
						pstmt.setInt(7,DLoop);
						rs = pstmt.executeQuery();
						
						
						if(!rs.next())
						{
							delv_rec = false;
							break;
						}

					}
						if(!delv_rec)
						{
							break;
						}


				}

				
			

			}

				if(delv_rec)
				{

					out.println("event_close_delv_yn('Y');");
				}
				else
				{
					out.println("event_close_delv_yn('N');");

				}



		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}	


	}
	else if(mode.equals("ADDLEVNT"))
	{

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		//String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String cycle_no = request.getParameter("cycle_no")==null?"0":request.getParameter("cycle_no");
		String module_id = request.getParameter("module_id")==null?"0":request.getParameter("module_id");
		String splt_event_code = request.getParameter("splty_event_code")==null?"":request.getParameter("splty_event_code");
		String additional_event_yn ="";
		int count = 0;

		try
		{

			String additional_event_query ="SELECT count(SPLTY_EVENT_STATUS) ADDITIONAL_EVENT_YN FROM CA_PAT_SPLTY_EPISODE_EVENT WHERE   PATIENT_ID = ? AND   MODULE_ID  =? AND CYCLE_NO =? AND SPLTY_EVENT_STATUS !='C'  ";
			
				con		= ConnectionManager.getConnection(request);
				pstmt =con.prepareStatement(additional_event_query);
				pstmt.setString(1,patient_id);
				pstmt.setString(2,module_id);
				pstmt.setString(3,cycle_no);
				//pstmt.setString(4,splt_event_code);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					count = rs.getInt("ADDITIONAL_EVENT_YN");
				}

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();

				if(count<=1)
				{
                     additional_event_yn = "Y";
				}
				else
				{
                     additional_event_yn = "N";
				}
				
				out.println("event_close_addlEvnt('"+additional_event_yn+"');");


		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}


	}
	else
	{

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	CallableStatement cs = null;	

	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	//String event_sel = request.getParameter("event_sel")==null?"":request.getParameter("event_sel");
	String splty_event_code = request.getParameter("splty_event_code")==null?"":request.getParameter("splty_event_code");
	String outcome_code = request.getParameter("outcome_code")==null?"":request.getParameter("outcome_code");

	String allow_yn = "";


	//String mat_valid_qry= "select CA_SPL_CAN_OPEN_DEL_CYCYLE_YN(?,?) allow_yn from dual" ;
	//String mat_valid_qry= "select mp_validate_nb_mother(?,?) allow_yn from dual" ;
	String out_evt_qry= "select OUTCOME_EVENT_CODE from CA_SPLTY_EVENT_OUTCOME  where  SPLTY_EVENT_CODE =? and OUTCOME_CODE=? " ;

	try
	{
		con = ConnectionManager.getConnection(request);
		
		if(!outcome_code.equals(""))
		{
			pstmt		=	con.prepareStatement(out_evt_qry);
			pstmt.setString(1,splty_event_code);
			pstmt.setString(2,outcome_code);
			rs	 =	pstmt.executeQuery();
			if(rs.next())
			{

				splty_event_code = rs.getString("OUTCOME_EVENT_CODE") == null?"":rs.getString("OUTCOME_EVENT_CODE");
				
			}

			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();


		}
		


		if(splty_event_code.equals("MCE004")||splty_event_code.equals("MCE008")||splty_event_code.equals("MCE009")||splty_event_code.equals("MCE012"))
	
		{		
		cs = con.prepareCall("{call mp_validate_nb_mother(?,?,?)}");

		cs.setString(1,patient_id);
		cs.setString(2,splty_event_code);
		cs.registerOutParameter( 3,Types.VARCHAR ) ;
		//pstmt.setString(2,event_sel);
		//rs	 =	pstmt.executeQuery();	

		cs.execute();
		allow_yn = cs.getString(3);
		if(allow_yn==null) allow_yn="";
		}
		else
		{
			allow_yn = "";
		}

		/*if(rs.next())
			{

				allow_yn = rs.getString("allow_yn") == null?"":rs.getString("allow_yn");
				
			} */

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		out.println("event_allow_yn(\""+allow_yn+"\");");



	}
	catch (Exception e) 
	{
		e.printStackTrace();
		
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}	
	}


            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
