package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import webbeans.eCommon.*;
import javax.servlet.*;

public final class __noteimagelistpreview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/NoteImageListPreview.jsp", 1709115211124L ,"10.3.6.0","Asia/Calcutta")) return true;
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

public static String getMimeType(File file)  throws java.io.IOException, MalformedURLException 
  {
		String type = null;
	try{
    
    URL u = file.toURL();
    URLConnection uc = null;
    uc = u.openConnection();
    type = uc.getContentType();
  
	}catch(Exception e){
		
		e.printStackTrace();
	}
	  return type;
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

/*
------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name					Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------
13/03/2017    IN063784     Krishna Gowtham J                                        Image is not displaying while clicking Preview button in Note Image
02/11/2018	IN068699	Raja S						02/11/2018		Ramesh G	ML-MMOH-SCF-1087 																					List function_UT Issue
-------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	//out.println("in print preview.");
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	PreparedStatement ptsmt = null;
	PreparedStatement ptsmt1 = null;
	ResultSet rs = null;
	ResultSet rs1 = null;

	java.sql.Blob img_blob = null;
	BufferedOutputStream Buffout = null;
	BufferedOutputStream Buffout1 = null;

	String qryImgContent = "";
	String image_ref = request.getParameter("image_ref")==null?"":request.getParameter("image_ref");
	try
	{
			String image_name = request.getParameter("image_name")==null?"":request.getParameter("image_name");
			String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
			String imgExists = request.getParameter("imgExists")==null?"":request.getParameter("imgExists");
			/*if(mode.equals("insert")){
			image_name="temp_"+image_name;
			}*/
			
			StringBuffer note_image_rep_folder	= new StringBuffer();
			String path	="";
			String docType="";
			String strFileSep="";
			java.util.Properties pFileSep	= null;
			path					= config.getServletContext().getRealPath("/");
			note_image_rep_folder.append(path);
			pFileSep	= System.getProperties();
			strFileSep	= (String) pFileSep.getProperty("file.separator");
			note_image_rep_folder.append(strFileSep); //IN063784
			note_image_rep_folder.append("eCA");
			note_image_rep_folder.append(strFileSep);
			note_image_rep_folder.append("MediPainter");
			note_image_rep_folder.append(strFileSep);
			note_image_rep_folder.append("images");
			note_image_rep_folder.append(strFileSep);
			note_image_rep_folder.append(image_name);
			String filename			=	note_image_rep_folder.toString();
			File file = null;
			InputStream in=null;
			InputStream ins=null;
			InputStream ins1 = null;
			ByteArrayOutputStream bytearrayoutputstream = null;
			boolean deleted=false;
			try{
			file = new File(filename);
			if(mode.equals("insert") || (imgExists.equals(""))){
				docType = request.getParameter("docType")==null?"":request.getParameter("docType");

			}else{
				con = ConnectionManager.getConnection(request);
				String exst="";
				ptsmt=con.prepareStatement("select 'Y' exst from CA_NOTE_IMAGE_LIST where image_Ref=? and objtype is not null");
				ptsmt.setString(1,image_ref);
				rs=ptsmt.executeQuery();
				while((rs!=null) && (rs.next())){
					exst=(String)rs.getString("exst");
				}
				if(exst.equals("Y") ){
					qryImgContent = "select objtype from CA_NOTE_IMAGE_LIST where IMAGE_REF = ? ";
					ptsmt1 = con.prepareStatement(qryImgContent);
					ptsmt1.setString(1,image_ref);
					rs1 = ptsmt1.executeQuery();
					while(rs1 !=null && rs1.next()){
						docType=rs1.getString("objtype");
					}
				}else{
					docType= (String)(getMimeType(file));	
				}
				if(rs1!=null)
					rs1.close();
				if(rs!=null)
					rs.close();
				if(ptsmt1!=null)
					ptsmt1.close();
				if(ptsmt!=null)
					ptsmt.close();		
				
				
			}
			response.setContentType(docType);
			//IN063784 start
			String[] objArray =docType.split("\\/");
			//IN063784 ends
			if(file.exists()){// if the file exists in the folder,read from the folder else read from the database.
				int  size=(int)file.length();
				in = new FileInputStream(file);			
			//IN063784 start
				if("image".equals(objArray[0]))
				{
					byte[] by = new byte[(int)size]; 
					int index = in.read(by, 0, (int)size);  
					response.reset();  
					response.setContentType(docType);  
					response.getOutputStream().write(by, 0, (int)size);  
					response.getOutputStream().flush(); 
				}
				else
				{
					//IN063784 ends
					Buffout = new BufferedOutputStream( response.getOutputStream() );			
					byte[] by = new byte[(int)size]; // 4K buffer buf, 0, buf.length
					int index = in.read(by , 0 ,(int)size);
					while ( index != -1) {
						Buffout.write(by , 0, index);
						index = in.read ( by , 0 ,(int)size );
					}
					Buffout.flush();
				}//added for IN063784
				in.close();
				if(mode.equals("insert") || (imgExists.equals(""))){
					if(file !=null){					
						deleted=file.delete();	
					}
				
				}
	
			}else{//reading from the database 
				if((mode.equals("modify")) && (!imgExists.equals(""))){

					con = ConnectionManager.getConnection(request);
					qryImgContent = "select objtype, IMAGE_CONTENT from CA_NOTE_IMAGE_LIST where IMAGE_REF = ? ";
					ptsmt = con.prepareStatement(qryImgContent);
					ptsmt.setString(1,image_ref);
					rs = ptsmt.executeQuery();
					while(rs !=null && rs.next())
					{
						
						response.setContentType(rs.getString("objtype"));
						img_blob  =  (java.sql.Blob)rs.getBlob("IMAGE_CONTENT");
						long len = img_blob.length();
					/****** create a copy in the image folder*******start****/
						ins1 = img_blob.getBinaryStream();
						bytearrayoutputstream = new ByteArrayOutputStream();
						int i;
						while((i = ins1.read()) != -1) 
						bytearrayoutputstream.write(i);

						boolean fcre=false;
						fcre = file.createNewFile();
						if(fcre)
						{
							FileOutputStream fileoutput = new FileOutputStream(file);
							fileoutput.write(bytearrayoutputstream.toByteArray(),0,(int)len);
							if (fileoutput != null)  fileoutput.close();			
						}

					/****** create a copy in the image folder *******end****/
					/*****get the data from database and display***start*********/
					try{
					  //IN068699 Starts
					  if(file.exists())
					  {// if the file exists in the folder,read from the folder else read from the database.
					  	int  size=(int)file.length();
						ins = new FileInputStream(file);			
						//IN063784 start
						if("image".equals(objArray[0]))
						{
							byte[] by = new byte[(int)size]; 
							int index = ins.read(by, 0, (int)size);  
							response.reset();  
							response.setContentType(docType);  
							response.getOutputStream().write(by, 0, (int)size);  
							response.getOutputStream().flush(); 
						}
						else
						{
							//ins = img_blob.getBinaryStream();
					  //IN068699 ends						
							Buffout1 = new BufferedOutputStream( response.getOutputStream() );
							byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
							int index = ins.read(by , 0 , (int)len);
							while ( index != -1) {
							Buffout1.write(by , 0, index);
							index = ins.read ( by , 0 , (int)len );
							}
							Buffout1.flush();
						}
						
					   }
					}catch(Exception e){
						e.printStackTrace();
					}
					/*****get the data from database and display***end*********/

						
					}
					if(ins !=null)
						ins.close();
					if(ins1 !=null)
					ins1.close();
				}
			}
						
			}catch(Exception e){
				
				e.printStackTrace();
			}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);

		if(rs!=null)
			rs.close();
		if(ptsmt!=null)
			ptsmt.close();
	
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
