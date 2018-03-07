package io.jenkins.plugins;

import hudson.model.Action;
import hudson.model.Run;
import jenkins.model.RunAction2;

/**
 * Created by Administrator on 2018/3/7.
 */
public class ReportAction implements RunAction2 {

    private transient Run run;

    @Override
    public void onAttached(Run<?, ?> r) {
        this.run = r;
    }

    @Override
    public void onLoad(Run<?, ?> r) {
        this.run = r;
    }

    public Run getRun() {
        return run;
    }

    private String reportUrl;

    public ReportAction(String reportUrl) {
        this.reportUrl = reportUrl;
    }

    @Override
    public String getIconFileName() {
        return "clipboard.png";
    }

    @Override
    public String getDisplayName() {
        return "查看测试报告";
    }

    @Override
    public String getUrlName() {
        return reportUrl;
    }
}
