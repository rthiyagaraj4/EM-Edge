/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS.resources;

import java.util.*;

public class Messages_zh extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {
		{"RECORD_DELETED","APP - RS0001 �?作�?功…"},
		{"RECORD_MODIFIED","APP - RS0001 �?作�?功..."},
		{"RECORD_INSERTED","APP - RS0001 �?作�?功…"},
		{"TRANSACTION_FAILED","APP - RS0002 交易�??交失败"},
		{"NOT_VALID APP-RS0012","此处请求�?是一个有效的�?作"},
		{"CAN_NOT_BE_EXEED","APP-RS0003 强制性文本长度�?能超过 400"},
		{"REASON_BLANK","APP-RS0003 原因�?能为空"},
		{"TERMSET_MUST_BE_SELECT","APP-RS0004 术语集必须选择"},
		{"NO_AXS_FOR_WP_REQ_SETUP","APP-RS0014 用户无法访问安装工作�?求"},
		{"NO_AXS_FOR_GEN_SCH","APP-RS0015 用户无法访问产生时间表"},
		{"TO_DATE_GR_FR_DATE","APP-RS0017 终止日期必须大于开始日期"},
		{"WORK_HRS_CANNOT_BE_ZERO","APP-RS0018 工作�?时数�?能为0"},
		{"EXPLTEXT_MAX_4000","APP-RS0019 说明文字�?能超过4000个字符"},
		{"FROM_DATE_LESS_SYSDATE","APP-RS0022 开始日期必须�?于等于当�?日期"},
		{"MIN_SCORE_MANDATORY","APP-RS0023 最�?分数必须强制选择输入"},
		{"TO_DATE_LESS_SYSDATE","APP-RS0023 终止日期必须�?于等于当�?日期"},
		{"FROM_TO_BLANK_NOT","APP-RS0026 起止日期必�?�为空或有效日期"},
		{"STEP_IN_CANNOT_BLANK","APP-RS0027 Step In 时间�?能为空白...."},
		{"STEP_OUT_CANNOT_BLANK","APP-RS0028 Step Out 时间�?能为空白...."},
		{"STEP_IN_OUT_HOURS_0_TO_23","APP-RS0029 StepIn/Out �?时必须在�?～２３之间"},
		{"STEP_IN_OUT_MINIT_0_TO_59","APP-RS0030 StepIn/Out 分钟必须在0~59之间"},
		{"SCHEDULE_PERIOD_LESS","APP-RS0032 Period for Work Schedule Generate is less...."},
		{"STEP_IN_OVERLAP","APP-RS0033 步的时间�?�?�"},
		{"REACHED_END","APP-RS0034 已到达最�?�"},
		{"REACHED_BEGIN","APP-RS0035 已到达开始"},
		{"NO_AXS_FOR_MARK_ATTENDANCE","APP-RS0037用户没有标志主治的�?�利"},
		{"STAFF_NOT_AVAILABLE","APP-RS0038 工作人员无法使用"},
		{"NO_VALID_SHIFT_ALLOCATION","APP-RS0043 No valid shifts found for allocation"},
		{"SHIFT_BLANK","APP-RS0044 轮�?��?能为空"},
		{"CANNOT_ASSIGN_SHIFT","APP-RS0046 �?能分�?轮轮�?�"},
		{"TRANSFER_BLANK","APP-RS0047 转�?��?能为空"},
		{"OVERTIME_ASSIGNMENT_NOT_ALLOWED","APP-RS0052 分�?加�?�在有效的时间内�?�?许"},
		{"OVERTIME_DURATION_LAPSED","APP-RS0053 Duration to assign overtime from start of shift is lapsed"},
		{"OVERTIME_DURATION_CLASHES","APP-RS0054 加�?�时间与下一�?�的工作人员冲�?"},
		{"OVERTIME_DURATION_NOT_ZERO","APP-RS0055 加�?�时间�?能为0"},
		{"NO_VALID_SHIFTS_CHANGE","APP-RS0056 没有有效的轮�?��?�以更改"},
		{"ALREADY_SHIFT_ASSIGNED","APP-RS0057 选择轮�?�已分�?给�?�员"},
		{"ERROR_IN_INSERTING_INTO","APP-RS0060�?�入失败"},
		{"STAFF_SUBSTITUTION_FEATURE_NOT_ENABLED","APP-RS0060 工作人员替代的功能没有�?�用"},
		{"NO_VALID_SHIFTS_SWAP","APP-RS0061 没有有效的轮�?��?�互�?�"},
		{"ONE_SHIFT_SELECT_FOR_SWAP","APP-RS0062 必须选择一个轮�?��?�互�?�"},
		{"ONE_SHIFT_SELECT_FOR_SWAP","APP-RS0062 必须选择一个轮�?��?�互�?�"},
		{"LOCATION_NOT_BLANK","APP-RS0063 �?置类型�?能为空白"},
		{"WORKPLACE_NOT_BLANK","APP-RS0063工作地点�?能为空白"},
		{"STAFF_NOT_BLANK","APP-RS0064 �?�员�?能为空"},
		{"STAFF1_SHIFT_ALREADY_ASSIGNED_TO_STAFF2_SHIFT","APP-RS0065 Selected shift of staff 1 is already assigned to staff 2"},
		{"STAFF2_SHIFT_ALREADY_ASSIGNED_TO_STAFF1_SHIFT","APP-RS0066 Selected shift of staff 2 is already assigned to staff 1"},
		{"STAFF1_SCHEDULE_OVERLAPS_WITH_STAFF2","APP-RS0067 Staff 1 existing schedule overlaps with Staff 2 shift to be swapped"},
		{"STAFF2_SCHEDULE_OVERLAPS_WITH_STAFF1","APP-RS0068 Staff 2 existing schedule overlaps with Staff 1 shift to be swapped"},
		{"FROM_DATE_CANNOT_BE_BLANK","开始时间�?能为空"},
		{"FROM_DATE_GREATER_TO_DATE","开始时间必须大于终止日期"},
		{"HOLIDAYS_FROM_TO_NOT_SAME","�?�期的开始日期和开始日期�?能相�?�"},
		{"HR_LESS_TWENTYFOUR","�?时数必须�?于24"},
		{"HR_LESS_TWENTYFOUR","�?时�?于24"},
		{"INVALID_SHIFT APP-RS0031","无效的轮�?�"},
		{"MI_LESS_SIXTY MI","must be less than Sixty"},
		{"NON-WORKING_DAYS_FROM_TO_NOT_EQUAL","�?�工作日起止时间�?能相�?�"},
		{"OPERATING_HOURS_0_TO_23","�?作�?时在0～23之间"},
		{"OPERATING_MINUTES_0_TO_59","�?作分钟在0～59之间"},
		{"FTE_RANGE","范围在1～9之间"},
		{"REMARKS_XCEED_2000_CHARS","备注�?能超过2000个字符"},
		{"TO_DT_GR_EQ_FM_DT","终止日期必须大于等于开始日期"},
		{"TO_DATE_LESSER_FROM_DATE","终止日期必须�?于开始日期"},
		{"TO_DATE_NOT_BLANK","终止日期�?能为空或无效日期"},
		{"WORKING_DAYS_FROM_TO_NOT_EQUAL","工作日起止时间�?能相�?�"}



	};
}			
