package top.fuyuaaa.brush.spring;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 19:15
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({BrushImportSelector.class})
public @interface EnableBrush {
    /**
     * available values : dyopen
     *
     * @see BrushEnum.BrushConstants
     */
    String[] type() default {};
}
