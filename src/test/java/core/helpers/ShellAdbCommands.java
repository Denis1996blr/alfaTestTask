package core.helpers;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ShellAdbCommands {

    private static final String COMMAND_ADB_UNINSTALL_PACKAGE_DEVICE_UDID = "adb -s %s uninstall %s";
    private static final Duration MAX_TIMEOUT = Duration.ofMillis(10000);
    private static final Logger log = LogManager.getLogger(ShellAdbCommands.class);

    public static void removeApp(Object deviceName, Object appPackage) {
        execute(String.format(COMMAND_ADB_UNINSTALL_PACKAGE_DEVICE_UDID, deviceName, appPackage));
    }

    public static void execute(String command) {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(command);
            log.info("Executed next command " + command);
            boolean isFinished = process.waitFor(MAX_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS);
            if (!isFinished && process.isAlive()) {
                throw new RuntimeException(
                        String.format("The shell command %s, is not finished during timeout %s", command, MAX_TIMEOUT));
            }
        } catch (IOException e) {
            throw new RuntimeException(String.format("Failed to process command %s", command), e);
        } catch (InterruptedException e) {
            process.destroyForcibly();
            throw new RuntimeException(String.format("Shell operation declined - '%s'", command), e);
        }
    }
}
