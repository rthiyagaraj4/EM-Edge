package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import java.util.*;
import com.ehis.util.*;

public final class __opqueuenumberingpopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/OpqueuenumberingPopulate.jsp", 1709119455851L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t\t\t<html><head>\n\t\t \n\t\t  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t  \n\t\t\t<!--\n\t\t\t\t<script>\n\t\t\t\tvar element = parent.f_query_add_mod.document.createElement(\'OPTION\');\n\t\t\t\telement.text = \"-----\"+getLabel(\'Common.defaultSelect.label\',\'Common\')+\"-----\";\n                element.value= \'\';\n                parent.f_query_add_mod.document.opqueuenumbering_form.locn_code.add(element);\t\t\t\n\t\t\t\t</script>\n\t\t\t-->\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<!-- <script>\n\t\t\t\t\tvar element = parent.f_query_add_mod.document.createElement(\'OPTION\');\n\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"; \n\t\t            element.value= \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t        parent.f_query_add_mod.document.opqueuenumbering_form.locn_code.add(element);\n\t\t\t\t</script>\n\t\t\t\t-->\n    \t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t \n\t\n\t<!-- <html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n<script>\n\n\t\n\tparent.f_query_add_mod.document.opqueuenumbering_form.open_to_all_pract_yn.value = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\n\tparent.f_query_add_mod.document.opqueuenumbering_form.res_class.value = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t \n\t\t\t\tparent.f_query_add_mod.document.opqueuenumbering_form.walk_in.disabled=true\t\t\t\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\tparent.f_query_add_mod.document.opqueuenumbering_form.walk_in.disabled=false;\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\tparent.f_query_add_mod.document.opqueuenumbering_form.appointment.disabled=true;\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\tparent.f_query_add_mod.document.opqueuenumbering_form.appointment.disabled=false;\t\t    \n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\tparent.f_query_add_mod.document.opqueuenumbering_form.referral.disabled=true;\t\t\t\t\n\t   ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\tparent.f_query_add_mod.document.opqueuenumbering_form.referral.disabled=false;\n\t\t    \n\t  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n\t\t\t\t\n\t\t\t\t\n\t\t\t\n\n\n\t\t\n\n\tvar obj = parent.f_query_add_mod.document.opqueuenumbering_form.room_no1;\n    var length  = obj.length;\n    for(i=0;i<length;i++) {obj.remove(0);}\n\troomNoOption=parent.f_query_add_mod.document.createElement(\'OPTION\');\n    roomNoOption.text=\"----------------\"+parent.getLabel(\'Common.defaultSelect.label\',\'Common\')+\"------------------\";\n    roomNoOption.value=\"*ALL\";\n    parent.f_query_add_mod.document.opqueuenumbering_form.room_no1.add(roomNoOption);\n\tparent.f_query_add_mod.document.opqueuenumbering_form.room_no1.disabled = false;\n\t\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t \n\t /*   roomNoOption=parent.f_query_add_mod.document.createElement(\'OPTION\');\n\t   roomNoOption.text=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"+\' \'+\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t   roomNoOption.value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t  \n\t   parent.f_query_add_mod.document.opqueuenumbering_form.room_no1.add(roomNoOption); */\n\t   \n\t   /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */\n\t            var temp = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"+\" \"+\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\tvar temp2=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\'OPTION\');\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp2;\n\t\t\t\tparent.f_query_add_mod.document.opqueuenumbering_form.room_no1.add(opt);\n\t /*CRF end SS-CRF-0010 [IN034516]*/\n\t\n        ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t roomNoOption=parent.f_query_add_mod.document.createElement(\'OPTION\');\n\t     roomNoOption.text=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t     roomNoOption.value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t   //  parent.f_query_add_mod.document.opqueuenumbering_form.room_no.add(roomNoOption);\n\t\n\t\t\n       ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\n\t\t\t\n</script>\n\t\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t<script>\n\troomNoOption=parent.f_query_add_mod.document.createElement(\'OPTION\');\n\troomNoOption.text=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\troomNoOption.value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\n\t\n//\tparent.f_query_add_mod.document.opqueuenumbering_form.room_no.add(roomNoOption);\n\t\n</script>\n\t\t\n    ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\t\n\t\t</head><body CLASS=\'MESSAGE\' onKeyDown = \'lockKey();\'></body></html>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n    \n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	String   locale = (String)session.getValue("LOCALE");
	/*end SS-CRF-0010 [IN034516]*/
    String getopt = request.getParameter("getoption");
    //String loctype = request.getParameter("locn_type");
	String loccode = request.getParameter("locn_code");

	
	String allow_walk_in_yn="";
	String allow_referral_yn="";
	String allow_appt_yn="";

	String queue_num_other_res_class="";
	String roomNo="";
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	String room_desc="";
	/*CRF end SS-CRF-0010 [IN034516]*/
	String res_class="";
	String short_desc = "";
    String clinic_code = "";
					
	Connection con = null;
    PreparedStatement pstmt = null;
	PreparedStatement roomNoPopulateStatement=null;
    ResultSet rs = null;
	ResultSet roomNoPopulateResult=null;

	try
	{
		con = ConnectionManager.getConnection(request);
		String globalfacilityId  =  (String) session.getValue( "facility_id" ) ;

		String opentoallpractyn = "";

		//if(getopt.equals("one"))
		//{
	  
            _bw.write(_wl_block5Bytes, _wl_block5);

			String sStyle	=
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			/*try
			{
				pstmt= con.prepareStatement("select clinic_code,long_desc from op_clinic where facility_id = '"+globalfacilityId+"' and clinic_type='"+loctype+"' and eff_status = 'E' order by long_desc");

                rs = pstmt.executeQuery() ;
                String short_desc = "";
                String clinic_code = "";
                if( rs != null ) 
                {
                    while( rs.next() ) 
                    {
                        short_desc = rs.getString( "long_desc" ) ;
                        clinic_code = rs.getString( "clinic_code" );*/
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block10Bytes, _wl_block10);

                 /*   }
                }

				if(rs != null ) rs.close();
				if(pstmt != null ) pstmt.close();

			} catch(Exception e) { out.println(e.toString());}

		}*/
		if(getopt.equals("two"))
	    {   
	
            _bw.write(_wl_block11Bytes, _wl_block11);

        try
		{
			pstmt=con.prepareStatement("select open_to_all_pract_yn,ident_at_checkin,allow_appt_yn,allow_walk_in_yn,allow_referral_yn,QUEUE_NUM_APPL_YN,QUEUE_NUM_OTHER_RES_CLASS,QUEUE_NUM_OTHER_RES_TYPE,primary_resource_class from op_clinic where clinic_code='"+loccode+"' and facility_id='"+globalfacilityId+"' ");
			
            rs = pstmt.executeQuery() ;

            
				while( rs.next() )
                {
					opentoallpractyn = rs.getString("open_to_all_pract_yn");
                    
			        allow_walk_in_yn= rs.getString("allow_walk_in_yn");
					allow_referral_yn= rs.getString("allow_referral_yn");
					allow_appt_yn= rs.getString("allow_appt_yn");
				   
						
					queue_num_other_res_class=rs.getString("queue_num_other_res_class");
					
					
				    res_class=rs.getString("primary_resource_class");
					
					}
			
			if(rs != null ) rs.close();
			if(pstmt != null ) pstmt.close();			
			

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(opentoallpractyn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(res_class));
            _bw.write(_wl_block14Bytes, _wl_block14);
            _bw.write(_wl_block15Bytes, _wl_block15);


		if(!allow_walk_in_yn.equals("Y"))
			 {
            _bw.write(_wl_block16Bytes, _wl_block16);
}else
			{
            _bw.write(_wl_block17Bytes, _wl_block17);
}

		if(!allow_appt_yn.equals("Y"))
			{
            _bw.write(_wl_block18Bytes, _wl_block18);
}else 
			{
            _bw.write(_wl_block19Bytes, _wl_block19);
}

		if(!allow_referral_yn.equals("Y"))
	    	{
            _bw.write(_wl_block20Bytes, _wl_block20);
}else
		   {
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
 //venkat this query was commented by venkatsh
	 
	 //String roomNoPopulateSql="select practitioner_id Room_no from op_pract_for_clinic where facility_id='"+globalfacilityId+"' and clinic_code='"+loccode+"' and eff_status='E' and resource_class='R' order by practitioner_id";
        
		/* Below line query modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
        String roomNoPopulateSql="SELECT a.practitioner_id ROOM_NO,am_get_desc.am_facility_room (a.facility_id,a.practitioner_id, '"+locale+"', 2) room_desc FROM op_pract_for_clinic a,  am_facility_room b WHERE a.facility_id='"+globalfacilityId+"' AND a.clinic_code='"+loccode+"' AND  a.eff_status='E'  AND  a.resource_class='R' AND  a.practitioner_id=b.room_num  AND a.facility_id=b.OPERATING_FACILITY_ID ";
		/*CRF end SS-CRF-0010 [IN034516]*/
		roomNoPopulateStatement=con.prepareStatement(roomNoPopulateSql);
        roomNoPopulateResult=roomNoPopulateStatement.executeQuery();
        while(roomNoPopulateResult.next())
        {  
	   roomNo=roomNoPopulateResult.getString("ROOM_NO"); 
	   /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	   room_desc=roomNoPopulateResult.getString("room_desc");
	   /*CRF end SS-CRF-0010 [IN034516]*/
	 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(room_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(room_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(room_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
		
 		if(roomNoPopulateResult != null) roomNoPopulateResult.close();
		if(roomNoPopulateStatement != null ) roomNoPopulateStatement.close();
	
		
            _bw.write(_wl_block31Bytes, _wl_block31);
String other_res=request.getParameter("other_res")==null?queue_num_other_res_class:request.getParameter("other_res");
	String desc="";
	roomNoPopulateSql="select  a.PRACTITIONER_ID Room_no, b.short_desc description from op_pract_for_clinic a, am_resource b  where a.FACILITY_ID='"+globalfacilityId+"' and a.CLINIC_CODE='"+loccode+"' and a.RESOURCE_CLASS='"+other_res+"' and a.FACILITY_ID=b.FACILITY_ID and a.resource_class=b.resource_class and a.PRACTITIONER_ID=b.resource_id order by 2";
    roomNoPopulateStatement=con.prepareStatement(roomNoPopulateSql);
    roomNoPopulateResult=roomNoPopulateStatement.executeQuery();
     while(roomNoPopulateResult.next())
      {  
		   roomNo=roomNoPopulateResult.getString("Room_no")==null?"":roomNoPopulateResult.getString("Room_no"); 
		   desc=roomNoPopulateResult.getString("description")==null?"":roomNoPopulateResult.getString("description"); 
		 
		 
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block35Bytes, _wl_block35);
            _bw.write(_wl_block2Bytes, _wl_block2);

				
			} catch(Exception e) { out.println(e.toString());}
	
		}else if(getopt.equals("three"))
		{
		   String other_res=request.getParameter("other_res");
		   String desc="";
		   String roomNoPopulateSql="select  a.PRACTITIONER_ID Room_no, b.short_desc description from op_pract_for_clinic a, am_resource b  where a.FACILITY_ID='"+globalfacilityId+"' and a.CLINIC_CODE='"+loccode+"' and a.RESOURCE_CLASS='"+other_res+"' and a.FACILITY_ID=b. FACILITY_ID and a.resource_class=b.resource_class and a.PRACTITIONER_ID=b.resource_id order by 2";
	  

	   roomNoPopulateStatement=con.prepareStatement(roomNoPopulateSql);
       roomNoPopulateResult=roomNoPopulateStatement.executeQuery();
       while(roomNoPopulateResult.next())
      {  
	  roomNo=roomNoPopulateResult.getString("Room_no")==null?"":roomNoPopulateResult.getString("Room_no");
	  desc=roomNoPopulateResult.getString("description")==null?"":roomNoPopulateResult.getString("description");
		   
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(roomNo));
            _bw.write(_wl_block38Bytes, _wl_block38);
  }
		
		if(roomNoPopulateResult != null) roomNoPopulateResult.close();
		if(roomNoPopulateStatement != null) roomNoPopulateStatement.close();

		}	
	

            _bw.write(_wl_block39Bytes, _wl_block39);
	
	}
	catch(Exception ec){ out.println("in exception :"+ec); }
	finally
	{
	      if (rs != null)       rs.close();
		  if (pstmt != null)    pstmt.close();
    
		  if(roomNoPopulateResult!=null)	roomNoPopulateResult.close();
		  if(roomNoPopulateStatement!=null)	roomNoPopulateStatement.close();

		  if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block40Bytes, _wl_block40);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
