package top.fuyuaaa.brush.spring;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 19:21
 */
public class BrushImportSelector implements ImportSelector  {


    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        Map<String, Object> annotationAttributesMap = importingClassMetadata.getAnnotationAttributes(EnableBrush.class.getName());
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(annotationAttributesMap);
        assert annotationAttributes != null;
        String[] types = annotationAttributes.getStringArray("type");

        if (types.length == 0) {
            return new String[0];
        }

        List<String> beans = new ArrayList<>();

        for (String brush : types) {
            BrushEnum brushEnum = BrushEnum.find(brush);
            Optional.ofNullable(brushEnum).map(BrushEnum::getBean).ifPresent(beans::add);
        }

        return beans.toArray(new String[0]);
    }
}
