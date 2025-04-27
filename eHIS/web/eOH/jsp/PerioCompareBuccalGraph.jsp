<!DOCTYPE html>
<%@page import="javax.servlet.jsp.PageContext,javax.servlet.ServletContext,java.sql.*, webbeans.eCommon.*,java.awt.Image, java.awt.*,java.io.*,java.net.*,java.awt.*,javax.swing.ImageIcon,java.awt.*,java.io.*,javax.servlet.*,javax.servlet.http.*,org.jfree.chart.*,org.jfree.chart.axis.*,org.jfree.chart.entity.StandardEntityCollection, org.jfree.chart.labels.*,org.jfree.chart.plot.*,org.jfree.chart.renderer.*,org.jfree.chart.servlet.ServletUtilities,org.jfree.chart.urls.*,org.jfree.data.*,org.jfree.chart.title.TextTitle,org.jfree.data.xy.*,org.jfree.data.category.DefaultCategoryDataset, org.jfree.chart.labels.StandardXYToolTipGenerator,org.jfree.chart.labels.CustomXYToolTipGenerator,org.jfree.chart.renderer.xy.XYLineAndShapeRenderer,org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator,javax.swing.JPanel,org.jfree.chart.title.LegendTitle,java.awt.BasicStroke,java.awt.Color,java.awt.Dimension,org.jfree.chart.ChartFactory,org.jfree.chart.ChartPanel, org.jfree.chart.JFreeChart,org.jfree.chart.axis.NumberAxis,org.jfree.chart.plot.CategoryPlot,org.jfree.chart.plot.PlotOrientation,org.jfree.chart.renderer.category.LineAndShapeRenderer,org.jfree.data.category.CategoryDataset,org.jfree.data.category.DefaultCategoryDataset, org.jfree.data.time.*,org.jfree.chart.axis.DateAxis,java.text.DecimalFormat,org.jfree.chart.*,org.jfree.data.category.*"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
			String locale = (String)session.getAttribute("LOCALE"); 
			request.setCharacterEncoding("UTF-8");
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="javascript" src="../../eCommon/js/common.js"></script> 
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	</head>

	 	<div id='img1' name='1' style="display:None;position:absolute;left:65;top:30;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div> 
		<div id='img2' name='2' style="display:None;position:absolute;left:115;top:30;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
	 	<div id='img3' name='3' style="display:None;position:absolute;left:160;top:30;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div> 
		<div id='img4' name='4' style="display:None;position:absolute;left:210;top:35;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img5' name='5' style="display:None;position:absolute;left:250;top:33;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
 		<div id='img6' name='6' style="display:None;position:absolute;left:295;top:25;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img7' name='7' style="display:None;position:absolute;left:345;top:35;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img8' name='8' style="display:None;position:absolute;left:390;top:30;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img9' name='9' style="display:None;position:absolute;left:435;top:30;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div> 
		<div id='img10' name='10' style="display:None;position:absolute;left:485;top:30;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img11' name='11' style="display:None;position:absolute;left:525;top:25;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img12' name='12' style="display:None;position:absolute;left:575;top:30;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img13' name='13' style="display:None;position:absolute;left:615;top:30;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img14' name='14' style="display:None;position:absolute;left:666;top:30;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img15' name='15' style="display:None;position:absolute;left:713;top:25;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>
		<div id='img16' name='16' style="display:None;position:absolute;left:760;top:30;height:100;width:100">
			<img src='../../eOH/images/Cross.PNG' style="position:absolute; left:0; top:0">
		</div>   

	 	
