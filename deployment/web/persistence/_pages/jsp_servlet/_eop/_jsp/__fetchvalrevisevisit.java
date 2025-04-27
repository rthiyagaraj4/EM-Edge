package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.jsp.JspWriter;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fetchvalrevisevisit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/FetchValReviseVisit.jsp", 1717396878547L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\n</head>\n\n<body class=\'message\' onKeyDown = \'lockKey();\'>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</body>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

  
  Connection con  	= null;
  String facility_id  	= ""; 
  String str1     	= "";
  String str2     	= "";
  //venkat
  String locale               = (String)session.getAttribute("LOCALE"); 
  PreparedStatement   pstmt=null;
  ResultSet     rs 		= null;
  String SPECIALITY_CODE="";
  StringBuffer rstr=new StringBuffer();

  try{    
  	con = ConnectionManager.getConnection(request);
  	facility_id = (String) session.getValue("facility_id");

  	String flag_name = request.getParameter("flag_name");
  	if(flag_name == null) flag_name= "";

	String resourceClass="";
	String OPEN_TO_ALL_PRACT_YN="";    	
  	
  /**Population of the Location Details **/     
   
   if (flag_name.equals("asn_locn_code"))
    {
      String locn_code    	= request.getParameter("asn_locn_code");
      String locncode = "";
      if (locn_code != null)
      {
      		locncode 	= locn_code.substring(0,locn_code.indexOf("|"));
      }
      
      pstmt   = con.prepareStatement( "select short_desc,locn_type from am_care_locn_type where locn_type=(select clinic_type from op_clinic where clinic_code ='"+locncode+"' and facility_id='"+facility_id+"' )");
	  
      rs = pstmt.executeQuery();
      if( rs != null )
      {
        while( rs.next() )
        {
          str1 = rs.getString( "short_desc" );   
          str2 = rs.getString( "locn_type" );
			out.println("<script>parent.frames[2].document.getElementById('asn_care_locn_text').innerHTML='&nbsp;&nbsp;"+str1+"';</script>");
		 out.println("<script>parent.frames[2].document.forms[0].asn_care_locn_type.value='"+str2+"';</script>");

		}

	  }
		 
		if(rs != null ) rs.close();
		if(pstmt != null) pstmt.close();

		String practitionerMandatorySQL = "Select ident_at_checkin, SPECIALITY_CODE,PRIMARY_RESOURCE_CLASS RESCLASS,OPEN_TO_ALL_PRACT_YN  from op_clinic where facility_id = ? and clinic_code = ? and clinic_type = (select clinic_type from op_clinic where clinic_code = ? and facility_id = ?)";


		PreparedStatement practitionerMandatoryStatement = con.prepareStatement(practitionerMandatorySQL);
		practitionerMandatoryStatement.setString(1,facility_id);
		practitionerMandatoryStatement.setString(2,locncode);
		practitionerMandatoryStatement.setString(3,locncode);
		practitionerMandatoryStatement.setString(4,facility_id);
		
		ResultSet practitionerMandatoryResult = practitionerMandatoryStatement.executeQuery();

		String practitionerMandatory = null;
		if(practitionerMandatoryResult != null && practitionerMandatoryResult.next())
		{
			practitionerMandatory = practitionerMandatoryResult.getString("ident_at_checkin");
		    SPECIALITY_CODE = practitionerMandatoryResult.getString("SPECIALITY_CODE");
			resourceClass   = practitionerMandatoryResult.getString("RESCLASS");
			OPEN_TO_ALL_PRACT_YN=practitionerMandatoryResult.getString("OPEN_TO_ALL_PRACT_YN");
		}

		if(practitionerMandatory == null)
			practitionerMandatory = "X";

		out.println("<script>");

		out.println("parent.frames[2].document.forms[0].cur_specialty_code.value='"+SPECIALITY_CODE+"';");
		out.println("parent.frames[2].document.forms[0].ident_at_checkin.value='"+practitionerMandatory+"';");
		
		out.println("parent.frames[2].document.forms[0].res_class.value='"+resourceClass+"';");
		out.println("parent.frames[2].document.forms[0].open_to_all.value='"+OPEN_TO_ALL_PRACT_YN+"';");

		if(practitionerMandatory.equalsIgnoreCase("P"))
		{
			if(!resourceClass.equals("R"))
			{
			out.println("parent.frames[2].document.forms[0].practitionerMandatoryGIF.style.visibility = 'visible';");
			out.println("parent.frames[2].document.forms[0].identifyPractitionerAtCheckIn.value = 'Y';");
			}
		}
		else
		{
			out.println("parent.frames[2].document.forms[0].practitionerMandatoryGIF.style.visibility = 'hidden';");
			out.println("parent.frames[2].document.forms[0].identifyPractitionerAtCheckIn.value = 'N';");
		}

		out.println("</script>");

		if(practitionerMandatoryResult != null)practitionerMandatoryResult.close();
		if(practitionerMandatoryStatement != null)practitionerMandatoryStatement.close();
     	 
  
    //int rcnt=0;
	rstr.append("<option value=''>&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</option>");
	
	/*pstmt=con.prepareStatement("select count(*) as total from op_pract_for_clinic where facility_id=? and clinic_code=? and eff_status='E' and resource_class='R' order by practitioner_id");
	
	pstmt.setString(1,facility_id);
	pstmt.setString(2,locncode);
	rs =pstmt.executeQuery();
	rs.next();
	rcnt=rs.getInt("total");

	
	if(rs != null ) rs.close();
	if(pstmt != null) pstmt.close();*/
//below query was modified by Venkatesh.S (4008) on 03-Dec-2012 against (36531)
	String roomNumberSQL="select practitioner_id ROOM_NO,am_get_desc.am_facility_room (a.facility_id, a.practitioner_id, '"+locale+"', 2) room_desc from op_pract_for_clinic a where facility_id=? and clinic_code=? and eff_status='E' and resource_class='R' order by practitioner_id";
	
	PreparedStatement roomNumberStatement = con.prepareStatement(roomNumberSQL);
	roomNumberStatement.setString(1,facility_id);
	roomNumberStatement.setString(2,locncode);
	ResultSet roomNumberResult = roomNumberStatement.executeQuery();
	
		//if(rcnt != 0)
		//{
				//if (roomNumberResult != null)
				//{
					boolean flag=false;
					while(roomNumberResult.next())
					{
						 flag=true;
						 String roomNumber=roomNumberResult.getString(1);
						 String roomDesc=roomNumberResult.getString(2);
						rstr.append( "<option value='"+roomNumber+"'>"+roomNumber+" "+roomDesc+"</option>");
					}
				//}
				if(roomNumberResult != null )roomNumberResult.close();
				
				if(flag)
				{
				String robj="<select name='Room_numsel' id='Room_numsel' onChange='setroomno()' tabIndex='2'>"+rstr.toString()+"</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'>";
				out.println("<script>");
				out.println("parent.frames[2].document.getElementById('room_value').innerHTML=\""+robj+"\"");
				out.println("</script>");
				}	
				else
				{
					 String robj="<select name='Room_numsel' id='Room_numsel' onChange='setroomno()' tabIndex='2'><option value=''>&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----</option></select>";
					 out.println("<script>");
					 out.println("parent.frames[2].document.forms[0].room_num.value ='NoRoom'");
					 out.println("parent.frames[2].document.getElementById('room_value').innerHTML=\""+robj+"\"");
					 out.println("</script>");
				}
		
				if(roomNumberStatement != null )roomNumberStatement.close();     
	}// if
	else if (flag_name.equals("assign_care_locn_code1"))
	{
		String locn_code = request.getParameter("clinic_code"); 		
      
		pstmt = con.prepareStatement("select open_to_all_pract_yn from op_clinic where FACILITY_ID ='"+facility_id+"' and CLINIC_CODE = '"+locn_code+"' ");	  
		rs = pstmt.executeQuery();

		if( rs != null )
		{
			if(rs.next())
			{
			 	 OPEN_TO_ALL_PRACT_YN = rs.getString("open_to_all_pract_yn"); 				
			}		  out.println("<script>parent.frames[1].document.getElementById('open_to_all_pract_yn').value='"+OPEN_TO_ALL_PRACT_YN+"';</script>");			
		}	  
		 
		if(rs != null ) rs.close();
		if(pstmt != null) pstmt.close();
	}

   if(rs != null)   rs.close();
   if(pstmt != null) pstmt.close();
  
     
  }catch(Exception  e){
	e.printStackTrace();
	  } 
  
  finally	{
		
		
		rstr.setLength(0);
	    try
		{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}catch(Exception e){
			e.printStackTrace();
		}
        if(con!=null) ConnectionManager.returnConnection(con,request);
			}

            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
