package com.philbeaudoin.platform.mvp.rebind;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Target(ElementType.METHOD)
public @interface RevealEventType {
  String value();
}