<%
	//Declarations

	int chartWidth = 831;

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Font labelFont = null;
    Font titleFont = null;

	String sql="";
	String graphURL = "";
	String filename = "";
	String sql1="";
	String tooth_no="";
	String component_code="";
	String s1_Val="";
	String s2_Val="";
	String s3_Val="";
	String tooth_num="";
	String tooth_arr="";
	String X_Axis="";
	String line_seq="";
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_num=checkForNull(request.getParameter("chart_num1"));
	String chart_num2=checkForNull(request.getParameter("chart_num2"));
	String chart_num3=checkForNull(request.getParameter("chart_num3"));
	String chart_line_num="";
	String chart_line_num2="";
	String chart_line_num3="";
	String chart_code=checkForNull(request.getParameter("chart_code"));
	String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag=checkForNull(request.getParameter("permanent_deciduous_flag"));
	String comp_code=checkForNull(request.getParameter("components"));
	String surfface_appl_yn=checkForNull(request.getParameter("surfface_appl_yn"));
	String perio_arch=checkForNull(request.getParameter("perio_arch"));
	String eval_type=checkForNull(request.getParameter("eval_type"));
	String no_of_charts=checkForNull(request.getParameter("no_of_charts"));
	String quadrant=checkForNull(request.getParameter("quadrant"));
	if(eval_type.equals("BB")){
		chart_line_num="1";
		chart_line_num2="1";
		chart_line_num3="1";
	}else{
		chart_line_num=checkForNull(request.getParameter("chart_line_num1"));	
		chart_line_num2=checkForNull(request.getParameter("chart_line_num2"));
		chart_line_num3=checkForNull(request.getParameter("chart_line_num3"));
	}

