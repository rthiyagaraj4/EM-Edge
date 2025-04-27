package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __operroomchargeunits extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OperRoomChargeUnits.jsp", 1709117270000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}


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
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet verifychecklist= null;synchronized(session){
                verifychecklist=(webbeans.eCommon.RecordSet)pageContext.getAttribute("verifychecklist",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(verifychecklist==null){
                    verifychecklist=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("verifychecklist",verifychecklist,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
	
	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter("func_mode") ;
	String facility_id			= checkForNull(request.getParameter( "facility_id" )) ;
	String chk_in_dt_time		= checkForNull(request.getParameter( "chk_in_dt_time" )) ;
	String chk_out_dt_time		= checkForNull(request.getParameter( "chk_out_dt_time" )) ;
	String oper_room_code		= checkForNull(request.getParameter( "oper_room_code" )) ;

	String units				= checkForNull(request.getParameter( "units" )) ;
	String serv_code			= checkForNull(request.getParameter( "serv_code" )) ;
	String oper_num				= checkForNull(request.getParameter( "oper_num" )) ;
	String module_id			= checkForNull(request.getParameter( "module_id" )) ;
	String patient_id			= checkForNull(request.getParameter( "patient_id" )) ;
	String booking_num			= checkForNull(request.getParameter( "booking_num" )) ;
	String order_id				= checkForNull(request.getParameter( "order_id" )) ;
	String speciality_code		= checkForNull(request.getParameter( "speciality_code" )) ;
	String oper_code			= checkForNull(request.getParameter( "oper_code" )) ;
	String surgeon_code			= checkForNull(request.getParameter( "surgeon_code" )) ;


	String encounter_id		= "";		
	String visit_id			= "";		
	String episode_id		= "";		
	String episode_type		= "";		
	String no_of_units		= "";		
	String bill_serv_code	= "";		
	String strErrorCode		= "";		
	String strSysMsgId		= "";
	String strErrText		= "";
	String panel_string		= "";
	String chrg_based_yn	= "";
	String total_amt		= "";
	String pat_payable_amt	= "";
	String excl_incl_ind	= "";
	String preapp_yn		= "";
	String pat_paid_amt		= "";
	String charged_yn		= "";
	String pat_billed_yn	= "";
	String error_lvl		= "";
	String sts_mess_id		= "";
	String err_txt			= "";
	String oper_room_chk_yn	= "";
	String patient_class	= "";
	String bl_episode_type	= "";
	String oper_room_charge_yn	= "";

	String sep	= "##";
	String splitter	= "$$";
	StringBuilder sbr = new StringBuilder();
	Connection con = null;
	PreparedStatement pstmt  = null;
	CallableStatement cstmt  = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		if(func_mode.equalsIgnoreCase("checkORChargeYN")){	
			String oper_room= checkForNull(request.getParameter( "oper_room_code" )) ;			
			String sql="SELECT NVL(CHARGEABLE_YN,'N') FROM OT_OPER_ROOM WHERE OPER_ROOM_CODE ='"+oper_room+"' AND OPERATING_FACILITY_ID='"+facility_id+"' ";
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()){
				oper_room_charge_yn=rst.getString(1);
			}
			out.println(oper_room_charge_yn);
		}else if(func_mode.equalsIgnoreCase("checkORParameter")){	
			if(pstmt!=null)pstmt.close();
			if(rst!=null)rst.close();
			String sql="SELECT CHARGE_OPERATING_ROOM_YN FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()){
				oper_room_chk_yn=rst.getString(1);
			}
			out.println(oper_room_chk_yn);
		}else if(func_mode.equalsIgnoreCase("getOperRoomCheck")){
			if(pstmt!=null)pstmt.close();
			if(rst!=null)rst.close();
			String oper_room_chrging_stg="";
			String sql="select nvl(OPER_ROOM_FINALIZATION_STAGE,'X') from ot_param_for_facility where operating_facility_id ='"+facility_id+"'";
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()){
				oper_room_chrging_stg=rst.getString(1);
			}	
    	  out.println(oper_room_chrging_stg);

		}else if(func_mode.equalsIgnoreCase("callChargeUnits")){	

			String sql="{call BL_PROC_ITEM_VALIDATIONS_MP. OT_CAL_RES_USAGE_UNITS('"+facility_id+"','OT','"+oper_room_code+"',to_date('"+chk_in_dt_time+"','DD/MM/YYYY HH24:MI'),to_date('"+chk_out_dt_time+"','DD/MM/YYYY HH24:MI'),null,?,?,?,?,?)}";
			cstmt=con.prepareCall(sql);
			cstmt.registerOutParameter(1,Types.VARCHAR);
			cstmt.registerOutParameter(2,Types.VARCHAR);
			cstmt.registerOutParameter(3,Types.VARCHAR);
			cstmt.registerOutParameter(4,Types.VARCHAR);
			cstmt.registerOutParameter(5,Types.VARCHAR);
			cstmt.executeQuery();
			no_of_units=cstmt.getString(1);
			bill_serv_code=checkForNull(cstmt.getString(2));
			strErrorCode=checkForNull(cstmt.getString(3));
			strSysMsgId=checkForNull(cstmt.getString(4));
			strErrText=checkForNull(cstmt.getString(5));
			sbr.append(no_of_units).append(sep).append(bill_serv_code).append(sep).append(strErrorCode).append(sep).append(strSysMsgId).append(sep).append(strErrText);
			out.println(sbr.toString());
		}else if(func_mode.equalsIgnoreCase("callServPanel")){
			if(pstmt!=null)pstmt.close();
			if(rst!=null)rst.close();
			String sql="SELECT ENCOUNTER_ID, VISIT_ID, EPISODE_ID,EPISODE_TYPE,PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"'";
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while(rst.next()){
				encounter_id=checkForNull(rst.getString(1));
				visit_id=checkForNull(rst.getString(2));		
				episode_id=checkForNull(rst.getString(3));	
				episode_type=checkForNull(rst.getString(4));		
				patient_class=checkForNull(rst.getString(5));		
			}
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			String sql_bl_episode_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
			pstmt = con.prepareStatement(sql_bl_episode_type);
			rst = pstmt.executeQuery();
			while(rst.next()){
				bl_episode_type=checkForNull(rst.getString(1));		

			}
			if(bl_episode_type.equals("")){
				bl_episode_type=episode_type;
			}
			if(!encounter_id.equals("")){
				String serv_panel_proc="{call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS('"+facility_id+"','"+module_id+"','"+order_id+"',null,'"+bl_episode_type+"','"+patient_id+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"',null,sysdate,'"+oper_code+"','S','"+serv_code+"','"+units+"',null,'P','"+surgeon_code+"',?,?,?,?,?,?,null,null,?,?,?,'"+locale+"',?,?,?)}";
				cstmt=con.prepareCall(serv_panel_proc);
				cstmt.registerOutParameter(1,Types.VARCHAR);
				cstmt.registerOutParameter(2,Types.VARCHAR);
				cstmt.registerOutParameter(3,Types.VARCHAR);
				cstmt.registerOutParameter(4,Types.VARCHAR);
				cstmt.registerOutParameter(5,Types.VARCHAR);
				cstmt.registerOutParameter(6,Types.VARCHAR);
				cstmt.registerOutParameter(7,Types.VARCHAR);
				cstmt.registerOutParameter(8,Types.VARCHAR);
				cstmt.registerOutParameter(9,Types.VARCHAR);
				cstmt.registerOutParameter(10,Types.VARCHAR);
				cstmt.registerOutParameter(11,Types.VARCHAR);
				cstmt.registerOutParameter(12,Types.VARCHAR);
				cstmt.executeQuery();
				panel_string=cstmt.getString(1);
				chrg_based_yn=checkForNull(cstmt.getString(2));
				total_amt=checkForNull(cstmt.getString(3));
				pat_payable_amt=checkForNull(cstmt.getString(4));
				excl_incl_ind=checkForNull(cstmt.getString(5));	
				preapp_yn=checkForNull(cstmt.getString(6));	
				pat_paid_amt=checkForNull(cstmt.getString(7));	
				charged_yn=checkForNull(cstmt.getString(8));	
				pat_billed_yn=checkForNull(cstmt.getString(9));	
				error_lvl=checkForNull(cstmt.getString(10));	
				sts_mess_id=checkForNull(cstmt.getString(11));	
				err_txt=checkForNull(cstmt.getString(12));	
			}
			sbr.append(panel_string).append(splitter).append(chrg_based_yn).append(splitter).append(total_amt).append(splitter).append(strSysMsgId).append(pat_payable_amt).append(excl_incl_ind).append(splitter).append(preapp_yn).append(splitter).append(pat_paid_amt).append(splitter).append(charged_yn).append(splitter).append(pat_billed_yn).append(splitter).append(error_lvl).append(splitter).append(sts_mess_id).append(sep).append(err_txt);
			out.println(sbr.toString());
		}
	}catch(Exception e){
			e.printStackTrace();
			System.err.println("Err Msg from OperRoomChargeUnits..jsp :"+e);
		}
		finally{
			if(sbr!=null)sbr.setLength(0);
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			if(cstmt!=null)cstmt.close();
			if(con!=null) con.close();
		}

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
