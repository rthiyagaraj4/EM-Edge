<%@ page import="com.asprise.util.jtwain.SourceManager,com.asprise.util.jtwain.Source,java.awt.*,java.awt.image.*,java.io.*,javax.imageio.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>  
<%	
	String appPath = "";
	String backSlash = "\\";
	String frontSlash = "/";

	//Image image = null;
	BufferedImage image = null;

	String filePath = session.getServletContext().getRealPath("/");
	appPath = filePath.replace(backSlash, frontSlash);		
	appPath = appPath + "eCA/images/";

	try {
		Source source = SourceManager.instance().getDefaultSource();

		if (source != null)
		{
			source.open();

			//image = source.acquireImage();
			if(source.isUIEnabled())
				source.setUIEnabled(false);

			source.setIndicators(false);

			image = source.acquireImageAsBufferedImage();

			ImageIO.write(image, "jpg", new File(appPath+"test.jpg"));

		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally{
		SourceManager.closeSourceManager();
	}
%>	
<html>
<body scroll="auto">

<h2>Scanned Image</h2>
<!--<img border="0" src=<%=image%> alt="Pulpit rock" width="304" height="228">-->
<img border="5" src="../../eCA/images/test.jpg" alt="Scanned Image"  width="1200" >

</body>
</html>


