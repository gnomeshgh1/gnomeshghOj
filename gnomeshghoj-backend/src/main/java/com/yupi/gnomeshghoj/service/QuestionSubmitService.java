package com.yupi.gnomeshghoj.service;

import com.yupi.gnomeshghoj.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.yupi.gnomeshghoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.gnomeshghoj.model.entity.User;

/**
* @author wl
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2023-11-15 20:32:02
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

}
