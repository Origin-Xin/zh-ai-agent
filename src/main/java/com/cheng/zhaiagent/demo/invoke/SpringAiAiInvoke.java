package com.cheng.zhaiagent.demo.invoke;


import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatModel;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * SpringAI框架调用AI大模型
 */
@Slf4j
@Component
public class SpringAiAiInvoke implements CommandLineRunner {
    @Resource
    private DashScopeChatModel dashscopeChatModel;

    @Override
    public void run(String... args) {
        try {
            AssistantMessage output = dashscopeChatModel.call(new Prompt("你是谁？"))
                    .getResult()
                    .getOutput();
            log.info(output.getText());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
