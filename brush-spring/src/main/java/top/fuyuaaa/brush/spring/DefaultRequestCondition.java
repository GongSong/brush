package top.fuyuaaa.brush.spring;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DefaultRequestCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, @NotNull AnnotatedTypeMetadata metadata) {
        String requestType = context.getEnvironment().getProperty("brush.config.request.type");
        return StringUtils.isBlank(requestType) || StringUtils.equals(requestType,"default");
    }
}
