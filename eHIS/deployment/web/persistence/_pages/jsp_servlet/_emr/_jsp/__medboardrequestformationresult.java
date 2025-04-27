package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __medboardrequestformationresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedBoardRequestFormationResult.jsp", 1733977617669L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\"../js/MedBoardRequestMain.js\" language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<!-- <script src=\"../../eMR/js/MedBoardRequestButtons.js\" language=\'javascript\'></script> -->\n<script language=\'javascript\' src=\"../../eMR/js/MedBoardReqButtons.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\tfunction assignValue()\n\t{\n\t\tparent.MedBoardRequestFormationMain.document.forms[0].RecordTime.value=\'Y\';\n\t}\n</script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\t<body onScroll=\'scrollTitle()\' onKeyDown=\'lockKey()\'>\n\t<form name=\'MedBoardReqFormResult\' id=\'MedBoardReqFormResult\' action=\'../../servlet/eMR.MedBoardFormationServlet\' method=\'get\' target=\'messageFrame\'>\n\t<div id=\'divDataTitle\' style=\'postion:relative\'>\n\t\t<table border=1 cellspacing=0 cellpadding=0 id=\'dataTitleTable\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t<th width=\'30%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t<th width=\'40%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t<th width=\'15%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t</tr>\n\t\t</table>\n\t</div>\n\t<table border=\'1\' width=\'100%\' id=\'dataTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' style=\"border-bottom:#ffffff\">\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\t\n\t\t\t<TR style=\'visibility:hidden\'>\n\t\t\t\t<th width=\'30%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t</tr>\t\n\t\t</table>\n\t</div>\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\'MEDICAL_BOARD_FORMATION\'>\n\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<input type=\'hidden\' name=\'request_id\' id=\'request_id\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t<input type=\'hidden\' name=\'formation_status\' id=\'formation_status\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n</form>\n</body>\t\n</html>\n\n<script>alignWidth();</script>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet MedBoardReqFormBean= null;synchronized(session){
                MedBoardReqFormBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("MedBoardReqFormBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(MedBoardReqFormBean==null){
                    MedBoardReqFormBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("MedBoardReqFormBean",MedBoardReqFormBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String facility_id = (String)session.getValue( "facility_id" );

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	String formation_status = checkForNull(request.getParameter("formation_status"));
	String medical_board	= checkForNull(request.getParameter("medical_board"));
	String appt_date		= checkForNull(request.getParameter("appt_date"));
	String user_type		= checkForNull(request.getParameter("user_type"));
	String user				= checkForNull(request.getParameter("user"));
	String role				= checkForNull(request.getParameter("role"));
	String pract_id			= checkForNull(request.getParameter("pract_id"));
	String practid_desc		= checkForNull(request.getParameter("practid_desc"));
	String request_id		= checkForNull(request.getParameter("request_id"));
	String check_value		= checkForNull(request.getParameter("check_value"));
	String mode				= checkForNull(request.getParameter("mode"));
	String RecordTime		= checkForNull(request.getParameter("RecordTime"));
		if(RecordTime.equals("")) RecordTime = "N";
	String queryFire_yn		= checkForNull(request.getParameter("queryFire_yn"));
		if(queryFire_yn == null || queryFire_yn.equals("")) queryFire_yn = "Y";

	String appendStr			= "";
	String record				= "";
	String modify_record		= "";
	String check				= "";
	String chk_value			= "";
	String classValue			= "";
	String mod_pract_id			= "";
	String mod_request_id		= "";
	String role1				= "";
	String pract_id1			= "";
	String request_id1			= "";
	String practitioner_name	= "";
	String practitioner_id		= "";
	String medical_board_code	= "";
	String new_role				= "";
	String user_code			= "";
	String pract_type_code		= "";
	String appt_dt				= "";
	String table_values			= "";

	int rec_count =0; 
	int rec_count1 =0; 
	int cnt = 0;
	int role_cnt =0;

	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;

	String Sql = "";
//out.println("<script>alert('queryFire_yn : "+queryFire_yn+" || RecordTime : "+RecordTime+"')</script>");

try
{
	if(queryFire_yn.equals("Y") && RecordTime.equals("N"))
	{
		con = ConnectionManager.getConnection(request);

		//Sql = " SELECT a.PRACT_TYPE, a.USER_PRACT_YN, TO_CHAR (c.appt_date, 'dd/mm/yyyy') appt_date, DECODE (a.pract_type,'I', 'Internal','E', 'External') pract_type_desc, DECODE (a.user_pract_yn, 'U', 'User', 'P', 'Practitioner') user_desc,(CASE WHEN a.pract_type = 'I' AND a.user_pract_yn = 'U' THEN (SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID = A.PRACTITIONER_ID) WHEN a.pract_type = 'I' AND a.user_pract_yn = 'P' THEN (SELECT PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = A.PRACTITIONER_ID) WHEN a.pract_type = 'E' AND a.user_pract_yn = 'P' THEN (SELECT PRACTITIONER_NAME FROM AM_EXT_PRACTITIONER WHERE PRACTITIONER_ID = A.PRACTITIONER_ID) END ) PRACTITIONER_NAME,a.practitioner_id, a.medical_board_code, a.request_id, a.ROLE, a.srl_no, a.user_pract_yn user_code, a.pract_type pract_type_code FROM MR_MED_BOARD_MEMBER a, MR_REPORT_REQUEST_HDR c WHERE a.facility_id = '"+facility_id+"' AND a.request_id = '"+request_id+"' AND A.FACILITY_ID = C.FACILITY_ID AND a.request_id = c.request_id ";

		Sql = " SELECT a.prAct_Type, a.User_prAct_yn, To_char(c.appt_Date,'dd/mm/yyyy') appt_Date, DECODE(a.prAct_Type,'I','Internal','E','External') prAct_Type_desc, DECODE(a.User_prAct_yn,'U','User','P','Practitioner') User_desc, (CASE WHEN a.prAct_Type = 'I' AND a.User_prAct_yn = 'U' THEN sm_get_desc.SM_APPL_USER(a.Practitioner_Id,'"+locale+"','1') WHEN a.prAct_Type = 'I' AND a.User_prAct_yn = 'P' THEN am_get_desc.AM_PRACTITIONER(a.Practitioner_Id,'"+locale+"','1') WHEN a.prAct_Type = 'E' AND a.User_prAct_yn = 'P' THEN am_get_desc.AM_EXT_PRACTITIONER(a.Practitioner_Id,'"+locale+"','1') END) Practitioner_Name, a.Practitioner_Id, a.Medical_Board_Code, a.Request_Id, a.ROLE, a.srl_No, a.User_prAct_yn User_Code, a.prAct_Type prAct_Type_Code FROM   MR_MED_BOARD_MEMBER a, MR_REPORT_REQUEST_HDR c WHERE  a.Facility_Id = '"+facility_id+"' AND a.Request_Id = '"+request_id+"' AND a.Facility_Id = c.Facility_Id AND a.Request_Id = c.Request_Id ";

		stmt = con.createStatement();
		rs	=	stmt.executeQuery(Sql);

		if(rs != null && rs.next())
		{
			MedBoardReqFormBean.clearAll();
		}
		if(rs != null) rs.close();		
		
		rs	=	stmt.executeQuery(Sql);
		if(rs != null)
		{
			while(rs.next())
			{
				practitioner_name	= checkForNull(rs.getString("practitioner_name"));
				practitioner_id		= checkForNull(rs.getString("practitioner_id"));
				medical_board_code	= checkForNull(rs.getString("medical_board_code"));
				new_role			= checkForNull(rs.getString("role"));
				user_code			= checkForNull(rs.getString("user_code"));
				pract_type_code		= checkForNull(rs.getString("pract_type_code"));
				appt_dt				= checkForNull(rs.getString("appt_date")," ");
				table_values		= pract_type_code+"~"+user_code+"~"+practitioner_id+"~"+practitioner_name+"~"+new_role+"~"+"Checked~"+appt_dt+"~"+request_id+"~"+medical_board_code;

				MedBoardReqFormBean.putObject(table_values);
				out.println("<script>setTimeout('assignValue()',1000);</script>");
			}
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}
}catch (Exception Ex)
{
	//out.println("Exception in query : "+Ex.toString());
	Ex.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

try
{
	if(mode.equals("insert"))
	{
		int k=0,incr =0;
		if(!check_value.equals(""))
		{
			StringTokenizer chk_val_split = new StringTokenizer(check_value,"~");
			while(chk_val_split.hasMoreTokens())
			{
				mod_pract_id = chk_val_split.nextToken();
				mod_request_id = chk_val_split.nextToken();
			}
		}

		rec_count1 = MedBoardReqFormBean.getSize();		

		if(	rec_count1 > 0 )
		{
			for(k=0;k<rec_count1;k++)
			{
				modify_record = (String)MedBoardReqFormBean.getObject(k);
				StringTokenizer mod_split_rec = new StringTokenizer(modify_record,"~");
				while(mod_split_rec.hasMoreTokens())
				{		
					mod_split_rec.nextToken();
					mod_split_rec.nextToken();
					pract_id1 = mod_split_rec.nextToken();
					mod_split_rec.nextToken();
					role1 = mod_split_rec.nextToken();
					check = mod_split_rec.nextToken();
					mod_split_rec.nextToken();
					request_id1 = mod_split_rec.nextToken();
					mod_split_rec.nextToken();

					if(	pract_id.equals(pract_id1) && request_id.equals(request_id1))
						incr++;

					if(role1.equals("C") && role.equals("C"))
						role_cnt++;
				}
			}

			if(incr>0)
			{
				out.println("<script>alert(getMessage('RECORD_ALREADY_EXISTS','SM'))</script>");
			}
			else if(role_cnt ==1)
			{
				out.println("<script>alert(getMessage('CONT_MRTHN_ONE_CHIEF','MR'))</script>");
			}
			else
			{
				appendStr = user_type+"~"+user+"~"+pract_id+"~"+practid_desc+"~"+role+"~"+"Checked~"+appt_date+"~"+request_id+"~"+medical_board;
				MedBoardReqFormBean.putObject(appendStr);
			}
		}
		else if(rec_count1 == 0)
		{
			appendStr = user_type+"~"+user+"~"+pract_id+"~"+practid_desc+"~"+role+"~"+"Checked~"+appt_date+"~"+request_id+"~"+medical_board;
			MedBoardReqFormBean.putObject(appendStr);
		}
	}
	else if(mode.equals("modify"))
	{
		int k=0,incr =0;
		StringTokenizer chk_val_split = new StringTokenizer(check_value,"~");
		while(chk_val_split.hasMoreTokens())
		{
			mod_pract_id = chk_val_split.nextToken();
			mod_request_id = chk_val_split.nextToken();
		}

		rec_count1 = MedBoardReqFormBean.getSize();		
		if(	rec_count1 > 0 )
		{
			for(k=0;k<rec_count1;k++)
			{
				modify_record = (String)MedBoardReqFormBean.getObject(k);
				StringTokenizer mod_split_rec = new StringTokenizer(modify_record,"~");
				while(mod_split_rec.hasMoreTokens())
				{		
					user_type = mod_split_rec.nextToken();
					user = mod_split_rec.nextToken();
					pract_id = mod_split_rec.nextToken();
					practid_desc = mod_split_rec.nextToken();
					role = mod_split_rec.nextToken();
					check = mod_split_rec.nextToken();
					appt_date = mod_split_rec.nextToken();
					request_id = mod_split_rec.nextToken();
					medical_board = mod_split_rec.nextToken();

					if(	pract_id.equals(mod_pract_id) && request_id.equals(mod_request_id))
					{
						check="unChecked";
						incr = k;
						k= rec_count1;
					}
					appendStr = user_type+"~"+user+"~"+pract_id+"~"+practid_desc+"~"+role+"~"+check+"~"+appt_date+"~"+request_id+"~"+medical_board;
				}
			}
			MedBoardReqFormBean.setObject(incr,appendStr);
			
			/// New logic to remove value from bean if chk box is unchecked
			if(	pract_id.equals(mod_pract_id) && request_id.equals(mod_request_id))
			{
				if((MedBoardReqFormBean.containsObject(appendStr)))
				{
					int removeCodeIndex = MedBoardReqFormBean.indexOfObject(appendStr);
						MedBoardReqFormBean.removeObject(removeCodeIndex);
				}
			}

		}
	}
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);


	//ArrayList record = MedBoardReqFormBean.getAllRecord();
	rec_count = MedBoardReqFormBean.getSize();
	//MedBoardReqFormBean.clearAll();
	if(	rec_count > 0 )
	{
		for(int j=0;j<rec_count;j++)
		{
			if(cnt%2 == 0)
				classValue = "QRYEVEN";
			else
				classValue = "QRYODD";

			record = (String)MedBoardReqFormBean.getObject(j);
//			out.println("getObject "+record);
//			out.println("<br>");

			StringTokenizer split_rec = new StringTokenizer(record,"~");
			while(split_rec.hasMoreTokens())
			{
				user_type = split_rec.nextToken();
				if(user_type.equals("I"))
					user_type = "Internal";
				else if(user_type.equals("E"))
					user_type = "External";

				user = split_rec.nextToken();
				if(user.equals("U"))
					user = "User";
				else if(user.equals("P"))
					user = "Practitioner";

				pract_id = split_rec.nextToken();
				practid_desc = split_rec.nextToken();
				role = split_rec.nextToken();
				if(role.equals("C"))
					role = "Chief";
				else if(role.equals("M"))
					role = "Member";

				check = split_rec.nextToken();
				appt_date = split_rec.nextToken();
				request_id = split_rec.nextToken();
				medical_board = split_rec.nextToken();

				chk_value = pract_id+"~"+request_id;
			}
			out.println("<tr>");
				out.println("<td width='30%' align='left' class='"+classValue+"'>"+user_type+" / "+user+"</td>");
				out.println("<td align='left' class='"+classValue+"'>"+practid_desc+"</td>");
				out.println("<td align='left' class='"+classValue+"'>"+role+"</td>");
				out.println("<td align='center' class='"+classValue+"'><input type='checkbox' name='check_"+cnt+"' id='check_"+cnt+"' value='"+chk_value+"'  "+check+"  Onclick='uncheckval(this)'><input type='hidden' name='pract_"+cnt+"' id='pract_"+cnt+"' value='"+user+"'><input type='hidden' name='role_"+cnt+"' id='role_"+cnt+"' value='"+role+"'></input><input type='hidden' name='user_type_"+cnt+"' id='user_type_"+cnt+"' value='"+user_type+"'></input></td>");
			out.println("</tr>");
			cnt++;
		}
	}

	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(formation_status));
            _bw.write(_wl_block17Bytes, _wl_block17);


}catch(Exception e)
{
	//out.println("Exception @ MedBoardRequestFormationResult "+e.toString());
	e.printStackTrace();
}

            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MemberType.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MemberType.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Role.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
