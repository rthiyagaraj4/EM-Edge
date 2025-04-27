<!DOCTYPE html>

<%@page import="javax.servlet.jsp.PageContext,javax.servlet.ServletContext,java.sql.*, webbeans.eCommon.*,java.awt.Image, java.awt.*,java.io.*,java.net.*,java.awt.*,javax.swing.ImageIcon,java.awt.*,java.io.*,javax.servlet.*,javax.servlet.http.*,org.jfree.chart.*,org.jfree.chart.axis.*,org.jfree.chart.entity.StandardEntityCollection,org.jfree.chart.renderer.category.BarRenderer, org.jfree.chart.labels.*,org.jfree.chart.plot.*,org.jfree.chart.renderer.*,org.jfree.chart.servlet.ServletUtilities,org.jfree.chart.urls.*,org.jfree.data.*,org.jfree.chart.title.TextTitle,org.jfree.data.xy.*,org.jfree.data.category.DefaultCategoryDataset, org.jfree.chart.labels.StandardXYToolTipGenerator,org.jfree.chart.labels.CustomXYToolTipGenerator,org.jfree.chart.renderer.xy.XYLineAndShapeRenderer,org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator,javax.swing.JPanel,org.jfree.chart.title.LegendTitle,java.awt.BasicStroke,java.awt.Color,java.awt.Dimension,org.jfree.chart.ChartFactory,org.jfree.chart.ChartPanel, org.jfree.chart.JFreeChart,org.jfree.chart.axis.NumberAxis,org.jfree.chart.plot.CategoryPlot,org.jfree.chart.plot.PlotOrientation,org.jfree.chart.renderer.category.LineAndShapeRenderer,org.jfree.data.category.CategoryDataset, org.jfree.data.time.*,org.jfree.chart.axis.DateAxis,java.text.DecimalFormat,org.jfree.chart.*,org.jfree.data.category.*,org.jfree.chart.title.CompositeTitle,org.jfree.chart.block.*,org.jfree.chart.labels.StandardCategoryToolTipGenerator,org.jfree.ui.*"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eOH/js/PerioBuccalGraph.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
		
		<div id='BucNumber1' name='bucNumber1' style="display:None;position:absolute;left:10;top:00;height:100;width:100">
			<img src='../../eOH/images/vertical Numbering_new.png' style="position:absolute; left:0; top:0">
		</div>
		<div id='PDGraph' name='PDGraph' style="display:None;position:absolute;left:350;top:240;height:100;width:100">
			<img src='../../eOH/images/legend3.png' style="position:absolute; left:0; top:0">
		</div>
		<div id='CALGraph' name='CALGraph' style="display:None;position:absolute;left:320;top:240;height:100;width:100">
			<img src='../../eOH/images/legend2.png' style="position:absolute; left:0; top:0">
		</div>
		<div id='CEJGraph' name='CEJGraph' style="display:None;position:absolute;left:328;top:240;height:100;width:100">
			<img src='../../eOH/images/legend1.png' style="position:absolute; left:0; top:0">
		</div>

		<div id='BucNumber2' name='BucNumber2' style="display:None;position:absolute;left:838;top:00;height:100;width:100">
			<img src='../../eOH/images/vertical Numbering_new.png' style="position:absolute; left:0; top:0">
		</div>


		<div id='fdilin' name='fdilin' style="display:None;position:absolute;left:64;top:220;height:100;width:100">
			<img src='../../eOH/images/Numbering2_New.png' style="position:absolute; left:0; top:0">
		</div>

		<div id='fdibuc' name='fdibuc' style="display:None;position:absolute;left:64;top:220;height:100;width:100">
			<img src='../../eOH/images/Numbering1_1.PNG' style="position:absolute; left:0; top:0">
		</div> 
		<div id='unibuc' name='unibuc' style="display:None;position:absolute;left:64;top:220;height:100;width:100">
			<img src='../../eOH/images/Numbering3_1.png' style="position:absolute; left:0; top:0">
		</div> 
		
		<div id='unilin' name='unilin' style="display:None;position:absolute;left:64;top:220;height:100;width:100">
			<img src='../../eOH/images/Numbering4_1.png' style="position:absolute; left:0; top:0">
		</div> 

 	 	<div id='img1' name='1' style="display:none;position:absolute;left:62;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div> 
		<div id='img2' name='2' style="display:none;position:absolute;left:104;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
	 	<div id='img3' name='3' style="display:none;position:absolute;left:150;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div> 
		<div id='img4' name='4' style="display:none;position:absolute;left:198;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img5' name='5' style="display:none;position:absolute;left:245;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
 		<div id='img6' name='6' style="display:None;position:absolute;left:286;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img7' name='7' style="display:none;position:absolute;left:330;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img8' name='8' style="display:none;position:absolute;left:375;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img9' name='9' style="display:none;position:absolute;left:419;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div> 
		<div id='img10' name='10' style="display:none;position:absolute;left:462;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img11' name='11' style="display:none;position:absolute;left:508;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img12' name='12' style="display:none;position:absolute;left:552;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img13' name='13' style="display:none;position:absolute;left:593;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img14' name='14' style="display:none;position:absolute;left:641;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img15' name='15' style="display:None;position:absolute;left:688;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img16' name='16' style="display:None;position:absolute;left:735;top:20;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>   


 	 	<div id='img32' name='32' style="display:none;position:absolute;left:64;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div> 
		<div id='img31' name='31' style="display:none;position:absolute;left:106;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
	 	<div id='img30' name='30' style="display:none;position:absolute;left:150;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div> 
		<div id='img29' name='29' style="display:none;position:absolute;left:200;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img28' name='28' style="display:none;position:absolute;left:240;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
 		<div id='img27' name='27' style="display:none;position:absolute;left:285;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img26' name='26' style="display:none;position:absolute;left:330;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img25' name='25' style="display:none;position:absolute;left:375;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img24' name='24' style="display:none;position:absolute;left:422;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div> 
		<div id='img23' name='23' style="display:none;position:absolute;left:465;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img22' name='22' style="display:none;position:absolute;left:510;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img21' name='21' style="display:none;position:absolute;left:555;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img20' name='20' style="display:none;position:absolute;left:600;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img19' name='19' style="display:none;position:absolute;left:645;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img18' name='18' style="display:none;position:absolute;left:695;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img17' name='17' style="display:none;position:absolute;left:740;top:47;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>   
	
