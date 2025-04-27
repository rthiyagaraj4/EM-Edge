package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __getval extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/GetVal.jsp", 1731310412855L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n        <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n    <script language=\"javascript\">\n\t\tvar counter,arrayServiceName,arrayServiceCode,arraySectionName,arraySectionCode,selectServiceCodeIndex,sectionLength=0,serviceLength=0;\n\t</script>\n    \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="       \n\t\n<script language=\"javascript\">\n\tarrayServiceCode=new Array();\n\tarrayServiceName=new Array();\n\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t\t\t\n\t\t\t\tarrayServiceCode.push(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\");\n\t\t\t\tarrayServiceName.push(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\");\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\tserviceLength=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =";\n    \n\t</script>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n<script language=\"javascript\">\n\tarraySectionCode=new Array();\n\tarraySectionName=new Array();\t\n\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t\t\t\tarraySectionCode.push(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\");\n\t\t\t\tarraySectionName.push(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\");\n\n\n    ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\tsectionLength=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =";\n    \n\n\t\t</script>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n<script language=\"javascript\">\n\tfunction onLoadAction()\n\t{\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\n\t\tvar n=parent.frames[1].document.forms[0].service.options.length;\n\t\t\t\t\t\t\n\t\tfor(var i=0;i<n;i++)\t\n\t\t\tparent.frames[1].document.forms[0].service.remove(\"service\");\n\t\t\n\t\tn=parent.frames[1].document.forms[0].section.options.length;\n\n        for(var i=0;i<n;i++)\t\n\t\t\tparent.frames[1].document.forms[0].section.remove(\"section\");\n\t\t\t\n\t\t\n\t\tif(parent.document.frames[1].clinic_form.eff_status.checked==true)\n        {\n\t\t\tvar optService=parent.document.frames[1].document.createElement(\"OPTION\");\n            optService.text=\"  -------- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" --------  \";\n            optService.value=\"\";\n\t\t\toptService.selected=true;\n\n\t\t\tvar optSection=parent.document.frames[1].document.createElement(\"OPTION\");\n            optSection.text=\"  -------- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" --------  \";\n            optSection.value=\"\";\n\t\t\toptSection.selected=true;\n            \n            \n            if(parent.document.frames[1].document.forms[0].service != null)\n\t\t\t    parent.document.frames[1].document.forms[0].service.add(optService); \n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\n\t\t\tif(parent.document.frames[1].document.forms[0].section != null)\tparent.document.frames[1].document.forms[0].section.add(optSection); \n\t\t\t    \n            var counter;\n\t\t\tif(parent.document.frames[1].document.forms[0].section != null)\n\t\t\tfor(counter=0;counter<sectionLength;counter++){\t\t\toptSection=parent.document.frames[1].document.createElement(\"OPTION\");\n            optSection.text=arraySectionName.pop();\n            optSection.value=arraySectionCode.pop();\n\t\t\tparent.document.frames[1].document.forms[0].section.add(optSection);\n\t\t\t}\n\t\t\t\n\n\t\t\tif(parent.document.frames[1].document.forms[0].service != null)\n\t\t\tfor(counter=0;counter<serviceLength;counter++){\t\t\toptService=parent.document.frames[1].document.createElement(\"OPTION\");\n            optService.text=arrayServiceName.pop();\n            optService.value=arrayServiceCode.pop();\n\t\t\tparent.document.frames[1].document.forms[0].service.add(optService);\n\t\t\t}\n\t\t\t            \t\n\t\t}\n\n\t}";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n    \n    </script> \n\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\n\n\n</head>\n\t<body onload=\"onLoadAction();\" CLASS=\'MESSAGE\' onKeyDown = \'lockKey();\'>\n\t\n\t\n    <form name=\'nam1\' id=\'nam1\'>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="                                  \n    <script>\n            var tp =\"  -------- \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\" --------  \";\n            var opt=parent.document.frames[1].document.createElement(\"OPTION\");\n            opt.text=tp;\n            opt.value=\"\";\n            \n            if(parent.document.frames[1].document.forms[0].mr_location_code != null)\n                parent.document.frames[1].document.forms[0].mr_location_code.add(opt);                   \n    </script>           \n                                    \n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n    <script>\n            var temp = \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n            var temp1=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n            var opt=parent.document.frames[1].document.createElement(\"OPTION\");\n            opt.text=temp1;\n            opt.value=temp;\n\t\t parent.document.frames[1].clinic_form.mr_location_code.value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n            \n            if(parent.document.frames[1].document.forms[0].mr_location_code != null)\n                parent.document.frames[1].document.forms[0].mr_location_code.add(opt);\n   \t\n   \t</script>\n     \t\t\t\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<script language =\'javascript\'>\n\t\t\t\t\t\tvar objlength=parent.frames[1].document.forms[0].vitalsignsb.length;\n\t\t\t\t\tfor(i=1;i<objlength;i++)\n\t\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].vitalsignsb.item(i).value == \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" )\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].vitalsignsb.item(i).selected=true;\n\t\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="          \n            \n            \n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);
          
			request.setCharacterEncoding("UTF-8");
			Connection con = null;
            Statement stmt = null;
            ResultSet rset=null;
			String sStyle	=
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		try{
			con=ConnectionManager.getConnection(request);
            stmt = con.createStatement();

            String servicecode="";
			String servicedesc="";
            String common=request.getParameter("Common_Text");
            String srv_code=request.getParameter("srv_code");
            String srv_desc=request.getParameter("srv_desc");
            String sectionType = request.getParameter("sectionType");
            if(sectionType == null) sectionType="";
            String toPopulatefs = request.getParameter("toPopulatefs");
            if(toPopulatefs == null) toPopulatefs="";

			String speciality=request.getParameter("speciality");
			if(speciality == null) speciality = "";
		
            String clinicSectionName=null, clinicSectionSql, clinicSectionCode=null;
				
			String facilityid=(String)session.getValue("facility_id");


			if(toPopulatefs.equals(""))
            {
            
            if(srv_code == null) srv_code="";
            if(srv_desc == null) srv_desc="";
            
                String sql = "select service_code,service_short_desc from am_facility_service_vw where eff_status = 'E' and operating_facility_id ='"+facilityid+"' and medical_yn='Y' and dept_Code='" + common.trim() + "' order by service_short_desc desc";
                rset = stmt.executeQuery(sql);          
                out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
			
			clinicSectionSql="Select clinicSection.SHORT_DESC clinicSectionName, clinicSection.SECTION_CODE clinicSectionCode from am_dept_section clinicSection, am_facility_section facilitySection where clinicSection.DEPT_CODE = facilitySection.DEPT_CODE and clinicSection.SECTION_CODE = facilitySection.SECTION_CODE and clinicSection.EFF_STATUS = 'E' and clinicSection.DEPT_CODE = '"+common.trim()+"' and facilitySection.OPERATING_FACILITY_ID='"+facilityid+"' order by 1 desc";

               
				

            _bw.write(_wl_block6Bytes, _wl_block6);


				if(rset != null) 
                {    
					

            _bw.write(_wl_block7Bytes, _wl_block7);

           
            int counter=0;
			while( rset.next() ) 
            {
				counter++;
                servicecode=rset.getString("service_code");
                servicedesc=rset.getString("service_short_desc");

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(servicedesc));
            _bw.write(_wl_block10Bytes, _wl_block10);

				
			}


            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block12Bytes, _wl_block12);

            }

			//Firing ClincSection query
         if(rset != null) rset.close();
		 

			rset=stmt.executeQuery(clinicSectionSql);

			//Creating Html Response for Populating section list item
			
			if(rset!=null)
			{
			

            _bw.write(_wl_block13Bytes, _wl_block13);

				int counter=0;
				while(rset.next())
				{
					counter++;
					clinicSectionName=rset.getString("clinicSectionName");
					clinicSectionCode=rset.getString("clinicSectionCode");
                

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinicSectionCode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(clinicSectionName));
            _bw.write(_wl_block16Bytes, _wl_block16);
                
            }

	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block18Bytes, _wl_block18);

            }

      if(rset != null) rset.close();
	 

            _bw.write(_wl_block19Bytes, _wl_block19);
            _bw.write(_wl_block20Bytes, _wl_block20);
            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block22Bytes, _wl_block22);


            
      }
      else if(toPopulatefs.equals("populate"))
      {
		String sql_l =" Select short_desc,fs_locn_code,permanent_file_area_yn, locn_identity from fm_storage_locn where facility_id = '"+facilityid+"' and locn_identity = '"+sectionType+"' and eff_status = 'E' order by short_desc ";
	            rset = stmt.executeQuery(sql_l);  
				out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE' onKeyDown='lockKey();'><form name='nam1' id='nam1'>");
                if(rset != null) 
                {

            _bw.write(_wl_block23Bytes, _wl_block23);
              
		    while( rset.next() ) 
		    {
			String fs_locn_code=rset.getString("fs_locn_code");
			String short_desc=rset.getString("short_desc");     	

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(fs_locn_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block27Bytes, _wl_block27);
     		
		}
     	}           
                  
           if(rset != null) rset.close();
		  
	  }
	  else
			{
		 String vitalsgncode="";
		 out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body CLASS='MESSAGE'  onKeyDown='lockKey();'><form name='nam1' id='nam1'>");

				String sql="select vital_signs_battery_id from am_speciality where eff_status='E' and speciality_code='"+speciality+"' order by short_desc";
				   rset = stmt.executeQuery(sql);  
				   if(rset != null)
				{
					   while (rset.next())
					{
						   
						  vitalsgncode=rset.getString(1);
						   
							
					}
					
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(vitalsgncode));
            _bw.write(_wl_block29Bytes, _wl_block29);

				}

			if(rset != null) rset.close();
			

			}
			
       
   if (stmt != null) stmt.close();
	}catch(Exception e) { 
		e.printStackTrace();
		//out.println(e.toString());
		
		}
    finally
    {
      if (stmt != null) stmt.close();
      if (rset != null) rset.close();
      if(con!=null) ConnectionManager.returnConnection(con,request);
    }
        out.println("</form></body></html>");       
                            

            _bw.write(_wl_block30Bytes, _wl_block30);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
