package org.whystudio.alumfound.annotation;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.lang.annotation.*;


/**
 *  使得CrossOrigin可以被Cross注解的类的子类继承
 *  使用了@Inherited
 * @author mrruan
 */
@CrossOrigin
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cross {

}
