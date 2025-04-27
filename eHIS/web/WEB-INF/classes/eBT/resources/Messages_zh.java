/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBT.resources;

import java.util.*;

public class Messages_zh extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
		{"DATE_ST_NULL","BT0113 输液开始日期�?能为空"},
		{"DATE_ST_GT_ISSUE","BT0114 输液开始日期应该大于�?�出日期"},
		{"DATE_ST_LT_RESER","BT0115 输液开始日期应该�?于�?留日期"},
		{"DATE_EN_NULL","BT0116 输液结�?�日期�?能为空"},
		{"DATE_EN_LT_SYS","BT0117 输液日期�?应该大于系统日期"},
		{"DATE_EN_GT_TRANS","BT0118 输液日期应该大于开始日期"},
		{"DATE_EN_GT_TRANS","BT0118 输液日期应该大于开始日期"},
		{"DATE_EN_LT_RESER","BT0119 输液结�?�日期应该�?于�?留日期"},
		{"DATE_EN_LT_RESER","BT0119 输液结�?�日期应该�?于�?留日期"},
		{"DATE_EN_LT_RESER","BT0119 输液结�?�日期应该�?于�?留日期"},
		{"VOLUME_NULL","BT0120 输液�?�?应该为空"},
		{"VOLUME_LT","BT0121 输液�?应该�?于当�?�?"},
		{"PRACT_ID_CURRENT_USER","BT0122 错误的医生选择"},
		{"PRACT_ID_CURRENT_USER","BT0122 错误的医生选择"},
		{"REACTION_CODE_NULL","BT0131 �??应代�?�?应该为空"},
		{"PARTIAL_TRANS_CODE","BT0132 部分输液原因�?能为空"},
		{"PARTIAL_TRANS_CODE","BT0132 部分输液原因�?能为空"},
		{"TXT_PRACT_NULL","BT0141 输液医生�??称为空"},
		{"TRANS_INVESTIGATE","Please order transfusion reaction investigation"},
		{"RECORD_SELECT","选择任一记录请求或打�?�"},
		{"COMPLETE","�?功完�?"}

	};
}			