<%
	//Declarations

	int chartWidth = 861;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String graphURL = "";
	String filename = "";
	String sql="";
	String sql1="";
	String tooth_no="";
	String component_code="";
	String s1_Val="";
	String s2_Val="";
	String s3_Val="";
	String s4_Val="0";
	String tooth_num="";
	String tooth_arr="";
	String X_Axis="";

	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_num=checkForNull(request.getParameter("chart_num"));
	String chart_line_num=checkForNull(request.getParameter("chart_line_num"));
	String chart_code=checkForNull(request.getParameter("chart_code"));
	String perio_arch=checkForNull(request.getParameter("perio_arch"));
	String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
	String pd_val=checkForNull(request.getParameter("pd_val"));
	String cal_val=checkForNull(request.getParameter("cal_val"));
	String cej_val=checkForNull(request.getParameter("cej_val"));
	String components=checkForNull(request.getParameter("components"));
	String load_flag=checkForNull(request.getParameter("load_flag"));
	String sel_radio_val=checkForNull(request.getParameter("sel_radio_val"));
	if(components.equals("") && sel_radio_val.equals("PD")){
		components="'PD','CAL'";
	}

	String qry_str2 =("2".equals(load_flag))?"AND Y.COMPONENT_CODE IN ("+components+")":"AND Y.COMPONENT_CODE IN ('PD','CAL')";
	String X_Axis_uni_upper="";
	String X_Axis_uni_lower="";
	String X_Axis_Lower="";
	String X_Axis_Upper="";
	String img_src="";
	if(tooth_numbering_system.equals("UNI")){
		if(perio_arch.equals("U")){
			X_Axis=X_Axis_uni_upper;
			//img_src="/eOH/images/R&D_upper_1.png";
			img_src="/eOH/images/DC1.png";

		}else{
			X_Axis=X_Axis_uni_lower;
			//img_src="/eOH/images/DetalChartFour_NEW_6.PNG";
			img_src="/eOH/images/DC4.png";
		}
	}else if(tooth_numbering_system.equals("FDI")){
		if(perio_arch.equals("U")){
			X_Axis=X_Axis_Upper;
			//img_src="/eOH/images/R&D_upper_1.png";
			img_src="/eOH/images/DC1.png";
		}else{
			X_Axis=X_Axis_Lower;
			img_src="/eOH/images/DC4.png";
		}
	}
	
	try{
	
		con=ConnectionManager.getConnection(request);
		sql1="SELECT B.NS_TOOTH_NO DISPLAY_TOOTH_NO, A.TOOTH_NO FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO=B.TOOTH_NO AND B.NUMBERING_SYSTEM=? AND A.PERMANENT_DECIDUOUS = ? AND A.ARCH_SNO = (?)";
		pstmt=con.prepareStatement(sql1);
		pstmt.setString(1,tooth_numbering_system);
		pstmt.setString(2,permanent_deciduous_flag);
		pstmt.setString(3,perio_arch);
		rs=pstmt.executeQuery();
		while(rs.next()){
				tooth_num=rs.getString(1);
				tooth_arr=tooth_arr+tooth_num+"    ";
		}

		//Data Set
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();

		if(sel_radio_val.equals("PD")){
			if(perio_arch.equals("U")){
				sql="SELECT B.TOOTH_NO,B.COMPONENT_CODE,A.S1,A.S2,A.S3 FROM OH_PERIODONTAL_CHART_DTL A, (SELECT TOOTH_NO, COMPONENT_CODE FROM OH_TOOTH X, OH_PERIODONTAL_CHART_COMP Y WHERE X.PERMANENT_DECIDUOUS = 'P' AND X.ARCH_SNO = ? "+qry_str2+" ) B WHERE A.PATIENT_ID (+) =? AND A.CHART_NUM (+) = ? AND A.CHART_LINE_NUM (+) =?  AND A.CHART_CODE (+)= ? AND A.TOOTH_NO (+) = B.TOOTH_NO AND A.COMPONENT_CODE (+) = B.COMPONENT_CODE ORDER BY B.COMPONENT_CODE DESC, B.TOOTH_NO";
			}else if(perio_arch.equals("L")){
				sql="SELECT B.TOOTH_NO,B.COMPONENT_CODE,A.S1,A.S2,A.S3 FROM OH_PERIODONTAL_CHART_DTL A, (SELECT TOOTH_NO, COMPONENT_CODE FROM OH_TOOTH X, OH_PERIODONTAL_CHART_COMP Y WHERE X.PERMANENT_DECIDUOUS = 'P' AND X.ARCH_SNO = ? "+qry_str2+" ) B WHERE A.PATIENT_ID (+) =? AND A.CHART_NUM (+) = ? AND A.CHART_LINE_NUM (+) =?  AND A.CHART_CODE (+)= ? AND A.TOOTH_NO (+) = B.TOOTH_NO AND A.COMPONENT_CODE (+) = B.COMPONENT_CODE ORDER BY B.COMPONENT_CODE DESC, B.TOOTH_NO DESC";	
			} 
		}else{
			if(perio_arch.equals("U")){
				sql="SELECT B.TOOTH_NO,B.COMPONENT_CODE,A.S1,A.S2,A.S3 FROM OH_PERIODONTAL_CHART_DTL A, (SELECT TOOTH_NO, COMPONENT_CODE FROM OH_TOOTH X, OH_PERIODONTAL_CHART_COMP Y WHERE X.PERMANENT_DECIDUOUS = 'P' AND X.ARCH_SNO = ? "+qry_str2+" ) B WHERE A.PATIENT_ID (+) =? AND A.CHART_NUM (+) = ? AND A.CHART_LINE_NUM (+) =?  AND A.CHART_CODE (+)= ? AND A.TOOTH_NO (+) = B.TOOTH_NO AND A.COMPONENT_CODE (+) = B.COMPONENT_CODE ORDER BY B.COMPONENT_CODE, B.TOOTH_NO";
			}else if(perio_arch.equals("L")){
				sql="SELECT B.TOOTH_NO,B.COMPONENT_CODE,A.S1,A.S2,A.S3 FROM OH_PERIODONTAL_CHART_DTL A, (SELECT TOOTH_NO, COMPONENT_CODE FROM OH_TOOTH X, OH_PERIODONTAL_CHART_COMP Y WHERE X.PERMANENT_DECIDUOUS = 'P' AND X.ARCH_SNO = ? "+qry_str2+" ) B WHERE A.PATIENT_ID (+) =? AND A.CHART_NUM (+) = ? AND A.CHART_LINE_NUM (+) =?  AND A.CHART_CODE (+)= ? AND A.TOOTH_NO (+) = B.TOOTH_NO AND A.COMPONENT_CODE (+) = B.COMPONENT_CODE ORDER BY B.COMPONENT_CODE , B.TOOTH_NO DESC";
			}
		}
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,perio_arch);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,chart_num);
		pstmt.setString(4,chart_line_num);
		pstmt.setString(5,chart_code);
		rs=pstmt.executeQuery();
		int i=1;
		int j=1;
		int k=1;

		if(pd_val.equals("") && cal_val.equals("") && cej_val.equals("") ){
			while(rs.next()){
				tooth_no=rs.getString("TOOTH_NO");
				component_code=rs.getString("COMPONENT_CODE");
				if(component_code.equals("PD")){
					s1_Val=checkForNull(rs.getString("S1"),"0");
					s2_Val=checkForNull(rs.getString("S2"),"0");
					s3_Val=checkForNull(rs.getString("S3"),"0");
					if(perio_arch.equals("L")){
						int s1=(Integer.parseInt(s1_Val)*-1);
						int s2=(Integer.parseInt(s2_Val)*-1);
						int s3=(Integer.parseInt(s3_Val)*-1);
						s1_Val=s1+"";
						s2_Val=s2+"";
						s3_Val=s3+"";
						//s1_Val=(String)s1;
						//s1_Val="-"+s1_Val;
						//s2_Val="-"+s2_Val;
						//s3_Val="-"+s3_Val;
					}
					if (!s1_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s1_Val), "PD", new Double(i+".1"));
					}
					if (!s2_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s2_Val), "PD", new Double(i+".12"));
					}
					if (!s3_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s3_Val), "PD", new Double(i+".14"));
					} 
					if (!s4_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s4_Val), "PD", new Double(j+".2"));
					}

					i++;
				}
				if(component_code.equals("CAL")){
					
					s1_Val=checkForNull(rs.getString("S1"),"0");
					s2_Val=checkForNull(rs.getString("S2"),"0");
					s3_Val=checkForNull(rs.getString("S3"),"0");
					if(perio_arch.equals("L")){
						int s1=(Integer.parseInt(s1_Val)*-1);
						int s2=(Integer.parseInt(s2_Val)*-1);
						int s3=(Integer.parseInt(s3_Val)*-1);
						s1_Val=s1+"";
						s2_Val=s2+"";
						s3_Val=s3+"";
					}
					if (!s1_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s1_Val), "CAL", new Double(j+".1"));
					}
					if (!s2_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s2_Val), "CAL", new Double(j+".12"));
					}
					if (!s3_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s3_Val), "CAL", new Double(j+".14"));
					}
					if (!s4_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s4_Val), "CAL", new Double(j+".2"));
					}
					j++;

				}
				if(component_code.equals("CEJ")){
					s1_Val=checkForNull(rs.getString("S1"),"0");
					s2_Val=checkForNull(rs.getString("S2"),"0");
					s3_Val=checkForNull(rs.getString("S3"),"0");
					if(perio_arch.equals("L")){
						int s1=(Integer.parseInt(s1_Val)*-1);
						int s2=(Integer.parseInt(s2_Val)*-1);
						int s3=(Integer.parseInt(s3_Val)*-1);
						s1_Val=s1+"";
						s2_Val=s2+"";
						s3_Val=s3+"";
					}
					if (!s1_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s1_Val), "CEJ-GM", new Double(k+".1"));
					}
					if (!s2_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s2_Val), "CEJ-GM", new Double(k+".12"));
					}
					if (!s3_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s3_Val), "CEJ-GM", new Double(k+".14"));
					}
					if (!s4_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s4_Val), "CEJ-GM", new Double(j+".2"));
					}
					k++;
				}
			}
		}else{
			while(rs.next()){
				tooth_no=rs.getString("TOOTH_NO");
				component_code=rs.getString("COMPONENT_CODE");
				if(component_code.equals("PD") && (pd_val.equals("PD")) ){
					if(components.equals("'PD','CAL'") && sel_radio_val.equals("PD")){
						s1_Val=checkForNull(rs.getString("S1"),"0");
						s2_Val=checkForNull(rs.getString("S2"),"0");
						s3_Val=checkForNull(rs.getString("S3"),"0");
					}else{
						s1_Val="0";
						s2_Val="0";
						s3_Val="0";
					}
					if(perio_arch.equals("L")){
						int s1=(Integer.parseInt(s1_Val)*-1);
						int s2=(Integer.parseInt(s2_Val)*-1);
						int s3=(Integer.parseInt(s3_Val)*-1);
						s1_Val=s1+"";
						s2_Val=s2+"";
						s3_Val=s3+"";
					}
					if (!s1_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s1_Val), "PD", new Double(i+".1"));
					}
					if (!s2_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s2_Val), "PD", new Double(i+".12"));
					}
					if (!s3_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s3_Val), "PD", new Double(i+".14"));
					} 
					if (!s4_Val.equals("")){
						if(sel_radio_val.equals("PD")){
							defaultcategorydataset.addValue(new Double(s4_Val), "PD", new Double(i+".2"));
						}else{
							defaultcategorydataset.addValue(new Double(s4_Val), "PD", new Double(j+".2"));
						}
					}
					i++;
				}
					if(component_code.equals("CAL") && (cal_val.equals("CAL")) ){
						if(components.equals("'CEJ','CAL'") && sel_radio_val.equals("CAL")){
							s1_Val=checkForNull(rs.getString("S1"),"0");
							s2_Val=checkForNull(rs.getString("S2"),"0");
							s3_Val=checkForNull(rs.getString("S3"),"0");
						}else{
							s1_Val="0";
							s2_Val="0";
							s3_Val="0";
						}
					if(perio_arch.equals("L")){
						int s1=(Integer.parseInt(s1_Val)*-1);
						int s2=(Integer.parseInt(s2_Val)*-1);
						int s3=(Integer.parseInt(s3_Val)*-1);
						s1_Val=s1+"";
						s2_Val=s2+"";
						s3_Val=s3+"";
					}
						if (!s1_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s1_Val), "CAL", new Double(j+".1"));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "CAL", new Double(j+".12"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "CAL", new Double(j+".14"));
						}
						if (!s4_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s4_Val), "CAL", new Double(j+".2"));
						}
						j++;

				}
				if(component_code.equals("CEJ") && (cej_val.equals("CEJ")) ){
					if(components.equals("'CEJ','PD'") && sel_radio_val.equals("CEJ")){
						s1_Val=checkForNull(rs.getString("S1"),"0");
						s2_Val=checkForNull(rs.getString("S2"),"0");
						s3_Val=checkForNull(rs.getString("S3"),"0");
					}else{
						s1_Val="0";
						s2_Val="0";
						s3_Val="0";
					}
					if(perio_arch.equals("L")){
						int s1=(Integer.parseInt(s1_Val)*-1);
						int s2=(Integer.parseInt(s2_Val)*-1);
						int s3=(Integer.parseInt(s3_Val)*-1);
						s1_Val=s1+"";
						s2_Val=s2+"";
						s3_Val=s3+"";
					}
					if (!s1_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s1_Val), "CEJ-GM", new Double(k+".1"));
					}
					if (!s2_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s2_Val), "CEJ-GM", new Double(k+".12"));
					}
					if (!s3_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s3_Val), "CEJ-GM", new Double(k+".14"));
					}
					if (!s4_Val.equals("")){
						defaultcategorydataset.addValue(new Double(s4_Val), "CEJ-GM", new Double(k+".2"));
					}
					k++;
				}
			}
		
		}

		JFreeChart jfreechart = ChartFactory.createBarChart(null, null, null, defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
		jfreechart.setBackgroundPaint(Color.white);
	//	String img1="/eOH/images/R&D_upper.png";
		String url =pageContext.getServletContext().getRealPath("/")+img_src;
		if(url != null){
            ImageIcon imageicon = new ImageIcon(url);
            categoryplot.setBackgroundImage(imageicon.getImage());
			categoryplot.setBackgroundImageAlpha(1.0F);
			//categoryplot.setBackgroundPaint(Color.lightGray);

		}

		categoryplot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT, false); //get the horizontal scale at the top or bottom(.... line)
        CategoryDataset categorydataset = defaultcategorydataset;
        categoryplot.setDataset(1, categorydataset);
   //   categoryplot.mapDatasetToRangeAxis(1, 1);
		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setAutoRangeIncludesZero(true);
		numberaxis.setLabelAngle(Math.PI / 2.0);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setRange(-25,20);
        categoryplot.setRangeAxis(1, numberaxis);
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
		lineandshaperenderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());
		lineandshaperenderer.setShapesVisible(false); //Line chart with outline.
        categoryplot.setRenderer(1, lineandshaperenderer);
        categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
   		org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
		org.jfree.chart.servlet.ServletUtilities.setTempOneTimeFilePrefix("JFGrCH");
		try{
			filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(jfreechart,chartWidth,261,info,null);
			org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename,info,false);
			graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
			//onload="checkMissingTooth();" 
		}
		catch(Exception ee){
			System.err.println("279 PerioBuccalGraph Exception:==="+ee.toString());
		}	
	}catch(Exception e){
		System.err.println("287 Exception in PerioBuccalGraph.jsp :"+e.toString());
	}finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
	}
%>
<!-- onload='loadBucNumsystem();checkMissingTooth();' -->
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload='loadBucNumsystem();checkMissingTooth();'>
		<form >
			<table>	
				<tr>
					<td>						
						<center><img  src="<%=graphURL%>" border=0 usemap="#<%=filename%>"/></center> 
					</td>
				</tr>
			</table>
			<table cellspacing="" cellpadding="">
				<!-- <tr>
					<td width='7%' >&nbsp;</td>
					<td>
						<center ><font size=1><%=X_Axis%></font></center> 
					</td>
					<td width='6%' >&nbsp;</td>
				</tr>	 -->
				
			</table>
	<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
	<input type = "hidden" name= "perio_arch" value = "<%=perio_arch%>">
	<input type = "hidden" name= "chart_code1" value = "<%=chart_code%>">
	<input type = "hidden" name= "chart_num" value = "<%=chart_num%>">
	<input type = "hidden" name= "chart_line_num" value = "<%=chart_line_num%>">
	<input type = "hidden" name= "tns" value = "<%=tooth_numbering_system%>">
	<input type = "hidden" name= "sel_radio_val" value = "<%=sel_radio_val%>">

		</form>
	</body>
</html>

