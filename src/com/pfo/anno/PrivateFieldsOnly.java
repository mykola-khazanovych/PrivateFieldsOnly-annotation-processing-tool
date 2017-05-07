package com.pfo.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mykola Khazanovych
 *         02.05.2017;
 *         15:56;
 *         com.mentor.ownannoproc;
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface PrivateFieldsOnly {
}
