package top.fuyuaaa.brush.spring;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author : fuyuaaa
 * @date : 2020-12-03 19:21
 */
public class BrushImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        Map<String, Object> annotationAttributesMap = importingClassMetadata.getAnnotationAttributes(EnableBrush.class.getName());
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(annotationAttributesMap);
        if (annotationAttributes == null) {
            throw new IllegalArgumentException(String.format(
                    "it is not present on importing class '%s' as expected", importingClassMetadata.getClassName()));
        }
        String[] types = annotationAttributes.getStringArray("type");

        if (types.length == 0) {
            return new String[0];
        }

        List<String> beans = new ArrayList<>();

        for (String brush : types) {
            BrushEnum brushEnum = BrushEnum.find(brush);

            if (BrushEnum.DY_OPEN.equals(brushEnum)) {
                beans.add(DyOpenConfiguration.class.getName());
            }

            if (brushEnum != null) {
                beans.addAll(Arrays.asList(brushEnum.getBeans()));
            }
        }

        return beans.toArray(new String[0]);
    }
}
