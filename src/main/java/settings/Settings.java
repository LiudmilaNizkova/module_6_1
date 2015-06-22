package settings;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.kohsuke.args4j.Option;

public class Settings {

	@Option(name = "--testng", usage = "Set path to testng.xml file", required = true)
    public String pathToTestNG;

    @Option(name = "--browser", usage = "Set browser for execution: firefox, ie, chrome", required = false)
    public String browserName;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
