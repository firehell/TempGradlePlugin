package com.zz.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project;

public class ZzCoder implements Plugin<Project> {
    @java.lang.Override
    void apply(Project project) {
        def extension = project.extensions.create("zzcoder", ZzCoderExtension)
        project.afterEvaluate {
            println("Hello ${extension.name}")
        }
    }
}