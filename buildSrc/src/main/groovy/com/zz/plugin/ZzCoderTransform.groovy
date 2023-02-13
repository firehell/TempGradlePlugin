package com.zz.plugin

import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform;

public class ZzCoderTransform extends Transform {

    @java.lang.Override
    java.lang.String getName() {
        return null
    }

    @java.lang.Override
    java.util.Set<QualifiedContent.ContentType> getInputTypes() {
        return null
    }

    @java.lang.Override
    java.util.Set<? super QualifiedContent.Scope> getScopes() {
        return null
    }

    @java.lang.Override
    boolean isIncremental() {
        return false
    }
}
