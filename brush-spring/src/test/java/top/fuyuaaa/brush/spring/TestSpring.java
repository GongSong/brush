package top.fuyuaaa.brush.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.fuyuaaa.brush.dyopen.DyOpenConfig;
import top.fuyuaaa.brush.dyopen.api.UserManagerApi;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 19:48
 */
public class TestSpring {
    @Test
    public void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BrushConfigurationTest.class);
        UserManagerApi bean = ctx.getBean(UserManagerApi.class);
        System.out.println(bean);

        System.out.println(ctx.getBean(DyOpenConfig.class));
    }
}
