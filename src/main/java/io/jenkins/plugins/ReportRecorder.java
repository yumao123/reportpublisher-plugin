package io.jenkins.plugins;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;


/**
 * Created by Administrator on 2018/3/7.
 */
public class ReportRecorder extends Recorder {

    private String reportPath;

    private String reportName;

    private String buildId;

    public String getReportPath() {
        return reportPath;
    }

    public String getReportName() {
        return reportName;
    }

    @DataBoundConstructor
    public ReportRecorder(String reportPath, String reportName) {
        this.reportPath = reportPath;
        this.reportName = reportName;
    }

    @Override
    public BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;
    }

    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {
        buildId = build.getId();
        String reportUrl = reportPath.trim().endsWith("/")
                ? reportPath.trim() + reportName.replace("$BUILD_ID", buildId) :
                reportPath.trim() + "/" + reportName.replace("$BUILD_ID", buildId);
        build.addAction(new ReportAction(reportUrl));
        return true;
    }

    @Extension
    public static class DescriptorImpl extends BuildStepDescriptor<Publisher> {
        @Override
        public boolean isApplicable(Class<? extends AbstractProject> jobType) {
            return true;
        }

        @Override
        public String getDisplayName() {
            return "测试报告输出配置";
        }
    }




}
