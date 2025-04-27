package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.io.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnoteslinkhistnoteintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkHistNoteIntermediate.jsp", 1738316258675L ,"10.3.6.0","Asia/Calcutta")) return true;
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

/*
------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------
06/01/2017    IN037125     Raja S	    08/01/2017                Ramesh G            ML-BRU-SCF-0645
06/09/2019	  IN071335	   Ramesh G											Common-ICN-0012
-------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	int i=1;


	String patient_id = request.getParameter("patient_id")==null?"0":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"0":request.getParameter("encounter_id");
	String accession_num = request.getParameter("accession_num")==null?"0":request.getParameter("accession_num");
	String section_hdg_code = request.getParameter("section_hdg_code")==null?"0":request.getParameter("section_hdg_code");
	String subsection_hdg_code = request.getParameter("subsection_hdg_code")==null?"0":request.getParameter("subsection_hdg_code");
	String facility_id = request.getParameter("facility_id")==null?"0":request.getParameter("facility_id");

	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	
	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);
//	StringBuffer buff =new StringBuffer();
	
	if(mode.equals("clearBean"))
	{
		manageEmailBean.clearBean();
	}
	else if(mode.equals("addToBean"))
	{
	StringBuffer	buf						=	new StringBuffer(); 
	
	//String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		



	//manageEmailBean.clearBean();
	//ArrayList list = manageEmailBean.returnSortList();

	Connection con = null;
//	PreparedStatement stmt = null;
	PreparedStatement pstmt = null;
	PreparedStatement ipstmt = null;
	ResultSet rs = null;
	ResultSet irs = null;
/*	String sql	 = "";
	StringBuffer displaydata = new StringBuffer();
	StringBuffer section_content = null ;
	String		 hist_data_type="";
	String		 strKey			=	"";
	String		 contentXML = "";
	String		 secKey = "";*/
	String		 hashKey = "";
	
	String			notes_section_content	=	"";
	String			section_img_content		=	"";
	StringBuffer			qry						=	new StringBuffer();
	String			sec_content_type			=	"";
	String			subsec_content_type			=	"";
	String			preserve_format_yn			=	"";
	String			image_linked_yn			=	"";
	StringBuffer image_qry = new StringBuffer();
	Clob			clb=null;
	Clob			iclb=null;
	
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();

	if (!section_hdg_code.equals(""))
	{
		//qry.append("select  a.sec_hdg_code , b.content_type sec_content_type , b.sec_hdg_desc , a.subsec_hdg_code , c.content_type subsec_content_type , c.sec_hdg_desc subsec_hdg_desc, a.notes_section_content, NVL(c.PRESERVE_FORMAT_YN, b.PRESERVE_FORMAT_YN) PRESERVE_FORMAT_YN from ca_encntr_note_section a ,ca_section_hdg b ,ca_section_hdg c where  facility_id = ? and accession_num = ? and b.sec_hdg_code=a.sec_hdg_code and c.sec_hdg_code(+)=a.SUBSEC_HDG_CODE and a.sec_hdg_code = ?  ");
		qry.append("select 	a.sec_hdg_code , c.content_type sec_content_type , CA_GET_DESC.CA_SECTION_HDG(a.sec_hdg_code,?,'1') sec_hdg_desc , a.subsec_hdg_code , c.content_type subsec_content_type , CA_GET_DESC.CA_SECTION_HDG(a.subsec_hdg_code,?,'1')  subsec_hdg_desc, a.notes_section_content,c.PRESERVE_FORMAT_YN PRESERVE_FORMAT_YN,c.image_linked_yn 	from 	ca_encntr_note_section a ,ca_section_hdg_lang_vw c 	where  	facility_id = ? and 	accession_num = ? and 	c.language_id = ? and 	c.sec_hdg_code=a.SUBSEC_HDG_CODE and 	a.sec_hdg_code = ?  ");

		if (!subsection_hdg_code.equals(""))
			qry.append("and subsec_hdg_code= ? ");

	}
	else
	{
		qry = new StringBuffer();
		qry.append("select  NOTE_CONTENT  from ca_encntr_note where facility_id = ? and accession_num = ?  ");
	}

	try
	{
		con	= ConnectionManager.getConnection(request);
		pstmt	= con.prepareStatement(qry.toString());
		if (!section_hdg_code.equals(""))
		{
			pstmt.setString(1, locale);
			pstmt.setString(2, locale);
			pstmt.setString(3, facility_id);
			pstmt.setString(4, accession_num);
			pstmt.setString(5, locale);
			pstmt.setString(6, section_hdg_code);

			if (!subsection_hdg_code.equals(""))
				pstmt.setString(7, subsection_hdg_code);
		}
		else 
		{
			pstmt.setString(1, facility_id);
			pstmt.setString(2, accession_num);	
		}
		
		rs = pstmt.executeQuery();
	  
		if (!section_hdg_code.equals(""))
	    {
		  buf.append("<HTML><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><BODY onKeyDown='lockKey()'>");
	 
			while(rs.next())
			{
			  notes_section_content = "";
		 
			buf.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			sec_content_type = rs.getString("sec_content_type")==null?"":rs.getString("sec_content_type");
			image_linked_yn = rs.getString("image_linked_yn")==null?"N":rs.getString("image_linked_yn");
			
			if(!sec_content_type.equals("S"))
			{			
				buf.append("<table width='100%'><tr><td class='NOTEHEADER'>");	
				buf.append(rs.getString("sec_hdg_desc"));
				buf.append("</td></tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				clb = rs.getClob("notes_section_content");
				
				if(clb.length()>0)
				{
					//java.io.BufferedInputStream r = clb.getAsciiStream();
					BufferedReader d  = new BufferedReader(clb.getCharacterStream() );
					String line="";
				
					while(line!=null)
					{
						notes_section_content+=line;
						line = d.readLine();					
					}
				}

				if(image_linked_yn.equals("Y"))
				{
					image_qry.append("select img_content from ca_encntr_note_section_obj where operating_facility_id = ? and accession_num =? and sec_hdg_code = ? ");
					if(!subsection_hdg_code.equals(""))
					{
						image_qry.append(" and subsec_hdg_code = ? ");
					}
					
					ipstmt	= con.prepareStatement(image_qry.toString());
					ipstmt.setString(1, facility_id);
					ipstmt.setString(2, accession_num);
					ipstmt.setString(3, section_hdg_code);
					if(!subsection_hdg_code.equals(""))
					{
						ipstmt.setString(4, subsection_hdg_code);
					}

					irs = ipstmt.executeQuery();

					while(irs.next())
					{
						iclb = irs.getClob("img_content");

						if(iclb.length()>0)
						{
							//IN037125 Changes starts
							/*BufferedReader im  = new BufferedReader(iclb.getCharacterStream() );
							String iline="";
						
							while(iline!=null)
							{
								section_img_content+=iline;
								iline = im.readLine();					
							}*/ 
							section_img_content = iclb.getSubString(1, (int) iclb.length());  
							//IN037125 Changes Ends
						}

					}


					if(irs!=null)  irs.close();
					if(ipstmt!=null) ipstmt.close();

		

				}
				if(sec_content_type.equals("T"))
				{			
					//buf.append("Eureka!!! its a template");
					// IN071335 Changes Start.
					/*StringBuffer url = new StringBuffer(HttpUtils.getRequestURL(request).toString());
					url = new StringBuffer(url.toString().substring(0,url.toString().indexOf("jsp/")));
					//url.append("html/RecClinicalNotesTemplateDispayView.xsl");
					preserve_format_yn= rs.getString("preserve_format_yn");
					buf.append("<table width='100%'><tr><td>");
					if (preserve_format_yn.equals("Y"))
						url.append("html/RecClinicalNotesTemplateDispayView.xsl");
					else
						url.append("html/RecClinicalNotesTemplateSentenceView.xsl");

					notes_section_content = converter.buildHTMLFromXML(notes_section_content,url.toString());
					*/
					String url					= application.getRealPath("/eCA")+"/";
					preserve_format_yn= rs.getString("preserve_format_yn");
					buf.append("<table width='100%'><tr><td>");
					if (preserve_format_yn.equals("Y"))
						url		=url+"html/RecClinicalNotesTemplateDispayView.xsl";
					else
						url		=url+"html/RecClinicalNotesTemplateSentenceView.xsl";
					
					notes_section_content = converter.buildHTMLFromXML(notes_section_content,url);
					// IN071335 Changes end.
					buf.append(notes_section_content);
					
					buf.append("</table>");	
					//eCA/html/RecClinicalNotesTemplateDispayView.xsl":"eCA/html/RecClinicalNotesTemplateSentenceView.xsl
				}
				else
				{
					buf.append(notes_section_content);


					if(!section_img_content.equals(""))
					{

						//buf.append("<tr><td colspan='3'><applet name='"+section_hdg_code + subsection_hdg_code+"' code='Drawing.class' codebase='../MediPainter/' archive='medipainterapplet.jar' width='845' height='400' align='baseline'><param name='canDraw' value='0'><param name='jpeg_quality' value='50'><param name='image' value='"+section_img_content+"'></applet> "); // Commented for IN037125

						buf.append("<tr><td><img src='data:image/jpg;base64, "+section_img_content+"' />");  // Added for IN037125
						
						section_img_content ="";

						

					}
				}
			
			}
			else
			{
				subsec_content_type = rs.getString("subsec_content_type");
				if(i==1)
			
					buf.append("<table width='100%'><tr><td class='NOTEHEADER' >" + rs.getString("sec_hdg_desc") + "</td></tr></table>");
				i++;
				buf.append("<table width='100%'><td class='NOTESUBHEADER'>" + rs.getString("subsec_hdg_desc") + "</td></table>");
				clb = rs.getClob("notes_section_content");
				if(clb.length()>0)
				{
					//java.io.BufferedInputStream r = clb.getAsciiStream();
					BufferedReader d  = new BufferedReader(clb.getCharacterStream() );
					String line="";
					while(line!=null)
					{
						notes_section_content+=line;
						line = d.readLine();					
					}
				}
				if(subsec_content_type.equals("T"))
				{
					// IN071335 Changes Start.
					/*
					StringBuffer url = new StringBuffer(HttpUtils.getRequestURL(request).toString());
					url= new StringBuffer(url.toString().substring(0,url.toString().indexOf("jsp/")));
					//url.append("html/RecClinicalNotesTemplateDispayView.xsl");
					preserve_format_yn= rs.getString("preserve_format_yn");

					if (preserve_format_yn.equals("Y"))
						url.append("html/RecClinicalNotesTemplateDispayView.xsl");
					else
						url.append("html/RecClinicalNotesTemplateSentenceView.xsl");
					
					notes_section_content = converter.buildHTMLFromXML(notes_section_content,url.toString());
					*/
					String url					= application.getRealPath("/eCA")+"/";
					preserve_format_yn= rs.getString("preserve_format_yn");					
					if (preserve_format_yn.equals("Y"))
						url		=url+"html/RecClinicalNotesTemplateDispayView.xsl";
					else
						url		=url+"html/RecClinicalNotesTemplateSentenceView.xsl";
					
					notes_section_content = converter.buildHTMLFromXML(notes_section_content,url);
					
					// IN071335 Changes End.
					buf.append("<table width='100%'><tr><td>");	
					buf.append(notes_section_content);
					buf.append("</table>");	
				}
				else
					buf.append(notes_section_content);
			}
		}
		if(rs!=null)  rs.close();
		if(pstmt!=null) pstmt.close();
		 buf.append("</BODY></HTML>");
		
	  }
		else
		{
			if (rs.next())
			{
				clb = rs.getClob("NOTE_CONTENT");
				if(clb.length()>0)
				{
					//java.io.BufferedInputStream r = clb.getAsciiStream();
					BufferedReader d  = new BufferedReader(clb.getCharacterStream() );
					String line="";
					while(line!=null)
					{
						notes_section_content+=line;
						line = d.readLine();					
					}
					buf.append(notes_section_content);
				}
			}
			if(rs!=null)  rs.close();
			if(pstmt!=null) pstmt.close();

		}

	}
	catch(SQLException sqle)
	{
		buf.append("SQL Exception = " + sqle);
		sqle.printStackTrace();
		if(rs!=null) rs.close();
		if(pstmt!=null)	pstmt.close();
	}
	catch(Exception se)
	{
		buf.append("Exception = " + se);
		se.printStackTrace();
	}
	
	buf.append("<link rel='stylesheet' type='text/css' href='../../eCommon/html/ " + sStyle + "'>");
	
	
	


	
	/*
	String sec_hdg_code = request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	String child_sec_hdg_code = request.getParameter("child_sec_hdg_code")==null?"":request.getParameter("child_sec_hdg_code");
	String Histrectype = request.getParameter("Histrectype")==null?"":request.getParameter("Histrectype");
	String Contrsysid = request.getParameter("Contrsysid")==null?"":request.getParameter("Contrsysid");
	String Accessionnum = request.getParameter("Accessionnum")==null?"":request.getParameter("Accessionnum");
	String Contrsyseventcode = request.getParameter("Contrsyseventcode")==null?"":request.getParameter("Contrsyseventcode");
	String result_disp = request.getParameter("result_disp")==null?"&nbsp;":request.getParameter("result_disp");
	result_disp=result_disp.trim();
	if(result_disp.equals("")||result_disp.equals("SPACE")||result_disp==null||result_disp.equals("null")||result_disp.equals("&nbsp;")||result_disp.equals("&amp;nbsp;"))
	{
		result_disp ="&amp;nbsp;";
	
	}
	String hist_rec_type_desc = request.getParameter("hist_rec_type_desc")==null?"&nbsp;":request.getParameter("hist_rec_type_desc");
	if(hist_rec_type_desc.equals("")||hist_rec_type_desc==null||hist_rec_type_desc.equals("null"))
		hist_rec_type_desc ="&nbsp;";
	String sort_by = request.getParameter("sort_by")==null?"C":request.getParameter("sort_by");
	String event_date_time = request.getParameter("event_date_time")==null?"":request.getParameter("event_date_time");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");

	
	*/
	try
	{
			hashKey =accession_num+"~"+section_hdg_code+"~"+subsection_hdg_code; //Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode+"~"+sec_hdg_code;
			
			/*if(sort_by.equals("D"))
				{
					secKey = sort_by+"~"+event_date_time+"~"+Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode+"~"+result_disp+"~"+hist_rec_type_desc+"~"+sec_hdg_code;
					//secKeyVal=Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode
				}
				else if(sort_by.equals("C"))
				{
					secKey=sort_by+"~"+Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode+"~"+result_disp+"~"+hist_rec_type_desc+"~"+event_date_time+"~"+sec_hdg_code;
					//secKeyVal=Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode
				}*/

				//secKey=Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode;
				
				//secKey = secKey.trim();
				//PatResHash.put(secKey,section_content.toString());


				//sectionBean.setPatSecDetails(PatResHash,patient_id);

				//sectionBean.setSectionContent(sec_hdg_code,child_sec_hdg_code,section_content.toString());
				
				if(!(manageEmailBean.returnHashMap().containsKey(hashKey))) 
				{
					manageEmailBean.addToHashMap(hashKey,buf.toString());
				}
				
				
			/*	if(mode.equals("add"))
				{
					if(!list.contains(secKey)) 
						manageEmailBean.addRecordsToSortList(hashKey);
						manageEmailBean.addToHashMap(hashKey,secKey);
						manageEmailBean.addRecordstoLine2(hashKey);
						manageEmailBean.remRecordsFromLine1(hashKey);
						//manageEmailBean.addRecordstoLine1(secKeyVal);
				}
				if(mode.equals("remove"))
				{

					manageEmailBean.remRecordsFromSortList(hashKey);
					manageEmailBean.removeFromHashMap(hashKey);
					if(!manageEmailBean.returnList1().contains(hashKey))
						{
							manageEmailBean.addRecordstoLine1(hashKey);
							//manageEmailBean.addToHashMap(hashKey,secKey);
						}
					
					//if((list.contains(secKey)))
					//manageEmailBean.addRecordstoLine2(secKey);
					
				}
				
				if(mode.equals("removeAll"))
				{
					manageEmailBean.clearBean();
												
				}*/

				putObjectInBean("manageEmailBean"+patient_id+encounter_id,manageEmailBean,session);

				//putObjectInBean("sectionBean",sectionBean,session);
				out.println("reloadSelPage();");


		/*if(rs !=null) rs.close();
		if(stmt != null ) stmt.close(); */

	}catch(Exception e)
	{		
		
		e.printStackTrace();
	
	}

	finally
	{
		
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

	}


	
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
