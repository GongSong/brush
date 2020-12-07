package top.fuyuaaa.brush.spring;

import cn.hutool.core.util.StrUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 
 * @author : fuyuaaa
 * @date : 2020-12-07 10:35
 */
public class DefaultRequestCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, @NotNull AnnotatedTypeMetadata metadata) {
        String requestType = context.getEnvironment().getProperty("brush.config.request.type");
        return StrUtil.isBlank(requestType) || StrUtil.equals(requestType,"default");
    }
}
