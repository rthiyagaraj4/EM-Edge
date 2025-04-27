/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCP.resources;

import java.util.*;

public class Messages_zh extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
			{"RECORD_DELETED","APP - CP0001 �?作�?功."},
			{"RECORD_MODIFIED","APP - CP0001 �?作�?功."},
			{"RECORD_INSERTED","APP - CP0001 �?作�?功."},
			{"TRANSACTION_FAILED","APP - CP0002 交易失败�??交"},
			{"ABS_QTY_CANNOT_ZERO","APP - CP0010 订购数�?�?能为0或空"},
			{"CAN_NOT_BE_EXEED","APP-CP0003 说明文字长度�?能超过400"},
			{"TERMSET_MUST_BE_SELECT","APP-CP0004 术语集必须选择"},
			{"VALUE_GT_ZERO","APP-CP0005 值必须大于零"},
			{"ONE_FINAL_LIB_VERSION","APP-CP0006 图书馆最终版本已存在"},
			{"ATLEAST_ONE_PATIENT_CLASS","APP-CP0007 至少选择一个病人分类被选中"},
			{"DEPENDENCY_LEVEL_CANNOT_ZERO","APP-CP0008 �?赖级别�?能空白"},
			{"LIBRARY_BASIS_CANNOT_ZERO","APP-CP0009 图书馆基础�?能空白"},
			{"NUM_ALLOWED","APP-CP0011 �?��?许数字"},
			{"APPLY_NOT_VALID","APP-CP0012 应用�?是一个有效的�?作"},
			{"INVALID_DATE_TIME","APP-CP0013 无效数�?�的时间.."},
			{"NO_INTERVENTION_TO_RECORD","APP-CP0014 没有涉�?�记录明细"},
			{"NO_RECORD_FOUND","APP-CP0015 未找到记录计划总结"},
			{"NO_INTERVENTION_SELECTED","APP-CP0016 �?干预选定计划详情"},
			{"NO_STD_CP_AVAIL","APP-CP0017 没有标准护�?�计划�??供"},
			{"LENGTH_CANT_EXCEED","APP-CP0018 说明文字长度�?能超过4000"},
			{"REASSESS_INTVL_NOT_ZERO","APP-CP0019 �?新间隔必须大于零"},
			{"ATLEAST_1_INT_1_OUTC","APP-CP0020 必须为一组选择一个介入和一个结果"},
			{"RANGE_1_TO_100","APP-CP0021 切断评分有效范围是1到100"},
			{"ERROR_IN_INSERTING_INTO","APP-CP0022 �?�入时必须至少选中一个记录或一些其他错误"},
			{"MIN_SCORE_MANDATORY","APP-CP0023 在所有选定的�?赖性中 最低分数是必须输入"},
			{"TO_DT_GR_EQ_FM_DT","APP-CP0024 终止日期必须大于等于开始日期"},
			{"DETAILIB_NOT_SELECT","APP-CP0025 没有选择图书馆计划详情"},
			{"INTVN_NOT_SELECT","APP-CP0026 至少一个干预应选择计划详情"},
			{"INTVN_PER_GRP","APP-CP0027 �?组至少应选择一个干预"},
			{"INTVN_ACHIEVE_GOAL","APP-CP0028 为实现这个目标，必须至少选择一个干预"},
			{"DIAGTARTGET_GREATER_DATE","APP-CP0029 诊断目标日期应大于或等于目标的预期日期"},
			{"PTARGET_GREATER_DATE","APP-CP0030 计划的目标日期应大于或等于诊断目标日期"},
			{"DIAGSTART_LESS_DATE","APP-CP0031诊断开始日期应�?于或等于计划开始日期"},
			{"GOALTARGET_GREATER_DATE","APP-CP0032 目标的目标日期应大于或等于诊断开始日期"},
			{"INTVN_START_DATE","APP-CP0033 计划�?�动日期�?，�?能开始干预"},
			{"INTVN_END_DATE","APP-CP0034 干预的结�?�日期时应将大于或等于干预的开始日期"},
			{"GOAL_PER_DIAGNOSIS","APP-CP0035 至少�?一个目标的诊断应选择"},
			{"LENGTH_CANNOT_4000","APP-CP0036 长度�?能超过4000 个字符"},
			{"REMARKS_NOT_BLANK","APP-CP0037 备注必须记录"},
			{"CODE24_GREATER","APP-CP0038 值�?能大于 24�?时"},
			{"WDAY_NOT_BLANK","APP-CP0039 工作日的工作�?时�?能为空"},
			{"NWDAY_NOT_BLANK","APP-CP0040 �?�工作日的工作�?时�?能为空"},
			{"HDAY_NOT_BLANK","APP-CP0041 �?�期的工作�?时�?能为空"},
			{"EXCEED_MAX_LENGTH","APP-CP0042 存在最大长度"},
			{"DURATION_CANNOT_ZERO","APP-CP0043 周期�?能为0"},
			{"VAR_CAUSE_REASON_NOT_BLANK","APP-CP0044 必须记录差�?原因"},
			{"VAR_ATLEAST_1_CAUSE_REASON","APP-CP0045 必须至少选择一个差�?原因"},
			{"ATLEAST_1_VAR_CAUSE_REASON","APP-CP0046 必须至少选择一个差�?原因"},
			{"START_DT_AND_DURN_MUST_ENTER","APP-CP0047 必须输入开始日期和周期"},
			{"INVALID_DATE_TIME","APP-CP0048 无效的日期和时间"},
			{"END_DT_SHOULD_GT_START_DT","APP-CP0049 结�?�日期必须大于开始日期"},
			{"START_DT_SHOULD_GT_SYS_DT","APP-CP0050 开始日期必须大于系统日期"},
			{"LENGTH_CANT_EXCEED_200","APP-CP0051 $长度�?能超过200"},
			{"INCL_DIAG_INTO_PAT_PROFILE","APP-CP0052 请选择诊断作为病人明细的一部分，并继续"},
			{"CANT_ZERO_OR_NEG_NUM","APP-CP0053 $ �?能为0或负数"},
			{"TERM_SET_MANDATORY","APP-CP0057 Atleast one Measure should be associated with the Terminology Set..."} //LICN_1

	};
}			
