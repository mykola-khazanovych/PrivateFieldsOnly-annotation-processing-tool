package com.pfo.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

import java.util.Set;

/**
 * @author Mykola Khazanovych
 *         02.05.2017;
 *         15:58;
 */

@SupportedAnnotationTypes(value = {"com.pfo.anno.PrivateFieldsOnly"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class PrivateFieldsOnlyProcessor extends AbstractProcessor {

    private Messager messager;

    @Override
    public void init(ProcessingEnvironment env) {
        messager = env.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        for (TypeElement ann : annotations) {
            Set<? extends Element> e2s = env.getElementsAnnotatedWith(ann);
            for (Element e2 : e2s) {
                Set<Modifier> modifiers = e2.getModifiers();
                if (!modifiers.contains(Modifier.PRIVATE)) {
                    messager.printMessage(Kind.ERROR,
                            "Incapsulation violation. Make all public fields private or protected", e2);
                }
            }
        }
        return true;
    }
}