String D1="";
String D2="";
String D3="";
			if("BE".equals(eval_type)){
				//chart_date= ("1".equals(line_seq))?eval_chart_date1+"(BL)":eval_chart_date2+"(EV)";//chart_date
				if("1".equals(line_seq)){
					D1 = "Baseline";
				}else if("2".equals(line_seq)){
					D2 = "Evaluation1";
				}else if("3".equals(line_seq)){
					D3 = "Evaluation2";
				}
			}else if("EE".equals(eval_type)){
				//chart_date= ("1".equals(line_seq))?eval_chart_date1+"(EV1)":eval_chart_date2+"(EV2)";//chart_date
				if("1".equals(line_seq)){
					D1 = "Evaluation1";
				}else if("2".equals(line_seq)){
					D2 = "Evaluation2";
				}else if("3".equals(line_seq)){
					D3 = "Evaluation3";
				}
			}else if("BB".equals(eval_type)){
				//chart_date = ("1".equals(line_seq))?eval_chart_date1+"(BL1)":eval_chart_date2+"(BL2)";//chart_date
				if("1".equals(line_seq)){
					D1 = "Baseline1";
				}else if("2".equals(line_seq)){
					D2 = "Baseline2";
				}else if("3".equals(line_seq)){
					D3 = "Baseline3";
				}
			}
	
	String X_Axis_uni_upper="";
	String X_Axis_uni_lower="";
	String X_Axis_Lower="";
	String X_Axis_Upper="";
	String img_src="";
	if(quadrant.equals("1")){
		img_src="/eOH/images/R&D_upper_1.png";		
	}else if(quadrant.equals("2")){
		img_src="/eOH/images/R&D_upper2_1.png";		
	}else if(quadrant.equals("4")){
		img_src="/eOH/images/DetalChartFour_NEW_6.PNG";		
	}else if(quadrant.equals("3")){
		img_src="/eOH/images/DetalChartThird_New_4.png";		
	}

	if(tooth_numbering_system.equals("UNI")){
		if(perio_arch.equals("U")){
			X_Axis=X_Axis_uni_upper;

		}else{
			X_Axis=X_Axis_uni_lower;
		}
	}else if(tooth_numbering_system.equals("FDI")){
		if(perio_arch.equals("U")){
			X_Axis=X_Axis_Upper;
		}else{
			X_Axis=X_Axis_Lower;
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
	
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
		if(surfface_appl_yn.equals("N")){
			if(no_of_charts.equals("2")){
				sql="SELECT COMPONENT_CODE,TOOTH_NO, VALUE ,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ 		FROM OH_PERIODONTAL_CHART_DTL A,		(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 			 FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y			 WHERE Z.CHART_CODE = ? 			 AND X.LANGUAGE_ID = ? 			 AND Y.PERMANENT_DECIDUOUS = 'P'	  			 AND Y.ARCH_SNO = ? 			 AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  		WHERE A.PATIENT_ID(+) =?	   	  		AND A.CHART_CODE(+) =?	 		AND A.CHART_NUM(+)  =?	 		AND A.CHART_LINE_NUM(+) =?	  		AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	 		AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	  		UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ      		FROM OH_PERIODONTAL_CHART_DTL A,(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 		FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y    		WHERE Z.CHART_CODE = ?		  		AND X.LANGUAGE_ID =?		    		AND Y.PERMANENT_DECIDUOUS = 'P'		  		AND Y.ARCH_SNO =?		    		AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		  WHERE A.PATIENT_ID(+) =?	   		  AND A.CHART_CODE(+) =?		  AND A.CHART_NUM(+)  =?		    AND A.CHART_LINE_NUM(+) =?		  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		    AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE )  		  WHERE COMPONENT_CODE =?		    ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";

			}else if(no_of_charts.equals("3")){

				sql="SELECT COMPONENT_CODE,TOOTH_NO, VALUE ,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ 		FROM OH_PERIODONTAL_CHART_DTL A,		(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 			 FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y			 WHERE Z.CHART_CODE = ? 			 AND X.LANGUAGE_ID = ? 			 AND Y.PERMANENT_DECIDUOUS = 'P'	  			 AND Y.ARCH_SNO = ? 			 AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D  		WHERE A.PATIENT_ID(+) =?	   	  		AND A.CHART_CODE(+) =?	 		AND A.CHART_NUM(+)  =?	 		AND A.CHART_LINE_NUM(+) =?	  		AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	 		AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	  		UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ      		FROM OH_PERIODONTAL_CHART_DTL A,(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 		FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y    		WHERE Z.CHART_CODE = ?		  		AND X.LANGUAGE_ID =?		    		AND Y.PERMANENT_DECIDUOUS = 'P'		  		AND Y.ARCH_SNO =?		    		AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		  WHERE A.PATIENT_ID(+) =?	   		  AND A.CHART_CODE(+) =?		  AND A.CHART_NUM(+)  =?		    AND A.CHART_LINE_NUM(+) =?		  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		    AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.VALUE,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,3 LINE_SEQ      		FROM OH_PERIODONTAL_CHART_DTL A,(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 		FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y    		WHERE Z.CHART_CODE = ?		  		AND X.LANGUAGE_ID =?		    		AND Y.PERMANENT_DECIDUOUS = 'P'		  		AND Y.ARCH_SNO =?		    		AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		  WHERE A.PATIENT_ID(+) =?	   		  AND A.CHART_CODE(+) =?		  AND A.CHART_NUM(+)  =?		    AND A.CHART_LINE_NUM(+) =?		  AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		    AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE)  		  WHERE COMPONENT_CODE =?		    ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";	
			}

			if(no_of_charts.equals("2")){
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,chart_code);
				pstmt.setString(2,locale);
				pstmt.setString(3,perio_arch);
				pstmt.setString(4,patient_id);
				pstmt.setString(5,chart_code);
				pstmt.setString(6,chart_num);
				pstmt.setString(7,chart_line_num);
				pstmt.setString(8,chart_code);
				pstmt.setString(9,locale);
				pstmt.setString(10,perio_arch);
				pstmt.setString(11,patient_id);
				pstmt.setString(12,chart_code);
				pstmt.setString(13,chart_num2);
				pstmt.setString(14,chart_line_num2);
				pstmt.setString(15,comp_code);
			}else if(no_of_charts.equals("3")){
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,chart_code);
				pstmt.setString(2,locale);
				pstmt.setString(3,perio_arch);
				pstmt.setString(4,patient_id);
				pstmt.setString(5,chart_code);
				pstmt.setString(6,chart_num);
				pstmt.setString(7,chart_line_num);
				pstmt.setString(8,chart_code);
				pstmt.setString(9,locale);
				pstmt.setString(10,perio_arch);
				pstmt.setString(11,patient_id);
				pstmt.setString(12,chart_code);
				pstmt.setString(13,chart_num2);
				pstmt.setString(14,chart_line_num2);
				pstmt.setString(15,chart_code);
				pstmt.setString(16,locale);
				pstmt.setString(17,perio_arch);
				pstmt.setString(18,patient_id);
				pstmt.setString(19,chart_code);
				pstmt.setString(20,chart_num3);
				pstmt.setString(21,chart_line_num3);
				pstmt.setString(22,comp_code);
			}

			rs=pstmt.executeQuery();

			int i=0;
			int j=0;
			int k=0;
			String value_exists_yn = "N";
			while(rs.next()){
				value_exists_yn = "Y";
				tooth_no=rs.getString("TOOTH_NO");
				component_code=rs.getString("COMPONENT_CODE");
				line_seq=rs.getString("LINE_SEQ");

				if(comp_code.equals(component_code) ){
					if("1".equals(line_seq)){
						s2_Val="0";
						s1_Val=checkForNull(rs.getString("VALUE"),"0");
						s3_Val="0";
						if (!s1_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart1", new Double(i));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart1", new Double(i+".3"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart1", new Double(i+".7"));
						} 
						i++;
					}else if("2".equals(line_seq)){
						s1_Val="0";
						s2_Val=checkForNull(rs.getString("VALUE"),"0");
						s3_Val="0";
					if (!s1_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart2", new Double(j));
						}
					if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart2", new Double(j+".3"));
						}
					if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart2", new Double(j+".7"));
						} 
						j++;

					}else if("3".equals(line_seq)){
						s1_Val="0";
						s3_Val=checkForNull(rs.getString("VALUE"),"0");
						s2_Val="0";
					if (!s1_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart3", new Double(k));
						}
					if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart3", new Double(k+".3"));
						}
					if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart3", new Double(k+".7"));
						} 
						k++;

					}
				}
				
			}
		}else{
			if(no_of_charts.equals("2")){
					sql="SELECT COMPONENT_CODE,TOOTH_NO, S1, S2, S3, S4, S5, S6,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6 ,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, 	   	(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	  	FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	  WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	  AND Y.PERMANENT_DECIDUOUS = 'P'	 AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D	 WHERE  A.PATIENT_ID(+) =?	   	 AND A.CHART_CODE(+) =?	AND A.CHART_NUM(+)  =?	AND A.CHART_LINE_NUM(+) =?	 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	 UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ     FROM OH_PERIODONTAL_CHART_DTL A,		  (SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	   		   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y   WHERE Z.CHART_CODE = ?		 AND X.LANGUAGE_ID =?		   AND Y.PERMANENT_DECIDUOUS = 'P'		 AND Y.ARCH_SNO =?		   AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		 WHERE  A.PATIENT_ID(+) =?	   		 AND A.CHART_CODE(+) =?		 AND A.CHART_NUM(+)  =?		   AND A.CHART_LINE_NUM(+) =?		 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE )  		 WHERE COMPONENT_CODE =?		   ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";
			}else if(no_of_charts.equals("3")){
					sql="SELECT COMPONENT_CODE,TOOTH_NO, S1, S2, S3, S4, S5, S6,SURFACES_APPL_YN, LINE_COLOR,LINE_SEQ FROM (SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6 ,D.SURFACES_APPL_YN,'QRYODD' LINE_COLOR,1 LINE_SEQ FROM OH_PERIODONTAL_CHART_DTL A, 	   	(SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	  	FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y 	  WHERE Z.CHART_CODE = ? AND X.LANGUAGE_ID =?	  AND Y.PERMANENT_DECIDUOUS = 'P'	 AND Y.ARCH_SNO = ?	AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D	 WHERE  A.PATIENT_ID(+) =?	   	 AND A.CHART_CODE(+) =?	AND A.CHART_NUM(+)  =?	AND A.CHART_LINE_NUM(+) =?	 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   	AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE	 UNION 	 SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,2 LINE_SEQ     FROM OH_PERIODONTAL_CHART_DTL A,		  (SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	   		   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y   WHERE Z.CHART_CODE = ?		 AND X.LANGUAGE_ID =?		   AND Y.PERMANENT_DECIDUOUS = 'P'		 AND Y.ARCH_SNO =?		   AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		 WHERE  A.PATIENT_ID(+) =?	   		 AND A.CHART_CODE(+) =?		 AND A.CHART_NUM(+)  =?		   AND A.CHART_LINE_NUM(+) =?		 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE UNION SELECT D.COMPONENT_CODE,D.TOOTH_NO,A.S1,A.S2,A.S3,A.S4,A.S5,A.S6,D.SURFACES_APPL_YN,'QRYEVEN' LINE_COLOR,3 LINE_SEQ     FROM OH_PERIODONTAL_CHART_DTL A,		  (SELECT X.COMPONENT_CODE,X.SURFACES_APPL_YN, TOOTH_NO 	   		   FROM OH_PERIODONTAL_CHART_DEF_DTL Z, OH_PERDONTAL_CHRT_COMP_LANG_VW X, OH_TOOTH Y   WHERE Z.CHART_CODE = ?		 AND X.LANGUAGE_ID =?		   AND Y.PERMANENT_DECIDUOUS = 'P'		 AND Y.ARCH_SNO =?		   AND Z.COMPONENT_CODE = X.COMPONENT_CODE ) D		 WHERE  A.PATIENT_ID(+) =?	   		 AND A.CHART_CODE(+) =?		 AND A.CHART_NUM(+)  =?		   AND A.CHART_LINE_NUM(+) =?		 AND A.TOOTH_NO (+)  = D.TOOTH_NO 	   		   AND A.COMPONENT_CODE (+)  = D.COMPONENT_CODE )  		 WHERE COMPONENT_CODE =?		   ORDER BY LINE_SEQ,COMPONENT_CODE,TOOTH_NO";
			}
		if(no_of_charts.equals("2")){
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,chart_code);
			pstmt.setString(2,locale);
			pstmt.setString(3,perio_arch);
			pstmt.setString(4,patient_id);
			pstmt.setString(5,chart_code);
			pstmt.setString(6,chart_num);
			pstmt.setString(7,chart_line_num);
			pstmt.setString(8,chart_code);
			pstmt.setString(9,locale);
			pstmt.setString(10,perio_arch);
			pstmt.setString(11,patient_id);
			pstmt.setString(12,chart_code);
			pstmt.setString(13,chart_num2);
			pstmt.setString(14,chart_line_num2);
			pstmt.setString(15,comp_code);

		}else if(no_of_charts.equals("3")){
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,chart_code);
			pstmt.setString(2,locale);
			pstmt.setString(3,perio_arch);
			pstmt.setString(4,patient_id);
			pstmt.setString(5,chart_code);
			pstmt.setString(6,chart_num);
			pstmt.setString(7,chart_line_num);
			pstmt.setString(8,chart_code);
			pstmt.setString(9,locale);
			pstmt.setString(10,perio_arch);
			pstmt.setString(11,patient_id);
			pstmt.setString(12,chart_code);
			pstmt.setString(13,chart_num2);
			pstmt.setString(14,chart_line_num2);
			pstmt.setString(15,chart_code);
			pstmt.setString(16,locale);
			pstmt.setString(17,perio_arch);
			pstmt.setString(18,patient_id);
			pstmt.setString(19,chart_code);
			pstmt.setString(20,chart_num3);
			pstmt.setString(21,chart_line_num3);
			pstmt.setString(22,comp_code);

		}
			rs=pstmt.executeQuery();
			int i=0;
			int j=0;
			int k=0;
			String value_exists_yn = "N";
			while(rs.next()){
				value_exists_yn = "Y";
				tooth_no=rs.getString("TOOTH_NO");
				component_code=rs.getString("COMPONENT_CODE");
				line_seq=rs.getString("LINE_SEQ");
				if(comp_code.equals(component_code) ){
					if(no_of_charts.equals("2")){	
					if("1".equals(line_seq)){
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
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart1", new Double(i));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart1", new Double(i+".3"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart1", new Double(i+".7"));
						} 
						i++;
					}else if("2".equals(line_seq)){
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
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart2", new Double(j));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart2", new Double(j+".3"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart2", new Double(j+".7"));
						} 
						j++;

					}
				}else if(no_of_charts.equals("3")){	
					if("1".equals(line_seq)){
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
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart1", new Double(i));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart1", new Double(i+".3"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart1", new Double(i+".7"));
						} 
						i++;
					}else if("2".equals(line_seq)){
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
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart2", new Double(j));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart2", new Double(j+".3"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart2", new Double(j+".7"));
						} 
						j++;

					}else if("3".equals(line_seq)){
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
							defaultcategorydataset.addValue(new Double(s1_Val), "Chart3", new Double(k));
						}
						if (!s2_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s2_Val), "Chart3", new Double(k+".3"));
						}
						if (!s3_Val.equals("")){
							defaultcategorydataset.addValue(new Double(s3_Val), "Chart3", new Double(k+".7"));
						} 
						k++;
					  }
				   }
				}
			}
		}//Else  condition for surface_appl_yn

	JFreeChart jfreechart = ChartFactory.createLineChart(null,null,null , defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);

		/*
		 "Line Chart Demo 1",			// chart title
            "Type",						// domain xaxis label
            "Value",					// range yaxis label will come
            dataset,					// data
            PlotOrientation.VERTICAL,	// orientation
            true,						// include legend
            true,						// tooltips
            false						// urls
		*/
		jfreechart.setBackgroundPaint(Color.white);
        labelFont = new Font("Helvetica", Font.PLAIN, 1);
        titleFont = new Font("Helvetica", Font.PLAIN, 8);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
	    categoryplot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_LEFT, false);
		CategoryAxis xAxis = new CategoryAxis("");
        xAxis.setLabelFont(titleFont);
        xAxis.setTickLabelFont(labelFont);
        xAxis.setTickMarksVisible(false);
		categoryplot.setDomainAxis(xAxis);
		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setAutoRangeIncludesZero(true);
 		numberaxis.setLabelAngle(Math.PI / 2.0);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setRange(-25,20);
		categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.lightGray);
        categoryplot.setRangeGridlinesVisible(true);
		categoryplot.setBackgroundImageAlpha(1.0F);
		String url =pageContext.getServletContext().getRealPath("/")+img_src;
	    if(url != null){
            ImageIcon imageicon = new ImageIcon(url);
            categoryplot.setBackgroundImage(imageicon.getImage());
        }

		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)categoryplot.getRenderer();
        lineandshaperenderer.setItemLabelsVisible(true);
        lineandshaperenderer.setPositiveItemLabelPosition(new ItemLabelPosition());
        lineandshaperenderer.setNegativeItemLabelPosition(new ItemLabelPosition());
        lineandshaperenderer.setShapesVisible(true);
        lineandshaperenderer.setDrawOutlines(true);
        lineandshaperenderer.setUseFillPaint(true);
        lineandshaperenderer.setFillPaint(Color.lightGray);
        lineandshaperenderer.setSeriesStroke(0, new BasicStroke(1F));
        lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(0.0F));
        lineandshaperenderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-3D, -3D, 5D, 5D));
		org.jfree.chart.ChartRenderingInfo info = new org.jfree.chart.ChartRenderingInfo(new StandardEntityCollection());
		org.jfree.chart.servlet.ServletUtilities.setTempOneTimeFilePrefix("JFGrCH");
		try{
			filename = org.jfree.chart.servlet.ServletUtilities.saveChartAsPNG(jfreechart,chartWidth,261,info,null);
			org.jfree.chart.ChartUtilities.writeImageMap(new PrintWriter(out),filename,info,false);
			graphURL = request.getContextPath() + "/servlet/org.jfree.chart.servlet.DisplayChart?filename="+filename;
		}
		catch(Exception ee){
			out.println("Exception in try -2 :"+ee.toString());
		}	
	}catch(Exception e){
		out.println("Exception in ComparePerioBuccalGraph.jsp :"+e.toString());
	}finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
	}
%>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
		<form>
			<table>				
				<tr>
					<td>						
						<center><img  src="<%=graphURL%>" border=0 usemap="#<%=filename%>"/></center>
					</td>
				</tr>				
			</table>
			<table cellspacing="" cellpadding="">
				<tr>
					<td width='7%' >&nbsp;</td>
					<td>
						<center ><font size=1><%=X_Axis%></font></center> 
					</td>
					<td width='6%' >&nbsp;</td>
				</tr>	
				
			</table>
		</form>
	</body>
</html>

