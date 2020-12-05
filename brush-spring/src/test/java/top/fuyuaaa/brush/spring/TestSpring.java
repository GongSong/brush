package top.fuyuaaa.brush.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.fuyuaaa.brush.dyopen.DyOpenConfig;
import top.fuyuaaa.brush.dyopen.api.UserInfoApi;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 19:48
 */
public class TestSpring {
    @Test
    public void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BrushConfigurationTest.class);
        UserInfoApi bean = ctx.getBean(UserInfoApi.class);
        System.out.println(bean);

        System.out.println(ctx.getBean(DyOpenConfig.class));
    }
}
