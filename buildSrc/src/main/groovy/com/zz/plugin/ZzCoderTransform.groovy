package com.zz.plugin

import com.android.build.api.transform.Format
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformException
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.internal.pipeline.TransformManager
import com.android.utils.FileUtils;

public class ZzCoderTransform extends Transform {

    @java.lang.Override
    java.lang.String getName() {
        return "zzcoder"
    }

    @java.lang.Override
    java.util.Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS
    }

    @java.lang.Override
    java.util.Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    @java.lang.Override
    boolean isIncremental() {
        return false
    }

    @Override
    void transform(TransformInvocation transformInvocation) throws TransformException,
            InterruptedException, IOException {
        super.transform(transformInvocation)
        def inputs = transformInvocation.inputs
        def outputProvider = transformInvocation.outputProvider
        inputs.each {
            it.jarInputs.each {
                File dest = outputProvider.getContentLocation(it.name, it.contentTypes, it.scopes, Format.JAR)
                println "Jar: ${it.file}, Dest: ${dest}"
                FileUtils.copyFile(it.file, dest)
            }
            it.directoryInputs.each {
                File dest = outputProvider.getContentLocation(it.name, it.contentTypes, it.scopes, Format.DIRECTORY)
                println "Dir: ${it.file}, Dest: ${dest}"
                FileUtils.copyDirectory(it.file, dest)
            }
        }
    }
}
