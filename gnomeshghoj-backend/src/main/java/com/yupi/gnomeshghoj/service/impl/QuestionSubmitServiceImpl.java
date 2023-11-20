package com.yupi.gnomeshghoj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.gnomeshghoj.common.ErrorCode;
import com.yupi.gnomeshghoj.exception.BusinessException;
import com.yupi.gnomeshghoj.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.yupi.gnomeshghoj.model.entity.Question;
import com.yupi.gnomeshghoj.model.entity.QuestionSubmit;
import com.yupi.gnomeshghoj.mapper.QuestionSubmitMapper;
import com.yupi.gnomeshghoj.model.entity.User;
import com.yupi.gnomeshghoj.model.enums.QuestionSubmitLanguageEnum;
import com.yupi.gnomeshghoj.model.enums.QuestionSubmitStatusEnum;
import com.yupi.gnomeshghoj.service.QuestionService;
import com.yupi.gnomeshghoj.service.QuestionSubmitService;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author wl
* @description 针对表【question_submit(题目提交)】的数据库操作Service实现
* @createDate 2023-11-15 20:32:02
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService {
    @Resource
    private QuestionService questionService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        String language = questionSubmitAddRequest.getLanguage();
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if(languageEnum==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"编程语言错误！");
        }
        long questionId = questionSubmitAddRequest.getQuestionId();
        // 判断实体是否存在，根据类别获取实体
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 是否已提交题目
        long userId = loginUser.getId();
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setLanguage(questionSubmitAddRequest.getLanguage());
        //设置初始状态
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setJudgeInfo("{}");
        boolean save = this.save(questionSubmit);
        if(!save){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"数据插入失败");
        }
        return questionSubmit.getId();
    }

}




